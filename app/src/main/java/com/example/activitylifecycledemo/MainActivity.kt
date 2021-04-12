package com.example.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.activitylifecycledemo.databinding.ActivityMainBinding


const val TAG: String = "MainActivity"


lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(savedInstanceState!=null && savedInstanceState.containsKey("First")){
            binding.firstNameEdit.text=savedInstanceState.getString("First") as Editable
            binding.lastNameEdit.text=savedInstanceState.getString("Second") as Editable
        }

        binding.displayButton.setOnClickListener(View.OnClickListener {
            binding.firstNameText.text=binding.firstNameEdit.text
            binding.lastNameText.text= binding.lastNameEdit.text
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("First",binding.firstNameEdit.text.toString())
        outState.putString("Last",binding.lastNameEdit.text.toString())
    }

}
