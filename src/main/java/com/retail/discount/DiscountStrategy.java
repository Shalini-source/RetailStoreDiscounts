package com.retail.discount;

import java.math.BigDecimal;

public interface DiscountStrategy {
	
	public BigDecimal getNetPayableAmount(BigDecimal billAmount);
}
