package com.synavos.AttendanceManagementSystem.admin

public class admin {
public fun validateAdmin(name:String , pass :String , role:String ) : Boolean
{
 if(name.equals("admin") && pass.equals("admin") && role.equals("admin"))
     return true
 return false
}
}