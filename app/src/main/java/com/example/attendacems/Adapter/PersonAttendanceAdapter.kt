package com.example.attendacems.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Data.Student
import com.example.attendacems.Database.dbTables.StudentAttendance
import com.example.attendacems.R

class PersonAttendanceAdapter(val SAttendance:List<StudentAttendance>): RecyclerView.Adapter<PersonAttendanceAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.personal_attandance_view,parent,false)
        return PersonAttendanceAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Date.text=SAttendance[position].Date
        holder.Status.text=SAttendance[position].Status
        holder.Id.text=SAttendance[position].Sid



    }

    override fun getItemCount(): Int {
        return SAttendance.size
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        var Id=itemView.findViewById<TextView>(R.id.Id)
        var Date=itemView.findViewById<TextView>(R.id.DateView)
        var Status=itemView.findViewById<TextView>(R.id.Absent_Present)

    }
}