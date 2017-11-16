package com.example.mcq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity implements OnClickListener{
	TextView txt1,txt2,txt3;
	Button btn1,btn2;
	int arr[];
	int num;
	int attempt,wrong,score;
	int cb[];
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
	
		arr=new int[5];
		cb=new int[5];
		txt1=(TextView)findViewById(R.id.result);
		txt2=(TextView)findViewById(R.id.attempt);
		txt3=(TextView)findViewById(R.id.wrong);
		
		btn1=(Button)findViewById(R.id.home);
		btn2=(Button)findViewById(R.id.review);
		
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		
		Bundle bundle=getIntent().getExtras();
		txt1.setText("your result"+"="+bundle.getInt("scr")+"%");
		txt2.setText("attempt:"+"="+bundle.getInt("atmpt"));
		
		txt3.setText("wrong:"+"="+bundle.getInt("wrng"));
		arr=bundle.getIntArray("array");
		num=bundle.getInt("number");
		attempt=bundle.getInt("atmpt");
		wrong=bundle.getInt("wrng");
		cb=bundle.getIntArray("cbarray");
		score=bundle.getInt("scr");
		
}
	public void onClick(View v)
	{
		if(v==btn1)
		{
			Intent i=new Intent(getBaseContext(),MainActivity.class);
			startActivity(i);	
		}
		if(v==btn2)
		{
			Intent i=new Intent(getBaseContext(),Que.class);
			i.putExtra("value", num);
			i.putExtra("array", arr);
			i.putExtra("bool", true);
			i.putExtra("atmpt", attempt);
			i.putExtra("wrng", wrong);
			i.putExtra("scr", score);
			i.putExtra("cbarray", cb);
			startActivity(i);
			
		}
	}
}