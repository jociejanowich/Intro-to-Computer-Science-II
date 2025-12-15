public class UnorderedLinkedListInt extends LinkedListIntClass {

    @Override
    public void insertFirst(int newItem) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.info = newItem;
        newNode.link = first;
        first = newNode;

        if (last == null) {
            last = newNode;
        }
        count++;
    }

    @Override
    public void insertLast(int newItem) {
        LinkedListNode newNode = new LinkedListNode();
        newNode.info = newItem;
        newNode.link = null;

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.link = newNode;
            last = newNode;
        }
        count++;
    }

    @Override
    public void deleteNode(int deleteItem) {
        if (first == null) {
            System.out.println("Nothing to delete from empty list");
            return;
        }

  
        if (first.info == deleteItem) {
            first = first.link;
            if (first == null)
                last = null;
            count--;
            return;
        }

       
        LinkedListNode current = first.link;
        LinkedListNode trailCurrent = first;

        while (current != null && current.info != deleteItem) {
            trailCurrent = current;
            current = current.link;
        }

        if (current == null) {
            System.out.println("Item not found in the list.");
        } else {
            trailCurrent.link = current.link;
            if (current == last)
                last = trailCurrent;
            count--;
        }
    }

    public int findSum() {
        int sum = 0;
        LinkedListNode current = first;
        while (current != null) {
            sum += current.info;
            current = current.link;
        }
        return sum;
    }

    public int findMin() {
        if (isEmptyList()) {
            throw new IllegalStateException("List is empty");
        }
        int min = first.info;
        LinkedListNode current = first.link;
        while (current != null) {
            if (current.info < min)
                min = current.info;
            current = current.link;
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        LinkedListNode current = first;
        while (current != null) {
            sb.append(current.info);
            if (current.link != null)
                sb.append(", ");
            current = current.link;
        }
        sb.append("]");
        return sb.toString();
    }
}
