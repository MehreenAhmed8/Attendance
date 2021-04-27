package com.example.attendacems.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Database.dbTables.EmployeeAttendance
import com.example.attendacems.Database.dbTables.StudentAttendance
import com.example.attendacems.R

class TeacherAttendanceApadter(val FAttendance:List<EmployeeAttendance>) : RecyclerView.Adapter<TeacherAttendanceApadter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.personal_attandance_view,parent,false)
        return TeacherAttendanceApadter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Date.text=FAttendance[position].Date
        holder.Status.text=FAttendance[position].Status
        holder.Id.text=FAttendance[position].EmployeeId



    }

    override fun getItemCount(): Int {
        return FAttendance.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var Id=itemView.findViewById<TextView>(R.id.Id)
        var Date=itemView.findViewById<TextView>(R.id.DateView)
        var Status=itemView.findViewById<TextView>(R.id.Absent_Present)

    }
}