package hans;
import java.io.*;
public class HW2 {

	public static void main(String[] args) throws Exception {
		//TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Java\\Lab Assignments\\csx-351-hw2-RamanHans-master\\HW2-dictionary.txt"));
		BufferedReader br2=new BufferedReader(new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Java\\Lab Assignments\\csx-351-hw2-RamanHans-master\\HW2-keywords.txt"));
		File f = new File("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Java\\Lab Assignments\\csx-351-hw2-RamanHans-master\\HW2-output-file-16103064.txt");
		f.createNewFile();
        PrintWriter pw=new PrintWriter("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Java\\Lab Assignments\\csx-351-hw2-RamanHans-master\\HW2-output-file-16103064.txt");
        BufferedReader br3=new BufferedReader(new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Java\\Lab Assignments\\csx-351-hw2-RamanHans-master\\HW2-output-file-16103064.txt"));
        BufferedReader br4=new BufferedReader(new FileReader("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Java\\Lab Assignments\\csx-351-hw2-RamanHans-master\\HW2-output-file-16103064.txt"));
    	
        String dictarr[]=new String[16000];
		String keyarr[]=new String[84];
		int i=0;
		int m;
		String str,kw;
		while((str=br.readLine())!=null)
		{
			dictarr[i]=str;
			i++;
		}
		int  j=0;
		while((str=br2.readLine())!=null)
        {
        	keyarr[j]=str;
        	j++;
	
        }
		
		// Sorting both Arrays Using Bubble Sort
		bubbleSort(dictarr,16000);
		bubbleSort(keyarr,84);
		int d,kwnf=0;
		for(m=0;m<84;m++)
		{   
			
			kw=keyarr[m];
			 d=search(dictarr,keyarr,kw);
			if(d==-1)
			{
				String res="Keyword not found: "+kw;
				pw.println(res);
				kwnf++;
			}
		}
		pw.println("\n");
		pw.println("\n");
		pw.println("No. of Keywords not found = "+kwnf);
		String s;
		while((s=br4.readLine())!=null)
		{
			System.out.println(s);
		}
		
			
	     
	    br.close();
		br2.close();
		br3.close();
		pw.close();

	
}
public static void bubbleSort(String arr[],int size)
{
	int i,j,xchanges=0;
	for(i=0;i<size-1;i++)
	{
		for(j=0;j<size-1-i;j++)
		{
			if(arr[j].compareTo(arr[j+1])>0)
			{
				String temp=arr[j];
				arr[j]=arr[j+1] ;
				arr[j+1]=temp;
				xchanges++;
		}
			
	}
		if(xchanges==0)
			break;
}}
public static int search(String dictarr[],String keyarr[],String kw)
{   
	    int k=0;;
	
		while((k<16000 && kw.compareToIgnoreCase(dictarr[k])!=0))
		k++;
		if(k<16000)
			return 1;
		else return -1;
	
}}