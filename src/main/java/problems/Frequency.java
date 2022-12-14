package problems;

public class Frequency {
    public static int[] frequency(int[] a){
        boolean ok = false;
        int[] b = new int[5];
        for (int i = 0; i < a.length; i++){
            int m = h(a[i], a);

            for (int j = 0; j < b.length; j++){
                if (a[i] == b[j]){
                    ok = true;
                }
            }
            if (ok == false){
                b[i] = a[i];
            }
        }

        return b;
    }

    private static int h(int i, int[] a) {
        int count = 0;
        for (int p = 0; p < a.length; p++){
            if (a[p] == i) count++;
        }
        return count;
    }
}
