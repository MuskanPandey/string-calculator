public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        }

        String[] numArray = numbers.split(",");
        int sum = 0;
        for (String num : numArray) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
