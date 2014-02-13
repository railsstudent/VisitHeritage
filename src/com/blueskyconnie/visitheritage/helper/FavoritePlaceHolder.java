package com.blueskyconnie.visitheritage.helper;

import java.util.Set;
import java.util.TreeSet;

import android.content.Context;
import android.content.SharedPreferences;

import com.blueskyconnie.visitheritage.Constants;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class FavoritePlaceHolder {

	private static final char SEP = ',';

	private Set<Integer> favoriteIds;	
	private SharedPreferences share_pref_favorite;
	
	public FavoritePlaceHolder(Context context) {
		share_pref_favorite = context.getSharedPreferences(Constants.SHARE_PREF_FAV, Context.MODE_PRIVATE);
		loadFavorites();
	}
	
	public FavoritePlaceHolder(Set<Integer> favoriteIds) {
		this.favoriteIds = favoriteIds;
	}
	
	public void addFavorite(int id) {
		favoriteIds.add(id);
	}
	
	public void removeFavorite(int id) {
		favoriteIds.remove(id);
	}
	
	public boolean isFavorite(int id) {
		return favoriteIds.contains(id);
	}
	
	public Set<Integer> getFavoriteIds() {
		return favoriteIds;
	}
	
	public void loadFavorites() {
		String strIds = share_pref_favorite.getString(Constants.FAVORITE_SET, "");
		Iterable<String> tmpFavIds = Splitter.on(SEP).omitEmptyStrings().trimResults().split(strIds);
		favoriteIds = new TreeSet<Integer>();
		for (String strId : tmpFavIds) {
			favoriteIds.add(Integer.valueOf(strId));
		}
	}
	
	public void saveFavorites() {
		String result = Joiner.on(SEP).join(favoriteIds);
		share_pref_favorite.edit().putString(Constants.FAVORITE_SET, result).commit();
	}
}
