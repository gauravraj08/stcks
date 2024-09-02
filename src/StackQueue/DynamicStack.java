package StackQueue;

public class DynamicStack extends stackCustom{
    public DynamicStack(){
        super();//calls public stackCustom()
    }
    public DynamicStack(int size){
        super(size);
    }
    @Override
    public boolean push(int item){
        if(this.isFull()){
            int[] temp=new int[data.length*2];
            for(int i=0;i<data.length;i++){
                temp[i]=data[i];
            }
            data=temp;
        }
        //now stack is not empty so
        return super.push(item);
    }
}
