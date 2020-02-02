package br.com.mrocigno.data.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "guides")
data class GuideData(
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
    @PrimaryKey(autoGenerate = false)
    val fc : Int = 0,
    val pg : String = "",
    val receiveDate: String = "",
    val sequence : Int = 0,
    val requester : String = "",
    val unity : String = "",
    val polo : String = "",
    val poloDescription: String = "",
    val month : String = ""
) {
    companion object {

        fun parseCsv(csvLine : String) : GuideData {
            val splited = csvLine.split(",")
            if(splited.isNotEmpty() && splited.size == 52) {
                return GuideData(
                    splited[0],
                    splited[1],
                    splited[2],
                    splited[3],
                    splited[4],
                    splited[5],
                    splited[6],
                    splited[7],
                    splited[8],
                    splited[9],
                    splited[10],
                    splited[11],
                    splited[12],
                    splited[13],
                    splited[14],
                    splited[15],
                    splited[16],
                    splited[17],
                    splited[18],
                    splited[19],
                    splited[20],
                    splited[21],
                    splited[22],
                    splited[23],
                    splited[24],
                    splited[25].toInt(),
                    splited[30],
                    splited[31],
                    splited[32].toInt(),
                    splited[33],
                    splited[34],
                    splited[35],
                    splited[36],
                    splited[37]
                )
            }
            return GuideData()
        }

    }
}