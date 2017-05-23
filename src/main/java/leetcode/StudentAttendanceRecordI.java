package leetcode;

/**
 * Created by lyk on 2017/5/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StudentAttendanceRecordI {
    public static void main(String[] args) {
        StudentAttendanceRecordI sari = new StudentAttendanceRecordI();
        System.out.println(sari.checkRecord("ALLPPPP"));
    }
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
