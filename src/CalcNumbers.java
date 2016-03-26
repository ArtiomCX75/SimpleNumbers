import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class CalcNumbers {
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		int time = (int) new Date().getTime();

		int x8 = 1_000_000_000;

		int x1 = x8 / 8;
		int x2 = x1 * 2;
		int x3 = x1 * 3;
		int x4 = x1 * 4;
		int x5 = x1 * 5;
		int x6 = x1 * 6;
		int x7 = x1 * 7;

		CalcThread t0 = new CalcThread(3, x1);
		CalcThread t1 = new CalcThread(x1, x2);
		CalcThread t2 = new CalcThread(x2, x3);
		CalcThread t3 = new CalcThread(x3, x4);
		CalcThread t4 = new CalcThread(x4, x5);
		CalcThread t5 = new CalcThread(x5, x6);
		CalcThread t6 = new CalcThread(x6, x7);
		CalcThread t7 = new CalcThread(x7, x8);
		list.add(2);
		t0.start();

		while (t0.iter < Math.sqrt(x1)) {
			Thread.sleep(1);
		}
		t1.start();

		while (t0.iter < Math.sqrt(x2)) {
			Thread.sleep(1);
		}
		t2.start();

		while (t0.iter < Math.sqrt(x3)) {
			Thread.sleep(1);
		}
		t3.start();

		while (t0.iter < Math.sqrt(x4)) {
			Thread.sleep(1);
		}
		t4.start();

		while (t0.iter < Math.sqrt(x5)) {
			Thread.sleep(10);
		}
		t5.start();

		while (t0.iter < Math.sqrt(x6)) {
			Thread.sleep(1);
		}
		t6.start();
		while (t0.iter < Math.sqrt(x7)) {
			Thread.sleep(1);
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

		System.out.println("count1 " + list.size());
		System.out.println("time " + ((double) time / 1000));
	}

	synchronized public static void addToList(int num) {
		list.add(num);
	}
}
