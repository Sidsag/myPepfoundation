import java.util.Scanner;
public class fibbodp
{
    public static void main(String[] args){
    Scanner scn =new Scanner(System.in);
    System.out.println("enter the number to get it's fibbonacci");
    int number=scn.nextInt();
    int[] dparr=new int[number+1];
    int s= fibbo(number,dparr);
    System.out.println("the ans is:"+s);
    }

    public static int fibbo(int n,int[] dp){
        
        if(n==0||n==1){
            return n;
        }

        if(dp[n]!=0){
            return dp[n];
        }
         
        int num1=fibbo(n-1,dp);
        int num2=fibbo(n-2,dp);
        dp[n]=num1+num2;
        return num1+num2;
    }
}