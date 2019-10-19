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
      
      System.out.println("�Է��� ������ ����");
      
      n=Integer.parseInt(in.readLine());
      
      String clust_a[]=new String[n]; //singleton
      int clust_1[]=new int[n]; // Distance
      
      System.out.println("�Է��� ������ �� ũ��");
         for(int i=0;i<n;i++)
         {
            clust_a[i]=in.readLine();
            clust_1[i]=Integer.parseInt(in.readLine());
            
            //���� �Է�
            FileWriter fout = null;
                 try {
                     fout = new FileWriter("test1.txt",true);
                     
                     fout.write(clust_a[i]+clust_1[i]+"\n");
                                
                     fout.close();
                  } catch (IOException ae) {
                     System.out.println("����");
                  }
         } 
         
         //�Է��� �����͸� ����
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
         System.out.println("���ĵ� ������");
         System.out.println("������\t\tũ��");
         
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
   
  
         /*2�����迭���� �� ��(b=0,1,2,3...)�� �ּڰ��� ã�� Ŭ���������ش�*/
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
         
// TreeSet Ŭ������ �̿��Ͽ� ���� ���ڿ�(clust) �׸��� ���� ����(�ּҰŸ�) ����(2���� �迭�̹Ƿ� �ߺ����� �ִ�.)
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
                  System.out.println("����");
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