package corePakage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class LinebyLine {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub

      String dirName = "?òÑ???èò?Çò??/?Ñ±?ä•/";
      String filePath = "D://" + dirName+ "/txt/2016/";
      //String feelingDicName = "D:/ASA2/feeling/Í∞êÏÑ±?Ç¨?†Ñ.txt";  
      for(int i=1; i<=340; i++ ){
      String infileName = filePath+ "a (" +i+ ").txt";
      String outfileName = "D://?òÑ???èò?Çò??/?Ñ±?ä•/test/" + "test" +i+".txt";
      String finalfileName = "D://?òÑ???èò?Çò??/?Ñ±?ä•/test/2016/"  + "final" +i+".txt";
      ArrayList<String> tokenList = new ArrayList<String>();
      StringTokenizer tokenizer;
      String token;
      
     //PrintWriter testWriter = new PrintWriter(new File(outfileName));
     PrintWriter finalWriter = new PrintWriter(new File(finalfileName));
      
      Tokenize(infileName, tokenList);
       
      for(String s : tokenList) {
         tokenizer = new StringTokenizer(s, ".");
         finalWriter.write(s);
         while(tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            
            if(token.equals(" ")){
               continue;
            }
            finalWriter.println(token);
           
         }
         
      }
      
      //testWriter.close();   
      finalWriter.close();
      System.out.println("success!");
      }  
   }
   
   public static int Tokenize(String fileName, 
         ArrayList<String> tokenList/*, ArrayList<String> duplitokenList*/) throws IOException { // 1ÔøΩÔøΩ tokenizing:
    
      // FileReader fr = new FileReader(new File(fileName));
      // BufferedReader textReader = new BufferedReader(fr);
   
      Scanner scan;

      // String line;
      /*
       * while((line = textReader.readLine()) != null) {
       * outTestWriter.println(line); line = line.replaceAll("[0-9]",
       * " ").replaceAll("[a-z]", " ") .replaceAll("\\s+", " ");
       * outWriter.println(line); }
       */

      try {
         scan = new Scanner(new File(fileName),"UTF-8");
      } catch(FileNotFoundException e) {
         return -1;
      }
      
      while (scan.hasNext()) {
         // delete unnecessary words
         String line = scan.nextLine();
         line = line.replaceAll("[0-9]", "").replaceAll("[a-zA-Z]", "")
               .replaceAll("[.]", "¬∑")
               .replaceAll("", "")
               .replaceAll("", " ");
      
       
         if(line.length() != 0)
            tokenList.add(line);
   
      }
      System.out.println(scan);
      scan.close();
      return 1;
   
   }
   
}