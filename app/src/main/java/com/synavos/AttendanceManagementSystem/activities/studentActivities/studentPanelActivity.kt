package com.synavos.AttendanceManagementSystem.activities.studentActivities

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synavos.AttendanceManagementSystem.activities.studentActivities.adapters.studentAttendanceAdapter
import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.StudentAttendance
import com.synavos.AttendanceManagementSystem.R
import com.synavos.AttendanceManagementSystem.activities.commnon.Date

class studentPanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_panel_layout)
        val intent1 = intent
        val sId = intent1.getStringExtra("Id")
        val markAttendance = findViewById<Button>(R.id.mark_attendance)
        val veiwAttendance = findViewById<Button>(R.id.view_attendence)

        if (sId != null) {

            markAttendance.setOnClickListener()
            {
                val db: AmsDatabase = AmsDatabase.getDatabase(this)
                val nStudent = db.getStudentAttendanceDao().getStudent(Date.getdate(), sId)
                if (nStudent != null)
                    {
                        Toast.makeText(applicationContext, R.string.already, Toast.LENGTH_SHORT).show()
                    } else
                    {
                        open_PopUp_Panel(sId)
                    }
            }

            veiwAttendance.setOnClickListener()
            {
                    setContentView(R.layout.display_student_teacher_attendance)
                    val studentList = findViewById<RecyclerView>(R.id.display_list)
                    val aStudentList: List<StudentAttendance>

                    val db: AmsDatabase = AmsDatabase.getDatabase(this)
                    aStudentList = db.getStudentAttendanceDao().getStudentAttendance(sId)

                    studentList.adapter = studentAttendanceAdapter(aStudentList)
                    studentList.layoutManager = LinearLayoutManager(this)
            }
        }
    }

    fun open_PopUp_Panel(id: String)
    {
        var db : AmsDatabase
        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.mark_attendance_view, null)

        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val markTodayAttendance = view.findViewById<Button>(R.id.mark_attendance_popup)
        val Attendance_cancel = view.findViewById<Button>(R.id.popup_close)

        (getString(R.string.mark)+Date.getdate()).also { markTodayAttendance.text = it }
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        markTodayAttendance.setOnClickListener {

            db = AmsDatabase.getDatabase(this)

                val StudentA = StudentAttendance(0, Date.getdate(), getString(R.string.status), id)
                db.getStudentAttendanceDao().Insert(StudentA)
                markTodayAttendance.text = getString(R.string.marked);
                markTodayAttendance.setEnabled(false)
                Toast.makeText(applicationContext, getString(R.string.attendance_marked), Toast.LENGTH_SHORT).show()
        }

        Attendance_cancel.setOnClickListener {
            popupWindow.dismiss()
        }
    }
}