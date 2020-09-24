package com.account.finance.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.account.finance.entity.TradeMaster;

public interface TradeService {
	 void saveFileDetails(MultipartFile file, HttpServletRequest request) throws Exception;
	 TradeMaster getTradeDetails(HttpServletRequest request) throws Exception;
}
