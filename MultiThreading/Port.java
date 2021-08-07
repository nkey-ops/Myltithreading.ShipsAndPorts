package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Port extends ActionOverContainer {

	private String name;

	private List<Pier> piers;

	public Port(Container container, int limiteOfContainers, String name) throws IllegalArgumentException {
		super(container, limiteOfContainers);
		this.name = name;
		piers = getPiers(5);
	}

	public String getName() {
		return name;
	}

	public synchronized int getLimiteOfContainers() {
		return limiteOfContainers;
	}

	public synchronized Container getContainer() {
		return container;
	}

	public synchronized int getNumberOfContainers() {
		return numberOfContainers;
	}

	public Pier getRandomPier() {
		return piers.get(new Random().nextInt(5));
	}

	private List<Pier> getPiers(int num) {
		List<Pier> piers = new ArrayList<Pier>(5);

		for (int i = 1; i <= num; i++) {
			piers.add(new Pier(this, ("Pier #" + i)));
		}

		return piers;
	}

}
