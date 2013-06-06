package com.speedway.conferences;

import com.parse.Parse;
import com.parse.ParseACL;

import com.parse.ParseUser;

import android.app.Application;

public class ConferencesApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		String applicationID = "oTaXBo23Q4S7xkfL9mmFceO5moSIdDYcdPjVMIGx";
		String clientKey = "yGHJIpJfueFviE3yXatSL12X62ZI7OsdBy6dBsTa";
		Parse.initialize(this, applicationID, clientKey);

		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		// Optionally enable public read access.
		// defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);
	}

}
