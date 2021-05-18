package com.synavos.ams.activities.admin_activities.modules

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.Employee
import com.synavos.ams.R
import com.synavos.ams.activities.commnon.Date.Companion.getdate

class AddEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_employee_layout)


        val dateOfJoining = findViewById<TextView>(R.id.date_of_joining)
        val addEmployee = findViewById<Button>(R.id.add_employee)

        dateOfJoining.text = getdate()

        addEmployee.setOnClickListener()
        { savetodatabase(getEmployee(this)) }

    }

    private fun getEmployee(context: Activity): Employee {
        val employeeName: EditText = (context).findViewById(R.id.employee_name)
        val employeePassword: EditText = (context).findViewById(R.id.default_password)
        val employeeType: EditText = (context).findViewById(R.id.employee_type)

        return Employee(0,
                employeeName.text.toString(),
                employeePassword.text.toString(),
                getdate(),
                employeeType.text.toString())

    }

    private fun savetodatabase(employee: Employee) {
        val db: AmsDatabase = AmsDatabase.getDatabase(this)
        db.getEmployeeDao().insert(employee)
        Toast.makeText(this, getString(R.string.insert_sucessfull), Toast.LENGTH_SHORT).show()
    }


}