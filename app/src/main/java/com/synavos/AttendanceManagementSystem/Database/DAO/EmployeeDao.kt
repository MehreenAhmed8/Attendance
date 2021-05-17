package com.synavos.AttendanceManagementSystem.Database.DAO

import androidx.room.*
import com.synavos.AttendanceManagementSystem.Database.dbTables.Employee


@Dao
interface EmployeeDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    fun Insert(employee : Employee)

    @Delete
    fun Delete(employee: Employee )

    @Query("Select * from Employee order by id asc")
    fun GetAllEmployee() : List<Employee>

    @Query("Select * from Employee where id = (:i) and Password=(:password)")
    fun GetEmployee(i: Int , password : String) : Employee?
}