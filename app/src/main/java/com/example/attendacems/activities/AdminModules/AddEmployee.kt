package com.example.attendacems.activities.AdminModules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.Database.dbTables.Student
import com.example.attendacems.R
import com.example.attendacems.activities.Commnon.Date

class AddEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)
        var DOT= findViewById<TextView>(R.id.DOJ)
        DOT.text= Date.getdate()
        var db : AmsDatabase;
        var Add1 = findViewById<Button>(R.id.AddE)

            Add1.setOnClickListener()
            {

                var Name = findViewById<EditText>(R.id.EName).getText().toString()
                var Password = findViewById<EditText>(R.id.DPassword).getText().toString()
                var Type = findViewById<EditText>(R.id.Etype).getText().toString()
                db= AmsDatabase.getDatabase(this)
                val emp : Employee = Employee(0,Name,Password,Date.getdate(),Type)
                db.getEmployeeDao().Insert(emp)
                Toast.makeText(this, "Insert SucessFull", Toast.LENGTH_SHORT).show()

            }

    }
}