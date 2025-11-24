import java.util.*;
public class ClientCode{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedStackClass<Integer> stack = new LinkedStackClass<>();
        System.out.print("Enter integers (999 to stop): ");
        int num = scan.nextInt();
        while(num != 999) {
            stack.push(num);
            num = scan.nextInt();
        }
        System.out.println("");
        System.out.println("The original stack printed in direct order (bottom to top) is:");
        printStack(stack);

        System.out.println("The stack printed in reverse order (top to bottom) is:");
        printBackStack(stack);

        System.out.println("The stack stores " + countItems(stack) + " items.");
        System.out.println("the top is: " + stack.peek());
        System.out.println("The second item (below top) is: " + getSecond(stack));

        System.out.print("The stack printed in reverse order (top to bottom is:");
        printBackStack(stack);

        System.out.println("Enter value to be removed from stack: ");
        int removeVal = scan.nextInt();
        removeItem(stack, removeVal);
        System.out.println("The stack after removing every occurence of " + removeVal + " is:");
        printStack(stack);

        reverseStack(stack);
        System.out.println("Reveresed the stack. The new stack printed in direct order is:");
        printStack(stack);

        QueueClass<Integer> queue = new QueueClass<>(100);
        System.out.println("\nEnter integers for queue (999 to stop):");
        num = scan.nextInt();
        while(num != 999){
            queue.enqueue(num);
            num = scan.nextInt();
        }
        System.out.println("THe queue is:");
        printQueue(queue);

        reverseQueue(queue);
        System.out.println("The reversed queue is:");
        printQueue(queue);

        scan.close();
    }
    
    public static void printBackStack(LinkedStackClass<Integer> intStack){
        LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
        while(!intStack.isEmptyStack()){
            temp.push(intStack.peek());
            System.out.print(intStack.peek() + " ");
            intStack.pop();
        }
        while(!temp.isEmptyStack()){
            intStack.push(temp.peek());
            temp.pop();
        }
        System.out.println();
    }
    public static void printStack(LinkedStackClass<Integer> intStack){
        LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
        LinkedStackClass<Integer> rearragne = new LinkedStackClass<Integer>();
        while(!intStack.isEmptyStack()){
            temp.push(intStack.peek());
            intStack.pop();
        }
        
        while(!temp.isEmptyStack()){
            System.out.println(temp.peek() + " ");
            rearragne.push(temp.peek());
            temp.pop();
        }

        while(!rearragne.isEmptyStack()){
            intStack.push(rearragne.peek());
            rearragne.pop();
        }
        System.out.println();
    }
    public static Integer getSecond(LinkedStackClass<Integer> intStack){
        if(intStack.isEmptyStack()){
            return null;
        }

        Integer top = intStack.peek();
        intStack.pop();
        if(intStack.isEmptyStack()){
            intStack.push(top);
            return null;
        }

        Integer second = intStack.peek();
        intStack.push(top);
        return second;
    }

    public static int countItems(LinkedStackClass<Integer> intStack){
        int count = 0;
        LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
        while(!intStack.isEmptyStack()){
            temp.push(intStack.peek());
            intStack.pop();
            count++;
        }
        while(!temp.isEmptyStack()){
            intStack.push(temp.peek());
            temp.pop();
        }
        return count;
    }
    public static void removeItem(LinkedStackClass<Integer> intStack, Integer n){
        LinkedStackClass<Integer> temp = new LinkedStackClass<Integer>();
        while(!intStack.isEmptyStack()){
            if(!intStack.peek().equals(n)){
                temp.push(intStack.peek());
            }
            intStack.pop();
        }
        while(!temp.isEmptyStack()){
            intStack.push(temp.peek());
            temp.pop();
        }
    }

    public static void reverseStack(LinkedStackClass<Integer> s){
        QueueClass<Integer> q = new QueueClass<Integer>(100);
        while(!s.isEmptyStack()){
            q.enqueue(s.peek());
            s.pop();
        }
        while(!q.isEmptyQueue()){
            s.push(q.front());
            q.dequeue();
        }
    }
    
    public static void reverseQueue(QueueClass<Integer> q){
        LinkedStackClass<Integer> s = new LinkedStackClass<Integer>();
        while(!q.isEmptyQueue()) {
            s.push(q.front());
            q.dequeue();
        }
        while(!s.isEmptyStack()) {
            q.enqueue(s.peek());
            s.pop();
        }
    }
    
    public static void printQueue(QueueClass<Integer> q) {
        QueueClass<Integer> temp = new QueueClass<Integer>(100); // temp queue
        
        while(!q.isEmptyQueue()) {
            try {
                Integer item = q.front();
                System.out.print(item + " ");
                
                temp.enqueue(item);
                
                q.dequeue();
            } catch (QueueUnderflowException e) {
                System.err.println("Queue underflow!");
            }
        }
        
        
        while(!temp.isEmptyQueue()) {
            try {
                q.enqueue(temp.front());
                temp.dequeue();
            } catch (QueueUnderflowException e) {
                System.err.println("Queue underflow!");
            }
        }
        
        System.out.println();
    }

}