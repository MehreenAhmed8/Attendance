package com.example.attendacems.Database.DAO
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.attendacems.Database.dbTables.StudentAttendance

@Dao
interface StudentAttendanceDao {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    fun Insert(studentA : StudentAttendance)

    @Query("Select * from StudentAttendance order by id asc")
    fun GetAllStudentAttendance() : List<StudentAttendance>

    @Query("Select * from StudentAttendance where StudentId = :id1")
    fun getStudentAttendance( id1 : String): List<StudentAttendance>

    @Query(value = "Select * from StudentAttendance where Date=(:date) and StudentId=(:id)" )
    fun getStudent(date: String,id:String):StudentAttendance?

    @Query(value = "Select Date from StudentAttendance where StudentId=(:id)" )
    fun getStudentDate(id:String):String?
}