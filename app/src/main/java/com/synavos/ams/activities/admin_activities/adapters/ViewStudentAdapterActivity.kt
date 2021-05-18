package com.synavos.ams.activities.admin_activities.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synavos.ams.database.db_tables.Student

import com.synavos.ams.R

class ViewStudentAdapterActivity(activity: Activity, private val studentList: List<Student>) : RecyclerView.Adapter<ViewStudentAdapterActivity.StudentAdapterViewHolder>() {

    private val context: Context = activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.display_each_student_and_teacher, parent, false)
        return StudentAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentAdapterViewHolder, position: Int) {
        setValues(holder, position)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class StudentAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mID: TextView = itemView.findViewById(R.id.display_id)
        var mDegree: TextView = itemView.findViewById(R.id.display_status)
        var mName: TextView = itemView.findViewById(R.id.display_name)

    }

    private fun setValues(holder: StudentAdapterViewHolder, position: Int) {
        holder.mID.text = context.resources.getString(R.string.id, studentList[position].Id.toString())
        holder.mName.text = context.resources.getString(R.string.faculty_name, studentList[position].Name)
        holder.mDegree.text = context.resources.getString(R.string.student_degree, studentList[position].Degree)
    }
}
