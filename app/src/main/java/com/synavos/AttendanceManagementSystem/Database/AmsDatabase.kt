package com.synavos.AttendanceManagementSystem.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.synavos.AttendanceManagementSystem.Database.DAO.EmployeeAttendanceDao
import com.synavos.AttendanceManagementSystem.Database.DAO.EmployeeDao
import com.synavos.AttendanceManagementSystem.Database.DAO.StudentAttendanceDao
import com.synavos.AttendanceManagementSystem.Database.DAO.StudentDao
import com.synavos.AttendanceManagementSystem.Database.dbTables.Employee
import com.synavos.AttendanceManagementSystem.Database.dbTables.EmployeeAttendance
import com.synavos.AttendanceManagementSystem.Database.dbTables.Student
import com.synavos.AttendanceManagementSystem.Database.dbTables.StudentAttendance

@Database(entities = [Student::class,Employee::class,EmployeeAttendance::class,StudentAttendance::class], version = 1,exportSchema = false)
abstract class AmsDatabase : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao
    abstract fun getEmployeeDao(): EmployeeDao
    abstract fun getStudentAttendanceDao(): StudentAttendanceDao
    abstract fun getEmployeeAttendanceDao(): EmployeeAttendanceDao

    companion object {
        @Volatile
        private var INSTANCE: AmsDatabase? = null

        fun getDatabase(context: Context): AmsDatabase {
            return INSTANCE ?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AmsDatabase::class.java,
                    "Ams_database"
                ).allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}