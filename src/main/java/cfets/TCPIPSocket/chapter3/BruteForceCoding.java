package cfets.TCPIPSocket.chapter3;

/**
 * Created by lyk on 2016/7/26.
 * Package name: cfets.TCPIPSocket.chapter3
 * Porject name: untitled1
 */

public class BruteForceCoding {
    private static byte byteVal = 101; // one hundred and one
    private static short shortVal = 10001; // ten thousand and one
    private static int intVal = 100000001; // one hundred million and one
    private static long longVal = 1000000000001L;// one trillion and one

    private final static int BSIZE = Byte.SIZE / Byte.SIZE;
    private final static int SSIZE = Short.SIZE / Byte.SIZE;
    private final static int ISIZE = Integer.SIZE / Byte.SIZE;
    private final static int LSIZE = Long.SIZE / Byte.SIZE;

    private final static int BYTEMASK = 0xFF; // 8 bits

    public static String byteArrayToDecimalString(byte[] bArray) {
        StringBuilder rtn = new StringBuilder();
        for (byte b : bArray) {
            rtn.append(b & BYTEMASK).append(" ");
        }
        return rtn.toString();
    }

    // Warning:  Untested preconditions (e.g., 0 <= size <= 8)
    public static int encodeIntBigEndian(byte[] dst, long val, int offset, int size) {
        for (int i = 0; i < size; i++) {
            dst[offset++] = (byte) (val >> ((size - i - 1) * Byte.SIZE));
        }
        return offset;
    }

    // Warning:  Untested preconditions (e.g., 0 <= size <= 8)
    public static long decodeIntBigEndian(byte[] val, int offset, int size) {
        long rtn = 0;
        for (int i = 0; i < size; i++) {
            rtn = (rtn << Byte.SIZE) | ((long) val[offset + i] & BYTEMASK);
        }
        return rtn;
    }

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("BSIZE:" + BSIZE);
        System.out.println("SSIZE:" + SSIZE);
        System.out.println("ISIZE:" + ISIZE);
        System.out.println("LSIZE:" + LSIZE);
        System.out.println("===================================");

        byte[] message = new byte[BSIZE + SSIZE + ISIZE + LSIZE];
        // Encode the fields in the target byte array
        int offset = encodeIntBigEndian(message, byteVal, 0, BSIZE);
        System.out.println("offset 1: " + offset);
        offset = encodeIntBigEndian(message, shortVal, offset, SSIZE);
        System.out.println("offset 2: " + offset);
        offset = encodeIntBigEndian(message, intVal, offset, ISIZE);
        System.out.println("offset 3: " + offset);
        System.out.println("value of message: " + String.valueOf(message));

        encodeIntBigEndian(message, longVal, offset, LSIZE);
        System.out.println("Encoded message: " + byteArrayToDecimalString(message));

        // Decode several fields
        long value = decodeIntBigEndian(message, BSIZE, SSIZE);
        System.out.println("Decoded short = " + value);
        value = decodeIntBigEndian(message, BSIZE + SSIZE + ISIZE, LSIZE);
        System.out.println("Decoded long = " + value);

        // Demonstrate dangers of conversion
        offset = 4;
        value = decodeIntBigEndian(message, offset, BSIZE);
        System.out.println("Decoded value (offset " + offset + ", size " + BSIZE + ") = "
                + value);
        byte bVal = (byte) decodeIntBigEndian(message, offset, BSIZE);
        System.out.println("Same value as byte = " + bVal);
    }

}
