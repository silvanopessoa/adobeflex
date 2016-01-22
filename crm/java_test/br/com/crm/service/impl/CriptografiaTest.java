package br.com.crm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("app-test.xml")
@TransactionConfiguration(defaultRollback=true)
public class CriptografiaTest {
	
	
	@Test
	public void testSenhaMD5(){
		String senha ="123456";
	    PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPass = encoder.encodePassword(senha, null);
	    Assert.isTrue(hashedPass.equals("e10adc3949ba59abbe56e057f20f883e"));
	}
}
