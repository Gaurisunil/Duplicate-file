import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.stream.Stream;

  public class FileCheckSum
  {
    public static void main(String[] args)throws Exception
	{
	
	
	
	
	
	   Scanner s=new Scanner(System.in);
	    System.out.println("enter folder name");
		  String str=s.nextLine();
		  checksum(str);
		   ArrayP(str,i);
		   }
		   
		   static String arr[]=new String[6];
		    static String brr[]=new String[6];
			      static int i=0;
				  
				  public static void checksum(String filepath)throws Exception
				  {
				   MessageDigest md = MessageDigest.getInstance("MD5");
				   try(Stream <Path> paths=Files.walk(Paths.get(filepath)))
               {
              paths.forEach(filePath->
			  {
			  if(Files.isRegularFile(filePath))
			  {
			      File file=new File(filePath.toString());
				   String ffile=filePath.getFileName().toString();
				    String str=file.getAbsolutePath();
					 Check(str,md,ffile);
					 }
					 });
					 }
					 catch(Exception e)
					 {
					    System.out.println(e);
						}
						}
						public static void Check(String file,MessageDigest md,String ffile)
						{
						 try(InputStream fis=new FileInputStream(file))
						 {
						   byte[]buffer=new byte[1024];
						   int nread;
						    while((nread=fis.read(buffer))!=-1)
							{
							         md.update(buffer,0,nread);
									 }
									 
									  StringBuilder  result=new StringBuilder();
									   for(byte b:md.digest())
									   {
									       result.append(String.format("%02X",b));
										   }
										      String str=result.toString();
											  
											  arr[i]=str;
											  brr[i]=ffile;
											  i++;
											     System.out.println(ffile+""+str);
												 }
												    catch(IOException e)
													{
													   System.out.println(e);
													   }
													   }
							public static void ArrayP(String file1,int iCnt)
               {
						     int k=0;
							 String F=new String();
							      for(int j=0;j<=iCnt;j++)
								  {
								  F=arr[j];
								  for(int i=j+1;i<=iCnt;i++)
								  {
								       if(F.equals(arr[i]))
									   {
									          k++;
									    File file=new File(file1+"\\"+brr[j]);
                                                                                 

										 file.delete();
                                                                                    }
										 
										 }
										 }
										   System.out.println("There are total" + k + "Duplicate file present.");
										   }
										   }