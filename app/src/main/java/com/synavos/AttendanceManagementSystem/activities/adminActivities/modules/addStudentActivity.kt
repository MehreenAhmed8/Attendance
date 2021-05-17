package com.synavos.AttendanceManagementSystem.activities.adminActivities.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.Student
import com.synavos.AttendanceManagementSystem.R
import com.synavos.AttendanceManagementSystem.activities.commnon.Date

class addStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_student_layout)

        var DOT= findViewById<TextView>(R.id.date_of_join)
        DOT.text=Date.getdate()
        var Add = findViewById<Button>(R.id.add_student)
        var db : AmsDatabase;
        Add.setOnClickListener()
        {

            val studentName= findViewById<EditText>(R.id.student_name).getText().toString()
            val studentPassword= findViewById<EditText>(R.id.student_password).getText().toString()
            val studentDegree= findViewById<EditText>(R.id.degree).getText().toString()

            db= AmsDatabase.getDatabase(this)
            val newStudent  : Student= Student(0,studentName, studentPassword ,Date.getdate(), studentDegree)
            db.getStudentDao().Insert(newStudent)

            Toast.makeText(this, "Insert SucessFull", Toast.LENGTH_SHORT).show()
        }
    }


}