package com.account.finance.dto;

/**
 * 
 * @author Admin
 *
 */
public class TradeDto {

	private Integer tradeId;
	
	private String symbol;
	
	private Integer price;
	
	private Integer quantity;
	
	private String date;
	
	private String clientCode;
	
	private String buySell;
	
	private String scriptCode;
	
	private String type;
	
	private String clientName;

	public TradeDto(Integer tradeId, String symbol,Integer price, Integer quantity,String date,String clientCode,String buySell,String scriptCode, String type){
		this.tradeId=tradeId;
		this.symbol=symbol;
		this.price=price;
		this.quantity=quantity;
		this.date=date;
		this.clientCode=clientCode;
		this.buySell=buySell;
		this.scriptCode=scriptCode;
		this.type=type;
	}
	
	public TradeDto(){
		
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getScriptCode() {
		return scriptCode;
	}

	public void setScriptCode(String scriptCode) {
		this.scriptCode = scriptCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	
}

