// Professor's code. Example and solution of a test question

import java.util.*;
public class ArrayistQuestion
{
  public static void main(String[] args)
  {
     ArrayList<Point> points = new ArrayList<Point>();
     points.add(new Point(12, 5));
     points.add(new Point(2,23));
     points.add(new Point(6,3));
     points.add(new Point(9,2));
     points.add(new Point(12,23));
     System.out.println(points);
     shift(points);
     System.out.println(points);
  }
  //this method shifts all the points with x greater than y to the end of the list
  public static void shift(ArrayList<Point> list)
  {
     int count = list.size();
     for(int i = 0; i < count; i++)
     {
        if(list.get(i).getX() > list.get(i).getY())
        {
           Point p = list.get(i);       // make a copy of the Point object
           list.remove(i);              // removes it from the list
           list.add(p);                 // adds it ot the endof the list
           i--;
           count--;                     // decrement the count by 1 since one element has been removed
        }
     }
  }
}
class Point
{
   private int x;
   private int y;
   public Point(int x, int y)
   {
     this.x = x;
     this.y = y;
   }
   public int getX()
   {
     return x;
   }
   public int getY()
   {
     return y;
   }
   public String toString()
   {
     return "(x = "+ x + " y = " + y+" )";
   }
   }