package com.example.activitylifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.example.activitylifecycledemo.databinding.ActivityMainBinding


const val TAG: String = "MainActivity"


lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        val nameValue: String = "Name";
        var name: Name = Name(nameValue, "")

        if (savedInstanceState != null) {
            val first = savedInstanceState.getString(FIRST);
            val last = savedInstanceState.getString(LAST)
            if (first != null && last != null) {
                name = Name(first, last)
            }
        }
        binding.name = name
        Log.d(TAG, "onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()

            R.id.menu_one -> Toast.makeText(this, "Menu one clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
        outState.putString(FIRST, binding.firstNameEdit.text.toString())
        outState.putString(LAST, binding.lastNameEdit.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
    }

    companion object {
        const val FIRST: String = "FIRST";
        const val LAST: String = "SECOND";
    }

}

data class Name(private val _firstName: String, private val _lastName: String) : BaseObservable() {

    @Bindable
    var firstName: String = _firstName
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }

    @Bindable
    var lastName: String = _lastName
        set(value) {
            field = value
            notifyPropertyChanged(BR.lastName)
        }

    fun getName(first: Int, last: Int) {

    }
}
