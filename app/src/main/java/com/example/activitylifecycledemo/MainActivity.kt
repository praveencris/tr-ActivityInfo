package com.example.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.example.activitylifecycledemo.databinding.ActivityMainBinding


const val TAG: String = "MainActivity"


lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        val name:Name = Name("","")
        binding.name=name
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

    /*override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("First",binding.firstNameEdit.text.toString())
        outState.putString("Last",binding.lastNameEdit.text.toString())
    }*/

}

data class Name(private val _firstName:String,private val _lastName:String):BaseObservable(){

    @Bindable var firstName:String=_firstName
    set(value){
      field =firstName
        notifyPropertyChanged(BR.firstName)
    }

    @Bindable var lastName:String=_lastName
        set(value){
            field =lastName
            notifyPropertyChanged(BR.lastName)
        }
}
