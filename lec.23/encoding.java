public class encoding{
    public static void main(String [] args){
    encode("1123","");
    }

    public static void encode(String ques,String ans){
      if()

        int num=ques.charAt(0)-'0';
        if(num>=1 && num<=9){
            encode(ques.substring(1),ans+(char)(96+num));} //'a'-num-1=96-1;
        else{
         return;}

        int num1=ques.charAt(1)-'0';
        int num2=10*num+num1;

        if(num2>=10 && num2<=26)
        encode(ques.substring(2),ans+(char)(96+num2));
        System.out.println(ans);
    }
}
