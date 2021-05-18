package com.synavos.ams.activities.faculty_activities

import android.annotation.SuppressLint
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
import com.synavos.ams.activities.admin_activities.adapters.ViewStudentAdapterActivity
import com.synavos.ams.activities.faculty_activities.adapters.TeacherAttendanceAdapterActivity
import com.synavos.ams.database.AmsDatabase
import com.synavos.ams.database.db_tables.EmployeeAttendance
import com.synavos.ams.database.db_tables.Student
import com.synavos.ams.database.db_tables.StudentAttendance
import com.synavos.ams.R
import com.synavos.ams.activities.commnon.Date
import com.synavos.ams.activities.studentActivities.adapters.StudentAttendanceAdapterActivity

class FacultyPanelActivity : AppCompatActivity() {
    lateinit var db: AmsDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.faculty_panel_layout)

        db = AmsDatabase.getDatabase(this)

        val employeeMarkAttendance: Button = findViewById(R.id.mark_employee_attendance)
        val employeeViewAttendance: Button = findViewById(R.id.view_employee_attendance)
        val studentViewAttendance: Button = findViewById(R.id.view_student_attendance)
        val studentViewStudent: Button = findViewById(R.id.view_student)

        val employeeId = this.intent.getStringExtra("Id")
        if (employeeId != null) {

            employeeMarkAttendance.setOnClickListener()
            {
                if (getEmployee(employeeId) != null)
                    Toast.makeText(applicationContext, R.string.already, Toast.LENGTH_SHORT).show()
                else
                    openPopUpPanel(employeeId)
            }

            employeeViewAttendance.setOnClickListener()
            {
                setContentView(R.layout.display_student_teacher_attendance)
                showEmployees(getEmployeeAttendance(employeeId))
            }

            studentViewAttendance.setOnClickListener()
            {
                setContentView(R.layout.display_student_teacher_attendance)
                showStudentAttendance(getStudentAttendance())
            }

            studentViewStudent.setOnClickListener()
            {
                setContentView(R.layout.display_student_layout)
                showStudents(getStudents())
            }
        }
    }

    @SuppressLint("SetTextI18n", "InflateParams")
    fun openPopUpPanel(id: String) {
        var db: AmsDatabase
        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.mark_attendance_view, null)
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val buttonPopup = view.findViewById<Button>(R.id.mark_attendance_popup)
        val buttonPopUpCancel = view.findViewById<Button>(R.id.popup_close)

        buttonPopup.text = getString(R.string.emp_mark_attendence, id, Date.getdate())
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        buttonPopup.setOnClickListener {
            db = AmsDatabase.getDatabase(this)
            val empAttendance = EmployeeAttendance(0, Date.getdate(), "Present", id)
            db.getEmployeeAttendanceDao().insert(employee = empAttendance)
            buttonPopup.text = (R.string.marked).toString()
            buttonPopup.isEnabled = false
            Toast.makeText(applicationContext, R.string.attendance_marked, Toast.LENGTH_SHORT).show()
        }

        buttonPopUpCancel.setOnClickListener {
            popupWindow.dismiss()
        }

    }

    private fun getEmployee(id: String): EmployeeAttendance? {
        return db.getEmployeeAttendanceDao().getEmployee(Date.getdate(), id)
    }

    private fun getEmployeeAttendance(employeeId: String): List<EmployeeAttendance> {
        return db.getEmployeeAttendanceDao().getAttendance(employeeId)
    }

    private fun showEmployees(employeeList: List<EmployeeAttendance>) {
        val employeeRecyclerView = findViewById<RecyclerView>(R.id.display_list)
        employeeRecyclerView.adapter = TeacherAttendanceAdapterActivity(employeeList)
        employeeRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getStudentAttendance(): List<StudentAttendance> {
        return db.getStudentAttendanceDao().getAllStudentAttendance()
    }

    private fun showStudentAttendance(allStudentList: List<StudentAttendance>) {
        val studentList = findViewById<RecyclerView>(R.id.display_list)
        studentList.adapter = StudentAttendanceAdapterActivity(allStudentList)
        studentList.layoutManager = LinearLayoutManager(this)
    }

    private fun getStudents(): List<Student> {
        return db.getStudentDao().getAllStudents()
    }

    private fun showStudents(allStudentList: List<Student>) {
        val studentList = findViewById<RecyclerView>(R.id.StudentList)
        studentList.adapter = ViewStudentAdapterActivity(this, allStudentList)
        studentList.layoutManager = LinearLayoutManager(this)
    }
}