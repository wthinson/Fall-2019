package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {

	Node sentinel; //this will be the entry point to your linked list (the head)
	int length = 0;
	public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
		sentinel = new Node(0); //Note that the root's data is not a true part of your data set!
		//length = 0;
	}

	//implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
		return sentinel;
	}

	@Override
	public boolean insert(double elt, int index) {
		// TODO Auto-generated method stub

		if (index > this.size() || index < 0) {
			return false;
		} 


		if (length == 0) {
			Node starterNode = new Node(elt);
			sentinel.next = starterNode;
			sentinel.prev = starterNode;
			starterNode.next = sentinel;
			starterNode.prev = sentinel;
			length++;
			return true;

		} else {

			Node newNode = sentinel.next;
			int nodeCunt = 0;

			while (newNode != sentinel) {
				if (nodeCunt < index ) {
					newNode = newNode.next;
					nodeCunt++;
				} else {
					break;
				}
			}
			Node newerNode = new Node(elt);
			newerNode.prev = newNode.prev;
			newNode.prev = newerNode;
			newerNode.prev.next = newerNode;
			newerNode.next = newNode;

			length++;

			return true;
		}
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if (index > this.size()-1 || index < 0) {
			return false;
		}

		Node newNode = sentinel.next;

		// Find previous node of the node to be deleted 
		for (int i = 0; i < index; i++) {
			newNode = newNode.next; 
		}

		newNode.next.prev = newNode.prev;
		newNode.prev.next = newNode.next;
		
		length--;

		return true;
	}

	@Override
	public double get(int index) {
		// TODO Auto-generated method stub

		if (index > this.size() || index < 0) {
			return Double.NaN;
		}
		if (length == 0) {
			return Double.NaN;
		}

		Node newNode = sentinel.next;
		int node_count = 0;

		while (newNode != sentinel) {
			if (node_count < index ) {
				newNode = newNode.next;
				node_count++;
			} else {
				break;
			}
		}

		return newNode.data;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (length== 0) {
			return true;
		}
		return false;

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		length = 0;
		
		sentinel.next = null;
		sentinel.prev = null;

	}

}
