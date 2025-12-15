public interface LinkedListIntADT{
    public boolean isEmptyList();
    public void initializeList();
    public void print();
    public int length();
    public int front();
    public int back();
    public boolean search(int searchItem);
    public void insertLast(int newItem);
    public void deleteNode(int deleteItem);
}