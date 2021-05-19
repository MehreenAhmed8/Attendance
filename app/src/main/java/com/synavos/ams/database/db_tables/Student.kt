package com.synavos.ams.database.db_tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student(
        @PrimaryKey(autoGenerate = true) val Id: Int,
        @ColumnInfo(name = "Name") var Name: String?,
        @ColumnInfo(name = "Password") var Password: String?,
        @ColumnInfo(name = "DOT") var DOT: String?,
        @ColumnInfo(name = "Degree") var Degree: String?

)