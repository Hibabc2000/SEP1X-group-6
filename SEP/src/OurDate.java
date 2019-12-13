public class OurDate
{
  private int day;
  private int month;
  private byte startHour;
  private byte endHour;
  private int year;
  private int week;
  private OurDate startT;
  public OurDate(int day, int month, int year, byte startHour, byte endHour,OurDate startDate)
  {
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
  public OurDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
    startHour = 0;
    endHour = 0;
    week = 0;
  }
  public boolean compare(OurDate date)
  {
    if(year == date.getYear())
    {
      if (month == date.getMonth())
      {
        if (day == date.getDay())
        {
          if (endHour < date.getStartHour())
          {
            return true;
          }
          else if (date.getEndHour() < startHour)
          {
            return true;
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
      else
      {
        return false;
      }
    }
    else{return false;}
  }
  public int getDay()
  {
    return day;
  }

  public byte getEndHour()
  {
    return endHour;
  }

  public byte getStartHour()
  {
    return startHour;
  }

  public void setDay(int day)
  {

  }

  public void setEndHour(byte endHour)
  {
    this.endHour = endHour;
  }

  public void setStartHour(byte startHour)
  {
    this.startHour = startHour;
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
}

