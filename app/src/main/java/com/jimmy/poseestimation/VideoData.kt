package com.jimmy.poseestimation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoData(
    val videoLink:String,
    val img:Int,
    val videoDesc: String): Parcelable