package com.account.finance.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface TradeService {
	 void saveFileDetails(MultipartFile file, HttpServletRequest request) throws Exception;
}
