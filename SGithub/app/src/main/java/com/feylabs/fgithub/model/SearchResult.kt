package com.feylabs.fgithub.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResult (
    var url: String? = "",
    var username: String? = "",
    var name: String?,
    var photo: String?,
) : Parcelable