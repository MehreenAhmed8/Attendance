package com.synavos.ams.database.db_tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

class EmployeeAttendance(
        @PrimaryKey(autoGenerate = true) val Id: Int,
        @ColumnInfo(name = "Date") val Date: String?,
        @ColumnInfo(name = "Status") val Status: String?,
        @ColumnInfo(name = "EmployeeId") val EmployeeId: String?,
)

