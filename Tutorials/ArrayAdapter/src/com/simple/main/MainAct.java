package com.simple.main;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.simplearray.R;

public class MainAct extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_act_layout);
		Button mainBtn = (Button) findViewById(R.id.mainActButton);
		mainBtn.setOnClickListener(listener);
		super.onCreate(savedInstanceState);
	}
	
	private  OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainAct.this, MyArrayListAct.class);
			MainAct.this.startActivity(intent);

		}
	};

}
