package com.example.attendacems.Database.dbTables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
public class Student (
    @PrimaryKey(autoGenerate = true )
    public  val id: Int ,
    @ColumnInfo(name = "Name")
    public var Name: String?,
    @ColumnInfo(name = "Password")
    public var Password: String?,
    @ColumnInfo(name = "DOT")
    public var DOT: String?,
    @ColumnInfo(name = "Degree")
    public var Degree: String?

    )