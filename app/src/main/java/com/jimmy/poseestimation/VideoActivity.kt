package com.jimmy.poseestimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_video.*

class VideoActivity : AppCompatActivity() {

    private lateinit var videoList:ArrayList<VideoData>
    private lateinit var links: ArrayList<String>
    private lateinit var imgs: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoList = ArrayList()
        links = ArrayList()
        imgs = ArrayList()

        links.add("android.resource://" + packageName + "/" + R.raw.video_abs1)
        links.add("android.resource://" + packageName + "/" + R.raw.video_abs2)
        links.add("android.resource://" + packageName + "/" + R.raw.video_legs)

        imgs.add(R.drawable.img_abs1)
        imgs.add(R.drawable.img_abs2)
        imgs.add(R.drawable.img_legs)

        for (i in 0..2) {
            videoList.add(VideoData(
                links[i],
                imgs[i],
                "This is test video"))
        }

        videoRV.layoutManager = LinearLayoutManager(this)

        val adapter = object:GenericAdapter<VideoData>(videoList, { videoData -> onItemClick(videoData) }) {
            override fun getLayoutId(position: Int, obj: VideoData): Int {
                return R.layout.video_cell
            }

            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
                return VideoHolder(view)
            }
        }

        videoRV.adapter = adapter

    }

    fun onItemClick(data: VideoData) {
        val intent = Intent(this, VideoViewActivity::class.java)
        intent.putExtra("video data", data)
        startActivity(intent)
    }
}
