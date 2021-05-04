package com.synavos.AttendanceManagementSystem.activities.signInActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.Student
import com.synavos.AttendanceManagementSystem.Database.dbTables.Employee
import com.synavos.AttendanceManagementSystem.activities.facultyActivities.FacultyPanel
import com.synavos.AttendanceManagementSystem.R
import com.synavos.AttendanceManagementSystem.activities.adminActivities.modules.adminPanelActivity
import com.synavos.AttendanceManagementSystem.activities.studentActivities.studentPanelActivity
import com.synavos.AttendanceManagementSystem.admin.admin

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity_layout)
        val personSignIn = findViewById<Button>(R.id.person_sign_in)
        val id = findViewById<EditText>(R.id.person_name)
        val pass = findViewById<EditText>(R.id.person_password)
        val role = findViewById<EditText>(R.id.person_role)
        val obj1 = admin()

        personSignIn.setOnClickListener {
                val  pId = id.text.toString()
                val  mPass = pass.text.toString()
                val  mRole = role.text.toString()
                val db: AmsDatabase
                db = AmsDatabase.getDatabase(this)
                if (pId == "" || mPass == "" || mRole == "")
                {
                    Toast.makeText(this@MainActivity, getString(R.string.empty), Toast.LENGTH_SHORT).show()
                }
                else if (obj1.validateAdmin(pId, mPass, mRole))
                {
                    val intent = Intent(this@MainActivity, adminPanelActivity::class.java)
                    startActivityForResult(intent, 1)
                }
                else if (mRole.equals (getString(R.string.student)))
                {
                    val studentExist: Student? = db.getStudentDao().GetStudent(pId.toInt(), mPass)
                    if (studentExist != null)
                    {
                        val intent = Intent(this@MainActivity, studentPanelActivity::class.java)
                        intent.putExtra("Id", pId)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(this, getString(R.string.wrong), Toast.LENGTH_SHORT).show()
                    }

                }
                else if (mRole.equals(getString(R.string.faculty)))
                {
                    val facultyExist: Employee? = db.getEmployeeDao().GetEmployee(pId.toInt(), mPass)
                    if (facultyExist != null)
                    {
                                val intent2 = Intent(this, FacultyPanel::class.java)
                                    intent2.putExtra("Id", pId)
                                  startActivity(intent2)
                    }
                    else
                    {
                        Toast.makeText(this, R.string.wrong, Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(this@MainActivity, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
                }
        }
        }
}



