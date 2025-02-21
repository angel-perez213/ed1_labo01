package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    // Método para QuickSort con el último elemento como pivote
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        System.out.println("Antes de ordenar (High Pivot):");
        printArray(array);
        quickSort(array, 0, array.length - 1, PivotStrategy.HIGH);
        System.out.println("Después de ordenar (High Pivot):");
        printArray(array);
    }

    // Método para QuickSort con el primer elemento como pivote
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        System.out.println("Antes de ordenar (Low Pivot):");
        printArray(array);
        quickSort(array, 0, array.length - 1, PivotStrategy.LOW);
        System.out.println("Después de ordenar (Low Pivot):");
        printArray(array);
    }

    // Método para QuickSort con un elemento aleatorio como pivote
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        System.out.println("Antes de ordenar (Random Pivot):");
        printArray(array);
        quickSort(array, 0, array.length - 1, PivotStrategy.RANDOM);
        System.out.println("Después de ordenar (Random Pivot):");
        printArray(array);
    }

    // Método privado que implementa el algoritmo QuickSort
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, PivotStrategy strategy) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, strategy);
            quickSort(array, low, pivotIndex - 1, strategy);
            quickSort(array, pivotIndex + 1, high, strategy);
        }
    }

    // Método para particionar el arreglo según la estrategia de pivote
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, PivotStrategy strategy) {
        int pivotIndex = selectPivotIndex(array, low, high, strategy);
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, high); // Mover pivote al final
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high); // Mover pivote a su posición correcta
        return i + 1;
    }

    // Método para seleccionar el índice del pivote según la estrategia
    private static <T extends Comparable<T>> int selectPivotIndex(T[] array, int low, int high, PivotStrategy strategy) {
        return switch (strategy) {
            case LOW -> low;
            case RANDOM -> new Random().nextInt(high - low + 1) + low;
            case HIGH -> high;
        };
    }

    // Método para intercambiar elementos en el arreglo
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método auxiliar para imprimir el arreglo
    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Enumeración para las estrategias de selección de pivote
    private enum PivotStrategy {
        LOW,
        HIGH,
        RANDOM
    }
}