package javaTuning.ch02.flyweight;

public class Main {

	public static void main(String[] args) {
		ReportManagerFactory rmf=new ReportManagerFactory();
		IReportManager rm=rmf.getFinancialReportManager("A");
		System.out.println(rm.createReport());
		IReportManager rm1=rmf.getFinancialReportManager("A");
		IReportManager rm2=rmf.getFinancialReportManager("B");
		System.out.println(rm1.createReport());
		System.out.println(rm2.createReport());
	}
}
