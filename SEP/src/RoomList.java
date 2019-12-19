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
    RoomList tmp = (RoomList) obj;
    if (rooms.size() != tmp.getAllRooms().size())
    {
      return false;
    }
    for (int x0 = 0; x0 < rooms.size(); x0++)
    {
      if (!rooms.get(x0).equals(tmp.getAllRooms().get(x0)))
      {
        return false;
      }
    }
    return true;
  }

  /**
   * @param room add a new room object to the roomList
   */
  public void addRoom(Room room)
  {
    rooms.add(room);
  }

}
