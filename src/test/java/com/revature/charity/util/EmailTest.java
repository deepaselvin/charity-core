package com.revature.charity.util;

import org.junit.Test;

import com.revature.charity.util.MailUtil;

public class EmailTest {
	
	@Test
	public void mailTest() throws Exception
	{
		// assertNull(mailTest.doSomething());  // JUnit assertion
		  //assertThat(myClass.doSomething()).isNull();  // Fest assertion 
		String host = "smtp.gmail.com";
	         String username = "pradeepaselvin97@gmail.com";
	         String password = "dptuwenukcjsiltu";
	         String fromAddress = "pradeepaselvin97@gmail.com";
	         String toAddress = "ennilla007@gmail.com";
	         String subject = "Password Verification";
	         String text = "This is a sample message. Thank you.";
	         MailUtil.sendMailUsingTLS(host, username, password,
	         fromAddress, toAddress, subject, text);
	         MailUtil.sendMailUsingSSL(host, username, password, fromAddress, toAddress,
	        subject, text);
	}

}
