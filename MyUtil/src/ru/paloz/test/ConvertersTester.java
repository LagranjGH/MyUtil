package ru.paloz.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.paloz.common.CollectionConverter;

public class ConvertersTester {

	@Test
	public void testCollectionConverterInt() {
		{
			List<Integer> list = Arrays.asList();		
			Assert.assertNotNull(list);
			
			list = Arrays.asList(3,17,42);
			Assert.assertEquals(3, list.size());	
		}
		
		{
			int[] vals = new int[]{1, 9, 228};
			
			int[] 	  intPrim 	= new int[]    {vals[0], vals[1], vals[2]};
			Integer[] intRef 	= new Integer[]{vals[0], vals[1], vals[2]};
			
			List<Integer> listFromPrim = CollectionConverter.arrayToIntList(intPrim);
			List<Integer> listFromRef = CollectionConverter.arrayToIntList(intRef);
			List<Integer> listVarArgs = CollectionConverter.arrayToIntList(vals[0], vals[1], vals[2]);
			
			for (int val : vals) {
				Assert.assertTrue(listFromPrim.contains(val));
				Assert.assertTrue(listFromRef.contains(val));
				Assert.assertTrue(listVarArgs.contains(val));
			}
			
		}
		
		{
			Integer[] vals = new Integer[3];
			vals[0] = new Integer(12);
			vals[1] = new Integer(24);
			vals[2] = new Integer(36);
			
			Assert.assertEquals(new Integer(24), vals[1]);
			List<Integer> list = CollectionConverter.arrayToIntList(vals);
			Assert.assertEquals(new Integer(24), list.get(1));
			
			vals[1] = new Integer(42);
			Assert.assertEquals(new Integer(42), vals[1]);
			Assert.assertEquals(new Integer(24), list.get(1));	
			
			Integer[] fromListRef = CollectionConverter.listToRefIntArray(list);
			int[] fromListPrim = CollectionConverter.listToPrimIntArray(list);
			vals[1] = new Integer(24);
			
			for (int i = 0; i < 3; i++) {
				Assert.assertEquals(vals[i], fromListRef[i]);
				Assert.assertEquals(vals[i].intValue(), fromListPrim[i]);
			}
		}
	}
}
