/**
   Author: Alina Rozenbaum	
   Date: 4/17/2012	
   Program Name: Insertion Sort
   Course: CS1043
   Lab Section: 4
   Assignment Lab Number: 13
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ArrayListLab13
{
   public static void main( String [] args )
   {
        if ( args.length != 1 )
        {
           System.err.printf( "USAGE: java %s file_name\n",
                (new ArrayListLab13()).getClass().getName() );
           System.exit(1);
        }

        // 1. Instantiate an ArrayList to hold the wrapper class used for
        //    integers.
        
        ArrayList <Integer> list = new ArrayList<Integer>();
        

        try
        {  // 2. Open the file-name stored in args[0].
        	
        	File file = new File (args[0]);

           // 3. Instatniate an object with the Scanner class. This will be
           //    used to extract the values from the input file.
        	
        	Scanner tokens = new Scanner (file);

           // 4. Read the first data value
        	
        	int firstData = tokens.nextInt();

           // 5. "add" (insert) the first data value into the ArrayList.
        	
        	list.add(firstData);

           // 6. Write a nested loop to read data and insert the remaining
           //    data values into the ArrayList in ascending order:
           //    a. Outer while-loop determine if there is another data value
           //       in the file. Use the Scanner-class hasNext() method.
              while(tokens.hasNext())
              {
           //    b. Initialize an index counter to zero.
            	  
            	  int indxCount = 0;

           //    c. Read the next data value and store it in a variable.
            	  
            	  int nextVal = tokens.nextInt();
 

           //    d. The inner while-loop should check for the end of the
           //       ArrayList with your index AND use the compareTo method to
           //       determine the correct position for the current data value.
           //       Do not use ==  The loop body should advance the counter.

                 while ( indxCount < list.size() && list.get(indxCount).compareTo(nextVal) < 0  )
                 {
				// e. advance the index counter.
                	 
                	 indxCount++;
                	 System.out.print(indxCount +"indx<< \n");
                	 
                 }//end inner while

           //    f. Insert the current data item into your vector.
                 
                 list.add(indxCount, nextVal);

              }//end outer while

           // 7. close the data file
              
              tokens.close();
        }

        catch ( IOException err )
        {
           System.err.printf( "File error: %s\n", "err" );
           System.exit(2);
        } // end IOException handler
        
        catch (IndexOutOfBoundsException e)
        {
        	System.err.printf("Out of bounds: %s\n", "e");
        	System.exit(3);
        }

        // 8. Display the ArrayList contents using an enhanced-for loop.

        for (Integer value : list)
        {
        	System.out.print(value+", ");
        }


   } // end main

} // end ArrayListLab13 class

