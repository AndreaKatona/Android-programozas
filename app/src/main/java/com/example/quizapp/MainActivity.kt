package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

//    private val TAG :String=javaClass.simpleName
//    private val REQUEST_CONTACT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView
                >(R.id.bottom_navigatin_view)
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController
        )
//        Log.d(TAG,"onCreate() called!")
//
//        val startButton:Button = findViewById(R.id.button_id)
//        val editText = findViewById<EditText>(R.id.editText)
//
//        startButton.setOnClickListener {
//            Log.d(TAG, "button clicked!")
//            Toast.makeText(applicationContext,"clicked",Toast.LENGTH_LONG).show()
//            val intent = Intent(this@MainActivity, NextActivity::class.java)
//            var name: String =editText.text.toString()
//
//            intent.putExtra("Name",name)
//            startActivity(intent)
//        }
    }
        override fun onPause() {
            super.onPause()
            Log.d("ONPAUSE", "Pause!")
        }

        override fun onStop() {
            super.onStop()
            Log.d("ONSTOP", "Stoped!")
        }

        override fun onStart() {
            super.onStart()
            Log.d("ONSTART", "Started!")
        }
    }



