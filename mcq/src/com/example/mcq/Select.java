package com.example.mcq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Select extends Activity implements View.OnClickListener{
	
	CheckBox cb1,cb2,cb3;
	Button btn;
	Intent i;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		
		btn=(Button)findViewById(R.id.start);
		cb1=(CheckBox)findViewById(R.id.scb1);
		cb2=(CheckBox)findViewById(R.id.scb2);
		cb3=(CheckBox)findViewById(R.id.scb3);
		
		cb1.setOnClickListener(this);
		cb2.setOnClickListener(this);
		cb3.setOnClickListener(this);
		btn.setOnClickListener(this);
	}
	
 @Override
 		public void onClick(View v) {
	// TODO Auto-generated method stub
	
	 if(v==cb1)
	 {
		 i=new Intent(getBaseContext(),Que.class);
		 i.putExtra("value", 1);
		
		 }
	 if(v==cb2)
	 {
		 i=new Intent(getBaseContext(),Que.class);
		 i.putExtra("value", 2);
	 }
	 
	 if(v==cb3)
	 {
		 i=new Intent(getBaseContext(),Que.class);
		 i.putExtra("value", 3);
	}
	 if(v==btn)
	 {
		 startActivity(i);
	 }
	 
 		}
}
