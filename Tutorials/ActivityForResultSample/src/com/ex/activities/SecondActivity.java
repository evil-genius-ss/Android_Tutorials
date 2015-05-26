package com.ex.activities;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.actforresultsample.R;

public class SecondActivity extends Activity{

	private Button sendBtn;
	private EditText msgEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.act2_layout);
		msgEditText = (EditText) findViewById(R.id.msgEditText);
		sendBtn = (Button) findViewById(R.id.sendMsgButton);
		sendBtn.setOnClickListener(clickListener);
		super.onCreate(savedInstanceState);
	}

	private OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			sendResultToActivity1();
		}
	};

	private void sendResultToActivity1() {

		String msg = msgEditText.getText().toString();
		
		Intent intent=new Intent(); 
		
		int resultCode = MainActivity.RESULT_OK_CODE;
		
		if(msg.isEmpty()){
			msg = "Erorr Message";
			resultCode = MainActivity.RESULT_ERROR_CODE;
		}else {
			resultCode = MainActivity.RESULT_OK_CODE;
		}
		intent.putExtra("MESSAGE",msg);  
		setResult(resultCode,intent); 
		finish();

	}
}
