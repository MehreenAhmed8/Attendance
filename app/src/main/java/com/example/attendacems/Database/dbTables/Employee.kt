package com.example.attendacems.Database.dbTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class Employee (
                @PrimaryKey(autoGenerate = true) val id : Int,
                @ColumnInfo(name = "Name") val Name: String?,
                @ColumnInfo(name = "Password") val Password: String?,
                @ColumnInfo(name = "DOJ") val DOJ: String?,
                @ColumnInfo(name = "Type") val Type: String?,)