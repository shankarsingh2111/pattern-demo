package com.example.shankar.patterndemo;

import android.animation.ValueAnimator;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}


	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */

	Marker marker;

	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;

		// Add a marker in Sydney and move the camera
		LatLng sydney = new LatLng(30.718511, 76.805357);

		marker = mMap.addMarker(new MarkerOptions().position(sydney).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_auto_marker)).anchor(0.5f, 0.5f).title("Marker in Sydney"));

		marker.setRotation(-45);
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));

		mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
			@Override
			public void onMapClick(LatLng latLng) {
				float start = 315;
				float to = -60;


				//235, 163
				//274, -167
				// 201, -148
				// 8, 33
				// 27, 50
				// 37, 81
				// 77, 103
				// 100, 127
				// 112, 55
				// 169, 54
				// 283, 53
				// 283, 147
				// 59, 57
				// 61, -35
				//
				animateMarker(start, to);
			}
		});

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				//nw 30.720134, 76.800508
				//sw 30.715190, 76.801581

				float start = marker.getRotation();
				float to = (float) getBearing(marker.getPosition(), new LatLng(30.715190, 76.801581));

//				rotateMarker(marker, start, to);

				animateMarker(marker.getRotation(), -60);
			}
		}, 1000);


	}

	public static double getBearing(LatLng source, LatLng dest) {
		//Source
		try {
			Location location1 = new Location("locationA");
			location1.setLatitude(source.latitude);
			location1.setLongitude(source.longitude);
			Location location2 = new Location("locationA");
			location2.setLatitude(dest.latitude);
			location2.setLongitude(dest.longitude);
			double brng = location1.bearingTo(location2);
			return brng;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public void animateMarker(float startB, float bearing) {
		if (marker != null) {
			ValueAnimator valueAnimator = new ValueAnimator();
			final float start = getPositiveRotation(startB);
			final float end = getPositiveRotation(bearing);
			final float rotationAngle = getRotationAngle(start, end);

			valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					try {
						if (marker == null) {
							return;
						}
						float v = animation.getAnimatedFraction();
						float rotation = start + v * rotationAngle;
						marker.setRotation(getRotationUnder360(rotation));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			valueAnimator.setFloatValues(0, 1);
			valueAnimator.setDuration(3000);
			valueAnimator.start();
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Log.e("marker.getRotation()", ">" + marker.getRotation());
				}
			}, 3005);
		}
	}


	private float getPositiveRotation(float rotation){
		if(rotation < 0){
			rotation = -(-180 - (rotation + 180));
		}
		return rotation;
	}

	private float getRotationUnder360(float rotation){
		if(rotation > 360){
			rotation = rotation - ((int)(rotation/360))*360;
		}
		return rotation;
	}

	private float getRotationAngle(float start, float end){
		float rotationTo = 0;
		if(start <= end){
			rotationTo = end - start;
		} else {
			rotationTo = 360+end - start;
		}

		if(rotationTo > 180){
			rotationTo = -(180 - (rotationTo - 180));
		}
		return rotationTo;
	}

}
