import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable
{
  /**
   * @author Ali Bahrani, 294418
   * @version 1.0.0.2
   * this class contains the rooms
   */

  private static ArrayList<Room> rooms;
  public RoomList()
  {
    /**
     * no argument constructor
     */
    rooms = new ArrayList<Room>();
  }
  /**
   * @return an array list containing all of the rooms
   * returns all of the rooms in an array list
   */
  public ArrayList getAllRooms()
  {
    ArrayList<Room> tmp = new ArrayList<Room>();
    for (int x0 = 0; x0 < rooms.size(); x0++)
    {
      tmp.add(rooms.get(x0));
    }
    return tmp;
  }
  /**
   * @return rooms with the selected projector type
   * @param projector type , 0 for non, 1 for VGA, 2 for hdmi and 3 for both
   * return an arraylist containing all the rooms with the selected projector type
   */
  public ArrayList getAllRoomsWithProjector(byte projector)
  {
    ArrayList<Room> tmp = new ArrayList<Room>();
    for( int x0 = 0; x0 < rooms.size(); x0 ++)
    {
      if(rooms.get(x0).getProjector()== projector)
      {
        tmp.add(rooms.get(x0));
      }
    }
    return tmp;
  }
  /**
   * @param minNum number of seats desired
   * @return an array list containing all the rooms with equal or higher number of seats
   * return all the rooms tha have the desired or higher seat count
   */
  public ArrayList getAllRoomsWithSeats(int minNum)
  {
    ArrayList<Room> tmp = new ArrayList<Room>();
    for(int x0 = 0; x0 < rooms.size();x0 ++)
    {
      if(minNum <= rooms.get(x0).getNumberOfSeats())
      {
        tmp.add(rooms.get(x0));
      }
    }
    return tmp;
  }
  // use the following methods with.....  just don't use them, ok?
  /**
   * @param obj a roomlist object
   * @return a boolean with the value of the two roomlist object equality
   * compares the roomlist to another
   */
  public boolean equals(Object obj)
  {
    if (!(obj instanceof RoomList))
    {
      return false;
    }
    RoomList tmp =(RoomList)obj;
    if(rooms.size() != tmp.getAllRooms().size())
    {
      return false;
    }
    for (int x0 = 0; x0 < rooms.size(); x0 ++)
    {
      if(!rooms.get(x0).equals(tmp.getAllRooms().get(x0)))
      {
        return false;
      }
    }
    return true;
  }
  /**
   * @return a copy of roomlist
   * return a copy of the roomlist object
   */
  public RoomList copy()
  {
    RoomList tmp = new RoomList();
    for(int x0 = 0; x0 < rooms.size(); x0 ++)
    {
      tmp.addRoom(rooms.get(x0));
    }
    return tmp;
  }
  //this is a dark territory, enter with caution
  public void addRoom(Room room)
  {
    rooms.add(room);
  }

}
