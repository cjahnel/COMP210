package assn03;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(60);
        list.add(30);
        System.out.println("list = " + list.toString());
        System.out.println("size of list = " + list.size());
        System.out.println("list contains 10?: " + list.contains(10));     // implemented
        System.out.println("list contains 50?: " + list.contains(50));
        System.out.println("set element at index 2 to be 10");
        list.set(2, 10);
        System.out.println("get element at index 2 = " + list.get(2));
        System.out.println("list = " + list.toString());
        System.out.println("Last Index of element 10 in list = " + list.lastIndexOf(10));

        list.remove(20);
        System.out.println("list after removing 20 = " + list.toString());

        System.out.println("index of '30' = " + list.indexOf(30));
        

        // Test task 1
        list.clear();
        list.add(1);
        list.add(4);
        list.add(2);
        int i = 1;
        System.out.println("Task 1: list before removing element at index i = " + list.toString());
        System.out.println("Task 1: i = " + i);
        list.removeAtIndex(i);
        System.out.println("Task 1: list after removing element at index i = " + list.toString());

        // Test task 2
        list.clear();
        list.add(1);
        list.add(5);
         list.add(2);
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(4);
        list2.add(2);
        System.out.println("list = " + list.toString());
        System.out.println("list2 = " + list2.toString());
        System.out.println("Task 2: list == list2 ?: " + list.isEqual(list2));

        // Test task 3
        list.clear();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println("list before removing repeats = " + list.toString());
        list.removeRepeats();
        System.out.println("Task 3: list after removing repeats = " + list.toString());

        // Test task 4
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("List: " + list.toString());
        list.reverse();
        System.out.println("Reversed List: " + list.toString());

        // Test task 5
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list2.clear();
//        list2.add(4);
        list2.add(5);
        list2.add(6);
        System.out.println("List: " + list.toString());
        System.out.println("List 2: " + list2.toString());
        list.merge(list2);
        System.out.println("Merged List: " + list.toString());
    }
}
