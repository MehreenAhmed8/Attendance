package com.synavos.AttendanceManagementSystem.activities.adminActivities.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synavos.AttendanceManagementSystem.activities.adminActivities.adapters.viewStudentAdapter


import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.Student
import com.synavos.AttendanceManagementSystem.R

class viewStudentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_student_layout)

        val studentRecyclerView = findViewById<RecyclerView>(R.id.StudentList)
        val studentList: List<Student>

        val db : AmsDatabase;
        db= AmsDatabase.getDatabase(this)

        studentList = db.getStudentDao().GetAllStudents()
        studentRecyclerView.adapter = viewStudentAdapter(studentList)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}