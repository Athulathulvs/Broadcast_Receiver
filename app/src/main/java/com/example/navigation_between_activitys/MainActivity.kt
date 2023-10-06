package com.example.navigation_between_activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.navigation_between_activitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }
    private fun setupUI(){
     binding.loginBtn.setOnClickListener {

         val username= binding.txtUsername.text.toString()
         val password = binding.txtPassword.text.toString()
         if (username.isBlank() || username.length <5){
             Toast.makeText(this, "Plsese enter a valid username", Toast.LENGTH_SHORT).show()
             return@setOnClickListener
         }

         if (password.isBlank() || password.length< 5){
             Toast.makeText(this, "Please enter a valid password", Toast.LENGTH_SHORT).show()
             return@setOnClickListener
         }
         val intent = Intent(this,DashbordActivity::class.java)
         intent.putExtra("USERNAME",username)
         intent.putExtra("PASSWORD",password)
         intent.putExtra("AGE",18)
         startActivity(intent)
        // finish()
     }
    }
}