package com.example.workoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmi_activity.*
import java.lang.NullPointerException

class bmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_activity)

      setSupportActionBar(bmitoolbar)
        
        var actionbar=supportActionBar
        if(actionbar!=null){

            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title="BMI Calculator"
        }
        bmitoolbar.setNavigationOnClickListener{
            onBackPressed()
        }


        btnbmicalculate.setOnClickListener {


            if(validvalue()) {
                var height: Float = tvheight.text.toString().toFloat()/100
                var weight:Float=tvweight.text.toString().toFloat()

                val bmi=weight/(height*height)
                setbmi(bmi)

            }else{

                Toast.makeText(this
                ,"pls enter valid values",Toast.LENGTH_LONG).show()
            }



        }

        



    }


    private  fun setbmi(bmi:Float){

        tvbmivalue.visibility=View.VISIBLE
        tvbmistatus.visibility=View.VISIBLE
        tvbmivalue.text=bmi.toString()
        tvbmistatus.text="kaam 25 hai"




    }

    private fun validvalue(): Boolean {
        var result=true

        if(tvheight.text.toString().isEmpty()) result=false
        else if(tvweight.text.toString().isEmpty()) result=false

        return result
    }



}