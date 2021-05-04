package com.synavos.AttendanceManagementSystem.activities.adminActivities.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.Employee
import com.synavos.AttendanceManagementSystem.R
import com.synavos.AttendanceManagementSystem.activities.commnon.Date

class addEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_employee_layout)

        var db : AmsDatabase
        val dateOfJoining= findViewById<TextView>(R.id.date_of_joining)
        val addEmployee = findViewById<Button>(R.id.add_employee)
        dateOfJoining.text= Date.getdate()

        addEmployee.setOnClickListener() {

                val employeeName = findViewById<EditText>(R.id.employee_name).text.toString()
                val employeePassword = findViewById<EditText>(R.id.default_password).text.toString()
                val employeeType = findViewById<EditText>(R.id.employee_type).text.toString()

                db= AmsDatabase.getDatabase(this)
                val newEmployee = Employee(0,employeeName,employeePassword,Date.getdate(),employeeType)
                db.getEmployeeDao().Insert(newEmployee)

                Toast.makeText(this, getString(R.string.insert_sucessfull), Toast.LENGTH_SHORT).show()

            }

    }
}