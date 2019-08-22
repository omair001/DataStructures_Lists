import java.util.*;

/**
 * The A1LinkedList is an implementation of the list interface using an linked
 * list. student number: 214719131. course: EECS 2011
 * 
 * @author Syed Omair Anwar
 * @version 19/06/2017
 */
public class A1LinkedList<E> implements List<E> {
	// fields - head and tail of the list
	private Node<E> head;
	private Node<E> tail;
	private int size;

	/**
	 * Constructor for objects of class A1LinkedList initializes size to 0;
	 * 
	 */
	public A1LinkedList() {
		size = 0;
	}

	/**
	 * Node class that will be used throughout the program
	 * 
	 * has an element, and next and prev nodes
	 * 
	 */
	private static class Node<E> {
		// fields element, next and prev nodes
		private E element;
		private Node<E> next;
		private Node<E> prev;

		/**
		 * constructor initializes fields as passed in parameters
		 * 
		 * * @param e is the element to add * @param n is next node * @param p
		 * is previous node
		 */
		public Node(E e, Node<E> n, Node<E> p) {
			this.element = e;
			this.next = n;
			this.prev = p;
		}

	}

	/**
	 * add method- this add method adds an element to the end of the list
	 * 
	 * @param e
	 *            is the element to add
	 * 
	 * @throws IllegalArgumentException
	 */
	@Override
	public boolean add(E e) throws IllegalArgumentException {
		// if no elements, create new node and make that the head and tail
		if (size == 0) {
			Node<E> newNode = new Node<E>(e, null, null);
			head = newNode;
			tail = newNode;
		}
		// otherwise add this to tail, with prev pointer pointing at tail
		// and element e. change current last's next pointer and move
		// tail to newest element
		else {
			Node<E> newNode = new Node<E>(e, null, tail);
			tail.next = newNode;
			tail = newNode;
		}
		// increase size and return true at the end of the method
		size++;
		return true;
	}

	/**
	 * add method- this add method adds an element to the index of the list
	 * 
	 * @param e
	 *            is the element to add
	 * @param index
	 *            is the index at which we add the element
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void add(int index, E e) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// if no elements and index is 0 add element and make it head and tail
		if (size == 0 && index == 0) {
			Node<E> newNode = new Node<E>(e, null, null);
			head = newNode;
			tail = newNode;
		} else {
			// if index is 0, add new element to head and change head to this
			// element
			if (index == 0) {
				Node<E> newNode = new Node<E>(e, head, null);
				head.prev = newNode;
				head = newNode;
			}
			// if index is last element, append and update tail
			else if (index == size) {
				Node<E> newNode = new Node<E>(e, null, tail);
				tail.next = newNode;
				tail = newNode;
			}
			// create a new node, if index is less than middle use head to get
			// to it,
			// otherwise use tail
			else {
				Node<E> currNode;
				if (size / 2 > index) {
					currNode = head;
					for (int i = 0; i < index; i++) {
						currNode = currNode.next;
					}
				} else {
					currNode = tail;
					for (int i = size - 1; i > index; i--) {
						currNode = currNode.prev;
					}
				}
				// if current node is tail, add this so it is now the second
				// last
				// next is tail and previous is previously second last element,
				// change next and previous nodes for the adjacent nodes so that
				// it is correctly added
				if (currNode == tail) {

					Node<E> newNode = new Node<E>(e, tail, currNode.prev);
					currNode.prev.next = newNode;
					currNode.prev = newNode;
				}
				// if current node is head, add this to front and update the
				// head
				else if (currNode == head) {
					System.out.println(index);
					Node<E> newNode = new Node<E>(e, head, null);
					currNode.prev = newNode;
					head = newNode;
				}
				// otherwise, insert node between two existing ones. change
				// their
				// next and prev nodes to new node, while references to these
				// nodes
				// was pased in the parameters of the constructor of this node
				else {
					Node<E> newNode = new Node<E>(e, currNode, currNode.prev);
					currNode.prev.next = newNode;
					currNode.prev = newNode;
				}
			}
		}
		// increase size
		size++;

	}

	/**
	 * toString method- string representation of list
	 * 
	 *
	 * @return string representation
	 */
	public String toString() {
		// uses a string builder to build a list that has square brackets
		// and elements separated by comma
		StringBuilder s = new StringBuilder("");
		s.append("[");
		Node<E> tmp = head;
		while (tmp != tail) {
			s.append(String.valueOf(tmp.element));
			s.append(", ");
			tmp = tmp.next;
		}
		// if tail is not null adds tail to string without comma
		if (tail != null) {
			tmp = tail;
			s.append(String.valueOf(tmp.element));
		}
		s.append("]");
		return s.toString();

	}

	/**
	 * Clear method- empties the list by simply removing references to list and
	 * allowing garbage cvollector to clean. sets size to 0
	 * 
	 *
	 * @return string representation
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;

	}

	/**
	 * indexOf- returns the index of an element
	 * 
	 * @param o
	 *            object to check
	 *
	 * @return int index of object
	 * @throws NullPointerException
	 */
	@Override
	public int indexOf(Object o) throws NullPointerException {

		if (o == null) {
			throw new NullPointerException();
		}

		// starts at head and checks every element, returns index if found
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (o.equals(current.element)) {
				return i;
			}
			current = current.next;
		}
		// otherwise -1 if not found
		return -1;
	}

	/**
	 * isEmpty method- checks to see if method is empty, returns true otherwise
	 * returns false
	 * 
	 *
	 * @return boolean value for string
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * remove method- removes an object from list
	 * 
	 *
	 * @return boolean value for whether or not removed
	 * @throws NullPointerException
	 */
	@Override
	public boolean remove(Object o) throws NullPointerException {
		// if object not in list, returm -1
		if (this.indexOf(o) == -1)
			return false;
		// otherwise call remove with the index of the object
		else {
			this.remove(indexOf(o));
		}
		// returns true
		return true;

	}

	/**
	 * remove method- removes an object from list
	 * 
	 * @param index
	 *            at which object is located
	 * @return E element removed
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// throw exception if not in bounds
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		// returns nothing if list is empty
		if (isEmpty()) {
			return null;
		}
		// if only one element, get element, and make head and tail null
		// decrease size and return node
		if (head == tail) {
			Node<E> currNode = head;
			head = null;
			tail = null;
			size--;
			return currNode.element;
		}
		// if first element, get element, move head up by one and change its
		// prev pointer to null
		// decrease size and return node
		if (index == 0) {

			Node<E> currNode = head;
			head = head.next;
			head.prev = null;
			size--;
			return currNode.element;
		}
		// if last element, get element, move tail back by one and change its
		// next pointer to null
		// decrease size and return node
		else if (index == size - 1) {
			Node<E> currNode = tail;
			tail = tail.prev;
			tail.next = null;
			size--;
			return currNode.element;

		}
		// otherwise check if index is in first half or second, get element
		// from head or tail, whichever it is closer to
		// next reference of previous to the next of current node and prev
		// of next node to prev of current to bypass the element
		// decrease size and return node
		else {
			Node<E> currNode;
			if (size / 2 > index) {
				currNode = head;
				for (int i = 0; i < index; i++) {
					currNode = currNode.next;
				}
			} else {
				currNode = tail;
				for (int i = size - 1; i > index; i--) {
					currNode = currNode.prev;
				}
			}
			currNode.prev.next = currNode.next;
			currNode.next.prev = currNode.prev;
			size--;
			return currNode.element;
		}

	}

	/**
	 * Size method returns size of list
	 * 
	 */
	@Override
	public int size() {

		return this.size;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) throws NullPointerException {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) throws NullPointerException, IndexOutOfBoundsException {

		return false;
	}

	@Override
	public boolean contains(Object o) throws ClassCastException, NullPointerException {

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) throws ClassCastException, NullPointerException {

		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + size;
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		A1LinkedList<E> other = (A1LinkedList<E>) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (size != other.size)
			return false;
		if (tail == null) {
			if (other.tail != null)
				return false;
		} else if (!tail.equals(other.tail))
			return false;
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		return null;

	}

	@Override
	public Iterator<E> iterator() {

		return null;
	}

	@Override
	public int lastIndexOf(Object o) throws ClassCastException, NullPointerException {

		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException {

		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c)
			throws UnsupportedOperationException, ClassCastException, NullPointerException {

		return false;
	}

	@Override
	public E set(int index, E element) throws UnsupportedOperationException, ClassCastException, NullPointerException,
			IllegalArgumentException, IndexOutOfBoundsException {

		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {

		throw new IndexOutOfBoundsException();
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) throws ArrayStoreException {
		throw new NullPointerException();
	}
}
