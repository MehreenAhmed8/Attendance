package com.synavos.ams.activities.faculty_activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.database.db_tables.EmployeeAttendance
import com.synavos.ams.R

class TeacherAttendanceAdapterActivity(private val facultyAttendance: List<EmployeeAttendance>) : RecyclerView.Adapter<TeacherAttendanceAdapterActivity.TeacherAttendanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherAttendanceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_teacher_attendance, parent, false)
        return TeacherAttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherAttendanceViewHolder, position: Int) {
        setValues(holder, position)
    }

    override fun getItemCount(): Int {
        return facultyAttendance.size
    }

    class TeacherAttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var nId: TextView = itemView.findViewById(R.id.Id)
        var nDate: TextView = itemView.findViewById(R.id.DateView)
        var nStatus: TextView = itemView.findViewById(R.id.Absent_Present)
    }

    private fun setValues(holder: TeacherAttendanceViewHolder, position: Int)
    {
        holder.nDate.text = facultyAttendance[position].Date
        holder.nStatus.text = facultyAttendance[position].Status
        holder.nId.text = facultyAttendance[position].EmployeeId
    }
}