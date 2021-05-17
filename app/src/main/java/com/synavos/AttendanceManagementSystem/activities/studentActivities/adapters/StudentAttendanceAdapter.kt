package com.synavos.AttendanceManagementSystem.activities.studentActivities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.AttendanceManagementSystem.Database.dbTables.StudentAttendance
import com.synavos.AttendanceManagementSystem.R

class studentAttendanceAdapter(val StudentAttendance:List<StudentAttendance>): RecyclerView.Adapter<studentAttendanceAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_teacher_attendance,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Date.text=StudentAttendance[position].Date
        holder.Status.text=StudentAttendance[position].Status
        holder.Id.text=StudentAttendance[position].Sid



    }

    override fun getItemCount(): Int {
        return StudentAttendance.size
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        var Id=itemView.findViewById<TextView>(R.id.Id)
        var Date=itemView.findViewById<TextView>(R.id.DateView)
        var Status=itemView.findViewById<TextView>(R.id.Absent_Present)

    }
}