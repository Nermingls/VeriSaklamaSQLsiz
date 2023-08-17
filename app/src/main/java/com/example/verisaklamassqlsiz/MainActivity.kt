package com.example.verisaklamassqlsiz

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import com.example.verisaklamassqlsiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences
    var ageFromSharedPref : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //SharedPrefences Initialize
        sharedPref =this.getSharedPreferences(" com.example.verisaklamassqlsiz", MODE_PRIVATE)
        ageFromSharedPref = sharedPref.getInt("age",-1)
        if (ageFromSharedPref == -1) {
            binding.ageText.text = "Your Age: "
        } else {
            binding.ageText.text = "Your Age: $ageFromSharedPref"
        }

    }

    fun save(view: View){
        val userAge = binding.userAge.text.toString().toIntOrNull()
        userAge?.let {
            binding.ageText.text= "Yasiniz " + userAge
            sharedPref.edit().putInt("age", userAge).apply()
        }

    }
    fun delete(view: View){

        ageFromSharedPref = sharedPref.getInt("age",-1)
        if (ageFromSharedPref != -1){
            sharedPref.edit().remove("age").apply()
            binding.ageText.text= "Yasiniz : "
        }

    }

}