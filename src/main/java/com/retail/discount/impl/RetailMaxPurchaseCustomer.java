package com.retail.discount.impl;

import java.math.BigDecimal;
import com.retail.discount.DiscountStrategy;

/**
 * @author Shalini
 * 
 * This class is implemented for the customer who is purchasing more than $100 to get $5 discount for every $100 from the bill amount
 *
 */
public class RetailMaxPurchaseCustomer implements DiscountStrategy {

	@Override
	public BigDecimal getNetPayableAmount(BigDecimal billAmount) {
		int discount = (billAmount.divide(BigDecimal.valueOf(100))).intValue();
		return billAmount.subtract(BigDecimal.valueOf(discount*5));
	}

}
