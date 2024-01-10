import java.util.Arrays;

public class UndoomedDiceChallenge {

    public static void main(String[] args) {
        // Initial dice configuration
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = Arrays.copyOf(dieA, dieA.length);

        // Apply the transformation
        int[] newDieA = undoom_dice(dieA, dieB);
        int[] newDieB = Arrays.copyOf(newDieA, newDieA.length);

        // Display the results
        System.out.println("Original Die A: " + Arrays.toString(dieA));
        System.out.println("Original Die B: " + Arrays.toString(dieB));
        System.out.println("New Die A: " + Arrays.toString(newDieA));
        System.out.println("New Die B: " + Arrays.toString(newDieB));
    }

    private static int[] undoom_dice(int[] dieA, int[] dieB) {
        int[] newDieA = new int[dieA.length];

        // Clone the original probabilities matrix for comparison
        int[][] originalProbabilities = calculateProbabilities(dieA, dieB);

        // Iterate through each face of Die A
        for (int i = 0; i < dieA.length; i++) {
            int originalSpots = dieA[i];

            // Try attaching 1 to 4 spots on the face of Die A
            for (int newSpots = 1; newSpots <= 4; newSpots++) {
                newDieA[i] = newSpots;

                // Recalculate probabilities for the new configuration
                int[][] newProbabilities = calculateProbabilities(newDieA, dieB);

                // Check if probabilities are the same
                if (Arrays.deepEquals(originalProbabilities, newProbabilities)) {
                    // Found a valid configuration, break the loop
                    break;
                }
            }
        }

        return newDieA;
    }

    private static int[][] calculateProbabilities(int[] dieA, int[] dieB) {
        int[][] probabilities = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                probabilities[i][j] = dieA[i] + dieB[j];
            }
        }

        return probabilities;
    }
}
Output :-
Original Die A: [1, 2, 3, 4, 5, 6]
Original Die B: [1, 2, 3, 4, 5, 6]
New Die A: [4, 4, 4, 4, 4, 4]
New Die B: [4, 4, 4, 4, 4, 4]
