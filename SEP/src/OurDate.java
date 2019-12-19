import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.GregorianCalendar;
public class OurDate implements Serializable
{
  private int day;
  private int month;
  private int startHour;
  private int endHour;
  private int year;
  private int sMinute;
  private int eMinute;
  private int stMinute;
  private int etMinute;
  private int week;
  private OurDate startT;

  /**
   * Gets the week number of this object
   * @return the number of the week
   */
  public int getWeek()
  {
    return week;
  }

  /**
   * This method creates a new date with the given parameters.
   * @param day - the day of the new date
   * @param month - the month of the new date
   * @param year - the year of the new date
   * @param startHour - the starting hour of the new date
   * @param endHour - the ending hour of the new date
   * @param startMinute - the starting minute of the new date
   * @param endMinute - the ending minute of the new date
   */
  public OurDate(int day, int month, int year, int startHour, int endHour,int startMinute, int endMinute)
  {
    try
    {
      OurDate startDate;
      FileAdapter fileHandler = new FileAdapter(null);
      Object[] objs = fileHandler.temporaryRead("tempSEDates");
      if (objs.length != 0)
      {
        startDate = (OurDate) objs[0];
      }
      else
      {
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentDay = currentDate.get(GregorianCalendar.DATE);
        int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
        int currentYear = currentDate.get(GregorianCalendar.YEAR);
        startDate = new OurDate(currentDay, currentMonth, currentYear);
      }

    sMinute = startMinute;
    eMinute = endMinute;
    stMinute = (startHour*60)+sMinute;
    etMinute = (endMinute*60)+eMinute;
    this.day = day;
    this.month = month;
    this.year = year;
    this.startHour = startHour;
    this.endHour = endHour;

      LocalDate localDate = LocalDate.of(year,month,day);
      LocalDate localDate2 = LocalDate.of(startDate.getYear(),startDate.getMonth(),startDate.getDay());

    startT = startDate;
    if (year == startDate.getYear())
    {
      int x9 = localDate2.getDayOfYear()-localDate.getDayOfYear();
      week = x9/7;
    }
    else if(year>startDate.getYear())
    {
      int x2;
      if(startDate.isLeapYear())
      {
        x2 = 366;
      }
      else
      {
        x2 = 365;
      }
      int x5 = (x2 - localDate2.getDayOfYear()) + localDate.getDayOfYear();
      week = x5/7;
    }
    }
    catch (IOException e)
    {
      System.exit(2);
    }
    catch (ClassNotFoundException e)
    {
      System.exit(3);
    }
  }

  /**
   * This method creates a new date with the given parameters.
   * @param day - the day of the new date
   * @param month - the month of the new date
   * @param year - the year of the new date
   */
  public OurDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    startHour = 0;
    endHour = 0;
    week = 0;
    stMinute = 0;
    etMinute = 0;
    sMinute = 0;
    eMinute = 0;
  }

  /**
   * This method is part of the conflict detection, with checking for overlapping times and dates.
   * @param date - the date to compare
   * @return - whether there is overlap in the two dates
   */
  public boolean compare(OurDate date)
  {
    if(year == date.getYear())
    {

      if (month == date.getMonth())
      {
        if (day == date.getDay())
        {
          if ((date.getStMinute() >= etMinute)||(stMinute >= date.etMinute))
          {
            return false;
          }
          else
          {
            return true;
          }
        }
        else {
          return false; }
      }
      else {
      return false; }
    }
    else{
    return false;}
  }

  /**
   * Returns this date's year.
   * @return The year of this date.
   */
  public int getYear()
  {
    return year;
  }

  /**
   * Returns this date's month.
   * @return The month of this date.
   */
  public int getMonth()
  {
    return month;
  }

  /**
   * Returns whether this year is a leap year.
   * @return true if the date's year is a leap year
   */
  public boolean isLeapYear()
  {
    boolean p;
    int z = year%100;
    int h = year%400;

    int x = year % 4;
    if (x == 0 && z!=0 || h==0 )
    {
      p = true;
    }
    else {p = false;}
    return p;
  }

  /**
   * Returns whether this date is before another date
   * @param date3 - the date to compare to
   * @return true if this date is before date3
   */
  public boolean isBefore(OurDate date3)
  {
    if (year < date3.getYear()){return true;}
    else if ( year > date3.getYear()){return false;}
    else {
      if (month < date3.getMonth()){return true;}
      else if (month> date3.getMonth()){return false;}
      else {
        if (day < date3.getDay()){return true;}
        else if(day > date3.getDay()){return false;}
        else {return false;}
      }
    }
  }

  /**
   * Returns this date's ending minute.
   * @return The ending minute of this date.
   */
  public int geteMinute()
  {
    return eMinute;
  }

  /**
   * Returns this date's starting minute.
   * @return The starting minute of this date.
   */
  public int getsMinute()
  {
    return sMinute;
  }

  /**
   * Returns this date's starting time in minutes.
   * @return The starting time in minutes of this date.
   */
  public int getStMinute()
  {
    return stMinute;
  }

  /**
   * Returns this date's day.
   * @return The day of this date.
   */
  public int getDay()
  {
    return day;
  }

  /**
   * Returns this date's ending hour.
   * @return The ending hour of this date.
   */
  public int getEndHour()
  {
    return endHour;
  }

  /**
   * Returns this date's starting hour.
   * @return The starting hour of this date.
   */
  public int getStartHour()
  {
    return startHour;
  }

  /**
   * Returns a String representation of this object.
   * @return A String representation of this object.
   */
  public String toString()
  {
    return year + "/" + month + "/" + day;
  }
}

