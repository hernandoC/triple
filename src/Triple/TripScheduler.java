package Triple;

import java.util.Scanner;

public class TripScheduler {
	public static void main(String[] args) {
		
		// 입력을 위한 Scanner		
		Scanner scanner = new java.util.Scanner(System.in);
		
		// 입력으로 받을 장소들의 개수, 여행 시간
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		// 최대 만족도를 저장할 배열
		int[][] dp = new int[n + 1][m + 1];
		
		// 입력을 문자열로 저장할  StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// 구분자
		String delimiter1 = "\n";
		String delimiter2 = ",";
			
		scanner.nextLine();
		
		// 입력받은 장소들의 개수 만큼 장소,시간,만족도를 입력받는다.
		for(int i = 0; i < n; i ++) {
			sb.append(scanner.nextLine().trim());
			if(i == n - 1) {
				scanner.close();
			}
			else {
				// 개행을 "\n" 로 구분하기 위해 구분자를 붙인다.
				sb.append(delimiter1);	
			}
		}
		
		// 각 장소,시간,만족도를 String[] 에 저장
		String[] arrData = sb.toString().split(delimiter1);
		
		for(int i = 1; i <= n; i ++  ) {
			
			// String[] 에 저장된 시간, 만족도를 inputTime, inputSatisfaction 에 저장
			int inputTime = Integer.parseInt(arrData[i - 1].split(delimiter2)[1]);
			int inputSatisfaction = Integer.parseInt(arrData[i - 1].split(delimiter2)[2]);
			
			for(int j = 1; j <= m; j ++) {
				
				// j가 입력받은 시간보다 크면
				if(j >= inputTime) {
					// 이전 장소까지의 최대 만족도와, 입력받은 시간을 뺀 만큼의 만족도에 입력받은 만족도를 더한 값 중 큰 값을 저장 
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - inputTime] + inputSatisfaction);
				}
				// 아니면
				else {
					// 이전 장소까지의 최대 만족도 저장
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		// 결과 출력
		System.out.println(dp[n][m]);
	}
}