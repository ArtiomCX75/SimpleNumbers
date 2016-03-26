import java.util.ArrayList;
import java.util.Date;

public class CalcNumbers {
	public static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		long time = (long ) new Date().getTime();

		long x8 = 1_000_000_000L;

		long x1 = x8 / 8;
		long x2 = x1 * 2;
		long x3 = x1 * 3;
		long x4 = x1 * 4;
		long x5 = x1 * 5;
		long x6 = x1 * 6;
		long x7 = x1 * 7;

		CalcThread t0 = new CalcThread(7, x1);
		CalcThread t1 = new CalcThread(x1, x2);
		CalcThread t2 = new CalcThread(x2, x3);
		CalcThread t3 = new CalcThread(x3, x4);
		CalcThread t4 = new CalcThread(x4, x5);
		CalcThread t5 = new CalcThread(x5, x6);
		CalcThread t6 = new CalcThread(x6, x7);
		CalcThread t7 = new CalcThread(x7, x8);
		list.add(2l);
		list.add(3l);
		list.add(5l);
		
		t0.start();

		while (t0.iter < Math.sqrt(x1)) {
			Thread.sleep(10);
		}
		t1.start();

		while (t0.iter < Math.sqrt(x2)) {
			Thread.sleep(10);
		}
		t2.start();

		while (t0.iter < Math.sqrt(x3)) {
			Thread.sleep(10);
		}
		t3.start();

		while (t0.iter < Math.sqrt(x4)) {
			Thread.sleep(10);
		}
		t4.start();

		while (t0.iter < Math.sqrt(x5)) {
			Thread.sleep(10);
		}
		t5.start();

		while (t0.iter < Math.sqrt(x6)) {
			Thread.sleep(10);
		}
		t6.start();
		
		while (t0.iter < Math.sqrt(x7)) {
			Thread.sleep(10);
		}
		t7.start();

		t0.join();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		t7.join();

		time = (long ) new Date().getTime() - time;
		System.out.println("count " + list.size());
		System.out.println("time " + ((double) time / 1000));
	}

	synchronized public static void addToList(long  num) {
		list.add(num);
	}
}
