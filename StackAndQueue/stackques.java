import java.util.Stack;
import java.util.Arrays;
public class stackques{
    public static boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         if(ch=='(' || ch=='{' || ch=='['){
             st.push(ch);
         }
         else{
             if(st.size()==0)return false;
             else if(st.peek()=='(' && ch!=')')return false;
             else if(st.peek()=='{' && ch!='}')return false;
              else if(st.peek()=='[' && ch!=']')return false;
             st.pop();
         }
        }
        return st.size()==0?true:false;
    }
   
    public static int[] nextgreaterOnRight(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st= new Stack<>();
        Arrays.fill(ans,arr.length);
         for(int i=0;i<arr.length;i++){
             
             while(st.size()!=0 && arr[st.peek()]<arr[i]){
                 int idx=st.pop();
                 ans[idx]=i;
             }
             st.push(i);
         }
        return ans;
    }

    public static int[] nextsmallerOnRight(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st= new Stack<>();
        Arrays.fill(ans,arr.length);
         for(int i=0;i<arr.length;i++){
             while(st.size()!=0 && arr[st.peek()]>arr[i]){
                 int idx=st.pop();
                 ans[idx]=i;
             }
             st.push(i);
         }
        return ans;
    }

    public static int[] nextgreaterOnLeft(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st= new Stack<>();
        Arrays.fill(ans,-1);
         for(int i=arr.length-1;i>=0;i--){
             while(st.size()!=0 && arr[st.peek()]<arr[i]){
                 int idx=st.pop();
                 ans[idx]=i;
             }
             st.push(i);
         }
        return ans;
    }

    public static int[] nextsmallerOnLeft(int[] arr){
        int[] ans=new int[arr.length];
        Stack<Integer> st= new Stack<>();
        Arrays.fill(ans,-1);
         for(int i=arr.length-1;i>=0;i--){
             while(st.size()!=0 && arr[st.peek()]>arr[i]){
                 int idx=st.pop();
                 ans[idx]=i;
             }
             st.push(i);
         }
        return ans;
    }

    public static int max_area(int[] arr){
        int[] nogl=nextsmallerOnLeft(arr);
        int[] nogr=nextsmallerOnRight(arr);
        int max_areaans=0;
        for(int i=0;i<arr.length;i++){
            int w=(nogr[i]-nogl[i]-1);
            int h=arr[i];
            int area=h*w;

            max_areaans=Math.max(max_areaans, area);
        }
        return max_areaans;
    }

    public static void main(String [] args){
        String s="{{[(])}";
        System.out.println(isValid(s));
        int[] arr={2,4,1,-1,6,8,6,5,4,9,8,7,6};
        int[] arr1={2,1,5,6,2,3};
        int maxarea =max_area(arr1);
        System.out.println(maxarea);
        int [] fansR= nextgreaterOnRight(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(fansR[i]+" ");
        }
        System.out.println("NGOR:");
        int [] fansL= nextgreaterOnLeft(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(fansL[i]+" ");
        }
        System.out.println("NGOL:");
       
        int [] fansLs= nextsmallerOnLeft(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(fansLs[i]+" ");
        }
        System.out.println("NSOL");
       
        int [] fansRs= nextsmallerOnRight(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(fansRs[i]+" ");
        }
        System.out.println("NSOR");
    }
}