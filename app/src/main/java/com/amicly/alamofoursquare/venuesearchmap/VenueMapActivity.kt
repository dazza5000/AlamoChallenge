package com.amicly.alamofoursquare.venuesearchmap

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.amicly.alamofoursquare.R
import com.amicly.alamofoursquare.model.venue.Venue
import com.amicly.playerbase.base.mvp.BaseActivity
import com.mapbox.geojson.Feature
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.layers.SymbolLayer
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import javax.inject.Inject


class VenueMapActivity: BaseActivity(), VenueMapContract.View, OnMapReadyCallback {

    @Inject
    lateinit var venueMapPresenter: VenueMapPresenter

    private lateinit var mapView: MapView
    private lateinit var mapboxMap: MapboxMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_map)

        Mapbox.getInstance(this, getString(R.string.access_token))
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
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

    override fun showVenues(venues: List<Venue>) {
        addMarkers(venues)
    }

    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap

        configureMapBoxMap(mapboxMap)

        intent.getStringExtra(EXTRA_SEARCH_STRING)?.let {
            venueMapPresenter.searchVenues(it)
        }
    }

    private fun configureMapBoxMap(mapboxMap: MapboxMap) {
        val drawable: Drawable = resources.getDrawable(R.drawable.ic_sentiment_satisfied_triad_24dp, null)

        val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        mapboxMap.addImage(MARKER_IMAGE, bitmap)
    }

    private fun addMarkers(venues: List<Venue>) {
        val features: ArrayList<Feature> = ArrayList()
        val latLngs: ArrayList<LatLng> = ArrayList()
        for (venue in venues) {
            venue.location?.let {
                val point: Point = Point.fromLngLat(it.lng, it.lat)
                features.add(Feature.fromGeometry(point).apply {
                    addStringProperty("venueId", venue.id)
                })
                latLngs.add(LatLng(it.lat, it.lng))
            }
        }

        val featureCollection: FeatureCollection = FeatureCollection.fromFeatures(features)
        val source = GeoJsonSource(MARKER_SOURCE, featureCollection)
        mapboxMap.addSource(source)
        val markerStyleLayer: SymbolLayer = SymbolLayer(MARKER_STYLE_LAYER, MARKER_SOURCE)
                .withProperties(
                        PropertyFactory.iconAllowOverlap(true),
                        PropertyFactory.iconImage(MARKER_IMAGE)
                )
        mapboxMap.addLayer(markerStyleLayer)
        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngBounds(
                LatLngBounds.Builder().includes(latLngs).build(), 77))
    }

    companion object {
        private const val EXTRA_SEARCH_STRING = "searchString"
        private const val MARKER_SOURCE = "markers-source"
        private const val MARKER_STYLE_LAYER = "markers-style-layer"
        private const val MARKER_IMAGE = "custom-marker"

        fun startVenueMapActivity(context: Context, searchString: String) {
            val intent = Intent(context, VenueMapActivity::class.java)
            intent.putExtra(EXTRA_SEARCH_STRING, searchString)
            context.startActivity(intent)
        }
    }
}
