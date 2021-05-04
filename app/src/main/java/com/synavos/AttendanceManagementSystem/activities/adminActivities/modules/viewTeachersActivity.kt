package com.synavos.AttendanceManagementSystem.activities.adminActivities.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synavos.AttendanceManagementSystem.activities.adminActivities.adapters.FacultyAdapter
import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.Employee
import com.synavos.AttendanceManagementSystem.R

class viewTeachersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.display_emplyees_layout)

        val employeeRecyclerView = findViewById<RecyclerView>(R.id.employee_list)
        val employeeList: List<Employee>

        val db : AmsDatabase;
        db= AmsDatabase.getDatabase(this)

        employeeList = db.getEmployeeDao().GetAllEmployee()
        employeeRecyclerView.adapter = FacultyAdapter(employeeList)
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)


    }
}