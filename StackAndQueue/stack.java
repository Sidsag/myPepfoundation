import java.util.EmptyStackException;
import java.util.EmptyStackException;
public class stack{
    protected int[] arr;
    protected int size=0;
    protected int tos=-1;

    public stack(){
        reassign(10);
    }

    public stack(int size){
        reassign(size);
    }

    protected void reassign(int size){
        arr=new int[size];
        size=0;
        tos=-1;
    }

    public int peek(){
        if(this.size==0)throw new EmptyStackException();
        return this.arr[this.tos];
    }

    public int pop(){
        if(this.size==0)throw new EmptyStackException();
        int rv=this.arr[this.tos];
        this.arr[this.tos]=0;
        this.tos--;
        this.size--;
        return rv;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void push(int val)throws Exception{
        if(this.size==this.arr.length)throw new Exception("StackisFull");
        this.tos++;
        this.arr[this.tos]=val;
        this.size++;
    }

    public void display(){
        String s="";
        for(int i=tos;i>=0;i--){
            s+=this.arr[i]+" ";
        }
        System.out.println(s);
    }
}