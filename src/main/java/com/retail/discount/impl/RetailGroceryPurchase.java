package com.retail.discount.impl;

import java.math.BigDecimal;

import com.retail.discount.DiscountStrategy;

/**
 * @author Shalini
 * 
 * This class is implemented for groceries purchase and the discount is not applicable for them
 *
 */
public class RetailGroceryPurchase implements DiscountStrategy {

	@Override
	public BigDecimal getNetPayableAmount(BigDecimal billAmount) {

		return billAmount;
	}

}
