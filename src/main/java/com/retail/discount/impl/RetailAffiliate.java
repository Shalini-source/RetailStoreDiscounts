package com.retail.discount.impl;

import java.math.BigDecimal;

import com.retail.discount.DiscountStrategy;

/**
 * @author Shalini
 * 
 * This class is implemented for an affiliate of the store to get 10% discount from the bill amount
 *
 */
public class RetailAffiliate implements DiscountStrategy {

	@Override
	public BigDecimal getNetPayableAmount(BigDecimal billAmount) {

		return billAmount.subtract(billAmount.multiply(BigDecimal.valueOf(0.10)));
	}

}
