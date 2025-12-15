public class Main {
    public static void main(String[] args) {
        UnorderedLinkedListInt list = new UnorderedLinkedListInt();
        list.insertLast(5);
        list.insertFirst(10);
        list.insertLast(20);
        System.out.println(list);
        System.out.println("Sum: " + list.findSum());
        System.out.println("Min: " + list.findMin());
    }
}
