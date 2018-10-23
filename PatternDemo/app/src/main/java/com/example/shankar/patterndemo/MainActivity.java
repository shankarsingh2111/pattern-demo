package com.example.shankar.patterndemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shankar.patterndemo.iterator.MenuTestDrive;
import com.example.shankar.patterndemo.qrgenerator.QRGContents;
import com.example.shankar.patterndemo.qrgenerator.QRGEncoder;
import com.google.zxing.WriterException;

import org.osmdroid.config.Configuration;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ServiceConnection {
	private LocalWordService s;
	private ArrayList<String> wordList;
	private ArrayAdapter<String> adapter;
	private ImageView ivQR;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.list);
		wordList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, wordList);
		listView.setAdapter(adapter);

		ivQR = (ImageView) findViewById(R.id.ivQR);

		Context ctx = getApplicationContext();
		//important! set your user agent to prevent getting banned from the osm servers
		Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));


		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//						.setAction("Action", null).show();
				MenuTestDrive.main();
//				Util.scheduleJob(MainActivity.this);
//				startActivity(new Intent(MainActivity.this, PlayerActivity.class));
			}
		});

//		container
//		getSupportFragmentManager().beginTransaction()
//				.add(R.id.container, new StarterMapFragment(), StarterMapFragment.class.getName())
//				.commit();

//		IntentFilter filter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
//		MediaButtonIntentReceiver r = new MediaButtonIntentReceiver();
//		registerReceiver(r, filter);


//		((AudioManager)getSystemService(AUDIO_SERVICE)).registerMediaButtonEventReceiver(
//				new ComponentName(
//						getPackageName(),
//						MediaButtonIntentReceiver.class.getName()));

		TesterKt.start();

	}

	@Override
	protected void onResume() {
		super.onResume();
		//this will refresh the osmdroid configuration on resuming.
		//if you make changes to the configuration, use
		//SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		//Configuration.getInstance().save(this, prefs);
		Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
		Intent intent= new Intent(this, LocalWordService.class);
		bindService(intent, this, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unbindService(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
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

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.updateList:
				if (s != null) {
					Toast.makeText(this, "Number of elements" + s.getWordList().size(),
							Toast.LENGTH_SHORT).show();
					wordList.clear();
					wordList.addAll(s.getWordList());
					adapter.notifyDataSetChanged();
				}
				break;
			case R.id.triggerServiceUpdate:
				Intent service = new Intent(getApplicationContext(), LocalWordService.class);
				getApplicationContext().startService(service);

				QRGEncoder qrgEncoder = new QRGEncoder(
						"Shankar", null,
						QRGContents.Type.TEXT,
						200);
				try {
					Bitmap bitmap = qrgEncoder.encodeAsBitmap();
					ivQR.setImageBitmap(bitmap);
				} catch (WriterException e) {
					Log.v("HElo", e.toString());
				}


				break;
		}
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder binder) {
		LocalWordService.MyBinder b = (LocalWordService.MyBinder) binder;
		s = b.getService();
		Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		s = null;
	}



}
