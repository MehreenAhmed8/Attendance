package com.synavos.ams.activities.admin_activities.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.Employee
import com.synavos.ams.R
import com.synavos.ams.activities.admin_activities.adapters.FacultyAdapterActivity

class ViewTeachersActivity : AppCompatActivity() {
    private lateinit var db: AmsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.display_emplyees_layout)

        showEmployees(getEmployeeList())
    }

    private fun getEmployeeList(): List<Employee> {
        db = AmsDatabase.getDatabase(this)
        return db.getEmployeeDao().getAllEmployee()
    }

    private fun showEmployees(employeeList: List<Employee>) {
        val employeeRecyclerView = findViewById<RecyclerView>(R.id.employee_list)
        employeeRecyclerView.adapter = FacultyAdapterActivity(this, employeeList)
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}