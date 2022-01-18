package M03_JavaAdvanced.L09_BasicAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T05MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

        sort(numbers);

        StringBuilder output = new StringBuilder();

        for (int num : numbers) {
            output.append(num).append(" ");
        }
        System.out.println(output);
    }

    private static void sort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
    }

    private static void mergeSort(int[] numbers, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;

        mergeSort(numbers, begin, mid);
        mergeSort(numbers, mid + 1, end);

        merge(numbers, begin, mid, end);
    }

    private static void merge(int[] numbers, int begin, int mid, int end) {
        if (mid < 0 || mid >= numbers.length || numbers[mid] < numbers[mid + 1]) {
            return;
        }

        int left = begin;
        int right = mid + 1;

        int[] helper = new int[numbers.length];

        for (int i = begin; i <= end; i++) {
            helper[i] = numbers[i];
        }

        for (int i = begin; i <= end; i++) {

            if (left > mid) {
                numbers[i] = helper[right++];
            } else if (right > end) {
                numbers[i] = helper[left++];
            } else if (helper[left] < helper[right]) {
                numbers[i] = helper[left++];
            } else {
                numbers[i] = helper[right++];
            }
        }
    }
}