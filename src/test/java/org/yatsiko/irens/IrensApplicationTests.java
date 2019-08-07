package org.yatsiko.irens;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yatsiko.irens.util.PalindromesHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IrensApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void isPalindromeTest() {
		Assert.assertTrue(PalindromesHelper.isPalindrome("1"));
		Assert.assertTrue(PalindromesHelper.isPalindrome("22"));
		Assert.assertTrue(PalindromesHelper.isPalindrome("333"));
		Assert.assertFalse(PalindromesHelper.isPalindrome("223"));
		Assert.assertFalse(PalindromesHelper.isPalindrome("123"));
		Assert.assertFalse(PalindromesHelper.isPalindrome("23"));
	}

	@Test
	public void incrementStringTest() {
		Assert.assertEquals("200", PalindromesHelper.incrementString("199", 0));
		Assert.assertEquals("100", PalindromesHelper.incrementString("99", 0));
		Assert.assertEquals("2", PalindromesHelper.incrementString("1", 0));
		Assert.assertEquals("1", PalindromesHelper.incrementString("0", 0));
	}

	@Test
	public void getNextPalindromeTest() {
		Assert.assertEquals("11", PalindromesHelper.getPalindrome("10"));
		Assert.assertEquals("22", PalindromesHelper.getPalindrome("12"));
		Assert.assertEquals("22", PalindromesHelper.getPalindrome("20"));
		Assert.assertEquals("1221", PalindromesHelper.getPalindrome("1221"));
	}

	@Test
	public void getEvenLengthPlndrmsTest() {
		PalindromesHelper.getEvenLengthPlndrms("1234", 10000).forEach(System.out::println);
	}
	@Test
	public void getOddLengthPlndrmsTest() {
		PalindromesHelper.getOddLengthPlndrms("123", 10000).forEach(System.out::println);
	}

}
