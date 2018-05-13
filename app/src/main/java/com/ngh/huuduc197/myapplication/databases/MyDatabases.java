package com.ngh.huuduc197.myapplication.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ngh.huuduc197.myapplication.models.Link;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyennhan on 5/13/18.
 */

public class MyDatabases extends SQLiteOpenHelper {

    public static String DB_NAME = "DB";
    public static int DB_VERSION = 1;
    public static String DB_TABLE = "BROWSERS";
    public static String DB_ID = "ID";
    public static String DB_TITLE = "TITLE";
    public static String DB_URL = "URL";

    public static String TAG = "DB";

    public MyDatabases(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =  "CREATE TABLE " + DB_TABLE + "("
                + DB_ID + " INTEGER PRIMARY KEY," + DB_TITLE + " TEXT,"
                + DB_URL + " TEXT" + ")";

        db.execSQL(sql);
        Log.e("DB","onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
        Log.e("DB","onUpgrade");
    }

    public void createDefaultLinks() {
        Log.i(TAG, "createDefaultLinks ... " );
        int count = this.getCountsLink();
        if(count ==0 ) {
            Link link = new Link("Trường ĐH Nguyễn Tất Thành",
                    "http://ntt.edu.vn/web/");
            Link link2 = new Link("Trường ĐH Nguyễn Tất Thành công bô phương thức xét tuyển và tuyển sinh 4 ngành mới\n",
                    "http://ntt.edu.vn/web/tin-tuc/truong-dh-nguyen-tat-thanh-cong-bo-phuong-thuc-xet-tuyen-va-tuyen-sinh-4-nganh-moi");
            this.addLink(link);
            this.addLink(link2);
        }
    }

    public int getCountsLink() {
        Log.i(TAG, "getCountsLink ... " );

        String countQuery = "SELECT  * FROM " + DB_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        return count;
    }

    public void addLink(Link link) {
        Log.i(TAG, "addLink ... " + link.getTitle());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DB_TITLE, link.getTitle());
        values.put(DB_URL, link.getUrl());

        db.insert(DB_TABLE, null, values);
        db.close();
    }

    public List<Link> getAllLinks() {
        Log.i(TAG, "getAllLinks ... " );

        List<Link> links = new ArrayList<Link>();
        String selectQuery = "SELECT  * FROM " + DB_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Link link = new Link();

                link.set_id(Integer.parseInt(cursor.getString(0)));
                link.setTitle(cursor.getString(1));
                link.setUrl(cursor.getString(2));

                links.add(link);
            } while (cursor.moveToNext());
        }
        return links;
    }

    public void deleteLink(Link link) {
        Log.i(TAG, "deleteLink ... " + link.getTitle() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLE, DB_ID + " = ?",
                new String[] { String.valueOf(link.get_id()) });
        db.close();
    }
}
