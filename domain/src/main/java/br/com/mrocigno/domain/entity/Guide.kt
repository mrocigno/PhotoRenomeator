package br.com.mrocigno.domain.entity

import java.io.Serializable


data class Guide(
    val name : String = "",
    val type : String = "",
    val vatNumber : String = "",
    val phone : String = "",
    val streetName : String = "",
    val number : String = "",
    val complement : String = "",
    val neighborhood : String = "",
    val country : String = "",
    val state : String = "",
    val city : String = "",
    val zipCode : String = "",
    val latLng : String = "",
    val responsible : String = "",
    val office : String = "",
    val email : String = "",
    val responsiblePhone: String = "",
    val moreInfo : String = "",
    val people : String = "",
    val guide : String = "",
    val users : String = "",
    val active : String = "",
    val serviceDescription : String = "",
    val serviceType : String = "",
    val rc : String = "",
    val fc : Int = 0,
    val pg : String = "",
    val receiveDate: String = "",
    val sequence : Int = 0,
    val requester : String = "",
    val unity : String = "",
    val polo : String = "",
    val poloDescription: String = "",
    val month : String = ""
) : Serializable