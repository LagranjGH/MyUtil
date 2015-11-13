package ru.paloz.common;

import java.util.ArrayList;
import java.util.List;

public class CollectionConverter {
	
	private CollectionConverter() {}
	
	private static <T> void arrToList(List<T> list, T[] array) {
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
	}
	
	private static <T> void listToArr(List<T> list, T[] array) {
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
	}
	
	//======================INTEGER=========================
	public static Integer[] integerPrimToRef(int ...args) {
		if (args != null) {
			Integer[] result = new Integer[args.length];
			for (int i = 0; i < args.length; i++) {
				result[i] = new Integer(args[i]);
			}
			return result;
		}
		return null;
	}
	
	public static int[] integerRefToPrim(Integer ...args) {
		if (args != null) {
			int[] result = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				result[i] = args[i].intValue();
			}
			return result;
		}
		return null;
	}
	
	public static List<Integer> arrayToIntList(Integer[] args) {
		List<Integer> result = new ArrayList<>();
		if (args != null) {
			arrToList(result, args);
		}
		return result;	
	}
	
	public static List<Integer> arrayToIntList(int ...args) {
		return arrayToIntList(integerPrimToRef(args));
	}
	
	public static List<Integer> arrayToIntList() {
		return new ArrayList<>();
	}
	
	public static Integer[] listToRefIntArray(List<Integer> list) {
		if (list != null) {
			Integer[] result = new Integer[list.size()];
			listToArr(list, result);
			return result;
		}
		return null;
	}
	
	public static int[] listToPrimIntArray(List<Integer> list) {
		if (list != null) {
			int[] result = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				result[i] = list.get(i);
			}
			return result;
		}
		return null;
	}
	
	//=======================LONG============================
	public static Long[] longPrimToRef(long ...args) {
		if (args != null) {
			Long[] result = new Long[args.length];
			for (int i = 0; i < args.length; i++) {
				result[i] = new Long(args[i]);
			}
			return result;
		}
		return null;
	}
	
	public static long[] longRefToPrim(Long ...args) {
		if (args != null) {
			long[] result = new long[args.length];
			for (int i = 0; i < args.length; i++) {
				result[i] = args[i].intValue();
			}
			return result;
		}
		return null;
	}
	
	public static List<Long> arrayToLongList(Long[] args) {
		List<Long> result = new ArrayList<>();
		if (args != null) {
			arrToList(result, args);
		}
		return result;	
	}
	
	public static List<Long> arrayToLongList(long ...args) {
		return arrayToLongList(longPrimToRef(args));
	}
	
	public static List<Integer> arrayTolongList() {
		return new ArrayList<>();
	}
	
	public static Long[] listToRefLongArray(List<Long> list) {
		if (list != null) {
			Long[] result = new Long[list.size()];
			listToArr(list, result);
			return result;
		}
		return null;
	}
	
	public static long[] listToPrimLongArray(List<Long> list) {
		if (list != null) {
			long[] result = new long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				result[i] = list.get(i);
			}
			return result;
		}
		return null;
	}
	
}
