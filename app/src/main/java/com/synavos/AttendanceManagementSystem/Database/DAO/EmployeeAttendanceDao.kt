package com.synavos.AttendanceManagementSystem.Database.DAO

import androidx.room.*

import com.synavos.AttendanceManagementSystem.Database.dbTables.EmployeeAttendance

@Dao
interface EmployeeAttendanceDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    fun Insert(employee : EmployeeAttendance)

    @Delete
    fun Delete(employee: EmployeeAttendance)

    @Query("Select * from EmployeeAttendance ")
    fun GetAllEmployeeAttendance() : List<EmployeeAttendance>

      @Query("Select * from EmployeeAttendance where EmployeeId = :id")
     fun getAttendance( id : String): List<EmployeeAttendance>

     @Query(value = "Select * from EmployeeAttendance where Date=(:date) and EmployeeId=(:id)" )
    fun getEmployee(date: String,id:String): EmployeeAttendance?

}