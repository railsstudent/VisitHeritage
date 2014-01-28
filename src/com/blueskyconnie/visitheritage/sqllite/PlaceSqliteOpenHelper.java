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
	public static final String COLUMN_LOCATION = "location";
	public static final String COLUMN_LOCATION_EN = "location_en";
	

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
		,COLUMN_LOCATION
		,COLUMN_LOCATION_EN
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
				+    ", location varchar(200) default ''"
				+    ", location_en varchar(200) default ''"
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
		ContentValues values = new ContentValues(); //data1
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大潭水塘");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tai Tam Group of Reservoirs");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tai Tam Group of Reservoirs, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.259371");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.210068");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "黃泥涌水塘"); //data2
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港仔水塘"); //data3
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "九龍水塘"); //data4
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "薄扶林水塘"); //data5
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "鶴咀燈塔"); //data6
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "中區警署"); //data7
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "張氏宗祠"); //data8
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "長山古寺"); //data9
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "植桂書室"); //data10
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "都爹利街石階及煤氣路燈"); //data11
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "覲龍圍圍牆及更樓"); //data12
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "老圍門樓及圍牆"); //data13
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "麻笏圍門樓"); //data14
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Entrance Tower of Ma Wat Wai, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "分流炮台"); //data15
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Fan Lau Fort, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "新界大嶼山分流");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "樊仙宮"); //data16
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Fan Sin Temple, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊三軍司令官邸"); //data17
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Flagstaff House, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前中央裁判司署"); //data18
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Central Magistracy, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前法國外方傳道會大樓"); //data19
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former French Mission Building, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前九龍英童學校"); //data20
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Kowloon British School, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前九廣鐵路鐘樓"); //data21
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Kowloon-Canton Railway Clock Tower, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前水警總部"); //data22
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Marine Police Headquarters Compound, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前九龍寨城衙門"); //data23
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Yamen Building of Kowloon Walled City, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "下白泥55號碉堡"); //data24
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Former Yamen Building of Kowloon Walled City, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊總督山頂別墅守衛室"); //data25
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Gate Lodge of the Former Mountain Lodge, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港禮賓府"); //data26
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Government House, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "青洲燈塔建築群"); //data27
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Green Island Lighthouse Compound, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "居石侯公祠"); //data28
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Hau Ku Shek Ancestral Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ho Sheung Heung, Sheung Shui, North");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "上水河上鄉");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "上水");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sheung Shui");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港天文台"); //data29
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Hong Kong Observatory, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "滘西洲洪聖古廟"); //data30
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hung Shing Temple, Hau Ku She");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Hung Shing Temple, Kau Sai Chau, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "二聖宮"); //data31
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "I Shing Temple, Kau Sai Chau, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前政務司官邸"); //data32
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Island House, Kau Sai Chau, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "鏡蓉書屋"); //data33
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kang Yung Study Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "敬羅家塾"); //data34
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King Law Ka Shuk, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "景賢里"); //data35
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King Yin Lei, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "英皇書院"); //data36
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King's College, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.285523");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.14069");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "甘棠第"); //data37
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kom Tong Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kom Tong Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282862");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.150818");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "覲龍圍門樓"); //data38
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kun Lung Gate Tower");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kun Lung Gate Tower, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.508236");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.148075");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "羅屋"); //data39
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Law Uk Hakka House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kun Lung Gate Tower, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.267334");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.235641");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "李鄭屋漢墓"); //data40
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Lei Cheng Uk Han Tomb");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Lei Cheng Uk Han Tomb, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.338138");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.159985");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "No. 41 Tonkin Street, Sham Shui Po");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "深水埗東京街41號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "深水埗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sham Shui Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "八鄉梁氏宗祠"); //data41
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Leung Ancestral Hall, Pat Heung");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Leung Ancestral Hall, Pat Heung, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.421651");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.066065");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廖萬石堂"); //data42
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Liu Man Shek Tong Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Liu Man Shek Tong Ancestral Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.510664");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.12414");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖士提反女校中學主樓"); //data43
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Main Building of St. Stephen's Girls' College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Main Building of St. Stephen's Girls' College, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287985");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.144146");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "麟峯文公祠"); //data44
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Man Lun Fung Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Man Lun Fung Ancestral Hall, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.500029");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.074412");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "文武二帝廟"); //data45
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Man Mo Temple");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Man Mo Temple, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.452283");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.164917");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "上環文武廟"); //data46
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Man Mo Temple Compound, Sheung Wan");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Man Mo Temple Compound, Sheung Wan, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287349");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.150669");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "瑪利諾修院學校"); //data47
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Maryknoll Convent School");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Maryknoll Convent School, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287349");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.150669");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "城門水塘紀念碑"); //data48
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Memorial Stone of Shing Mun Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Memorial Stone of Shing Mun Reservoir, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.386984");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.147127");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "馬禮遜樓"); //data49
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "建築物為私人物業，不對外開放。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。\n農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Morrison Building");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Morrison Building, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.396914");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.977477");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "28 Castle Peak Road, San Hui, Tuen Mun");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "屯門青山道(新墟段)28號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "屯門");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tuen Mun");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖約瑟書院北座及西座"); //data50
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "North and West Blocks of St. Joseph's College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "North and West Blocks of St. Joseph's College, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.291638");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.158828");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊北區理民府"); //data51
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old District Office North");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old District Office North, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.445898");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.170682");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "海壩村古屋"); //data52
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old House, Hoi Pa Village");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old House, Hoi Pa Village, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.118036");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Tak Wah Park, Tak Wah Street, Tsuen Wan");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "荃灣德華街德華公園");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "荃灣");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tsuen Wan");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "王屋村古屋"); //data53
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old House, Wong Uk Village");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old House, Wong Uk Village, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.388809");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.197334");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊病理學院"); //data54
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old Pathological Institute");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old Pathological Institute, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.283527");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.148055");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊赤柱警署"); //data55
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old Stanley Police Station");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old Stanley Police Station, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.221257");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.213325");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊大埔墟火車站"); //data56
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old Tai Po Market Railway Station");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old Tai Po Market Railway Station, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.451173");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.164402");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊灣仔郵政局"); //data57
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Old Wan Chai Post Office");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Old Wan Chai Post Office, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.274513");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.173278");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "碗窰村碗窰"); //data58
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Pottery Kilns at Wun Yiu Village");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Pottery Kilns at Wun Yiu Village, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.430666");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.162791");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "九龍寨城南門遺蹟"); //data59
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Remnants of the South Gate of Kowloon Walled City");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Remnants of the South Gate of Kowloon Walled City, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.33531");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.190494");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "葉定仕故居"); //data60
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Residence of Ip Ting-sz");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Residence of Ip Ting-sz, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.55071");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.222363");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大浪灣石刻"); //data61
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carving at Big Wave Bay");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carving at Big Wave Bay, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.245748");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.250256");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "龍蝦灣石刻"); //data62
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carving at Big Wave Bay");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carving at Big Wave Bay, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.31016");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.298859");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "石壁石刻"); //data63
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carving at Shek Pik");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carving at Shek Pik, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.236989");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.883483");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "滘西洲石刻"); //data64
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carving on Kau Sai Chau");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carving on Kau Sai Chau, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.36357");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.313417");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東龍洲石刻"); //data65
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carving on Tung Lung Island");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carving on Tung Lung Island, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.253553");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.283194");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "黃竹坑石刻"); //data66
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carvings at Wong Chuk Hang");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carvings at Wong Chuk Hang, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.253314");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.175065");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "長洲石刻"); //data67
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carvings on Cheung Chau");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carvings on Cheung Chau, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.207988");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.032709");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "蒲台石刻"); //data68
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carvings on Po Toi");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carvings on Po Toi, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.161891");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.256175");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大廟灣刻石"); //data69
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Inscription at Joss House Bay");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Inscription at Joss House Bay, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.274324");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.290573");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "三棟屋村"); //data70
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Sam Tung Uk Village");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Sam Tung Uk Village, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.380516");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.130862");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖士提反書院的書院大樓"); //data71
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "School House of St. Stephen's College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "School House of St. Stephen's College, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.220304");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.21693");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "上窰村"); //data72
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Sheung Yiu Village ");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Sheung Yiu Village , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.401824");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.322674");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "佛頭洲稅關遺址"); //data73
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Site of Chinese Customs Station, Fat Tau Chau ");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Site of Chinese Customs Station, Fat Tau Chau , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.321495");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.268745");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖約翰座堂"); //data74
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "St. John's Cathedral");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "St. John's Cathedral , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282743");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.158909");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "分流石圓環"); //data75
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Stone Circle at Fan Lau");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Stone Circle at Fan Lau , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.200359");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.849252");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大夫第"); //data76
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tai Fu Tai Mansion");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tai Fu Tai Mansion , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.502566");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.077198");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廈村鄧氏宗祠"); //data77
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tang Ancestral Hall, Ha Tsuen");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tang Ancestral Hall, Ha Tsuen , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.447603");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.986323");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "屏山鄧氏宗祠"); //data78
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tang Ancestral Hall, Ping Shan");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tang Ancestral Hall, Ping Shan , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.438282");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.010227");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "松嶺鄧公祠"); //data79
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tang Chung Ling Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tang Chung Ling Ancestral Hall , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.497858");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.152818");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廣瑜鄧公祠"); //data80
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tang Kwong U Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tang Kwong U Ancestral Hall , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.446354");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.060969");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "燈籠洲燈塔"); //data81
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tang Lung Chau Lighthouse");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tang Lung Chau Lighthouse , is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.339676");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.063082");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學孔慶熒樓外部"); //data82
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "The Exterior of Hung Hing Ying Building, the University of Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Exterior of Hung Hing Ying Building, the University of Hong Kong, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.285602");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.137857");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學鄧志昂樓外部"); //data83
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "The Exterior of Tang Chi Ngong Building, the University of Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Exterior of Tang Chi Ngong Building, the University of Hong Kong, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.283974");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.139942");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學大學堂外部"); //data84
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "The Exterior of University Hall, the University of Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Exterior of University Hall, the University of Hong Kong, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.263879");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.135243");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "梅夫人婦女會主樓外部"); //data85
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "The Exterior of the Main Building, the Helena May");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Exterior of the Main Building, the Helena May, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.277749");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.15858");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學本部大樓外部"); //data86
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "The Exterior of the Main Building, the University of Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Exterior of the Main Building, the University of Hong Kong, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.284282");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.137916");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊最高法院外部"); //data87
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "The Exterior of the Old Supreme Court");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Exterior of the Old Supreme Court, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.28183");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.160302");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "銅鑼灣天后廟"); //data88
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tin Hau Temple, Causeway Bay");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tin Hau Temple, Causeway Bay, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.284093");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.192739");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "龍躍頭天后宮"); //data89
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tin Hau Temple, Lung Yeuk Tau");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tin Hau Temple, Lung Yeuk Tau, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.50098");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.152729");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聚星樓"); //data90
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tsui Sing Lau Pagoda");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tsui Sing Lau Pagoda, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.4491");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.006166");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東涌小炮台"); //data91
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tung Chung Battery");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tung Chung Battery, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287806");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.935987");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東涌炮台"); //data92
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tung Chung Fort");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tung Chung Fort, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.278712");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.935751");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東龍洲炮台"); //data93
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tung Lung Fort");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tung Lung Fort, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.255618");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.296905");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東華三院文物館"); //data94
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tung Wah Museum");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Tung Wah Museum, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.318795");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.172298");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "域多利監獄"); //data95
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Victoria Prison Compound");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Victoria Prison Compound, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.28173");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.15346");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "橫瀾燈塔"); //data96
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Waglan Lighthouse");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Waglan Lighthouse, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.186153");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.305329");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊上環街市"); //data97
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Western Market");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Western Market, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287697");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.150404");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "仁敦岡書室"); //data98
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Yan Tun Kong Study Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Yan Tun Kong Study Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.443577");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.014309");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廈村楊侯宮"); //data99
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Yeung Hau Temple, Ha Tsuen");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Yeung Hau Temple, Ha Tsuen, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.45383");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.99313");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "二帝書院"); //data100
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
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Yi Tai Study Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Yi Tai Study Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.445094");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.061194");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "愈喬二公祠"); //data101
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Yu Kiu Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.448793");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.008362");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
	}
		
}
