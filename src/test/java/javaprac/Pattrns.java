package javaprac;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Pattrns {

    //@Test
    public void pattern1(){
        int rows = 5;
        System.out.println("## Printing the pattern ##");
        // Print i number of stars
        for (int i=1; i<=rows; i++)
        {
            for (int j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        //output
        /**
         **
         ***
         ****
         *******/
    }

   // @Test
    public void pattern2(){
        int rows = 5;
        System.out.println("## Printing the pattern ##");
        for (int i=1; i<=rows; i++)
        {
            // Print space in decreasing order
            for (int j=rows; j>i; j--)
            {
                System.out.print(" ");
            }
            // Print star in increasing order
            for (int k=1; k<=i; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

       /* *
   **
  ***
 ****
******/
    }

    //@Test
    public void pattern3(){
        int rows = 5;
        System.out.println("## Printing the pattern ##");
        // Print i number of stars
        for (int i=1; i<=rows; i++)
        {
            for (int j=rows; j>=i; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //@Test
    public void pattern4(){
        int rows = 5;
        System.out.println("## Printing the pattern ##");
        for (int i=1; i<=rows; i++)
        {
            // Print space in increasing order
            for (int j=1; j<i; j++)
            {
                System.out.print(" ");
            }
            // Print star in decreasing order
            for (int k=rows; k>=i; k--)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    @Test
    public void pattern5(){
        int rows = 5;
        System.out.println("## Printing the pattern ##");
        for (int i=1; i<=rows; i++)
        {
            // Print space in decreasing order
            for (int j=rows; j>i; j--)
            {
                System.out.print(" ");
            }
            // Print star in increasing order
            for (int k=1; k<=(i * 2) -1; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
/*## Printing the pattern ##
    *
   ***
  *****
 *******
**********/

    }
}


