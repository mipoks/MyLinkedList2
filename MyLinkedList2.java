import java.util.NoSuchElementException;

/**
 *This is doubly-linked list implementation. Does not implements most of optional list operations,
 * and permits only Integer values (not including null).
 * All of the operations perform as could be expected for a doubly-linked list.
 *
 * Note that this implementation is not synchronized. If multiple threads access a linked list concurrently,
 * and at least one of the threads modifies the list structurally, it must be synchronized externally.
 *
 * @author  Dankato
 */
public class MyLinkedList2  {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyLinkedList2() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Constructs a list containing the elements of the specified array.
     * @param arr array containing elements to be added to this list
     */
    public MyLinkedList2(int[] arr) {
        size = 0;
        head = null;
        tail = null;
        for (int i = 0; i < arr.length; i++)
            insert(arr[i]);
    }

    /**
     * Returns an array of two lists of the elements in this list.
     * The first list contains all numbers that are multiples of three, the second - all the rest.
     * @return an array of two lists of the elements calculated as above
     */
    public MyLinkedList2[] divide() {
        Node now = head;
        MyLinkedList2 firstLL2 = new MyLinkedList2();
        MyLinkedList2 secondLL2 = new MyLinkedList2();
        while (now != null) {
            if (now.data % 3 == 0) {
                firstLL2.insert(now.data);
            }
            else {
                secondLL2.insert(now.data);
            }
            now = now.next;
        }
        return new MyLinkedList2[]{firstLL2, secondLL2};
    }

    /**
     * Returns a new MyLinkedList2 instance with the elements which are calculated as follows:
     * the first element is multiplied with the last one, the second one is multiplied with the penultimate element,
     * and so on. Thus, the returned list contains the same number of elements as in the original list,
     * and each element is repeated twice.
     * @return list of the elements calculated as above
     */
    public MyLinkedList2 newList() {
        MyLinkedList2 newLL2 = new MyLinkedList2();
        int half = (size % 2 > 0) ? (size / 2 + 1) : (size / 2);
        Node left = head;
        Node right = tail;
        for (int i = 0; i < half; i++) {
            newLL2.insert(left.data  * right.data);
            newLL2.insert(left.data  * right.data);
            if (left.next != null) {
                left = left.next;
                right = right.prev;
            }
        }
        return newLL2;
    }

    /**
     * Appends the specified element to the list between elements that are smaller and larger than the specified element.
     * @param element element to be appended to this list
     */
    public void insert(int element) {
        size++;
        if (head == null) {
            head = new Node(element, null, null);
            tail = head;
            return;
        }
        Node now = head;
        Node prev = null;
        while (now != null && element > now.data) {
            prev = now;
            now = now.next;
        }
        if (now == null) {
            prev.next = new Node(element, null, prev);
            tail = prev.next;
        }
        else {
            if (prev != null) {
                prev.next = new Node(element, now, prev);
                now.prev = prev.next;
            }
            else {
                head = new Node(element, now, null);
                now.prev = head;
            }
        }
    }

    /**
     * Returns the element by index
     * @param index index of element
     * @return the element of list
     * @throws
     * IndexOutOfBoundsException if list does not contain the element on the index position
     */
    public int get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        Node now = head;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return now.data;
    }

    /**
     * Returns the number of elements in the list
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Removes the specified element of this list.
     * @param element element to be removed from this list, if present
     * @throws
     * NoSuchElementException if specified element is not in this list
     */
    public void delete(int element) {
        Node now = head;
        Node prev = head;
        while (now.next != null && now.data != element) {
            prev = now;
            now = now.next;
        }
        if (now.next == null) {
            if (now.data == element) {
                if (now == head) {
                    head = null;
                }
                else {
                    prev.next = null;
                }
                size--;
                return;
            }
            else
                throw new NoSuchElementException();
        }
        else {
            if (now != head) {
                Node tmp = now.next;
                prev.next = tmp;
                tmp.prev = prev;
            }
            else {
                head = now.next;
                now.next.prev = null;
            }
            size--;
            return;
        }

    }


    /**
     * Appends the specified element to the list between elements that are smaller and larger than the specified element.
     * @param myLinkedList2 list with the elements to be appended to this list
     * @return this instance of MyLinkedList2
     */
    public MyLinkedList2 merge(MyLinkedList2 myLinkedList2) {
        Node tmp = myLinkedList2.head;
        while (tmp != null) {
            insert(tmp.data);
            tmp = tmp.next;
        }
        size = size + myLinkedList2.size;
        return this;
    }

    /**
     * Returns the largest number of identical elements in the list
     * @return the largest number of repetitions
     */
    public int maxNum() {
        Node tmp = head;
        int repeatedData = 1;
        int maxNum = 1;
        while (tmp != null) {
            if (tmp.prev != null && tmp.prev.data == tmp.data) {
                maxNum = Math.max(maxNum, ++repeatedData);
            }
            else
                repeatedData = 1;
            tmp = tmp.next;
        }
        if (head == null)
            return 0;
        return maxNum;
    }

    /**
     * Returns String with all elements in the list separated by space
     * @return all elements in the list separated by space
     */
    @Override
    public String toString() {
        Node now = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (now != null) {
            stringBuilder.append(now.data);
            stringBuilder.append(" ");
            now = now.next;
        }
        return new String(stringBuilder);
    }

    private class Node{
        private int data;
        private Node next;
        private Node prev;

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

