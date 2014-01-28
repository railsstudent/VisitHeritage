package com.blueskyconnie.visitheritage.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		
		Cursor cursor = database.query(PlaceSqliteOpenHelper.TABLE_PLACE, PlaceSqliteOpenHelper.ALL_COLUMNS, 
							"district = ?", selectArg, null, null, null);
		
		// iterate cursor and convert the sql object to Place bean
		lstPlace = PlaceCursorHelper.loadFromCursor(cursor);
		for (Place place : lstPlace) {
			place.setDistance(0);
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

//	private Place convertToPlace(Cursor cursor) {
//		Place.PlaceBuilder builder = new Place.PlaceBuilder();
//		Place place = builder
//						.id(CursorUtils.getInt(PlaceSqliteOpenHelper.COLUMN_ID, cursor))
//						.name(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_NAME, cursor))
//						.imgUrl(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_IMG_URL, cursor))
//						.description(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_DESC, cursor))
//						.email(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_EMAIL, cursor))
//						.homepage(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, cursor))
//						.remark(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_REMARK, cursor))
//						.openingHour(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_HOUR, cursor))
//						.phone(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_PHONE, cursor))
//						.name_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_NAME_EN, cursor))
//						.description_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_DESC_EN, cursor))
//						.remark_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, cursor))
//						.openingHour_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, cursor))
//						.lat(CursorUtils.getDouble(PlaceSqliteOpenHelper.COLUMN_LAT, cursor))
//						.lng(CursorUtils.getDouble(PlaceSqliteOpenHelper.COLUMN_LNG, cursor))
//						.district(CursorUtils.getInt(PlaceSqliteOpenHelper.COLUMN_DISTRICT, cursor))
//						.distance(0)
//						.address(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_ADDRESS, cursor))
//						.address_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, cursor))
//						.build();
//		return place;
//	}
}
