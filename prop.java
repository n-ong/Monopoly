public class prop extends SquareType
{
  private int cost;
  private int value;
  public prop(String name, String tileType, int cost, int value)
  {
   super(name, tileType); 
   this.cost = cost;
   this.value = value;
  }
  public int getCost()
  {
   return cost; 
  }
  public void setCost(int x)
  {
   cost = x;
  }
  public int getValue()
  {
   return value; 
  }
  public void setValue(int x)
  {
   value = x; 
  }
}