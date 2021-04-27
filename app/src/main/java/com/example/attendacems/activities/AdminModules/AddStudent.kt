package com.example.attendacems.activities.AdminModules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.Student
import com.example.attendacems.R
import com.example.attendacems.activities.Commnon.Date

class AddStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        var DOT= findViewById<TextView>(R.id.DateofJoining)
        DOT.text=Date.getdate()
        var Add = findViewById<Button>(R.id.Add)
        var db : AmsDatabase;
        Add.setOnClickListener()
        {

            var Name= findViewById<EditText>(R.id.StudentName).getText().toString()
            var Password= findViewById<EditText>(R.id.DefaultPassword).getText().toString()
            var Degree= findViewById<EditText>(R.id.Degree).getText().toString()
            db= AmsDatabase.getDatabase(this)

            val stu : Student= Student(0,Name, Password ,Date.getdate(), Degree)

            db.getStudentDao().Insert(stu)
            Toast.makeText(this, "Insert SucessFull", Toast.LENGTH_SHORT).show()
        }
    }


}