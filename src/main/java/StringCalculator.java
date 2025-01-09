public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            String delimiterLine = numbers.split("\n")[0];
            String delimiters = delimiterLine.substring(2);

            // If the delimiter is enclosed in square brackets, handle multiple delimiters
            if (delimiters.startsWith("[")) {
                delimiters = delimiters.substring(1, delimiters.length() - 1);
                String[] delimiterArray = delimiters.split("\\]\\[");

                for (String delimiter : delimiterArray) {
                    numbers = numbers.replace(delimiter, ",");
                }
            } else {
                numbers = numbers.replace(delimiters, ",");
            }

            numbers = numbers.substring(delimiterLine.length() + 1);

        } else {
            numbers = numbers.replace("\n", ",");
        }

        String[] numArray = numbers.split(",");

        int sum = 0;
        for (String num : numArray) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
