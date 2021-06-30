package com.example.workoutapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_exceriseactivity.*
import kotlinx.android.synthetic.main.backbuttonpopup.*
import java.util.*
import javax.net.ssl.SSLEngineResult
import kotlin.collections.ArrayList

class exceriseactivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    private var resttime: CountDownTimer? = null
    private var restprogress= 0

    private var extime: CountDownTimer? = null
    private var exprogress= 0
    private var tts:TextToSpeech?=null

    var currentpos:Int=-1
    var exercisearr:ArrayList<excerciselayout>?=Constants.defaultexcercsielist()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_exceriseactivity)

        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
        toolbar.setNavigationOnClickListener {

           backbuttondialogue()

        }
        tts= TextToSpeech(this,this)

        setrestprogresbar()



      }

       override fun onDestroy() {
        super.onDestroy()
        if(resttime!=null) {
            resttime!!.cancel()
            restprogress=0

        }

           if(extime!=null) {
               extime!!.cancel()
            exprogress=0
           }
          if(tts!=null){
              tts!!.stop()
              tts!!.shutdown()

          }


       }


        private fun setrestprogresbar() {
            restprogress=0
            exerciseview.visibility=View.GONE
            llrestview.visibility=View.VISIBLE
            tvnextex.text=exercisearr!![currentpos+1].getName()
            progressbar.progress = restprogress
            resttime = object : CountDownTimer(10000, 1000) {
                override fun onTick(p0: Long) {
                    restprogress++
                    progressbar.progress = 10-restprogress
                    tvtimer.text = (10 - restprogress).toString()


                }

                override fun onFinish() {
                    currentpos++

                    if (currentpos<exercisearr!!.size) {
                        setexrestprogresbar()
                    }
                    else{
                        finish()
                        var intent=Intent(this@exceriseactivity,finishactivity::class.java)
                        startActivity(intent)

                    }



                }

            }.start()
        }
        private fun onstartprogress(){

            if(resttime!=null){
                resttime!!.cancel()
                restprogress=0
                setrestprogresbar()

            }
            setrestprogresbar()



        }
    private fun setexrestprogresbar() {
        exprogress=0
        exerciseview.visibility=View.VISIBLE
        llrestview.visibility=View.GONE

        exno.text=exercisearr!![currentpos].getId().toString()
        exname.text=exercisearr!![currentpos].getName()
        speaktts(exercisearr!![currentpos].getName())

        showGif(View(this@exceriseactivity))
        exprogressbar.progress = exprogress
        extime = object : CountDownTimer(30000, 1000) {


            override fun onTick(p0: Long) {
                exprogress++
                exprogressbar.progress = 30-exprogress
                extvtimer.text = (30 - exprogress).toString()


            }
            override fun onFinish() {
             if (currentpos<(exercisearr!!.size)-1) {
                 setrestprogresbar()
             }
                else{
                 Toast.makeText(this@exceriseactivity, "Finished", Toast.LENGTH_SHORT).show()

             }


            }

            

        }.start()


    }
    private fun showGif(view: View) {

        val imageView: ImageView = findViewById(R.id.eximg)
        Glide.with(this@exceriseactivity).load(exercisearr?.get(currentpos)!!.getImage()).into(imageView)
    }

    override fun onInit(status: Int) {

        if(status==TextToSpeech.SUCCESS){
            val result=tts!!.setLanguage(Locale.US)
            if(result==TextToSpeech.LANG_MISSING_DATA ||result==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","lang not supported")

            }
        }else{
            Log.e("TTS","initialisation failed")

        }

    }
    private fun speaktts(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")

    }

    private fun backbuttondialogue(){
        var customdialogue=Dialog(this)
        customdialogue.setContentView(R.layout.backbuttonpopup)

        customdialogue.backbttnyes.setOnClickListener{
            finish()
            customdialogue.dismiss()

        }
        customdialogue.backbttnno.setOnClickListener{
            customdialogue.dismiss()

        }

        customdialogue.show()

    }


}