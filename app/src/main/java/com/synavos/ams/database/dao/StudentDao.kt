package com.synavos.ams.database.dao

import androidx.room.*
import com.synavos.ams.database.db_tables.Student

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Student)

    @Delete
    fun delete(student: Student)

    @Query("Select * from Student")
    fun getAllStudents(): List<Student>

    @Query("Select * from Student where Id = (:i) and Password=(:password)")
    fun getStudent(i: Int, password: String): Student?

}