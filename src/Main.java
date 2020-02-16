import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello,");
        String[] arr;
        int threshold;
        List<Integer> list;
        while (true) {
            try {
                System.out.print("Enter candies:");
                arr = scanner.nextLine()
                        .split(", ");
                System.out.print("Threshold: ");
                threshold = Integer.parseInt(scanner.nextLine());
                list = Arrays.stream(arr).
                        map(Integer::parseInt)
                        .sorted()
                        .collect(Collectors.toList());
                if (list.get(0) < 0 ||
                        list.get(list.size() - 1) > 100 ||
                        threshold < 1) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input!");
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) + sum > threshold) {
                list.subList(i, list.size()).clear();
                break;
            } else {
                sum += list.get(i);
            }
        }
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(Integer.parseInt(arr[i]))) {
                if (n == list.size()) {
                    break;
                }
                result.append(i);
                if(n!=list.size()-1) {
                    result.append(", ");
                }
                n++;
            }
        }
        System.out.printf("sugarHigh(candies , threshold) = [%s].%n", result.toString());
    }
}
