package com.parasde.simplecalendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.parasde.library.simpleweeklycalendar.data.WeeklyOrientation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cal.init(this as AppCompatActivity, 2019, 12, 2, null)

        // pageChange -> callback change year, month value
        cal.setCalendarPageChangeListener { year, month ->
            Log.d("CalendarPageChange", "$year - $month")
            if(month < 10) calHeader.text = "$year - 0${month}"
            else calHeader.text = "$year - $month"
        }

//        cal.onTouchEnable(false)

        // callback click item value
        cal.setCalendarClickListener { year, month, date ->
//            Toast.makeText(applicationContext, "$year $month $date", Toast.LENGTH_SHORT).show()
            Log.e("cal info", "${cal.clickYear}, ${cal.clickMonth}, ${cal.clickDate}")
        }


        val dayOfWeek: Array<String> = arrayOf("일", "월", "화", "수", "목", "금", "토")

        // scroll bar calendar test
//        cal2.init(this as AppCompatActivity, dayOfWeek, null)

        // weekly
        weekly.init(this as AppCompatActivity, 2020, 2, 20, dayOfWeek, WeeklyOrientation.VERTICAL)
        weekly.setWeeklyClickListener { year, month, date -> Toast.makeText(applicationContext, "$year $month $date", Toast.LENGTH_SHORT).show() }
        weekly.setWeeklyPageChangeListener { data -> Log.i("Weekly", "Prev weekly : ${data[0].weekOfMonth}\nCur weekly: ${data[6].weekOfMonth}") }
    }
}
