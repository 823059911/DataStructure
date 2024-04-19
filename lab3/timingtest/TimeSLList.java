package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

public class TimeSLList {
    private static void printTimingTable(SLList<Integer> Ns, SLList<Double> times, SLList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount *1000000;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }
    public static void timeGetLast() {
        SLList<Integer> Ns = new SLList<>();
        SLList<Double> times = new SLList<>();
        SLList<Integer> opCounts = new SLList<>();
        int[] sizes = {10000,20000,40000,50000,60000,80000};
        for (int size : sizes) {
            SLList<Integer> tempList = new SLList<>();
            double timeInSeconds;
            for (int i = 0; i <= size; i++) {
                tempList.addLast(i);
            }
                Stopwatch sw = new Stopwatch();
                tempList.getLast();
                timeInSeconds = sw.elapsedTime();
                Ns.addLast(size);
                times.addLast(timeInSeconds);
                opCounts.addLast(1); // 记录 getLast() 方法的调用次数
            }
            printTimingTable(Ns, times, opCounts);
        }

    }

