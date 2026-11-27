package src.String.Assignment.level1;

public class Q4_NullPointerException {
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // Deliberately throws NullPointerException.
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.toUpperCase());
        } catch (NullPointerException ex) {
            System.out.println("NullPointerException handled: text is null.");
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException handled: " + ex);
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException ex) {
            System.out.println("Generated exception caught in main: " + ex.getClass().getSimpleName());
        }
        handleException();
    }
}
