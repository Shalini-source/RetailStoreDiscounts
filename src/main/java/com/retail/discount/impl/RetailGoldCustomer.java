package com.retail.discount.impl;

import java.math.BigDecimal;

import com.retail.discount.DiscountStrategy;

/**
 * @author Shalini
 * 
 * This class is implemented for the customer over 2years to get 5% discount from the bill amount
 *
 */
public class RetailGoldCustomer implements DiscountStrategy {

	@Override
	public BigDecimal getNetPayableAmount(BigDecimal billAmount) {

		return billAmount.subtract(billAmount.multiply(BigDecimal.valueOf(0.05)));
	}

}
