import java.util.ArrayList;
import java.util.Date;

public class CalcNumbers {
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		int time = (int) new Date().getTime();
		int x1 = 50_000_000;
		int x2 = 75_000_000;
		int x3 = 100_000_000;
		int x4 = 125_000_000;
		int x5 = 150_000_000;
		int x6 = 175_000_000;
		int x7 = 195_000_000;
		int x8 = 200_000_000;

		CalcThread t0 = new CalcThread(2, x1);
		CalcThread t1 = new CalcThread(x1, x2);
		CalcThread t2 = new CalcThread(x2, x3);
		CalcThread t3 = new CalcThread(x3, x4);
		CalcThread t4 = new CalcThread(x4, x5);
		CalcThread t5 = new CalcThread(x5, x6);
		CalcThread t6 = new CalcThread(x6, x7);
		CalcThread t7 = new CalcThread(x7, x8);

		t0.start();

		while (t0.iter < x1 / 2) {
			Thread.sleep(1000);
		}
		t1.start();

		while (t0.iter < x2 / 2) {
			Thread.sleep(1000);
		}
		t2.start();

		while (t1.iter < x3 / 2) {
			Thread.sleep(1000);
		}
		t3.start();

		while (t1.iter < x4 / 2) {
			Thread.sleep(1000);
		}
		t4.start();

		while (t1.iter < x5 / 2) {
			Thread.sleep(1000);
		}
		t5.start();

		while (t2.iter < x6 / 2) {
			Thread.sleep(1000);
		}
		t6.start();
		while (t3.iter < x7 / 2) {
			Thread.sleep(1000);
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

		time = (int) new Date().getTime() - time;
		System.out.println("count " + list.size());
		System.out.println("time " + ((double) time / 1000));

	}

	synchronized public static void addToList(int num) {
		list.add(num);
	}
}
