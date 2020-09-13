package com.account.finance.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.account.finance.service.TradeService;

@RequestMapping("/tradeFile")
@RestController
public class TradeResources {

	@Autowired
	TradeService tradeService;
	
	@PostMapping("/upload")	
	public void singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {		
		tradeService.saveFileDetails(file, request);
	}
	
}
