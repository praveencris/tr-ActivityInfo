package com.example.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val TAG:String="MainActivity"

lateinit var firstNameEdit:EditText
lateinit var lastNameEdit:EditText
lateinit var firstNameText:TextView
lateinit var lastNameText:TextView
lateinit var displayButton:Button


class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameEdit=findViewById(R.id.firstNameEdit)
        lastNameEdit=findViewById(R.id.lastNameEdit)
        firstNameText=findViewById(R.id.firstNameText)
        lastNameText=findViewById(R.id.lastNameText)
        displayButton=findViewById(R.id.displayButton)


        displayButton.setOnClickListener(View.OnClickListener {
            firstNameText.text = firstNameEdit.text
            lastNameText.text = lastNameEdit.text
        })

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

    /*override fun onClick(v: View?) {
        firstNameText.text = firstNameEdit.text
        lastNameText.text = lastNameEdit.text
    }*/
}