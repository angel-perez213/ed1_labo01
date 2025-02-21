package ed.lab;

import java.util.stream.IntStream;
import ed.lab.SortingAlgorithms;

public class Main {
    private static final ArrayGenerator<Integer> sortedArrayGenerator = length ->
            IntStream.range(0, length).boxed().toArray(Integer[]::new);

    private static final ArrayGenerator<Integer> invertedArrayGenerator = length ->
            IntStream.iterate(length - 1, i -> i - 1).limit(length).boxed().toArray(Integer[]::new);

    private static final ArrayGenerator<Integer> randomArrayGenerator = length ->
            IntStream.generate(() -> (int) (Math.random() * length)).limit(length).boxed().toArray(Integer[]::new);

    private static final ArrayGenerator<String> sortedStringArrayGenerator = length ->
            IntStream.range(0, length).mapToObj(i -> "Str" + i).toArray(String[]::new);

    private static final ArrayGenerator<String> randomStringArrayGenerator = length ->
            java.util.stream.Stream.generate(() -> "Str" + (int) (Math.random() * length))
                    .limit(length)
                    .toArray(String[]::new);

    private static final QuickSort<Integer> highPivotQuickSort = SortingAlgorithms::<Integer>highPivotQuickSort;
    private static final QuickSort<Integer> lowPivotQuickSort = SortingAlgorithms::<Integer>lowPivotQuickSort;
    private static final QuickSort<Integer> randomPivotQuickSort = SortingAlgorithms::<Integer>randomPivotQuickSort;

    private static final QuickSort<String> highPivotStringQuickSort = SortingAlgorithms::<String>highPivotQuickSort;
    private static final QuickSort<String> lowPivotStringQuickSort = SortingAlgorithms::<String>lowPivotQuickSort;
    private static final QuickSort<String> randomPivotStringQuickSort = SortingAlgorithms::<String>randomPivotQuickSort;

    public static QuickSort<Integer> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<Integer> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<Integer> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static QuickSort<String> getHighPivotStringQuickSort() {
        return highPivotStringQuickSort;
    }

    public static QuickSort<String> getLowPivotStringQuickSort() {
        return lowPivotStringQuickSort;
    }

    public static QuickSort<String> getRandomPivotStringQuickSort() {
        return randomPivotStringQuickSort;
    }

    public static ArrayGenerator<Integer> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<Integer> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static ArrayGenerator<String> getSortedStringArrayGenerator() {
        return sortedStringArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomStringArrayGenerator() {
        return randomStringArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<Integer> tester = new SortingTester<>();
        final SortingTester<String> stringTester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado (Integer):");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido (Integer):");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio (Integer):");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo ordenado (String):");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        stringTester.testSorting(sortedStringArrayGenerator, highPivotStringQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        stringTester.testSorting(sortedStringArrayGenerator, lowPivotStringQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        stringTester.testSorting(sortedStringArrayGenerator, randomPivotStringQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio (String):");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        stringTester.testSorting(randomStringArrayGenerator, highPivotStringQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        stringTester.testSorting(randomStringArrayGenerator, lowPivotStringQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        stringTester.testSorting(randomStringArrayGenerator, randomPivotStringQuickSort);
        System.out.println("================================");
    }
}
