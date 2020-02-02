package br.com.mrocigno.data.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PhotoData(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val serviceId: Int,
    val path: String = "",
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    val createdDate: String = ""
)