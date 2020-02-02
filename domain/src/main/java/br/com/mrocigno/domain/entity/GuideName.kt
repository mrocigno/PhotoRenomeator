package br.com.mrocigno.domain.entity

import java.io.Serializable

class GuideName(
    val fc: Int = 0,
    val guide: String = "",
    val name: String = "",
    val rc: String = "",
    val streetName: String = "",
    val number: String = "",
    val complement: String = "",
    val countPhotos: Int = 0
) : Serializable