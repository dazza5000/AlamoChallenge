package com.amicly.alamofoursquare.venuemap

import android.os.Bundle
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.alamofoursquare.venuemap.VenueMapContract
import com.amicly.playerbase.base.mvp.BaseActivity
import com.mapbox.geojson.Feature
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource


class VenueMapActivity: BaseActivity(), VenueMapContract.View, OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var mapboxMap: MapboxMap

    private val MARKER_SOURCE = "markers-source"
    private val MARKER_STYLE_LAYER = "markers-style-layer"
    private val MARKER_IMAGE = "custom-marker"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_map)

        Mapbox.getInstance(this, getString(R.string.access_token))
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap
        /* Image: An image is loaded and added to the map. */
        val icon = BitmapFactory.decodeResource(resources, R.drawable.custom_marker)
        mapboxMap.addImage(MARKER_IMAGE, icon)
        addMarkers()
    }

    private fun addMarkers() {
        val source = GeoJsonSource(MARKER_SOURCE,
                Feature.fromGeometry(Point.fromLngLat(2.0, 2.0)))
        mapboxMap.addSource(source)
        val markerStyleLayer: SymbolLayer = SymbolLayer(MARKER_STYLE_LAYER, MARKER_SOURCE)
                .withProperties(
                        PropertyFactory.iconAllowOverlap(true),
                        PropertyFactory.iconImage(MARKER_IMAGE)
                )
        mapboxMap.addLayer(markerStyleLayer)
    }

    public override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    public override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    public override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    public override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun showVenues(venus: List<Venue>) {

    }
}
