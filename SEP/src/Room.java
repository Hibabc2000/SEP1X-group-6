public class Room
{
  /**
   *@author Ali Bahrani, 294418
   *@version 1.0.0
   *this class is responsible for managing room data
   */
  private int numberOfSeats;
  private String roomNumber;
  private byte projector;
  public Room()
  {
    /**
     * no argument constructor
     */
    projector = null;
    numberOfSeats = null;
    roomNumber = null;
  }
  public Room(String roomNumber,int numberOfSeats, byte projector)
  {
    /**
     * a three argument constructor for all fields
     */
    this.roomNumber=roomNumber;
    this.projector= projector;
    this.numberOfSeats=numberOfSeats;
  }
  public byte getProjector()
  {
    /**
     * @return projector state, 0 for non, 1 for VGA, 2 for hdmi and 3 for both
     *
     */
    return projector;
  }

  public int getNumberOfSeats()
  {
    return numberOfSeats;
  }

  public String getRoomNumber()
  {
    return roomNumber;
  }

  public void setNumberOfSeats(int numberOfSeats)
  {
    this.numberOfSeats = numberOfSeats;
  }

  public void setProjector(byte projector)
  {
    this.projector = projector;
  }

  public void setRoomNumber(String roomNumber)
  {
    this.roomNumber = roomNumber;
  }
  public boolean equals(Object object)
  {
    if(!(object instanceof Room))
    {
      return false;
    }
    Room tmp = (Room)object;
    if ((numberOfSeats == tmp.getNumberOfSeats() )&&(roomNumber.equalsIgnoreCase(tmp.roomNumber))&&(projector == tmp.getProjector()))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public void copyDontUse()
  {
    Room tmp = new Room();
    tmp.setRoomNumber(roomNumber);
    tmp.setNumberOfSeats(numberOfSeats);
    tmp.setProjector(projector);
  }
}