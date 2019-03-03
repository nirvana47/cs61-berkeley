public class ArrayMax {
    public static void main(String[] args) {
        // declaring an array style 1
        int[] numbers1 = new int[3];
        numbers1[0] = 4;
        numbers1[1] = 7;
        numbers1[2] = 10;
        System.out.println(numbers1[1]);

        // declaring an array style 2
        int[] numbers2 = new int[] { 4, 7, 10 };
        System.out.println(numbers2[0]);

        System.out.println("Length of 1st Array: " + numbers1.length + " and length of 2nd Array: " + numbers2.length);
    }
}