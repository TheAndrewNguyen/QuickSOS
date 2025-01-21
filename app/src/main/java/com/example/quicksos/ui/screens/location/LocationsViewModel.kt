package com.example.quicksos.ui.screens.location

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LocationsViewModel @Inject constructor(private val fusedLocationClient: FusedLocationProviderClient) :
    ViewModel() {

    @SuppressLint("MissingPermission")
    fun getLastLocation() {
        Log.d("FusedLocationD", "getLastLocation called")
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    Log.d("FusedLocationD", "success current Location: $location")
                } else {
                    Log.d("FusedLocationD", "location is null")
                }
            }
    }
}