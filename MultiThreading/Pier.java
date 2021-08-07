package MultiThreading;


public class Pier {
	private Port port;
	private String name;

	public Pier(Port port, String name) throws IllegalArgumentException {
		this.port = port;
		this.name = name;

	}

	public synchronized int unloadContainers(int numberOfContainers, String nameOfPlaceToLoad)
			throws IllegalArgumentException {
		int numOfUnloadedContainers = port.unloadContainers(numberOfContainers, nameOfPlaceToLoad);
		getInfo("unload", numberOfContainers, nameOfPlaceToLoad);

		return numOfUnloadedContainers;
	}

	public synchronized int loadContainers(int numberOfContainers, String nameOfPlaceToUnload)
			throws IllegalArgumentException {
		int numOfLoadedContainers = port.loadContainers(numberOfContainers, nameOfPlaceToUnload);
		getInfo("load", numberOfContainers, nameOfPlaceToUnload);

		return numOfLoadedContainers;
	}

	public String getName() {
		return name;
	}

	public void getInfo(String process, int numberOfContainers, String nameOfShip) {
		if ("load".equals(process)) {
			System.out.printf("%s: %s loaded %d containers to the %s.\n", port.getName(), this.getName(),
					numberOfContainers, nameOfShip);
		} else {
			System.out.printf("In port %s: %s were unloaded %d containers from the %s.\n", port.getName(), getName(),
					numberOfContainers, nameOfShip);
		}

		getStatistics();
	}

	public void getStatistics() {
		System.out.printf("%s C %d FC %d L %d\n", getName(), port.getNumberOfContainers(), port.getFreeSpace(),
				port.getLimiteOfContaiters());
	}
}
