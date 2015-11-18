package towerofhanoi;

import java.util.EmptyStackException;

import stack.StackInterface;

/**
 * Implentation of Linked Stack to be used in Tower of Hanoi.
 * @author Daniel Xu <xudy>
 * @version 2015.10.19
 *
 * @param <T> can take any type
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;
   
    /**
     * Initializes the first node and the size to their
     * default values.
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }
    
    /**
     * Size of the linked stack.
     * @return int of the size.
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Nullifies the first node in the stack so that
     * all other nodes are nullified.
     */
    @Override
    public void clear() {
        if (!this.isEmpty())
        {
            topNode.data = null;
            topNode.next = null;
            size = 0;
        }
    }

    /**
     * Checks whether the stack is empty.
     * @return true or false whether the stack is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Shows the most recent entry.
     * @return the most recent entry
     */
    @Override
    public T peek() {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        
        else
        {
            return topNode.data;
        }
    }

    /**
     * Removes and returns the most recent entry.
     * @return the most recent entry.
     */
    @Override
    public T pop() {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        
        else
        {
            T temp = topNode.data;
            topNode = topNode.next;
            size--;
            
            return temp;
        }
        
    }

    /**
     * Adds a new node entry to the stack.
     * @param anEntry entry to be added to the stack.
     */
    @Override
    public void push(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;        
    }
    
    /**
     * Returns the stack as a string
     * @return String representation of the stack.
     */
    @Override
    public String toString()
    {
        LinkedStack<T> stack = this;
        
        if (stack.size() == 0)
        {
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder();        
        builder.append("[");
        
        while (!stack.isEmpty())
        {
            builder.append(String.valueOf(stack.pop()));
            if (stack.size() != 0)
            {
                builder.append(", ");
            }
            
            else
            {
                builder.append("]");
            }            
        }
        
        return builder.toString();
    }
    
    /**
     * Private node class only used by LinkedStack.
     * @author Daniel Xu <xudy>
     * @version 2015.10.19
     *
     * @param <T> takes any type
     */
    @SuppressWarnings("hiding")
    private class Node<T>
    {
        private Node<T> next;
        private T data;
        
        /**
         * Takes data and a next node.
         * @param data Data in the node
         * @param next Reference to the next node
         */
        @SuppressWarnings("unused")
        public Node(T data, Node<T> next)
        {
            this.data = data;
            this.next = next; 
        }
        
        /**
         * Takes one parameter of data.
         * @param data Data in the node.
         */
        @SuppressWarnings("unused")
        public Node(T data)
        {
            this.data = data;
        }
        
        /**
         * Shows the next node.
         * @return the next node.
         */
        @SuppressWarnings("unused")
        public Node<T> getNextNode()
        {
            return this.next;
        }
        
        /**
         * Shows data in the current node.
         * @return Data in the current node.
         */
        @SuppressWarnings("unused")
        public T getData()
        {
            return data; 
        }
        
        /**
         * Sets what the next node will be.
         * @param newNext What the next node will be set as.
         */
        @SuppressWarnings("unused")
        public void setNextNode(Node<T> newNext)
        {
            next = newNext;
        }
    }
}
