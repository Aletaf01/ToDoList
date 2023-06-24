package com.example.myapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView

class doom : AppCompatActivity() {

    var video: VideoView?=null
    var mediaControllo: MediaController?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doom)
        video=findViewById<View>(R.id.doom) as VideoView
        if (mediaControllo==null){
            mediaControllo= MediaController(this)
            mediaControllo!!.setAnchorView(this.video)
        }

        video!!.setMediaController(mediaControllo)

        video!!.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=d0Dl8HSKMWM"))

        video!!.start()
    }
}