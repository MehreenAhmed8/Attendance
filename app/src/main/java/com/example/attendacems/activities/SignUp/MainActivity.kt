package com.example.attendacems.activities.SignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.activities.FacultyModules.FacultyPanel
import com.example.attendacems.R
import com.example.attendacems.activities.AdminModules.AdminPanel
import com.example.attendacems.activities.StudentModules.StudentPanel
import com.example.attendacems.admin.admin

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var SignIn = findViewById<Button>(R.id.b1)

            val obj1 = admin()
            SignIn.setOnClickListener {
                var id = (findViewById<EditText>(R.id.PersonName)).text.toString()
                var pass = findViewById<EditText>(R.id.TextPassword).text.toString()
                var role = findViewById<EditText>(R.id.Role).text.toString()
                var db: AmsDatabase;
                db = AmsDatabase.getDatabase(this)
                if (id == "" || pass == "" || role == "") {
                    Toast.makeText(this@MainActivity, "Please fill the fields properly", Toast.LENGTH_SHORT).show()
                } else if (obj1.validateAdmin(id, pass, role))
                {
                    val intent = Intent(this@MainActivity, AdminPanel::class.java)
                    startActivityForResult(intent, 1)
                } else if (role.equals("student")) {

                    val studentExist: com.example.attendacems.Database.dbTables.Student
                    studentExist = db.getStudentDao().GetStudent(id.toInt(), pass)

                    if (studentExist != null) {
                        val intent = Intent(this@MainActivity, StudentPanel::class.java)
                        intent.putExtra("Id", id)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }

                } else if (role.equals("faculty"))
                {

                    val FacultyExist: Employee
                    FacultyExist = db.getEmployeeDao().GetEmployee(id.toInt(), pass)
                    if (FacultyExist != null) {
                                val intent2 = Intent(this, FacultyPanel::class.java)
                                 intent2.putExtra("Id", id)
                                  startActivity(intent2)

                    }
                    else {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Either Id or password or role is incoreect", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }



