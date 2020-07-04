import java.util.HashMap;
import java.util.ArrayList;

public class basichash{
    public static void basicfunction(){
        HashMap<String,Integer> coronar=new HashMap<>();
        coronar.put("USA",298765);
        coronar.put("Spain",124736);
        coronar.put("Italy",29871);
        coronar.put("India",3024);
        coronar.put("USA",58765);
        System.out.println(coronar);
        System.out.println(coronar.get("USA"));
        System.out.println(coronar.getOrDefault("IBN",0));
    }
    public static void freqmap(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);}
            System.out.println(map);
            for(char ch: map.keySet()){
                System.out.println(ch+"-> "+map.get(ch));
            }
        }

        public static void freqarraylist(String str){
            HashMap<Character,ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                map.putIfAbsent(ch,new ArrayList<>());
                map.get(ch).add(i);
            }
            System.out.println(map);
            for(char ch:map.keySet()){
                System.out.println(ch+"->"+ map.get(ch));
            }
        }

        public static void intersectionsimple(int[] one,int[] two){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int ele:one){
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
            System.out.print("[");
            for(int ele:two){
                if(map.containsKey(ele)){
                 System.out.print(ele+", ");
                 map.remove(ele);
                }
            }
            System.out.println("]");
        }

        public static void intersectionactual(int[] one,int[] two){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int ele:one){
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
            System.out.print("[");
            for(int ele:two){
                if(map.containsKey(ele)){
                 System.out.print(ele+", ");
                 map.put(ele,map.get(ele)-1);
                 if(map.get(ele)==0)
                 map.remove(ele);
                }
            }
            System.out.println("]");
        }

    public static void main(String[] args){
        String str="qwysadsfacqasyfrs";
        freqmap(str);
        freqarraylist(str);
        int[] one={2,3,2,4,6};
        int[] two={2,2,2,3,6,6,3};
        intersectionsimple(one, two);
        intersectionactual(one, two);
        basicfunction();
    }
}