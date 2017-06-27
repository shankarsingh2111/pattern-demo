package com.example.shankar.patterndemo;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.shankar.patterndemo.template.BeverageTestDrive;

import org.osmdroid.config.Configuration;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Context ctx = getApplicationContext();
		//important! set your user agent to prevent getting banned from the osm servers
		Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));


		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
				BeverageTestDrive.main(new String[]{});
			}
		});

//		container
//		getSupportFragmentManager().beginTransaction()
//				.add(R.id.container, new StarterMapFragment(), StarterMapFragment.class.getName())
//				.commit();

	}

	@Override
	public void onResume(){
		super.onResume();
		//this will refresh the osmdroid configuration on resuming.
		//if you make changes to the configuration, use
		//SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		//Configuration.getInstance().save(this, prefs);
		Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


//	private void animateDown(){
//		if(!animationStarted && scrollView.getVisibility() == View.VISIBLE){
//			Animation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
//					Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1f);
//			translate.setDuration(300);
//			translate.setAnimationListener(new Animation.AnimationListener() {
//				@Override
//				public void onAnimationStart(Animation animation) {
//
//				}
//
//				@Override
//				public void onAnimationEnd(Animation animation) {
//					scrollView.setVisibility(View.GONE);
//					animationStarted = false;
//				}
//
//				@Override
//				public void onAnimationRepeat(Animation animation) {
//
//				}
//			});
//			scrollView.clearAnimation();
//			scrollView.startAnimation(translate);
//			animationStarted = true;
//		}
//	}
//
//	private void animateUp(){
//		Animation translate = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
//				Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0f);
//		translate.setDuration(300);
//		scrollView.setVisibility(View.VISIBLE);
//		scrollView.clearAnimation();
//		scrollView.startAnimation(translate);
//	}

}
