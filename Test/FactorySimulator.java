import java.util.*;


public class FactorySimulator {

    
    static class JunctionTracker {
        String activeFeeder = null; 
        int timesSwitched = 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int layoutLines = Integer.parseInt(input.nextLine());

        Map<String, String> conveyorLayout = new HashMap<>();
        Map<String, JunctionTracker> junctions = new HashMap<>();

        for (int i = 0; i < layoutLines; i++) {
            String[] parts = input.nextLine().split(" ");
            String junctionName = parts[0];
            junctions.putIfAbsent(junctionName, new JunctionTracker());
            for (int j = 1; j < parts.length; j++) {
                String sourceName = parts[j];
                conveyorLayout.put(sourceName, junctionName);
            }
        }

        String[] productQueue = input.nextLine().split(" ");
        int maxSwitches = Integer.parseInt(input.nextLine());
        input.close();

        final int PER_JUNCTION_WAIT = 1;
        final int SWITCH_DELAY = 2;
        final int RESET_DELAY = 3;

        long grandTotalTime = 0;

        for (String productOrigin : productQueue) {
            long timeForThisProduct = 0;
            String currentFeeder = productOrigin;
            String currentLocation = productOrigin;

            while (conveyorLayout.containsKey(currentLocation)) {
                String destinationJunction = conveyorLayout.get(currentLocation);

                timeForThisProduct += PER_JUNCTION_WAIT;

                JunctionTracker tracker = junctions.get(destinationJunction);

                if (tracker.activeFeeder == null || !tracker.activeFeeder.equals(currentFeeder)) {
                    if (tracker.timesSwitched < maxSwitches) {
                        timeForThisProduct += SWITCH_DELAY;
                        tracker.activeFeeder = currentFeeder;
                        tracker.timesSwitched++;
                    } else {
                        timeForThisProduct += RESET_DELAY;
                    }
                }

                currentLocation = destinationJunction;
                currentFeeder = destinationJunction; 
            }

            grandTotalTime += timeForThisProduct;
        }

        System.out.println(grandTotalTime);
        input.close();
    }
}