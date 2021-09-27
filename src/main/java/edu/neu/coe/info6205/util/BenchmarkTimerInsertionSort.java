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
    
        public static Integer[] reverseSortedArrayGeneration(int k){

        Integer[] in = new Integer[k];
        for(int i = 0; i<k;i++){
            in[i] = k-i;
        }
        return in;
    }
      public static Integer[] sortedArrayGeneration(int k){

        Integer[] in = new Integer[k];
        for(int i = 1; i<=k;i++){
            in[i-1] = 2*i;
        }
        return in;
    }

    public static Integer[] partiallySortedArrayGeneration(int k){


        Random rand = new Random();
        Integer[] in = new Integer[k];
        for (int i = 0; i<k/2; i++){
            in[i] = i;
        }

        for (int i = k/2; i<k; i++){

            in[i] =  rand.nextInt(K) + k/2;
        }

        return in;
    }
     public static Integer[] randomArrayGeneration(int k){


        Random rand = new Random();
        Integer[] in = new Integer[k];
        for(int i = 0; i<K;i++){
            in[i] = rand.nextInt(k) + 1;
        }
        return in;
    }
  

   

    public static void runBenchmarkTest(int K, String description, Supplier<Integer[]> supplier){

        Helper<Integer> helper = new BaseHelper<>(description, k, config);
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


            int k = 1000;
           

            String description = "Insertion sort for ordered array of size: " + k;
            Supplier<Integer[]> supplier = () -> sortedArrayGeneration(k);
            runBenchmarkTest(k, description, supplier);

            description = "Insertion sort for reverse-ordered array of size: " + k;
            supplier = () -> reverseSortedArrayGeneration(k);
            runBenchmarkTest(k, description, supplier);

            description = "Insertion sort for random numbers in a array of size: " + k;
            supplier = () -> randomArrayGeneration(k);
            runBenchmarkTest(k, description, supplier);

            description = "Insertion sort for partially - ordered array of size: " + k;
            supplier = () -> partiallySortedArrayGeneration(k);
            runBenchmarkTest(k, description, supplier);

        

  
    }



}
