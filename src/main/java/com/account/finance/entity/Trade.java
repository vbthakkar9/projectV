package com.account.finance.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Admin
 *
 */
@Entity
@Table(name="trade")
public class Trade implements Serializable {
	private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String glCode;

	@Column
	private String glDescription;

	@Column
	private BigDecimal openingBalance;

	@Column
	private BigDecimal closingBalance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGlCode() {
		return glCode;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getGlDescription() {
		return glDescription;
	}

	public void setGlDescription(String glDescription) {
		this.glDescription = glDescription;
	}

	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	public BigDecimal getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(BigDecimal closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Trade() {

	}

	
}
