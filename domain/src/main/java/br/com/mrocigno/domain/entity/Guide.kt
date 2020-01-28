package br.com.mrocigno.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guides")
data class Guide(
    @PrimaryKey(autoGenerate = true)
    val id : Int?,
    val name : String
)