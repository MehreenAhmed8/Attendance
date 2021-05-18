package com.synavos.ams.activities.admin_activities.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.database.db_tables.Employee
import com.synavos.ams.R

class FacultyAdapterActivity(activity: Activity, private val employeeList: List<Employee>) : RecyclerView.Adapter<FacultyAdapterActivity.FacultyAdapterViewHolder>() {
    private val context: Context = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_and_teacher, parent, false)
        return FacultyAdapterViewHolder(view)
    }


    override fun onBindViewHolder(holder: FacultyAdapterViewHolder, position: Int) {
        setValues(holder, position)
    }

    override fun getItemCount(): Int {

        return this.employeeList.size
    }

    class FacultyAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mID: TextView = itemView.findViewById(R.id.display_id)
        var mType: TextView = itemView.findViewById(R.id.display_status)
        var mName: TextView = itemView.findViewById(R.id.display_name)
    }


    private fun setValues(holder: FacultyAdapterViewHolder, position: Int) {
        holder.mID.text = context.resources.getString(R.string.id, employeeList[position].Id.toString())
        holder.mName.text = context.resources.getString(R.string.faculty_name, employeeList[position].Name)
        holder.mType.text = context.resources.getString(R.string.faculty_type, employeeList[position].Type)
    }

}
