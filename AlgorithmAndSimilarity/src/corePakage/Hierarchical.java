package corePakage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Hierarchical {
	public static void main(String[] args) {
		
		HashMap<String, Integer> S1 = new HashMap<String,Integer>();
		HashMap<String, Integer> S2 = new HashMap<String,Integer>();
		HashMap<String, Integer> S3 = new HashMap<String,Integer>();
		
		try {
			BufferedReader br1 = new BufferedReader(new FileReader("c:\\Test\\s1.txt"));
			String buffer1="";
			while( (buffer1 = br1.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(buffer1, " ?.,");
				while(st.hasMoreTokens()) {
					String tempToken = st.nextToken();
					//System.out.println(tempToken);
					if(!S1.containsValue(tempToken)) {
						S1.put(tempToken, 1);
					} else {
						Integer tempInt = S1.get(tempToken) + 1;
						S1.put(tempToken, tempInt);
					}
				}
			}
			
			BufferedReader br2 = new BufferedReader(new FileReader("c:\\Test\\s2.txt"));
			String buffer2="";
			while( (buffer2 = br2.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(buffer2, " ?.,");
				while(st.hasMoreTokens()) {
					String tempToken = st.nextToken();
					//System.out.println(tempToken);
					if(!S2.containsValue(tempToken)) {
						S2.put(tempToken, 1);
					} else {
						Integer tempInt = S2.get(tempToken) + 1;
						S2.put(tempToken, tempInt);
					}
				}
			}
			
			BufferedReader br3 = new BufferedReader(new FileReader("c:\\Test\\s3.txt"));
			String buffer3="";
			while( (buffer3 = br3.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(buffer3, " ?.,");
				while(st.hasMoreTokens()) {
					String tempToken = st.nextToken();
					//System.out.println(tempToken);
					if(!S3.containsValue(tempToken)) {
						S3.put(tempToken, 1);
					} else {
						Integer tempInt = S3.get(tempToken) + 1;
						S3.put(tempToken, tempInt);
					}
				}
			}
			
			
			br1.close();
			br2.close();
			br3.close();
		} catch (IOException e) {
			System.out.println("error is" + e);
		}
		
	}
	
}



