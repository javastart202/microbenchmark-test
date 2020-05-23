package manual;

import java.util.function.Consumer;

public class ManualExecution {

       public static void repeatExecute(Runnable method, int times) {
              long startTime = System.currentTimeMillis();
              for (int i = 0; i < times; i++) {
                     long iterStartTime = System.currentTimeMillis();
                     method.run();
                     long iterEndTime = System.currentTimeMillis();
                     System.out.println("Iteration " + (i + 1) + " finished in " + (iterEndTime - iterStartTime) + "ms");
              }
              long endTime = System.currentTimeMillis();
              long timeElapsed = endTime - startTime;

              System.out.println("Execution time in milliseconds: " + timeElapsed + " avg : " + timeElapsed / times);
       }

}
