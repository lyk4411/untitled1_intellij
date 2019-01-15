package JavaConcurrencyinPractice;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CasNumberRange
 * <p>
 * Preserving multivariable invariants using CAS
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CasNumberRange {
    public static void main(String[] args) {
        CasNumberRange cnp = new CasNumberRange();

        System.out.println(cnp.getLower());
        System.out.println(cnp.getUpper());
        cnp.setLower(1);
        cnp.setUpper(99);
        System.out.println(cnp.getLower());
        System.out.println(cnp.getUpper());
        cnp.values.set(new IntPair(6, 88));
        System.out.println(cnp.getLower());
        System.out.println(cnp.getUpper());
//        cnp.values.get().lower = 100;
//        cnp.values.get().upper = 1;
//        System.out.println(cnp.getLower());
//        System.out.println(cnp.getUpper());
    }
    public static class IntPair {
        // INVARIANT: lower <= upper
        public final int lower;
        public final int upper;

        public IntPair(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }

    public final AtomicReference<IntPair> values =
            new AtomicReference<IntPair>(new IntPair(0, 100));

    public int getLower() {
        return values.get().lower;
    }

    public int getUpper() {
        return values.get().upper;
    }

    public void setLower(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i > oldv.upper)
                throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
            IntPair newv = new IntPair(i, oldv.upper);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }

    public void setUpper(int i) {
        while (true) {
            IntPair oldv = values.get();
            if (i < oldv.lower)
                throw new IllegalArgumentException("Can't set upper to " + i + " < lower");
            IntPair newv = new IntPair(oldv.lower, i);
            if (values.compareAndSet(oldv, newv))
                return;
        }
    }
}
