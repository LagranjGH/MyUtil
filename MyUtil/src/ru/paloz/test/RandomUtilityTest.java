package ru.paloz.test;

import org.junit.*;

import ru.paloz.common.RandomUtility;

public class RandomUtilityTest {

	@Test
	public void testGenerateRandomArray() {
		int[] array = RandomUtility.generateRandomArray(6, -5, 5);	
		Assert.assertEquals(6, array.length);
		
		int sum = 0;
		for (int i = 0; i < array.length; i++) 
			sum += array[i];		
		Assert.assertTrue(sum <= 30);
		Assert.assertTrue(sum >= -30);
		
		int rndInd = RandomUtility.generateRandomNumber(0, 5);
		Assert.assertTrue(rndInd >= 0);
		Assert.assertTrue(rndInd <= 5);
		
		int rndElem = array[rndInd];
		Assert.assertTrue(rndElem >= -5);
		Assert.assertTrue(rndElem <= 5);
	}
}
