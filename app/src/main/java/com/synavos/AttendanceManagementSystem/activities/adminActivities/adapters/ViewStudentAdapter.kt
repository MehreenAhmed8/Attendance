package com.synavos.AttendanceManagementSystem.activities.adminActivities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.AttendanceManagementSystem.Database.dbTables.Student

import com.synavos.AttendanceManagementSystem.R

class viewStudentAdapter(val studentList:List<Student>):RecyclerView.Adapter<viewStudentAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
    val inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_and_teacher,parent,false)
    return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ID.text="ID : "+studentList[position].id.toString()
        holder.Name.text="Name : "+studentList[position].Name
        holder.Degree.text="Degree: "+studentList[position].Degree
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var ID=itemView.findViewById<TextView>(R.id.display_id)
        var Degree=itemView.findViewById<TextView>(R.id.display_status)
        var Name=itemView.findViewById<TextView>(R.id.display_name)

    }
}
