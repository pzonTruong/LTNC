public class MyDate{
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate(MyDate other){
        this(other.day, other.month, other.year);
    }

    // getter
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // setter   
    public void setDay(int day) { this.day = day; }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}