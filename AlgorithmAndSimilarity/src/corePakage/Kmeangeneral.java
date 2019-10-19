package corePakage;
import java.io.*;
import java.util.*;
import java.*;  
import java.lang.*;  
import java.io.*;  
import java.util.*;  
import java.lang.String.*;  
import java.awt.event.*;  
import java.io.FileWriter;  
import java.io.PrintWriter;  
import java.io.StringReader.*;  
import java.util.Vector;  
import java.util.Iterator;  

import javax.swing.table .*;  



public class Kmeangeneral{  
        

     public static void main(String args[])throws Exception{  

           

         int words = 0;  

         int chars = 0;  

         int lines = 0;  

           

         String s,sp1;  

         StringTokenizer st;   

     ArrayList x=new ArrayList();  

            

                

 FileReader fr = new FileReader("c:\\Test\\s1.txt");  

                BufferedReader buf=new BufferedReader(fr);  

                   

          

         while((s=buf.readLine())!=null)  

         {  

                      lines++;  

                     st=new StringTokenizer(s," ,;:.");  
                                                    

                        while(st.hasMoreTokens())  

                         {  

                                

                                 words++;  

                                 s=st.nextToken();  

                                 chars+=s.length();  

                                    

                                 Double y=new Double(s);   

                                 x.add(y);  

                                    

                       }  
                          

         }  


        System.out.println("Word Count : "+words/lines);  

        System.out.println("Line Count : "+lines);  

           

                   

        Double ct[] = new Double[0];  


                   

        // Input array, values to be read in successively, float  

         double[][] indat = new double[lines][lines*words];   

          int inval =0;  

            

             

         BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in));  

         System.out.print("Enter K-Value : ");  

         sp1=buf1.readLine();  

            

          Integer ky=new Integer(sp1);     

         int k= ky;  

            

          System.out.println("K ==  "+ k);  

             

           

            

         // Now read in input array values, successively  

      

       

      for (int i = 0; i < lines; i++) {  

         for (int j = 0; j < words/lines; j++) {  

               

             

            indat[i][j] = ct[inval];  

             inval++;  

                

                        

              System.out.print(indat[i][j]);  

            System.out.print("\t");  

            }System.out.println();  

        }  
       

  

 //      Vector <Vector <String>> MyVector;  

   

 //  MyVector= new Vector <Vector <String>>(5,5);  

 //  MyVector.add("1");  

           
          

   // Vector clst = convertToVector(Object[k][words] indat);  

           

           

       //  Initial Clusters  

        System.out.println("   "  );  

        System.out.println(k + " seed  points "  );  

            

         double[][] Clusters = new double[k][lines*words];  
        double[][] calcnt = new double[lines][words];   

        double[][] array  = new double[k][lines*words];   

            

         

   //  int pos=0;  

        for (int i = 0; i < k; i++) {  

        for (int j = 0; j < words/lines; j++) {  

               

            Clusters[i][j] = indat[i][j];  

      //       pos= j;  

                     

             System.out.print(Clusters[i][j]);  

            System.out.print("\t");  

        }System.out.println();  
     



      }  


        Vector [][] FinalClusters = new Vector[k][lines*words];  

         

         for (int i = 0; i < k; i++) {  
         for (int j = 0; j < words/lines; j++){  

         FinalClusters[i][j].add(String. valueOf(Clusters[i][j]));  

             }  

         }  

   // Inital Cluster Array   

      System.out.println("Initial Cluster Array");  

        int b=0;  

        double [] arr = new double[lines*(words/lines)];  

         

      for (int i = 0; i < k; i++) {  

         for (int j = 0; j < words/lines; j++) {  

               

              arr[b]= Clusters[i][j]; // = indat[i][j];  

              System.out.print(arr[b]);  

              System.out.print("\t");          

            b++;  

           }  

 

             }System.out.println();  
     }

	private static void ray(Double[] ct) {
		// TODO 자동 생성된 메소드 스텁
		
	}
}

