package com.blueskyconnie.visitheritage.helper;

import java.util.Comparator;

import com.blueskyconnie.visitheritage.model.Place;
import com.google.common.collect.ComparisonChain;

public class DistanceComparator implements Comparator<Place> {

	public int compare(Place lhs, Place rhs) {
		// sort distance in ascending order
		return ComparisonChain.start().compare(lhs.getDistance(), rhs.getDistance()).result();
	}

}
