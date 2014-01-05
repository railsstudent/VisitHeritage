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
	public static final String COLUMN_ADDRESS = "address";
	public static final String COLUMN_ADDRESS_EN = "address_en";
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
		,COLUMN_ADDRESS_EN
		,COLUMN_ADDRESS
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
				+    ", address_en varchar(200) default ''"
				+    ", address varchar(200) default ''"
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data2
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Wong Nai Chung Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Wong Nai Chung Reservoir, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.256809");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.19539");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data3
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Aberdeen Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Aberdeen Reservoir, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.259312");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.167763");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data4
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kowloon Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kowloon Reservoir, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.354839");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.153954");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data5
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Pok Fu Lam Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Pok Fu Lam Reservoir, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.265597");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.137412");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data6
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Cape D'Aguilar Lighthouse");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Cape D'Aguilar Lighthouse, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.208901");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.260295");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data7
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Central Police Station Compound");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Central Police Station Compound, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282703");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.154122");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data8
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Cheung Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Cheung Ancestral Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.432332");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.017523");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data9
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Cheung Shan Monastery");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Cheung Shan Monastery, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.529455");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.175649");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data10
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Chik Kwai Study Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Chik Kwai Study Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.433244");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.101416");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data11
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Duddell Street Steps and Gas Lamps");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Duddell Street Steps and Gas Lamps, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.279874");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.156724");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data12
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.507235");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.148452");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data13
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.497848");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.15181");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data14
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Entrance Tower of Ma Wat Wai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Entrance Tower of Ma Wat Wai, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.499751");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.149874");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data15
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Fan Lau Fort");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Fan Lau Fort, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.201233");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.85421");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data16
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Fan Sin Temple");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Fan Sin Temple, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.441019");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.163715");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data17
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Flagstaff House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Flagstaff House, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.281949");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.16217");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data18
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Central Magistracy");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Central Magistracy, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.285284");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.155132");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data19
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former French Mission Building");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former French Mission Building, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.283061");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.159424");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data20
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Kowloon British School");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Kowloon British School, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.305297");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.172298");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data21
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Kowloon-Canton Railway Clock Tower");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Kowloon-Canton Railway Clock Tower, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.296879");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.169552");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data22
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Marine Police Headquarters Compound");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Marine Police Headquarters Compound, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.299261");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.169037");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data23
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Yamen Building of Kowloon Walled City");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Yamen Building of Kowloon Walled City, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.335627");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.190323");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data24
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Fortified Structure at No. 55 Ha Pak Nai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Fortified Structure at No. 55 Ha Pak Nai, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.446572");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.943908");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data25
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Gate Lodge of the Former Mountain Lodge");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Gate Lodge of the Former Mountain Lodge, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.277819");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.145691");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data26
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Government House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Government House, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282266");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.156849");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data27
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Green Island Lighthouse Compound");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Green Island Lighthouse Compound, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.370714");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.112917");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data28
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hau Ku Shek Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Hau Ku Shek Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.509593");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.107843");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data29
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hong Kong Observatory");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Hong Kong Observatory, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.305932");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.173843");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data30
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hung Shing Temple, Kau Sai Chau");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Hung Shing Temple, Kau Sai Chau, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.342614");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.321669");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data31
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "I Shing Temple");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "I Shing Temple, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.454534");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.027763");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data32
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Island House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Island House, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.270631");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.158365");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data33
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kang Yung Study Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kang Yung Study Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.527859");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.194747");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data34
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "King Law Ka Shuk");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King Law Ka Shuk, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.456369");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.157083");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data35
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "King Yin Lei");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King Yin Lei, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.267573");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.18073");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		// insert row 2, row 3, ...data36
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "King's College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King's College, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.267573");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.18073");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
	}
		
}
