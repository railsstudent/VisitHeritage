package com.blueskyconnie.visitheritage.model;

import java.io.Serializable;
import java.util.List;

public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	private int nameResId;
//	private int numMonument;
	private int imgResId;
	private List<Place> source;
	private String sharePrefKey;
	
	public Region(int nameResId, int imgResId, List<Place> source, String sharePrefKey) {
		this.nameResId = nameResId;
		//this.numMonument = numMonument;
		this.imgResId = imgResId;
		this.source = source;
		this.sharePrefKey = sharePrefKey;
	}

	public int getNameResId() {
		return nameResId;
	}

	public int getNumMonument() {
		return (source == null ? 0 : source.size());
	}

	public int getImageResId() {
		return imgResId;
	}

	public List<Place> getSource() {
		return source;
	}

	public String getSharePrefKey() {
		return sharePrefKey;
	}
}
