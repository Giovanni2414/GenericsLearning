package Collections;

public interface LinkedListInter<T extends Comparable<T>> {
	
    public void addToList(T newNode);
    public boolean deleteElement(T deleteElement);
    public T deletePosition(int position);
    public int getLength();
    public int getElementPosition(T element);
    public T getElementByPosition(int position);
    public boolean clearList();
    public String showAll();
    public boolean isEmpty();
    
}
