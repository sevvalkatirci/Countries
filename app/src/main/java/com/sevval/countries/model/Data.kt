package com.sevval.countries.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
class Data(
    @ColumnInfo(name="code")
    val code: String,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="wikiDataId")
    val wikiDataId: String,
){
    @PrimaryKey(autoGenerate = true)
    var id=0
}