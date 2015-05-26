package com.pckages.main;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ex.androiddialogs.R;

public class CustomDialog {

	private Dialog mDialog;
	private Context mContext;
	private Button cancelButton;


	public CustomDialog(Context context) {
		mContext = context;
	}


	public void createDialog(){
		LayoutInflater inflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View customView = inflater.inflate(R.layout.dialog_layout,null,false);
		mDialog = new Dialog(mContext,android.R.style.Theme_NoTitleBar_Fullscreen);
		mDialog.setContentView(customView);
		cancelButton = (Button)customView.findViewById(R.id.canelBtn);
		cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cancelDialog();
				
			}
		});
	}

	public void showDilog(){
		mDialog.show();
	}

	public void hideDialog(){
		mDialog.hide();
	}

	public void cancelDialog(){
		mDialog.cancel();
	}

}
