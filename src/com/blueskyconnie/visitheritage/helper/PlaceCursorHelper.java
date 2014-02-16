package com.blueskyconnie.visitheritage.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.database.Cursor;
import android.util.Log;

import com.blueskyconnie.visitheritage.Constants;
import com.blueskyconnie.visitheritage.model.Place;
import com.blueskyconnie.visitheritage.sqllite.CursorUtils;
import com.blueskyconnie.visitheritage.sqllite.PlaceSqliteOpenHelper;
import com.google.common.base.Strings;


public final class PlaceCursorHelper {

   private static final String TAG = "PlaceCursorHelper";

   public static boolean IsDeviceEngLang() {
		return Constants.LANG_CODE_EN.equals(getDeviceLang()); 
   }
   
   public static String getDeviceLang() {
		Locale locale = Locale.getDefault();
		return Strings.nullToEmpty(locale.getLanguage()).toUpperCase(locale);
   }
   
   public static String getUrlByLanguage(String url) {
	   String folderLang = "b5";
	   if (IsDeviceEngLang()) {
		   folderLang = "en";
	   }
	   return String.format(url, folderLang);
   }
   
   public static List<Place> loadFromCursor(Cursor cursor) {
	   
	   List<Place> places = new ArrayList<Place>();
	   try {
			if (cursor != null) {
				for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

					Place.PlaceBuilder builder = new Place.PlaceBuilder();
					Place place = builder
								.id(CursorUtils.getInt(PlaceSqliteOpenHelper.COLUMN_ID, cursor))
								.address(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_ADDRESS, cursor))
								.address_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, cursor))
								.description(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_DESC, cursor))
								.description_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_DESC_EN, cursor))
								.district(CursorUtils.getInt(PlaceSqliteOpenHelper.COLUMN_DISTRICT, cursor))
								.email(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_EMAIL, cursor))
								.homepage(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, cursor))
								.lat(CursorUtils.getDouble(PlaceSqliteOpenHelper.COLUMN_LAT, cursor))
								.lng(CursorUtils.getDouble(PlaceSqliteOpenHelper.COLUMN_LNG, cursor))
								.name(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_NAME, cursor))
								.name_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_NAME_EN, cursor))
								.openingHour(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_HOUR, cursor))
								.openingHour_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, cursor))
								.phone(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_PHONE, cursor))
								.remark(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_REMARK, cursor))
								.remark_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, cursor))
								.imgUrl(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_IMG_URL, cursor))
								.location(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_LOCATION, cursor))
								.location_en(CursorUtils.getString(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, cursor))
								.build();
					places.add(place);
				}
			}
		} catch (IllegalArgumentException ex) {
			Log.e(TAG, ex.getMessage());
		} 
	    return places;
   }
}
