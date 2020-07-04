import java.util.ArrayList;
 class countstep{
public static int stairspath(int n){
if(n==0)
return 1;
int myans=0;
if(n-1>=0)
myans+=stairspath(n-1);
if(n-2>=0)
myans+=stairspath(n-2);
if(n-3>=0)
myans+=stairspath(n-3);
return myans;
}

public static ArrayList<String> givepath(int n){

if(n==0){
ArrayList<String> baseres=new ArrayList<>();
baseres.add("");
return baseres;
}

ArrayList<String> myans=new ArrayList<>();
if(n-1>=0){
ArrayList<String> recans=givepath(n-1);
for(String str:recans)
myans.add("1"+str);
}
if(n-2>=0){
ArrayList<String> recans=givepath(n-1);
for(String str:recans)
myans.add("2"+str);
}
if(n-3>=0){
ArrayList<String> recans=givepath(n-3);
for(String str:recans)
myans.add("3"+str);
}
return myans;
}

public static void main(String[] args){
    System.out.println(stairspath(7));
     System.out.println(givepath(7));
}
}
