
public class CalcThread extends Thread {
	long fromnum;
	long tonum;
	public long iter;

	public CalcThread(long from, long to) {
		if (from % 2 == 0)
			from--;
		if (to % 2 == 0)
			to--;
		fromnum = from;
		tonum = to;
	}

	@Override
	public void run() {
		System.out.println(this.getName() + " starts");
		calc();
		System.out.println(this.getName() + " ends");
	}

	public void calc() {
		for (iter = fromnum; iter < tonum; iter += 2) {
			if ((iter % 5 == 0) || (iter % 3 == 0))
				continue;
			if (!(hasDiv(iter))) {
				CalcNumbers.addToList(iter);
			}
		}
	}

	public boolean hasDiv(long num) {
		long fromList;
		for (long i = 0; i < CalcNumbers.list.size(); i++) {
			fromList = CalcNumbers.list.get((int) i);
			if (Math.multiplyExact(fromList, fromList) > num) {
				return false;
			}
			if (num % fromList == 0) {
				return true;
			}
		}
		return false;
	}
}
