package ru.paloz.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtility {
	private static final int DEF_LENGTH = 10;
	private static final Range DEF_RANGE = Range.createRange();
	private static final Random RANDOM = new Random();
	
	private RandomUtility(){}
	
	private static int getForRange(Range range) {
		int rangeLen = range.getRange();
		if(rangeLen == 0)
			return range.getStart();		
		return range.getStart() + RANDOM.nextInt(rangeLen + 1);
	}
	
	public static int generateRandomNumber() {
		return getForRange(DEF_RANGE);
	}
	
	public static int generateRandomNumber(Range range) {
		return getForRange(range);
	}
	
	public static int generateRandomNumber(int from, int to) {
		Range range = Range.createRange(from, to);
		return getForRange(range);
	}
	
	public static int[] generateRandomArray() {
		return generateRandomArray(DEF_LENGTH, DEF_RANGE);
	}
	
	public static int[] generateRandomArray(int length) {
		return generateRandomArray(length, DEF_RANGE);
	}
	
	public static int[] generateRandomArray(int length, int from, int to) {
		Range range = Range.createRange(from, to);
		return generateRandomArray(length, range);
	}
	
	public static int[] generateRandomArray(int length, Range range) {
		if (length < 0) throw new IllegalArgumentException("Count of elements can not be negative.");
		if (range == null) range = DEF_RANGE;
		
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = getForRange(range);
		}
		return result;
	}
	
	public static List<Integer> generateRandomList() {
		return generateRandomList(DEF_LENGTH, DEF_RANGE);
	}
	
	public static List<Integer> generateRandomList(int length) {
		return generateRandomList(length, DEF_RANGE);
	}
	
	public static List<Integer> generateRandomList(int length, int from, int to) {
		Range range = Range.createRange(from, to);
		return generateRandomList(length, range);
	}
	
	public static List<Integer> generateRandomList(int length, Range range) {
		List<Integer> result = new ArrayList<Integer>();
		for (Integer num : generateRandomArray(length, range)) {
			result.add(num);
		}
		return result;
	}
}
