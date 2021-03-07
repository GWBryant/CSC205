public class Person
{
  private String name;
  private int    id;
  private static int personCount = 0;

  // constructor
  public Person(String pname)
  {
    name = pname;
    personCount++;
    id = 100 + personCount;
  }
  public Person()
  {
    this("N/A");
    id = -1;
  }

  public String  toString()
  {
    return "name: " + name + "  id: " + id 
      + "  (Person count: " + personCount + ")";
  }

  //get name method
  public String getName()
  {
    return name;
  }

  //reset method
  public void reset(String nName, int nId)
  {
    name = nName;  
    id = nId;
  }
  
  //get id method
  public int getId()
  {
    return id;
  }

  // static/class method
  public static int getCount()
  {
    return personCount;
  }
  
}
