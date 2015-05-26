package com.menu.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menututorial.R;


public class GroupMenuAct extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.common_layout);
		TextView textView = (TextView) findViewById(R.id.common_textView);
		textView.setText("Group MENU ACTIVITY");

		super.onCreate(savedInstanceState);
	}
	
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        // Inflate the menu; this adds items to the action bar if it is present.  
        getMenuInflater().inflate(R.menu.act1_group_menu, menu);//Menu Resource, Menu  
        return true;  
    }  
    @Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
            case R.id.menu1:  
              Toast.makeText(getApplicationContext(),"Menu No. 1 Selected",Toast.LENGTH_SHORT).show();  
            return true;     
           case R.id.menu2:  
                Toast.makeText(getApplicationContext(),"Menu No. 2 Selected",Toast.LENGTH_SHORT).show();  
              return true;     
            case R.id.submenu1:  
                Toast.makeText(getApplicationContext(),"SUB Menu No. 1 Selected",Toast.LENGTH_SHORT).show();  
              return true;     
            case R.id.submenu2:  
            	Toast.makeText(getApplicationContext(),"SUB Menu No. 2 Selected",Toast.LENGTH_SHORT).show();  
            	return true;     
              default:  
                return super.onOptionsItemSelected(item);  
        }  
    }  
	
}
