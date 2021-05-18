package com.synavos.ams.activities.signInActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.Student
import com.synavos.ams.database.db_tables.Employee
import com.synavos.ams.activities.faculty_activities.FacultyPanelActivity
import com.synavos.ams.R
import com.synavos.ams.R.id.*
import com.synavos.ams.activities.admin_activities.modules.AdminPanelActivity
import com.synavos.ams.activities.studentActivities.StudentPanelActivity
import com.synavos.ams.admin.Admin

class MainActivity : AppCompatActivity() {
    lateinit var db: AmsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity_layout)

        val personSignIn = findViewById<Button>(person_sign_in)
        val id = findViewById<EditText>(person_name)
        val pass = findViewById<EditText>(person_password)
        val role = findViewById<EditText>(person_role)


        personSignIn.setOnClickListener {
            val pId = id.text.toString()
            val mPass = pass.text.toString()
            val mRole = role.text.toString()
            getDetails(pId, mPass, mRole)
        }
    }

    private fun isEmpty(id: String, pass: String, role: String): Boolean {
        if (id == "" || pass == "" || role == "") {
            return true
        }
        return false
    }

    private fun openStudent(pId: String, mPass: String) {

        db = AmsDatabase.getDatabase(this)
        val studentExist: Student? = db.getStudentDao().getStudent(pId.toInt(), mPass)

        if (studentExist != null) {
            val intent = Intent(this@MainActivity, StudentPanelActivity::class.java)
            intent.putExtra("Id", pId)
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.wrong), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDetails(pId: String, mPass: String, mRole: String) {
        val obj1 = Admin()
        when {
            this.isEmpty(id = pId, pass = mPass, role = mRole) -> {
                Toast.makeText(this@MainActivity, getString(R.string.empty), Toast.LENGTH_SHORT).show()
            }
            obj1.validateAdmin(pId, mPass, mRole) -> {
                val intent = Intent(this@MainActivity, AdminPanelActivity::class.java)
                startActivityForResult(intent, 1)
            }
            mRole == getString(R.string.student) -> {
                openStudent(pId, mPass)
            }
            mRole == getString(R.string.faculty) -> {
                db = AmsDatabase.getDatabase(this)
                val facultyExist: Employee? = db.getEmployeeDao().getEmployee(pId.toInt(), mPass)
                if (facultyExist != null) {
                    val intent2 = Intent(this, FacultyPanelActivity::class.java)
                    intent2.putExtra("Id", pId)
                    startActivity(intent2)
                } else {
                    Toast.makeText(this, R.string.wrong, Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                Toast.makeText(this@MainActivity, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
            }
        }
    }


}



