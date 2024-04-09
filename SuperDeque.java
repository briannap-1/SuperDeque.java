/**
 * @author Brianna Penkala
 * This class represents a deque
 */

public class SuperDeque <E> {

    /** A field that tracks the front of the deque */
    private int front;
    /** A field that tracks the back of the deque */
    private int back;
    /** A field for the array of the deque */
    private E[] dq;
    /** A field that sets the initial capacity of the deque */
    private static final int DEFAULT_CAP = 1;

    /** A method that returns the length of the deque array
     * @return the length of the deque
     * */
    int getDQLength() {
        return this.dq.length;
    }

    /** The constructor for the deque */
    public SuperDeque() {
        this.dq = (E[]) new Object[DEFAULT_CAP];
        this.front = -1;
        this.back = -1;
    }

    /** A method that adds an element to the front of the deque
     * @param element the element to add to the front of the deque
     * */
    public void push(E element) {
        if (front == (back + 1) % dq.length) { //if array full
            doubleSize();
        }
        else if (front == -1) { //initializes circular array
            front = 0;
            back = 0;
        }
        if (front == 0) //if front reaches the end of the circle, moves it to the other end
            front = dq.length - 1;
        else
            front--;
        dq[front] = element;
    }

    /** A method that removes an element from the front of the deque
     * @return the element removed
     * */
    public E pop() {
        if (isEmpty())
            return null;
        else {
            E save = dq[front];
            dq[front] = null;
            front = (front + 1) % dq.length;
            return save;
        }
    }

    /** A method that returns the first element in the deque
     * @return the element at the front of the deque
     * */
    public E peek() {
        if (isEmpty())
            return null;
        else
            return dq[front];
    }

    /** A method that adds an element to the back of a deque
     * @param element the element to add to the back of the deque
     * */
    public void enqueue(E element) {
        if (front == (back + 1) % dq.length) { //if array full
            doubleSize();
            back++;
        }
        else if (front == -1) { //initializes circular array
            front = 0;
            back = 0;
        }
        else
            back++;
        dq[back] = element;
    }

    /** A method that removes an element from the front of the deque
     * @return the element removed from the deque
     * */
    public E dequeue() {
        if (isEmpty())
            return null;
        else {
            E save = dq[front];
            dq[front] = null;
            front = (front + 1) % dq.length;
            return save;
        }
    }

    /** A method that checks if a deque is empty
     * @return true if the deque is empty
     * */
    public boolean isEmpty() {
        return dq.length < 1;
    }

    /** A method that doubles the size of the deque **/
    private void doubleSize() {
        int currentLength = dq.length;
        int newLength = currentLength * 2;
        E[] newArray = (E[]) new Object[newLength];

        if (dq.length == 1) //if array has just been initialized, only has one element
            newArray[0] = dq[front];
        else {
            for (int i = 0; i < currentLength; i++) { //add all elements to the new array
            newArray[i] = dq[front];
            front = (front + 1) % currentLength;
        }
            }
        front = 0;
        back = currentLength - 1;
        dq = newArray;
    }

    /** A method that converts the deque to a string
     * @return the string version of the deque
     * */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i != dq.length; i++) { //goes through array
            int index = (front + i) % dq.length; //helps to specify the element at the index
            if (builder.length() >= 1 && dq[index] != null) //if there are proceeding elements
                builder.append(", ");
            if (dq[index] != null) {
                builder.append(dq[index]);
            }
        }
        return builder.toString();
    }
 }