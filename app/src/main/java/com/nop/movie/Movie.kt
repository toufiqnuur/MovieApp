package com.nop.movie

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val poster: Int,
    val title: String,
    val date: String,
    val rating: String,
    val summary: String,
    val ratingCount: String,
    val popularity: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(poster)
        parcel.writeString(title)
        parcel.writeString(date)
        parcel.writeString(rating)
        parcel.writeString(summary)
        parcel.writeString(ratingCount)
        parcel.writeString(popularity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}
