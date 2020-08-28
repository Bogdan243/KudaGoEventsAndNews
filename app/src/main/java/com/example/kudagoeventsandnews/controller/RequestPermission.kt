package com.example.kudagoeventsandnews.controller

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity

class RequestPermission(private val activity: FragmentActivity?) {

    private val INTERNET_PERMISSION_ID = 43

    fun checkInternetPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                activity!!,
                Manifest.permission.INTERNET
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    fun requestInternetPermissions() {
        ActivityCompat.requestPermissions(
            activity!!,
            arrayOf(Manifest.permission.INTERNET),
            INTERNET_PERMISSION_ID
        )
    }
}