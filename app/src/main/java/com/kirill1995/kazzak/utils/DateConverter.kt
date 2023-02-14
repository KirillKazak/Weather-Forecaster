package com.kirill1995.kazzak.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

interface DateConverter {
    fun convertCurrentDate(date: String): Array<String> {
        val dateSplit = date.split(" ")[0]
        val timeSplit = date.split(" ")[1]

        val year = dateSplit.split("-")[0]
        val monthInt = dateSplit.split("-")[1]
        val day = dateSplit.split("-")[2]

        val hour = timeSplit.split(":")[0]
        val minutes = timeSplit.split(":")[1]

        val monthString = when(monthInt) {
            "01" -> "Jan"
            "02" -> "Feb"
            "03" -> "Mar"
            "04" -> "Apr"
            "05" -> "May"
            "06" -> "Jun"
            "07" -> "Jul"
            "08" -> "Ayg"
            "09" -> "Sep"
            "10" -> "Oct"
            "11" -> "Nov"
            "12" -> "Dec"
            else -> "Unknown"
        }
        return arrayOf(year, monthInt, monthString, day, hour, minutes)
    }


    @SuppressLint("SimpleDateFormat")
    fun convertUnixToTime(unixDate: Int): String {
        val dv: Long = java.lang.Long.valueOf(unixDate.toLong()) * Constants.MILLISECONDS_FACTOR
        val df = Date(dv)
        val vv: String = SimpleDateFormat("MM dd, yyyy hh:mma").format(df)
        val time = vv.split(" ")
        return if (time[3].contains("A")) {
            time[3].split("A")[0]
        } else if (time[3].contains("P")) {
            time[3].split("P")[0]
        } else { "Unknown" }
    }

    fun convertUnixToWeekday(unixDate: Int): String {
        val daysSinceEpoch = unixDate / 86400
        return when((daysSinceEpoch + 4) % 7) {
            0 -> "Sun"
            1 -> "Mon"
            2 -> "Tue"
            3 -> "Wed"
            4 -> "Thu"
            5 -> "Fri"
            6 -> "Sat"
            else -> "Unknown"
        }
    }
}