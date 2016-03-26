
public class CalcThread extends Thread {

	int fromnum;
	int tonum;
	public int iter;

	public CalcThread(int from, int to) {
		fromnum = from;
		tonum = to;
	}

	@Override
	public void run() {
		 System.out.println("Thread starts "+this.getName());
		calc();
		 System.out.println("Thread ends "+this.getName());
	}

	public void calc() {
		for (iter = fromnum; iter < tonum; iter++) {
			if (hasDiv(iter)) {
				// System.out.println("contains " + i);
			} else {
				CalcNumbers.addToList(iter);
				// System.out.println("add " + iter);
			}
		}
	}

	public boolean hasDiv(int num) {
		for (int i = 0; i < CalcNumbers.list.size(); i++) {
			if (num % CalcNumbers.list.get(i) == 0) {
				return true;
			}
			if(Math.sqrt(num)<CalcNumbers.list.get(i))
				break;
		}
		return false;
	}
}
