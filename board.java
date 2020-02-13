//Nick Ong
import java.util.*;
public class board
{
  public static void main(String[] args)
  {
    ArrayList<prop> board = new ArrayList<prop>();
    board.add(new prop("GO", "land", 0, 200));
    board.add(new prop("Mediterranean Ave", "land", 150, 30));
    board.add(new prop("Baltic Ave", "land", 150, 30));
    board.add(new prop("Income Tax", "tax", 0, 200));
    board.add(new prop("Reading Railroad", "land", 150, 30));
    board.add(new prop("Mediterranean Ave", "land", 150, 30));
    board.add(new prop("Chance", "chance", 0, 200));
    board.add(new prop("Vermont Ave", "land", 150, 30));
    board.add(new prop("Connecticut Ave", "land", 150, 30));
    board.add(new prop("Jail/Just Visiting", "land", 0, 0));
    board.add(new prop("St. Charles Place", "land", 150, 30));
    board.add(new prop("Electric Company", "utility", 150, 30));
    board.add(new prop("States Ave", "land", 150, 30));
    board.add(new prop("Pennsylvania Railroad", "land", 150, 30));
    board.add(new prop("St. James Place", "land", 150, 30));
    board.add(new prop("Tennessee Ave", "land", 150, 30));
    board.add(new prop("New York Ave", "land", 150, 30));
    board.add(new prop("Free Parking", "land",  0, 0));
    board.add(new prop("Kentucky Ave", "land", 150, 30));
    board.add(new prop("Chance", "chance", 0, 200));
    board.add(new prop("Indiana Ave", "land", 150, 30));
    board.add(new prop("Illinois Ave", "land", 150, 30));
    board.add(new prop("B & O Railroad", "land", 150, 30));
    board.add(new prop("Atlantic Ave", "land", 150, 30));
    board.add(new prop("Ventnor Ave", "land", 150, 30));
    board.add(new prop("Waterworks", "Utility", 150, 30));
    board.add(new prop("Marvin Gardens", "land", 150, 30));
    board.add(new prop("Go To Jail", "land", 0, 0));
    board.add(new prop("Pacific Ave", "land", 150, 30));
    board.add(new prop("N. Carolina Ave", "land", 150, 30));
    board.add(new prop("Pennsylvania Ave", "land", 150, 30));
    board.add(new prop("Short Line", "land", 150, 30));
    board.add(new prop("Chance", "chance", 0, 200));
    board.add(new prop("Park Place", "land", 150, 30));
    board.add(new prop("Luxury Tax", "tax", 0, 75));
    board.add(new prop("Boardwalk", "land", 150, 30));
    
    player P1 = new player("P1");
    player P2 = new player("P2");
    
    Scanner user = new Scanner(System.in);
    System.out.println("Welcome to Monopoly");
    boolean run1 = true;
    boolean run2 = false;
    boolean game = true;
    
    int position1 = 0;
    int position2 = 0;
    while (game == true)
    {
      while (run1 == true)
      {
        System.out.println("|Free parking| |Kentucky Ave| |Chance| |Indiana Ave| |Illinois Ave| |B&O Railroad| |Atlantic Ave| |Ventnor Ave| |Water Works| |Marvin Gardens| |Go To Jail|");
        System.out.println("|New York Ave|                                                                                                                                 |Pacific Ave|");
        System.out.println("|Tennessee Ave|                                                                                                                                |N. Carolina Ave|");
        System.out.println("|St. James Place|                                                                                                                              |Pennsylvania Ave|");
        System.out.println("|Pennsylvania Railroad|                                            Monopoly                                                                    |Short Line|");
        System.out.println("|Virginia Ave|                                                                                                                                 |Chance|");
        System.out.println("|States Ave|                                                                                                                                   |Park Place|");
        System.out.println("|Electric Company|                                                                                                                             |Luxury Tax|");
        System.out.println("|St. Charles Place|                                                                                                                            |Boardwalk|");
        System.out.println("|Jail/Just Visiting|   |Connecticut Ave|   |Vermont Ave|   |Chance|   |Reading Railroad|   |Income Tax|   |Baltic Ave|   |Mediterranean Ave|   |GO|");  
        
        System.out.println("You are P1 and are at the " + board.get(position1).getName() + " tile. You have $" +P1.getMoney());
        
        int dice = (int)(Math.random() * 11 + 2);
        System.out.println("You rolled a " + dice);
        position1 = dice + position1;
        if (position1 >35)
        {
          P1.gain(200);
          System.out.println("You pass the GO tile.");
        }
        if (position1 > 35)
        {
          position1 = position1 - 36; 
        }
        prop square = board.get(position1);
        System.out.println("You landed on " + square.getName());
        
        if (square.getTileType().equals("chance"))
        {
          int chance = (int)(Math.random() * 2);
          if (chance == 0)
          {
            System.out.println("You gain $200");
            P1.gain(200); 
          }
          else
          {
            System.out.println("You lose $200");
            P1.lose(200); 
          }
          run1= false;
          run2 = true;
        }
        
        else if (square.getTileType().equals("tax"))
        {
          System.out.println("You are taxed " + square.getValue());
          run1 = false;
          run2 = true;
        }
        else if (square.getName().equals("Jail/Just Visiting") || square.getName().equals("Free Parking"))
        {
          System.out.println("You are visiting " + square.getName());
          run1 = false;
          run2 = true;
        }
        else if (square.getName().equals("Go to Jail"))
        {
          position1 = 9;
          System.out.println("You are sent to jail.");
          run1 = false;
          run2 = true;
        }
        else 
        {
          for (prop x : P2.owned)
          {
            if (square.getName().equals(x.getName()))
            {
              P1.lose(square.getValue());
              P2.gain(square.getValue());
              System.out.println("You landed on P2's property and pay " + square.getValue());
              run1 = false; 
              run2 = true;
            }
          }
          for (prop y : P1.owned)
          {
            if (square.getName().equals(y.getName()))
            {
              System.out.println("This is yours already.");
              run1 = false; 
              run2 = true;
            }
          }
        }
        if (run1 != false)
        {
          System.out.println("Would you like to buy " + square.getName() + " (Y/N)?");
          String ans = user.nextLine();
          if (ans.equals("Y"))
          {
            P1.owned.add(square);
            P1.lose(square.getCost()); 
          }
          else
          {
            run1 =  false;
            run2 = true;
          } 
        } 
        run1 = false;
        run2 = true;
      }
      
      
      
      while (run2 == true)
      {
        System.out.println("|Free parking| |Kentucky Ave| |Chance| |Indiana Ave| |Illinois Ave| |B&O Railroad| |Atlantic Ave| |Ventnor Ave| |Water Works| |Marvin Gardens| |Go To Jail|");
        System.out.println("|New York Ave|                                                                                                                                 |Pacific Ave|");
        System.out.println("|Tennessee Ave|                                                                                                                                |N. Carolina Ave|");
        System.out.println("|St. James Place|                                                                                                                              |Pennsylvania Ave|");
        System.out.println("|Pennsylvania Railroad|                                            Monopoly                                                                    |Short Line|");
        System.out.println("|Virginia Ave|                                                                                                                                 |Chance|");
        System.out.println("|States Ave|                                                                                                                                   |Park Place|");
        System.out.println("|Electric Company|                                                                                                                             |Luxury Tax|");
        System.out.println("|St. Charles Place|                                                                                                                            |Boardwalk|");
        System.out.println("|Jail/Just Visiting|   |Connecticut Ave|   |Vermont Ave|   |Chance|   |Reading Railroad|   |Income Tax|   |Baltic Ave|   |Mediterranean Ave|   |GO|");  
        
        System.out.println("You are P2 and are at the " + board.get(position2).getName() + " tile. You have $" +P2.getMoney());
        
        int dice = (int)(Math.random() * 11 + 2);
        System.out.println("You rolled a " + dice);
        position2 = dice + position2;
        if (position2 >35)
        {
          P2.gain(200);
          System.out.println("You pass the GO tile.");
        }
        if (position2 > 35)
        {
          position2 = position2 - 36; 
        }
        prop square = board.get(position2);
        System.out.println("You landed on " + square.getName());
        
        if (square.getTileType().equals("chance"))
        {
          int chance = (int)(Math.random() * 2);
          if (chance == 0)
          {
            System.out.println("You gain $200");
            P2.gain(200); 
          }
          else
          {
            System.out.println("You lose $200");
            P2.lose(200); 
          }
          run2 = false;
          run1 = true;
        }
        
        else if (square.getTileType().equals("tax"))
        {
          System.out.println("You are taxed " + square.getValue());
          run2 = false;
          run1 = true;
        }
        else if (square.getName().equals("Jail/Just Visiting") || square.getName().equals("Free Parking"))
        {
          System.out.println("You are visiting " + square.getName());
          run2 = false;
          run1 = true;
        }
        else if (square.getName().equals("Go to Jail"))
        {
          position2 = 9;
          System.out.println("You are sent to jail.");
          run2 = false;
          run1 = true;
        }
        else 
        {
          for (prop x : P1.owned)
          {
            if (square.getName().equals(x.getName()))
            {
              P2.lose(square.getValue());
              P1.gain(square.getValue());
              System.out.println("You landed on P1's property and pay " + square.getValue());
              run2 = false; 
              run1 = true;
            }
          }
          for (prop y : P2.owned)
          {
            if (square.getName().equals(y.getName()))
            {
              System.out.println("This is yours already.");
              run2 = false; 
              run1 = true;
            }
          }
        }
        if (run2 != false)
        {
          System.out.println("Would you like to buy " + square.getName() + " (Y/N)?");
          String ans = user.nextLine();
          if (ans.equals("Y"))
          {
            P2.owned.add(square);
            P2.lose(square.getCost()); 
          }
          else
          {
            run2 =  false;
            run1 = true;
          } 
        } 
        run2 = false;
        run1 = true;
      }
    }
  }
}