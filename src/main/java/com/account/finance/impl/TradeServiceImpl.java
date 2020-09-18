package com.account.finance.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.account.finance.entity.Trade;
import com.account.finance.entity.TradeMaster;
import com.account.finance.repository.TradeMasterRepository;
import com.account.finance.repository.TradeRepository;
import com.account.finance.service.TradeService;

@Service
public class TradeServiceImpl implements TradeService{
	
	private static String UPLOADED_FOLDER = "C://temp//";
	
	@Autowired
	TradeRepository tradeRepository;

	@Autowired
	TradeMasterRepository tradeMasterRepository;
	
	@Override
	@Transactional
	public void saveFileDetails(MultipartFile multiPartFile, HttpServletRequest request) throws Exception {
		TradeMaster tradeMaster = new TradeMaster();
		List<Trade> tradeList = new ArrayList<>();
		try {
			savePhysicalFile(multiPartFile);

			int rowStartFrom = Integer.parseInt(request.getParameter("rowStartFrom"));
			//int lastRow = Integer.parseInt(request.getParameter("lastRow"));
			int glCodeColumn = Integer.parseInt(request.getParameter("glCodeColumn"));
			int glCodeDescColumn = Integer.parseInt(request.getParameter("glCodeDescColumn"));
			int openingBalanceColumn = Integer.parseInt(request.getParameter("openingBalanceColumn"));
			int closingBalanceColumn = Integer.parseInt(request.getParameter("closingBalanceColumn"));
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			Workbook workbook = new XSSFWorkbook(multiPartFile.getInputStream());

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			BigDecimal openingBalance = new BigDecimal(0).setScale(2, RoundingMode.DOWN);
			BigDecimal closingBalance = new BigDecimal(0).setScale(2, RoundingMode.DOWN);
			int rowNumber = 0;
			while (rows.hasNext() ) {
				Row currentRow = rows.next();
				if (rowNumber < rowStartFrom) {
					rowNumber++;
					continue;
				}
				if(currentRow.getRowNum()<sheet.getLastRowNum()) {
					Iterator<Cell> cellsInRow = currentRow.iterator();
					Trade trade = new Trade();
					int cellIdx = 0;
					while (cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();

						if(cellIdx == glCodeColumn) {
							trade.setGlCode(currentCell.getStringCellValue());
						}
						if(cellIdx == glCodeDescColumn) {
							trade.setGlDescription(currentCell.getStringCellValue());
						}
						if(cellIdx == openingBalanceColumn) {
							openingBalance =openingBalance.add(new BigDecimal(Double.toString(currentCell.getNumericCellValue())).setScale(2, RoundingMode.DOWN));
							trade.setOpeningBalance(new BigDecimal(Double.toString(currentCell.getNumericCellValue())).setScale(2, RoundingMode.DOWN));
						}
						if(cellIdx == closingBalanceColumn) {
							closingBalance = closingBalance.add(new BigDecimal(Double.toString(currentCell.getNumericCellValue())).setScale(2, RoundingMode.DOWN));
							trade.setClosingBalance(new BigDecimal(Double.toString(currentCell.getNumericCellValue())).setScale(2, RoundingMode.DOWN));
						}
						cellIdx++;
					}
					tradeMaster.getTrades().add(trade);
				}else {
					System.out.println("opening balance"+openingBalance);
					System.out.println("closing balance"+ closingBalance);
					if (openingBalance.compareTo(BigDecimal.ZERO) > 0 || openingBalance.compareTo(BigDecimal.ZERO) < 0 ||closingBalance.compareTo(BigDecimal.ZERO) > 0 || closingBalance.compareTo(BigDecimal.ZERO) < 0) {
						throw new Exception("opennig or closing balance is not ZERO");
					}
				}
			}
			tradeMaster.setLatest(true);
			tradeMaster.setMonth(month);
			tradeMaster.setYear(year);
			tradeMaster.setTradeType(1);
			tradeMaster.setUploadedDateTime(new Date());
			
			
			List<TradeMaster> tradeMasterList = tradeMasterRepository.findByYearAndMonth(year, month);
			if(tradeMasterList.size()>0) {
				tradeMasterList.forEach(tm->tm.setLatest(false));
				tradeMasterRepository.saveAll((tradeMasterList));
			}
			tradeMasterRepository.save(tradeMaster);
		}catch(Exception e) {
			throw e;
		}
	}


	private void savePhysicalFile(MultipartFile multiPartFile) throws IOException {
		try {
			byte[] bytes = multiPartFile.getBytes();
			String filePath=UPLOADED_FOLDER + FilenameUtils.getBaseName(multiPartFile.getOriginalFilename())+new Date().getTime()+"."+FilenameUtils.getExtension(multiPartFile.getOriginalFilename());;
			Path path = Paths.get(filePath);
			Files.write(path, bytes);	
		}catch(Exception e) {
			throw e;
		}
		
	}
	
}
