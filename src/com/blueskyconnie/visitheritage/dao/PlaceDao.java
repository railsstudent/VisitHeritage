package com.blueskyconnie.visitheritage.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.blueskyconnie.visitheritage.Constants;
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
		
		Cursor cursor = database.query(PlaceSqliteOpenHelper.TABLE_PLACE, PlaceSqliteOpenHelper.ALL_COLUMNS, 
							"district = ?", selectArg, null, null, null);
		
		// iterate cursor and convert the sql object to Place bean
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Place place = convertToPlace(cursor);
			lstPlace.add(place);
			cursor.moveToNext();
		}
		
		// sort by id
		Collections.sort(lstPlace);
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

	// to do later pass location
	public List<Place> getAroundMePlaces() {
		
		List<Place> lstPlace = new ArrayList<Place>();
		Cursor cursor = database.query(PlaceSqliteOpenHelper.TABLE_PLACE, PlaceSqliteOpenHelper.ALL_COLUMNS,
							null, null, null, null, "");

		
		// iterate cursor and convert the sql object to Place bean
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Place place = convertToPlace(cursor);
			place.setDistance(0);
			lstPlace.add(place);
			cursor.moveToNext();
		}
		return lstPlace;
	}
	
	private Place convertToPlace(Cursor cursor) {
		int colIdx = 0;
		Place.PlaceBuilder builder = new Place.PlaceBuilder();
		Place place = builder
						.id(cursor.getInt(colIdx++))
						.name(cursor.getString(colIdx++))
						.imgUrl(cursor.getString(colIdx++))
						.description(cursor.getString(colIdx++))
						.email(cursor.getString(colIdx++))
						.homepage(cursor.getString(colIdx++))
						.remark(cursor.getString(colIdx++))
						.openingHour(cursor.getString(colIdx++))
						.phone(cursor.getString(colIdx++))
						.name_en(cursor.getString(colIdx++))
						.description_en(cursor.getString(colIdx++))
						.remark_en(cursor.getString(colIdx++))
						.openingHour_en(cursor.getString(colIdx++))
						.lat(cursor.getDouble(colIdx++))
						.lng(cursor.getDouble(colIdx++))
						.district(cursor.getInt(colIdx++))
						.distance(0)
						.build();
		return place;
	}
}
