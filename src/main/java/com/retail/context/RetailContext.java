package com.retail.context;

import java.math.BigDecimal;

import com.retail.discount.DiscountStrategy;

/**
 * @author Shalini
 *
 */
public class RetailContext {

	private DiscountStrategy discountStrategy;
    
    public RetailContext(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    public BigDecimal applyDiscount(BigDecimal billAmount) {
        return discountStrategy.getNetPayableAmount(billAmount);
    }
}
