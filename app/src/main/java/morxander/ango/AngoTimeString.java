package morxander.ango;

/**
 * Created by morxander on 12/6/16.
 */

public class AngoTimeString {

    private static String now = "Just Now";
    private String minute = "minute";
    private String minutes = "minutes";
    private String ago = "ago";
    private String one_minute = "1 " + minute + " " + ago;

    private static AngoTimeString angoTimeString;

    private AngoTimeString() {
    }

    public static AngoTimeString getInstance() {
        if(angoTimeString == null){
            angoTimeString = new AngoTimeString();
        }
        return angoTimeString;
    }

    public String getNow() {
        return now;
    }

    public String getMinute() {
        return minute;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getAgo() {
        return ago;
    }

    public String getOne_minute() {
        return one_minute;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public void setAgo(String ago) {
        this.ago = ago;
    }

    public void setOne_minute(String one_minute) {
        this.one_minute = one_minute;
    }
}
