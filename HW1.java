package hans;
import java.io.*;
public class HW1 {

	public static void main(String[] args) throws Exception {
		System.getProperty("line.separator");
		   // TODO Auto-generated method stub
		  //Reading File HW1-data 
File hw1= new File("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Advanced Programming in Java\\Lab Assignments\\Assn 1\\HW1-data.txt");
BufferedReader br=new BufferedReader(new FileReader(hw1));
String str;
PrintWriter pw=new PrintWriter("C:\\Users\\Cheena Hans\\Documents\\5th Sem\\Advanced Programming in Java\\Lab Assignments\\Assn 1\\HW1-output-16103064.txt");
          // Writing Contents of file HW1-data to HW1-output-16103064
  init_file(pw);
         //Printing Contents of StudentReportFile
String arr[]=new String[15];
int gradearr[]=new int[5];
for(int i=0;i<5;i++)
{
	gradearr[i]=0;
}
int max=0;
while((str=br.readLine())!=null)
{   
	strread(str,arr);
    String stu_id=arr[0];
    int lab=Integer.valueOf(arr[1]);
    int assn_mark=0;
    for(int i=0;i<10;i++)
    {
    	assn_mark+=Integer.valueOf(arr[2+i]);
    }
    int mi=Integer.valueOf(arr[12]);
    int fin=Integer.valueOf(arr[13]);
    int cl=Integer.valueOf(arr[14]);
    int tot=lab+assn_mark+mi+fin+cl;
    if(tot>max)
    	{
    	max=tot;
    	}
    	
    double percent=1.0*(float)tot/420.0*100;
	int per=(int)percent;
	if(percent-per>=0.5) {
		per+=1;
	}
	char grade=cal(per);
	gradearr[grade-'A']++;
	String result=stu_id+"  "+toStr(lab,2)+"  "+assignments(arr)+" "+toStr(assn_mark,3)+"  "+toStr(mi,2)+"  "+toStr(fin,3)+"  "+toStr(cl,2)+"  "+toStr(tot,3)+"  "+toStr(per,3)+"   "+grade;
	pw.println(result);	
	System.out.println(result);
}
pw.println("\n");
System.out.println("\n");
String last=FinalLines(gradearr,max);
pw.println(last);
System.out.println(last);
br.close();
pw.close();

	}
public static void init_file(PrintWriter pw) 
			
			{
				String first="Stdnt Id  Ex  ------- Assignments ---------  Tot  Mi  Fin  CL  Pts  Pct  Gr";
				String second="--------  --  -----------------------------  ---  --  ---  --  ---  ---  --";
				pw.println(first);
				pw.println(second);
				System.out.println(first);
				System.out.println(second);
			}

public static void strread(String str,String arr[])
{
	int i=0,j=0;
	boolean status=false;
	arr[j]="";
	while(i<str.length()) {
		if(str.charAt(i)==' ') {
			if(status==false) {
				status=true;
				j++;
				arr[j]="";
			}
		}
		else {
			status=false;
			arr[j]=arr[j]+str.charAt(i);
		}
		i++;	
	}
}

public static String assignments(String arr[]) {
	String res="";
	for(int i=0;i<10;i++) {
		if(arr[2+i].length()==1)
			res=res+" ";
		res=res+arr[2+i]+" ";
	}
	return res;
}
public static String toStr(int num,int n) {
	String number=Integer.toString(num);
	String res="";
	if(number.length()<n) {
		int diff=n-number.length();
		for(int i=0;i<diff;i++)
			res=res+" ";
	}
	res=res+number;
	return res;
}
public static String FinalLines(int gradearr[],int max) {
	String res="";
	for(int i=0;i<5;i++) {
		String line="Number Of "+(char)('A'+i)+"\'s= "+gradearr[i]+"\r\n";
		res=res+line;
	}
	String maxm="Maximum Points= "+max;
	res=res+maxm;
	return res;
}



public static char cal(int per)
{
	if(per>=90)
		return 'A';
	if(per>=78)
		return 'B';
	if(per>=62)
			return 'C';
	if(per>=46)
		return 'D';
	return 'E';
}}