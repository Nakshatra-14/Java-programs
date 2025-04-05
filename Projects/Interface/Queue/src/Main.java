public class Main {
    public static void main(String[] args) {
        // Queue<Integer> q = new CircularQueue<>();
        // Queue<Integer> q = new LinearQueue<>();
        Queue<Integer> q = Queue.create(false);

        q.insert(10);
        q.insert(15);
        System.out.println(q);
        System.out.println(q.delete());
        System.out.println(q);
    }
}
