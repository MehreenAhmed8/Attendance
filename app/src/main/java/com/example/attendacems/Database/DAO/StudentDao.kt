package com.example.attendacems.Database.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.attendacems.Database.dbTables.Student

@Dao
interface StudentDao {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    fun Insert(student : Student)

    @Delete
    fun Delete(student : Student)

    @Query("Select * from Student")
    fun GetAllStudents() : List<Student>

    @Query("Select * from Student where id = (:i) and Password=(:password)")
    fun GetStudent(i: Int , password : String) : Student

}