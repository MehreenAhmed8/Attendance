package com.synavos.ams.activities.admin_activities.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.synavos.ams.R

class AdminPanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.admin_panel_layout)

        val addNewStudent = findViewById<Button>(R.id.add_new_student)
        val viewStudents = findViewById<Button>(R.id.view_students)
        val addNewEmployee = findViewById<Button>(R.id.add_new_faculty)
        val viewEmployees = findViewById<Button>(R.id.view_faculty)

        addNewStudent.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, 1)
        }

        viewStudents.setOnClickListener {
            val intent = Intent(this, ViewStudentsActivity::class.java).apply {
                intent.putExtra(getString(R.string.Tag), getString(R.string.student))
            }
            startActivity(intent)
        }

        addNewEmployee.setOnClickListener {
            val intent = Intent(this, AddEmployeeActivity::class.java)
            startActivityForResult(intent, 2)
        }

        viewEmployees.setOnClickListener {
            val intent = Intent(this, ViewTeachersActivity::class.java)
            startActivity(intent)
        }
    }
}