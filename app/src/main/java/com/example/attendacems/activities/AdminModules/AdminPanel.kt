package com.example.attendacems.activities.AdminModules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.attendacems.R

class AdminPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_panel)
        var add = findViewById<Button>(R.id.Addstudent)
        add.setOnClickListener {
            val intent = Intent(this, AddStudent::class.java)
            startActivityForResult(intent,1)

        }

        var VeiwStudents = findViewById<Button>(R.id.ViewStudents)
            VeiwStudents.setOnClickListener {
                val intent = Intent(this, View_Students_and_Teacher::class.java).apply {
                    intent.putExtra("tag","student")
                }
                startActivity(intent)

            }


        var AddEmployees1 = findViewById<Button>(R.id.AddF)

            AddEmployees1.setOnClickListener{
                //Toast.makeText(this,"agya", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, AddEmployee::class.java)
                startActivityForResult(intent, 2)
            }

            var Veiw_Employees = findViewById<Button>(R.id.ViewFaculty)
            Veiw_Employees.setOnClickListener {
                val intent = Intent(this, View_teachers::class.java).apply {

                }
                startActivity(intent)
            }


    }
}