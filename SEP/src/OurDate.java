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
/*
import java.util.GregorianCalendar;
public class MyDate
{
  private int year;
  private int month;
  private int day;
  private String sDate;
  public MyDate()
  {
    GregorianCalendar currentDate1 = new GregorianCalendar();
    year =currentDate1.get(GregorianCalendar.YEAR);
    month = currentDate1.get(GregorianCalendar.MONTH)+1;
    day =currentDate1.get(GregorianCalendar.DATE);
  }
  public static void today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH)+1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    new MyDate(currentDay,currentMonth,currentYear);
  }

  public MyDate(int day, int month, int year)
  {
    this.year = year; this.month = month; this.day=day;
  }
  public MyDate(int year)
  {
    this.year = year; month = 1; day = 1;
  }
  public void setYear( int y)
  {
    year = y;
  }
  public void setMonth ( int m)
  {
    month = m;
  }
  public void setDay ( int d)
  {
    day = d;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }
  public String getDate()
  {
    sDate = day + "/" + month + "/" + year;
    return sDate;
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
  public String getAstrologicalSign()
  {
    String as = null;
    if ((month == 3 && day >= 21)||(month == 4 && day <= 19 ) )  as = "Aries";
    else if ((month == 4&& day>= 20)||(month == 5 && day <= 20 )) as = "Taurus";
    else if ((month == 5 && day>= 21)||(month == 6 && day <= 20 )) as = "Geminie";
    else if ((month ==6  && day>= 21 )||(month == 7  && day <= 22 )) as = "Cancer";
    else if ((month == 7 && day>= 23)||(month == 8 && day <= 22  )) as = "Leo";
    else if ((month == 8 && day>= 23)||(month == 9 && day <= 22 )) as = "Virgo";
    else if ((month == 9 && day>= 23 )||(month == 10 && day <= 22 )) as = "Libra";
    else if ((month == 10 && day>= 23 )||(month == 11  && day <=  21 )) as = "Scorpio";
    else if ((month == 11 && day>= 22)||(month == 12 && day <= 21 )) as = "Sagittarius";
    else if ((month == 12 && day>= 22 )||(month == 1  && day <= 19 )) as = "Capricorn";
    else if ((month ==1 && day>=20 )||(month == 2 && day <= 18  )) as = "Aquarius";
    else if ((month ==2 && day>=19 )||(month == 3 && day <= 20 )) as = "Pisces";
    else as =" I fucked up";
    return as;

  }
  public String dayOfWeek()
  {
    int q; int k;int j;int h; double hd;int m;int y;
    q = day;
    if ( month <= 3) {m = month; y = year;}
    else {m = month + 12; y = year -1; }
    k = y%100;
    j = y/100;
    h = (q+((13*(m+1))/5)+k+(k/4)+(j/4)+(5*j))%7;
    switch(h){
      case 0:
        return "Saturday";

      case 1:
        return "Sunday";

      case 2 :
        return "Monday";

      case 3 :
        return "Tuesday ";

      case 4:
        return "Wednesday";

      case 5:
        return "Thursday";

      case 6 :
        return "Friday";
      default: return "ERROR";
    }

  }
  public String getMonthName()
  {
    switch (month)
    {
      case 1:
        return "January";
      case 2:
        return"February";
      case 3 :
        return "March";
      case 4:
        return"April";
      case 5 :
        return "May";
      case 6 :
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9 :
        return "September";
      case 10:
        return "October";
      case 11 :
        return "November";
      case 12:
        return "December";
      default:
        return "Wrong month biatch";

    }
  }
  public void nextDay()
  {
    if (day < (dayInMonth() ) ){day ++;}
    else
    {
      if(month < 12){day = 1; month ++;}
      else if (month == 12) {day =1; month = 1; year ++;}
    }
  }
  public void nextDays(int ann)
  {
    int i = 0;
    while (i < ann)
    {
      if (day < (dayInMonth() ) ){day ++;}
      else
      {
        day = 1; month ++;
        if (month < 12) {month++;}
        else {month = 1; year++; }
      }
      i++;
    }
  }
  public boolean equals( Object obj)
  {
    if (!(obj instanceof MyDate)){return false;}
    MyDate temp = (MyDate)obj;
    if (temp.getYear() == year && temp.getMonth() == month && temp.getDay()== day){return true;}
    else{return false;}
  }
  public MyDate copy()
  {
    return new MyDate(day,month,year);
  }
  public MyDate(MyDate ddd)
  {
    year = ddd.getYear(); month = ddd.getMonth(); day = ddd.getDay();
  }
  public boolean isBefore(MyDate date3)
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


 */
