package com.example.attendacems.Database.DAO

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.attendacems.Database.dbTables.EmployeeAttendance
import com.example.attendacems.Database.dbTables.StudentAttendance

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