package com.synavos.ams.database.dao

import androidx.room.*
import com.synavos.ams.database.db_tables.StudentAttendance

@Dao
interface StudentAttendanceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(studentA: StudentAttendance)

    @Query("Select * from StudentAttendance order by id asc")
    fun getAllStudentAttendance(): List<StudentAttendance>

    @Query("Select * from StudentAttendance where StudentId = :id1")
    fun getStudentAttendance(id1: String): List<StudentAttendance>

    @Query(value = "Select * from StudentAttendance where Date=(:date) and StudentId=(:id)")
    fun getStudent(date: String, id: String): StudentAttendance?

    @Query(value = "Select Date from StudentAttendance where StudentId=(:id)")
    fun getStudentDate(id: String): String?
}