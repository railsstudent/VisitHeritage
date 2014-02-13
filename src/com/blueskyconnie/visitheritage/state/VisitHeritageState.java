package com.blueskyconnie.visitheritage.state;

import java.util.ArrayList;

import android.content.Context;

import com.blueskyconnie.visitheritage.dao.PlaceDao;
import com.blueskyconnie.visitheritage.helper.FavoritePlaceHolder;
import com.blueskyconnie.visitheritage.model.Place;

public class VisitHeritageState {
	
//	private static final char SEP = ',';
	
	private Context context;
//	private SharedPreferences share_pref_favorite;
	private FavoritePlaceHolder favPlaceHolder;
	
	private ArrayList<Place> lstHK;
	private ArrayList<Place> lstKowloon;
	private ArrayList<Place> lstNT;
	private ArrayList<Place> lstIsland;
	private ArrayList<Place> lstAll;
	
	public VisitHeritageState(Context context) {
		this.context = context;
		favPlaceHolder = new FavoritePlaceHolder(context);
	}
	
	public FavoritePlaceHolder getFavorites() {
		return favPlaceHolder;
	}
	
	public ArrayList<Place> getLstHK() {
		if (lstHK == null) {
			PlaceDao dao = null;
			try {
				dao = new PlaceDao(context);
				dao.open();
				lstHK = (ArrayList<Place>)dao.getHKPlaces();
			} finally {
				if (dao != null) {
					dao.close();
				}
			}
		}
		return lstHK;
	}

	public ArrayList<Place> getLstKowloon() {
		if (lstKowloon == null) {
			PlaceDao dao = null;
			try {
				dao = new PlaceDao(context);
				dao.open();
				lstKowloon = (ArrayList<Place>)dao.getKowloonPlaces();
			} finally {
				if (dao != null) {
					dao.close();
				}
			}
		}
		return lstKowloon;
	}

	public ArrayList<Place> getLstNT() {
		if (lstNT == null) {
			PlaceDao dao = null;
			try {
				dao = new PlaceDao(context);
				dao.open();
				lstNT = (ArrayList<Place>)dao.getNTPlaces();
			} finally {
				if (dao != null) {
					dao.close();
				}
			}
		}
		return lstNT;
	}

	public ArrayList<Place> getLstIsland() {
		if (lstIsland == null) {
			PlaceDao dao = null;
			try {
				dao = new PlaceDao(context);
				dao.open();
				lstIsland = (ArrayList<Place>)dao.getIslandPlaces();
			} finally {
				if (dao != null) {
					dao.close();
				}
			}
		}
		return lstIsland;
	}

	public ArrayList<Place> getLstAll() {
		if (lstAll == null) {
			PlaceDao dao = null;
			try {
				dao = new PlaceDao(context);
				dao.open();
				lstAll = (ArrayList<Place>)dao.getAll();
			} finally {
				if (dao != null) {
					dao.close();
				}
			}
		}
		return lstAll;
	}
}
