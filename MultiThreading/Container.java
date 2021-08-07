package MultiThreading;


public class Container {
	private volatile int numberOfContainers;

	public Container() {
	}

	public Container(int numberOfContainers) {
		this.numberOfContainers = numberOfContainers;
	}

	public int getNumberOfContainers() {
		return numberOfContainers;
	}

	public void add(int numberOfContainers) throws IllegalArgumentException {
		if (numberOfContainers < 0) {
			throw new IllegalArgumentException();
		}

		this.numberOfContainers += numberOfContainers;
	}

	public int remove(int numberOfContainers) throws IllegalArgumentException {
		if (numberOfContainers < 0) {
			throw new IllegalArgumentException();
		} else if (numberOfContainers > this.numberOfContainers) {
			System.out.println("There`re no such containers ");
			return -1;
		} else {
			this.numberOfContainers -= numberOfContainers;

			return numberOfContainers;
		}
	}

}
