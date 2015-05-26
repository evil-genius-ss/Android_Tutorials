package com.menu.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menututorial.R;


public class GroupMenuByProgram extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.common_layout);
		TextView textView = (TextView) findViewById(R.id.common_textView);
		textView.setText("Group MENU By Program ACTIVITY");

		super.onCreate(savedInstanceState);
	}

	@Override  
	public boolean onCreateOptionsMenu(Menu menu) {  
		int MENU3 = 1;
		int MENU4 = 2;
		int GROUP1 = 6;
		int SUBMENU1 = 3;
		int SUBMENU2 = 4;
		// Inflate the menu; this adds items to the action bar if it is present.  
		//        getMenuInflater().inflate(R.menu.act1_group_menu, menu);//Menu Resource, Menu 
		MenuItem menu3 = menu.add(Menu.NONE, 1, 3, "Menu No. 3");

		SubMenu menu4 = menu.addSubMenu(Menu.NONE, 4, 4,"Menu No. 4");

		menu4.add(GROUP1, SUBMENU1, 1, "SubMenu No. 1");
		menu4.add(GROUP1, SUBMENU2, 2, "SubMenu No. 2");
		menu4.setGroupCheckable(GROUP1,false,true);

		return super.onCreateOptionsMenu(menu);  
	}  
	@Override  
	public boolean onOptionsItemSelected(MenuItem item) {  
		switch (item.getItemId()) {  
		case 1:  
			Toast.makeText(getApplicationContext(),"Menu No. 3 Selected",Toast.LENGTH_SHORT).show();  
			return true;     
		case 2:  
			Toast.makeText(getApplicationContext(),"Menu No. 4 Selected",Toast.LENGTH_SHORT).show();  
			return true;     
		case 3:  
			Toast.makeText(getApplicationContext(),"SUB Menu No. 1 Selected",Toast.LENGTH_SHORT).show();  
			return true;     
		case 4:  
			Toast.makeText(getApplicationContext(),"SUB Menu No. 2 Selected",Toast.LENGTH_SHORT).show();  
			return true;     
		default:  
			return super.onOptionsItemSelected(item);  
		}  
	}  

}
