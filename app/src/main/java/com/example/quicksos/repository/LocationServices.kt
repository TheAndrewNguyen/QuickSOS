package com.example.quicksos.repository

import android.annotation.SuppressLint
import android.util.Log
import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject


class LocationServicesRepository @Inject constructor(private val fusedLocationClient: FusedLocationProviderClient) {

    @SuppressLint("MissingPermission")
    fun getCurrentLocation() {
        Log.d("FusedLocationD", "getCurrentLocation called")
        fusedLocationClient.lastLocation
            .addOnSuccessListener {location ->
                if(location != null) {
                    Log.d("FusedLocationD", "success current Location: $location")
                } else {
                    Log.d("FusedLocationD", "location is null")
                }
            }
    }
}