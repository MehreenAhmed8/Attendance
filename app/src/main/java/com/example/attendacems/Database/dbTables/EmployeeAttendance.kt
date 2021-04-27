package com.example.attendacems.Database.dbTables
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity

class EmployeeAttendance(@PrimaryKey(autoGenerate = true) public val id : Int,
                         @ColumnInfo(name = "Date") public val Date: String?,
                         @ColumnInfo(name = "Status") public val Status : String?,
                         @ColumnInfo(name = "EmployeeId") public val EmployeeId: String?,)

