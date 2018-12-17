package food.sharefood.com.sharefood.add_food_post

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.Helper
import food.sharefood.com.sharefood.util.Helper.Companion.LOCATION_PERMISSION_REQUEST_CODE

class MapViewActivity : AppCompatActivity(),
        OnMapReadyCallback {

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpMap()

    }


    private fun setUpMap() {
        if(intent != null)
        {
            latitude = intent.getDoubleExtra(Extras.LATITUDE_VALUE, 0.0)
            longitude = intent.getDoubleExtra(Extras.LONGITUDE_VALUE, 0.0)
        }

        if (ActivityCompat.checkSelfPermission(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
        val mapFragment: SupportMapFragment? =
                supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            Helper.LOCATION_PERMISSION_REQUEST_CODE -> {

                if (!grantResults.isEmpty() || grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        googleMap ?: return
        with(googleMap) {
            val latLng = LatLng(latitude, longitude)
            moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f))
            addMarker(MarkerOptions().position(latLng))
        }
    }
}