import java.util.HashMap;
import java.util.Set;

class intCopy {
    public static void main(String[] args) {
        // test cases
        int[] x = { 1, 1, 2, 3, 4, 3, 2, 1, 0, 0 };
        int[] y = { 1 };
        int[] z = { 12, 1, 22, 3, 43, 3, 2, 14, 0, 0 };

        System.out.println(copyBuster(z));
    }

    public static int copyBuster(int[] x) {
        // send back the number if the array is only 1 in length
        if (x.length == 1) {
            return x[0];
        }
        int recur;
        int maxIndex = 0;
        int max = 0;

        // create a map to hold the entries
        HashMap<Integer, Integer> ref = new HashMap<>();
        // loop through (going for that single loop solution)
        for (int i = 0; i < x.length; i++) {
            // if there is an entry, add/overwrite the value
            if (ref.containsKey(x[i])) {
                ref.put(x[i], ref.get(x[i]) + 1);
                // check if the count is the highest so far
                if (ref.get(x[1]) > max) {
                    max = ref.get(x[1]);
                    maxIndex = x[i];
                }
            } else {
                ref.put(x[i], 1);
            }

        }
        // System.out.println(ref);

        // Return the key with the highest value:
        return maxIndex;
    }
}