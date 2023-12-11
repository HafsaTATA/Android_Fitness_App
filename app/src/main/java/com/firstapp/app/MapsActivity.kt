package com.firstapp.app

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet))
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        var sheet = findViewById<LinearLayout>(R.id.bottomSheet)
        BottomSheetBehavior.from(sheet).apply {
            peekHeight = 100
            this.state= BottomSheetBehavior.STATE_COLLAPSED
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        findViewById<TextView>(R.id.greenPlace).setOnClickListener {
            mMap.clear()

            val greenPlaceMarker1 = MarkerOptions().position(LatLng(34.02796667970565, -5.021170524565989)).title("Jardin de nouveau Méchouar")
            mMap.addMarker(greenPlaceMarker1)
            val greenPlaceMarker2 = MarkerOptions().position(LatLng(34.03502644105762, -5.0123271579048785)).title("Parc Prestigia")
            mMap.addMarker(greenPlaceMarker2)
            val greenPlaceMarker3 = MarkerOptions().position(LatLng(34.02894725006908, -4.991142243411343)).title("Union Sportive de Fès")
            mMap.addMarker(greenPlaceMarker3)
            val greenPlaceMarker4 = MarkerOptions().position(LatLng(33.9856772689874, -5.019330232022985)).title("Forêt d'ain Chkef")
            mMap.addMarker(greenPlaceMarker4)
            val greenPlaceMarker5 = MarkerOptions().position(LatLng(34.06321591098598, -4.9882595242017995)).title("Jnan Sbil")
            mMap.addMarker(greenPlaceMarker5)
            val greenPlaceMarker6 = MarkerOptions().position(LatLng(33.99158350560855, -5.020156003452234)).title("Diamant Vert")
            mMap.addMarker(greenPlaceMarker6)

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(34.02796667970565, -5.021170524565989), 12f))

            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        }

        findViewById<TextView>(R.id.gym).setOnClickListener {
            mMap.clear()

            val gymMarker1 = MarkerOptions().position(LatLng(34.04375791278575, -5.014234093024584)).title("Adrigym Bel Air")
            mMap.addMarker(gymMarker1)
            val gymMarker2 = MarkerOptions().position(LatLng(34.03971640019344, -5.008689505715078)).title("AdriLadies")
            mMap.addMarker(gymMarker2)
            val gymMarker3 = MarkerOptions().position(LatLng(34.047681866766375, -5.003539664316016)).title("Olympia Gym")
            mMap.addMarker(gymMarker3)
            val gymMarker4 = MarkerOptions().position(LatLng(34.00528399639356, -4.968203708345067)).title("Fit house")
            mMap.addMarker(gymMarker4)
            val gymMarker5 = MarkerOptions().position(LatLng(34.01439262784237, -5.011436087794549)).title("Time Fitness")
            mMap.addMarker(gymMarker5)
            val gymMarker6 = MarkerOptions().position(LatLng(34.06645464884515, -5.02534065957202)).title("Axis Fitness")
            mMap.addMarker(gymMarker6)
            val gymMarker7 = MarkerOptions().position(LatLng(34.01949715814539, -4.980924890424566)).title("Golden Gym")
            mMap.addMarker(gymMarker7)
            val gymMarker8 = MarkerOptions().position(LatLng(34.01794979359129, -5.009376151234928)).title("PRO FITNESS")
            mMap.addMarker(gymMarker8)
            val gymMarker9 = MarkerOptions().position(LatLng(34.011404493428586, -5.0016513891363354)).title("STARS FITNESS & SPA")
            mMap.addMarker(gymMarker9)
            val gymMarker10 = MarkerOptions().position(LatLng(34.02705545867436, -5.015212638153865)).title("Nausikaa Fitness")
            mMap.addMarker(gymMarker10)
            val gymMarker11 = MarkerOptions().position(LatLng(34.04611728059475, -5.035468680990175)).title("MEGAfit")
            mMap.addMarker(gymMarker11)
            val gymMarker12 = MarkerOptions().position(LatLng(34.03943190540731, -5.014869315393927)).title("Challenge Fit")
            mMap.addMarker(gymMarker12)
            val gymMarker13 = MarkerOptions().position(LatLng(34.034595348047006, -5.003882987075928)).title("Friend's Move")
            mMap.addMarker(gymMarker13)


            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(34.04375791278575, -5.014234093024584), 12f))

            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}