package Collections;

public class LinkedList<T extends Comparable<T>> implements LinkedListInter<T> {

    private Node<T> root;

    public LinkedList()
    {
        this.root = null;
    }

    public Node<T> getRoot()
    {
        return root;
    }

    public void setRoot(Node<T> root)
    {
        this.root = root;
    }

	@Override
    public void addToList(T newNode)
    {
        if(root == null) {
            root = new Node<T>(newNode);
        } else {
            if(root.getElement().compareTo(newNode)<0) {
                Node<T> temporal = new Node<T>(newNode);
                temporal.setNext(root);
                root = temporal;
            } else {
            	addToListRecursive(root, newNode);
            }
        }
    }

    public void addToListRecursive(Node<T> current, T newNode)
    {
        if(current.getElement().compareTo(newNode)>0 && current.getNext() == null) {
            current.setNext(new Node<T>(newNode));
        }else if(current.getElement().compareTo(newNode)>0 && current.getNext() != null) {
            if(current.getNext().getElement().compareTo(newNode)<=0) {
                Node<T> temporal = new Node<T>(newNode);
                temporal.setNext(current.getNext());
                current.setNext(temporal);
            }else {
            	addToListRecursive(current.getNext(), newNode);
            }
        }
    }
    
    @Override
    public boolean deleteElement(T elementToDelete)
    {
    	boolean response = false;
    	if(root != null) {
    		Node<T> current = root;
    		Node<T> previous = null;
    		while(!current.getElement().equals(elementToDelete)) {
    			if(current.getNext() != null) {
					previous = current;
					current = current.getNext();
				} else {
					break;
				}
    		}
    		if(current.getElement().equals(elementToDelete)) {
				if(previous == null) {
					if(root.getNext() != null) {
						root = current.getNext();
					} else {
						root = null;
					}
				} else {
					previous.setNext(current.getNext());
				}
				response = true;
			}
    	}
    	return response;
    }
	
	@Override
	public T deletePosition(int position) 
	{
		T response = null;
		if(position >= 0 && position < getLength()) {
			if(position == 0) {
				response = root.getElement();
				if(root.getNext() != null) {
					root = root.getNext();
				} else {
					root = null;
				}
			} else {
				Node<T> temp = root;
				Node<T> previous = null;
				for(int c = 0; c <= position-1; c++) {
					previous = temp;
					temp = temp.getNext();
				}
				response = temp.getElement();
				if(temp.getNext() != null) {
					previous.setNext(temp.getNext());
				} else {
					previous.setNext(null);
			}
			}
		}
		return response;
	}

	@Override
	public int getLength() {
		int cont = 0;
		if(root != null) {
			cont++;
			Node<T>temp= root;
			while(temp.getNext()!=null) {
				cont++;
				temp= temp.getNext();
			}
		}
		return cont;
	}

	@Override
	public int getElementPosition(T elementToFind) {
		int pos=0;
		Node<T>temp= root;
		while(!temp.getElement().equals(elementToFind) && temp.getNext()!=null) {
			pos++;
			temp= temp.getNext();
		}
		if(!temp.getElement().equals(elementToFind)) {
			pos=-1;
		}
		return pos;
	}

	@Override
	public T getElementByPosition(int position) {
		T response = null;
		if(position >= 0 && position < getLength()) {
			Node<T> temp = root;
			for(int c = 0; c <= position-1; c++) {
				temp = temp.getNext();
			}
			response = temp.getElement();
		}
		return response;
	}

	@Override
	public boolean clearList() {
		boolean response = false;
		if(root != null) {
			root = null;
			response = true;
		}
		return response;
	}

	@Override
	public String showAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isEmpty()
	{
		boolean response = true;
		if(root != null) {response = false;} 
		return response;
	}


}
