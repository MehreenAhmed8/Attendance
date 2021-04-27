package com.example.attendacems.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.attendacems.Database.dbTables.Student

import com.example.attendacems.R

class MyAdapter(val student:List<Student>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    var inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view,parent,false)
    return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ID.text="ID : "+student[position].id.toString()
        holder.Name.text="Name : "+student[position].Name
        holder.Degree.text="Degree: "+student[position].Degree
    }

    override fun getItemCount(): Int {
        return student.size
    }
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var ID=itemView.findViewById<TextView>(R.id.ID)
        var Degree=itemView.findViewById<TextView>(R.id.status)
        var Name=itemView.findViewById<TextView>(R.id.Name)

    }
}
