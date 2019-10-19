package corePakage;

import java.util.Scanner;

public class FormalClass {
	public static void main(String [] Args){
		
		int [][] one = {{1,0,1,7},
							{0,7,2,6}};
		
		int [][] two = {{4,5},
							{5,2},
							{1,3},
							{7,4}};
		int result [][] = new int [2][2];

		for (int i = 0 ; i<result.length; i++) {
			for (int j = 0 ; j<result.length; j++){
				for (int k = 0 ; k<4; k++){
					result [i][j] += one[i][k] * two[k][j];
				}
				System.out.println(result[i][j]);
			}
		}
		
	
		
				
			

				
				
			}
}

	


