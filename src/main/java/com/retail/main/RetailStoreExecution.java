package com.retail.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.retail.context.RetailContext;
import com.retail.discount.impl.RetailAffiliate;
import com.retail.discount.impl.RetailEmployee;
import com.retail.discount.impl.RetailGoldCustomer;
import com.retail.discount.impl.RetailGroceryPurchase;
import com.retail.discount.impl.RetailMaxPurchaseCustomer;

public class RetailStoreExecution {

	public static void main(String[] args) {
		
		System.out.println("Please select the product type. Press 1 for Groceries ::  2 for others");
		
		Scanner productTypeScanner = new Scanner(System.in);
		String productType = productTypeScanner.nextLine();
		
		System.out.println("Please enter the bill amount");
		
		Scanner billAmountScanner = new Scanner(System.in);
		String billAmountString = billAmountScanner.nextLine();
		
		BigDecimal billAmount = BigDecimal.valueOf(new Double(billAmountString));
		
		BigDecimal netPayableAmount = null; 
		
		//If the product type is groceries
		if("1".equalsIgnoreCase(productType)) {
			//Bill amount greater than 100,,get $5 discount for every $100
			if(billAmount.compareTo(BigDecimal.valueOf(100)) > 0) {
				RetailContext retailContext = new RetailContext(new RetailMaxPurchaseCustomer());
				netPayableAmount = retailContext.applyDiscount(billAmount);
			} else {
			RetailContext retailContext = new RetailContext(new RetailGroceryPurchase());
			netPayableAmount = retailContext.applyDiscount(billAmount);
			}
		} else {
			System.out.println("Please select the customer Type. Press 1 for Employee :: 2 for Affiliate :: 3 for customer for over 2years :: 4 for Others");
			Scanner customerTypeScanner = new Scanner(System.in);
			String customerType = customerTypeScanner.nextLine();
			
			//1.Employee, gets 30% discount
			if("1".equalsIgnoreCase(customerType)) {
				RetailContext retailContext = new RetailContext(new RetailEmployee());
				netPayableAmount = retailContext.applyDiscount(billAmount);
			} 
			//2.Affilate, gets 10% discount
			else if("2".equalsIgnoreCase(customerType)) {
				RetailContext retailContext = new RetailContext(new RetailAffiliate());
				netPayableAmount = retailContext.applyDiscount(billAmount);
			} 
			//3.Customer over 2years, gets 5% discount
			else if("3".equalsIgnoreCase(customerType)) {
				RetailContext retailContext = new RetailContext(new RetailGoldCustomer());
				netPayableAmount = retailContext.applyDiscount(billAmount);
			} else {
				//Bill amount greater than 100,get $5 discount for every $100
				if(billAmount.compareTo(BigDecimal.valueOf(100)) > 0) {
					RetailContext retailContext = new RetailContext(new RetailMaxPurchaseCustomer());
					netPayableAmount = retailContext.applyDiscount(billAmount);
				} else {
					netPayableAmount  = billAmount;
				}
			}
		}
		
		System.out.println("Net Payable amount ::  "+netPayableAmount);

	}

}
