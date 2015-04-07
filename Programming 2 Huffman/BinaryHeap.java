//This program generates a set of random integers and inserts
//them into a min-heap and then returns the numbers in order
import java.util.Random;

public class BinaryHeap 
{
	
	public BinaryHeap(int capacity) 
	{
		currentSize = 0;
		array = new Comparable[capacity + 1];
	}

	public void insert(Comparable x) 
	{
		// percolate up
		int hole = ++currentSize;
		for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
			array[hole] = array[hole / 2];
		array[hole] = x;
	}

	public Comparable findMin()
	{
		if (isEmpty())
			return null;
		return array[1];
	}

	public Comparable deleteMin() 
	{
		if (isEmpty())
			return null;
		Comparable minItem = findMin();
		array[1] = array[currentSize--];
		percolateDown(1);
		return minItem;
	}

	public void buildHeap()
	{
		for (int i = currentSize / 2; i > 0; i--)
			percolateDown(i);
	}

	public boolean isEmpty()
	{
		return currentSize == 0;
	}

	private void percolateDown(int hole) 
	{
		int child;
		Comparable tmp = array[hole];
		
		for (; hole * 2 <= currentSize; hole = child) 
		{
			child = hole * 2;
			if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
				child++;
			if (array[child].compareTo(tmp) < 0)
				array[hole] = array[child];
			else
				break;
		}
		array[hole] = tmp;
	}

	public Comparable[] getArray()
	{
		return array;
	}
	
	public int getSize()
	{
		return currentSize;
	}
	
	private int currentSize; // Number of elements in heap
	private Comparable[] array; // The heap array
}
