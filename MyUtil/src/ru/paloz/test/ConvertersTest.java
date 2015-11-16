package ru.paloz.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ru.paloz.common.CollectionConverter;

public class ConvertersTest {

	@Test
	public void testCommon() {
		{
			List<Integer> list = new ArrayList<Integer>(0);
			Assert.assertNotNull(list);
			Assert.assertEquals(0, list.size());
			list.add(22);
			Assert.assertEquals(1, list.size());
		}
		{
			List<Integer> list = Arrays.asList();		
			Assert.assertNotNull(list);
			
			list = Arrays.asList(3,17,42);
			Assert.assertEquals(3, list.size());	
		}
		{
			int ii = 10;
			long ll = 10L;
			Assert.assertEquals(ii, ll);
			Integer i = new Integer(45);
			Long l = new Long(45);
			Assert.assertNotEquals(i, l);
			Assert.assertEquals(i.intValue(), l.intValue());
			Assert.assertEquals(i.intValue(), l.longValue());
			Assert.assertEquals(i.longValue(), l.intValue());
			Assert.assertEquals(i.longValue(), l.longValue());		
		}
	}
	
	@Test
	public void testCollectionConverterInt() {	
		{
			int[] vals = new int[]{1, 9, 228};
			
			int[] 	  intPrim 	= new int[]    {vals[0], vals[1], vals[2]};
			Integer[] intRef 	= new Integer[]{vals[0], vals[1], vals[2]};
			
			List<Integer> listFromPrim = CollectionConverter.arrayToIntList(intPrim);
			List<Integer> listFromRef = CollectionConverter.arrayToIntList(intRef);
			List<Integer> listVarArgs = CollectionConverter.arrayToIntList(vals[0], vals[1], vals[2]);
			
			intRef[2] = new Integer(42);
			
			{
				Assert.assertTrue(listFromPrim.contains(vals[0]));
				Assert.assertTrue(listFromPrim.contains(vals[1]));
				Assert.assertTrue(listFromPrim.contains(vals[2]));
			}
			{
				Assert.assertTrue(listFromRef.contains(vals[0]));
				Assert.assertTrue(listFromRef.contains(vals[1]));
				Assert.assertTrue(listFromRef.contains(vals[2]));
			}
			{
				Assert.assertTrue(listVarArgs.contains(vals[0]));
				Assert.assertTrue(listVarArgs.contains(vals[1]));
				Assert.assertTrue(listVarArgs.contains(vals[2]));
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
		
		{
			Integer[] ref = CollectionConverter.integerPrimToRef(null);
			Assert.assertNull(ref);
			ref = CollectionConverter.integerPrimToRef();
			Assert.assertNotNull(ref);
			Assert.assertEquals(0, ref.length);
			
			//Commented because warning result
//			int[] prim = CollectionConverter.integerRefToPrim(null);
//			Assert.assertNull(prim);
//			prim = CollectionConverter.integerRefToPrim();
//			Assert.assertNotNull(prim);
//			Assert.assertEquals(0, prim.length);
		}
	}
	
	@Test
	public void testCollectionConverterString() {
		String str1 = "1", str2 = "23", str3 = "456";
		String[] strs = new String[]{str1, str2, str3};
		
		Assert.assertEquals(str1, strs[0]);
		Assert.assertEquals(str2, strs[1]);
		Assert.assertEquals(str3, strs[2]);
		
		str2 = new String("999");
		String str4 = new String("23");
		Assert.assertEquals(str4, strs[1]);
		
		List<String> list = CollectionConverter.arrayToStringList(strs);
		Assert.assertTrue(list.contains(str1));
		Assert.assertTrue(list.contains(str3));
		Assert.assertTrue(list.contains(str4));
		
		String[] nStrs = CollectionConverter.listToRefStringArray(list);
		Assert.assertEquals(str1, nStrs[0]);
		Assert.assertEquals(str4, nStrs[1]);
		Assert.assertEquals(str3, nStrs[2]);
	}
}
