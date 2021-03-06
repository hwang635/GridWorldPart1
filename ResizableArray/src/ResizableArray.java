import java.lang.reflect.Array;
import java.util.Arrays;

public class ResizableArray {

	private int[] data;
	private int size;

	private int INITIAL_LENGTH = 100;

	public ResizableArray() {
		data = new int[INITIAL_LENGTH];
		size = 0;
	}

	public void add(int value) {
		if(size >= INITIAL_LENGTH) {
			resize();
		}

		data[size] = value;
		size++;
	}

	//value is the number you want to get rid of
	public void removeAll(int value) {
		int numReal = 0;

		for(int i = 0; i<size; i++) {
			if(data[i] != value) {
				data[numReal] = data[i];
				numReal++;
			}
			else
				data[size-numReal+2] = 0;
		}
		size = numReal;
	}

	public void resize() {
		//creates a new, larger array
		//copies all element from data into new array
		//set the data field to the new array
		INITIAL_LENGTH += 100;
		int[] newData = new int[INITIAL_LENGTH];

		for(int i = 0; i<size; i++) {
			newData[i] = data[i];
		}

		data = newData;
	}

	//public void addAll(int[] data)
	//public fboolean equals(Object other
	//public int[] toArray() 

	//returns array[index] the value that was removed
	public int remove(int index) {
		int removed = data[index];

		if(index<0 || index>size-1) {
			throw new IllegalArgumentException("Bad index");
		}
		else {
			for(int i = index; i<size-1; i++) {
				data[i] = data[i+1];
			}
			
			size--;
		}

		return removed;

	}

	public int size() {
		return size;
	}

	public String toString() {
		String output = "[";
		for(int i = 0; i<size; i++) {
			if(i<size-1)
				output += (data[i] + ", ");
			else
				output += data[i];
		}
		output += "]";

		return output;
	}

	public void insert(int index, int value) {
		if(index<0 || index>=size) {
			throw new IllegalArgumentException("Bad index");
		}
		if(size >= INITIAL_LENGTH) {
			resize();
		}	
		for(int i = size; i>index; i--) {
			data[i] = data[i-1];
			//System.out.println("data[i+1], data[i]" + data[i+1] + " " + data[i]);
		} //end of loop
		size ++;

		data[index] = value;
		//end of big else
	}
	public int get(int index) {
		if(index<0 || index>=size) {
			throw new IllegalArgumentException("Bad index");
		}
		return data[index];
	}

	public void set(int index, int value) {
		if(index<0 || index>=size) {
			throw new IllegalArgumentException("Bad index");
		}
		data[index] = value;
	}

	public void sort() {
		//Arrays.sort(data, 0, size);
		for(int i = 0; i<size; i++) {
			for(int c = i; c<size; c++) {
				if(data[i] > data[c]) {
					int greater = data[i];
					data[i] = data[c];
					data[c] = greater;
				}
			} //end of small for
		} //end of i for
		
	}

	//finds the value's index in the array, returns -1 if not there
	public int indexOf(int value) {
		int count = -1;
		for(int i = 0; i<size; i++) {
			if(data[i] == value) {
				count = i;
				return count;
			}
		}
		
		return count;
	}

	//switches the values at the positions
	public void swap(int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	public boolean equals(Object other) {
		boolean output = true;

		ResizableArray otherArray = new ResizableArray();
		otherArray = (ResizableArray)other;

		if(otherArray.size() != size)
			output = false;
		for(int i = 0; i<size; i++) {
			if(data[i] != otherArray.get(i))
				output = false;
		}

		return output;
	}

	public int[] toArray() {
		int[] newData = new int[size];

		for(int i = 0; i<size; i++) {
			newData[i] = data[i];
		}

		return newData;
	}
}
