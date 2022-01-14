package com.digytal.open.util;

public enum Extensao {
	JPG,
	JPEG,
	PNG,
	ICO,
	TIF,
	GIF,
	TXT;
	@Override
	public String toString() {
		return "."+name().toLowerCase();
	}
}
