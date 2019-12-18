import java.io.IOException;
import java.io.Serializable;
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
  public int getWeek()
  {
    return week;
  }

  public void setWeek(int week)
  {
    this.week = week;
  }

  private int week;
  private OurDate startT;
  public OurDate(int day, int month, int year, int startHour, int endHour,int startMinute, int endMinute)
  {
    try
    {
      OurDate startDate;
      FileAdapter fileHandler = new FileAdapter(null);
      Object[] objs = fileHandler.temporaryRead("tempTeacher");
      objs = fileHandler.temporaryRead("tempSEDates");
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

    startT = startDate;
    if (year == startDate.getYear())
    {
      if(month == startDate.getMonth())
      {
        int tmp = startDate.getDay() - day;
        week = tmp/7;
      }
      else
      {
        int tmp = (startDate.dayInMonth())-startDate.getDay();
        int x = month;
        while (startDate.getMonth() < x)
        {
          int y0 = 0;
          if(startDate.getMonth() == x-1)
          {
            int x0 = tmp + day + y0;
            week = tmp/7;
          }
          if(startDate.getMonth() < x-1)
          {
            y0 += dayInMonth(x-1);
          }
          x --;
        }
      }
    }
    else if(year>startDate.getYear())
    {
      int x1 = dayInMonth(12) - startDate.getDay();
      if(month == 1)
      {
        week = (x1+day)/7;
      }
      if(month == 2)
      {
        week = (x1+day+dayInMonth(2))/7;
      }

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
  public boolean compare(OurDate date)
  {
    if(year == date.getYear())
    {
      if (month == date.getMonth())
      {
        if (day == date.getDay())
        {
          if(((etMinute <= date.getEtMinute())&&(stMinute <= date.getStMinute()))||((stMinute >= date.getStMinute())))
          {
            return true;
          }
          else if (((etMinute >= date.getStMinute())&&(stMinute >= date.getStMinute()))||((etMinute >= date.getEtMinute())&&(stMinute >= date.getStMinute())))
          {
            return true;
          }
          else {return false;}

        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    else{return false;}
  }

  public void setDay(int day)
  {

  }


  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  public void setYear(int year)
  {
    year = year;
  }

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
  public int dayInMonth()
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )
    {
      return 31;
    }
    else if ( month == 2 && !isLeapYear())
    {
      return 28;
    }
    else if ( month == 2 && isLeapYear() )
    {
      return 29;
    }
    else {return 30;}
  }
  public int dayInMonth(int cmonth)
  {
    if (cmonth == 1 || cmonth == 3 || cmonth == 5 || cmonth == 7 || cmonth == 8 || cmonth == 10 || cmonth == 12 )
    {
      return 31;
    }
    else if ( cmonth == 2 && !isLeapYear())
    {
      return 28;
    }
    else if ( cmonth == 2 && isLeapYear() )
    {
      return 29;
    }
    else {return 30;}
  }
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

  public void setStartHour(int startHour)
  {
    this.startHour = startHour;
  }

  public void setEndHour(int endHour)
  {
    this.endHour = endHour;
  }

  public int geteMinute()
  {
    return eMinute;
  }

  public int getEtMinute()
  {
    return etMinute;
  }

  public int getsMinute()
  {
    return sMinute;
  }

  public int getStMinute()
  {
    return stMinute;
  }

  public void seteMinute(int eMinute)
  {
    this.eMinute = eMinute;
  }

  public void setEtMinute(int etMinute)
  {
    this.etMinute = etMinute;
  }

  public void setsMinute(int sMinute)
  {
    this.sMinute = sMinute;
  }

  public void setStartT(OurDate startT)
  {
    this.startT = startT;
  }

  public void setStMinute(int stMinute)
  {
    this.stMinute = stMinute;
  }

  public int getDay()
  {
    return day;
  }

  public int getEndHour()
  {
    return endHour;
  }

  public int getStartHour()
  {
    return startHour;
  }
  public String toString()
  {
    return year + "/" + month + "/" + day;
  }
}

