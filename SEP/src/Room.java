public class Room
{
  /**
   *@author Ali Bahrani, 294418
   *@version 1.0.0.3
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
    projector = 5;
    numberOfSeats = -1;
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
     * @return projector state
     * return the projector state of the room, 0 for non, 1 for VGA, 2 for hdmi and 3 for both, 5 for null
     */
    return projector;
  }

  public int getNumberOfSeats()
  {
    /**
     * @return Number of seats in the class
     * returns the number of the seats in the class, -1 is not defined
     */
    return numberOfSeats;
  }

  public String getRoomNumber()
  {
    /**
     * @return the room number
     * returns the room number
     */
    return roomNumber;
  }

  public void setNumberOfSeats(int numberOfSeats)
  {
    /**
     * @param number of seats
     * sets the number of seats in the room
     */
    this.numberOfSeats = numberOfSeats;
  }

  public void setProjector(byte projector)
  {
    /**
     * @param state of projector
     *  sets the state of projector for the room, 0 for non, 1 for VGA, 2 for hdmi and 3 for both
     */
    this.projector = projector;
  }

  public void setRoomNumber(String roomNumber)
  {
    /**
     * @param number o the room
     * sets the romm number
     */
    this.roomNumber = roomNumber;
  }
  public boolean equals(Object object)
  {
    /**
     * @param Objct of room type
     * checks if the rooms are the same
     */
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

  //Don't use this method
  public void copy()
  {
    /**
     * @return a Room object identical to this one
     * copies the Room object
     */
    Room tmp = new Room();
    tmp.setRoomNumber(roomNumber);
    tmp.setNumberOfSeats(numberOfSeats);
    tmp.setProjector(projector);
  }

}

