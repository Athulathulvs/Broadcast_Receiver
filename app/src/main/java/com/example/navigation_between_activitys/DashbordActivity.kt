package com.example.navigation_between_activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.IntentFilter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.navigation_between_activitys.databinding.ActivityDashbordBinding

class DashbordActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashbordBinding
    private var callReciver:CallReceiver? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashbordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        requestPermission()
        initBroadcastReciver()
    }

    private fun initBroadcastReciver() {
         callReciver=CallReceiver{
            binding.textView.text = it
        }
        //registering a broadcast
        registerReceiver(callReciver, IntentFilter("android.intent.action.PHONE_STATE"))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(callReciver)
    }

    // Request premission code
    private fun requestPermission() {
           registerForActivityResult(
               ActivityResultContracts.RequestPermission()
           ){ isGranted:Boolean ->
               if (isGranted){
                   Toast.makeText(this, "Permission Available", Toast.LENGTH_SHORT).show()

                }

           }.launch(Manifest.permission.READ_PHONE_STATE)
    }

    private fun setupUI() {


    }

}