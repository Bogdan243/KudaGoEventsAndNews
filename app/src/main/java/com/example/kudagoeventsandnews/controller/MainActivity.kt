package com.example.kudagoeventsandnews.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.kudagoeventsandnews.R
import com.example.kudagoeventsandnews.model.NewsAndEventsViewModel
import com.example.kudagoeventsandnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var newsAndEventsViewModel: NewsAndEventsViewModel
    private lateinit var permissionRequester: RequestPermission
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        initViewModel()
        createDataRequestWithCheckPermisson()
    }

    private fun createDataRequestWithCheckPermisson() {
        permissionRequester = RequestPermission(this)

        if( permissionRequester.checkInternetPermissions() ) {
            Log.i("InternetPermisson","Have internet permisson")
            createEventRequest()
        }
        else {
            permissionRequester.requestInternetPermissions()
        }
    }

    private fun createEventRequest() {
        newsAndEventsViewModel.makeNetworkRequestAndSetEventList()
    }

    private fun initViewModel() {
        newsAndEventsViewModel = ViewModelProvider(this).get(NewsAndEventsViewModel::class.java)
    }
}
