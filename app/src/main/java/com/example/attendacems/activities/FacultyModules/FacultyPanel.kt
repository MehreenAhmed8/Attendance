package com.example.attendacems.activities.FacultyModules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Adapter.MyAdapter
import com.example.attendacems.Adapter.PersonAttendanceAdapter
import com.example.attendacems.Adapter.TeacherAttendanceApadter
import com.example.attendacems.Database.AmsDatabase
import com.example.attendacems.Database.dbTables.EmployeeAttendance
import com.example.attendacems.Database.dbTables.Student
import com.example.attendacems.R
import com.example.attendacems.activities.Commnon.Date

class FacultyPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_panel)
       val MarkTAttendance = findViewById<Button>(R.id.Mark1)
       val VeiwTAttendance= findViewById<Button>(R.id.ViewAttendance1)
        val ViewAttendance = findViewById<Button>(R.id.ViewStudentsA1)
        val VeiwStudent = findViewById<Button>(R.id.ViewStudent1)
        val intent1 = intent
       val id = intent1.getStringExtra("Id")
        if (id != null) {
            MarkTAttendance.setOnClickListener()
            {
                var db: AmsDatabase;
                db = AmsDatabase.getDatabase(this)
                val Emp = db.getEmployeeAttendanceDao().getEmployee(Date.getdate(), id)
                    if (Emp != null) {
                        Toast.makeText(applicationContext, "attendance already marked", Toast.LENGTH_SHORT).show()
                    } else {
                        open_PopUp_Panel(id)
                    }

            }
            VeiwTAttendance.setOnClickListener()
            {
                    setContentView(R.layout.activity_view_personal_attendance)
                    Toast.makeText(this, id, Toast.LENGTH_LONG).show()
                    val x = findViewById<RecyclerView>(R.id.AList)
                    var db: AmsDatabase;
                    db = AmsDatabase.getDatabase(this)
                    val studentAList: List<com.example.attendacems.Database.dbTables.EmployeeAttendance>
                    studentAList = db.getEmployeeAttendanceDao().getAttendance(id)
                    x.adapter = TeacherAttendanceApadter(studentAList)
                    x.layoutManager = LinearLayoutManager(this)
            }
            ViewAttendance.setOnClickListener()
            {
                setContentView(R.layout.activity_view_personal_attendance)
                val x = findViewById<RecyclerView>(R.id.AList)
                var db: AmsDatabase;
                db = AmsDatabase.getDatabase(this)
                val studentAList: List<com.example.attendacems.Database.dbTables.StudentAttendance>
                studentAList = db.getStudentAttendanceDao().GetAllStudentAttendance()
                x.adapter = PersonAttendanceAdapter(studentAList)
                x.layoutManager = LinearLayoutManager(this)
            }
            VeiwStudent.setOnClickListener()
            {
                setContentView(R.layout.activity_view__students_and__teacher)
                var db: AmsDatabase;
                db = AmsDatabase.getDatabase(this)
                val x = findViewById<RecyclerView>(R.id.SList)
                val studentList: List<Student>
                studentList = db.getStudentDao().GetAllStudents()
                x.adapter = MyAdapter(studentList)
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
        buttonPopup.text="Mark Attendance of id : "+id+"at" + Date.getdate()
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
        buttonPopup.setOnClickListener {

            db = AmsDatabase.getDatabase(this)

            val EmpA: EmployeeAttendance = EmployeeAttendance(0, Date.getdate(), "Present", id)
            db.getEmployeeAttendanceDao().Insert(EmpA)
            buttonPopup.text = "marked";
            buttonPopup.setEnabled(false)
            Toast.makeText(applicationContext, "attendance marked", Toast.LENGTH_SHORT).show()
        }

        buttonPopup_cancel.setOnClickListener{
            popupWindow.dismiss()
        }

    }

}