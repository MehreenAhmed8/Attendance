package com.synavos.ams.activities.studentActivities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.activities.studentActivities.adapters.StudentAttendanceAdapterActivity
import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.StudentAttendance
import com.synavos.ams.R
import com.synavos.ams.activities.commnon.Date

class StudentPanelActivity : AppCompatActivity() {
    lateinit var db: AmsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_panel_layout)

        val studentId = intent.getStringExtra("Id")

        val markAttendance = findViewById<Button>(R.id.mark_attendance)
        val viewAttendance = findViewById<Button>(R.id.view_attendance)

        if (studentId != null) {

            markAttendance.setOnClickListener()
            {
                if (getStudent(studentId) != null) {
                    Toast.makeText(applicationContext, R.string.already, Toast.LENGTH_SHORT).show()
                } else {
                    openPopupPanel(studentId)
                }
            }

            viewAttendance.setOnClickListener()
            {
                setContentView(R.layout.display_student_teacher_attendance)
                showStudentAttendance(getStudentAttendance(studentId))
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun openPopupPanel(id: String) {

        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.mark_attendance_view, null)
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val markTodayAttendance = view.findViewById<Button>(R.id.mark_attendance_popup)
        val attendanceCancel = view.findViewById<Button>(R.id.popup_close)

        (getString(R.string.mark, Date.getdate())).also { markTodayAttendance.text = it }
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        markTodayAttendance.setOnClickListener {

            db = AmsDatabase.getDatabase(this)
            val studentA = StudentAttendance(0, Date.getdate(), getString(R.string.status), id)
            db.getStudentAttendanceDao().insert(studentA)
            markTodayAttendance.text = getString(R.string.marked)
            markTodayAttendance.isEnabled = false

            Toast.makeText(applicationContext, getString(R.string.attendance_marked), Toast.LENGTH_SHORT).show()
        }

        attendanceCancel.setOnClickListener {
            popupWindow.dismiss()
        }
    }

    private fun getStudent(id: String): StudentAttendance? {
        db = AmsDatabase.getDatabase(this)
        return db.getStudentAttendanceDao().getStudent(Date.getdate(), id)
    }

    private fun getStudentAttendance(id: String): List<StudentAttendance> {
        db = AmsDatabase.getDatabase(this)
        return db.getStudentAttendanceDao().getStudentAttendance(id)
    }

    private fun showStudentAttendance(attendanceList: List<StudentAttendance>) {
        val studentList = findViewById<RecyclerView>(R.id.display_list)
        studentList.adapter = StudentAttendanceAdapterActivity(attendanceList)
        studentList.layoutManager = LinearLayoutManager(this)
    }
}