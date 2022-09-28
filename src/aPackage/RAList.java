package aPackage;

/**
 * Demonstrating inserting and deleting from an array while keeping all data
 * packed to the front of the array
 * 
 * This is less full-featured than a true ArrayList implementation
 * would be and is intended for demonstration purposes only
 * @author gosnat/albing
 * @version 1.2b
 *
 * @param <T> type of data you're storing
 */
public class RAList<T>
{
    
    /** The underlying array that we're storing data in;
     *  must be "left-justified" - lowest indicies, no gaps
     */
    private T[] data;
    
    /** The number of elements currently being stored */
    private int size;
    
    /**
     * Constructor
     * @param capacity max number of elements we can store in this array
     * @throws IllegalArgumentException if capacity isn't positive
     */
    public
    RAList(int capacity) throws IllegalArgumentException
    {
    	if (capacity <= 0) {
    		throw new IllegalArgumentException("Capacity must be positive.");
    	}
    	size = 0;
    	data = (T[])(new Object[capacity]);

    } // RAList constructor
    
    /**
     * Insert a new item at the requested index
     * @param item data to insert
     * @param index index where you want this data to live
     * @throws IllegalArgumentException out of bounds index, or
     * 	array is full, or requested index would leave a gap 
     */
    public void
    insert(T item, int index) throws IllegalArgumentException
    {
	//TODO insert data at requested index,
	//moving items down to make room as needed
    	if (index < 0 || index > size) {
    		throw new IllegalArgumentException("Index out of bounds.");
    	}
    	if (size > data.length) {
    		throw new IllegalArgumentException("Array is full.");
    	}
    	
    	for (int i = size; i > index; i--) {
    		data[i] = data[i+1];
    	}
    	data[index] = item;
    	size++;


    } // insert
    
    /**
     * Delete the requested item from the array.
     * In case of duplicates, the item with
     * the lowest index is the one that will be deleted
     * @param item item you want deleted
     * @throws IllegalArgumentException if requested item isn't present.
     */
    public void 
    delete(T item) throws IllegalArgumentException
    {
	//TODO Find and delete requested item
    	for (int i = 0; i < size; i++) {
    		if (data[i].equals(item)) {
    			data[i] = null;
    			for (int j = i+1; j < size; j++) {
    				data[j-1] = data[j];
    			}
    			size--;
    		}
    	}

    } // delete
    
    /** Just to get an easy peek inside */
    @Override
    public String
    toString()
    {
	    String result = "";
	    for(int i = 0; i < size; i++) {
		    result += data[i] + " ";
	    }
	    return result;
    } // toString

} // class RAList