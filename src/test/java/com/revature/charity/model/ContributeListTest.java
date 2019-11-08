package com.revature.charity.model;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContributeListTest {

	@Test
	public void test() {
		ContributeList list =new ContributeList();
		list.setUserid(1);
		list.setRequestid(1);
        
        list.setAmountdonated(35);
        list.setName("deepa");
        assertEquals(1,list.getUserid());
        assertEquals(1,list.getRequestid());
        assertEquals("deepa",list.getName());
	}

}
