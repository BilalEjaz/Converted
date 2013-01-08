package com.BD.com.bdcoverter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	
	private EditText text;
	RadioButton fahrenheitButton;
	RadioButton celsiusButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (EditText) findViewById(R.id.inputTempData);
		celsiusButton = (RadioButton)findViewById(R.id.celciusButton);
		fahrenheitButton = (RadioButton)findViewById(R.id.fahrenheitButton);

	}

	

	
	public void onClick(View View){
		switch (View.getId()){
		case R.id.calculatebutton:
			celsiusButton = (RadioButton)findViewById(R.id.celciusButton);
			fahrenheitButton = (RadioButton)findViewById(R.id.fahrenheitButton);
		
		// Validation occurs here	
			if(text.getText().length() == 0){
				Toast.makeText(this, "Please enter valid number", Toast.LENGTH_LONG).show();
			
	return;
	}
	float inputvalue = Float.parseFloat(text.getText().toString());
	if (celsiusButton.isChecked()){
		text.setText(String.valueOf(convertFahrenheitToCelsius(inputvalue)));
		celsiusButton.setChecked(false);
		fahrenheitButton.setChecked(true);
	}else{
			text.setText(String.valueOf(convertCelsiusToFahrenheit(inputvalue)));
			celsiusButton.setChecked(true);
			fahrenheitButton.setChecked(false);
		}
			break;
	  }
	}
	
	  private float convertFahrenheitToCelsius(float fahrenheit) {
		    return ((fahrenheit - 32) * 5 / 9);
		  }

		  // Converts to fahrenheit
		  private float convertCelsiusToFahrenheit(float celsius) {
		    return ((celsius * 9) / 5) + 32;
		  }
	
	
}


