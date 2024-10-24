/*
 * Student information for assignment: 
 * On my honor, Shikhar Joshi, this programming assignment is my own work
 * and I have not provided this code to any other student. 
 * UTEID: shj577
 * email address: shikharhjoshi@utexas.edu
 * Number of slip days I am using: 1
 */

import java.util.Iterator;

public class LL314<E> implements IList<E> {
    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements. 
    // No ArrayLists or Java LinkedLists.
    private DoubleListNode<E> head;
    private DoubleListNode<E> tail;
    private int size;

    // CS314 students, add constructors here:

    // O(1)
    public LL314() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    // O(1)
    public LL314(DoubleListNode node) {
        this.size = 1;
        this.head = node;
        this.tail = node;
    }

    // CS314 students, add methods here:

    /**
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list,
     * item != null
     */
    // O(n)
    public void add(E item) {
        if (item == null) {
            throw new IllegalArgumentException("cannot have null parameter");
        }

        if (size == 0) {
            DoubleListNode<E> node = new DoubleListNode<>(null, item, null);
            head = node;
            tail = node;
        } else {
            DoubleListNode<E> node = new DoubleListNode<>(tail, item, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a position >= pos have a
     * position = old position + 1
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list, item != null
     */
    // O(n)
    public void insert(int pos, E item) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("pos out of bounds");
        }
        if (item == null) {
            throw new IllegalArgumentException("item can't be null");
        }

        // insert @ beginning
        if (pos == 0) {
            // use addFirst()
            addFirst(item);
        }
        // insert @ end
        else if (pos == size) {
            // use addLast()
            addLast(item);
        }
        // insert in the middle
        else {
            // start @ head/tail depending on pos (optimization)
            DoubleListNode<E> curr;
            if (pos < size / 2) {
                curr = head;
                for (int i = 0; i < pos - 1; i++) {
                    curr = curr.next;
                }
            } else {
                curr = tail;
                for (int i = size - 1; i >= pos; i--) {
                    curr = curr.prev;
                }
            }

            // create the new node
            DoubleListNode<E> newNode = new DoubleListNode<>(curr, item, curr.next);

            // update links of surrounding nodes
            curr.next.prev = newNode;
            curr.next = newNode;

            // increment size
            size++;
        }
    }


    /**
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     * item != null
     * @return the old data at the specified position
     */
    // O(n)
    public E set(int pos, E item) {
        if (item == null) {
            throw new IllegalArgumentException("item cant be null");
        }
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("pos out of bounds");
        }

        DoubleListNode<E> curr;

        // start from head or tail depending on position (to optimize)
        // thats why we have a double linked list lol
        if (pos < size / 2) {
            curr = head;
            for (int i = 0; i < pos; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > pos; i--) {
                curr = curr.prev;
            }
        }

        // save old data
        E oldData = curr.data;

        // replace data at position pos
        curr.data = item;

        return oldData;
    }

    /**
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
    // O(n)
    public E get(int pos) {
        DoubleListNode<E> curr;

        // start from head or tail depending on position (to optimize)
        // thats why we have a double linked list lol
        if (pos < size / 2) {
            curr = head;
            // from head forwards
            for (int i = 0; i < pos; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            // from tail backwards
            for (int i = size - 1; i > pos; i--) {
                curr = curr.prev;
            }
        }

        return curr.data;
    }

    /**
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a position > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
    // O(n)
    public E remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Position out of bounds");
        }

        DoubleListNode<E> curr;

        // locate node @ pos
        if (pos == 0) {
            // remove head and move on, special case
            curr = head;
            head = head.next;

            // if head.next was null, then set the tail to null thus emptying list
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (pos == size - 1) {
            // remove current tail and move tail down 1, special case
            curr = tail;
            tail = tail.prev;

            // if the tail is null, then empty list
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            // traverse list depending on if pos is in first or second half
            if (pos < size / 2) {
                // start @ head bc pos in first half
                curr = head;
                for (int i = 0; i < pos; i++) {
                    curr = curr.next;
                }
            } else {
                // start @ tail bc pos in second half
                curr = tail;
                for (int i = size - 1; i > pos; i--) {
                    curr = curr.prev;
                }
            }

            // adjust links of the surrounding nodes
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        // update size and return the removed nodes data
        size--;
        return curr.data;
    }

    /**
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurrence
     * has been removed and size() = old size() - 1.
     * If obj is not present the list is not altered in any way.
     * @param obj The item to remove from this list. obj != null
     * @return Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     */
    // O(n)
    public boolean remove(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("parameter cannot be null");
        }

        Iterator<E> iter = this.iterator();

        // while in the list
        while(iter.hasNext()) {
            E data = iter.next();
            // found the correct node
            if (data.equals(obj)) {
                // remove, and then exit
                iter.remove();
                return true;
            }
        }

        return false;
    }

    /**
     * Return a sublist of elements in this list
     * from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start
     * and contains the elements at positions start through stop - 1
     * in this list.
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element
     * of the sublist.
     * @return a list with <tt>stop - start</tt> elements,
     * The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     * If start == stop an empty list is returned.
     */
    // O(n)
    public IList<E> getSubList(int start, int stop) {
        if (start < 0 || stop > size || start > stop) {
            throw new IndexOutOfBoundsException("invalid start or stop pos");
        }
        LL314<E> subList = new LL314<>();

        if (start == stop) {
            // start == stop, return an empty list
            return subList;
        }

        // traverse from start to stop - 1
        Iterator<E> iter = this.iterator();
        int index = 0;

        // move iterator to the start
        while (index < start && iter.hasNext()) {
            iter.next();
            index++;
        }

        // add from start to stop - 1 to the sublist
        while (index < stop && iter.hasNext()) {
            subList.add(iter.next());
            index++;
        }

        return subList;
    }


    /**
     * Return the size of this list.
     * In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * @return the number of items in this list
     */
    // O(1)
    public int size() {
        return this.size;
    }

    /**
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     * @param item the element to search for in the list. item != null
     * @return return the index of the first element equal to item
     * or a -1 if item is not present
     */
    // O(n)
    public int indexOf(E item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }
        int index = 0;

        Iterator<E> iter = this.iterator();
        // while in the list
        while (iter.hasNext()) {
            // if next element is item, return the index its at
            if (iter.next().equals(item)) {
                return index;
            }
            index++;
        }

        // not found
        return -1;
    }

    /**
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     */
    // O(n)
    public int indexOf(E item, int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("pos out of bounds");
        }
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }

        Iterator<E> iter = this.iterator();
        E data;
        int index = 0;

        // move iterator to pos
        while (index < pos && iter.hasNext()) {
            iter.next();
            index++;
        }

        // search from pos onward
        while (iter.hasNext()) {
            data = iter.next();
            if (data.equals(item)) {
                // found item, return index
                return index;
            }
            index++;
        }

        // item not found
        return -1;
    }



    /**
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     */

    // O(1)
    public void makeEmpty() {
        // detach the head and tail, reset size
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * return an Iterator for this list.
     * <br>pre: none
     * <br>post: return an Iterator object for this List
     */
    // O(1)
    public Iterator<E> iterator() {
        return new LLIterator();
    }

    /**
     * Remove all elements in this list from <tt>start</tt>
     * inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements
     * to be removed
     * @param stop stop - 1 is the position at the end
     * of the range of elements to be removed
     */
    // O(n)
    public void removeRange(int start, int stop) {
        if (start < 0 || stop > size || start > stop) {
            throw new IndexOutOfBoundsException("invalid start or stop pos");
        }

        Iterator<E> iter = this.iterator();
        int index = 0;

        // get to start
        while (iter.hasNext() && index < start) {
            iter.next();
            index++;
        }

        // remove onwards from start to stop
        while (iter.hasNext() && index < stop) {
            iter.next();
            iter.remove();
            index++;
        }

    }

    /**
     * Return a String version of this list enclosed in
     * square brackets, []. Elements are in
     * are in order based on position in the
     * list with the first element
     * first. Adjacent elements are separated by comma's
     * @return a String representation of this IList
     */
    // O(n)
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        Iterator<E> nodeIter = this.iterator();
        StringBuilder sb = new StringBuilder("[");

        // append first element wout a preceding comma
        sb.append(nodeIter.next());

        // append rest of the elements w commas
        while (nodeIter.hasNext()) {
            sb.append(", ");
            sb.append(nodeIter.next());
        }

        sb.append("]");
        return sb.toString();
    }


    /**
     * Determine if this IList is equal to other. Two
     * ILists are equal if they contain the same elements
     * in the same order.
     * @return true if this IList is equal to other, false otherwise
     */
    // O(n)
    public boolean equals(Object other) {
        if (!(other instanceof LL314)) {
            return false;
        }

        // cast other to linked list bc we know its alr a linked list
        LL314<?> otherList = (LL314<?>) other;
        // if their size isnt equal, then they arent equal
        if (this.size != otherList.size) {
            return false;
        }

        // iterators for both lists
        Iterator<E> currIter = this.iterator();
        Iterator<?> otherIter = otherList.iterator();

        // compare each item and return false if mismatch
        while (currIter.hasNext() && otherIter.hasNext()) {
            if (!currIter.next().equals(otherIter.next())) {
                return false;
            }
        }

        // theyre the same
        return true;
    }


    /**
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     * 
     * @param item the data to add to the front of this list
     */
    // O(1)
    public void addFirst(E item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }

        DoubleListNode<E> node = new DoubleListNode<>(null, item, head);

        if (size == 0) {
            // list is empty, set both head + tail to node
            this.head = this.tail = node;
        } else {
            // otherwise update previous heads pointer
            head.prev = node;
            // and update head
            this.head = node;
        }

        size++;
    }

    /**
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(size() -1) = item
     * 
     * @param item the data to add to the end of this list
     */
    // O(1)
    public void addLast(E item) {
        if (item == null) {
            throw new IllegalArgumentException("item cannot be null");
        }

        DoubleListNode<E> node = new DoubleListNode<>(tail, item, null);

        if (size == 0) {
            // list is empty, set both tail + head to node
            this.tail = this.head = node;
        } else {
            // otherwise update previous tails pointer
            tail.next = node;
            // and update tail
            this.tail = node;
        }

        size++;
    }

    /**
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * 
     * @return the old first element of this list
     */
    // O(1)
    public E removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("list is empty");
        }

        // get the first's data
        E data = head.data;

        // if size = 1, empty list
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            // else, reassign head
            this.head = head.next;
            head.prev = null;
        }

        // decrement size
        this.size--;

        // return data
        return data;
    }

    /**
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * 
     * @return the old last element of this list
     */
    // O(1)
    public E removeLast() {
        if (size == 0) {
            throw new IllegalStateException("list is empty");
        }

        // get the last's data
        E data = tail.data;

        // if size = 1, empty list
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            // else, reassign tail
            this.tail = tail.prev;
            tail.next = null;
        }

        // decrement size
        this.size--;

        // return data
        return data;
    }

    // inner class LLIterator that implements Iterator<E>
    private class LLIterator implements Iterator<E> {
        // keep track of the current node
        private DoubleListNode<E> nextNode;
        private DoubleListNode<E> currNode;
        private boolean removeOk;

        // O(1)
        private LLIterator() {
            this.nextNode = head;
            this.currNode = null;
            this.removeOk = false;

        }

        // method to check if there is a next element
        // O(1)
        public boolean hasNext() {
            return nextNode != null;
        }

        // method to return the next element in the iteration
        // O(1)
        public E next() {
            if (!hasNext()) {
                throw new IllegalStateException("no next element");
            }
            // get data of curr, move to next
            this.currNode = nextNode;
            this.nextNode = currNode.next;
            this.removeOk = true;

            return currNode.data;
        }

        // O(1)
        public void remove() {
            if (!removeOk) {
                throw new IllegalStateException("not okay to remove");
            }

            // remove currNode from the list
            if (currNode == head) {
                // if removing head
                head = head.next;
                // if the list has >1 element, need to reset head.prev
                // else, empty list
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
            } else if (currNode == tail) {
                // if removing tail
                tail = tail.prev;
                // need to reset tail.next
                if (tail != null) {
                    tail.next = null;
                }
            } else {
                // otherwise move the references by 1
                currNode.prev.next = currNode.next;
                if (currNode.next != null) {
                    currNode.next.prev = currNode.prev;
                }
            }

            // update size and currNode
            size--;
            currNode = null;
            removeOk = false;
        }
    }


    /**
     * A class that represents a node to be used in a linked list.
     * These nodes are doubly linked. All methods are O(1).
     *
     * @author Mike Scott
     * @version 9/25/2023
     */

    private static class DoubleListNode<E> {

        // the data to store in this node
        private E data;

        // the link to the next node (presumably in a list)
        private DoubleListNode<E> next;

        // the reference to the previous node (presumably in a list)
        private DoubleListNode<E> prev;

        /**
         * default constructor.
         * <br>pre: none
         * <br>post: data = null, next = null, prev = null
         * <br>O(1)
         */
        public DoubleListNode() {
            this(null, null, null);
        }

        /**
         * create a DoubleListNode that holds the specified data
         * and refers to the specified next and previous elements.
         * <br>pre: none
         * <br>post: this.data = data, this.next = next, this.prev = prev
         * <br>O(1)
         * @param prev the previous node
         * @param data the  data this DoubleListNode should hold
         * @param next the next node
         */
        public DoubleListNode(DoubleListNode<E> prev, E data, DoubleListNode<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;    
        }
    }

}
