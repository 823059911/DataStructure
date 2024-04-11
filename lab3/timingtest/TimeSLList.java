package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(SLList<Integer> Ns, SLList<Double> times, SLList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
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
        int[] sizes = {1000, 5000, 10000, 20000, 30000, 40000};

        for (int size : sizes) {
            SLList<Integer> tempList = new SLList<>();
            for (int i = 0; i <= size; i++) {
                tempList.addLast(i);
            }
                int timeOfGetlast = 0;
                Stopwatch sw = new Stopwatch();
                tempList.getLast(); // 在计时器开始和结束之间调用 getLast() 方法
                timeOfGetlast++;
                double timeInSeconds = sw.elapsedTime();
                Ns.addLast(size);
                times.addLast(timeInSeconds);
                opCounts.addLast(timeOfGetlast); // 这里应该记录 getLast() 方法的调用次数

            }
            printTimingTable(Ns, times, opCounts);
        }

    }

