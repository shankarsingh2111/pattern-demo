package com.example.shankar.patterndemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

/**
 * Created by shankar on 10/05/17.
 */

public class StarterMapFragment extends Fragment {

	View rootView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_map, container, false);

		MapView map = (MapView) rootView.findViewById(R.id.map);
		map.setTileSource(TileSourceFactory.MAPNIK);
		map.setBuiltInZoomControls(true);
		map.setMultiTouchControls(true);


		GeoPoint startPoint = new GeoPoint(30.718622, 76.810078);
		IMapController mapController = map.getController();
		mapController.setZoom(9);
		mapController.setCenter(startPoint);


		return rootView;
	}

}
