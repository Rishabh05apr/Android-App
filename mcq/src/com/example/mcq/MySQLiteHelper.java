package com.example.mcq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public MySQLiteHelper(Context context, String name,
			SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
		/*
		 * CursorFactory is used to create Cursor Objects with customized
		 * implementation. Use it when you want Cursor from a custom factory
		 * Pass null if you want to use default factory.
		 */
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		String query = "create table Result("
				+ "_id integer primary key autoincrement,"
				+ "date text not null," 
				+ "time text not null," 
				+ "score integer not null" 
				+ ")";
		
		
		db.execSQL(query);
		

		String query1 = "create table Mcqinfo("
				+ "_id integer primary key autoincrement,"
				+ "ques text not null," 
				+ "opa text not null,"
				+ "opb text not null," 
				+ "opc text not null,"
				+ "opd text not null," 
				+ "ans text not null" 
				+ ")";
		
		
		db.execSQL(query1);
		
		
		db.execSQL("Insert into Mcqinfo values(1,'capital of india??','jaipur','mumbai','delhi','chennai','delhi')");
		db.execSQL("Insert into Mcqinfo values(2,'size of int in java??','1 byte','2 byte','4 byte','8 byte','4 byte')");
		db.execSQL("Insert into Mcqinfo values(3,'how many fingers in one hand??','one','three','five','seven','five')");
		db.execSQL("Insert into Mcqinfo values(4,'currency of india??','rs','pound','dollar','euro','rs')");
		db.execSQL("Insert into Mcqinfo values(5,'colour of sky??','blue','pink','green','violet','blue')");
		db.execSQL("Insert into Mcqinfo values(6,'which is not an android version??','kitkat','froyo','jellybean','muffin','muffin')");
		db.execSQL("Insert into Mcqinfo values(7,'how many wings in a fan??','two','three','four','five','three')");
		db.execSQL("Insert into Mcqinfo values(8,'colour of leaf??','green','blue','pink','red','green')");
		db.execSQL("Insert into Mcqinfo values(9,'how many months in a year??','six','eight','ten','twelve','twelve')");
		db.execSQL("Insert into Mcqinfo values(10,'how many days in a week??','five','six','seven','eight','seven')");
		
		String query2 = "create table Android("
				+ "_id integer primary key autoincrement,"
				+ "ques text not null," 
				+ "opa text not null,"
				+ "opb text not null," 
				+ "opc text not null,"
				+ "opd text not null," 
				+ "ans text not null" 
				+ ")";
		
		
		db.execSQL(query2);
		db.execSQL("Insert into Android values(1,'which component is not activated by intent??','activity','services','contentprovider','broadcastreceiver','contentprovider')");
		db.execSQL("Insert into Android values(2,'dialog class is??','alertdialog','processdialog','confirmdialog','all above','alertdialog')");
		db.execSQL("Insert into Android values(3,'builder class can create a??','service','intent','notification','activity','notification')");
		db.execSQL("Insert into Android values(4,'?base class for activity?','applicationcontext','context','basecontext','bundledcontext','context')");
		db.execSQL("Insert into Android values(5,'appropriate to store state of android??','onfreez()','onpause()','onstop()','ondestroy()','onpause()')");
		db.execSQL("Insert into Android values(6,'which is not an android version??','kitkat','froyo','jellybean','muffin','muffin')");
		db.execSQL("Insert into Android values(7,'recommended size unit for font??','px','sp','dp','pt','sp')");
		db.execSQL("Insert into Android values(8,'recommended size unit for component??','px','sp','dp','pt','dp')");
		db.execSQL("Insert into Android values(9,'you can shutdown an activity by??','ondestroy()','finish()','finishactivity()','none','finish()')");
		db.execSQL("Insert into Android values(10,'latest version of android??','jellybean','froyo','kitkat','eclairs','kitkat')");
		
		String query3 = "create table Java("
				+ "_id integer primary key autoincrement,"
				+ "ques text not null," 
				+ "opa text not null,"
				+ "opb text not null," 
				+ "opc text not null,"
				+ "opd text not null," 
				+ "ans text not null" 
				+ ")";
		db.execSQL(query3);
		
		db.execSQL("Insert into Java values(1,'size of short??','1 byte','2 byte','3 byte','4 byte','2 byte')");
		db.execSQL("Insert into Java values(2,'size of byte??','1 byte','2 byte','3 byte','4 byte','1 byte')");
		db.execSQL("Insert into Java values(3,'size of int??','1 byte','2 byte','3 byte','4 byte','4 byte')");
		db.execSQL("Insert into Java values(4,'size of long??','1 byte','2 byte','3 byte','8 byte','8 byte')");
		db.execSQL("Insert into Java values(5,'which of the following is not a layout??','gridlayout','tablelayout','flowlayout','borderlayout','tablelayout')");
		db.execSQL("Insert into Java values(6,'which is not an access modifier??','public','private','protected','secure','secure')");
		db.execSQL("Insert into Java values(7,'super should be the first statement in method??','yes','no','dont knw','none','yes')");
		db.execSQL("Insert into Java values(8,'java is platform dependent??','yes','no','dont knw','none','no')");
		db.execSQL("Insert into Java values(9,'after compiling d code,which file is generated??','.exe','.class','.mkv','.mp3','.class')");
		db.execSQL("Insert into Java values(10,'class name should start with??','capital letter','small letter','symbol','any of d above','capital letter')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		String query = "drop table if exists Mcqinfo";
		db.execSQL(query);
		onCreate(db);

	}

}
