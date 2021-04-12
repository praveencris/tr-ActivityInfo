package com.example.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.activitylifecycledemo.databinding.ActivityMainBinding

const val TAG:String="MainActivity"


lateinit var binding: ActivityMainBinding



class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding.lifecycleOwner=this
        val name:Name=Name("First","Second")
        binding.name=name

      /*  binding.displayButton.setOnClickListener(View.OnClickListener {
            binding.firstNameText.text = name.firstName
            binding.lastNameText.text = name.lastName
        })*/

        binding.firstNameEdit.addTextChangedListener( object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

               binding.firstNameText.text=name.firstName
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })

        binding.lastNameEdit.addTextChangedListener( object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {

                binding.lastNameText.text=name.lastName
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

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



data class Name(var firstName:String,var lastName:String)