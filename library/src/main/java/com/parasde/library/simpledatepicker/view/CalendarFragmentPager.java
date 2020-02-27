package com.parasde.library.simpledatepicker.view;

import android.widget.LinearLayout;

import com.parasde.library.simpledatepicker.R;
import com.parasde.library.simpledatepicker.data.CalendarClickData;
import com.parasde.library.simpledatepicker.data.CalendarMemo;
import com.parasde.library.simpledatepicker.data.CalendarSize;
import com.parasde.library.simpledatepicker.listener.CalendarClickListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarFragmentPager extends CalendarFragment {
    private CalendarClickListener calendarClickListener;
    private CalendarClickData calendarClickData;
    private String[] weekDay;
    private CalendarSize size;

    private Calendar cal;

    private ArrayList<CalendarMemo> memoItems;
    private String colorHex;
    private float memoFontSize, calendarFontSize;

    CalendarFragmentPager(Calendar cal, CalendarClickListener calendarClickListener, CalendarClickData calendarClickData, String[] weekDay,
                          CalendarSize size, ArrayList<CalendarMemo> memoItems, String colorHex, float memoFontSize, float calendarFontSize) {
        this.calendarClickListener = calendarClickListener;
        this.calendarClickData = calendarClickData;
        this.weekDay = weekDay;
        this.size = size;
        this.cal = (Calendar)cal.clone();
        this.memoItems = memoItems;
        this.colorHex = colorHex;
        this.memoFontSize = memoFontSize;
        this.calendarFontSize = calendarFontSize;
    }

    // select pager calendar
    Calendar getCalendar() {
        return cal;
    }

    @Override
    protected int layoutResId() {
        return R.layout.calendar_pager;
    }

    @Override
    protected void initLayout(@NotNull LinearLayout layout) {
        CalendarLayoutView calLayout = new CalendarLayoutView(getContext());
        if(calendarClickListener != null) calLayout.setCalendarDateOnClickListener(calendarClickListener);
        layout.addView(calLayout.onCreateLayout(cal, weekDay, calendarClickData, size, memoItems, colorHex,  memoFontSize, calendarFontSize));
    }
}
