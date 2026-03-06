public class MyDate{
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate other){
        this.year = other.year;
        this.month = other.month;
        this.day = other.day;
    }

    // setter
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    // getter
    public void setDay(int day) { this.day = day; }
    public void setMonth(int month) { this.month = month; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}