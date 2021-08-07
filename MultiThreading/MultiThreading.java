package MultiThreading;

import java.util.Iterator;

public class MultiThreading extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("run " + i);
		}
	}

	public void start() {
		System.out.println("start");
		super.start();
	}

	public static void main(String args[]) {
		MultiThreading mt = new MultiThreading();
		MultiThreading mt2 = new MultiThreading();
		mt.start();
		mt2.start();
		System.out.println("main");
	}
}
