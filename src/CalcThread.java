
public class CalcThread extends Thread {
	int fromnum;
	int tonum;
	public int iter;

	public CalcThread(int from, int to) {
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
			if (hasDiv(iter)) {
				// System.out.println(this.getName()+" contains " + iter);
			} else {
				CalcNumbers.addToList(iter);
				// System.out.println(this.getName()+" add " + iter);
			}
		}
	}

	public boolean hasDiv(int num) {
		long fromList;
		for (int i = 0; i < CalcNumbers.list.size(); i++) {
			fromList = CalcNumbers.list.get(i);
			if (num % fromList == 0) {
				return true;
			}
			if (Math.multiplyExact(fromList, fromList) > num) {
				return false;
			}
		}
		return false;
	}
}
