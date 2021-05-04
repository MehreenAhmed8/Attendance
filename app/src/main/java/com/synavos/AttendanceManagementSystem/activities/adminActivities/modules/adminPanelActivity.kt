package com.synavos.AttendanceManagementSystem.activities.adminActivities.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.synavos.AttendanceManagementSystem.R

class adminPanelActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            this.setContentView(R.layout.admin_panel_layout)
            val addNewStudent = findViewById<Button>(R.id.add_new_student)
            val veiwStudents = findViewById<Button>(R.id.view_students)
            val addNewEmployee = findViewById<Button>(R.id.add_new_faculty)
            val veiwEmployees = findViewById<Button>(R.id.view_faculty)

            addNewStudent.setOnClickListener{
               val intent = Intent(this, addStudentActivity::class.java)
               startActivityForResult(intent,1)
             }

            veiwStudents.setOnClickListener {
                val intent = Intent(this, viewStudentsActivity::class.java).apply{
                    intent.putExtra(getString(R.string.Tag),getString(R.string.student))
                }
                startActivity(intent)
            }

            addNewEmployee.setOnClickListener{
                val intent = Intent(this, addEmployeeActivity::class.java)
                startActivityForResult(intent, 2)
            }

            veiwEmployees.setOnClickListener {
                val intent = Intent(this, viewTeachersActivity::class.java)
                startActivity(intent)
            }
        }
}