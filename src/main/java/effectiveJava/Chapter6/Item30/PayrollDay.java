package effectiveJava.Chapter6.Item30;

// The strategy enum pattern
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;
    PayrollDay(PayType payType) { this.payType = payType; }

//    double pay(double hoursWorked, double payRate) {
//        return payType.pay(hoursWorked, payRate);
//    }
    // The strategy enum type
    private enum PayType {
        WEEKDAY {
            double overtimePay(double hours, double payRate) {
                return hours <= HOURS_PER_SHIFT ? 0 :
                  (hours - HOURS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };
        private static final int HOURS_PER_SHIFT = 8;

    abstract double overtimePay(double hrs, double payRate);

        double pay(double hoursWorked, double payRate) {
            double basePay = hoursWorked * payRate;
            return basePay + overtimePay(hoursWorked, payRate);
        }
    }

    public static void main(String[] args) {
        for(PayrollDay pd : PayrollDay.values()){
            System.out.println(pd.payType.overtimePay(15, 900));
            System.out.println(pd.payType.pay(15, 900));
        }
        System.out.println("=====================================");
        for(PayrollDay pd : PayrollDay.values()){
            System.out.println(pd.payType.overtimePay(5, 900));
            System.out.println(pd.payType.pay(15, 900));
        }
        System.out.println("=====================================");
        for(PayrollDay pd : PayrollDay.values()){
            System.out.println(pd.payType.overtimePay(8, 900));
            System.out.println(pd.payType.pay(15, 900));
        }
        System.out.println("=====================================");
        System.out.println(PayType.WEEKDAY);
        System.out.println(PayType.WEEKDAY.ordinal());
        System.out.println(PayType.WEEKEND.ordinal());


    }
}
