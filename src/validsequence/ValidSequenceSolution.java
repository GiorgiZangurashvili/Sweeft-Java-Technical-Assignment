package validsequence;

public class ValidSequenceSolution {

    public static void main(String[] args) {
        var solution = new ValidSequenceSolution();

        int[] array = new int[]{};
        int[] sequence = new int[]{1};
        System.out.println(solution.isValidSequence(array, sequence)); // expected = false

        array = new int[] {5, 1, 22, 25, 6, -1, 8, 10};
        sequence = new int[] {1, 6, -1, 10};
        System.out.println(solution.isValidSequence(array, sequence)); // expected = true
    }

    private boolean isValidSequence(int[] array, int[] sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while (true) {
            if (sequenceIndex >= sequence.length) {
                return true;
            }
            if (arrayIndex >= array.length) {
                return false;
            }

            if (array[arrayIndex] == sequence[sequenceIndex]) {
                arrayIndex++;
                sequenceIndex++;
            } else {
                arrayIndex++;
            }
        }
    }

}
