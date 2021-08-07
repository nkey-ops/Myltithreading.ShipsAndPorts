package MultiThreading;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Port port1 = new Port(new Container(150), 500, "De Castro");
		Port port2 = new Port(new Container(202), 750, "El Namibe");

		for (int i = 1; i <= 20; i++) {
			Ship ship = new Ship(new Container(new Random(41).nextInt(25)), 14, port1, port2, ("Ship # " + i));
			Thread t = new Thread(ship);
			t.start();
		}

	}
}
