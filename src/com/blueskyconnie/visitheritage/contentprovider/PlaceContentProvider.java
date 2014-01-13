package com.blueskyconnie.visitheritage.contentprovider;

import android.content.UriMatcher;
import android.net.Uri;

import com.blueskyconnie.visitheritage.sqllite.PlaceSqliteOpenHelper;

public class PlaceContentProvider extends AbstractContentProvider {

   	 private static final String AUTHORITY = "com.blueskyconnie.visitheritage";
   	 
	 public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + PlaceSqliteOpenHelper.TABLE_PLACE);
	 
	 private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

	    static {
	        uriMatcher.addURI(AUTHORITY, PlaceSqliteOpenHelper.TABLE_PLACE, LIST);
	        uriMatcher.addURI(AUTHORITY, PlaceSqliteOpenHelper.TABLE_PLACE + "/#", ITEM_ID);
	    }

	    public PlaceContentProvider() {
	        super(PlaceSqliteOpenHelper.TABLE_PLACE, uriMatcher);
	    }
}
