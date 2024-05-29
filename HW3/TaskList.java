/*
@Author: Anjali Gupta
I pledge my honor that I have abided by the Stevens Honor System - AG
 */

package HW3;

import java.util.Iterator;
import java.util.List;

public class TaskList <E> {
    private ListQueue<E> all;
    private ListQueue<E> active;
    private ListQueue<E> completed;
    private int LOW_PRIORITY = Integer.MAX_VALUE;
    private int HIGH_PRIORITY = 1;

    // initialize all the ListQueue attributes (all, active, completed)
    public TaskList(){
        all = new ListQueue<E>();
        active = new ListQueue<E>();
        completed = new ListQueue<E>();
    }

    /*
    add item into active and all queues with default priority as LOW_PRIORITY
    if item is null, return false, otherwise return true
     */
    public boolean createTask(E item){
        if (item == null)
            return false;

        active.offer(item, LOW_PRIORITY);
        all.offer(item, LOW_PRIORITY);
        return true;
    }

    /*
    add item into and all queues. if item null, return false
    otherwise return true
     */
    public boolean createTask(E item, int priority){
        if (item == null)
            return false;

        active.offer(item, priority);
        all.offer(item, priority);
        return true;
    }

    /*
    returns a string that has the top 3 highest priority tasks
     */
    public String getTopThreeTasks() {
        int task = 0;
        String myString = "";
        ListQueue.Node<E> node = active.getFront();
        if (active.getSize() < 3){
            for (int i = 0; i < active.getSize(); i++){
                myString += ((task + 1) + ". " + node.getData() + "\n");
                node = node.getNext();
                task++;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                myString += ((task + 1) + ". " + node.getData() + "\n");
                node = node.getNext();
                task++;
            }
        }
        return myString;
    }

    public void showActiveTasks(){
        if (active == null)
            return;
        printTasks(active);
    }

    public void showCompletedTasks(){
        if (completed == null)
            return;
        printTasks(completed);
    }

    public void showAllTasks(){
        if (all == null)
            return;
        printTasks(all);
    }

    /*
    helper method uses iterator() to iterate through queue elements and
    print them with numbers. front of queue will have task 1and each node
    will have increasing task number
     */
    private void printTasks(ListQueue<E> queue){
        Iterator<E> iterator = queue.iterator();
        int counter = 1;
        while (iterator.hasNext()) {
            System.out.println(counter + ". " + iterator.next());
            counter++;
        }
    }

    /*
    remove the highest priority task from the front of the queue and returns
    true if successfully removed. the task will be added to the completed queue
    if it does not exist, it prints an error message and returns false
     */
    public boolean crossOffMostUrgent() {     // -> cross off the first task (highest priority)
        if (active.getSize() == 0){
            System.out.println("Queue is empty, cannot cross off the most urgent");
            return false;
        }
        else {
            E mostUrgent = all.peek();    // holds most urgent element
            completed.addRear(mostUrgent);
            //active.remove((ListQueue.Node<E>) mostUrgent);
            active.poll();
            return true;
        }
    }

    /*
    removes task at location identified by taskNumber. task will be added to
    completed queue. returns true if successful. if task removal is unsuccessful
    return false
     */
    public boolean crossOffTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > active.getSize())
            return false;
        else {
            Iterator<E> Iter = active.iterator();
            for (int i = 1; i < taskNumber; i++)
                Iter.next();
            E removed = Iter.next();
            completed.addRear(removed);
            ListQueue.Node node = new ListQueue.Node(removed);
            active.remove(node);
            return true;
        }
    }


    // getters for ListQueue<E> attributes
    public ListQueue<E> getAll() { return all; }

    public ListQueue<E> getCompleted(){
        return completed;
    }

    public ListQueue<E> getActive(){
        return active;
    }
}
