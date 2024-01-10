public class DoomedDiceChallenge {

    public static void main(String[] args) {
        // Part 1: Total Combinations
        int totalCombinations = calculateTotalCombinations();
        System.out.println("Total Combinations: " + totalCombinations);

        // Part 2: Distribution of Combinations
        int[][] combinationMatrix = displayCombinationDistribution();

        // Part 3: Probability of Sums
        calculateAndDisplayProbabilities(totalCombinations, combinationMatrix);
    }

    private static int calculateTotalCombinations() {
        return 6 * 6;
    }

    private static int[][] displayCombinationDistribution() {
        int[][] combinationMatrix = new int[6][6];

        System.out.println("Combination Distribution:");

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int sum = i + j;
                combinationMatrix[i - 1][j - 1] = sum;
                System.out.print(sum + " ");
            }
            System.out.println();
        }

        return combinationMatrix;
    }

    private static void calculateAndDisplayProbabilities(int totalCombinations, int[][] combinationMatrix) {
        System.out.println("\nProbability of Sums:");

        for (int targetSum = 2; targetSum <= 12; targetSum++) {
            int occurrences = 0;

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (combinationMatrix[i][j] == targetSum) {
                        occurrences++;
                    }
                }
            }

            double probability = (double) occurrences / totalCombinations;
            System.out.println("P(Sum = " + targetSum + ") = " + occurrences + "/" + totalCombinations + " = " + probability);
        }
    }
}
