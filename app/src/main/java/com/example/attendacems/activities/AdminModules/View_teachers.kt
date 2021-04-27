package com.example.attendacems.activities.AdminModules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Adapter.FacultyAdapter
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.R

class View_teachers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_teachers)
        var db : AmsDatabase;
        db= AmsDatabase.getDatabase(this)
        val x = findViewById<RecyclerView>(R.id.TList)
         val EmployeeList: List<Employee>
        EmployeeList = db.getEmployeeDao().GetAllEmployee()
         x.adapter = FacultyAdapter(EmployeeList)
        x.layoutManager = LinearLayoutManager(this)


    }
}