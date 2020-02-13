import java.util.*;
public class player
{
 int money;
 String name;
 ArrayList<prop> owned;
 
 public player(String name)
 {
  this.name = name; 
  money = 1500;
  owned = new ArrayList<prop>();
 }
 public void buy(prop x)
 {
  owned.add(x);
  money = money - x.getCost();
 }
 public void lose(int x)
 {
  money = money - x; 
 }
 public void gain(int x)
 {
  money += x; 
 }
 public void mortgage(prop x)
 {
  owned.remove(x);
  money += x.getCost();
 }
 public int getMoney()
 {
  return money; 
 }
}