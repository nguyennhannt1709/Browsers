package com.ngh.huuduc197.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Browser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huuduc on 09/05/2018.
 */

public class KetNoiDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME="quanlyWeb";
    private static final String TABLE_BROWSER = "Browser";
    private static final String KEY_ID = "_id";
    private static final String COL_NAME = "link";

    public KetNoiDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE= "CREATE TABLE " + TABLE_BROWSER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + COL_NAME + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Hủy (drop) bảng cũ nếu nó đã tồn tại.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BROWSER);
        // Và tạo lại.
        onCreate(db);
    }

    public void add(String link) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(COL_NAME, browser.getNoteTitle());
        values.put(COL_NAME, link);


        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TABLE_BROWSER, null, values);


        // Đóng kết nối database.
        db.close();
    }

    // dung cusor duyet va lay tat ca BR
    public Cursor LayTatCaBr() {
        SQLiteDatabase mDb = this.getWritableDatabase();
        Cursor mCursor = mDb.query(TABLE_BROWSER, new String[] {KEY_ID,
                        COL_NAME },
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public List<getSet> getAllNotes() {


        List<getSet> noteList = new ArrayList<getSet>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BROWSER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                getSet note = new getSet();
                note.setIdCV(Integer.parseInt(cursor.getString(0)));
                note.setTenCV(cursor.getString(1));


                // Thêm vào danh sách.
                noteList.add(note);
            } while (cursor.moveToNext());
        }

        // return note list
        return noteList;
    }



}
