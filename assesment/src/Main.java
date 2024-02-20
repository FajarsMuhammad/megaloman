public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(reverse("ale"));
        System.out.println(prime(100));
    }


    public static String reverse(String input) {
        byte[] strByteArray = input.getBytes();
        byte[] result = new byte[strByteArray.length];

        for (int i = 0; i < strByteArray.length; i++) {
            result[i] = strByteArray[strByteArray.length - i - 1];
        }
        return new String(result);
    }

    public static String prime(int input) {
        StringBuilder builder = new StringBuilder();
        for (int j = 1; j <= input; j++) {
            int count = 0;
            for (int i = 1; i <= j; i++) {
                if (j % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                builder
                    .append("Bilangan prima ")
                    .append(j)
                    .append(" ");
            } else {
                builder.append(j)
                    .append(" ");
            }
        }
        return builder.toString();
    }
}