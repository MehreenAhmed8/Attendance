package com.example.attendacems.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.attendacems.Database.DAO.EmployeeAttendanceDao
import com.example.attendacems.Database.DAO.EmployeeDao
import com.example.attendacems.Database.DAO.StudentAttendanceDao
import com.example.attendacems.Database.DAO.StudentDao
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.Database.dbTables.EmployeeAttendance
import com.example.attendacems.Database.dbTables.Student
import com.example.attendacems.Database.dbTables.StudentAttendance
import kotlinx.coroutines.CoroutineScope

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