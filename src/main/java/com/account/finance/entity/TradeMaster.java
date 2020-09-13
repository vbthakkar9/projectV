package com.account.finance.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="trade_master")
public class TradeMaster implements Serializable {
	
	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="trade_master_id", referencedColumnName = "id")
    private List<Trade> trades = new ArrayList<>();
	
	@Column
	private boolean isLatest;
	
	@Column
	private int year;
	
	@Column
	private int month;
	
	@Column
	private int tradeType;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
    private Date uploadedDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}

	public boolean isLatest() {
		return isLatest;
	}

	public void setLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Date getUploadedDateTime() {
		return uploadedDateTime;
	}

	public void setUploadedDateTime(Date uploadedDateTime) {
		this.uploadedDateTime = uploadedDateTime;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}
	
	
}
