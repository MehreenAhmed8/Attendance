package com.synavos.ams.activities.studentActivities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.database.db_tables.StudentAttendance
import com.synavos.ams.R
import com.synavos.ams.R.id.*

class StudentAttendanceAdapterActivity(private val StudentAttendance: List<StudentAttendance>) : RecyclerView.Adapter<StudentAttendanceAdapterActivity.StudentAttendanceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAttendanceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_teacher_attendance, parent, false)
        return StudentAttendanceViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentAttendanceViewHolder, position: Int) {
        setValues(holder, position)
    }

    override fun getItemCount(): Int {
        return this.StudentAttendance.size
    }

    class StudentAttendanceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var mId: TextView = itemView.findViewById(Id)
        var mDate: TextView = itemView.findViewById(DateView)
        var mStatus: TextView = itemView.findViewById(Absent_Present)

    }

    private fun setValues(holder: StudentAttendanceViewHolder, position: Int) {
        holder.mDate.text = StudentAttendance[position].Date
        holder.mStatus.text = StudentAttendance[position].Status
        holder.mId.text = StudentAttendance[position].Sid
    }
}