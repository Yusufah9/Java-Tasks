package tdd;

public class Stack {
    private int count;
    private String[] stackContents = new String[5];

    public boolean isEmpty(){
        return count == 0;
    }

    public void push(String element){
        stackContents[count++] = element;
    }

    public String pop(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is Empty");
        }
        return stackContents[--count];
    }

    public String peek(){
        if(isEmpty()){
            throw new IllegalArgumentException("Stack is empty");
        }
        return stackContents[count - 1];
    }

    public int search(String element){
        for(int index = 0; index < count; index++){
            if(stackContents[index].equals(element)) return index;
        }
        return -1;
    }
}
