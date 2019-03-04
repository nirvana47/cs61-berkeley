public class BreakContinue {

    /**
     * windowPosSum(int[] a, int n) Replaces each element a[i] with the sum of a[i]
     * through a[i + n], but only if a[i] is positive valued. If there are not
     * enough values because we reach the end of the array, we sum only as many
     * values as we have.
     * 
     * @param a
     * @param n
     */
    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length - 1; i++) {
            // we don't need to run this loop for the last item in the array
            // so i < (a.length - 1)
            if (a[i] < 0) {
                continue;
                // if the array element is negative, we skip ahead out of the loop
            }
            int x = 0;
            for (int j = 0; j <= n; j++) {
                if (i + j >= a.length) {
                    continue;
                    // if we are at the i'th element, and somewhere between i and i + n we exceed
                    // the length of the array, we need to skip out of the loop before it.
                }
                x += a[i + j]; // adding up a[i] to a[i+n] in to 'x'
            }
            a[i] = x; // assigning x to the a[i]'th element after addition
        }
    }

    public static void main(String[] args) {
        // int[] a = { 1, 2, -3, 4, 5, 4 };
        // int n = 3;
        int[] a = {1, 11, -1, 10, 5, -1};
        int n = 1;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}