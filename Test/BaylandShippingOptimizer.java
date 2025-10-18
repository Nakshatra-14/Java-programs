import java.util.*;

public class BaylandShippingOptimizer {
    static class GoodieInfo {
        String targetShip;
        int weight;
        int landPosition;

        GoodieInfo(String targetShip, int weight, int landPosition) {
            this.targetShip = targetShip;
            this.weight = weight;
            this.landPosition = landPosition;
        }
    }

    static class ShipData {
        String name;
        long totalWeight;

        ShipData(String name, long totalWeight) {
            this.name = name;
            this.totalWeight = totalWeight;
        }
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        int numGoodies = inputReader.nextInt();
        inputReader.nextLine();

        List<GoodieInfo> allGoodies = new ArrayList<>();
        Map<String, Long> weightAggregator = new HashMap<>();

        for (int i = 0; i < numGoodies; i++) {
            String[] parts = inputReader.nextLine().split(" ");
            String shipName = parts[0];
            int goodieWeight = Integer.parseInt(parts[1]);

            allGoodies.add(new GoodieInfo(shipName, goodieWeight, i + 1));
            weightAggregator.merge(shipName, (long) goodieWeight, Long::sum);
        }

        long arrangementRank = inputReader.nextLong();
        inputReader.close();

        List<ShipData> ships = new ArrayList<>();
        for (Map.Entry<String, Long> entry : weightAggregator.entrySet()) {
            ships.add(new ShipData(entry.getKey(), entry.getValue()));
        }

        ships.sort((s1, s2) -> {
            int weightCompare = Long.compare(s2.totalWeight, s1.totalWeight);
            if (weightCompare != 0) {
                return weightCompare;
            }
            return s1.name.compareTo(s2.name);
        });

        long[] factorials = precomputeFactorials(21);

        List<String> optimalArrangement = findKthOptimalArrangement(ships, arrangementRank, factorials);
        long finalCost = calculateTotalCost(allGoodies, optimalArrangement);

        System.out.println(finalCost);
        System.out.println(String.join(" ", optimalArrangement));
    }

    private static List<String> findKthOptimalArrangement(List<ShipData> sortedShips, long rank, long[] factorials) {
        List<String> finalArrangement = new ArrayList<>();
        long k_index = rank - 1;

        int currentIndex = 0;
        while (currentIndex < sortedShips.size()) {
            int groupEndIndex = currentIndex;
            while (groupEndIndex + 1 < sortedShips.size() &&
                    sortedShips.get(groupEndIndex + 1).totalWeight == sortedShips.get(currentIndex).totalWeight) {
                groupEndIndex++;
            }

            List<String> currentGroupNames = new ArrayList<>();
            for (int i = currentIndex; i <= groupEndIndex; i++) {
                currentGroupNames.add(sortedShips.get(i).name);
            }

            long remainingPermutations = 1;
            int nextIndex = groupEndIndex + 1;
            while (nextIndex < sortedShips.size()) {
                int nextGroupEnd = nextIndex;
                while (nextGroupEnd + 1 < sortedShips.size()
                        && sortedShips.get(nextGroupEnd + 1).totalWeight == sortedShips.get(nextIndex).totalWeight) {
                    nextGroupEnd++;
                }
                int groupSize = nextGroupEnd - nextIndex + 1;
                remainingPermutations *= factorials[groupSize];
                nextIndex = nextGroupEnd + 1;
            }

            long permutationChoice = k_index / remainingPermutations;
            finalArrangement.addAll(generatePermutation(currentGroupNames, permutationChoice, factorials));
            k_index %= remainingPermutations;

            currentIndex = groupEndIndex + 1;
        }
        return finalArrangement;
    }

    private static long calculateTotalCost(List<GoodieInfo> goodies, List<String> arrangement) {
        Map<String, Integer> shipSeaPositions = new HashMap<>();
        for (int i = 0; i < arrangement.size(); i++) {
            shipSeaPositions.put(arrangement.get(i), i + 1); // 1-based sea position
        }

        long totalCost = 0;
        for (GoodieInfo goodie : goodies) {
            int landPos = goodie.landPosition;
            int seaPos = shipSeaPositions.get(goodie.targetShip);
            totalCost += (long) goodie.weight * (landPos + seaPos);
        }
        return totalCost;
    }

    private static long[] precomputeFactorials(int limit) {
        long[] factorials = new long[limit];
        factorials[0] = 1;
        for (int i = 1; i < limit; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        return factorials;
    }

    private static List<String> generatePermutation(List<String> candidates, long rank, long[] factorials) {
        List<String> result = new ArrayList<>();
        List<String> available = new ArrayList<>(candidates);

        while (!available.isEmpty()) {
            int groupSize = available.size();
            long permutationsPerBranch = factorials[groupSize - 1];

            int chosenIndex = (int) (rank / permutationsPerBranch);
            result.add(available.remove(chosenIndex));

            rank %= permutationsPerBranch;
        }
        return result;
    }
}