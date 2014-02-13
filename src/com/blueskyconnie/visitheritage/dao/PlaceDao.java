package com.blueskyconnie.visitheritage.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.blueskyconnie.visitheritage.Constants;
import com.blueskyconnie.visitheritage.helper.PlaceCursorHelper;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.sqllite.PlaceSqliteOpenHelper;

public class PlaceDao {

	private SQLiteDatabase database;
	private PlaceSqliteOpenHelper dbHelper;
	
	public PlaceDao(Context context) {
		dbHelper = new PlaceSqliteOpenHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close()  {
		dbHelper.close();
	}
	
	private List<Place> getPlaceByDistrict(int district) {
		List<Place> lstPlace = new ArrayList<Place>();
		String[] selectArg = { String.valueOf(district) };
		
		Cursor cursor = null;
		try {
			cursor = database.query(PlaceSqliteOpenHelper.TABLE_PLACE, PlaceSqliteOpenHelper.ALL_COLUMNS, 
								"district = ?", selectArg, null, null, null);
			
			// iterate cursor and convert the sql object to Place bean
			lstPlace = PlaceCursorHelper.loadFromCursor(cursor);
			for (Place place : lstPlace) {
				place.setDistance(0);
			}
			// sort by id
			Collections.sort(lstPlace);
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return lstPlace;
	}
	
	public List<Place> getHKPlaces() {
		return getPlaceByDistrict(Constants.INT_HK);
	}

	public List<Place> getKowloonPlaces() {
		return getPlaceByDistrict(Constants.INT_KOWLOON);
	}

	public List<Place> getNTPlaces() {
		return getPlaceByDistrict(Constants.INT_NT);
	}

	public List<Place> getIslandPlaces() {
		return getPlaceByDistrict(Constants.INT_ISLAND);
	}
	
	public List<Place> getAll() {
		List<Place> lstPlace = new ArrayList<Place>();
		Cursor cursor = null;
		try {
			cursor = database.query(PlaceSqliteOpenHelper.TABLE_PLACE, PlaceSqliteOpenHelper.ALL_COLUMNS, 
								null, null, null, null, null);
			
			// iterate cursor and convert the sql object to Place bean
			lstPlace = PlaceCursorHelper.loadFromCursor(cursor);
			for (Place place : lstPlace) {
				place.setDistance(0);
			}
			// sort by id
			Collections.sort(lstPlace);
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return lstPlace;
	}
	
	public List<Place> getFavorites(Set<Integer> setFavIds) {

		List<Place> lstPlace = new ArrayList<Place>();
		Cursor cursor = null;
		try {
			String selectClause = "";
			String[] selectArgs = new String[setFavIds.size()]; 
			int i = 0;
			for (int id : setFavIds) {
				if (selectClause.length() > 0) {
					selectClause += " OR ";
				}
				selectClause += PlaceSqliteOpenHelper.COLUMN_ID + "= ? ";
				selectArgs[i++] = String.valueOf(id);
			}
			
			cursor = database.query(PlaceSqliteOpenHelper.TABLE_PLACE, PlaceSqliteOpenHelper.ALL_COLUMNS, 
								selectClause, selectArgs, null, null, null);
			
			// iterate cursor and convert the sql object to Place bean
			lstPlace = PlaceCursorHelper.loadFromCursor(cursor);
			for (Place place : lstPlace) {
				place.setDistance(0);
			}
			// sort by id
			Collections.sort(lstPlace);
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return lstPlace;
		
	}
}
