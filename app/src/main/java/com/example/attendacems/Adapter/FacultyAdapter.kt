package com.example.attendacems.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Database.dbTables.Employee
import com.example.attendacems.R

class FacultyAdapter(val employeeList: List<Employee>) : RecyclerView.Adapter<FacultyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view,parent,false)
        return FacultyAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        holder.ID.text="ID : "+employeeList[position].id.toString()
        holder.Name.text="Name : "+employeeList[position].Name
        holder.Type.text="Type : "+employeeList[position].Type
    }

    override fun getItemCount(): Int {

        return employeeList.size;
    }
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var ID=itemView.findViewById<TextView>(R.id.ID)
        var Type=itemView.findViewById<TextView>(R.id.status)
        var Name=itemView.findViewById<TextView>(R.id.Name)

    }
}
