import java.util.Arrays;

public class LIS {
	
	public static void lis(int a[],int dp[]) {
		for(int i =0;i<a.length;i++) {
			for(int j =0;j<i;j++) {
				if(a[i]>a[j]) {
					if(dp[j]>=dp[i])
						dp[i]=dp[j]+1;
				}
			}
		}
		int l = 0;
		for(int i = 0;i<dp.length;i++)
			l = Math.max(l, dp[i]);
	}
	
	public static void dis(int a[],int dp[]) {
		for(int i = a.length-1;i>=0;i--) {
			for(int j = a.length-1;j>i;j--) {
				if(a[i]>a[j]) {
					if(dp[j]>=dp[i])
						dp[i] = dp[j]+1;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 4, 2, 5, 9, 7, 6, 10, 3, 1 }; 
		int ip[] = new int[arr.length];
		Arrays.fill(ip, 1);
		lis(arr,ip);
		int min = -1;
		int x=0;
		for(int i=0;i<ip.length;i++)
			if(min>ip[i]) {
				min =ip[i];
				x = i;
			}
//		System.out.print(arr[x]+", ");
//		for(int i =x+1;i<ip.length;i++) {
//			if(ip[i]>ip[x]) {
//				x=i;
//				System.out.print(arr[i]+", ");
//			}
//		}
		int dp[] = new int[arr.length];
		Arrays.fill(dp, 1);
		dis(arr,dp);
		int max = 0;
		for(int i = 0;i<arr.length;i++) {
			max = Math.max(max, dp[i]+ip[i]-1);
		}
		System.out.println("Length of Longest bitonic sequence "+max);
	}

}
