package com.pckages.main;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ex.androiddialogs.R;

/**
 * @author M.Subhan
 *
 */
public class LauncherAct extends Activity {
	
	//Class Fields
	private EditText customEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_lay);
		
		//Alert Dialog Button
		Button showBtn = (Button) findViewById(R.id.showBtn);
		showBtn.setOnClickListener(clickListener);

		//Custom Alert Dialog Button
		Button showCustomBtn = (Button) findViewById(R.id.showCustomBtn);
		showCustomBtn.setOnClickListener(clickListener);
		
		// Dialog Button
		Button showDialogBtn = (Button) findViewById(R.id.showCustomDialogBtn);
		showDialogBtn.setOnClickListener(clickListener);
		super.onCreate(savedInstanceState);
	}

	private OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.showBtn:
				showIconAlertDialog();
				break;
			case R.id.showCustomBtn:
				showCustomAlertDialog();
				break;
			case R.id.showCustomDialogBtn:
				showCustomCreatedDialog();
				break;

			default:
				break;
			}
			
		}
	};
	
	//Simple Alert Dialog
	private void showIconAlertDialog() {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("This is Title");
		alertDialog.setMessage("This is Message");
		alertDialog.setCancelable(false);
		alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				Toast.makeText(LauncherAct.this, "Positive Button Clicked", Toast.LENGTH_LONG).show();
			}
		});
		alertDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				Toast.makeText(LauncherAct.this, "Negative Button Clicked", Toast.LENGTH_LONG).show();
			}
		});
		alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
		alertDialog.show();
	}
	
	
	//Custom Alert Dialog
	private void showCustomAlertDialog() {
		LayoutInflater inflater =  (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View customView = inflater.inflate(R.layout.custom_view_lay,null,false);
		customEditText = (EditText) customView.findViewById(R.id.CustomEdit);
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//		alertDialog.setTitle("This is Title");
//		alertDialog.setMessage("Show Input Text in Toast?");
		alertDialog.setView(customView);
		alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) { 
				Toast.makeText(LauncherAct.this, customEditText.getText().toString(), Toast.LENGTH_LONG).show();
			}
		});
//		alertDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int which) { 
//				Toast.makeText(LauncherAct.this, "Negative Button Clicked", Toast.LENGTH_LONG).show();
//			}
//		});
		alertDialog.show();
	}

	//Simple Alert Dialog
		private void showAppQiutDialog() {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("QUIT APPLICATION");
			alertDialog.setMessage("Are you sure you want to quit Application?");

			alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
					LauncherAct.this.finish();
				}
			});
			alertDialog.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) { 
//					Toast.makeText(LauncherAct.this, "Negative Button Clicked", Toast.LENGTH_LONG).show();
				}
			});
			alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
			alertDialog.show();
		}
	
		
		private void showCustomCreatedDialog() {
			CustomDialog customDialog = new CustomDialog(this);
			customDialog.createDialog();
			customDialog.showDilog();
		}
		
	
	@Override
	public void onBackPressed() {
		showAppQiutDialog();
	}
	
}
