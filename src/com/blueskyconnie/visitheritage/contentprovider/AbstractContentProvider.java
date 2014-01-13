package com.blueskyconnie.visitheritage.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.blueskyconnie.visitheritage.sqllite.PlaceSqliteOpenHelper;

public class AbstractContentProvider extends ContentProvider {

    protected static final int LIST = 10;
    protected static final int ITEM_ID = 20;
	
    private UriMatcher mUriMatcher;
    private String mTableName ;
    private PlaceSqliteOpenHelper dbHelper;
//    private String mBasePath;
	
    public AbstractContentProvider( String tableName, UriMatcher uriMatcher ) {
        super();
        this.mTableName = tableName;
        this.mUriMatcher = uriMatcher;
 //       this.mBasePath = basePath;
    }
    
//	static String buildAuthority( String packageName, String name) {
//        StringBuilder authority = new StringBuilder(packageName);
//        authority.append('.');
//        authority.append(name);
//        return authority.toString();
//    }
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// no delete operation
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// no insert operation
		return null;
	}

	@Override
	public boolean onCreate() {
		dbHelper = new PlaceSqliteOpenHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		SQLiteDatabase sqlDB = dbHelper.getReadableDatabase();

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(mTableName);

        int uriType = mUriMatcher.match(uri);
        switch (uriType) {
            case LIST:
                break;
            case ITEM_ID:
                // Adding the ID to the original query
                queryBuilder.appendWhere(PlaceSqliteOpenHelper.COLUMN_ID + "="
                        + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        Cursor cursor = queryBuilder.query(sqlDB, projection, selection,
                selectionArgs, null, null, sortOrder);
        // Make sure that potential listeners are getting notified
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// no update operation
		return 0;
	}

}
