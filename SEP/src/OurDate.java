public class OurDate
{
  private byte day;
  private byte startHour;
  private byte endHour;
  private byte week;
  public OurDate(byte day,byte startHour,byte endHour, byte week)
  {
    this.day=day;
    this.endHour=endHour;
    this.startHour=startHour;
    this.week=week;
  }
  public boolean compare(OurDate date)
  {
    if (day == date.getDay())
    {
      if(endHour < date.getStartHour())
      {
        return true;
      }
      else if (date.getEndHour() < startHour)
      {
        return true;
      }
      else{return false;}
    }
    else{return false;}
  }

  public byte getDay()
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

  public byte getWeek()
  {
    return week;
  }

  public void setDay(byte day)
  {
    this.day = day;
  }

  public void setEndHour(byte endHour)
  {
    this.endHour = endHour;
  }

  public void setStartHour(byte startHour)
  {
    this.startHour = startHour;
  }

  public void setWeek(byte week)
  {
    this.week = week;
  }

}
