package corePakage;

import java.io.*;
import java.lang.*;
import java.util.TreeSet;
import java.util.Iterator;

public class Hierarchical_Clustering
{
   public static void main(String args[])throws IOException
   {
      int n,temp;
      String temp1;
      String [][]arrS1 = new String[4][4]; // 
      int [][]arrD1 = new int[4][4]; // 
      
      DataInputStream in=new DataInputStream(System.in);
      
      System.out.println("입력할 데이터 갯수");
      
      n=Integer.parseInt(in.readLine());
      
      String clust_a[]=new String[n]; //singleton
      int clust_1[]=new int[n]; // Distance
      
      System.out.println("입력할 데이터 및 크기");
         for(int i=0;i<n;i++)
         {
            clust_a[i]=in.readLine();
            clust_1[i]=Integer.parseInt(in.readLine());
            
            //파일 입력
            FileWriter fout = null;
                 try {
                     fout = new FileWriter("test1.txt",true);
                     
                     fout.write(clust_a[i]+clust_1[i]+"\n");
                                
                     fout.close();
                  } catch (IOException ae) {
                     System.out.println("오류");
                  }
         } 
         
         //입력한 데이터를 정렬
         for(int j=0;j<n;j++)
         {
            for(int k=0;k<n;k++)
            {
               if(clust_1[j]<clust_1[k])
               {
                  temp=clust_1[j];
                  clust_1[j]=clust_1[k];
                  clust_1[k]=temp;
                  temp1=clust_a[j];
                  clust_a[j]=clust_a[k];
                  clust_a[k]=temp1;
               }
               
            
               arrS1[j][k]=clust_a[j]+"-"+clust_a[k];
               arrD1[j][k]=Math.abs(clust_1[j]-clust_1[k]);
            }
         }
         System.out.println("정렬된 데이터");
         System.out.println("데이터\t\t크기");
         
         for(int i=0;i<n;i++)
         {
            if(clust_a[i]!="0")
               System.out.println(clust_a[i]+"\t\t"+clust_1[i]);
         }
         System.out.println("");
         
         
         operation op=new operation();
         op.display(arrS1,arrD1,n);
         
         
         String clust_b[]=new String[n+100]; //clustering1 data
         int clust_2[]=new int[n+100]; // clustering1 Distance
   
  
         /*2차원배열에서 각 행(b=0,1,2,3...)의 최솟값을 찾아 클러스터해준다*/
         int min = Integer.MAX_VALUE;
         for(int a=0;a<n;a++) 
         {
            if(arrD1[a][0] != 0) {
               if(min>arrD1[a][0]){
                  min = arrD1[a][0];
                  clust_2[0] = min;
                  clust_b[0] = arrS1[a][0]; 
               
               }
            }
         
         }
         
         int min1 = Integer.MAX_VALUE;
         for(int a=0;a<n;a++) {
            if(arrD1[a][1] != 0) {
               if(min1>arrD1[a][1]){
                  min1 = arrD1[a][1];
                  clust_2[1] = min1;
                  clust_b[1] = arrS1[a][1];
                  
               }
            }
         }
         
         int min2 = Integer.MAX_VALUE;
         for(int a=0;a<n;a++) {
            if(arrD1[a][2] != 0) {
               if(min2>arrD1[a][2]){
                  min2 = arrD1[a][2];
                  clust_2[2] = min2;
                  clust_b[2] = arrS1[a][2];
                  
               }
            }
         }
         
         int min3 = Integer.MAX_VALUE;
         for(int a=0;a<n;a++) {
            if(arrD1[a][3] != 0) {
               if(min3>arrD1[a][3]){
                  min3 = arrD1[a][3];
                  clust_2[3] = min3;
                  clust_b[3] = arrS1[a][3];
      
               }
            }
         }
         //System.out.println("clustering\tManhattanDistance");
         
// TreeSet 클래스를 이용하여 같은 문자열(clust) 그리고 같은 숫자(최소거리) 제거(2차원 배열이므로 중복값이 있다.)
         TreeSet tSet = new TreeSet(); 
         TreeSet tSet1= new TreeSet();
         
         for(int i=0;i<n;i++) {
            tSet.add(clust_b[i]);
            tSet1.add(clust_2[i]);
         }
         Iterator it = tSet.iterator();
         Iterator it1= tSet1.iterator();
         
         /*while (it.hasNext() || it1.hasNext()) {
            System.out.println(it.next()+"\t\t"+it1.next());
         }*/
         
         while (it.hasNext() || it1.hasNext()) {
            FileWriter fout1 = null;
              try {
                  fout1 = new FileWriter("test2.txt",true);
                  fout1.write("clustering\tManhattanDistance\n");
                  fout1.write(it.next()+"\t\t"+it1.next()+"\n");
                             
                  fout1.close();
               } catch (IOException ae) {
                  System.out.println("오류");
               }
         }   
      
   }
}

class operation {
   void display(String arrS1[][],int arrD1[][],int n)
   {
      System.out.println("subtraction\tManhattanDistance");
      
      for(int i=0;i<n;i++){
         for (int j=0;j<n;j++){
            if(arrD1[i][j]!=0){
               
            
               System.out.println(arrS1[i][j]+"\t\t"+arrD1[i][j]);
            }
         }
         System.out.println("");
      }
      System.out.println("");
   }
}