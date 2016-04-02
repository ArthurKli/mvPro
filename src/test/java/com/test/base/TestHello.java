package com.test.base;


import org.junit.Assert;
import org.junit.Test;

public class TestHello {
	
	@Test
	public void testOne(){
		
		String str = "abc";
		
		Assert.assertTrue("abc".equals(str));
	}

}
