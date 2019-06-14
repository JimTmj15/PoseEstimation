package com.jimmy.poseestimation

import android.text.Html
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_cell.view.*

class VideoHolder (itemView: View) : RecyclerView.ViewHolder(itemView), GenericAdapter.Binder<VideoData> {

    private val v = itemView

    override fun bind(data: VideoData, onItemClickListener: (VideoData) -> Unit) {
        v.videoDescTV.text = Html.fromHtml(data.videoDesc)
        Picasso.get().load(data.img).into(v.imgView)
        v.setOnClickListener { onItemClickListener(data) }
    }
}