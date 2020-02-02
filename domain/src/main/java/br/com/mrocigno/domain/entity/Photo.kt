package br.com.mrocigno.domain.entity

import android.graphics.Bitmap

data class Photo(
    val id: Int? = null,
    val serviceId: Int,
    var path: String = "",
    val createdDate: String = ""
)