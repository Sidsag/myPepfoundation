
public class client {
  public static void main(String[] args){
      hashmap map=new hashmap();
      hashmapgenric <String,Integer> coronar=new hashmapgenric<>();
      map.put(10,100);
      map.put(20,200);
      map.put(32,300);
      map.put(40,400);
      map.put(50,500);
      map.put(66,600);
      map.put(70,700);
      map.put(80,800);
      map.put(90,601);
      map.put(22,900);
      map.display();
      System.out.println(map.containskey(22));
      System.out.println(map.get(80));
 //generic
        coronar.put("USA",298765);
        coronar.put("Spain",124736);
        coronar.put("Italy",29871);
        coronar.put("India",3024);
        coronar.put("USA",58765);
        coronar.getbydefault("Nepal", 00);
        //coronar.putifabsent("Nepal",1000);
        coronar.display();
        System.out.println(coronar.get("USA"));
  }
}