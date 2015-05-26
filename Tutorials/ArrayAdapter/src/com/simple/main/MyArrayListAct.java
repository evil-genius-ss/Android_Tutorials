package com.simple.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.simplearray.R;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MyArrayListAct extends ListActivity{

	private Cursor mCursor;
	private ArrayList<String> arrayListItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.list_act_layout);
		//Either
		populateFromStringFolder();
		//or
//		populateCustomArrayList();


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.row_text1,arrayListItems);

		//Either
		ListView listView = getListView();
		listView.setAdapter(adapter);
		//or
		//setListAdapter(adapter);


		super.onCreate(savedInstanceState);
	}



	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String selectedItem = (String) getListView().getItemAtPosition(position);
		Toast.makeText(MyArrayListAct.this, selectedItem, Toast.LENGTH_SHORT).show();
		super.onListItemClick(l, v, position, id);
	}

	private void populateCustomArrayList() {
		arrayListItems = new ArrayList<String>();
		arrayListItems.add("A1");
		arrayListItems.add("A2");
		arrayListItems.add("A3");
		arrayListItems.add("A4");
		arrayListItems.add("A5");
		arrayListItems.add("A6");
		arrayListItems.add("A7");
		arrayListItems.add("A1");arrayListItems.add("A3");
		arrayListItems.add("A4");
		arrayListItems.add("A5");
		arrayListItems.add("A6");
		arrayListItems.add("A7");
		arrayListItems.add("A1");arrayListItems.add("A3");
		arrayListItems.add("A4");
		arrayListItems.add("A5");
		arrayListItems.add("A6");
		arrayListItems.add("A7");
		arrayListItems.add("A1");
		arrayListItems.add("A3");
		arrayListItems.add("A4");
		arrayListItems.add("A5");
		arrayListItems.add("A6");
		arrayListItems.add("A7");
		arrayListItems.add("A1");
		arrayListItems.add("A3");
		arrayListItems.add("A4");
		arrayListItems.add("A5");
		arrayListItems.add("A6");
		arrayListItems.add("A7");
		arrayListItems.add("A1");
	}
	private void populateFromStringFolder() {
		arrayListItems = new ArrayList<String>();
		
//		getResources().getString(R.string.person);
		String[] countries =  getResources().getStringArray(R.array.country_array);
		arrayListItems = new ArrayList<String>(Arrays.asList(countries));
	}

}
