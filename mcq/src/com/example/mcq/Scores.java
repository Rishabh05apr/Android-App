package com.example.mcq;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Scores extends Activity {

	MySQLiteHelper helper;
	SQLiteDatabase db;
	Cursor cursor;
	TextView score,time,date;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scores);
		
		helper = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
		db = helper.getReadableDatabase();
		
		String sc,da,ti;
		cursor = db.rawQuery("Select * from Result", null);
		
	
		score=(TextView)findViewById(R.id.score);
		date=(TextView)findViewById(R.id.date);
		time=(TextView)findViewById(R.id.time);
		
		while(cursor.moveToNext())
		{
			da = cursor.getString(1);
			ti = cursor.getString(2);
			sc = cursor.getString(3);
			
			score.append("\n"+sc+" ");
			date.append("\n"+da+" ");
			time.append("\n"+ti+" ");
			
		}
		
	}
	
	
}
