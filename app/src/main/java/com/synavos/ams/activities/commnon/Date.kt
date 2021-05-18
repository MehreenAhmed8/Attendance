package com.synavos.ams.activities.commnon

import java.util.*

class Date {
    companion object {
        fun getdate(): String {
            val c: Calendar = Calendar.getInstance()
            val day: Int = c.get(Calendar.DAY_OF_MONTH)
            val month: Int = c.get(Calendar.MONTH)
            val year: Int = c.get(Calendar.YEAR)

            return day.toString() + "/" + (month + 1) + "/" + year
        }
    }

}

