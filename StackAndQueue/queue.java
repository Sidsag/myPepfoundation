
public class queue {
  protected int[] arr;
  protected int size=0;
  protected int front=0;
  protected int back=0;
 
  public queue(){
      reassign(10);
  }

  public queue(int size){
      reassign(size);
  }
  protected void reassign(int size){
    arr=new int[size];
    size=0;
    front=0;
    back=0;
 }
  
 protected int front(){
     if(this.size==0)throw new Ex
 }


}