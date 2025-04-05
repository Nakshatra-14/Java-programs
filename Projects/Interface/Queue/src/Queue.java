interface Queue<E> {
    boolean isEmpty();
    boolean isFull();
    void insert(E e);
    E delete();

    public static Queue create(boolean isEfficient)
    {
        
        // return new LinearQueue();
        // return new CircularQueue();

        return isEfficient ? new CircularQueue<>() : new LinearQueue<>();
    }
}


