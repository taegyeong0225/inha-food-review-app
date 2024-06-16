package com.example.android_final_app.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class postDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MOBILE_FINAL_PROJECT.db";
    private static final int DATABASE_VERSION = 1;

    public postDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POSTS_TABLE = "CREATE TABLE " + postDB.TABLE_POST + " (" +
                postDB.COL_NO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                postDB.COL_TITLE + " TEXT, " +
                postDB.COL_CONTENT + " TEXT, " +
                postDB.COL_AUTHOR + " TEXT, " +
                postDB.COL_RESTAURANT + " TEXT, " +
                postDB.COL_RECOMMEND + " BOOLEAN DEFAULT 0)"; // 추천 필드 추가
        db.execSQL(CREATE_POSTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + postDB.TABLE_POST);
        onCreate(db);
    }

    // 데이터 삽입 메서드
    public long addPost(String title, String content, String author, String restaurant, boolean recommend) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(postDB.COL_TITLE, title);
        values.put(postDB.COL_CONTENT, content);
        values.put(postDB.COL_AUTHOR, author);
        values.put(postDB.COL_RESTAURANT, restaurant);
        values.put(postDB.COL_RECOMMEND, recommend);
        return db.insert(postDB.TABLE_POST, null, values);
    }

    // 데이터 읽기 메서드
    public Cursor getAllPosts() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                postDB.COL_NO,
                postDB.COL_TITLE,
                postDB.COL_CONTENT,
                postDB.COL_AUTHOR,
                postDB.COL_RESTAURANT,
                postDB.COL_RECOMMEND
        };
        return db.query(postDB.TABLE_POST, projection, null, null, null, null, null);
    }
}