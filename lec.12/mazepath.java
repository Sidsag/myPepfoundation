import java.util.ArrayList;
class mazepath{
    public static int mzpth(int sr,int sc,int er,int ec,String path){
        if(sr==er && sc==er){
        System.out.println(path + " ");
            return 1;
        }
        int count =0;
        if(sc+1<=ec){
            count+=mzpth(sr,sc+1,er,ec,path + "H");
        }

        if(sr+1<=er){
            count+=mzpth(sr+1,sc,er,ec,path + "V");
        }
        return count;
    }

    public static void main(String[] args){
        String p="";
        int number=mzpth(0,0,3,3,p);
        System.out.println(number);
        ArrayList<String> ans=maze(0,0,3,3);
        System.out.println(ans);
        System.out.println(ans.size());
        
    }

    public static ArrayList<String> maze(int sr,int sc,int er,int ec){
       if(sr==er && sc==er){
        ArrayList<String> baseres= new ArrayList<>();
        baseres.add("");
        return baseres;
        } 

      ArrayList<String> myans= new ArrayList<>();

      if(sc+1<=ec){
          ArrayList<String> recans= maze(sr,sc+1,er,ec);
          for(String str:recans)
          myans.add("H"+str);
      }

      if(sr+1<=er){
          ArrayList<String> recans= maze(sr+1,sc,er,ec);
          for(String str:recans)
          myans.add("V"+str);
      }
      return myans;

    }
}