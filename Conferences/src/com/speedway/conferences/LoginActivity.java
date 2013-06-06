package com.speedway.conferences;

import com.parse.ParseException;
import com.parse.ParseUser;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class LoginActivity extends Activity implements OnClickListener {

	private Button loginBtn;
	private Button helpBtn;
	private String user;
	private String password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// Set on click listeners for buttons
		loginBtn = (Button) findViewById(R.id.loginBtn);
		loginBtn.setOnClickListener(this);
		helpBtn = (Button) findViewById(R.id.helpBtn);
		helpBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginBtn:
			Log.d("Button", "You clicked Login.");
			System.out.println("Login Button");

			// Create an error dialog if credentials are invalids
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					v.getContext());
			alertDialogBuilder.setTitle("Invalid Login");
			alertDialogBuilder
			.setMessage("Your login credentials are incorrect. Please try again or select" +
					"help for additional information.")
					.setCancelable(false)
					.setPositiveButton("Okay",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							dialog.cancel();
						}
					});
			/*
					.setNegativeButton("Quit",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							LoginActivity.this.finish();
						} 
					}); 
			 */


			// Get the username and password from input
			EditText userInput = (EditText) findViewById(R.id.userEdit);
			EditText passInput = (EditText) findViewById(R.id.passwordEdit);
			user = userInput.getText().toString();
			password = passInput.getText().toString();

			// If login is blank, show dialog
			if(password.isEmpty() || user.isEmpty()) {
				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}

			else {
				// If login credentials are correct
				try {
					ParseUser.logIn(user, password);
					Toast.makeText(this, "Success! Found you in database.", Toast.LENGTH_LONG)
					.show();
					Intent in = new Intent(v.getContext(), TabActivity.class);
					startActivity(in);
				} 
				// Otherwise show error dialog
				catch (ParseException e) {
					AlertDialog alertDialog = alertDialogBuilder.create();
					alertDialog.show();
				} 
			}
			
			break;
		case R.id.helpBtn:
			Log.d("Button", "You clicked Help.");
			Toast.makeText(this, "Help me!!", Toast.LENGTH_LONG)
			.show();
			break;
		}
	}

}
