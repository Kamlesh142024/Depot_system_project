package model;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOfCustomers {
    private Queue<Customer> customerQueue = new LinkedList<>();

    public void addCustomer(Customer customer) {
        customerQueue.add(customer);
    }

    public Customer processNextCustomer() {
        return customerQueue.poll();
    }

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }
}
