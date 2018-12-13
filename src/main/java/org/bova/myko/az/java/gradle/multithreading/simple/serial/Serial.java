package org.bova.myko.az.java.gradle.multithreading.simple.serial;

/*
Some task; here it will print 1500 T's.
*/
class Task {

    public void doTask() {
        for(int i=1; i <= 1500; i++) {
            System.out.print("T");
        }
    }
}

/* Main */
public class Serial {

    public static void main(String[] args) {

        // Print M's
        for(int i=1; i <= 1500; i++) {
            System.out.print("M");
        }

        // Call the task to print T's
        Task t1 = new Task();
        t1.doTask();
    }

}