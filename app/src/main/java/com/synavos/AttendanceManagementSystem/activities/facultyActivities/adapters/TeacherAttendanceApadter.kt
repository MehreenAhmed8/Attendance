package com.synavos.AttendanceManagementSystem.activities.facultyActivities.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.AttendanceManagementSystem.Database.dbTables.EmployeeAttendance
import com.synavos.AttendanceManagementSystem.R

class TeacherAttendanceApadter(val facultyAttendance:List<EmployeeAttendance>) : RecyclerView.Adapter<TeacherAttendanceApadter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_teacher_attendance,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Date.text=facultyAttendance[position].Date
        holder.Status.text=facultyAttendance[position].Status
        holder.Id.text=facultyAttendance[position].EmployeeId
    }

    override fun getItemCount(): Int {
        return facultyAttendance.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var Id=itemView.findViewById<TextView>(R.id.Id)
        var Date=itemView.findViewById<TextView>(R.id.DateView)
        var Status=itemView.findViewById<TextView>(R.id.Absent_Present)
    }
}