package com.synavos.ams.activities.admin_activities.modules
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.activities.admin_activities.adapters.ViewStudentAdapterActivity


import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.Student
import com.synavos.ams.R
import com.synavos.ams.R.layout.display_student_layout

class ViewStudentsActivity : AppCompatActivity() {
    private lateinit var db: AmsDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(display_student_layout)

        showStudents(getStudentList())
    }

    private fun getStudentList(): List<Student> {
        db = AmsDatabase.getDatabase(this)
        return db.getStudentDao().getAllStudents()
    }

    private fun showStudents(studentList: List<Student>) {
        val studentRecyclerView = findViewById<RecyclerView>(R.id.StudentList)

        studentRecyclerView.adapter = ViewStudentAdapterActivity(this, studentList)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}