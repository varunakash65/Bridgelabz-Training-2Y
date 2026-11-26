package src.String.Assignment.LinearBinarySearch;

public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        final int repetitions = 1_000_000;
        final String value = "hello";

        StringBuilder builder = new StringBuilder();
        long builderStart = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            builder.append(value);
        }
        long builderTime = System.nanoTime() - builderStart;

        StringBuffer buffer = new StringBuffer();
        long bufferStart = System.nanoTime();
        for (int i = 0; i < repetitions; i++) {
            buffer.append(value);
        }
        long bufferTime = System.nanoTime() - bufferStart;

        System.out.println("StringBuilder time: " + builderTime + " ns");
        System.out.println("StringBuffer time:  " + bufferTime + " ns");
        System.out.println("StringBuilder length: " + builder.length());
        System.out.println("StringBuffer length:  " + buffer.length());
    }
}
