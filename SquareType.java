//Nick Ong
public abstract class SquareType
{
 private String name;
 private String tileType;
 private int owner;
 
 public SquareType(String name, String tileType)
 {
  this.name = name;
  this.tileType = tileType;
  owner = 0;
 }
 
 public String getName()
 {
  return name; 
 }
 public void setName(String name)
 {
  this.name = name;
 }
 public String getTileType()
 {
  return tileType; 
 }
 public void setTileType(String tileType)
 {
  this.tileType = tileType; 
 }
 public int getOwner()
 {
  return owner; 
 }
 public void setOwner(int owner)
 {
  this.owner = owner; 
 }
 
 
}