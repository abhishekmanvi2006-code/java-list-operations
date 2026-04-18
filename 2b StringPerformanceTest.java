public class StringPerformanceTest {
    public static void main(String[] args) {
        int iterations = 10000;
        String appendString = "AIET";

        // Test StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < iterations; i++) {
            stringBuffer.append(appendString);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " ns");

        // Test StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < iterations; i++) {
            stringBuilder.append(appendString);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " ns");

        // Justification
        System.out.println();
        if(durationBuffer > durationBuilder) {
            System.out.println("StringBuilder is faster than StringBuffer for appending strings.");
        } else {
            System.out.println("StringBuffer is faster than StringBuilder for appending strings.");
        }
    }
}