package com.synavos.ams.database.dao

import androidx.room.*

import com.synavos.ams.database.db_tables.EmployeeAttendance

@Dao
interface EmployeeAttendanceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(employee: EmployeeAttendance)

    @Delete
    fun delete(employee: EmployeeAttendance)

    @Query("Select * from EmployeeAttendance ")
    fun getAllEmployeeAttendance(): List<EmployeeAttendance>

    @Query("Select * from EmployeeAttendance where EmployeeId = :id")
    fun getAttendance(id: String): List<EmployeeAttendance>

    @Query(value = "Select * from EmployeeAttendance where Date=(:date) and EmployeeId=(:id)")
    fun getEmployee(date: String, id: String): EmployeeAttendance?

}