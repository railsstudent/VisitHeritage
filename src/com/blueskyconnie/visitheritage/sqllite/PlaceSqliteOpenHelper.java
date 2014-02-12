package com.blueskyconnie.visitheritage.sqllite;

import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blueskyconnie.visitheritage.Constants;

public class PlaceSqliteOpenHelper extends SQLiteOpenHelper {

	public static final String TABLE_PLACE = "place";
	
	public static final String SQL_CREATE_TABLE;
	
	private static final String IMG_FMT = "http://www.amo.gov.hk/graphics/%%s/monuments/%1$s.jpg";

	private static final String HOMEPAGE_FMT = "http://www.amo.gov.hk/%%s/monuments_%1$s.php";
	
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
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("88"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("88"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "薄扶林水塘落成後，市民對食水的需求有增無減，為應付所需，政府於一八八三至一九一七年期間，" +
				"進行大潭計劃和大潭篤計劃，建造了多個容量更大的水塘，以及一些更為複雜的供水系統。在該兩項計劃下，多個水塘相繼落成，包括大潭上水塘（一八八八年）、" +
				"大潭副水塘（一九〇四年）、大潭中水塘（一九〇七年）和大潭篤水塘（一九一七年）（現統稱大潭水塘群）。隨供水系統得到改善，" +
				"都市的發展逐漸從中西區擴展至港島東部，擴大了香港的市區面積。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Tai Tam Group of Reservoirs");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "To cater for the ever-increasing demands of water after the completion of " +
				"Pok Fu Lam Reservoir, much larger reservoirs and more complex water supply systems were constructed under the " +
				"Tai Tam Scheme and Tai Tam Tuk Scheme between 1883 and 1917. With improved water provision brought by the two " +
				"Schemes through the construction of Tai Tam Upper Reservoir (1888), Tai Tam Byewash Reservoir (1904), Tai Tam " +
				"Intermediate Reservoir (1907) and Tai Tam Tuk Reservoir (1917) (which are collectively known as Tai Tam " +
				"Group of Reservoirs nowadays), the forces of urbanisation gradually spread from central and western " +
				"districts to the eastern side of Hong Kong Island, thus expanding the Hong Kong urban area.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.259371");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.210068");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Tai Tam Reservoir Road, Tai Tam / Bowen Road");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "大潭 大潭水塘道 / 寶雲道");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "灣仔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Wan Chai");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "黃泥涌水塘"); //data2
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("89"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("89"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "黃泥涌水塘是本港現存第三個最古老的水務建築。水塘於一八九九年落成後，" +
				"成為大潭水塘群以外的輔助水源，進一步增加了港島的儲水設施。黃泥涌水塘範圍內現存具歷史價值的建築，包括石砌水壩、水掣房和溢流口。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Wong Nai Chung Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Wong Nai Chung Reservoir is the third oldest surviving waterworks " +
				"construction in Hong Kong. Upon its completion in 1899, it served as a supplementary source to the Tai Tam " +
				"Group of Reservoirs and thus further increased the facilities for storing water on Hong Kong Island. " +
				"The surviving historical structures in Wong Nai Chung Reservoir include a masonry dam, a valve house and a weir.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.256809");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.19539");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Tai Tam Reservoir Road, Wong Nai Chung");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "黃泥涌 大潭水塘路");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港仔水塘"); //data3
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("90"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("90"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "香港仔水塘由上水塘（一九三一年）和下水塘（一九三二年）組成，是為了在薄扶林水塘以" +
				"外增加儲水量以解決港島西區食水短缺的問題而興建。這是繼薄扶林水塘、大潭水塘群和黃泥涌水塘後，最後一個在港島興建的水塘。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Aberdeen Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Aberdeen Reservoir, comprising the Upper Reservoir (1931) and the Lower Reservoir (1932), " +
				"was built to augment Pok Fu Lam Reservoir for solving the water shortage problem in the western part of Hong Kong Island. " +
				"It became the last reservoir ever built on Hong Kong Island, after Pok Fu Lam, Tai Tam and Wong Nai Chung.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.259312");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.167763");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Aberdeen Reservoir Road, Aberdeen");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "香港仔 香港仔水塘路");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "九龍水塘"); //data4
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("91"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("91"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "九龍水塘是本港的第四個水塘，於一九〇一至一九一〇年間興建，是因應九龍半島人口不斷增加而在九龍興建的首個水塘。" +
				"九龍半島的供水方式隨著九龍水塘的落成而急劇轉變。居民的食水自此依賴水塘所儲存的雨水，正式取代了慣用的井水以及由油麻地抽水站所運送的地下水源。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kowloon Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Built between 1901 and 1910 as the fourth reservoir of the territory, Kowloon Reservoir " +
				"was the first reservoir built in Kowloon in response to the growing population of Kowloon Peninsula. The way in which water was provided " +
				"for the Kowloon Peninsula was radically changed by the establishment of the Kowloon Reservoir. " +
				"Rainwater impounded in the reservoir replaced well water and subterranean water pumped out by the Yau Ma Tei Pumping Station.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.354839");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.153954");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Golden Hill Road, Kam Shan Country Park, Sha Tin");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "沙田 歌賦山道 金山郊野公園");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "沙田");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Shatin");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "薄扶林水塘"); //data5
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("87"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("87"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "一八六〇年代以前，食水主要依靠水井和溪流等原始水源。十九世紀中葉開始，香港人口不斷增加，城市面積也隨之不斷擴展，" +
				"穩定的食水供應成為沉重壓力，促使政府興建水塘。港督羅便臣爵士於一八五九至一八六五年在任期間，政府首次提出供水的構思。薄扶林水塘建於一八六三年，成為本港第一個水塘。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Pok Fu Lam Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Water supply in Hong Kong before 1860s mainly relied on primitive sources such as wells and streams. " +
				"Since the mid-nineteenth century, the continual increase in population and the accompanying city expansion had placed a great pressure on " +
				"permanent provision of fresh water resources which accelerated the construction of reservoirs. The first water supply scheme was mooted during " +
				"the time Sir Hercules Robinson was the Governor of Hong Kong from 1859 to 1865. Completed in 1863, Pok Fu Lam Reservoir is the first ever-built " +
				"reservoir in the territory.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.265597");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.137412");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Pok Fu Lam Reservoir Road, Pok Fu Lam");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "薄扶林 薄扶林水塘道");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "鶴咀燈塔"); //data6
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("80"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("80"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "鶴咀燈塔是香港現存的五座戰前燈塔之一，於二ＯＯ六年三月三日列為法定古蹟。" +
				"鶴咀燈塔位於香港島東南面，於一八七五年四月十六日啟用，是香港第一座燈塔。現時的燈塔建築是一座白色的圓形石塔，高9.7米。燈塔底座、" +
				"拱形門口及螺旋式樓梯均由石塊砌成，工藝精湛。位於入口的鐵門上方，飾有幾何圖案，別具特色。一八九三年，橫瀾燈塔落成啟用，鶴咀燈塔從此失去其原有的功能，" +
				"至一八九六年停止運作。一九Ｏ五年，當局決定將鶴咀燈塔上已停用的一級號燈及其附屬設備遷往青洲，以取代青洲燈塔的的四級號燈。及至一九七五年，" +
				"鶴咀燈塔改為自動化操作，燈塔的燈光再次亮起。鶴咀燈塔在香港海事史上佔著重要的一頁。該燈塔現由海事處管理。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "此燈塔現由海事處管理及操作。基於保安理由及避免影響日常運作，燈塔並不對外開放。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Cape D'Aguilar Lighthouse");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Being one of the five surviving pre-war lighthouses in Hong Kong, Cape D'Aguilar " +
				"Lighthouse was declared a monument on 3 March 2006.Situated at the southeast of Hong Kong Island, Cape D'Aguilar Lighthouse, " +
				"the first of its kind built in Hong Kong, was put into service on 16 April 1875. The existing structure is a round stone tower, " +
				"9.7 metres high and white in colour. The tower base, the arched doorway and the circular staircase are of fine masonry. " +
				"The door is made of iron with geometric decoration on top.As a result of the operation of Waglan Island Lighthouse " +
				"in 1893, Cape D'Aguilar Lighthouse became superfluous, and was discontinued in 1896. The disused first-order light " +
				"was removed from Cape D'Aguilar and, together with the light apparatus, was subsequently transferred to Green " +
				"Island in 1905 to replace the fourth-order light. It was not until 1975 that the lantern of Cape D'Aguilar " +
				"Lighthouse was re-lit and automated.Cape D'Aguilar Lighthouse once played an important role in the maritime " +
				"history of Hong Kong. It is now under the management of Marine Department.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "This lighthouse is still running under the management of the Marine Department. " +
				"For security and operational reasons, it is not open to the public.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.208901");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.260295");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Cape D'Aguilar Peninsula");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "鶴咀半島");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "中區警署"); //data7
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("53"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("53"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "中區警署內歷史最悠久的建築物是建於一八六四年之大樓，大樓原高三層，與域多利監獄毗鄰，" +
				"一九〇五年加建一層。其後，警署逐漸擴建。面對荷李活道的四層高大樓則於一九一九年加建，一九二五年，在廣場的西北端又增建另一所兩層高樓房，" +
				"作為軍械倉庫。它與毗鄰的前中央裁判司署及域多利監獄，組成了一組標誌著法律及紀律的歷史建築群。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282703");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.154122");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "10 Hollywood Road, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環荷李活道十號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "張氏宗祠"); //data8
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("68"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("68"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "張氏宗祠又名「華封堂」，建於清朝嘉慶二十年（一八一五年），由元朗山廈村張氏第二十二世祖張南一、" +
				"張瑞一、張志廣及張耀晃主力籌建，是張氏族人議事和祭祖的重要場所。張氏族人十分重視子孫的教育，山廈村曾建有多所書室，當時不論男女均可入" +
				"讀。張氏宗祠於一九三Ｏ至一九五Ｏ年代曾用作華封學校校舍。至一九五八年，華封學校才遷往欖口村附近的新校舍。張氏宗祠為傳統的兩進式青磚建築，中間為天井，" +
				"兩側為廂房，分別作為廚房及貯物之用。後進置有神龕，安放張氏歷代祖先神位，頂層供奉唐朝丞相張九齡的木主，山廈村及東莞的張氏族人多奉張九齡為先祖。" +
				"整座神龕莊嚴華麗，飾以「八仙」為主題的木雕，盡顯昔日工匠的精湛工藝。張氏宗祠曾於一九九九年進行大規模修繕工程，工程由建築署及古物古蹟辦事處監督。" +
				"張氏宗祠於一九九九年十二月三十日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、" +
				"元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Cheung Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Cheung Ancestral Hall, also known as Wah Fung Tong, was mainly built by Cheung Nam-yat, " +
				"Cheung Shui-yat Cheung Chi-kwong and Cheung Yiu-fong of the 22nd generation of the Cheung clan of Shan Ha Tsuen, Yuen Long in the " +
				"20th year of Jiaqing reign (1815), Qing dynasty.The ancestral hall then served as a centre for communal gatherings and ancestral worship." +
				"The Cheung clan attached great importance to the education of their children. A number of study halls were built in Shan Ha Tsuen for " +
				"educating both boys and girls. The Cheung Ancestral Hall was also used as Wah Fung School between the 1930s and 1950s until the school was " +
				"relocated to a new school building near Lam Hau Tsuen in 1958.The Cheung Ancestral Hall is a traditional two-hall grey brick structure with an " +
				"open courtyard in between. The two side chambers between the two halls were used as kitchen and storage space respectively. An altar is installed" +
				"at the rear hall where ancestral tablets are placed. At the top shelf of the altar is the soul tablet of Cheung Gau-ling, a prime minister of the Tang dynasty," +
				" who is commonly recognized by the Cheung clan of both Shan Ha Tsuen and Dongguan as the pioneer ancestor. Combining splendour with solemnity, the altar is " +
				"elaborately decorated with fine wood carvings of “The Eight Immortals”, which reflect the superb craftsmanship of the old days.Major restoration of the " +
				"Cheung Ancestral Hall was carried out in 1999 and was under the supervision of the Architectural Services Department and the Antiquities and Monuments Office. " +
				"The Cheung Ancestral Hall was declared a monument on 30 December 1999.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. Closed on Tuesdays, Christmas Day, " +
				"Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.432332");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.017523");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Shan Ha Tsuen, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗山廈村");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "長山古寺"); //data9
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("66"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("66"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "長山古寺位於禾徑山廟徑，原稱「長生庵」，約於一七八九年由打鼓嶺區的萊洞、" +
				"萬屋邊和坪源合鄉約(包括坪洋、瓦窰下、禾徑山及坪輋)六條村落共同興建。廟內供奉佛祖、觀音及地藏王。廟徑過去曾是旅客經沙頭角前往深圳的必經之路，" +
				"因此長山古寺亦一度作為旅客中途歇腳的地方，供應茶水之類的服務。據廟內木匾額所記，現存兩進式的結構相信是同治七年(一八六八年)重建而成。" +
				"該廟於一九九八年被列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Cheung Shan Monastery");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Situated at Miu Keng in Ping Che, this Monastery was formerly called Cheung Sang Nunnery, " +
				"and was probably first constructed in 1789 as a joint effort of six villages in Ta Kwu Ling area, namely Loi Tung, Man Uk Pin, and the " +
				"alliance of Ping Yuen Hap Heung which consisted of Ping Yeung, Nga Yui Ha, Wo Keng Shan and Ping Che. The Buddha, " +
				"Kwun Yum and Tei Chong Wong (a Bodhisattva) were all worshipped in the temple.Since Miu Keng was a halfway point " +
				"of the route to Shenzhen via Sha Tau Kok in the past, the temple was once a resting place to provide services, " +
				"including free tea to wayfarers.The existing two - hall structure was believed to have been fully rebuilt in the " +
				"7th year of Tongzhi reign (1868), as recorded in a wooden plaque inside the temple. The temple was declared a monument in 1998.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. Closed on Christmas Day, Boxing Day, " +
				"New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.529455");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.175649");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Che, Fanling");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "粉嶺坪輋");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "植桂書室"); //data10
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("82"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("82"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "植桂書室建於一八九九年以前，由聚居於八鄉的黎氏族人黎金泰所建，屬香港典型的中國傳統書室。" +
				"黎族早於數百年前已在八鄉一帶定居，據族譜所載，黎族二世祖黎忠卿於宋朝期間從江西遷往廣東新會，及後族人曾於東莞和錦田一帶定居，" +
				"明朝期間由十三世祖黎會雲率族人於現時的上村開基立村。植桂書室同時作祭祀祖先和教育村中子弟用途。書室曾於二次世界大戰時關閉，" +
				"戰後用作永慶學校的臨時課室，為學生提供現代教育，其後改作植桂幼稚園，至 一九七Ｏ年代初停辦。植桂書室屬兩進一天井的清代傳統建築。" +
				"書室正面以花崗石塊和青磚築砌，屋頂簷下是雕刻精美的斗拱、駝峰和花崗石柱。前進屋脊飾有以「鯉躍龍門」為題的灰塑，" +
				"另書室內的駝峰和封簷板皆刻有中國傳統的民間故事和吉祥圖案，雕刻巧手精緻。書室後進明間置有精美的木製神龕，供奉黎氏歷代祖先神位。" +
				"書室的獨特之處是保存了大量原有的建築構件，例如建築物內外的精美木雕、屋脊和山牆上生動的灰塑，以及書室栩栩如生的壁畫，" +
				"據說皆自書室建成後一直未有重新上彩或翻新，這使植桂書室成為元朗區現存最具文物價值的傳統書室之一。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Chik Kwai Study Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Chik Kwai Study Hall, a typical traditional Chinese study hall in Hong Kong, " +
				"was built before 1899 by Lai Kam Tai of the Lai clan in Pat Heung, which had settled in the Pat Heung area for " +
				"hundreds of years. According to the genealogy of the clan, the second generation ancestor, Lai Chung Hing migrated " +
				"from Jianxi to Xinhui, Guangdong in the Song dynasty. Clansmen later settled in the Dongguan and Kam Tin areas. " +
				"During the Ming dynasty, the thirteenth generation ancestor, Lai Wui Wun, led his clansmen to settle in the " +
				"present Sheung Tsuen. Chik Kwai Study Hall was used for both ancestor worship and educating young clansmen. " +
				"The Study Hall, which ceased operation during the Second World War, was used afterwards as the temporary " +
				"classrooms of Wing Hing School, a school offering modern education. The Study Hall was later used as Chik Kwai " +
				"Kindergarten, which was closed in the early 1970s.Chik Kwai Study Hall is a typical example of traditional " +
				"two-hall-one-courtyard building of the Qing dynasty. The impressive facade of the green-brick study hall is " +
				"distinguished by the solemn granite-block wall base and the overhanging roof supported by ornamental brackets, " +
				"camel humps and granite columns. The roof ridge of the entrance hall is decorated with polychrome mouldings " +
				"depicting the theme of 'carp jumps over the dragon gate'. Internally, all the exquisitely craved camel " +
						"humps and eaves boards are devoted to the themes of traditional Chinese folk stories and auspicious motifs. " +
						"A beautifully crafted wooden altar is placed at the main hall of the Study Hall for accommodating the " +
						"soul tablets of the clan ancestors. The Chik Kwai Study Hall is exceptional due to the well-preserved " +
						"architectural components of the building. Examples include the ornate woodcarvings throughout the building," +
						" the lively decorative plaster mouldings on the roof ridges and gable walls, and the vivid traditional " +
						"Chinese murals, which are all said not to have been repainted or refurbished since the " +
						"construction of the Study Hall. Such features make it one of the finest examples of traditional " +
						"Chinese study halls that still survive in Yuen Long.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am - 1:00pm & 2:00pm - 5:00pm daily. Closed on Tuesdays, Christmas Day, Boxing Day, " +
				"New Year’s Day and the first 3 days of the Lunar New Year");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.433244");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.101416");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Sheung Tsuen, Pat Heung, Yuen Long, New Territories");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "新界元朗八鄉上村");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "都爹利街石階及煤氣路燈"); //data11
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("08"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("08"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "中環都爹利街的石階約建於一八七五至一八八九年間。四座煤氣路燈置於石階兩端的欄杆上，" +
				"是本港僅存的煤氣路燈，現仍由原為本港提供街道照明而開辦的香港中華煤氣公司繼續操作。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Duddell Street Steps and Gas Lamps");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The stone steps at Duddell Street, Central were built between 1875 and 1889. " +
				"Four gas lamps surmounting the balustrades at the top and foot of the steps are the only surviving working gas " +
				"street lamps in Hong Kong. The Hong Kong and China Gas Company which was originally founded to provide street " +
				"lighting in Hong Kong continues to operate the lamps as objects of historical interest.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.279874");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.156724");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Duddell Street, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環都爹利街");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "覲龍圍圍牆及更樓"); //data12
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("48"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("48"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "覲龍圍門樓公告為古蹟後數年，圍村司理進一步同意將該村的圍牆及四角更樓列為古蹟。" +
				"當時圍牆及更樓部分已倒塌，修繕工程由政府資助，於一九九四年完成。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Enclosing Walls and Corner Watch Towers of Kun Lung Wai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Some years after the declaration of the gate house of Kun Lung Wai as a monument, " +
				"the managers of the walled village further agreed to the protection of the enclosing walls and corner watch " +
				"towers under the Antiquities and Monuments Ordinance. The walls and watch towers were then in a dilapidated " +
				"condition, which were subsequently fully restored in 1994 with funding from the Government.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.507235");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.148452");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Kun Lung Wai (San Wai), Lung Yeuk Tau, Fanling");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "粉嶺龍躍頭覲龍圍（新圍）");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "老圍門樓及圍牆"); //data13
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("64"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("64"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "龍躍頭鄧族於十三世紀由錦田移居此區，先後建立了「五圍六村」老圍便是五圍中最早建立的圍村。" +
				"老圍四周築有圍牆。原先的圍門是北向，但由於風水理由，圍門被改建為東向。老圍雖曾經歷多次改建，但其原本的圍牆結構和圍村布局仍保存得頗為完整。" +
				"老圍部分圍牆於一九九一年由北區政務處撥款維修。老圍門樓及圍牆於一九九七年一月三十一日被列為法定古蹟，同年年初隨即展開全面修復工程，" +
				"工程由古物古蹟辦事處及建築署古蹟復修組監督，於翌年完成。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午五時。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Entrance Tower & Enclosing Walls of Lo Wai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Lo Wai is the first built of the five renowned walled villages " +
				"in Lung Yeuk Tau, Fanling established by the Tang clan whose ancestors branched out from the main Tang settlement " +
				"in Kam Tin in the 13th century. The Tangs since then established eleven villages in the area, known as 'Five Wais " +
				"(Walled villages) and Six Tsuens (Villages)'.Lo Wai is a village enclosed by brick walls on four sides. " +
				"The present village entrance tower is not the original one which faced the north but was relocated towards " +
				"the east in order to achieve better fung shui. Although the wai has undergone changes with the entrance tower " +
				"relocated, most of the original village wall and the layout of the village still exist.Repairs to a portion of the " +
				"wall was undertaken in 1991 with funds provided by the North District Office. " +
				"The entrance tower and enclosing walls of Lo Wai were declared a monument on 31 January 1997. " +
				"Full restoration works were completed in 1998.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 5:00pm daily.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.497848");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.15181");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Lung Yeuk Tau, Fanling");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "粉嶺龍躍頭老圍");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "麻笏圍門樓"); //data14
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("50"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("50"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "麻笏圍於清乾隆年間（一七三六至一七九五年）由鄧氏族人所建，是龍躍頭著名的五圍六村之一。" +
				"龍躍頭鄧族由錦田鄧族分支而來，據鄧族族譜記載，龍躍頭先祖乃南宋皇姑的長子，因此皇姑的神位仍供奉於龍躍頭主祠松嶺鄧公祠之內。麻笏圍原本四周建有磚牆，" +
				"四角則建有更樓，但現時大部分圍牆及四個更樓已遭拆卸，只留下這極具歷史價值之門樓。門樓上刻有「鬱」字樣，寓意春生長茂盛之地。" +
				"門樓於一九九四年被列為法定古蹟，由政府斥資重修。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Entrance Tower of Ma Wat Wai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Ma Wat Wai was built by the Tang lineage during the Qianlong reign (1736-1795) of the Qing Dynasty. " +
				"It is one of the renowned Five Wais (walled villages) and Six Tsuens (villages) in the area of Lung Yeuk Tau in Fanling." +
				" The Tang lineage in Lung Yeuk Tau branched out from the main clan in Kam Tin. According to the genealogy of the " +
				"Tang clan, the founding ancestor of Lung Yeuk Tau lineage was the eldest son of Wong Koo (a Southern Song princess), " +
				"which explains why the soul tablet of Wong Koo is still worshipped in the Tang Chung Ling Ancestral Hall, the main " +
				"ancestral hall of Lung Yeuk Tau. Ma Wat Wai was originally a walled village with brick walls constructed on the " +
				"four sides and a watch tower on each corner. However owing to past developments, most of the walls and all four " +
				"corner towers were demolished leaving only this very historic entrance tower. A stone tablet engraved with two " +
				"Chinese characters denoting a place with flourishing growth of spring onions was embedded at the facade of " +
				"the entrance tower. The entrance tower was declared a monument in 1994 and was fully restored with funds " +
				"from the Government.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.499751");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.149874");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ma Wat Wai, Lung Yeuk Tau, Fanling ");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "粉嶺龍躍頭麻笏圍");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "分流炮台"); //data15
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("11"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("11"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "分流炮台位於大嶼山西南端，俯瞰來往珠江的航道。《澳門記略》載雍正七年(一七二九年)時大嶼山「兩山各設炮台」，" +
				"分流炮台該為其中之一。炮台長約四十六米，闊二十一米，牆身以花崗石及青磚疊砌而成。炮台曾遭海盜所據，及至一八一〇年間，海盜先後向清廷投降，炮台才再恢復戍守。" +
				"估計至一八九八年新界租借予英國後，炮台才正式棄置。炮台在一九八五年完成初步修繕工程，一九九〇年再進行大規模修葺，並改善附近的環境與設施。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Fan Lau Fort");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Fan Lau Fort is located at the south-western tip of Lantau, overlooking a sea passage " +
				"leading into the Pearl River Estuary. According to the Macau Gazetteer, the fort can be dated reliably to the 7th year of Yongzheng (1729), " +
				"when it was recorded that two forts were constructed on Lantau. Fan Lau Fort was apparently one of them. Rectangular in shape, the " +
				"fort measures 46m by 21m and its walls are built of semi-dressed stone and green bricks. It was believed that the fort was once occupied " +
				"by pirates. However, after the surrender of pirates to the Qing government in 1810, the fort would have been retaken by government troops. " +
				"It was probably abandoned around 1898 after the lease of the New Territories to Britain.Initial restoration work was undertaken in early 1985. " +
				"This was followed by a large scale restoration and repair project in 1990 which also provided for the clearance of the surrounding area.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.197995");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.853761");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Fan Lau, Lantau Island");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "大嶼山分流");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);  
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "樊仙宮"); //data16
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("69"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("69"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "樊仙宮(又名樊仙廟)位於大埔上碗，已於一九九九年十二月三十日列為法定古蹟。樊仙宮是上碗窰村和下碗窰村的主要廟宇，" +
				"也是唯一在本港現存的該類廟宇，其建築日期已無從稽考，懸掛在正廳的木牌匾為清朝乾隆庚戌年間(一七九〇年)的雕刻，故相信該廟已有超過二百年歷史。" +
				"一般相信樊仙宮由馬氏宗族興建，以供奉陶匠的守護樊仙大師。樊仙宮的建築既簡單又實用，而大門的裝飾卻巧奪天工，可是，一九七〇年代中期的一場嚴重火災破壞" +
				"了很多歷史遺蹟。自從大火發生後，大門上的書法和繪畫曾於一九七六年整修時重新髹上，至於廟內四壁的窗門連鐵框，則於第二次世界大戰後才裝上。" +
				"廟內仍保留一七九〇年的木牌匾和因修繕工程而分別於一八九七、一九二五、一九六四及一九七六年而設置的紀念碑石。樊仙宮的修繕工作已經完成並開放予市民參觀。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. Closed on Tuesdays, " +
				"Christmas Day, Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.441019");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.163715");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Sheung Wun Yiu, Tai Po");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "大埔上碗");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊三軍司令官邸"); //data17
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("36"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("36"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "中區紅棉路的舊三軍司令官邸是本港現存歷史最悠久的西式建築。這座大樓建於一八四六年，" +
				"原名「司令總部大樓」，為德己立少將而建。約於一九三二年易名為「旗杆屋」。大樓至一九七八年前一直是三軍司令的官邸。現已用作茶具文物館，" +
				"展出有關茶藝的文物資料。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午十時至下午六時。聖誕前夕及農曆新年除夕提前於下午五時休館。" +
				" 逢星期二（公眾假期除外）、農曆新年年初一及初二休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Flagstaff House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Flagstaff House in Hong Kong Park Central is the oldest existing " +
				"Western building in Hong Kong. Built in 1846 for Major General George Charles D'Aguilar, it was formerly known as " +
				"Headquarters House. The building was renamed Flagstaff House around 1932 and remained the office and residence " +
				"of the Commander of British Forces until 1978. It now houses the Museum of Tea Ware displaying " +
				"Chinese teaware and related material of different periods.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "10:00am – 6:00pm daily. Closed at 5:00pm on Christmas Eve and Lunar New Year's Eve " +
				"Closed on Tuesday (except Public Holidays) and on the first two days of Lunar New Year");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.281949");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.16217");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Cotton Tree Drive, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環紅棉路");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前中央裁判司署"); //data18
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("54"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("54"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "中央裁判司署於一九一三年動工興建，翌年落成。原址為另一所可能建於一八四七年的裁判司署，" +
				"後來被拆卸，以便興建現時之中央裁判司署。因為要建造大型的地下室，裁判司署之建築工程因而受到拖延。整座建築物十分雄偉，正面採用希臘復興式建築，" +
				"建有宏偉的石柱，護土牆則以花崗岩砌築而成。裁判司署於一九七九年遷出，建築物曾為警察附屬之組織所使用。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Central Magistracy");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The construction of the Central Magistracy commenced in 1913 and was completed in 1914. " +
				"The site was originally occupied by the first Hong Kong Magistracy which was probably erected in 1847 but was later demolished to make " +
				"way for the present building. The provision of an extensive basement in the new magistracy caused much difficulty and delay in the construction work." +
				" The building has a majestic appearance with imposing pillars of the facade and other features in the Greek-revival style. " +
				"The massive retaining walls were constructed with granite blocks. The Central Magistracy was closed in 1979 and had been used by " +
				"different associations affiliated to the Police.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.285284");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.155132");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "1 Arbuthnot Road, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環亞畢諾道一號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前法國外方傳道會大樓"); //data19
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("37"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("37"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "前法國外方傳道會大樓坐落於中環炮台里，建於一九一七年，前身是昔日的「拱北樓」。" +
				"大樓樓高三層，而北隅建有一座圓頂的小教堂，整座建築以花崗石和紅磚蓋成，屬新古典風格。大樓曾先後用作教育署總部、維多利亞地方法院、" +
				"最高法院及政府新聞處。大樓現用作香港終審法院。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former French Mission Building");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The former French Mission Building on Battery Path, Central, " +
				"was built in 1917 on the foundation of a previous structure. A chapel is incorporated in the north-west " +
				"corner with its cupola projecting above the roof. The three-storey building is constructed in granite and " +
				"red bricks in neo-classical style. It was occupied successively by the Education Department, the " +
				"Victoria District Court, the Supreme Court, and the Information Services Department. " +
				"It is now used as the Hong Kong Court of Final Appeal.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.283061");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.159424");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "1 Battery Path, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環炮台里一號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前九龍英童學校"); //data20
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("45"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("45"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "前九龍英童學校是本港現存最古舊的英童學校建築。何東先生（後晉封爵士）" +
				"一九〇〇年捐贈一萬五千元資助港府於九龍半島興建新校，學校於一九〇二年四月十九日正式開幕。校舍為典型維多利亞時代建築，" +
				"但亦因應本港氣候環境，建有寬闊游廊，高樓面及金字瓦頂等。重修後，闢作古物古蹟辦事處辦公地方。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午六時");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Kowloon British School");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "This is the oldest surviving school building constructed " +
				"for foreign residents living in Hong Kong. In 1900, Mr. Ho Tung (later Sir Robert) donated $15,000 to " +
				"the Government to erect a school in Kowloon. The building was officially opened on 19 April 1902. " +
				"It is a typical Victorian structure, but was modified to adapt to local climatic conditions by adding " +
				"wide verandas, high ceilings and pitched roofs. After proper restoration, it houses the " +
				"Antiquities and Monuments Office.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00 a.m. - 6:00 p.m. daily");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.305297");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.172298");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "136 Nathan Road, Tsim Sha Tsui ");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "尖沙咀彌敦道一百三十六號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "油尖旺");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yau Tsim Mong");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前九廣鐵路鐘樓"); //data21
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("43"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("43"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "九廣鐵路英段於一九一〇年十月一日通車。尖沙咀火車站興建工程於一九一三年展開。" +
				"一九一五年鐘樓建成。火車總站於一九七八年拆卸，只留下鐘樓，成為本港的標記。鐘樓高四十四米，樓頂裝有七米高的避雷針。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Kowloon-Canton Railway Clock Tower");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Hong Kong Section of the Kowloon-Canton Railway was opened for traffic " +
				"on 1 October 1910. The construction of a terminus in Tsim Sha Tsui started in 1913 and the clock tower was completed " +
				"in 1915 to form part of the complex. The main terminus building was demolished in 1978 leaving only the clock tower " +
				"which has become a landmark of Hong Kong. The clock tower is 44m high surmounted by a 7m lightning rod.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.296879");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.169552");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Tsim Sha Tsui");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "尖沙咀");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "油尖旺");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yau Tsim Mong");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前水警總部"); //data22
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("51"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("51"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "前水警總部建於一八八四年，整組建築包括主樓、馬廄及報時塔（俗稱圓屋）。" +
				"除日佔期間(一九四一至一九四五年)曾用作日本海軍基地外，至一九九六年為止，一直為水警所用。主樓本為一所兩層高建築，" +
				"後於一九二〇年代加建一層，主樓東南及東西兩翼為已婚職員宿舍。日佔期間於水警總部前草地下建有大規模地下通道。二次大戰後，" +
				"為安全起見，封閉地下通道，及重鋪草地。報時塔可謂整座水警總部最具特色之建築，為海港船隻報時。其作用於一九〇七年大包米的訊號塔落成啟用後而消失。" +
				"前水警總部為現存最古老的政府建築之一。於一九九四年被列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Marine Police Headquarters Compound");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The former Marine Police Headquarters was constructed in 1884, " +
				"comprises a main building, a stable block and signal tower (commonly known as Round House)." +
				" The compound has been occupied by the Marine Police since its establishment until 1996, " +
				"except for the Japanese Occupation (1941-1945) when it was used as a base by the Japanese navy. " +
				"The main building was originally a two-storey structure to which was added an extra storey in the 1920s. " +
				"The south-east and south-west wings of the main building served as married quarters. " +
				"During the Japanese Occupation Period, extensive underground tunnels were constructed beneath the lawn " +
				"but after World War II, in view of public safety, these tunnels were blocked and the lawn was re-turfed. " +
				"The Signal Tower is the most unique building within the compound and was constructed to provide time " +
				"signals to ships in the harbour. Its use diminished in 1907 when the time ball apparatus was removed to " +
				"Signal Hill. Being one of the oldest surviving government buildings in Hong Kong, the former Marine " +
				"Police Headquarters Compound was declared a monument in 1994.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.299261");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.169037");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "2A Canton Road, Tsim Sha Tsui, Kowloon ");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "九龍尖沙咀廣東道2號A");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "油尖旺");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yau Tsim Mong");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前九龍寨城衙門"); //data23
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("63"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("63"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "一八四七年，清廷修建九龍寨城，駐兵數百，以加強海防。寨城衙門，原為九龍司巡檢辦公地方，深三進，" +
				"二進為公堂，後進為官邸。自一八九九年清朝官兵撤離寨城後，衙門曾被不同的教會團體租用，先後作老人院、孤兒寡婦所、學校、醫務所等用途。" +
				"一九八七年政府宣布清拆寨城，於原址興建公園，衙門得以保留並全面復修，成為公園內的重要古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午六時半至下午十一時。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Former Yamen Building of Kowloon Walled City");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Kowloon Walled City was orginally a garrison town built by " +
				"the Qing government in 1847 as a military outpost occupied by several hundred soldiers to reinforce the " +
				"coastal defence of the region. The Yamen building was originally the administrative office of the " +
				"Assistant Magistrate of Kowloon. The building is a three-hall structure. The middle hall was the office " +
				"while the rear block served as the officer's residence. After the departure of the Qing officials in 1899, " +
				"the Yamen building was used by different religious groups including a home for the aged, home for widows " +
				"and orphans, school and clinic. In 1996 the Yamen was preserved and restored to remind the people of its " +
				"historical past.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "6:30am – 11:00pm daily.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.335627");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.190323");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Kowloon Walled City Park, Kowloon City");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "九龍城九龍寨城公園");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "九龍城");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Kowloon City");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "下白泥55號碉堡"); //data24
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("99"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("99"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "位於元朗下白泥55號的碉堡約建於一九一Ｏ年，是香港唯一有確實證據證明與孫中山先生" +
				"（一八六六至一九二五年）及其革命黨人領導的革命運動有直接關係的建築物。元朗下白泥55號俯瞰后海灣和深圳，處有利位置，因此成為革命活動基地。" +
				"一九一Ｏ左右，廣州新軍之役結束後，革命人士於該址建立藏身之處，並以稻米磨坊和煉糖廠作掩護。碉堡亦用以監視后海灣對岸屬清廷管轄的地方。" +
				"碉堡由興中會的骨幹分子鄧蔭南先生（一八四六至一九二三年）所建。碉堡附近的土地曾經主要由李紀堂先生（一八七三至一九四三年）所擁有。" +
				"李紀堂先生於一九ＯＯ年加入興中會，是富商李陞先生（一八三Ｏ至一九ＯＯ年）之子。在建築方面來說，下白泥碉堡是一座以實用為主的構築物，" +
				"主要作監視用途。碉堡樓高兩層，為一長方形構築物，以青磚修築而成。一樓與天台之間設有閣樓，天台建有伸出的梯間結構。外牆上下各處仍有槍眼。" +
				"內部房間設計簡單，以砂漿鋪地。為了達到防禦的目的，碉堡設有錐形凹入式窗口，令該建築物從裏面外望的視野更為廣闊。古物古蹟辦事處已於碉堡附近安放展示設施，" +
				"以介紹該古蹟的歷史。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Fortified Structure at No. 55 Ha Pak Nai");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Built around 1910, the fortified structure at No. 55 Ha Pak Nai, " +
				"Yuen Long is the only remaining building in Hong Kong with solid evidence of having direct connection with " +
				"the revolutionary movement under the leadership of Dr. Sun Yat-sen (1866-1925) and his compatriots. With its advantageous " +
				"location overlooking Deep Bay and Shenzhen, No. 55 Ha Pak Nai was an operational base of the revolutionary movement.  " +
				"A place of refuge for the revolutionaries under the cover of a rice mill and sugar refinery was set up around 1910 at " +
				"the site after the Mutiny of the New Army in Guangzhou.  A fortified structure was also built at the site to keep watch on " +
				"the area across Deep Bay, which was then under the administration of the Qing authority.  The fortified structure was built by " +
				"Mr. Tang Yam-nam (1846-1923), who was a core member of Hsing Chung Hui (Xing Zhong Hui, 興中會).  " +
				"The land adjacent to the fortified structure was mainly owned by Mr. Li Ki-tong (1873-1943) who joined Hsing Chung Hui " +
				"in 1900 and was a son of the wealthy businessman Mr. Li Sing (1830-1900). Architecturally, the fortified structure " +
				"in Ha Pak Nai is essentially a functional structure for surveillance.  It is a two-storey rectangular structure built of grey bricks, " +
				"with a mezzanine floor between the first floor and the roof. A staircase bulkhead is found on the flat roof. Gun loops at " +
				"various levels on the elevations can still be found.  Internally, the plain rooms have screeded floors. To serve defence purposes, " +
				"tapered and recessed window openings allowed a greater viewing angle from the inside of the building.The Antiquities and Monuments Office " +
				"has provided display facilities near the fortified structure to introduce the history of the monument.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.424755");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.940913");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Fortified Structure at No. 55 Ha Pak Nai, Yuen Long, New Territories");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "新界元朗下白泥55號碉堡");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊總督山頂別墅守衛室"); //data25
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("52"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("52"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "這座建築物原本是總督山頂別墅守衛室，於一九〇〇至一九〇二年間興建。" +
				"山頂別墅採用蘇格蘭大宅建築特色，被當時傳媒形容為山頂區最宏偉及壯觀之建築。守衛室則採用文藝復興建築風格，與山頂別墅迴然不同。" +
				"山頂別墅於一九四六年拆卸，只剩下這所守衛室。守衛室雖然面積不大，但建築規格嚴謹。守衛室於一九九五年被列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Gate Lodge of the Former Mountain Lodge");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Gate Lodge originally served as living quarters for the keeper of Mountain Lodge, " +
				"the summer Peak residence of the Governor. It was built between 1900 and 1902. Mountain Lodge was constructed in " +
				"the style of Scottish lodges and was described by the media as the most imposing and handsome architecture on the peak." +
				" Gate Lodge, however, is in Renaissance style which is a major deviation from Mountain Lodge. " +
				"Mountain Lodge was demolished in 1946, leaving only Gate Lodge. Although Gate Lodge is a small building, " +
				"it was planned in a very functional way. It was declared a monument in 1995.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.277819");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.145691");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "山頂柯士甸山道");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港禮賓府"); //data26
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("59"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("59"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "香港禮賓府昔日是香港總督的辦公室和官邸。這座建築物的建築工程於一八五一年展開，" +
				"歷時四年完竣。禮賓府建成之初，附近尚未建有現今所見的高樓大廈，故海港景色飽覽無遺。禮賓府原屬英喬治亞時代建築，富有濃厚殖民地色彩。" +
				"建築物曾經歷多次大規模修繕，最後一次工程在一九四二年日佔期間進行。日軍佔領香港期間，把禮賓府用作司令部，並委派日本工程師藤村清一設計一座高塔樓，" +
				"加建於原有兩座建築之間，把兩座建築物連接起來；在屋頂加上日式瓦片，淡化建築物的歐陸風味。這座典雅的建築物現為香港特別行政區行政長官官邸。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Government House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Government House was formerly the office and residence of previous " +
				"Governors of Hong Kong. Construction works started in 1851 and took four years to complete. " +
				"At that time it enjoyed a fine harbour view. It was originally built in the Georgian style and bore rich " +
				"colonial characteristics. It underwent a number of large-scale renovations, with the latest undertaken in 1942, " +
				"during the Japanese Occupation, by a Japanese engineer, Siechi Fujimura, who designed to construct a dominant " +
				"central tower to link the two original buildings; the roofs were also modified to add in more Japanese flavour, " +
				"thus diminishing the strong European style of the mansion. It was then used as the military headquarters for the " +
				"Japanese until 1945. Government House is now the residence for the Chief Executive.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282266");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.156849");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Upper Albert Road, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環上亞厘畢道");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "青洲燈塔建築群"); //data27
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("86"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("86"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "青洲燈塔建築群包括一座建於一八七五年的舊燈塔、一座於一九〇五年興建的新燈塔、一幢前歐籍職員宿舍，" +
				"以及一幢前看守員房舍。數十年來，新舊青洲燈塔為數以萬計從西面進入香港的船隻輔航，在香港海事史上佔有重要的地位。青洲燈塔於一八七五年七月一日啟用，" +
				"時為香港首座燈塔於鶴咀建成後約三個月。一九〇一年，當時有計劃把鶴咀燈塔的訊號燈搬移至青洲。為此，青洲需要建造一座更高更大的塔樓，以容納鶴咀的訊號燈。" +
				"新青洲燈塔建於舊燈塔旁，於一九〇四年動工，翌年竣工。新燈塔建成後，取代了舊燈塔的功能。新燈塔在一九七〇年代已改為全自動操作，一直使用至今。" +
				"舊燈塔是細小的圓柱形燈塔，以花崗石建造，高約十二米，門口沿邊飾以凸出的粗面隅石。燈塔的牆上有兩個「十」字開口，供塔內通風和透光之用。" +
				"這些開口與雕鑿於中古時代歐洲堡壘上的槍眼，十分相似。新燈塔也呈圓柱形，以花崗石和混凝土建造，高十七點五米，頂部裝設一個鋼鑄訊號燈。" +
				"整座構築物均髹上白漆，不但令航海員易於看見，而且又能發揮隔熱功能和保護構築物本身。螺旋型樓梯以磚石鋪砌，工藝精巧，並築有美觀的欄杆。" +
				"入口處和窗戶的頂部，則塑造成平圓拱形，並以灰塑裝飾作為點綴。前歐籍職員宿舍是燈塔建築群不可或缺的部分。該宿舍相信是建於十九世紀末，" +
				"當中不乏充滿古典風格的裝飾構件，例如前門的門廊，以飾有改良式柱頭的支柱作為支撐。建築物原本只是單層樓房，於一九二三年才加建頂層。" +
				"前看守員房舍是一幢單層、平頂而呈「L」形狀的建築物，外牆開有平圓拱窗戶，頂部則建有飛檐。自一九五〇年代起，由本地人員代替歐籍人員執行看守燈塔的工作，" +
				"到了一九七〇年代，看守燈塔的工作更由自動化設備所取代。該兩座宿舍建築物曾一度改建為警察康樂中心。現時，青洲燈塔的前職員宿舍、" +
				"前看守員房舍連同四周範圍（不包括兩座燈塔）均租予基督教互愛中心作為青少年戒毒治療及康復中心之用。舊和新青洲燈塔是香港現存五座戰前燈塔的其中兩座。" +
				"至於其餘三座，位於橫瀾島和燈籠洲的燈塔已於二〇〇〇年根據《古物及古蹟條例》列為法定古蹟，位於鶴咀的則於二〇〇六年列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "此燈塔建築群現為海事處(新青洲燈塔)及政府產業署管理，並用作戒毒治療中心。 基於保安理由及避免影響日常運作，建築群並不對外開放。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Green Island Lighthouse Compound");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Green Island lighthouse compound comprises an old lighthouse " +
				"built in 1875, a new lighthouse built in 1905, a former European quarters and a former keeper’s house. " +
				"Both the old and the new Green Island lighthouses have served thousands of vessels from the west approach " +
				"to Hong Kong for many decades and have played an important role in Hong Kong’s maritime history." +
				"The Green Island lighthouse started operation on July 1, 1875, about three months after Hong Kong’s first " +
				"lighthouse was set up at Cape D’Aguilar. In 1901, there was a plan to move the lantern of Cape D’Aguilar " +
				"lighthouse to Green Island. As such, a higher and larger tower to accommodate the Cape D’Aguilar light was necessary." +
				"The construction of a new lighthouse adjacent to the old one on Green Island commenced in 1904 and was completed " +
				"in 1905. Upon the completion of the new lighthouse, the old lighthouse has since then lost its original function. " +
				"The new lighthouse was fully automated in the 1970s and is still in use." +
				"The old lighthouse is a 12-metre high small circular tower constructed of granite. Its doorway features" +
				"projected rock-faced quoins. There are two cross-shaped openings on its wall for ventilation and lighting inside. " +
				"The openings resemble gun-posts like those found in mediaeval European castles." +
				"The new lighthouse is also a circular tower. Constructed of granite and concrete, " +
				"it is about 17.5 metres high with a steel lantern on top. The whole structure is painted " +
				"white for high visibility to mariners, thermal insulation and protection to the structure itself. " +
				"The spiral staircase is of fine masonry with beautiful railings while the entrance and window are in the " +
				"form of segmental arches with ornamental plaster mouldings.The former European staff quarters, probably " +
				"built in the late 19th century, forms an integral part of the lighthouse compound. classical features " +
				"such as the front porch supported by columns with modified capitals can be found in the building. " +
				"The quarters was originally a single-storey building but an upper floor was added in 1923." +
				"The former keeper’s house is a one-story flat-roofed block in simple L-shape, featuring segmental " +
				"arched windows and overhanging eaves.From the 1950s, local staff started to replace Europeans as the " +
				"light-keepers in Hong Kong. However, their duties were replaced by automatic operational devices in the 1970s. " +
				"The two lighthouse staff quarters were once converted and used as the Police Recreation Centre. " +
				"At present, the former quarters, the former keeper’s house together with the surrounding area " +
				"(except the two lighthouses) are leased to the Wu Oi Christian Centre as a drug treatment and " +
				"rehabilitation centre for youth.The old and new Green Island lighthouses are two of the " +
				"five surviving pre-war lighthouses in Hong Kong. For the other three lighthouses, the two on " +
				"Waglan Island and Tang Lung Chau were declared monuments under the Antiquities and Monuments Ordinance " +
				"in 2000 while the one at Cape D’Aguilar in 2006.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "This lighthouse compound is managed by the Marine Department (New Green Island Lighthouse) " +
				"and the Government Property Agency and reused as a drug treatment and rehabilitation centre. " +
				"For security and operational reasons, the complex is not open to the public.");
//		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.370714");
//		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.112917");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.283473");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.111243");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Green Island");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "青洲");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "居石侯公祠"); //data28
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("78"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("78"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "河上鄉居石侯公祠始建於明朝末年，據侯氏族譜所載，該祠為侯族十七世祖侯居石所建。" +
				"從懸於正門的牌匾年份推斷，居石侯公祠曾於清乾隆二十七年（公元一七六二年）進行修繕。居石侯公祠是傳統的三進兩院式建築。前院兩旁建有廂房，" +
				"中進設有供奉歷代祖先神位的神龕。後進樓高兩層，曾用作村校，一樓為課室，地下為老師寢室，學校已於二次大戰時停辦。現時，" +
				"居石侯公祠仍是村民祭祖和舉行傳統儀式的場所，也是侯族日常聚會議事的地方。居石侯公祠正面的鼓台與門框均以紅砂岩建造，" +
				"紅砂岩是傳統用於重要建築物的貴重材料。祠堂的屋脊飾有精緻的灰塑裝飾，建築物內外的駝峰、檐板及繫樑所雕刻的吉祥圖案及民間故事，也極為細緻華美。 " +
				"居石侯公祠於二ＯＯ三年十二月十九日列為法定古蹟，受《古物及古蹟條例》保護。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hau Ku Shek Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Hau Ku Shek Ancestral Hall in Ho Sheung Heung was built in the " +
				"late Ming Dynasty (1368 – 1644). According to the genealogy of the Hau clan, the Ancestral Hall was constructed " +
				"by Hau Ku Shek, the 17th generation ancestor of the Hau clan. The date inscribed on the name board hanging over " +
				"the main entrance suggests that the Ancestral Hall underwent renovation around the 27th year of the Qianlong " +
				"reign (1762) during the Qing Dynasty (1644 – 1911). The layout of the Ancestral Hall is of the traditional " +
				"three-hall-two-courtyard style. There are side chambers at both sides of the front courtyard, while an alter is " +
				"erected in the middle hall for housing ancestral tablets. The two-storey rear hall was used as a village school, " +
				"with the ground floor providing accommodation for teachers and the upper floor being classrooms. The school was " +
				"closed during the Second World War. Nowadays, the Hau Ku Shek Ancestral Hall is still used by the clansmen for " +
				"worshipping ancestors and holding traditional ceremonies. It is also a gathering and meeting place for the locals. " +
				"The drum-platforms and doorframe at the facade of the Hau Ku Shek Ancestral Hall are constructed of red sandstone, " +
				"traditionally a precious building material for important buildings. Its roof ridges are richly embellished. " +
				"The camel’s humps, eaves boards and tie beam of the Ancestral Hall are also decorated with exquisite carvings of " +
				"auspicious motifs. The Hau Ku Shek Ancestral Hall was declared a monument on 19 December 2003 and is protected " +
				"under the Antiquities and Monuments Ordinance.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. " +
				"Closed on Tuesdays, Christmas Day, Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.509593");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.107843");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ho Sheung Heung, Sheung Shui");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "上水河上鄉");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港天文台"); //data29
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("24"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("24"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "香港天文台建於一八八三年，坐落於九龍一小山丘上，為一殖民地式建築。" +
				"一九一二年正式命名為皇家香港天文台。天文台樓高兩層，呈長方形，外牆經過粉飾，拱形窗和長廊別具特色。隨著附近之新大樓落成，" +
				"天文台各技術及職務部門已遷往新廈。不過，舊大樓仍為台長辦公室及行政中心。隨著一九九七年七月一日香港主權回歸中國，復稱「香港天文台」。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hong Kong Observatory");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Hong Kong Observatory was established in 1883 and was " +
				"built on a small hill in Kowloon. Built in the colonial style, it is a rectangular two-storey plastered " +
				"brick structure characterised by arched windows and long verandas. The technical and operational units " +
				"of the Observatory have been moved to new premises nearby, leaving the old building to continue to house " +
				"the office of the directorate and to serve as a centre of administration.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.305932");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.173843");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "134A Nathan Road, Tsim Sha Tsui");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "尖沙咀彌敦道一百三十四號A");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "油尖旺");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yau Tsim Mong");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "滘西洲洪聖古廟"); //data30
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("76"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("76"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "西貢滘西洲洪聖古廟是典型的鄉村廟宇建築。由於滘西村居民以捕魚為生，" +
				"故集資籌建廟宇供奉海神洪聖以保平安。根據村民傳說及從古廟的碑記推測，洪聖古廟在一八八九年以前便已建成，一直以來是滘西洲的地區廟宇，" +
				"不僅供漁民祈福求安，也有團結地方社群的社會功能。西貢居民在每年洪聖誕均會在滘西洲洪聖古廟及其鄰近空地舉行大型的慶祝活動。" +
				"洪聖古廟為兩進三開間建築，門廳置有擋中。正殿神壇供奉洪聖、財帛星君及水仙爺。該廟最近一次的修復工程於一九九九年進行，獲香港賽馬會資助。" +
				"工程以恢復古廟原貌為原則，在古物古蹟辦事處的監督下，於二〇〇〇年竣工。在當地村民全力支持及積極參與下，" +
				"是項修復工程榮獲聯合國教科文組織「亞太區二千年文物古蹟保護獎」傑出項目獎。洪聖古廟於二〇〇二年十一月十五日被列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午六時至下午六時。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Hung Shing Temple, Hau Ku She");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Situated on Kau Sai Chau (Island), Sai Kung, " +
				"Hung Shing Temple is a typical example of a rural temple. The temple was constructed as a result of " +
				"donations from local residents whose livelihood relied mainly on fishing. Hung Shing was a protective " +
				"deity of the sea. According to local legends and the stone tablet at the temple, the building was built " +
				"before 1889. Being a district temple of Kau Sai Chau, it has long been a place in which to pray for " +
				"the safety of fishermen and has the social function of strengthening the coherence of the community. " +
				"Large scale celebrations are held by the locals for the birthday of Hung Shing every year." +
				"Hung Shing Temple is a two-hall, three-bay structure with a dong-chung door in the front hall. " +
				"Altars are placed in the main hall where Hung Shing, Choi Pak Shing Kwan and Shui Sin Yeuh are worshipped." +
				"A recent project sponsored by the Hong Kong Jockey Club, restored the building to its original " +
				"design and this was supervised by the Antiquities and Monuments Office and completed in 2000. " +
				"With the full support and active participation of the local villagers, the restoration project " +
				"was awarded an 'Outstanding Project' in the UNESCO Asia-Pacific Heritage 2000 Awards. " +
				"The temple was declared a monument on 15 November 2002.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "6:00am – 6:00pm daily.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.342614");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.321669");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Kau Sai Chau, Sai Kung");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "西貢滘西洲");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "二聖宮"); //data31
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("61"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("61"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "二聖宮坐落於元朗橫洲，該區為一雜姓村。廟宇大約於康熙五十七年（一七一八年）由村民合資建成，" +
				"以供奉洪聖和車公及發揮守望相助之精神。建築物為一所兩進式青磚建築，內有一天井。建築物雖曾於一九七〇和八〇年代進行修葺工程，" +
				"但大部分原有特色仍保持完好。二聖宮於一九九六年被列為法定古蹟，並進行全面維修，費用由香港賽馬會資助。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午七時至下午五時。逢聖誕日及聖誕翌日休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "I Shing Temple");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "I Shing Temple is situated at the multi-clan village of Wang Chau in Yuen Long. " +
				"The temple was constructed by the villagers around the 57th year of Kangxi (1718) to promote communal spirit. " +
				"It was dedicated to the worship of the two deities, Hung Shing and Che Kung. The building is a two-hall structure " +
				"with an open courtyard in between. Although it underwent renovations in the 1970s and 1980s, most of its original " +
				"features were kept intact. The temple was declared a monument in 1996. Full restoration was carried out in the same " +
				"year with funds from the Hong Kong Jockey Club.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "7:00am – 5:00pm daily.Closed on Christmas Day and Boxing Day.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.454534");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.027763");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Wang Chau, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗橫洲");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "前政務司官邸"); //data32
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("17"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("17"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "前政務司官邸於一九〇五年興建之時，坐落於吐露港一小島元洲仔上，原由一條基堤與陸地連接。" +
				"官邸是兩層高建築，建有游廊，是一座二十世紀初的典型殖民地式建築。建築物原用作當時新界理民官宿舍之用，後改為政務司官邸，" +
				"建築物與新界民政息息相關。現已改用作世界自然(香港)基金會的自然環境保護研究中心。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Island House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "When it was built in 1905, Island House stood on a small islet " +
				"called Yuen Chau Tsai near the head of Tolo Harbours, which was connected to the mainland by a causeway. " +
				"The two-storey plastered building with open verandas is a classic example of the colonial architecture at " +
				"the turn of the century. It was erected as quarters for government officers and was long associated with " +
				"the former New Territories Administration. It is now used by the World Wide Fund for Nature as a " +
				"Conservation Studies Centre.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.445945");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.178743");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Yuen Chau Tsai, Tai Po");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "大埔公路元洲仔");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);

		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "鏡蓉書屋"); //data33
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("44"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("44"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "鏡蓉書屋是少數專為教學用途而建的書室，位於沙頭角上禾坑的客家村內，" +
				"是由該區李姓客家人於清初建成。初期僅是一所供二、三十人就讀的私塾，至乾隆年間（一七三六至一七九五年）始再行重建，改名為鏡蓉書屋。" +
				"由於專供教學之用，所以建築頗為簡單但實用，建築物只有兩個廳堂和閣樓，分別用作課室和宿舍。書屋外形呈長方形，牆身用青磚砌築，" +
				"屋內用未經燒製的泥磚和夯土作間隔。書屋於一九九一年被列為法定古蹟後由政府進行全面修復工程，現已開放供市民參觀。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kang Yung Study Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kang Yung Study Hall is one of the few examples of study halls " +
				"built purely for teaching purposes. Situated in the Hakka village of Sheung Wo Hang in Sha Tau Kok, " +
				"it was built by the Li clan in the early Qing Dynasty. It began as a small private school for 20 to " +
				"30 pupils and was rebuilt in the Qianlong reign (1736-1795) and renamed Kang Yung Study Hall. As it " +
				"was constructed purely for teaching purposes, the architecture is simple but functional. It is a " +
				"two-hall building with cocklofts, providing classrooms and living quarters and comprises a " +
				"rectangular structure of green brick walls, with unfired mud-bricks and rammed earth for internal partitions. " +
				"It was declared a monument in 1991 followed by a full restoration undertaken by the government. " +
				"It is now open to the public.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. Closed on Tuesdays, " +
				"Christmas Day, Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.527859");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.194747");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Sheung Wo Hang, Sha Tau Kok");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "沙頭角上禾坑");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "敬羅家塾"); //data34
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("67"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("67"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "敬羅家塾位於大埔頭村﹐百多年來一直為大埔頭鄧氏宗族的家祠﹐曾作書室之用，" +
				"現仍是族人聚會和舉行傳統節日活動的地方。該建築物的確實建造年分已無從稽考﹐據說是明朝時由第十三代鄧氏族人玄雲、梅溪及念峰公所建﹐" +
				"以紀念他們的第十代先人敬羅公。敬羅家塾於一九九八年八月被列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "King Law Ka Shuk");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King Law Ka Shuk was once used as a study hall, " +
				"but been serving as the ancestral hall of the Tang clan in Tai Po Tau for over one hundred years. " +
				"It still serves as a venue for clan members to hold meetings and traditional functions. " +
				"It is believed that the building was built by the thirteenth generation ancestors Tang Yuen-wan, " +
				"Tang Mui-kei and Tang Nim Fung in the Ming Dynasty to commemorate their tenth generation ancestor " +
				"Tang King-law. King Law Ka Shuk was declared a monument in August 1998.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. Closed on Tuesdays, Christmas Day, " +
				"Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.456369");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.157083");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Tai Po Tau Tsuen, Tai Po");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "大埔大埔頭村");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "景賢里"); //data35
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("85"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("85"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "景賢里是以中國文藝復興風格建造、糅合優秀的中西式建築特色的罕有例子。這種中西結合的風格，" +
				"令該建築物在香港成為一幢罕見、出色的建築藝術品。景賢里原名「禧廬」，約建於一九三七年，首任業主為岑李寶麟女士。岑女士的丈夫岑日初先生是廣東新會" +
				"著名的殷商，樂善好施。大宅由厘份則師樓設計。一九七八年，大宅售予邱氏家族－邱子文先生及其子邱木城先生，邱氏家族把大宅易名為「景賢里」。" +
				"大宅具有標誌著香港歷史發展的重要性。它是散建於港島山邊的歷史豪宅之一，不僅反映當時華人社群在本港地位日高，財富日增，" +
				"也展示高尚住宅區開始在半山區成形的本港早期歷史。大宅的外觀吸引不少遊客前來拍照，是一個受歡迎的景點。它的社會價值也在於其在本港電影文化" +
				"和娛樂工業中所扮演的角色。這幢大宅曾在國際知名的電影中出現，包括《江湖客》（一九五五年）和本地製作的電視劇《京華春夢》（一九八Ｏ年）" +
				"也曾在此取景。這些例子都反映出該址的景致極為優美。大宅於二ＯＯ七年八月售予上任業主。當局在二ＯＯ七年九月初發現該址進行一些工程，以移除屋頂瓦片、" +
				"石製器具及窗框。景賢里的全面修復工程於二ＯＯ八年九月展開，並於二Ｏ一Ｏ年十二月竣工。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "King Yin Lei");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King Yin Lei is a rare surviving example of Chinese Renaissance " +
				"style that reflected the design and construction excellence in both Chinese and Western architecture of Hong Kong. " +
				"The 'East-meets-West' construction methods have made the building a rarity in Hong Kong and an outstanding piece " +
						"of art. Originally named “Hei Lo”, King Yin Lei was built in around 1937 with Mrs. Shum Li Po-lun as " +
						"the first owner. Her husband, Mr. Shum Yat-chor, was a notable merchant and philanthropist in Xinhui of " +
						"Guangdong province. The building was designed by the Office of A.R.F. Raven. It was sold in 1978 to the " +
						"Yow family - Mr. Yeo (Yow) Chei-man and his son Mr. Yow Mok-shing, who renamed the building as 'King Yin Lei'." +
						"The building is important in signifying the historical development of Hong Kong. As one of the luxurious " +
						"historic houses located along the hillside of Hong Kong Island, the building reflects the rising status " +
						"and growing wealth of the Chinese community in Hong Kong. It also represents an earlier phase of Hong " +
						"Kong history when the upper-class residential area took shape in the Mid-Levels. The facade of the building " +
						"has been a popular spot for taking photographs by visitors. The social value of the building also lies in the " +
						"role it played in the film heritage and entertainment industry of Hong Kong. The mansion has been featured " +
						"in films of international renown such as 'Soldier of Fortune' (1955) and a locally produced " +
								"television series 'Delightful Dream of the Capital' (1980). These examples reflect the " +
										"high scenic character of the site. The building was sold to its last owner in August 2007, " +
										"and works to remove the roof tiles, stone features and window frames were noticed on site " +
										"in early September 2007. Full restoration of Kin Yin Lei commenced in September 2008 and " +
										"was completed in December 2010.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.266719");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.180862");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "No. 45 Stubbs Road, Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "香港司徒拔道４５號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "灣仔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Wan Chai");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);  
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "英皇書院"); //data36
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("101"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("101"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "英皇書院於一九二六年落成，是本港現存六幢戰前官立學校校舍之一。" +
				"其餘五幢戰前官立學校校舍包括前九龍英童學校(建於一九ＯＯ至一九Ｏ二年間)、前山頂學校(建於一九一五年)、前魚涌學校(建於一九二六年)、" +
				"長洲官立中學(建於一九二八年)和英皇佐治五世學校(建於一九三六年)。英皇書院前身為政府於一八七九年在第三街興辦的西營盤學校，" +
				"該校其後於一八九一年遷往薄扶林道。現時的般咸道校舍始建於一九二三年，於一九二六年竣工。西營盤學校同年遷至新校舍，並易名為英皇書院。" +
				"當年的香港政府行政報告形容英皇書院為「最優良及最新式的校舍之一」。日佔期間(一九四一至一九四五年)，日軍將校舍用作飼養軍用騾馬的馬廄。" +
				"校舍在戰時遭嚴重破壞，經修復後於一九五Ｏ年重開。這座以新古典主義風格建成的紅磚校舍，在本港同類的學校建築中甚為罕有。" +
				"校舍於一九二六年落成時，建有東翼、南翼和北翼，而位於般咸道和西邊街交界正門入口的弧形柱廊上則建有鐘樓（現已拆除）。" +
				"校舍內，新古典主義風格的建築特色舉目可見，例如拱形柱廊、飾有石柱的外廊、粗琢隅石、模製檐楣、圍繞窗戶的古典風格石砌緣飾等，" +
				"令這幢文物建築顯得古典雅致。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "King's College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "King's College, built in 1926, is one of the six surviving " +
				"pre-war government school buildings in Hong Kong. The other five pre-war government school buildings are " +
				"Former Kowloon British School (built between 1900 and 1902), Former Peak School (built in 1915), Former " +
				"Quarry Bay School (built in 1926), Cheung Chau Government Secondary School (built in 1928) and King " +
				"George V School (built in 1936).King's College was formerly known as Saiyingpun School established by the " +
				"Government on Third Street in 1879 and later moved to Pokfulam Road in 1891. The construction of the present " +
				"Bonham campus commenced in 1923 and was completed in 1926. Saiyingpun School moved to the new campus in the " +
				"same year and was renamed as King's College. The Hongkong Administrative Report of 1926 described King's " +
				"College as 'one of the finest and most modern of school buildings'. During the Japanese Occupation (1941-1945), " +
				"the school was used as a military mule and horse stable for the Japanese Army. The school building was badly " +
				"damaged during the war time. After refurbishment, the school was re-opened in 1950.The red-brick school building " +
				"in Neo-classical style is a rare piece of school architecture of its kind in Hong Kong. When the school " +
				"building was built in 1926, it comprised an east wing, a south wing and a north wing with a bell tower " +
				"(now removed) above the colonnaded curved entrance porch at the junction of Bonham Road and Western Street. " +
				"The notable Neo-classical style features such as arched colonnades, colonnaded verandahs, rusticated quoins, " +
				"moulded cornices and classical stone surrounds make it an interesting piece of built heritage.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.285523");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.14069");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "63A Bonham Road, Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "香港般咸道63A號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "甘棠第"); //data37
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("98"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("98"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "甘棠第於一九一四年落成，以第一任屋主何甘棠的名字命名。何甘棠（一八六六至一九五Ｏ年），" +
				"別名何啟棠，又名何棣生，是何東爵士的胞弟。何甘棠不但是傑出的商人，而且也是著名的社區領袖和慈善家，在二十世紀初的華人及歐亞裔人商界中地位顯赫，" +
				"是當時最具影響力的人物之一。何氏家族一直居於甘棠第，直至一九五九年鄭姓商人購入該建築物為止。翌年，該建築物再轉售予耶穌基督後期聖徒教會。" +
				"政府於二ＯＯ四年購得甘棠第，並將之改建為孫中山紀念館。該紀念館自二ＯＯ六年十二月起開放給公眾參觀。甘棠第屬綜合古典風格的建築，" +
				"這種風格在英皇愛德華時期的香港甚為流行。建築物的牆身由紅磚築砌，門窗四周飾有花崗石，露台建有精巧華麗的鐵製欄杆。" +
				"甘棠第是本港最先以鋼架興建，並鋪設入牆電線的構築物之一。建築物內部富麗堂皇，糅合了巴洛克及洛可可風格的建築特色。" +
				"地庫至二樓之間以寬闊華麗的樓梯連接，梯上設有精緻的扶欄。主要房間的天花均飾有以金箔點綴的灰塑鑲板，" +
				"而主樓梯及其他當眼位置亦裝設了色彩斑斕的玻璃窗，並以當時流行的新藝術風格圖案作為裝飾。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午十時至下午六時；星期六、日及公眾假期延長至下午七時。" +
				"聖誕前夕及農曆新年除夕提前於下午五時休館。逢星期四（公眾假期、11月12日孫中山先生誕辰及3月12日孫中山先生忌辰除外）、農曆新年年初一及初二休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kom Tong Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Built in 1914, Kom Tong Hall was named after its first owner, " +
				"Ho Kom Tong. Ho Kom Tong (1866-1950), alias Ho Kai Tong, otherwise known as Ho Tai Sang, was the younger " +
				"brother of Sir Robert Ho Tung. Ho Kom Tong was a prominent businessman as well as a well-known community " +
				"leader and philanthropist at the centre of the Chinese and Eurasian commercial community at the beginning " +
				"of the 20th century and one of the most influential figures of his time.Kom Tong Hall remained the residence " +
				"of the Ho family until 1959 when a merchant surnamed Cheng purchased the building. In the following year, " +
				"the Church of Jesus Christ of Latter-day Saints purchased the building from the Chengs. In 2004, Kom Tong " +
				"Hall was acquired by the Government and then converted into the Dr Sun Yat-sen Museum. The museum has " +
				"been open to the public since December 2006. This building is built in the composite classical style " +
				"popular in the Edwardian Colonial Period in Hong Kong, featuring red brick walls, granite dressings around " +
				"windows and doors, and ornate ironwork on balconies. It is one of the first structures in Hong Kong built " +
				"with a steel frame with concealed built-in electrical wiring.Internally, the building is richly decorated " +
				"with classical architectural features in Baroque and Rococo styles. A grand staircase with ornamental " +
				"balustrading serves the building from basement to the second floor. The ceilings of the main rooms are " +
				"ornately decorated with moulded plaster panels highlighted in gold leaf. Colourful stained glass windows " +
				"in Art Nouveau patterns of the period can be found at the main staircase and other notable positions.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "10:00 am to 6:00 pm daily; extended to 7:00 pm on Saturday, " +
				"Sunday and Public Holidays. Closed at 5:00 pm on Christmas Eve and Lunar New Year’s Eve. Closed on Thursday " +
				"(except Public Holidays, the anniversaries of Dr Sun's birth (12 November) and death (12 March)) " +
				"and on the first two days of Lunar New Year");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.282862");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.150818");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "7 Castle Road, Mid-Levels, Central, Hong Kong");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "香港中環半山衛城道7號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "覲龍圍門樓"); //data38
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("33"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("33"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "覲龍圍又名新圍，是粉嶺龍躍頭十一鄧姓村落之一。鄧氏宗族據說在十四世紀時已在此建村，" +
				"但圍牆很可能於一七四四年才興建。圍村門樓的石額刻有「覲龍乾隆甲子歲」字樣，乾隆甲子即一七四四年。覲龍圍四面有磚牆環繞，圍內布局基本依舊，" +
				"為本區保存最完好的圍村。圍村門樓於一九八八年被列為法定古蹟並已修復完好。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Kun Lung Gate Tower");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Kun Lung Wai, presently known as San Wai, is one of the eleven Tang villages " +
				"in Lung Yeuk Tau, Fanling. Although this village was reportedly settled by members of the Tang clan during the 14th century, " +
				"the walls of San Wai were believed built in 1744 as the stone lintel above the main entrance to the village is " +
				"engraved with 'Kun Lung, dated this Jiazi of the Qianlong reign'. Kun Lung Wai is enclosed with brick walls on " +
				"all four sides. It is the most authentic and undisturbed walled village left in the area. The gate house of " +
				"the walled village was declared a monument in 1988 and has since been properly restored.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.508236");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.148075");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "羅屋"); //data39
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("38"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("38"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "羅屋是一間有二百多年歷史的客家村屋，乃柴灣區數條古老村落碩果僅存的村屋。屋主羅氏先祖在清朝康熙年間" +
				"（一六六二至一七二二年）在柴灣定居，以種稻為生，生活刻苦。羅屋現已重修及闢作羅屋民俗館。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午十時至下午六時。聖誕前夕及農曆新年除夕提前於下午五時休館。 " +
				"逢星期四（公眾假期除外）、農曆新年年初一及初二休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Law Uk Hakka House");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Law Uk is a simple Hakka residence built over 200 years ago by the Law family, " +
				"whose ancestors settled in Chai Wan early in the Kangxi reign (1662-1722) of the Qing Dynasty. The Laws were poor peasants" +
				" who grew rice as their livelihood. The village house is the only example left from the old farming villages which " +
				"used to be in Chai Wan. It has been fully restored and is now a folk museum.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "10:00am – 6:00pm daily. Closed at 5:00pm on Christmas Eve and Lunar " +
				"New Year's Eve. Closed on Thursday (except Public Holidays) and on the first two days of Lunar New Year");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.267334");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.235641");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "14 Kut Shing Street, Chai Wan");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "柴灣吉勝街十四號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "東區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Eastern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "李鄭屋漢墓"); //data40
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("35"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("35"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "一九五五年平整地盤興建李鄭屋邨時，建築工人發現這座磚室古墓。出土明器共五十八件，" +
				"包括陶製器皿及青銅器物。墓室形制及出土明器式樣顯示，這座古墓的建造年代應在東漢期間(公元二十五至二百二十年)。古墓現已闢作李鄭屋漢墓博物館。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午十時至下午六時。聖誕前夕及農曆新年除夕提前於下午五時休館。逢星期四（公眾假期除外）、農曆新年年初一及初二休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Lei Cheng Uk Han Tomb");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "This ancient brick tomb was discovered in 1955 when workmen were " +
				"levelling a hill slope to make way for the present Lei Cheng Uk Estate. A total of 58 pottery and bronze " +
				"objects were found inside the tomb. Available evidence based on the design of the tomb and the forms of " +
				"burial objects suggests that it was built during the Eastern Han Dynasty (A.D.25-220). The site is now " +
				"the Lei Cheng Uk Han Tomb Museum.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "10:00am – 6:00pm daily.Closed at 5:00pm on Christmas Eve and " +
				"Lunar New Year's Eve. Closed on Thursday (except Public Holidays) and on the first two days of Lunar New Year");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.338138");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.159985");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Lei Cheng Uk Estate, Sham Shui Po");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "深水埗李鄭屋邨");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "深水埗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sham Shui Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "八鄉梁氏宗祠"); //data41
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("81"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("81"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "梁氏宗祠由八鄉元崗村梁族興建，建成至今已約二百年。梁氏族人源於廣東東莞，" +
				"在十七至十八世紀期間由十二世祖梁國初帶同族人遷徙至新界，及後其子梁大成定居元朗八鄉並建立元崗村，現時梁氏宗祠即由梁大成祖所擁有。" +
				"據村中父老憶述，元崗村的得名與其地形有關。元崗鄉公所背後原有一座圓形山崗，村莊因此取名圓崗，但由於村落不斷擴展，" +
				"這座小山崗已被移平並發展成現在的休憩處，村名也隨之改為目前的元崗村。由於新界鄉村不斷發展，元崗村內很多舊村屋已被重建或拆卸，" +
				"梁氏宗祠是村中少數僅存的歷史建築物。宗祠現時仍用作舉行祭祖及點燈等傳統儀式，同時也是梁氏族人議事的地方。" +
				"梁氏宗祠是典型的清代兩進式建築，兩進之間為天井，天井兩旁建有廂房。右廂房設有廚房，曾在喜慶活動時用作烹煮盆菜。" +
				"祠堂的正面牆身以花崗石和磚建造，牆頂配有雕刻精美的封簷板和中式壁畫，外觀莊嚴。正門上方是刻有「梁氏宗祠」四字的石額。" +
				"屋脊的灰塑裝飾以梅花、牡丹、蓮花與鰲魚等瑞獸和吉祥圖案為主題，山牆也有精美的草尾灰塑裝飾。祠堂後進明間置有神龕，安放歷代先祖的神位。" +
				"神龕刻有各類色彩斑斕的花卉植物，如梅花、青竹、牡丹、桃花和蓮花等，以代表四季生生不息，寓意梁族開枝散葉。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Leung Ancestral Hall, Pat Heung");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Built by the Leung clan in Yuen Kong Tsuen, Pat Heung, " +
				"the Leung Ancestral Hall has a history of about 200 years. The Leungs came originally from Dongguan " +
				"of Guangdong Province. Led by Leung Kwok Chor, the 12th generation ancestor, the Leung clan migrated " +
				"to the New Territories during the 17th and 18th Century. His son, Leung Tai Shing, finally settled in Pat Heung, " +
				"Yuen Long and established Yuen Kong Tsuen there, which explains why the Leung Ancestral Hall is now owned by " +
				"Leung Tai Shing Tso. Yuen Kong Tsuen was so named owing to its topography. According to local villagers, " +
				"originally there was a round mound at the back of Yuen Kong Rural Committee Office. The village was " +
				"subsequently known as Yuen Kong, which literally means a round mound. With the expansion of the village, " +
				"the mound was levelled to make way for the present playground and the village was later renamed as " +
				"the present Yuen (a different Chinese character which has the same pronunciation but does not mean 'round' " +
				"any more) Kong Tsuen. Due to rural development in recent years, many old houses in Yuen Kong Tsuen have " +
				"either been rebuilt or demolished. The Leung Ancestral Hall is among a few historic buildings remaining there. " +
				"Today, the Leung Ancestral Hall is still used to hold traditional ceremonies such as ancestral worship and " +
				"lantern lighting ceremony, and as a meeting place for clansmen. The Leung Ancestral Hall is a typical " +
				"Qing vernacular building having a layout of two-hall-one-courtyard. Side chambers are located at both " +
				"sides of the courtyard. The right side chamber houses a kitchen, which was once used for cooking basin " +
				"meals during festive events. The building is characterized by its solemn facade constructed of the " +
				"granite block base and the brick wall complete with finely carved fascia boards and traditional " +
				"Chinese murals on the top. The stone lintel above the main entrance is engraved with the name of " +
				"the Ancestral Hall. The roof ridges are decorated with plastered motifs of auspicious animals and " +
				"patterns like dragon fish, peony, plums and lotus, and its gable walls are adorned with delicate leafy mouldings. " +
				"The wooden altar housing the ancestral tablets is placed at the main bay of the rear hall. " +
				"The altar is richly decorated with wood carvings of stylized plants such as plums, bamboo, peony, " +
				"peach and lotus which represent different seasons to signify the flourishing growth of descendants.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. " +
				"Closed on Tuesdays, Christmas Day, Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.421651");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.066065");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Yuen Kong Tsuen, Pat Heung, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "新界八鄉元崗村");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廖萬石堂"); //data42
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("30"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("30"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "廖氏先祖原籍福建，於明代（一三六八至一六四四年）遷居上水雙魚河，子孫其後散居附近一帶。" +
				"十八世紀時，廖氏勢力至為顯赫，這可見諸他們所建的祠堂--廖萬石堂。廖萬石堂建於一七五一年，屬三進兩院建築。整座建築裝飾華麗，" +
				"灰塑、木刻、壁畫、泥塑等比目皆是，題材多為傳統吉祥圖案。廖萬石堂於一九八三年重修，費用主要由廖族支付。祠堂於一九九四年由政府斥資再次重修。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "星期三、星期四、星期六、星期日及公眾假期，上午九時至下午一時及下午二時至下午五時。" +
				"逢星期一、星期二、星期五、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Liu Man Shek Tong Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The founding ancestors of the Liu lineage of Sheung Shui came " +
				"from Fujian and settled in the plains of the Sheung Yue River during the Ming Dynasty (1368-1644). " +
				"In the 18th century, the Lius were very rich and prosperous and this was well demonstrated by the " +
				"building of their main ancestral hall, the Liu Man Shek Tong in 1751. This typical three-hall two-courtyard " +
				"building is richly embellished with plaster mouldings, wood carvings and murals of auspicious motifs and pictures. " +
				"It was restored first in 1983 with funding mainly from the clan, and again in 1994 with funds from the Government.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "Wednesdays, Thursdays, Saturdays, Sundays and Public Holidays: 9:00am – 1:00pm & 2:00pm – 5:00pm. " +
				"Closed on Mondays, Tuesdays, Fridays, Christmas Day, Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.510664");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.12414");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Mun Hau Tsuen, Sheung Shui");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "上水門口村");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖士提反女校中學主樓"); //data43
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("46"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("46"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "聖士提反女子中學是本港首批女子學校之一，多年來作育英才，部分學生更是香港大學首批畢業的女學生。" +
				"該校原址在堅道二十七號，一九二三年始遷往列堤頓道現址。主樓的西翼和中央部分在一九二三年完成；東翼則在一九二八年加建。" +
				"建築物樓高四層，學校禮堂圍攏於中央。這座西式建築物的設計概念和布局與中國傳統合院式建築風格相類似，別具特色。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Main Building of St. Stephen's Girls' College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "St. Stephen's Girls' College is one of the first schools to " +
				"devote itself to the education of girls in Hong Kong. Many of its students became prominent members of " +
				"the local community, including some of the first female graduates of the University of Hong Kong. The " +
				"College was originally located at 27 Caine Road but moved to its present location at Lyttelton Road in 1923." +
				"The West Wing and the Central Portion of the Main Building were completed in 1923 while the East Wing was " +
				"erected in 1928. The building is a four-storey structure enclosing a school hall in the centre. " +
				"The design concept and layout of this Classical-style building is of particular interest because " +
				"of its similarities in style to a traditional Chinese courtyard house.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287985");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.144146");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "2 Lyttelton Road, Mid-Levels");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "列堤頓道二號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "麟峯文公祠"); //data44
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("19"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("19"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "文氏是新界「五大宗族」之一；雖然並非是最早遷居香港的宗族，但已於十五世紀，" +
				"在元朗新田和大埔泰亨一帶定居。麟峯文公祠坐落於新田低地上，建於二百多年前以紀念文氏先祖文麟峯。祠堂屬傳統的三進兩院式建築。" +
				"修復工程在一九八七年完成，費用由香港賽馬會資助。其後於一九九五年再次修葺，全部工程費用由政府撥款資助。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。逢星期二、聖誕日、聖誕翌日、元旦日及農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Man Lun Fung Ancestral Hall");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Man clan is one of the 'Five Major Clans' in Hong Kong. Although it " +
				"was not the first clan settled in the territory, the Man clan already started its settlement in San Tin and Tai Hang " +
				"as early as the 15th century. The Ancestral Hall, situated on the low lying ground of San Tin, was built more than " +
				"200 years ago to commemorate one of the clan's ancestors, Man Lun-fung. The building follows the traditional style, " +
				"having three halls and two enclosed open courtyards. It was fully restored in 1987 with generous donations from " +
				"the Hong Kong Jockey Club. It was renovated again in 1995 with funds provided by the Government.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "9:00am – 1:00pm & 2:00pm – 5:00pm daily. Closed on Tuesdays, " +
				"Christmas Day, Boxing Day, New Year's Day and the first 3 days of the Lunar New Year.");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.500029");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.074412");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, " Fan Tin Tsuen, San Tin, Yuen Long ");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗新田蕃田村");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "文武二帝廟"); //data45
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("23"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("23"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "文武二帝廟約於一百多年前由大埔七約鄉民合力興建，以紀念現位於富善街的太和市落成，" +
				"該址現時通常稱為大埔墟。該廟於一九八五年由七約鄉公所進行修葺，政府則提供專業意見及資助部分修葺費用。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Man Mo Temple");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Man Mo Temple was built about 100 years ago by the Tsat Yeuk " +
				"Community of Tai Po to mark the founding of Tai Wo Shi (Tai Wo Market Town) which is now commonly known " +
				"as Tai Po Market. Full restoration of the temple was undertaken by the Tai Po Tsat Yeuk Rural Committee " +
				"in 1985 with technical advice and a subsidy from the Government.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.452283");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.164917");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Fu Shin Street, Tai Po");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "大埔富善街");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "上環文武廟"); //data46
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("96"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("96"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "文武廟為廟宇組群，位於上環荷李活道，由文武廟、列聖宮和公所三幢建築物組成。該廟宇由華人富商興建，" +
				"估計於一八四七至一八六二年期間落成。文武廟主要為供奉文昌及武帝，列聖宮則用作供奉諸神列聖。公所為區內華人議事及排難解紛的場所。三幢建築物以兩條小巷分隔。" +
				"一九Ｏ八年，政府制定《文武廟條例》，正式把文武廟交予東華醫院管理。時至今天，東華三院董事局和社會賢達每年仍會齊集廟內舉行秋祭典禮，" +
				"酬拜文武二帝，同時為香港祈福。文武廟對本港具有重要的歷史和社會意義，反映昔日香港華人的社會組織和宗教習俗。文武廟為兩進三開間建築，" +
				"正門外面有兩座花崗石鼓台，前進置有擋中。廟宇按照傳統中式建築布局設計，後進較前進高出幾級，設有供奉諸神的神龕。兩進之間的天井已為重檐歇山頂覆蓋，" +
				"屋頂由天井四角的花崗石柱支撐，兩側為捲棚頂的廂房。位於文武廟左側的列聖宮原為三進兩院式建築，其後兩個天井加築鋼架屋面。公所為簡單的一進式建築，" +
				"其花崗石門框至今保存完好，上面刻有公所的建築年份，甚具歷史價值。文武廟組群屬典型的傳統中式民間建築，飾有精緻的陶塑，花崗石雕、木雕、" +
				"灰塑和壁畫，盡顯精湛的傳統工藝技術。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午八時至下午六時");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Man Mo Temple Compound, Sheung Wan");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Man Mo Temple Compound on Hollywood Road, " +
				"Sheung Wan comprising three blocks, namely Man Mo Temple, Lit Shing Kung and Kung Sor, was " +
				"built approximately between 1847 and 1862 by wealthy Chinese merchants. Man Mo Temple was built " +
				"mainly for the worship of Man Cheong (God of Literature) and Mo Tai (God of Martial Arts). " +
				"Lit Shing Kung was built for the worship of all heavenly gods. Kung Sor was used as a meeting " +
				"place and for resolving matters related to the Chinese community in the area. The three blocks " +
				"are separated by two alleys. The Temple was officially entrusted to Tung Wah Hospital with the " +
				"enactment of the Man Mo Temple Ordinance in 1908. Even nowadays, the Directors of the Tung Wah " +
				"Group of Hospitals and community celebrities still congregate in the Temple every year at the Autumn " +
				"Sacrificial Rites to pay homage to Man Cheong and Mo Tai as well as to invoke prosperity of Hong Kong. " +
				"The Temple has imperative historical and social values to the territory, representing the " +
				"traditional social organization and religious practices of the Chinese community in old Hong Kong." +
				"Man Mo Temple is a two-hall-three-bay structure fronted by two granite drum platforms. " +
				"A pair of screen doors is placed in the front hall. Following the traditional Chinese architectural " +
				"layout, the rear hall housing the altars of the deities is a few steps higher than the front hall. " +
				"Between the two halls is a covered courtyard flanked by two side chambers with humpbacked roofs. " +
				"The courtyard is covered with a double-eaved hip-and-gable roof supported by four granite columns " +
				"at the corners of the courtyard. Lit Shing Kung, which is attached to the left of Man Mo Temple, " +
				"was originally a three-hall-two-courtyard structure. The two courtyards were later covered by steel roofs. " +
				"Kung Sor is a simple one-hall structure. The historic granite doorframe on which the year of construction " +
				"of Kung Sor can be found is still well preserved.The magnificent Man Mo Temple Compound is a fine " +
				"example of traditional Chinese vernacular architecture. It is exquisitely decorated with ceramic figurines, " +
				"granite carvings, wood carvings, plaster mouldings and murals, reflecting superb traditional craftsmanship.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "8:00am to 6:00pm daily");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.287349");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.150669");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "124-126, 128 & 130 Hollywood Road, Sheung Wan");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "上環荷李活道124-126、128及130號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "瑪利諾修院學校"); //data47
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("84"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("84"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "瑪利諾女修會 ( 又名「聖道明瑪利諾女修會」，其原名為「聖道明海外傳教女修會」 ) " +
				"於一九二一年來到香港傳教和服務，並於一九二五年創辦瑪利諾修院學校，該校最初是一所幼稚園，校址位於柯士甸道。一九三一年，聖德肋撒堂成立後，" +
				"學校管理層認為發展中的九龍塘區是瑪利諾修院學校的理想選址。窩打老道的新校舍於一九三三年開始興建。一九三六年五月，當時的香港總督郝德傑爵士 " +
				"( 一八八四至一九五一年 ) 為學校主樓主持奠基儀式。翌年，瑪利諾修院學校遷至新校舍，為幼稚園至預科程度的學生提供教育，校舍自始亦成為區內的地標。" +
				"學校運作因二次大戰而中斷，校舍由一九四二至四五年曾改作日軍醫院。主樓旁邊的修院在二次大戰前開始興建，於一九五三年竣工。一九六〇年，" +
				"學校的中學部遷往何東道 5 號的新校舍，此後，窩打老道學校主樓便一直由小學部使用，而主樓旁邊的修院在一九九七年當小學改為全日制後，亦歸小學部使用。" +
				"於一九三七年落成的學校主樓採用中世紀修道院或學院的布局設計，列柱迴廊圍繞露天中庭。校舍建築群的自由新都鐸風格融合了多種不同的建築設計特色，" +
				"包括裝飾派藝術、羅馬式、新喬治亞風格和哥德復興式。禮堂內羅馬式的拱頂天花、面向界限街的麻石階梯、尖拱門、四坡或斜折線形屋頂和建築物正面的塔樓，" +
				"均是主樓顯著的建築特色。瑪利諾修院學校的布局和一九三七年落成的主樓保存甚佳，多年來並沒有經過明顯的改動或改建，校舍內仍保存著古色古香的裝飾和地台。" +
				"校內優美的花園和園景，亦提高了該建築群的整體性價值。在校方及瑪利諾女修會的支持下，" +
				"瑪利諾修院學校包括一九三七年落成的學校主樓和修院根據《古物及古蹟條例》於二〇〇八年被宣布為法定古蹟，並受該條例保護。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Maryknoll Convent School");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Maryknoll Convent School was first established at Austin Road in " +
				"1925 as a kindergarten by the Maryknoll Sisters of St. Dominic (originally named as 'The Foreign Mission " +
						"Sisters of St. Dominic') coming to Hong Kong in 1921 with a mission to preach and to serve. " +
								"With the opening of St. Teresa's Parish in 1931, the school management felt that Kowloon Tong, " +
								"as a developing district, was an ideal place for Maryknoll Convent School. Construction of the " +
								"new campus on Waterloo Road started in 1933. In May 1936, Sir Andrew Caldecott (1884-1951), " +
								"the then Governor of Hong Kong, laid the cornerstone of the Main Building of the School. " +
								"One year later, the School moved to the new campus providing education for students from " +
								"kindergarten to matriculation. It has been a landmark in the area since. School operation was " +
								"interrupted by the Second World War and the School was used as a Japanese military hospital " +
								"from 1942 to 1945. Construction of the Convent next to the Main Building, which began before " +
								"the Second World War, was finally completed in 1953. In 1960, the Secondary Section was moved " +
								"to the new school building at 5 Ho Tung Road. Ever since, the Primary Section has remained " +
								"in the Waterloo Road Main Building and occupied the Convent as well when it turned whole-day " +
								"session in 1997. The layout of the 1937-built Main Building adopts the medieval monastery or " +
								"collegiate layout of an open peristyle courtyard surrounded by cloisters. " +
								"The free neo-Tudor style of the school complex incorporates different features " +
								"of architecture including Art Deco, Romanesque, Neo-Georgian and Gothic Revival. " +
								"Vaulted ceiling of Romanesque style in the auditorium, the granite staircase " +
								"facing Boundary Street, pointed arches, hipped or gambrel-shaped roofs and the " +
								"single tower at the facade are notable features of the Main Building. The setting and the " +
								"1937-built Main Building of the Maryknoll Convent School are preserved in a very good condition. " +
								"No notable change or alteration has been made to the school building over the years. Old style " +
								"furnishings and flooring can still be found in the Main Building. The well-kept landscape " +
								"gardens also enhance the setting of the school complex. With the support of the school and the " +
								"Maryknoll Sisters of St. Dominic, the 1937-built Main Building and the Convent are declared " +
								"as a monument for protection under the Antiquities and Monuments Ordinance in 2008.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.32747");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.179231");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "No. 130 Waterloo Road, Kowloon ");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "九龍窩打老道130號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "九龍城");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Kowloon City");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "城門水塘紀念碑"); //data48
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("92"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("92"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "城門水塘的建造工程始於一九二三年，歷時十四年完成。這項工程規模龐大，" +
				"水塘除了為九龍半島供水，滿足九龍居民的食水需要外，也通過跨海水管把食水輸往人口密集的香港島，幫助紓緩港島所面對的食水需求壓力。" +
				"城門水塘是戰前最大和最主要的水塘，同時為九龍和港島供應食水。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Memorial Stone of Shing Mun Reservoir");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The construction of Shing Mun Reservoir commenced in 1923 and took 14 years to complete. " +
				"The enormous size of the project not only brought water to cater for the needs of people in Kowloon Peninsula, " +
				"but also helped to relieve pressure on water demand in the densely populated Hong Kong Island via the " +
				"cross-harbour mains, making it the largest and major reservoir in the pre-war period to supply water " +
				"for both Kowloon and Hong Kong Island.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.386984");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.147127");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Kwai Tsing");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "葵青");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "葵青");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Kwai Tsing");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "馬禮遜樓"); //data49
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("79"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("79"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "位於屯門何福堂會所內的馬禮遜樓建於一九三六年，是抗日名將十九路軍軍長蔡廷鍇將軍（1892-1968）" +
				"別墅一部分。一九四六年至一九四九年間，該別墅被用作達德學院的校舍。達德學院是在周恩來和董必武指示下創辦，多位當時著名的中國學者均曾在此講學。" +
				"學院培育了不少年青知識份子。建築物見証了香港在近代中國歷史和中華人民共和國建國史中所扮演的獨特角色。馬禮遜樓建築特色獨特，選用上海批盪，" +
				"並以裝飾派藝術建築風格建成，廡殿式的屋頂以青釉中式瓦片砌築，四角飾以瑞龍，反映了中西相容的風格。馬禮遜樓於二OO四年三月被列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "建築物為私人物業，不對外開放。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Morrison Building");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The Morrison Building in Hoh Fuk Tong Centre, " +
				"Tuen Mun was originally part of a villa built in 1936 by General Cai Tingjie (1892-1968), " +
				"who led the Nineteen Corps against the Japanese invasion. It was used for tertiary education " +
				"by the Dade Institute, founded under the directive of Chinese leaders Zhou Enlai and Dong Biwu, " +
				"from 1946 to 1949. Many eminent Chinese scholars of the time lectured at the institute, nurturing " +
				"a group of young intellectuals. The building bears witness to the unique role played by Hong Kong " +
				"in the history of modern China and the establishment of the People's Republic of China.The architectural " +
				"characteristics of the building are rather unique. It is designed in Art Deco style and rendered with " +
				"Shanghai plaster, and has a green glazed Chinese tiled hipped roof decorated with dragon shaped " +
				"ornaments at four corners, representing a harmonious blend of Chinese and Western styles. " +
				"The Morrison Building was declared a monument in 26 March 2004.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.396914");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.977477");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Hoh Fuk Tong Centre, Castle Peak Road (Sun Hui Section), Tuen Mun");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "屯門青山公路新新墟段何福堂會所");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_NT);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "屯門");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tuen Mun");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖約瑟書院北座及西座"); //data50
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("70"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("70"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "位於香港堅尼地道七號的聖約瑟書院的北座及西座於二〇〇〇年八月十八日列為法定古蹟。" +
				"聖約瑟書院是本港其中一所教會主辦的學校。一八六四年，羅馬天主教會在威靈頓街開辦救主書院(即聖約瑟書院前身)。一八七五年，六名喇沙修士會修士接辦該校，" +
				"改名為聖約瑟書院。一九一八年，新校舍設於堅尼地道七號德國會所，即書院現址。書院的教學樓(即現北座)於一九二〇年啟用，" +
				"科學樓或稱教堂樓(即現西座)則於一九二五年啟用。書院的北座和西座是該校現存的戰前建築物。北座樓高四層，兩側建有鐘樓，" +
				"一邊建有遊廊；西座亦是樓高四層，頂部建有塔樓。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "North and West Blocks of St. Joseph's College");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "The North Block and West Block of St. Joseph's College at 7 Kennedy Road, " +
				"Hong Kong were declared historical monuments on 18 August 2000. St. Joseph's College is a Roman Catholic " +
				"missionary school and its forerunner, St. Saviour's College, was opened at Wellington Street in 1864 by " +
				"the Roman Catholic Church. In 1875, six La Salle Brothers took over the school and renamed it as " +
				"St. Joseph's College. In 1918, the college moved to the present site at 7 Kennedy Road, which " +
				"had been previously occupied by the Club Germania. The Classroom Block, i.e. the present North Block, " +
				"was opened in 1920 while the Science Block or the Chapel Block, i.e. the present West Block was " +
				"opened in 1925. The North Block and West Block are currently the only existing pre-War buildings of the college. " +
				"The former is a four-storey building flanked by two clock towers at both ends and has verandahs on one side " +
				"whereas the latter is also a four-storey structure with a turret on top.");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK_EN, "PLEASE CALL TO CHECK THE OPENING HOURS");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR_EN, "");
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.276555");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.158726");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "7 Kennedy Road, Central");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "中環堅尼地道七號");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK); 
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);  
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊北區理民府"); //data51
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("12"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("12"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "海壩村古屋"); //data52
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("31"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("31"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("39"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("39"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "沙田");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Shatin");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊病理學院"); //data54
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("41"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("41"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊赤柱警署"); //data55
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("25"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("25"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.218258");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.213435");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");  
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊大埔墟火車站"); //data56
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("29"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("29"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊灣仔郵政局"); //data57
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("40"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("40"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "灣仔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Wan Chai");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "碗窰村碗窰"); //data58
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("20"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("20"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "大埔");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tai Po");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "九龍寨城南門遺蹟"); //data59
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("62"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("62"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "九龍城");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Kowloon City");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "葉定仕故居"); //data60
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("93"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("93"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大浪灣石刻"); //data61
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("01"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("01"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.246145");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.248831");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);   
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "龍蝦灣石刻"); //data62
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("16"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("16"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
		values.put(PlaceSqliteOpenHelper.COLUMN_REMARK, "開放時間只作參考，請致電查詢詳情。");
		values.put(PlaceSqliteOpenHelper.COLUMN_HOUR, "每日上午九時至下午一時及下午二時至五時。\n農曆年初一至初三休息。");
		values.put(PlaceSqliteOpenHelper.COLUMN_PHONE, "+852 2208 4400");
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME_EN, "Rock Carving at Lung Ha Wan");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC_EN, "Rock Carving at Lung Ha Wan, is situated adjacent to Tang Ancestral Hall, "
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "石壁石刻"); //data63
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("05"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("05"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "滘西洲石刻"); //data64
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("02"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("02"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東龍洲石刻"); //data65
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("03"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("03"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "黃竹坑石刻"); //data66
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("28"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("28"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "長洲石刻"); //data67
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("14"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("14"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "蒲台石刻"); //data68
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("06"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("06"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大廟灣刻石"); //data69
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("04"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("04"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "三棟屋村"); //data70
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("10"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("10"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "荃灣");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tsuen Wan");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖士提反書院的書院大樓"); //data71
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("100"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("100"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.215745");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "114.215948");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);  
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "上窰村"); //data72
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("13"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("13"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "佛頭洲稅關遺址"); //data73
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("18"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("18"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聖約翰座堂"); //data74
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("60"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("60"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "分流石圓環"); //data75
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("21"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("21"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LAT, "22.197895");
		values.put(PlaceSqliteOpenHelper.COLUMN_LNG, "113.84771");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS_EN, "Ping Shan, Yuen Long");
		values.put(PlaceSqliteOpenHelper.COLUMN_ADDRESS, "元朗屏山");
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);  
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "大夫第"); //data76
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("32"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("32"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廈村鄧氏宗祠"); //data77
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("83"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("83"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "屏山鄧氏宗祠"); //data78
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("73"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("73"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "松嶺鄧公祠"); //data79
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("65"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("65"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廣瑜鄧公祠"); //data80
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("97"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("97"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "燈籠洲燈塔"); //data81
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("72"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("72"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "荃灣");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Tsuen Wan");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學孔慶熒樓外部"); //data82
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("57"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("57"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學鄧志昂樓外部"); //data83
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("58"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("58"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學大學堂外部"); //data84
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("56"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("56"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "南區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Southern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "梅夫人婦女會主樓外部"); //data85
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("49"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("49"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "香港大學本部大樓外部"); //data86
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("27"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("27"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊最高法院外部"); //data87
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("26"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("26"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "銅鑼灣天后廟"); //data88
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("15"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("15"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/15.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_15.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "東區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Eastern");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "龍躍頭天后宮"); //data89
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("77"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("77"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/77.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_77.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "北區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "North");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "聚星樓"); //data90
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("75"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("75"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/75.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_75.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東涌小炮台"); //data91
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("22"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("22"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/07.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_07.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東涌炮台"); //data92
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("07"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("07"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/en/monuments/small/74/742.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/b5/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東龍洲炮台"); //data93
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("09"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("09"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/09.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_09.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "西貢");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Sai Kung");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "東華三院文物館"); //data94
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("95"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("95"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/95.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_95.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_KOWLOON);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "油尖旺");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yau Tsim Mong");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
				
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "域多利監獄"); //data95
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("55"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("55"));

//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/55.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_55.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "橫瀾燈塔"); //data96
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("71"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("71"));
		//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/71.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_71.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_ISLAND);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "離島");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Islands");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "舊上環街市"); //data97
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("42"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("42"));
		//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/42.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_42.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_DISTRICT, Constants.INT_HK);
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "中西區");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Central & Western");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "仁敦岡書室"); //data98
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("94"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("94"));
		//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/94.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_94.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "廈村楊侯宮"); //data99
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("34"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("34"));
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "二帝書院"); //data100
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("47"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("47"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/47.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_47.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
		
		
		
		values = new ContentValues();
		values.put(PlaceSqliteOpenHelper.COLUMN_NAME, "愈喬二公祠"); //data101
		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, buildImageUrl("74"));
		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, buildHomePageUrl("74"));
//		values.put(PlaceSqliteOpenHelper.COLUMN_IMG_URL, "http://www.amo.gov.hk/graphics/%s/monuments/74.jpg");
		values.put(PlaceSqliteOpenHelper.COLUMN_DESC, "愈喬二公祠坐落於鄧氏宗祠旁邊，為三進兩院式建築，結構和規模與鄧氏宗祠相若。" 
								+ "二公祠由鄧族第十一世祖鄧世賢（號愈聖）和鄧世昭（號喬林）昆仲於十六世紀初興建。"
								+ "二公祠除用作祠堂外，亦曾經是各村子弟讀書之所。一九三一至一九六一年間，達德學校於此開辦。"
								+ "據祠堂正門石額所載，清光緒年間（一八七五至一九零八年）曾進行大規模修葺，但仍基本保持原來的結構和特色。"
								+ "愈喬二公祠於二零零一年十二月十四日列為法定古蹟。");
		values.put(PlaceSqliteOpenHelper.COLUMN_EMAIL, "amo@lcsd.gov.hk");
//		values.put(PlaceSqliteOpenHelper.COLUMN_HOMEPAGE, "http://www.amo.gov.hk/%s/monuments_74.php");
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
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION, "元朗");
		values.put(PlaceSqliteOpenHelper.COLUMN_LOCATION_EN, "Yuen Long");
		database.insert(PlaceSqliteOpenHelper.TABLE_PLACE, null, values);
	}

	private static String buildImageUrl (String id) {
		return String.format(Locale.US, IMG_FMT, id);
	}
	
	private static String buildHomePageUrl (String id) {
		return String.format(Locale.US, HOMEPAGE_FMT, id);
	}
}
