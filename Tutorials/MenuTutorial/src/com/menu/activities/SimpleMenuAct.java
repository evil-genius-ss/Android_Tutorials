package com.menu.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menututorial.R;


public class SimpleMenuAct extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.common_layout);
		TextView textView = (TextView) findViewById(R.id.common_textView);
		textView.setText("SIMPLE MENU ACTIVITY");

		super.onCreate(savedInstanceState);
	}
	
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.act1_menu, menu);//Menu Resource, Menu  
        return true;  
    }  
    @Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
            case R.id.item1:  
              Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_SHORT).show();  
            return true;     
           case R.id.item2:  
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_SHORT).show();  
              return true;     
            case R.id.item3:  
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_SHORT).show();  
              return true;     
              default:  
                return super.onOptionsItemSelected(item);  
        }  
    }  
	
}
