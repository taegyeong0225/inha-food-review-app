package com.example.android_final_app.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class memberDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "memberDBHelper";
    private Context context;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MOBILE_FINAL_PROJECT.db";

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + memberDB.TABLE_MEMBER + " (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    memberDB.COL_NAME + " TEXT, " +
                    memberDB.COL_EMAIL + " TEXT," +
                    memberDB.COL_ID + " TEXT," +
                    memberDB.COL_PASSWORD + " TEXT)";

    private static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + memberDB.TABLE_MEMBER;

    public memberDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

    public long addMember(String name, String email, String id, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(memberDB.COL_NAME, name);
        values.put(memberDB.COL_EMAIL, email);
        values.put(memberDB.COL_ID, id);
        values.put(memberDB.COL_PASSWORD, password);

        long newRowId = db.insert(memberDB.TABLE_MEMBER, null, values);

        Log.d(TAG, "New row ID: " + newRowId);
        if (newRowId != -1) {
            // 회원 추가 성공
            Log.d(TAG, "New member inserted with ID: " + newRowId);
            Toast.makeText(context, "회원 가입 성공", Toast.LENGTH_SHORT).show();
        } else {
            // 회원 추가 실패
            Log.e(TAG, "Failed to insert new member");
            Toast.makeText(context, "회원 가입 실패", Toast.LENGTH_SHORT).show();
        }
        return newRowId;
    }

    public Cursor getMember(String id, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                memberDB.COL_NAME,
                memberDB.COL_EMAIL,
                memberDB.COL_ID,
                memberDB.COL_PASSWORD
        };

        String selection = memberDB.COL_ID + " = ? AND " + memberDB.COL_PASSWORD + " = ?";
        String[] selectionArgs = {id, password};

        Cursor cursor = db.query(
                memberDB.TABLE_MEMBER,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }
}