package com.tuto.vle.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class TimeUtil {


  public Timestamp addHoursToDate(int hours) {
    Timestamp timestamp = new Timestamp(new Date().getTime());
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timestamp.getTime());
    calendar.add(Calendar.HOUR_OF_DAY, hours);
    timestamp = new Timestamp(calendar.getTime().getTime());
    return timestamp;
  }

}
