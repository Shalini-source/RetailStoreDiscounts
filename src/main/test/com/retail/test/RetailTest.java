package com.retail.test;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.retail.context.RetailContext;
import com.retail.discount.impl.RetailAffiliate;
import com.retail.discount.impl.RetailEmployee;
import com.retail.discount.impl.RetailGoldCustomer;
import com.retail.discount.impl.RetailGroceryPurchase;
import com.retail.discount.impl.RetailMaxPurchaseCustomer;


/**
 * @author Shalini
 * 
 * Test class to verify the test scenarioss
 *
 */
public class RetailTest {
	
	@Test
	public void testRetailEmployee() {
		RetailContext retailContext = new RetailContext(new RetailEmployee());
		assertTrue(retailContext.applyDiscount(BigDecimal.valueOf(1000)).compareTo(BigDecimal.valueOf(700)) == 0);
	}
	
	@Test
	public void testRetailAffiliate() {
		RetailContext retailContext = new RetailContext(new RetailAffiliate());
		assertTrue(retailContext.applyDiscount(BigDecimal.valueOf(1000)).compareTo(BigDecimal.valueOf(900)) == 0);
	}
	
	@Test
	public void testRetailGoldCustomer() {
		RetailContext retailContext = new RetailContext(new RetailGoldCustomer());
		assertTrue(retailContext.applyDiscount(BigDecimal.valueOf(1000)).compareTo(BigDecimal.valueOf(950)) == 0);
	}
	
	@Test
	public void testRetailMaxPurchaseCustomer() {
		RetailContext retailContext = new RetailContext(new RetailMaxPurchaseCustomer());
		assertTrue(retailContext.applyDiscount(BigDecimal.valueOf(990)).compareTo(BigDecimal.valueOf(945)) == 0);
	}
	
	@Test
	public void testRetailGroceryPurchase() {
		RetailContext retailContext = new RetailContext(new RetailGroceryPurchase());
		assertTrue(retailContext.applyDiscount(BigDecimal.valueOf(1000)).compareTo(BigDecimal.valueOf(1000)) == 0);
	}

}
