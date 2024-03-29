package com.cs471.prodcons;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Represents a sale record
 * @author Abel Weldaregay
 *
 */
public class SalesRecord {
	/**
	 *  Sales Date (DD/MM/YY)
	 */
	private String salesDate;
	/**
	 * The store id the item is associated with
	 * 1 to p range (where p is the number of
	 * producers)
	 */
	private int storeId;
	/**
	 * range from 1-6 for any store
	 */
	private int registerNumber;
	/**
	 * The sale amount in each
	 * item can range between 0.50 and 999.99
	 */
	private float saleAmount;
	/**
	 * Holds the sales month,
	 * makes it easier to calculate stats
	 */
	private int saleMonth;

	/**
	 * Creates a sales record with a given producer id
	 * that will be assigned to the store id
	 * @param proID
	 */
	public SalesRecord(int producerId) {
		
		this.registerNumber = UtilityClass.getRandomNumberInRange(2, 5);
		this.saleAmount = UtilityClass.getRandomFloatInRange( 0.50, 999.99);
		this.storeId=producerId;
		generateAndSetRandomDates();
	}
	/**
	 * 
	 * @param date
	 * @param store
	 * @param register
	 * @param sale
	 */
	SalesRecord(String salesDate, int storeId, int registerNumber, float sale) {
		@SuppressWarnings("deprecation")
		Date aDate = new Date(salesDate);
		SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yy");
		String newDate = fm.format(aDate);
		this.salesDate = newDate;
		this.storeId = storeId;
		this.registerNumber = registerNumber;
		this.saleAmount = sale;
	}

	/**
	 * Implements toString() for printing SalesRecord
	 */
	public String toString() {
		return String.format("%1s %5s %5s %5s %6s %6s %4s %10s %8s",
	               "|" ,salesDate, "|", Integer.toString(storeId), "|" , Integer.toString(registerNumber), "|", Float.toString(saleAmount), "|\n");
	}

	/**
	 * @return sales date
	 */
	String getSalesDate() {
		return this.salesDate;
	}
	/**
	 * 
	 * @return store id
	 */
	int getStoreId() {
		return this.storeId;
	}
	/**
	 * 
	 * @return register number
	 */
	int getRegisterNumber() {
		return this.registerNumber;
	}
	/**
	 * 
	 * @return sales amount
	 */
	float getSaleAmount() {
		return this.saleAmount;
	}
	/**
	 * Set the storeId
	 * @param store
	 */
	void setStoreId(int store) {
		this.storeId = store;
	}
	/**
	 * set the sale amount
	 * @param sale
	 */
	void setSaleAmount(float sale) {
		this.saleAmount = sale;
	}
	
	public int getSaleMonth() {
		return this.saleMonth;
	}
	
	/**
	 * generate and set the random day and month of the date
	 * The year will always be 2016 as specified in specification
	 */
	@SuppressWarnings("deprecation")
	void generateAndSetRandomDates() {
		Date date = new Date();
		this.saleMonth = UtilityClass.getRandomNumberInRange(1, 12);
		date.setMonth(this.saleMonth);
		date.setYear(2016);
		date.setDate(UtilityClass.getRandomNumberInRange(1, 29));
		SimpleDateFormat fm = new SimpleDateFormat("MM/dd/yy");
		this.salesDate = fm.format(date);
	}


}
