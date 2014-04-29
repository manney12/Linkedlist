
/**
 *
 */
/**
 * Main class that has the test method
 *
 * @author O.Emmanuel.OGAH
 * @param <T>
 */
public class LinkedSet<T> implements SetInterface<T> {

    public static void main(String[] args) {
        SetInterface<String> first = new LinkedSet<>();
        SetInterface<String> second = new LinkedSet<>();
        SetInterface<String> union = new LinkedSet<>();
        SetInterface<String> intersection = new LinkedSet<>();
        SetInterface<String> difference = new LinkedSet<>();
        SetInterface<String> difference2 = new LinkedSet<>();
// content of the list being added 
        first.add("bob");
        first.add("bill");
        first.add("tom");
        first.add("bill");

        System.out.println("Contents of first set:\n " + first.toString());

        second.add("alf");
        second.add("tom");
        second.add("zee");
        second.add("tom");
        System.out.println("\nContents of second set:\n " + second.toString());

        // System.out.println("union" + second.getFrequencyOf("tom"));

        //The union of the first and second sets 
        union = first.union(second);
//The union  if the first and the second  set
        System.out.println("\nunion of first set and second set  ");
        System.out.println(union);
// The intersect of  the first and second set 
        System.out.println("\nIntersection of the first set and second set ");
        intersection = first.intersection(second);
        System.out.println(intersection.toString());
// The difference of the first and second set
        System.out.println("\nDifference of the first set and second set \n ");
        difference = first.difference(second);
        difference2 = second.difference(first);
        System.out.println(difference.toString());
        System.out.println(difference2.toString());
       
        // current size of List
        System.out.println("Current size of first set: " + first.getCurrentSize()+"\n");
        System.out.println("Current size of second set: " + second.getCurrentSize()+"\n");
        System.out.println("");
        //Frequency of List
        System.out.println("Frequency of \"bill\" in first set: " + first.getFrequencyOf("bill"));
        System.out.println("Frequency of \"tom\" in second set: " + second.getFrequencyOf("tom"));
        System.out.println("");
//items in contained in list?
        System.out.println("If first set has \"tom\"? : " + first.contains("tom"));
        System.out.println("If second set has \"sam\"? : " + second.contains("bill"));
        System.out.println("");
        //removing an item from the availiable list 
        System.out.println(first.remove("bill"));
        System.out.println("First now contains: " + first);
        System.out.println(second.remove("tom"));
        System.out.println("Second now contains: " + second+"\n");
        
        //removes  certain item from the list 
        System.out.println("Removing a certain  entry from first bag \""+ first.remove());
        System.out.println("First only contains: " + first+"\n");
        System.out.println("Removing a certain entry from second bag  \"" + second.remove());
        System.out.println("Second only contains: " + second+"\n");
        
       
        
        
    }

    /**
     * The private method Node This is to create the information on the null
     */
    private class Node {

        /**
         * Two private methods to not change or tamper with the T data and Node
         * next
         */
        private T data;
        private Node next;

        private Node(T value) {
            data = value;
            next = null;
        }

        private Node(T value, Node n) {
            data = value;
            next = n;
        }
    }
    /*
     * Two private Node and size  that cannot be accessed 
     */
    private Node front;
    private int size;

    /**
     * private method to get reference to and is used by the remove class pre:
     * Should contain already a Node. post:The reference Node of the
     *
     * @param anEntry to be referenced 
     * @return currentNode
     */
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = front;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }


        }
        return currentNode;
    } //end of getReferenceTo

    /**
     * Default constructor of the LinkedSet
     */
    public LinkedSet() {
        front = null;
        size = 0;
    }

    /**
     * creates union as it passes through each node and also keeps track of it
     * with current node 
     * pre:None 
     * post:None
     * @param anEntry that is added to a union set
     * @return current node
     */
    @Override
    public SetInterface<T> union(SetInterface<T> anEntry) {
        // what does this do is to add the first set to the second and second to the first
        // The the add method already has the  way to  detect  duplicate
        T array[];
        array = (T[]) anEntry.toArr();
        T s[] = (T[]) this.toArr();
        LinkedSet curr = new LinkedSet();

        for (int i = 0; i < array.length; i++) {
            curr.add(array[i]);
        }

        for (int i = 0; i < s.length; i++) {
            curr.add(s[i]);
        }



        return curr;
// return with curr 
    }

    /**
     * creates intersection as it passes through each node and also keeps track
     * of it with current node and then sees which is in both sets. pre:None
     * post:None
     *
     * @param anEntry that is added into the intersection set that contains things from both set 
     * @return finalset
     */
    @Override
    public SetInterface<T> intersection(SetInterface<T> anEntry) {
        // create final set from a new LinkedSet
        SetInterface<T> finalSet = new LinkedSet<>();
        // refernce the front of the node to  be turned to a variable of  naming to curr 
        Node curr = this.front;
        // A T arrary temp is created from an added item  that is verified to toArray hold the information.
        T[] temp = anEntry.toArr();
// loops through the temp T[] and calls in the contain method and see if an element is contained in the temp 
        // then it should add the element  to the final sent from the element in the temp i
        for (int i = 0; i < temp.length; i++) {
            if (this.contains(temp[i])) {
                finalSet.add(temp[i]);
            }
            // then it returns the final set that has the added element 
        }
        return finalSet;

    }

    /**
     * Difference is what in set A but not in set B 
     * pre: None 
     * post:None
     *
     * @param anEntry that will be used to find the difference in the entry
     * @return SetInterface<T> that has the analyzed difference
     */
    @Override
    public SetInterface<T> difference(SetInterface<T> anEntry) {
        //A T array is being made to  hold the information.
        T array[];
        // array is being reference to T that is included with an item coming into the method
        // which calls in the toArray method 
        array = (T[]) anEntry.toArr();
        // T array S is being referenced to the data of the  toArray  that is from this class 
        T[] s = (T[]) this.toArr();
        //A new LinkedSet is created  named curr 

        LinkedSet curr = new LinkedSet();
        // for loop is formed to go  through the length of S 

        for (int i = 0; i < s.length; i++) {
// picks out the entrty to see if it not is already in S  then

            if (anEntry.contains(s[i]) == false) {
                // curr will add it to S 
                curr.add(s[i]);
            } else {
                //else curr will be contained in S  for the i from the loop
                curr.contains(s[i]);
            }

        }
// returns the curr after it has been 
        return curr;
    }

    /**
     * The exact size of the list 
     * pre: None
     * post:None 
     *
     * @return size
     */
    public int getCurrentSize() {
        //intialize the number of nodes to 0 
        int nNodes = 0;
        // The current Node equals the front to the first node 
        Node currNode = front;
        // while  loop to create to im
        while (currNode != null) {
            nNodes++;
            currNode = currNode.next;
        }
        return nNodes;
    }

    /**
     * Full Method 
     * pre: Should not be empty
     * post:None
     *
     * @return false if it not fall else true
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Empty Method pre: Should not be full post:None
     *
     * @return Size
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /*used to add if the boolean is true
     * pre: Set should not be empty 
     * post:None
     * @param anEntry that would be added to the list
     * @returns a  true value if it has to add otherwise false
     */

    @Override
    public boolean add(T anEntry) {
        //construct a new node with data = anEntry
        //and next referencing the front
        int num = getCurrentSize();
//have an if statement  that uses the contain method that has the an Entry if false 
//then it  enters the  state and creates 
        if (this.contains(anEntry) == false) {
            Node newNode = new Node(anEntry);
            newNode.next = front;
            //update the front
            front = newNode;
            num++;
            return true;
        }
        return false;
    }

    /**
     * Remove method  that would remove a certain item
     * pre:Needs to contain an element in the sets 
     * post: One less than what was originally in the set
     *
     * @return result that has one element in the T generics
     */
    @Override
    // this removes an item from  the bag
    public T remove() {
        T result = null;
        if (this.front != null) {
            result = front.data;
            front = front.next;
            size--;
        }
        return result;
    }

    /**
     * Remove  an item if true otherwise does not if false
     * pre:Needs to contain an element 
     * post:none
     *
     * @param anEntry that would be 
     * @return Boolean result
     */
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = front.data;
            remove();
            result = true;
        }
        return result;
    }

    /** Clears the list when needed to.
     * pre: Needs to have an item
     * post:none
     */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag
     * pre: None
     * post:None
     *
     * @param anEntry the entry to be counted 
     * @return the number of times  anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int counter = 0;
        // node to create and keep track of it it
        Node currentNode = front;
        while ((currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                frequency++;
            }
            counter++;
            currentNode = currentNode.next;
        }//end of the while 
        return frequency;
    }

    /**See what is contained in the bag
     * 
     * pre: none 
     * post: none
     *
     * @param anEntry the entry that would be evaluated 
     * @return the presence of  an item if it is in the set
     */
    @Override
    public boolean contains(T anEntry) {
        // used if boolean is false\
        boolean found = false;
        Node currentNode = front;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }//end while
        return found;
    }

    /**
     * To string  to print out the statement 
     * pre:none
     * post:none
     *
     * @return string from the formation
     */
    @Override
    public String toString() {
        String str = "";
        Node curr = this.front;
        while (curr != null) {
            str += curr.data;
            str += " ";
            curr = curr.next;
        }
        return str;
    }

    /**
     * to array  that  is called into the need when an array is needed 
     * pre:none 
     * post:none
     *
     * @return What the form of what an array is going to be needed for 
     */
    @Override
    public T[] toArr() {
        //make an array that is this.size
        T[] result = (T[]) new Object[getCurrentSize()];
        //ref to iterate through data
        Node curr = front;
        int i = 0;
        while (curr != null) {
            result[i] = curr.data;
            i++;
            curr = curr.next;
        }
        return result;
    }
}