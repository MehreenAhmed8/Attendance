package com.example.attendacems.Database.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.Database.dbTables.Student


@Dao
interface EmployeeDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    fun Insert(employee : Employee)

    @Delete
    fun Delete(employee: Employee )

    @Query("Select * from Employee order by id asc")
    fun GetAllEmployee() : List<Employee>

    @Query("Select * from Employee where id = (:i) and Password=(:password)")
    fun GetEmployee(i: Int , password : String) : Employee
}