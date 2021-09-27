package edu.neu.coe.info6205;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.GenericSort;
import edu.neu.coe.info6205.sort.Helper;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class BenchmarkTimerInsertionSort {
    private static Config config;
    
    public static Integer[] reverseSortedArrayGeneration(int N){

    Integer[] in = new Integer[N];
    for(int i = 0; i<N;i++){
        in[i] = N-i;
    }
    return in;
}


public static Integer[] partiallySortedArrayGeneration(int N){


    Random rand = new Random();
    Integer[] in = new Integer[N];
    for (int i = 0; i<N/2; i++){
        in[i] = i;
    }

    for (int i = N/2; i<N; i++){

        in[i] =  rand.nextInt(N) + N/2;
    }

    return in;
}
 public static Integer[] randomArrayGeneration(int N){


    Random rand = new Random();
    Integer[] in = new Integer[N];
    for(int i = 0; i<N;i++){
        in[i] = rand.nextInt(N) + 1;
    }
    return in;
}
 public static Integer[] sortedArrayGeneration(int N){

	    Integer[] in = new Integer[N];
	    for(int i = 1; i<=N;i++){
	        in[i-1] = 2*i;
	    }
	    return in;
	}



public static void runBenchmarkTest(int N, String description, Supplier<Integer[]> supplier){

    Helper<Integer> helper = new BaseHelper<>(description, N, config);
    final GenericSort<Integer> sort = new InsertionSort<>(helper);
    final Benchmark<Integer[]> benchmark = new Benchmark_Timer<>(
            description ,
            (xs) -> Arrays.copyOf(xs, xs.length),
            sort::sort,
            null

    );
    System.out.println(benchmark.runFromSupplier(supplier, 5) + "ms");
}


public static void main(String[] args) {


        int N = 1000;
       

        String description = "Insertion sort for ordered array of size: " + N;
        Supplier<Integer[]> supplier = () -> sortedArrayGeneration(N);
        runBenchmarkTest(N, description, supplier);
        
        description = "Insertion sort for partially - ordered array of size: " + N;
        supplier = () -> partiallySortedArrayGeneration(N);
        runBenchmarkTest(N, description, supplier);
        
        description = "Insertion sort for random numbers in a array of size: " + N;
        supplier = () -> randomArrayGeneration(N);
        runBenchmarkTest(N, description, supplier);



        description = "Insertion sort for reverse-ordered array of size: " + N;
        supplier = () -> reverseSortedArrayGeneration(N);
        runBenchmarkTest(N, description, supplier);

       
        
    


}
	

}
