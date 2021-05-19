package com.synavos.ams.database.db_tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class StudentAttendance(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo(name = "Date") val Date: String?,
        @ColumnInfo(name = "Status") val Status: String?,
        @ColumnInfo(name = "StudentId") val Sid: String?,
)





