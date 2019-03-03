public class ArrayMax {

    public static int max(int[] m) {
        int x = 0;
        for (int counter = 0; counter < m.length; counter++) {
            if (x < m[counter])
                x = m[counter];
        }
        return x;
    }

    public static void main(String[] args) {
        // declaring an array style 1
        // int[] numbers1 = new int[3];
        // numbers1[0] = 4;
        // numbers1[1] = 7;
        // numbers1[2] = 10;
        // System.out.println(numbers1[1]);

        // declaring an array style 2
        int[] numbers2 = new int[] { 4, 7, 12, 3113, 12, 122213, 1321, 2, 12, 3, 44, 1, 2, 3, 1, 3, 10, -1, 25, 100,
                211, 47, 9, 99, 1, 2, 0, 0, 0, 11, 1, 2, 3, 4, 5, 6, 1, 3, 4, 13, 344 };
        System.out.println("The array contains: ");
        for (int i = 0; i < numbers2.length; i++) {
            System.out.print(numbers2[i] + " ");
        }

        System.out.println("\nAnd the largest value in Array is: " + max(numbers2));

        // System.out.println("Length of 1st Array: " + numbers1.length + " and length
        // of 2nd Array: " + numbers2.length);
    }
}