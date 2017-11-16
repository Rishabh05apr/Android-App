package com.example.mcq;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity implements View.OnClickListener {

	
	Button ins,exit,about,scores,exams;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ins=(Button)findViewById(R.id.instructions);
		exit=(Button)findViewById(R.id.exit);
		about=(Button)findViewById(R.id.about);
		scores=(Button)findViewById(R.id.scores);
		exams=(Button)findViewById(R.id.exams);
		
		ins.setOnClickListener(this);
		exit.setOnClickListener(this);
		about.setOnClickListener(this);
		scores.setOnClickListener(this);
		exams.setOnClickListener(this);
		
	
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v == exams)
		{
			Intent i=new Intent(this,Select.class);
		startActivity(i);		
		}
		if(v==ins)
		{
			Dialog d=new Dialog(this);
			d.setTitle("Instructions");
			TextView tv=new TextView(this);
			tv.setText("1-There are 5 questions"+"\n"+"2-All ques carry 1 mark each" +"\n"+"3-Passing score=60%");
			d.setContentView(tv);
			d.show();
		}
		if(v==about)
		{
			Dialog d=new Dialog(this);
			d.setTitle("About");
			TextView tv=new TextView(this);
			tv.setText("Details about the application");
			d.setContentView(tv);
			d.show();
			
			
		}
		if(v==exit)
		{
			finishAffinity();
		}
		if(v== scores)
		{
			Intent i=new Intent(this,Scores.class);
			startActivity(i);
			
			
		}
		
	}

}
