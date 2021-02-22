package com.adityabrian.latihanrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SuperHero(
    val name:String,
    val deskripsi:String
) : Parcelable