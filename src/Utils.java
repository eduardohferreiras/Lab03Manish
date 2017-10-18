public class Utils {
    public static int char2int (char c) {
        if (c == '1') {
            return 1;
        }
        return 0;
    }

    public static String int2char(int i) {
        if (i==0) {
            return "0";
        }
        return "1";
    }
}
