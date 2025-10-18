import java.util.*;

public class CubeStructureBuilder {

    static class PlacementInstruction {
        int baseCube;
        int newCube;
        String placementSide;

        PlacementInstruction(int baseCube, int newCube, String placementSide) {
            this.baseCube = baseCube;
            this.newCube = newCube;
            this.placementSide = placementSide;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int instructionCount = reader.nextInt();
        reader.nextLine(); 

        List<PlacementInstruction> instructions = new ArrayList<>();
        for (int i = 0; i < instructionCount; i++) {
            String[] parts = reader.nextLine().split(" ");
            instructions.add(new PlacementInstruction(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1]),
                parts[2]
            ));
        }
        int queryCube = reader.nextInt();
        reader.close();

instructions.sort(Comparator.comparingInt((PlacementInstruction p) -> p.baseCube)
                            .thenComparingInt((PlacementInstruction p) -> p.newCube));        
        Map<Integer, String> cubeLocations = new HashMap<>();
        Map<String, Integer> locationToCube = new HashMap<>();

        if (!instructions.isEmpty()) {
            int initialCube = instructions.get(0).baseCube;
            String origin = "0,0";
            cubeLocations.put(initialCube, origin);
            locationToCube.put(origin, initialCube);
        }

        Map<String, int[]> directionDeltas = Map.of(
            "top",   new int[]{0, 1},
            "down",  new int[]{0, -1},
            "left",  new int[]{-1, 0},
            "right", new int[]{1, 0}
        );

        for (PlacementInstruction instruction : instructions) {
            String baseLocationStr = cubeLocations.get(instruction.baseCube);
            if (baseLocationStr == null) {
                continue;
            }

            String[] xy = baseLocationStr.split(",");
            int baseX = Integer.parseInt(xy[0]);
            int baseY = Integer.parseInt(xy[1]);

            int[] delta = directionDeltas.get(instruction.placementSide);
            int newX = baseX + delta[0];
            int newY = baseY + delta[1];
            String newLocationStr = newX + "," + newY;

            if (locationToCube.containsKey(newLocationStr)) {
                int displacedCube = locationToCube.get(newLocationStr);
                cubeLocations.remove(displacedCube);
            }

            locationToCube.put(newLocationStr, instruction.newCube);
            cubeLocations.put(instruction.newCube, newLocationStr);
        }

        String targetLocationStr = cubeLocations.get(queryCube);
        if (targetLocationStr == null) {
            System.out.println("-1 -1 -1 -1");
        } else {
            String[] targetXY = targetLocationStr.split(",");
            int targetX = Integer.parseInt(targetXY[0]);
            int targetY = Integer.parseInt(targetXY[1]);

            int neighborUp = locationToCube.getOrDefault((targetX) + "," + (targetY + 1), -1);
            int neighborDown = locationToCube.getOrDefault((targetX) + "," + (targetY - 1), -1);
            int neighborLeft = locationToCube.getOrDefault((targetX - 1) + "," + (targetY), -1);
            int neighborRight = locationToCube.getOrDefault((targetX + 1) + "," + (targetY), -1);

            System.out.printf("%d %d %d %d%n", neighborUp, neighborDown, neighborLeft, neighborRight);
        }
    }
}