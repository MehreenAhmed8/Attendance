package com.synavos.AttendanceManagementSystem.activities.facultyActivities
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
import com.synavos.AttendanceManagementSystem.activities.adminActivities.adapters.viewStudentAdapter
import com.synavos.AttendanceManagementSystem.activities.facultyActivities.adapters.TeacherAttendanceApadter
import com.synavos.AttendanceManagementSystem.Database.AmsDatabase
import com.synavos.AttendanceManagementSystem.Database.dbTables.EmployeeAttendance
import com.synavos.AttendanceManagementSystem.Database.dbTables.Student
import com.synavos.AttendanceManagementSystem.Database.dbTables.StudentAttendance
import com.synavos.AttendanceManagementSystem.R
import com.synavos.AttendanceManagementSystem.activities.commnon.Date
import com.synavos.AttendanceManagementSystem.activities.studentActivities.adapters.studentAttendanceAdapter

class FacultyPanel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.faculty_panel_layout)
        val employeeMarkAttendance = findViewById<Button>(R.id.mark_employee_attendance)
        val employeeVeiwAttendance= findViewById<Button>(R.id.view_employee_attendance)
        val studentViewAttendance = findViewById<Button>(R.id.view_student_attendance)
        val studentVeiwStudent = findViewById<Button>(R.id.view_student)

        val intent1 = intent
        val eId = intent1.getStringExtra("Id")

        if (eId != null) {

            employeeMarkAttendance.setOnClickListener()
            {

                val db: AmsDatabase
                db = AmsDatabase.getDatabase(this)
                val Emp = db.getEmployeeAttendanceDao().getEmployee(Date.getdate(), eId)
                    if (Emp != null)
                    {
                        Toast.makeText(applicationContext, R.string.already, Toast.LENGTH_SHORT).show()
                    }
                    else
                        open_PopUp_Panel(eId)

            }

            employeeVeiwAttendance.setOnClickListener()
            {
                    setContentView(R.layout.display_student_teacher_attendance)
                    val x = findViewById<RecyclerView>(R.id.display_list)
                    val db: AmsDatabase
                    db = AmsDatabase.getDatabase(this)
                    val studentAList: List<EmployeeAttendance>
                    studentAList = db.getEmployeeAttendanceDao().getAttendance(eId)
                    x.adapter = TeacherAttendanceApadter(studentAList)
                    x.layoutManager = LinearLayoutManager(this)
            }

            studentViewAttendance.setOnClickListener()
            {
                setContentView(R.layout.display_student_teacher_attendance)
                val studentList = findViewById<RecyclerView>(R.id.display_list)
                val allStudentList: List<StudentAttendance>

                val db: AmsDatabase = AmsDatabase.getDatabase(this)
                allStudentList = db.getStudentAttendanceDao().GetAllStudentAttendance()

                studentList.adapter = studentAttendanceAdapter(allStudentList)
                studentList.layoutManager = LinearLayoutManager(this)
            }

            studentVeiwStudent.setOnClickListener()
            {
                setContentView(R.layout.display_student_layout)
                val db: AmsDatabase;
                db = AmsDatabase.getDatabase(this)
                val x = findViewById<RecyclerView>(R.id.StudentList)
                val studentList: List<Student> = db.getStudentDao().GetAllStudents()
                x.adapter = viewStudentAdapter(studentList)
                x.layoutManager = LinearLayoutManager(this)
            }
        }
    }
    @SuppressLint("SetTextI18n", "InflateParams")
    fun open_PopUp_Panel(id: String)
    {
        var db : AmsDatabase;
        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.mark_attendance_view, null)
        val popupWindow = PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val buttonPopup = view.findViewById<Button>(R.id.mark_attendance_popup)
        val buttonPopup_cancel = view.findViewById<Button>(R.id.popup_close)

        buttonPopup.text=getString(R.string.emp_mark_attendence)+id+"at" + Date.getdate()
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

        buttonPopup.setOnClickListener {
            db = AmsDatabase.getDatabase(this)
            val empAttendance: EmployeeAttendance = EmployeeAttendance(0, Date.getdate(), "Present", id)
            db.getEmployeeAttendanceDao().Insert(empAttendance)
            buttonPopup.text = (R.string.marked).toString();
            buttonPopup.setEnabled(false)
            Toast.makeText(applicationContext, R.string.attendance_marked, Toast.LENGTH_SHORT).show()
        }

        buttonPopup_cancel.setOnClickListener{
            popupWindow.dismiss()
        }

    }

}