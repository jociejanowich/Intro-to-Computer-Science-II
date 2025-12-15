import java.util.NoSuchElementException;

public abstract class LinkedListIntClass implements LinkedListIntADT {
    protected class LinkedListNode {
        int info;
        LinkedListNode link;
    }

    protected LinkedListNode first;
    protected LinkedListNode last;
    protected int count;

    public LinkedListIntClass() {
        initializeList();
    }

    public boolean isEmptyList() {
        return (first == null);
    }

    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

    public void print() {
        LinkedListNode current = first;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.link;
        }
        System.out.println();
    }

    public int length() {
        return count;
    }

    public int front() {
        if (first == null) {
            throw new NoSuchElementException("List is empty.");
        }
        return first.info;
    }

    public int back() {
        if (last == null) {
            throw new NoSuchElementException("List is empty.");
        }
        return last.info;
    }

    public boolean search(int searchItem) {
        LinkedListNode current = first;
        while (current != null) {
            if (current.info == searchItem) {
                return true;
            }
            current = current.link; 
        }
        return false;
    }

    public abstract void insertFirst(int newItem);
    public abstract void insertLast(int newItem);
    public abstract void deleteNode(int deleteItem);
}
