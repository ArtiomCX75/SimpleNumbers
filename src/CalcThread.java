
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
		int sumofnum;
		for (iter = fromnum; iter < tonum; iter += 2) {
			sumofnum = (int) divByThree(iter);
			if ((iter % 5 == 0) || (sumofnum == 3) || (sumofnum == 6) || (sumofnum == 9))
				continue;
			if (hasDiv(iter)) {
				// System.out.println(this.getName()+" contains " + iter);
			} else {
				CalcNumbers.addToList(iter);
				// System.out.println(this.getName()+" add " + iter);
			}
			// if((iter-1)%10_000_000==0)
			// System.out.println("Current size is "+CalcNumbers.list.size());
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
		return false; // заменить на умножение
	}

	public long divByThree(long num) {
		if (num < 10)
			return num;
		String s = new Long(num).toString();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += new Integer(s.substring(i, i + 1));
		}
		if (sum > 9)
			divByThree(sum);
		return sum;
	}
}
