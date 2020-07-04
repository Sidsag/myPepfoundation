import java.util.ArrayList;
public class subseq2{
public static ArrayList<string> subseq1(String ques) {
    if(ques.length()==0){
        ArrayList<String> baseres=new ArrayList<>();
        baseres.add("");
        return baseres;
    }

    String roq=ques.substring(1);
    ArrayLIst<String> recans= new ArrayList<>();
    ArrayLIst<String> myans= new ArrayList<>();
    
    char ch=ques.charAt(0);

    for(int i=0;i<recans.size;i++)
    myans.add(ch + recans.get(i));

    for(int i=0;i<recans.size;i++)
    myans.add(recans.get(i));

    return myans;
}

public static void main(String[] args){
    String st=substring(abc);
    System.out.println(st);
}
}