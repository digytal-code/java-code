package com.digytal.open.util;

import java.util.ArrayList;
import java.util.List;

public class Hash {
	private String code = "";
	private String next = "";
	private Integer[] groups;
	public void base65(Integer last) {
		generate(last, 65);
	}
	public void base48(String last) {
		base48(Integer.valueOf(last));
	}
	public void base48(Integer last) {
		generate(last, 48);
	}

	private void generate(Integer last, int base) {
		groups = groups(last);
		if (base == 65)
			base65();
		else
			base48();
		for (int x = 0; x < groups.length; x++) {
			code = code + new String(Character.toChars(groups[x]));
			next = next + groups[x];
		}
	}

	private void base65() {
		int rest = 1;
		for (int x = groups.length - 1; x >= 0; x--) {
			if ((groups[x] = groups[x] + rest) == 91) {
				groups[x] = 65;
				rest = 1;
			} else
				rest = 0;
		}
	}

	private void base48() {
		int rest = 1;
		for (int x = groups.length - 1; x >= 0; x--) {
			if ((groups[x] = groups[x] + rest) == 91) {
				groups[x] = 48;
				rest = 1;
			} else {
				groups[x] = groups[x] == 58 ? 65 : groups[x];
				rest = 0;
			}
		}
	}

	private static Integer[] groups(Integer number) {
		List<Integer> parts = new ArrayList<Integer>();
		int length = number.toString().length();
		for (int i = 0; i < length; i += 2) {
			parts.add(Integer.valueOf(number.toString().substring(i,
					Math.min(length, i + 2))));
		}
		return parts.toArray(new Integer[0]);
	}

	public String getNext() {
		return next;
	}

	public Integer getIntNext() {
		return Integer.valueOf(next);
	}

	public String getId() {
		return code;
	}

	/*
	 * public static void main(String[] args) { Hash hash = null; int current =
	 * 48654865; System.out.println("******* BASE 48 *********"); for (int next = 1;
	 * next <= 30; next++) { hash = new Hash(); hash.base48(current);
	 * System.out.println(hash.getId() + "--" + hash.getIntNext()); current =
	 * hash.getIntNext(); } }
	 */
}
