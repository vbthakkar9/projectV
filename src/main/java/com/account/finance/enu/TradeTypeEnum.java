package com.account.finance.enu;

import java.util.HashMap;
import java.util.Map;

public enum TradeTypeEnum {
	SAP(1, "SAP"), TALLY(2, "TALLY"), PDF(3, "PDF"), OTHER(4, "OTHER");

	private static final Map<String, Integer> searchByName= new HashMap<>();

	private static final Map<Integer, String> searchByType = new HashMap<>();

	private int searchType;
	private String name;

	static {
		for(TradeTypeEnum typeEnum:TradeTypeEnum.values())
        {
			searchByName.put(typeEnum.name,typeEnum.searchType);
        }
	}

	static {
		for(TradeTypeEnum typeEnum:TradeTypeEnum.values())
        {
			searchByType.put(typeEnum.searchType, typeEnum.name);
        }
	}
	
	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private TradeTypeEnum(int searchType,String name){
		this.searchType=searchType;
		this.name=name;
	}
}
