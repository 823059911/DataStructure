package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        //建立存储不同规模的测试集
        int[]size={10000,20000,30000,40000,50000};
        for(int elem:size){
            //循环之前开始计时
            Stopwatch sw = new Stopwatch();
            //
            AList<Integer>tempList=new AList<>();
            for(int i=1;i<elem;i++){
                tempList.addLast(i);
            }
            //循环结束，停止计时
            double timeInSeconds = sw.elapsedTime();
            //循环结束，将size添加进去
            opCounts.addLast(elem);
            //循环结束，将执行时间添加进去
            times.addLast(timeInSeconds);
            Ns.addLast(elem);
        }
        printTimingTable(Ns,times,opCounts);
    }
}

