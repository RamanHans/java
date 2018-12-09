package javaLab;

import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class HW9_Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        ListInterface<Integer> l= new AList<Integer>(max);
        for(int i=2;i<=max;i++)
        	l.add(i);
        System.out.println("the list of the numbers is "+l);
        int g;
        ListInterface<Integer> primes= new AList<Integer>(max);
        ListInterface<Integer> composites= new AList<Integer>(max);
        while(l.getLength()>1)
        {
        	g=l.getEntry(1);
        	primes.add(g);
        	l.remove(1);
        	getComposites(l,composites,g);
        	  System.out.println("the list of the numbers is "+l);
        	  System.out.println("the list of the prime numbers is "+primes);
        	  System.out.println("the list of the composites numbers is "+composites);
                	
        }
        
    }
   
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
        // COMPLETE THIS METHOD
    	int i,j;
    	i=1;
    	for(i=1;i<=candidates.getLength();i++)
    	{
    		j=candidates.getEntry(i);
    		if(j%prime==0)
    		{
    			candidates.remove(i);
    			i--;
    			composites.add(j);
    		}
    	}
    	
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
