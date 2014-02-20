package com.blueskyconnie.visitheritage.model;

import java.io.Serializable;

public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	private int nameResId;
	private int numMonument;
	private int resId;
	
	public Region(int nameResId, int numMonument, int resId) {
		this.nameResId = nameResId;
		this.numMonument = numMonument;
		this.resId = resId;
	}

	public int getNameResId() {
		return nameResId;
	}

	public int getNumMonument() {
		return numMonument;
	}

	public int getImageResId() {
		return resId;
	}
}
