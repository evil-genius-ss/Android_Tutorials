package com.tutrial.menu;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.menututorial.R;
import com.menu.activities.GroupMenuAct;
import com.menu.activities.GroupMenuByProgram;
import com.menu.activities.IconMenuAct;
import com.menu.activities.SimpleMenuAct;


public class MainAct extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_act_layout);
		Button simpleMenuBtn = (Button) findViewById(R.id.sMenuActivityBtn);
		Button iconMenuBtn = (Button) findViewById(R.id.iconMenuActivityBtn);
		Button groupMenuBtn = (Button) findViewById(R.id.groupMenuActivityBtn);
		Button groupByProgramMenuBtn = (Button) findViewById(R.id.groupByProgMenuActivityBtn);
		
		simpleMenuBtn.setOnClickListener(this);
		iconMenuBtn.setOnClickListener(this);
		groupMenuBtn.setOnClickListener(this);
		groupByProgramMenuBtn.setOnClickListener(this);
		

		super.onCreate(savedInstanceState);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.sMenuActivityBtn:
			intent = new Intent(MainAct.this, SimpleMenuAct.class);
			break;
		case R.id.iconMenuActivityBtn:
			intent = new Intent(MainAct.this, IconMenuAct.class);
			break;
		case R.id.groupMenuActivityBtn:
			intent = new Intent(MainAct.this, GroupMenuAct.class);
			break;
		case R.id.groupByProgMenuActivityBtn:
			intent = new Intent(MainAct.this, GroupMenuByProgram.class);
			break;

		default:
			break;
		}
		if(intent != null){
			MainAct.this.startActivity(intent);
		}
	}
	
	
}
