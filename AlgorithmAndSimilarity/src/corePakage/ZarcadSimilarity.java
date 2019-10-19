package corePakage;

import java.io.*;
import java.util.*;

public class ZarcadSimilarity {
	public static void main(String[] args) {
		
		HashMap<String, Integer> S1 = new HashMap<String,Integer>();
		HashMap<String, Integer> S2 = new HashMap<String,Integer>();
		HashMap<String, Integer> S3 = new HashMap<String,Integer>();
		
		try {
			BufferedReader br1 = new BufferedReader(new FileReader("c:\\Test\\s1.txt"));
			String buffer1="";
			while( (buffer1 = br1.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(buffer1, " ?.");
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
				StringTokenizer st = new StringTokenizer(buffer2, " ?.");
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
				StringTokenizer st = new StringTokenizer(buffer3, " ?.");
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
		} catch (IOException e) {}
		
		// S1과 S2의 JC 계산
		int numOfCommon1 = 0;
		Iterator<String> iS1 = S1.keySet().iterator();
		while(iS1.hasNext()) {
			String tempKey1 = iS1.next();
			if(S3.containsKey(tempKey1)) {
				numOfCommon1++;
			}
		}

		System.out.println(numOfCommon1);
		System.out.println("JC S1 and S2 = " + (double)numOfCommon1/(double)(S1.keySet().size()+S2.keySet().size()-numOfCommon1));
		
		// S2과 S3의 JC 계산
		int numOfCommon2 = 0;
		Iterator<String> iS2 = S2.keySet().iterator();
		while(iS2.hasNext()) {
			String tempKey2 = iS2.next();
			if(S3.containsKey(tempKey2)) {
				numOfCommon2++;
			}
		}

		System.out.println(numOfCommon2);
		System.out.println("JC S2 and S3 = " + (double)numOfCommon2/(double)(S2.keySet().size()+S3.keySet().size()-numOfCommon2));
		
		// S2과 S3의 JC 계산
		int numOfCommon3 = 0;
		Iterator<String> iS3 = S3.keySet().iterator();
		while(iS3.hasNext()) {
			String tempKey3 = iS3.next();
			if(S1.containsKey(tempKey3)) {
				numOfCommon3++;
			}
		}

		System.out.println(numOfCommon3);
		System.out.println("JC S1 and S3 = " + (double)numOfCommon3/(double)(S1.keySet().size()+S3.keySet().size()-numOfCommon3));
		
		
	}
}