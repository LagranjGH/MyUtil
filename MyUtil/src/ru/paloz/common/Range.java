package ru.paloz.common;

public class Range {
	private static final int DEF_START = 0;
	private static final int DEF_END = 10;
	
	private int start;
	private int end;
	
	private Range() {
		this(DEF_START, DEF_END);
	}	
	
	private Range(int start, int end) {
		if (start > end) {
			this.start = end;
			this.end = start;
		} else {
			this.start = start;
			this.end = end;
		}
	}
	
	public static Range createRange() {
		return new Range();
	}
	
	public static Range createRange(int start, int end) {
		return new Range(start, end);
	}
	
	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}	
	
	public int getRange() {
		return (end - start);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(start);
		sb.append(",");
		sb.append(end);
		sb.append("]");
		return sb.toString();
	}
}
