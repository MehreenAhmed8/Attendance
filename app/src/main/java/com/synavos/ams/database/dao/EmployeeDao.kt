package com.synavos.ams.database.dao

import androidx.room.*
import com.synavos.ams.database.db_tables.Employee


@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(employee: Employee)

    @Delete
    fun delete(employee: Employee)

    @Query("Select * from Employee order by Id asc")
    fun getAllEmployee(): List<Employee>

    @Query("Select * from Employee where Id = (:i) and Password=(:password)")
    fun getEmployee(i: Int, password: String): Employee?
}