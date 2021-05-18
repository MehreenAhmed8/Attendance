package com.synavos.ams.activities.admin_activities.modules

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.Student
import com.synavos.ams.R
import com.synavos.ams.activities.commnon.Date

class AddStudentActivity : AppCompatActivity() {

    lateinit var db: AmsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_student_layout)

        val mDateOfJoin = findViewById<TextView>(R.id.date_of_join)
        val mAdd = findViewById<Button>(R.id.add_student)

        mDateOfJoin.text = Date.getdate()

        mAdd.setOnClickListener()
        {
            val mStudent: Student = getStudentCredentials(this)
            savetodatabase(mStudent)
        }
    }

    private fun getStudentCredentials(context: Activity): Student {
        val studentName: EditText = (context).findViewById(R.id.student_name)
        val studentPassword: EditText = (context).findViewById(R.id.student_password)
        val studentDegree: EditText = (context).findViewById(R.id.degree)

        return Student(0,
                studentName.text.toString(),
                studentPassword.text.toString(),
                Date.getdate(),
                studentDegree.text.toString())

    }

    private fun savetodatabase(student: Student)
    {
        AmsDatabase.getDatabase(this).also { db = it }
        db.getStudentDao().insert(student)
        Toast.makeText(this, getString(R.string.insert_sucessfull), Toast.LENGTH_SHORT).show()
    }


}