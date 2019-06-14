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
    private lateinit var descs: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoList = ArrayList()
        links = ArrayList()
        imgs = ArrayList()
        descs = ArrayList()

        links.add("android.resource://" + packageName + "/" + R.raw.video_abs1)
        links.add("android.resource://" + packageName + "/" + R.raw.video_abs2)
        links.add("android.resource://" + packageName + "/" + R.raw.video_legs)

        imgs.add(R.drawable.img_abs1)
        imgs.add(R.drawable.img_abs2)
        imgs.add(R.drawable.img_legs)

        descs.add("<b>交替摸脚</b><br/>" +
                "<b>步骤</b><br/>" +
                "•\t仰卧在瑜伽垫上，肩部稍微抬离地面，双腿屈曲与肩同宽，双臂伸直离开地面<br/><br/>" +
                "•\t向身体两侧侧屈，双手交替摸脚，始终保持腹肌紧张<br/><br/>" +
                "<b>呼吸</b><br/><br/>" +
                "•\t摸脚时呼气，还原时吸气<br/><br/>" +
                "动作感觉<br/><br/>" +
                "•\t整个腹肌始终保持紧绷感，动作持续越久，腹肌灼烧感越强<br/><br/>")

        descs.add("<b>交替扭转卷腹</b><br/>" +
                "<b>步骤</b><br/>" +
                "身体呈仰卧姿势;双手置于头后;双腿保持弯曲并让双腿平放在地面上<br/><br/>" +
                "肌肉收缩：向一侧提升并旋转您的躯干，同时让两个膝盖相互靠拢。<br/><br/>" +
                "结束运动：回到起始位置，并另一侧重复刚才的运动<br/><br/>" +
                "<b>呼吸</b><br/><br/>" +
                "躺下吸气，起身吐气<br/><br/>" +
                "<b>注意点</b><br/><br/>" +
                "在抬腿的过程中，不能改变腿部的脚度，在腿部上用力，你的背部要尽量的离开地面，腹肌用力。<br/><br/>")

        descs.add("<b>垂直双腿卷腹</b><br/>" +
                "<b>步骤</b><br/>" +
                "躺在地上，手臂张开，腿垂直于身体<br/><br/>" +
                "肌肉收缩：通过收缩您的腹部抬起躯干，同时，试图用指尖碰到脚踝。<br/><br/>" +
                "结束运动：缓慢回到初始姿势，放松你的肌肉<br/><br/>" +
                "<b>呼吸</b><br/><br/>" +
                "起身吐气，躺下吸气<br/><br/>" +
                "<b>注意点</b><br/><br/>" +
                "在抬起胸部时，要尽量保持双腿的伸直，双腿弯曲，会导致腹部筋膜负重力的大幅减少。<br/><br/>")

        for (i in 0..2) {
            videoList.add(VideoData(
                links[i],
                imgs[i],
                descs[i]))
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
