package br.com.mrocigno.domain

object Constants {

    private val extStorage = "${System.getenv("EXTERNAL_STORAGE")}/Siscon"

    val csvFolder = "$extStorage/csv"
    val photosFolder = "$extStorage/fotos"

}