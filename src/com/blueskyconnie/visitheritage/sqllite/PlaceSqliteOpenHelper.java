package com.blueskyconnie.visitheritage.sqllite;

import com.blueskyconnie.visitheritage.Constants;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlaceSqliteOpenHelper extends SQLiteOpenHelper {

	public static final String TABLE_PLACE = "place";
	
	public static final String SQL_CREATE_TABLE;
	
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_IMG_URL = "imgUrl";
	public static final String COLUMN_DESC = "description";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_HOMEPAGE = "homepage";
	public static final String COLUMN_REMARK = "remark";
	public static final String COLUMN_HOUR = "openingHour";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_NAME_EN = "name_en";
	public static final String COLUMN_DESC_EN = "description_en";
	public static final String COLUMN_REMARK_EN = "remark_en";
	public static final String COLUMN_HOUR_EN = "openingHour_en";
	public static final String COLUMN_LAT = "lat";
	public static final String COLUMN_LNG = "lng";
	public static final String COLUMN_DISTRICT = "district";

	public static final String[] ALL_COLUMNS  = {
		 COLUMN_ID
		,COLUMN_NAME
		,COLUMN_IMG_URL
		,COLUMN_DESC
		,COLUMN_EMAIL
		,COLUMN_HOMEPAGE
		,COLUMN_REMARK
		,COLUMN_HOUR
		,COLUMN_PHONE
		,COLUMN_NAME_EN
		,COLUMN_DESC_EN
		,COLUMN_REMARK_EN
		,COLUMN_HOUR_EN
		,COLUMN_LAT
		,COLUMN_LNG
		,COLUMN_DISTRICT
	};
	
	private static final String DATABASE_NAME = "place.db";
	private static final int DATABASE_VERSION = 1;
	  
	static {
		SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_PLACE 
				+ "("
				+    "id integer primary key autoincrement "
				+    ", name varchar(200) default '' "
				+    ", imgUrl varchar(200) default ''"
				+    ", description varchar(2000) default ''"
				+    ", email varchar(100) default ''"
				+    ", homepage varchar(200) default ''"
				+    ", remark varchar(100) default ''"
				+    ", openingHour varchar(300) default ''"
				+    ", phone varchar(20) default ''"
				+    ", name_en varchar(100) default ''"
				+    ", description_en varchar(1000) default ''"
				+    ", remark_en varchar(50) default ''"
				+    ", openingHour_en varchar(150) default ''"
				+    ", lat real default 0 "
				+    ", lng real default 0 "
				+    ", district integer default 0 "
				+ ")";
	}
	
	public PlaceSqliteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// create database
		db.execSQL(SQL_CREATE_TABLE);
		createData(db);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion) {
			// drop table
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACE);
			// recreate database
			onCreate(db);
		}
	}

	
	private void createData(SQLiteDatabase database) {
		ContentValues values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "愈喬二公祠");
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。\n農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Yu Kiu Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Yu Kiu Ancestral Hall, is situated adjacent to Tang Ancestral Hall, "
				+ "comprises three halls and two internal courtyards. The layout and design of Yu Kiu "
				+ "Ancestral Hall is identical to Tang Ancestral Hall. It was constructed in the early "
				+ "sixteenth century by two eleventh generation brothers of the Tang clan of Ping Shan: "
				+ "Tang Sai-yin (alias Yu-sing) and Tang Sai-chiu (alias Kiu-lum). Apart from serving as an "
				+ "ancestral hall, the building was also used as a teaching hall for youngsters of Ping Shan. "
				+ "From 1931 to 1961, it was occupied by Tat Tak Primary School. The last major renovation of "
				+ "the building probably took place during the Guangzu reign (1875-1908) of Qing dynasty as "
				+ "indicated by the engraved characters on the stone tablet above the main entrance. Most of "
				+ "the original structure and features of the building remain intact. Yu Kiu Ancestral Hall was "
				+ "declared a monument on 14 December 2001.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00AM – 1:00PM & 2:00PM – 5:00PM.\nCLOSED ON THE FIRST 3 DAYS OF THE LUNAR NEW YEAR");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.482106");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.013152");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		values = new ContentValues();
		// insert row 2, row 3, ...
	}
}
