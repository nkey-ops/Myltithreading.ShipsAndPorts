package MultiThreading;


public abstract class ActionOverContainer {
	protected Container container = new Container();
	protected volatile int limiteOfContainers;
	protected volatile int numberOfContainers;
	protected int freeSpace = limiteOfContainers - numberOfContainers;

	public ActionOverContainer(Container container, int limiteOfContainers) throws IllegalArgumentException {
		super();

		if (limiteOfContainers < 0 || numberOfContainers < 0) {
			throw new IllegalArgumentException();
		}

		this.container = container;
		numberOfContainers = container.getNumberOfContainers();
		this.limiteOfContainers = limiteOfContainers;
		freeSpace = this.limiteOfContainers - numberOfContainers;

	}

	public int getLimiteOfContaiters() {
		return limiteOfContainers;
	}

	public synchronized int getNumberOfContainers() {
		return numberOfContainers;
	}

	public int getFreeSpace() {
		return freeSpace;
	}

	public synchronized int unloadContainers(int numberOfContainers, String nameOfPlaceToUnload)
			throws IllegalArgumentException {
		if (numberOfContainers < 0) {
			throw new IllegalArgumentException();
		} else if (numberOfContainers > freeSpace) {
			throw new IllegalArgumentException(
					this.getClass().getSimpleName() + " can`t take so much containers." + "\nFree Space " + freeSpace);
		} else {
			add(numberOfContainers);

			return numberOfContainers;
		}
	}

	public synchronized int loadContainers(int numberOfContainers, String nameOfPlaceToLoad)
			throws IllegalArgumentException {
		if (numberOfContainers < 0) {
			throw new IllegalArgumentException();
		} else if (numberOfContainers > this.numberOfContainers) {
			throw new IllegalArgumentException(
					this.getClass().getSimpleName() + " doesn`t have this number of containers."
							+ "\n The current number of containers is " + this.numberOfContainers);
		} else {
			return remove(numberOfContainers);
		}
	}

	public synchronized void add(int numberOfContainers) throws IllegalArgumentException {
		if (numberOfContainers < 0 || numberOfContainers > freeSpace) {
			throw new IllegalArgumentException("illegal argumet exception");
		}

		this.numberOfContainers += numberOfContainers;
		freeSpace = limiteOfContainers - this.numberOfContainers;
	}

	public synchronized int remove(int numberOfContainers) throws IllegalArgumentException {
		if (numberOfContainers < 0 || this.numberOfContainers < numberOfContainers) {
			throw new IllegalArgumentException();
		} else {

			this.numberOfContainers -= numberOfContainers;
			freeSpace = limiteOfContainers - this.numberOfContainers;

			return numberOfContainers;
		}
	}

}
