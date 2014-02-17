package com.blueskyconnie.visitheritage.model;

import java.io.Serializable;

public class Region implements Serializable {

	private static final long serialVersionUID = 1L;

	private int nameResId;
	private int numMonument;
	private String imgUrl;
	
	public Region(int nameResId, int numMonument, String imgUrl) {
		this.nameResId = nameResId;
		this.numMonument = numMonument;
		this.imgUrl = imgUrl;
	}
	

	public int getNameResId() {
		return nameResId;
	}

	public void setName(int nameResId) {
		this.nameResId = nameResId;
	}

	public int getNumMonument() {
		return numMonument;
	}


	public void setNumMonument(int numMonument) {
		this.numMonument = numMonument;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}
