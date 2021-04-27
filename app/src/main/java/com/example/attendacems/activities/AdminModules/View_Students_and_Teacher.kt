package com.example.attendacems.activities.AdminModules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Adapter.MyAdapter


import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.Database.dbTables.Student
import com.example.attendacems.R

class View_Students_and_Teacher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view__students_and__teacher)

        var db : AmsDatabase;
        db= AmsDatabase.getDatabase(this)

            val x = findViewById<RecyclerView>(R.id.SList)
            val studentList: List<Student>
            studentList = db.getStudentDao().GetAllStudents()
            x.adapter = MyAdapter(studentList)
            x.layoutManager = LinearLayoutManager(this)

    }
}