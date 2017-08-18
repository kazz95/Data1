package com.carol.data1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kazz95 on 12/07/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    //database version to identify the database uniquely. So everytime you make changes to the databse, you increment the version
    private static final int DATABASE_VERSION = 36;

    // database name
    private static final String DATABASE_NAME = "doctors.db"  ;

    //table name
    private static final String TABLE_DOCTORS = "doctors"  ;
    private static final String TABLE_PROFILE = "profile"  ;



    //attributes in the table
    private static final String COLUMN_ID = "_id" ;
    private static final String COLUMN_DOCTORNAME = "doctorname" ;
    private static final String COLUMN_SPECIALITY = "speciality" ;
    private static final String COLUMN_PHONE = "phone" ;
    private static final String COLUMN_EMAIL = "email" ;


    private static final String COLUMN_PID = "_id" ;
    private static final String COLUMN_PROFILE = "name" ;
    private static final String COLUMN_PDOB = "dob" ;
    private static final String COLUMN_PPHONE = "phone" ;
    private static final String COLUMN_PEMAIL = "email" ;
    private static final String COLUMN_AFFTECTEDEAR = "affectedEar" ;
    private static final String COLUMN_OTHER = "other" ;



    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      //  String query1 = "CREATE TABLE " + TABLE_DOCTORS + " ( "
              //  + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
             //   + COLUMN_DOCTORNAME + " TEXT "
               // + COLUMN_SPECIALITY + " TEXT " + ");" ;

        String query = "CREATE TABLE doctors ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "doctorname TEXT, " +
                "speciality TEXT, " +
                "phone TEXT, " +
                "email TEXT )";

        String query1 = "CREATE TABLE profile ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "dob TEXT, " +
                "phone TEXT, " +
                "email TEXT, " +
                "affectedEar TEXT, " +
                "other TEXT )";




        db.execSQL(query);
        db.execSQL(query1);

       Log.i("Message", query) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete existing table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOCTORS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);


        //call onCreate() method to create new table
        onCreate(db);

    }


    public void addDoctor(Doctor doctor){
        // associate each value with content values
        ContentValues values = new ContentValues();
        //method to combine everything so as to insert in the table
        values.put(COLUMN_DOCTORNAME,doctor.get_doctorname());
       values.put(COLUMN_SPECIALITY,doctor.get_speciality());
        values.put(COLUMN_PHONE,doctor.get_phone());
        values.put(COLUMN_EMAIL,doctor.get_email());

        //reference to the database to write something
        SQLiteDatabase db = getWritableDatabase();
        //insert the values
        db.insert(TABLE_DOCTORS, null,values) ;
        //close the database
        db.close();

    }

    public void addProfile(Profile profile){
        // associate each value with content values
        ContentValues values = new ContentValues();
        //method to combine everything so as to insert in the table
        values.put(COLUMN_PROFILE,profile.get_profile());
        values.put(COLUMN_PDOB,profile.get_dob());
        values.put(COLUMN_PPHONE,profile.get_phone());
        values.put(COLUMN_PEMAIL,profile.get_email());
        values.put(COLUMN_AFFTECTEDEAR,profile.get_affectedEar());
        values.put(COLUMN_OTHER,profile.get_other());

        //reference to the database to write something
        SQLiteDatabase db = getWritableDatabase();
        //insert the values
        db.insert(TABLE_PROFILE, null,values) ;
        //close the database
        db.close();

    }

    public void editDoctor (String doctorname, String speciality, String phone, String email ){

        SQLiteDatabase db =getWritableDatabase();
        //ContentValues values = new ContentValues();

        db.execSQL("UPDATE " + TABLE_DOCTORS + " SET " + COLUMN_DOCTORNAME + "=\"" + doctorname  + "\";" );
       /* db.execSQL("UPDATE " + TABLE_DOCTORS + " SET " + COLUMN_SPECIALITY + "=\"" + speciality  + "\";" );
     *   db.execSQL("UPDATE " + TABLE_DOCTORS + " SET " + COLUMN_PHONE + "=\"" + phone  + "\";" );
        */db.execSQL("UPDATE " + TABLE_DOCTORS + " SET " + COLUMN_EMAIL + "=\"" + email  + "\";" );

    }

    public void deleteDoctor(String doctorname){

        SQLiteDatabase db =getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_DOCTORS + " WHERE " + COLUMN_DOCTORNAME + "=\"" + doctorname + "\";");

    }

    public void deleteProfile(String profile){

        SQLiteDatabase db =getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_PROFILE + " WHERE " + COLUMN_PROFILE + "=\"" + profile + "\";");

    }

    public String databaseToString() {

        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        // query to display results
        String query = "SELECT * FROM " + TABLE_DOCTORS + " WHERE 1 ";


        //create cursor to point to current row
        Cursor cursor = db.rawQuery(query, null) ;

        cursor.moveToFirst();


        Log.e("Log",  query);

        //while loop to loop through the table
        while(!cursor.isAfterLast()) {

            if(cursor.getString(cursor.getColumnIndex("doctorname")) != null) {


                for (int i=0; i<cursor.getColumnCount(); i++) {
                    dbString+= cursor.getString(cursor.getColumnIndex("doctorname"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("speciality"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("phone"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("email"));

                    break ;

                }

                dbString+="\n";

            }
            cursor.moveToNext() ;

        }




            //close database
        db.close() ;
        return dbString;
    }


    public String displayProfile() {

        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        // query to display results
        String query = "SELECT * FROM " + TABLE_PROFILE + " WHERE 1 ";


        //create cursor to point to current row
        Cursor cursor = db.rawQuery(query, null) ;

        cursor.moveToFirst();


        Log.e("Log",  query);

        //while loop to loop through the table
        while(!cursor.isAfterLast()) {

            if(cursor.getString(cursor.getColumnIndex("name")) != null) {


                for (int i=0; i<cursor.getColumnCount(); i++) {
                    dbString+= cursor.getString(cursor.getColumnIndex("name"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("dob"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("phone"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("email"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("affectedEar"));
                    dbString+="        ";
                    dbString+= cursor.getString(cursor.getColumnIndex("other"));

                    break ;

                }

                dbString+="\n";

            }
            cursor.moveToNext() ;

        }

        //close database
        db.close() ;
        return dbString;
    }




}
