package morxander.zaman;

import java.util.HashMap;


/**
 * Created by morxander on 12/6/16.
 */

public class AngoTimeString {
    public static final String NOW = "Just Now";
    public static final String IN_FEW_SECONDS = "In a few seconds";
    public static final String AGO = "ago";
    public static final String IN = "In";

    public static final String MINUTE = "minute";
    public static final String MINUTES = "minutes";
    public static final String ONE_MINUTE_AGO = "A " + MINUTE + " " + AGO;
    public static final String IN_ONE_MINUTE = IN + " a " + MINUTE;


    public static final String HOUR = "hour";
    public static final String HOURS = "hours";
    public static final String ONE_HOUR_AGO = "Last" + " " + HOUR;
    public static final String IN_ONE_HOUR = "Next" + " " + HOUR;


    public static final String DAY = "day";
    public static final String DAYS = "days";
    public static final String ONE_DAY_AGO = "Yesterday";
    public static final String IN_ONE_DAY = "Tomorrow";


    public static final String WEEK = "week";
    public static final String WEEKS = "weeks";
    public static final String ONE_WEEK_AGO = "Last" + " " + WEEK;
    public static final String IN_ONE_WEEK = "Next" + " " + WEEK;

    public static final String MONTH = "month";
    public static final String MONTHS = "months";
    public static final String ONE_MONTH_AGO = "Last" + " " + MONTH;
    public static final String IN_ONE_MONTH = "Next" + " " + MONTH;


    public static final String YEAR = "year";
    public static final String YEARS = "years";
    public static final String ONE_YEAR_AGO = "Last" + " " + YEAR;
    public static final String IN_ONE_YEAR = "Next" + " " + YEAR;

    public static final HashMap<String, String> ONE_THING_AGO;
    public static final HashMap<String, String> IN_ONE_THING;

    static {
        ONE_THING_AGO = new HashMap<String, String>();
        ONE_THING_AGO.put("minute", ONE_MINUTE_AGO);
        ONE_THING_AGO.put("day", ONE_DAY_AGO);
        ONE_THING_AGO.put("hour", ONE_HOUR_AGO);
        ONE_THING_AGO.put("week", ONE_WEEK_AGO);
        ONE_THING_AGO.put("month", ONE_MONTH_AGO);
        ONE_THING_AGO.put("year", ONE_YEAR_AGO);


    }

    static {
        IN_ONE_THING = new HashMap<String, String>();
        IN_ONE_THING.put("minute", IN_ONE_MINUTE);
        IN_ONE_THING.put("day", IN_ONE_DAY);
        IN_ONE_THING.put("hour", IN_ONE_HOUR);
        IN_ONE_THING.put("week", IN_ONE_WEEK);
        IN_ONE_THING.put("month", IN_ONE_MONTH);
        IN_ONE_THING.put("year", IN_ONE_YEAR);

    }

}
