package com.synavos.ams.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.synavos.ams.database.dao.EmployeeAttendanceDao
import com.synavos.ams.database.dao.EmployeeDao
import com.synavos.ams.database.dao.StudentAttendanceDao
import com.synavos.ams.database.dao.StudentDao
import com.synavos.ams.database.db_tables.Employee
import com.synavos.ams.database.db_tables.EmployeeAttendance
import com.synavos.ams.database.db_tables.Student
import com.synavos.ams.database.db_tables.StudentAttendance

@Database(entities = [Student::class, Employee::class, EmployeeAttendance::class, StudentAttendance::class], version = 1, exportSchema = false)
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