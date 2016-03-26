
public class CalcThread extends Thread {

	int fromnum;
	int tonum;
	public int iter;

	public CalcThread(int from, int to) {
		if(from%2==0)
			from--;
		if(to%2==0)
			to--;
		fromnum = from;
		tonum = to;
	}

	@Override
	public void run() {
		 System.out.println(this.getName()+" starts");
		calc();
		 System.out.println(this.getName()+" ends");
	}

	public void calc() {
		for (iter = fromnum; iter < tonum; iter+=2) {
			
			if (hasDiv(iter)) {
			//	 System.out.println(this.getName()+" contains " + iter);
			} else {
				CalcNumbers.addToList(iter);
			//	 System.out.println(this.getName()+"           add " + iter);
			}
		//	if((iter-1)%10_000_000==0)
		//		System.out.println("Current size is "+CalcNumbers.list.size());
			
		}
	}

	public boolean hasDiv(int num) {
		
		for (int i = 0; i < CalcNumbers.list.size(); i++) {
			if (num % CalcNumbers.list.get(i) == 0) {
				return true;
			}
			if(CalcNumbers.list.get(i)>Math.sqrt(num)+1){
				return false;
			}
		}
		return false;
	}
}
