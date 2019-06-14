package com.jimmy.poseestimation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import com.halilibo.bvpkotlin.BetterVideoPlayer
import kotlinx.android.synthetic.main.activity_video_view.*
import android.R.attr.path



class VideoViewActivity : AppCompatActivity() {

    lateinit var player: BetterVideoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        val data = intent?.extras?.getParcelable<VideoData>("video data")

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val uri = Uri.parse(data!!.videoLink)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
