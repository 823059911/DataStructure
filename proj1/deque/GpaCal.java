package deque;

public class GpaCal {
    public double gpaCalculator(int[] a) {
        double[] temp = new double[a.length];
        if (a == null) {
            return 0;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 90 && a[i] <= 100) {
                temp[i] = 1.0;
            }
            if (a[i] >= 85 && a[i] <= 89) {
                temp[i] = 1.3;
            }
            if (a[i] >= 80 && a[i] <= 84) {
                temp[i] = 1.7;
            }
            if (a[i] >= 75 && a[i] <= 79) {
                temp[i] = 2.0;
            }
            if (a[i] >= 70 && a[i] <= 74) {
                temp[i] = 2.3;
            }
            if (a[i] >= 65 && a[i] <= 69) {
                temp[i] = 2.7;
            }
            if (a[i] >= 60 && a[i] <= 64) {
                temp[i] = 3.0;
            }
        }
        double gpa = 0; // 初始化 gpa 变量
        for (double elem : temp) {
            gpa += elem;
        }
        return gpa/temp.length;
    }
    public static void main(String[] args) {
        GpaCal a = new GpaCal();
        int[] b = { 79, 90, 75, 83, 72, 93, 88, 84, 88, 94, 90, 91, 92, 90, 90, 90, 90, 94, 83, 90, 84, 80, 90 };
        System.out.println(a.gpaCalculator(b));
        System.out.println(b.length);
    }
}
