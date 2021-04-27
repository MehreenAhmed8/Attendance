package com.example.attendacems.activities.StudentModules

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Adapter.PersonAttendanceAdapter
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.Student
import com.example.attendacems.Database.dbTables.StudentAttendance
import com.example.attendacems.R
import com.example.attendacems.activities.Commnon.Date
import com.example.attendacems.activities.Commnon.ViewPersonalAttendance
import java.util.*

class StudentPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_panel)
        val intent1 = intent
        val id = intent1.getStringExtra("Id")
        val MarkAttendance = findViewById<Button>(R.id.Mark)
        val VeiwAttendance = findViewById<Button>(R.id.ViewAttendance)

        if (id != null) {
            MarkAttendance.setOnClickListener()
            {

                var db: AmsDatabase;

                    db = AmsDatabase.getDatabase(this)

                    val Student = db.getStudentAttendanceDao().getStudent(Date.getdate(), id)

                    if (Student != null) {
                        Toast.makeText(applicationContext, "attendance already marked", Toast.LENGTH_SHORT).show()
                    } else {
                        open_PopUp_Panel(id)
                    }
            }
            VeiwAttendance.setOnClickListener()
            {
                    setContentView(R.layout.activity_view_personal_attendance)
                    val x = findViewById<RecyclerView>(R.id.AList)
                    var db: AmsDatabase;
                    db = AmsDatabase.getDatabase(this)
                    val studentAList: List<com.example.attendacems.Database.dbTables.StudentAttendance>
                    studentAList = db.getStudentAttendanceDao().getStudentAttendance(id)

                    x.adapter = PersonAttendanceAdapter(studentAList)
                    x.layoutManager = LinearLayoutManager(this)
            }
        }
    }
    fun open_PopUp_Panel(id: String)
    {
        var db : AmsDatabase;
        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.another_view, null)
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val buttonPopup = view.findViewById<Button>(R.id.button_popup_Mark)
        val buttonPopup_cancel = view.findViewById<Button>(R.id.button_popup_close)
        buttonPopup.text="Mark Attendance of "+Date.getdate()
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        buttonPopup.setOnClickListener {

            db = AmsDatabase.getDatabase(this)

                val StudentA: StudentAttendance = StudentAttendance(0, Date.getdate(), "Present", id)
                db.getStudentAttendanceDao().Insert(StudentA)
                buttonPopup.text = "marked";
                buttonPopup.setEnabled(false)
                Toast.makeText(applicationContext, "attendance marked", Toast.LENGTH_SHORT).show()
        }

        buttonPopup_cancel.setOnClickListener {
            popupWindow.dismiss()
        }


    }
}