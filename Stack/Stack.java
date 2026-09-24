
public class Stack {
    private int count;
    private String[] stackContents = new String[5];

    public boolean isEmpty(){
        return count == 0;
    }
    public void push(String element){
        stackContents[count++] = element;
    }
    public String pop(){;
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is Empty");
        }
        return stackContents[--count];
    }
    public String peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty");
        }
        String element =  stackContents[--count];
        count++;
        return element;
    }
    public int search(String element){
        for(int index = 0; index < stackContents.length; index++){
            if(stackContents[index] == element) return index;
        }
        return -1;
    }

}
