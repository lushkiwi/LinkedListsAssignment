/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:
 *  email address:
 *  UTEID:
 *  Number of slip days used on this assignment:
 */

/* Experiment results. CS314 students, place your experiment
 *  results here:
 *
 * adding at end: ArrayList
 * adding at front: LinkedList
 * removing from front: LinkedList
 * getting random: ArrayList
 * getting all using iterator: ArrayList
 * getting all using get method: ArrayList
 *
 * For the ArrayList, based on the time data, it seems like the amount of time for each
 * operation doubles every time N doubles, for almost every operation. From this, we can
 * conclude that the complexity is O(N) for all but one operation. But, for the adding
 * at front operation, the ArrayList time quadrupled every time N doubled. So, for this
 * operation, it is O(N^2).
 *
 * For the LinkedList, this behavior of time doubling every time N doubles is also true
 * for all but one operation - getting random. Therefore, every operation besides getting
 * random has a complexity of O(N). For the getting random, whenever N doubles, time
 * quadruples. So, the time complexity for this is O(N^2).
 */


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedListTester {

    public static void main(String[] args) {

//        basicTests();
//        spring2021StressTests();
//        itRemoveStressTests();


        //CS314 students. Add your tests here:

        // test 1: default constructor
        LL314<String> linkedList = new LL314<>();
        System.out.println(linkedList.toString().equals("[]") ? "test 1 passed" : "test 1 failed");

        // test 2: default constructor
        System.out.println(linkedList.size() == 0 ? "test 2 passed" : "test 2 failed");

        // test 3: parameterized constructor
        LL314<String> singleElementList = new LL314<>();
        singleElementList.add("A");
        System.out.println(singleElementList.toString().equals("[A]") ? "test 3 passed" : "test 3 failed");

        // test 4: parameterized constructor
        System.out.println(singleElementList.size() == 1 ? "test 4 passed" : "test 4 failed");

        // test 5: add(E item)
        linkedList.add("A");
        linkedList.add("B");
        System.out.println(linkedList.toString().equals("[A, B]") ? "test 5 passed" : "test 5 failed");

        // test 6: add(E item)
        linkedList.add("C");
        System.out.println(linkedList.toString().equals("[A, B, C]") ? "test 6 passed" : "test 6 failed");

        // test 7: insert(int pos, E item)
        linkedList.insert(1, "D");
        System.out.println(linkedList.toString().equals("[A, D, B, C]") ? "test 7 passed" : "test 7 failed");

        // test 8: insert(int pos, E item)
        linkedList.insert(0, "E");
        System.out.println(linkedList.toString().equals("[E, A, D, B, C]") ? "test 8 passed" : "test 8 failed");

        // test 9: iterator()
        Iterator<String> iter = linkedList.iterator();
        System.out.println(iter.hasNext() ? "test 9 passed" : "test 9 failed");

        // test 10: iterator()
        System.out.println(iter.next().equals("E") ? "test 10 passed" : "test 10 failed");

        // test 11: set(int pos, E item)
        linkedList.set(1, "F");
        System.out.println(linkedList.toString().equals("[E, F, D, B, C]") ? "test 11 passed" : "test 11 failed");

        // test 12: set(int pos, E item)
        String oldData = linkedList.set(3, "G");
        System.out.println((oldData.equals("B") && linkedList.toString().equals("[E, F, D, G, C]")) ? "test 12 passed" : "test 12 failed");

        // test 13: get(int pos)
        System.out.println(linkedList.get(2).equals("D") ? "test 13 passed" : "test 13 failed");

        // test 14: get(int pos)
        System.out.println(linkedList.get(4).equals("C") ? "test 14 passed" : "test 14 failed");

        // test 15: remove(int pos)
        linkedList.remove(1);
        System.out.println(linkedList.toString().equals("[E, D, G, C]") ? "test 15 passed" : "test 15 failed");

        // test 16: remove(int pos)
        linkedList.remove(3);
        System.out.println(linkedList.toString().equals("[E, D, G]") ? "test 16 passed" : "test 16 failed");

        // test 17: remove(E obj)
        boolean removed = linkedList.remove("G");
        System.out.println((removed && linkedList.toString().equals("[E, D]")) ? "test 17 passed" : "test 17 failed");

        // test 18: remove(E obj)
        removed = linkedList.remove("Z");
        System.out.println(!removed ? "test 18 passed" : "test 18 failed");

        // test 19: getSubList(int start, int stop)
        LL314<String> subList = (LL314<String>) linkedList.getSubList(0, 2);
        System.out.println(subList.toString().equals("[E, D]") ? "test 19 passed" : "test 19 failed");

        // test 20: getSubList(int start, int stop)
        subList = (LL314<String>) linkedList.getSubList(0, 1);
        System.out.println(subList.toString().equals("[E]") ? "test 20 passed" : "test 20 failed");

        // test 21: size()
        System.out.println((linkedList.size() == 2) ? "test 21 passed" : "test 21 failed");

        // test 22: size()
        linkedList.add("H");
        System.out.println((linkedList.size() == 3) ? "test 22 passed" : "test 22 failed");

        // test 23: indexOf(E item)
        System.out.println((linkedList.indexOf("H") == 2) ? "test 23 passed" : "test 23 failed");

        // test 24: indexOf(E item)
        System.out.println((linkedList.indexOf("Z") == -1) ? "test 24 passed" : "test 24 failed");

        // test 25: indexOf(E item, int pos)
        System.out.println((linkedList.indexOf("D", 0) == 1) ? "test 25 passed" : "test 25 failed");

        // test 26: indexOf(E item, int pos)
        System.out.println((linkedList.indexOf("H", 1) == 2) ? "test 26 passed" : "test 26 failed");

        // test 27: makeEmpty()
        linkedList.makeEmpty();
        System.out.println(linkedList.toString().equals("[]") ? "test 27 passed" : "test 27 failed");

        // test 28: makeEmpty()
        linkedList.add("I");
        linkedList.makeEmpty();
        System.out.println(linkedList.toString().equals("[]") ? "test 28 passed" : "test 28 failed");

        // test 29: equals(Object other)
        LL314<String> otherList = new LL314<>();
        otherList.add("E");
        otherList.add("D");
        System.out.println(!linkedList.equals(otherList) ? "test 29 passed" : "test 29 failed");

        // test 30: equals(Object other)
        linkedList.add("E");
        linkedList.add("D");
        System.out.println(linkedList.equals(otherList) ? "test 30 passed" : "test 30 failed");

        // test 31: addFirst(E item)
        linkedList.addFirst("X");
        System.out.println(linkedList.toString().equals("[X, E, D]") ? "test 31 passed" : "test 31 failed");

        // test 32: addFirst(E item)
        linkedList.addFirst("Y");
        System.out.println(linkedList.toString().equals("[Y, X, E, D]") ? "test 32 passed" : "test 32 failed");

        // test 33: addLast(E item)
        linkedList.addLast("Z");
        System.out.println(linkedList.toString().equals("[Y, X, E, D, Z]") ? "test 33 passed" : "test 33 failed");

        // test 34: addLast(E item)
        linkedList.addLast("W");
        System.out.println(linkedList.toString().equals("[Y, X, E, D, Z, W]") ? "test 34 passed" : "test 34 failed");

        // test 35: removeFirst()
        String removedFirst = linkedList.removeFirst();
        System.out.println((removedFirst.equals("Y") && linkedList.toString().equals("[X, E, D, Z, W]")) ? "test 35 passed" : "test 35 failed");

        // test 36: removeFirst()
        removedFirst = linkedList.removeFirst();
        System.out.println((removedFirst.equals("X") && linkedList.toString().equals("[E, D, Z, W]")) ? "test 36 passed" : "test 36 failed");

        // test 37: removeLast()
        String removedLast = linkedList.removeLast();
        System.out.println((removedLast.equals("W") && linkedList.toString().equals("[E, D, Z]")) ? "test 37 passed" : "test 37 failed");

        // test 38: removeLast()
        removedLast = linkedList.removeLast();
        System.out.println((removedLast.equals("Z") && linkedList.toString().equals("[E, D]")) ? "test 38 passed" : "test 38 failed");

        // test 39: toString()
        System.out.println(linkedList.toString().equals("[E, D]") ? "test 39 passed" : "test 39 failed");

        // test 40: toString()
        linkedList.add("A");
        System.out.println(linkedList.toString().equals("[E, D, A]") ? "test 40 passed" : "test 40 failed");

        // test 41: removeRange(int start, int stop)
        linkedList.removeRange(0, 2);
        System.out.println(linkedList.toString().equals("[A]") ? "test 41 passed" : "test 41 failed");

        // test 42: removeRange(int start, int stop)
        linkedList.add("B");
        linkedList.add("C");
        linkedList.removeRange(1, 3);
        System.out.println(linkedList.toString().equals("[A]") ? "test 42 passed" : "test 42 failed");


        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LL314 class to the java ArrayList class.
        comparison();
    }

    /*
     * Runs very basic tests on the LinkedList class for 
     * CS314 assignment 4.
     */
    private static void basicTests() {

        System.out.println("****** BASIC TESTS *******\n");
        LL314<String> list = new LL314<>();

        // test 0
        System.out.println("\nTest 0: initial list is empty");
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 0");
        } else {
            System.out.println("Failed test 0");
        }

        // test 0.1
        System.out.println("\nTest 0.1: add to end");
        list.add("A");
        if (list.get(0).equals("A")) {
            System.out.println("Passed test 0.1");
        } else {
            System.out.println("Failed test 0.1"); 
        }

        // test 0.2
        System.out.println("\nTest 0.2: size");
        if (list.size() == 1) {
            System.out.println("Passed test 0.2");
        } else {
            System.out.println("Failed test 0.2"); 
        }

        // test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        String removed = list.remove(0);
        if (removed.equals("A")) {
            System.out.println("Passed test 0.31");
        } else {
            System.out.println("Failed test 0.31"); 
        }

        System.out.println("\nTest 0.31: toString after remove");

        // test 0.31
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 0.3");
        } else {
            System.out.println("Failed test 0.3");  
        }

        // test 0.4
        System.out.println("\nTest 0.4: size");
        if (list.size() == 0) {
            System.out.println("Passed test 0.4");
        } else {
            System.out.println("Failed test 0.4"); 
        }

        // test 0.5
        System.out.println("\nTest 0.5: add and toString");
        list.add("A");
        list.add("B");
        if (list.toString().equals("[A, B]")) {
            System.out.println("Passed test 0.5");
        } else {
            System.out.println("Failed test 0.5");  
        }

        // test 0.6
        System.out.println("\nTest 0.6: size");
        if (list.size() == 2) {
            System.out.println("Passed test 0.6");
        } else {
            System.out.println("Failed test 0.6");
        }

        // test 0.7
        System.out.println("\nTest 0.7: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 0.7");
        } else {
            System.out.println("Failed test 0.7");
        }

        // test 0.8
        System.out.println("\nTest 0.8: makeEmpty on empty list");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 0.8");
        } else {
            System.out.println("Failed test 0.8");
        }


        // test 1
        System.out.println("\nTest 1: Adding at end");
        list = new LL314<>();
        list.add("A");
        Object[] actual = toArray(list);
        Object[] expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));      
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Failed test 1");
        }


        // test 2
        System.out.println("\nTest 2: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Failed test 2");
        }


        // test 3
        System.out.println("\nTest 3: Adding at pos 0 in empty list");
        list.insert(0, "A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );          
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Failed test 3");
        }


        //test 4
        System.out.println("\nTest 4: Adding at front");
        list = new LL314<>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Failed test 4");
        }


        // test 5
        System.out.println("\nTest 5: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Failed test 5");
        }


        // test 6
        list = new LL314<>();
        System.out.println("\nTest 6: Adding at end");
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Failed test 6");
        }


        // test 7
        System.out.println("\nTest 7: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Failed test 7");
        }

        // test 8
        System.out.println("\nTest 8: Adding at middle");
        list = new LL314<>();
        list.add("A");
        list.add("C");
        list.insert(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Failed test 8");
        }


        // test 9
        System.out.println("\nTest 9: Setting");
        list = new LL314<>();
        list.add("A");
        list.add("D");
        list.add("C");
        String oldValue = list.set(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) ) {
            System.out.println("Passed test 9.1");
        } else {
            System.out.println("Failed test 9.1");
        }
        if (oldValue.equals("D")) {
            System.out.println("Passed test 9.2");
        } else {
            System.out.println("Failed test 9.2");
        }


        // test 10
        System.out.println("\nTest 10: Removing");
        list = new LL314<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove( list.size() - 1 );
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }
    }


    // constants for the maximum length of the lists used in the tests as well as
    // the number of times each method should be tested
    private static final int MAX_LENGTH = 15;
    private static final int NUM_TESTS_PER_METHOD = 50;

    // From Spring 2021 students:
    // Tests use randomness to find edge cases, 
    // so the test numbering is irrelevant, each test being different every time the 
    // program is run.
    private static void spring2021StressTests() {
        System.out.println("\n****** SPRING 2021 RANDOM STRESS TESTS *******\n");

        // performs all the tests. The console displays some private methods I have as
        // well, but it isn't actually directly calling those private methods. It merely
        // sets the conditions to where those methods would be called in my personal
        // program. It still is useful to test for edge cases

        final String methodNamesRaw = "void addFirst(E item)\r\n" + "void addLast(E item)\r\n" + "E removeFirst()\r\n"
                + "E removeLast()\r\n" + "void add(E item)\r\n" + "void insert(int pos, E item)\r\n"
                + "void insertBeforeLast(E item)\r\n" + "void insertAfterFirst(E item)\r\n" + "E set(pos, E item)\r\n"
                + "E get(int pos)\r\n" + "E remove(int pos)\r\n" + "E removeAFterFirst()\r\n"
                + "E removeBeforeLast()\r\n" + "boolean remove(E obj)\r\n"
                + "Ilist<E> getSubList(int start, int stop)\r\n" + "int size()\r\n" + "int indexOf(E item)\r\n"
                + "int indexOf(E item, int pos)\r\n" + "void makeEmpty()\r\n"
                + "void removeRange(int start, int stop)\r\n" + "string tosString()\r\n" + "boolean equals(other)\r\n"
                + "ITERATOR LLIterator()\r\n" + "ITERATOR boolean hasNext()\r\n" + "ITERATOR E next()\r\n"
                + "ITERATOR void remove()\r\n";
        final String[] methodNames = methodNamesRaw.split("\r\n");
        String methodName = methodNames[0];
        int methodNum = 0;
        LL314<String> testList = new LL314<>();
        int numTestsFailed = 0;
        HashSet<String> failedTests = new HashSet<>();
        // void addFirst(E item)
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            testList.addFirst("FIRST ELEMENT");
            toCompare.add(0, "FIRST ELEMENT");
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.addLast("LAST ELEMENT");
            toCompare.add("LAST ELEMENT");

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeFirst();
            toCompare.remove(0);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeLast();
            toCompare.remove(toCompare.size() - 1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void add(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.add(methodName);
            toCompare.add(methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insert(int pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int randomPos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.insert(randomPos, methodName);
            toCompare.add(randomPos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void insertBeforeLast(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insertAfterFirst(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E set(pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.set(pos, methodName);
            toCompare.set(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E get(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here

            String expected = toCompare.get(pos);
            String actual = testList.get(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E remove(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.remove(pos);
            toCompare.remove(pos);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeAFterFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            if (toCompare.size() == 1) {
                toCompare.add("Item " + 2);
                testList.add("Item " + 2);
            }
            // perform actions here
            testList.remove(1);
            toCompare.remove(1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeBeforeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 2;
            if (pos == -1) {
                pos = 0;
            }
            // perform actions here

            String expected = toCompare.remove(pos);
            String actual = testList.remove(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean remove(E obj)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            String objToRemove = toCompare.get((int) (Math.random() * toCompare.size()));

            // perform actions here
            testList.remove(objToRemove);
            toCompare.remove(objToRemove);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // Ilist<E> getSubList(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int size()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (actualA.size() == expectedB.size()) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int indexOf(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());
            toCompare.add(pos, methodName);
            testList.insert(pos, methodName);
            // perform actions here

            int expected = toCompare.indexOf(methodName);
            int actual = testList.indexOf(methodName);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // int indexOf(E item, int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos2 = (int) (Math.random() * toCompare.size()) + 1;
            int pos1 = (int) (Math.random() * pos2);
            toCompare.add(pos1, methodName);
            toCompare.add(pos2, methodName);
            testList.insert(pos1, methodName);
            testList.insert(pos2, methodName);

            int posToCheckFrom = (int) (Math.random() * toCompare.size());
            // perform actions here
            int expected;
            if (posToCheckFrom > pos2) {
                expected = -1;
            } else if (posToCheckFrom > pos1 && posToCheckFrom <= pos2) {
                expected = pos2;
            } else {
                expected = pos1;
            }

            int actual = testList.indexOf(methodName, posToCheckFrom);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual + "  toCompare Array: " + toCompare.toString()
                        + " testList array " + testList.toString() + "  POS1: " + pos1 + " POS2: " + pos2
                        + " POSTTOCHECK: " + posToCheckFrom);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void makeEmpty()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.makeEmpty();
            toCompare.clear();

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void removeRange(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            testList.removeRange(start, stop);
            for (int j = stop - 1; j >= start; j--) {
                toCompare.remove(j);
            }
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual) + " START: " + start
                        + " STOP: " + stop);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // string tosString()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here

            String expected = toCompare.toString();
            String actual = testList.toString();
            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean equals(other)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            LL314<String> toCompareLinkedList = arrayListToLinkedList(toCompare);
            // perform actions here

            if (testList.equals(toCompareLinkedList)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR LLIterator()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            // perform actions here

            if (testList.iterator().hasNext() && testList.iterator().next().equals(testList.get(0))) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // ITERATOR boolean hasNext()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int count1 = 0;
            int count2 = 0;
            while (testListIterator.hasNext()) {
                count1++;
                testListIterator.next();
            }
            while (toCompareIterator.hasNext()) {
                count2++;
                toCompareIterator.next();
            }

            if (count1 == count2) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR E next()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            boolean pass = true;
            while (testListIterator.hasNext() && toCompareIterator.hasNext() && pass) {
                if (!testListIterator.next().equals(toCompareIterator.next())) {
                    pass = false;
                }
            }
            if (testListIterator.hasNext() != toCompareIterator.hasNext()) {
                pass = false;
            }

            if (pass) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR void remove()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int random = (int) (Math.random() * toCompare.size()) + 1;
            for (int j = 0; j < random; j++) {
                if (testListIterator.hasNext()) {
                    testListIterator.next();
                }
                if (toCompareIterator.hasNext()) {
                    toCompareIterator.next();
                }
            }
            toCompareIterator.remove();
            testListIterator.remove();
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        System.out.println("RESULTS:");
        System.out.println("TOTAL TESTS: " + (NUM_TESTS_PER_METHOD * methodNames.length) + " | TOTAL FAILED: "
                + numTestsFailed + " | FAILED METHODS: " + failedTests.toString() + " |");
    }


    private static LL314<String> newResetedTestList(LL314<String> a) {
        a.makeEmpty();
        int random = (int) (Math.random() * MAX_LENGTH) + 1;
        for (int j = 0; j < random; j++) {
            a.add(String.valueOf((char) (j + 'A')));
        }
        return a;
    }

    private static ArrayList<String> linkedListToArrayList(LL314<String> testList) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> s = testList.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static LL314<String> arrayListToLinkedList(ArrayList<String> toCompare) {
        LL314<String> result = new LL314<>();
        Iterator<String> s = toCompare.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static String[] toArray2(IList<String> actualA) {
        String[] result = new String[actualA.size()];
        Iterator<String> it = actualA.iterator();
        int index = 0;
        while (it.hasNext()) {
            result[index] = it.next();
            index++;
        }
        return result;
    }

    private static void itRemoveStressTests() {
        /*
         *  Test that the iterator remove is O(1).
         *  Total time to remove half of list should roughly double
         *  when size of list is doubled.
         */
        final int SEED = 19431215;
        Random r = new Random(SEED);
        Stopwatch st = new Stopwatch();
        final int NUM_DOUBLINGS = 6;
        final int INITIAL_N = 50_000;
        int n = INITIAL_N;
        for (int i = 0; i < NUM_DOUBLINGS; i++) {
            LL314<Double> list = new LL314<>();
            for (int j =0; j < n; j++) {
                list.add(r.nextDouble());
            }
            Iterator<Double> it = list.iterator();
            final int LIMIT = n / 2;
            for (int j = 0; j < LIMIT; j++) {
                it.next();
            }
            st.start();
            while(it.hasNext()) {
                it.next();
                it.remove();
            }
            st.stop();
            System.out.println("number of elements = " + n 
                    + " time to remove half of list with iterator = " + st);
            n *= 2;
        }   
    }

    // Convert elements of list to an array. Uses the list
    // size method and iterator.
    private static Object[] toArray(LL314<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    // pre: none
    // post: return true if the 
    private static boolean arraysSame(Object[] one, Object[] two)  {
        return Arrays.equals(one, two);
    }


    private static final int NUM_DOUBLINGS_OF_N = 5;
    private static final int NUM_REPEATS_OF_TEST = 100;

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    private static void comparison(){
        Stopwatch s = new Stopwatch();

        int initialN = 30000;
        addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 10000;
        addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 5000;
        removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 10000;
        getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 50000;
        getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
        getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 100000;
        getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

    }

    // These methods illustrate a failure to use polymorphism.
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repetition of code.
    private static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }

    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println("Number of times test run: " + NUM_REPEATS_OF_TEST);
        System.out.println(title);
        for (double time : times) {
            System.out.print("N = " + initialN + ", total time: ");
            System.out.printf("%7.4f\n", time);
            initialN *= 2;
        }
        System.out.println();
    }

    private static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    private static void addFrontArrayList(Stopwatch s, int initialN, int numTests){ 
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    private static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.insert(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    private static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){     
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<String> javaList = new ArrayList<>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while (!javaList.isEmpty()) {
                    javaList.remove(0);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    private static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;    
            for (int i = 0; i < numTests; i++) {
                LL314<String> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j + "");
                }
                s.start();
                while (studentList.size() != 0) {
                    studentList.removeFirst();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    private static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                for (int j = 0; j < n; j++) {
                    total += javaList.get(r.nextInt(javaList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    private static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];     
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                int total = 0;
                s.start();
                for (int j = 0; j < n; j++) {
                    total += studentList.get(r.nextInt(studentList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                Iterator<Integer> it = javaList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }        
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                Iterator<Integer> it = studentList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < javaList.size(); j++) {
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LL314<Integer> studentList = new LL314<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < studentList.size(); j++) {
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }
}
