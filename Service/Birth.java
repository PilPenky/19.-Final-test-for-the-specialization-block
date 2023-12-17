package Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Birth {
    int year;
    int month;
    int dayOfMonth;

    public Birth(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public String birthday() {
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDateNow.format(date);
    }

    @Override
    public String toString() {
        return birthday();
    }
}