import java.util.ArrayList;
public class nokiakeypad{

    public static void main(String[] args){
        String[] codes={"?.",",;","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
        String ques="478";
         ArrayList<String> ans= nokiakey(codes,ques);
         System.out.println(ans);
    }


    public static ArrayList<String> nokiakey(String[] codes,String ques){
        if(ques.length()==0){
            ArrayList<String> baseres= new ArrayList<>();
            baseres.add("");
            return baseres;
        }

        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        int idx= ch-"0";
        String code= codes[idx];
        ArrayList<String> myans= new ArrayList<>();
        ArrayList<String> recans= nokiakey(codes,roq);
        for(int i=0;i<code.length();i++){
            for(String str:recans){
                myans.add(code.charAt(i)+str);
            }
        }
        return myans;
    }
}