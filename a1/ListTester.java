import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * The List Tester is a class used to test the lists and see their execution
 * times in a table. student number: 214719131. course EECS 2011
 * 
 * @author Syed Omair Anwar
 * @version 19/06/2017
 */
public class ListTester {

	// main method
	public static void main(String args[]) {
		// create an array of N values to test then loop through and test each
		// of them
		Integer[] values = { 10, 100, 1000, 10000, 100000 };
		for (int i = 0; i < values.length; i++) {
			ListTester c = new ListTester();

			c.testN(values[i]);
		}

	}

	/**
	 * testN - this method tests the execution times of certain operations for
	 * each of these lists and displays the results in a table
	 * 
	 * @param N
	 *            is the integer that specifies how many elements to add
	 * 
	 */
	public void testN(int N) {
		// fields are the different times we will check for inserting to start,
		// end, or at a random spot, removing at start, end and random spot, and
		// removing by value
		long insStart;
		long insEnd;
		long insRnd;
		long rmStart;
		long rmEnd;
		long rmRnd;
		long rmVal;
		long startTime;
		long endTime;

		// random value to use
		Random rand = new Random();

		// string with header of table
		String s = String.format("N = %d: ms to Ins. start,   end,    rnd; Rmv. start,   end,    rnd; Rmv. by value",
				N);
		System.out.println(s);

		// 4 arraylists to test
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> arrList1 = new ArrayList<Integer>();
		ArrayList<Integer> arrList2 = new ArrayList<Integer>();
		ArrayList<Integer> arrList3 = new ArrayList<Integer>();

		// time to add at the front
		startTime = System.currentTimeMillis();
		arrList = (ArrayList<Integer>) add(N, rand, 0, 2);
		endTime = System.currentTimeMillis();
		insStart = (endTime - startTime);

		// time to add at the back
		startTime = System.currentTimeMillis();
		arrList1 = (ArrayList<Integer>) add(N, rand, 1, 2);
		endTime = System.currentTimeMillis();
		insEnd = (endTime - startTime);

		// time to add at random index
		startTime = System.currentTimeMillis();
		arrList2 = (ArrayList<Integer>) add(N, rand, 2, 2);
		endTime = System.currentTimeMillis();
		insRnd = (endTime - startTime);

		// populate last list
		arrList3 = (ArrayList<Integer>) add(N, rand, 0, 2);

		// get values for all remove operations
		rmStart = rmIndex(N, arrList, rand, 0);
		rmEnd = rmIndex(N, arrList1, rand, 1);
		rmRnd = rmIndex(N, arrList2, rand, 2);
		rmVal = rmObj(N, arrList3, rand);
		// string with results
		String a = String.format(
				"ArrayList%" + 12 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d", insStart,
				insEnd, insRnd, rmStart, rmEnd, rmRnd, rmVal);
		System.out.println(a);

		// 4 A1 arraylists
		A1ArrayList<Integer> a1ArrList = new A1ArrayList<Integer>();
		A1ArrayList<Integer> a2ArrList = new A1ArrayList<Integer>();
		A1ArrayList<Integer> a3ArrList = new A1ArrayList<Integer>();
		A1ArrayList<Integer> a1clone = new A1ArrayList<Integer>();

		// time to add at the front
		startTime = System.currentTimeMillis();
		a1ArrList = (A1ArrayList<Integer>) add(N, rand, 0, 0);
		endTime = System.currentTimeMillis();
		insStart = (endTime - startTime);

		// time to add at the back
		startTime = System.currentTimeMillis();
		a2ArrList = (A1ArrayList<Integer>) add(N, rand, 1, 0);
		endTime = System.currentTimeMillis();
		insEnd = (endTime - startTime);

		// time to add at random index
		startTime = System.currentTimeMillis();
		a3ArrList = (A1ArrayList<Integer>) add(N, rand, 2, 0);
		endTime = System.currentTimeMillis();
		insRnd = (endTime - startTime);

		// populate last list
		a1clone = (A1ArrayList<Integer>) add(N, rand, 0, 0);
		// get values for all remove operations
		rmStart = rmIndex(N, a1ArrList, rand, 0);
		rmEnd = rmIndex(N, a2ArrList, rand, 1);
		rmRnd = rmIndex(N, a3ArrList, rand, 2);
		rmVal = rmObj(N, a1clone, rand);
		// string with results
		String b = String.format(
				"A1ArrayList%" + 10 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d", insStart,
				insEnd, insRnd, rmStart, rmEnd, rmRnd, rmVal);
		System.out.println(b);
		// 4 linkedlists
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		LinkedList<Integer> linkedList1 = new LinkedList<Integer>();
		LinkedList<Integer> linkedList2 = new LinkedList<Integer>();
		LinkedList<Integer> linkedList3 = new LinkedList<Integer>();
		// time to add at the front
		startTime = System.currentTimeMillis();
		linkedList = (LinkedList<Integer>) add(N, rand, 0, 3);
		endTime = System.currentTimeMillis();
		insStart = (endTime - startTime);
		// time to add at the back
		startTime = System.currentTimeMillis();
		linkedList1 = (LinkedList<Integer>) add(N, rand, 1, 3);
		endTime = System.currentTimeMillis();
		insEnd = (endTime - startTime);
		// time to add at random index
		startTime = System.currentTimeMillis();
		linkedList2 = (LinkedList<Integer>) add(N, rand, 2, 3);
		endTime = System.currentTimeMillis();
		insRnd = (endTime - startTime);
		// populate last list
		linkedList3 = (LinkedList<Integer>) add(N, rand, 0, 3);
		// get values for all remove operations
		rmStart = rmIndex(N, linkedList, rand, 0);
		rmEnd = rmIndex(N, linkedList1, rand, 1);
		rmRnd = rmIndex(N, linkedList2, rand, 2);
		rmVal = rmObj(N, linkedList3, rand);
		// string with results
		String c = String.format(
				"LinkedList%" + 11 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d", insStart,
				insEnd, insRnd, rmStart, rmEnd, rmRnd, rmVal);
		System.out.println(c);
		// 4 a1linkedlists
		A1LinkedList<Integer> a1LinkedList = new A1LinkedList<Integer>();
		A1LinkedList<Integer> a2LinkedList = new A1LinkedList<Integer>();
		A1LinkedList<Integer> a3LinkedList = new A1LinkedList<Integer>();
		A1LinkedList<Integer> a1LinkedClone = new A1LinkedList<Integer>();
		// time to add at the front
		startTime = System.currentTimeMillis();
		a1LinkedList = (A1LinkedList<Integer>) add(N, rand, 0, 1);
		endTime = System.currentTimeMillis();
		insStart = (endTime - startTime);
		// time to add at the back
		startTime = System.currentTimeMillis();
		a2LinkedList = (A1LinkedList<Integer>) add(N, rand, 1, 1);
		endTime = System.currentTimeMillis();
		insEnd = (endTime - startTime);
		// time to add at random index
		startTime = System.currentTimeMillis();
		a3LinkedList = (A1LinkedList<Integer>) add(N, rand, 2, 1);
		endTime = System.currentTimeMillis();
		insRnd = (endTime - startTime);
		// populates last list
		a1LinkedClone = (A1LinkedList<Integer>) add(N, rand, 0, 1);
		// 4 remove operations
		rmStart = rmIndex(N, a1LinkedList, rand, 0);
		rmEnd = rmIndex(N, a2LinkedList, rand, 1);
		rmRnd = rmIndex(N, a3LinkedList, rand, 2);
		rmVal = rmObj(N, a1LinkedClone, rand);
		// results string
		String d = String.format(
				"A1LinkedList%" + 9 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d%" + 9 + "d%" + 8 + "d%" + 10 + "d%n%n",
				insStart, insEnd, insRnd, rmStart, rmEnd, rmRnd, rmVal);
		System.out.println(d);

	}

	/**
	 * The add method adds to the lists at different locations as specified
	 * 
	 * @param N
	 *            is the number of elements to add
	 * @param rand
	 *            is random number to add
	 * @param index
	 *            specifies the location to add
	 * @param lt
	 *            is the list type to know which type of list to create and
	 *            return
	 * 
	 * @return returns the list created so that it could be used by remove
	 *         operations
	 */
	public List<Integer> add(int N, Random rand, int index, int lt) {

		// creates an empty list
		List<Integer> list = null;
		// checks list type and creates the correct type of list
		if (lt == 0) {
			list = new A1ArrayList<Integer>();
		} else if (lt == 1) {
			list = new A1LinkedList<Integer>();
		} else if (lt == 2) {
			list = new ArrayList<Integer>();
		} else {
			list = new LinkedList<Integer>();
		}
		// adds N elements to the list
		for (int i = 1; i <= N; i++) {

			// values will range from 0 to 10N
			Integer a = rand.nextInt(10 * N);
			// checks index to see where to add them
			if (index == 0) {
				list.add(0, a);
			} else if (index == 1) {
				list.add(list.size(), a);
			} else {
				// if adds to front if 1 or 2 elements in list, otherwise adds
				// randomly
				int b;
				if ((list.size() == 0) || (list.size() == 1)) {
					b = 0;
				} else {
					b = rand.nextInt(list.size() - 1);
				}
				// add to list at that location
				list.add(b, a);
			}

		}
		// return list
		return list;

	}

	/**
	 * The rmIndex method removes using the index provided
	 * 
	 * @param N
	 *            is the number of elements to remove
	 * @param list
	 *            is the list to remove from
	 * @param rand
	 *            is random number
	 * @param lndex
	 *            specifies where to remove from
	 * 
	 * @return time it takes to perform operation in ms
	 */
	public long rmIndex(int N, List<Integer> list, Random rand, int index) {
		// current time
		long startTime = System.currentTimeMillis();

		// for N elements
		for (int i = 0; i < N; i++) {
			// remove from front
			if (index == 0) {
				list.remove(0);
			} else if (index == 1) {
				// remove from back
				list.remove(list.size() - 1);
			} else {
				// remove from random index, 0 if only 2 elements left
				int b;
				if ((list.size() == 0) || (list.size() == 1)) {
					b = 0;
				} else {
					b = rand.nextInt(list.size() - 1);
				}
				// remove
				list.remove(b);

			}
		}
		// end time
		long endTime = System.currentTimeMillis();

		// duration of operation
		return (endTime - startTime);
	}

	/**
	 * The rmObj method removes object specified from list
	 * 
	 * @param N
	 *            is the number of elements to remove
	 * @param list
	 *            is the list to remove from
	 * @param rand
	 *            is random number
	 * 
	 * @return time it takes to perform operation in ms
	 */
	public long rmObj(int N, List<Integer> list, Random rand) {
		// start time
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			// remove random integer between 0 and 10N
			Integer a = rand.nextInt(10 * N);
			list.remove(a);
		}
		// end time
		long endTime = System.currentTimeMillis();
		// return duration
		return (endTime - startTime);
	}
}