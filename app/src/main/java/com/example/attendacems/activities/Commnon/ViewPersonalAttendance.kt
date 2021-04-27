package com.example.attendacems.activities.Commnon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Adapter.MyAdapter
import com.example.attendacems.Adapter.PersonAttendanceAdapter
import com.example.attendacems.Data.Student
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.R

class ViewPersonalAttendance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_personal_attendance)
        val x = findViewById<RecyclerView>(R.id.AList)

            var db: AmsDatabase;
            db = AmsDatabase.getDatabase(this)
            val studentAList: List<com.example.attendacems.Database.dbTables.StudentAttendance>
            studentAList = db.getStudentAttendanceDao().GetAllStudentAttendance()

            x.adapter = PersonAttendanceAdapter(studentAList)
            x.layoutManager = LinearLayoutManager(this)

    }
}