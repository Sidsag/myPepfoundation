class string{

    public static void main(String[] args){
        String s="abcdef";

        for(int k=0;k<s.length();k++){
             String str=s.substring(1,4);
              System.out.println(str);}

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){  /*as i+1-:if begning and last index same i.e.*/ 
            String sb=s.substring(i,j);            /* in i=j:string run for empty too*/
            System.out.print(sb+" ");
            }
        }
    }
}