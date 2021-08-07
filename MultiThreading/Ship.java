package MultiThreading;

import java.util.Random;

public class Ship extends ActionOverContainer implements Runnable {
	private String name;

	private Port port1;
	private Port port2;

	public Ship(Container container, int limiteOfContaiters, Port port1, Port port2, String name)
			throws IllegalArgumentException {
		super(container, limiteOfContaiters);
		this.port1 = port1;
		this.port2 = port2;
		this.name = name;
	}

	@Override
	public void run() {

		while (true) {
			Port port = null;
			try {
				if (isFull()) {
					Thread.sleep(getRandomTimeOfShipping());

					if (new Random().nextInt(2) == 0)
						port = port1;
					else
						port = port2;
					getInfo(port, "load");
					port.getRandomPier().unloadContainers(this.loadContainers(getNumberOfContainers(), port.getName()),
							this.getName());
					getStatistics();

					Thread.sleep(getRandomTimeOfShipping());
				} else {

					Thread.sleep(getRandomTimeOfShipping());

					if (new Random().nextInt(2) == 0)
						port = port1;
					else
						port = port2;
					getInfo(port, "unload");
					port.getRandomPier().loadContainers(this.unloadContainers(getFreeSpace(), port.getName()),
							this.getName());
					getStatistics();

					Thread.sleep(getRandomTimeOfShipping());
				}

				System.out.println();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getName() {
		return name;
	}

	public int getRandomTimeOfShipping() {
		return new Random().nextInt(100000);
	}

	public void getInfo(Port port, String staff) {
		System.out.printf("%s is going to %s containers in %s\n", this.getClass().getSimpleName(), staff,
				port.getName());
	}

	public boolean isFull() {
		return getNumberOfContainers() == getLimiteOfContaiters();
	}

	public void getStatistics() {
		System.out.printf("%s C %d FC %d L %d\n\n", getName(), getNumberOfContainers(), getFreeSpace(),
				getLimiteOfContaiters());
	}

}
