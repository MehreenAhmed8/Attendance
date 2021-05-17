package com.synavos.AttendanceManagementSystem.Database.dbTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class StudentAttendance(
        @PrimaryKey(autoGenerate = true)  public val id: Int,
        @ColumnInfo(name = "Date") public val Date: String?,
        @ColumnInfo(name = "Status") public val Status: String?,
        @ColumnInfo(name = "StudentId") public val Sid: String?,)





