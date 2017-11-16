package com.example.mcq;

import java.util.Calendar;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


		public class Que extends Activity implements View.OnClickListener {

			MySQLiteHelper helper;
			SQLiteDatabase db;
			int arr[];
			TextView txt1, txt2, txt3, txt4, question;
			String ques, opa, opb, opc, opd, ans;
			Button next, previous;
			Cursor cursor;
			boolean b;
			int k=0;
			CheckBox cb1,cb2,cb3,cb4;
			String answer[];
			String uanswer[];
			int cb[];
			int count;
			int attempt[];
			int wrong;
			int count1;
			Calendar c;
			ContentValues values ;
			boolean bool=false;
			int num;
			Bundle bundle;
			
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.que);
				
	
				bundle = getIntent().getExtras();
				num = bundle.getInt("value");
				
				try
				{
					bool=bundle.getBoolean("bool");
				}
				catch(Exception e)
				{}
				
			
				helper = new MySQLiteHelper(getBaseContext(), "mydatabase.db", null, 1);
				db = helper.getWritableDatabase();
				
				
				switch(num)
				{
					case 1:cursor = db.rawQuery("Select * from Mcqinfo", null);
					break;
					case 2:cursor = db.rawQuery("Select * from Android", null);
					break;
					case 3:cursor = db.rawQuery("Select * from Java", null);
					break;
				}
				

				cb1=(CheckBox)findViewById(R.id.cb1);
				cb2=(CheckBox)findViewById(R.id.cb2);
				cb3=(CheckBox)findViewById(R.id.cb3);
				cb4=(CheckBox)findViewById(R.id.cb4);
				txt1 = (TextView) findViewById(R.id.txt1);
				txt2 = (TextView) findViewById(R.id.txt2);
				txt3 = (TextView) findViewById(R.id.txt3);
				txt4 = (TextView) findViewById(R.id.txt4);
				question = (TextView) findViewById(R.id.textview);
				next = (Button) findViewById(R.id.next);
				previous = (Button) findViewById(R.id.previous);
				next.setOnClickListener(this);
				previous.setOnClickListener(this);
				
				
				cb1.setOnClickListener(this);
				cb2.setOnClickListener(this);
				cb3.setOnClickListener(this);
				cb4.setOnClickListener(this);
				
				
				if(bool==true)
				{
					cb1.setEnabled(false);
					cb2.setEnabled(false);
					cb3.setEnabled(false);
					cb4.setEnabled(false);
					
					
				}
				
				arr = new int[5];
				attempt = new int[5];
				answer=new String[5];
				uanswer=new String[5];
				cb=new int[5];
				boolean flag;
				
				for (int j = 0; j < 5; ) {
					flag=true;
					int y = (int) (Math.random() * 10);
					for(int m=0;m<=j;m++)
					{
						if(arr[m]==y)
						{
							flag=false;
						}
					}
					if(flag==true)
					{
						arr[j]=y;
						j++;
					}
				}
				
				
				for(int g=0;g<5;g++)
				{
					attempt[g]=0;
					}
					
				if(bool==true)
				{
					arr=bundle.getIntArray("array");
					cb=bundle.getIntArray("cbarray");
				}
				
				
				b = cursor.moveToPosition(arr[0]);

				ques = cursor.getString(1);
				opa = cursor.getString(2);
				opb = cursor.getString(3);
				opc = cursor.getString(4);
				opd = cursor.getString(5);
				ans = cursor.getString(6);
				answer[0]=ans;
				
				txt1.setText(opa);
				txt2.setText(opb);
				txt3.setText(opc);
				txt4.setText(opd);
				question.setText("ques 1:"+ques);
				
				if(bool==true)
				{if(cb[0]==1)
					cb1.setChecked(true);
				else if(cb[0]==2)
					cb2.setChecked(true);
				else if(cb[0]==3)
					cb3.setChecked(true);
				else if(cb[0]==4)
					cb4.setChecked(true);
				
				if(bool==true)
				{
					if(txt1.getText().equals(ans))
						txt1.setTextColor(Color.GREEN);
					else if(txt2.getText().equals(ans))
						txt2.setTextColor(Color.GREEN);
					else if(txt3.getText().equals(ans))
						txt3.setTextColor(Color.GREEN);
					else if(txt4.getText().equals(ans))
						txt4.setTextColor(Color.GREEN);
					
				}
				
				}
				
				
			}

			@Override
			public boolean onCreateOptionsMenu(Menu menu) {
				// Inflate the menu; this adds items to the action bar if it is present.
				getMenuInflater().inflate(R.menu.main, menu);
				return true;
			}

			public boolean onOptionsItemSelected(MenuItem item) {
				
				
				c=Calendar.getInstance();
				count=0;
				count1=0;
				try
				{for(int j=0;j<5;j++)
				{
					if(answer[j].equals(uanswer[j]))
					{
						count++;
					}
				}
				}
				catch(Exception e)
				{
					
				}
				
				
				for(int j=0;j<5;j++)
				{
					if(attempt[j]==1)
					count1++;
					
				}
				
				int wrg=count1-count;
				
				String date=c.get(Calendar.DAY_OF_MONTH)+ ":" + c.get(Calendar.MONTH)+ ":" + c.get(Calendar.YEAR);
				
				String time = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) ;
				int x=(count*100)/5;
				
				values = new ContentValues();
				
				values.put("score", x);
				values.put("date", date);
				values.put("time", time);
				
				
				// insert(TableName, NullColumn, ContentValues);
				if(bool==false)
				{long id = db.insert("Result",null, values);}
				
				if(bool==true)
				{
					count1=bundle.getInt("atmpt");
					wrg=bundle.getInt("wrng");
					x=bundle.getInt("scr");
				}
				
				Intent i = new Intent(getBaseContext(), Score.class);
				i.putExtra("scr",x);
				i.putExtra("atmpt",count1);
				i.putExtra("wrng", wrg);
				i.putExtra("array", arr);
				i.putExtra("number", num);
				i.putExtra("cbarray", cb);
				startActivity(i);
				return true;
			}

			public void onClick(View v) {
				if (v == next) {
					cb1.setChecked(false);
					cb2.setChecked(false);
					cb3.setChecked(false);
					cb4.setChecked(false);
					k++;
					if(k==5)
					{
						k=0;
					}
					b = cursor.moveToPosition(arr[k]);

					ques = cursor.getString(1);
					opa = cursor.getString(2);
					opb = cursor.getString(3);
					opc = cursor.getString(4);
					opd = cursor.getString(5);
					ans = cursor.getString(6);
					answer[k]=ans;
					

					txt1.setText(opa);
					txt2.setText(opb);
					txt3.setText(opc);
					txt4.setText(opd);
					int q=k+1;
					question.setText("ques "+q+":"+ques);
					
					
					if(cb[k]==1)
						cb1.setChecked(true);
					else if(cb[k]==2)
						cb2.setChecked(true);
					else if(cb[k]==3)
						cb3.setChecked(true);
					else if(cb[k]==4)
						cb4.setChecked(true);
					
					if(bool==true)
					{
						if(txt1.getText().equals(ans))
							{txt1.setTextColor(Color.GREEN);
							txt2.setTextColor(Color.BLACK);
							txt3.setTextColor(Color.BLACK);
							txt4.setTextColor(Color.BLACK);
							}
						else if(txt2.getText().equals(ans))
						{txt1.setTextColor(Color.BLACK);
						txt2.setTextColor(Color.GREEN);
						txt3.setTextColor(Color.BLACK);
						txt4.setTextColor(Color.BLACK);
						}
						else if(txt3.getText().equals(ans))
						{txt1.setTextColor(Color.BLACK);
						txt2.setTextColor(Color.BLACK);
						txt3.setTextColor(Color.GREEN);
						txt4.setTextColor(Color.BLACK);
						}
						else if(txt4.getText().equals(ans))
						{txt1.setTextColor(Color.BLACK);
						txt2.setTextColor(Color.BLACK);
						txt3.setTextColor(Color.BLACK);
						txt4.setTextColor(Color.GREEN);
						}
						
					}

						
						
				}
				if(v==previous)
				{
					
					cb1.setChecked(false);
					cb2.setChecked(false);
					cb3.setChecked(false);
					cb4.setChecked(false);
					k--;
					if(k==-1)
					{k=4;}
					b = cursor.moveToPosition(arr[k]);

					ques = cursor.getString(1);
					opa = cursor.getString(2);
					opb = cursor.getString(3);
					opc = cursor.getString(4);
					opd = cursor.getString(5);
					ans = cursor.getString(6);

					txt1.setText(opa);
					txt2.setText(opb);
					txt3.setText(opc);
					txt4.setText(opd);
					int p=k+1;
					question.setText("ques "+p+":"+ques);
					
					if(cb[k]==1)
						cb1.setChecked(true);
					else if(cb[k]==2)
						cb2.setChecked(true);
					else if(cb[k]==3)
						cb3.setChecked(true);
					else if(cb[k]==4)
						cb4.setChecked(true);
					
					if(bool==true)
					{
						if(txt1.getText().equals(ans))
							{txt1.setTextColor(Color.GREEN);
							txt2.setTextColor(Color.BLACK);
							txt3.setTextColor(Color.BLACK);
							txt4.setTextColor(Color.BLACK);
							}
						else if(txt2.getText().equals(ans))
						{txt1.setTextColor(Color.BLACK);
						txt2.setTextColor(Color.GREEN);
						txt3.setTextColor(Color.BLACK);
						txt4.setTextColor(Color.BLACK);
						}
						else if(txt3.getText().equals(ans))
						{txt1.setTextColor(Color.BLACK);
						txt2.setTextColor(Color.BLACK);
						txt3.setTextColor(Color.GREEN);
						txt4.setTextColor(Color.BLACK);
						}
						else if(txt4.getText().equals(ans))
						{txt1.setTextColor(Color.BLACK);
						txt2.setTextColor(Color.BLACK);
						txt3.setTextColor(Color.BLACK);
						txt4.setTextColor(Color.GREEN);
						}
						
					}

				}
				
				
				if(v==cb1)
				{
					if(cb1.isChecked())
					{
				uanswer[k]=txt1.getText()+"";
				cb[k]=1;
	            		cb2.setChecked(false);
				cb3.setChecked(false);
				cb4.setChecked(false);
				attempt[k]=1;
					}
					else
					{
						uanswer[k]="";
						cb[k]=0;
						attempt[k]=0;
					}
				}
				if(v==cb2)
				{
					if(cb2.isChecked())
					{
				uanswer[k]=txt2.getText()+"";
				cb[k]=2;
				cb1.setChecked(false);
				cb3.setChecked(false);
				cb4.setChecked(false);
				attempt[k]=1;
					}
					else
					{
						uanswer[k]="";
						cb[k]=0;
						attempt[k]=0;
					}
				}
				
				if(v==cb3)
				{
					if(cb3.isChecked())
					{
				uanswer[k]=txt3.getText()+"";
				cb[k]=3;
				cb1.setChecked(false);
				cb2.setChecked(false);
				cb4.setChecked(false);
				attempt[k]=1;
					}
					else
					{
						uanswer[k]="";
						cb[k]=0;
						attempt[k]=0;
					}
				}
				
				if(v==cb4)
				{
					if(cb4.isChecked())
					{
				uanswer[k]=txt4.getText()+"";
				cb[k]=4;
				cb1.setChecked(false);
				cb2.setChecked(false);
				cb3.setChecked(false);
				attempt[k]=1;
					}
					else
					{
						uanswer[k]="";
						cb[k]=0;
						attempt[k]=0;
					}
				}		
			}
		}