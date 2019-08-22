import java.util.*;

/**
 * The A1 Arraylist is an implementation of the list interface using an array.
 * student number: 214719131. course EECS 2011
 * 
 * @author Syed Omair Anwar
 * 
 * @version 19/06/2017
 */
public class A1ArrayList<E> implements List<E> {
	// size, array to use, initial capacity
	private int size;
	private Object newArr[];
	private static final int DEFAULT_CAP = 8;

	/**
	 * A1ArrayList() - constructor makes empty arraylist of default size
	 * 
	 */
	@SuppressWarnings("unchecked")
	public A1ArrayList() {
		this.newArr = (E[]) new Object[DEFAULT_CAP];
		this.size = 0;
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = null;
		}
	}

	/**
	 * Add- adds an element to end of arraylist, increases size if necessary
	 * 
	 * @param e
	 *            is the element to add
	 * 
	 * @return true if successfully added, false if not
	 * @throws IllegalArgumentException
	 */
	@Override
	public boolean add(E e) throws IllegalArgumentException {
		// checks capacity and increases size if necessary
		checkCap();
		// adds new element to end of list and increases size
		newArr[size] = e;
		this.size++;
		// returns true
		return true;
	}

	/**
	 * Add - adds an element to end of arraylist, increases size if necessary
	 * 
	 * @param e
	 *            is the element to add
	 * @param index
	 *            the position to add element
	 * 
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public void add(int index, E element)
			throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
		// verifies that index is not out of bounds and verifies capacity
		checkIndex(index);
		checkCap();
		// shifts all elements after the index to make room then adds
		// new element to the array, then increases size
		for (int i = size - 1; i >= index; i--) {
			newArr[i + 1] = newArr[i];
		}
		newArr[index] = element;
		size++;

	}

	/**
	 * toString() - returns a string representation of arraylist
	 * 
	 * 
	 * @return string representation
	 * 
	 */
	public String toString() {
		// creates a stringbuilder with square brackets and elements separated
		// by commas
		StringBuilder s = new StringBuilder("");
		s.append("[");
		for (int i = 0; i <= size - 2; i++) {
			s.append(newArr[i]);
			s.append(", ");
		}
		if (size > 0) {
			// appends last element separately since no comma after
			s.append(newArr[size - 1]);
		}
		s.append("]");
		return s.toString();

	}

	/**
	 * clear - clears arraylist
	 * 
	 * 
	 * 
	 */
	@Override
	public void clear() {
		// goes through array and sets values to null and size to 0
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = null;
		}
		size = 0;

	}

	/**
	 * removes an object from arraylist
	 * 
	 * @param object
	 *            to remove
	 * @return true if removed, otherwise false
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public boolean remove(Object o) throws NullPointerException {
		// returns false if not in list
		if (this.indexOf(o) == -1)
			return false;
		else {
			// calls the remove function that takes in index
			// passes in of the object as a parameter
			this.remove(indexOf(o));
		}
		// returns true if found and removed
		return true;
	}

	/**
	 * checks index
	 * 
	 * @param index
	 *            to check
	 * 
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	private void checkIndex(int index) {
		// if index is outside range, throw exception
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * removes an element using index
	 * 
	 * @param index
	 *            at which we must remove element
	 * @return element we are removing
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException, ClassCastException {
		// check index
		checkIndex(index);

		// set return value
		@SuppressWarnings("unchecked")
		E retE = (E) newArr[index];
		// moving all subsequent values back by one to remove unwanted value
		for (int i = index; i < size - 1; i++) {
			newArr[i] = newArr[i + 1];
		}
		// set last value of arraylist to null as we have removed an element
		// and decrease size
		newArr[size - 1] = null;
		size--;

		// if array is less than a quarter full, half its size
		// the defaulr capacity being the lower bound
		if (size > 0) {
			if ((double) ((newArr.length) / size) < 0.25) {
				if (newArr.length / 2 < DEFAULT_CAP - 1) {
					Object tempArr[] = newArr;
					this.newArr = Arrays.copyOf(tempArr, DEFAULT_CAP);
				} else {
					Object tempArr[] = new Object[newArr.length / 2];
					for (int i = 0; i < size; i++) {
						tempArr[i] = newArr[i];
					}
					this.newArr = tempArr;

				}

			}
		}
		// return element
		return retE;
	}

	/**
	 * gets element
	 * 
	 * @param index
	 *            of element to get
	 * @return element
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		return (E) newArr[index];

	}

	/**
	 * doubles size if necessary
	 * 
	 */
	private void checkCap() {

		if (size > 0) {

			if (size == newArr.length) {

				Object tempArr[] = newArr;
				newArr = Arrays.copyOf(tempArr, (tempArr.length * 2));

			}

		}
	}

	/**
	 * gets index of element
	 * 
	 * @param object
	 *            to check
	 * @return -1 if not in list, index if it is
	 * 
	 * @throws NullPointerException
	 */
	@Override
	public int indexOf(Object o) throws NullPointerException {
		if (o == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < size; i++) {
			if (o.equals(newArr[i])) {

				return i;
			}

		}
		return -1;

	}

	/**
	 * returns size
	 * 
	 * @return size
	 */
	@Override
	public int size() {

		return this.size;
	}

	/**
	 * returns true if arraylist empty
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * the rest are default methods in the interface that we did not need to
	 * implement
	 */
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
		result = prime * result + Arrays.hashCode(newArr);
		result = prime * result + size;
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
		A1ArrayList<E> other = (A1ArrayList<E>) obj;
		if (!Arrays.equals(newArr, other.newArr))
			return false;
		if (size != other.size)
			return false;
		return true;
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
