package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReverseBirth {
    public Date stringToDate(String strDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse(strDate);
        return date;
    }

    public String dateToString(Date date) throws ParseException {
        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String str = myDateFormat.format(date);
        return str;
    }
}