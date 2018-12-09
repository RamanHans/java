package hans;
import java.io.*;


public class HW3  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader (new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Advanced Programming in Java\\Lab Assignments\\csx-351-hw3-RamanHans-master\\HW3-unsorted-keywords.txt"));
        BufferedReader br2 =new BufferedReader (new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Advanced Programming in Java\\Lab Assignments\\csx-351-hw3-RamanHans-master\\HW3-input-code.txt"));
        BufferedReader br1= new BufferedReader (new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Advanced Programming in Java\\Lab Assignments\\csx-351-hw3-RamanHans-master\\HW3-unsorted-keywords.txt"));
        File f= new File("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Advanced Programming in Java\\Lab Assignments\\csx-351-hw3-RamanHans-master\\HW3-output-16103064.txt");
        f.createNewFile();
        PrintWriter pw= new PrintWriter (f);
        String str;
        int i=0;
        while((str=br.readLine())!=null)
        {
        	
        	i++;
        }
        int count=i;
        String keys[]=new String[i];i=0;
        while((str=br1.readLine())!=null)
        {
        	keys[i]=str;
        	i++;
        }
       
        bubblesort(keys,count);
        int j=0,cnt=0;
       while((str=br2.readLine())!=null)
       { 
    	   j++;
    	   int flag=0;
    	   String x="line "+j+": ";
    	   for(int k=0;k<str.length();k++)
    	   hans:{
    		   int z=k;
    		   char w=str.charAt(k);
    		   if(Character.isDigit(w)||Character.isLetter(w)||w=='_')
    		   {
    			   String s="";
    			   while(Character.isDigit(w)||Character.isLetter(w)||w=='_')
    			   {
    				   s+=w;
    				   k++;
    				   if(k<str.length())
    					   w=str.charAt(k);
    					   else w='£';
    			   }
    			   k=k-1;
    			   int low,hig,mid;
  				 low=0;
  				 hig=count-1;
  				 while(low<=hig)
  				 {
  					 mid=(low+hig)/2;
  					 if(s.compareTo(keys[mid])==0)
  					 {
  						flag=1;
  						cnt++;
  						x=x+s+"("+z+") ";
  					    break;
  					 }
  					 else if(s.compareTo(keys[mid])>0)
  				      low=mid+1;
  					 else
  					hig=mid-1;
  				 }
    		   }
				  else
				  {
					  if(w=='/')
					  {
						  k++;
						  w=str.charAt(k);
						  if(w=='/')
						  {
							  break hans;
						  }
						  else
							  k=k-1;
					  }
				  }
				}
			if(flag==1)
			{
				x=x+"\n";
				pw.println(x);
				System.out.println(x);
				
			}
			}
    			   
    		   
    		   
    	   
    	   
	String last="number of keywords found : " + cnt + "\n";
	System.out.print(last);
	pw.println(last);
	br.close();
	br1.close();
	pw.close();
	br2.close();
     
	}
public static void bubblesort(String keys[], int size)
{
	int xchgs=0;
	int k,j;
	for(k=0;k<size-1;k++)
	{
		for(j=0;j<size-1-k;j++)
		{
			if(keys[j].compareTo(keys[j+1])>0)
			{
				String t=keys[j];
				keys[j]=keys[j+1];
				keys[j+1]=t;
				xchgs++;
			}
		}
		if(xchgs==0)
			break;
	}
}


	 
}
