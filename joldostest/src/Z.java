/**
 * Created by lilla on 10/02/17.
 *
 */

public class Z extends C {
    public static final int ONE = 1;
    public static float SEVEN = 2;
    Z() {
        super(ONE);
    }
    public float doIt(int i) {
        return SEVEN * i;
    }
    public static void main(String args[]) {
        Object o1 = new Z();
        Object o2 = new Z();
        SEVEN = ((Z)o1).doIt(-1);
        System.out.println(((Z)o2).doIt(7) + " " + ((Z)o1).SEVEN);
    }
}

 class C{
    public static double SEVEN = 8;
    public C(double two) {
        System.out.println("C 3 = " + SEVEN);
        SEVEN = two;
    }
}