package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MovieProducer {

	/*
	 * Snakes can be venomous or not. 
	 * A Plane contains a list of snakes. 
	 * How many snakes does Sam have to kill to make the plane safe?
	 */

	public static void main(String[] args) {
		List<Snake> snakes = SnakeFactory.createListOfSnakesWithThatAreRandomlyVenomous();
		Plane plane = new Plane();
		plane.addSnakes(snakes);
		int howManyCanKillMe = plane.getNumberOfVenomousSnakes();
		System.out.println("Sam has to kill the right " + howManyCanKillMe + " snakes.");
	}
}

 class Snake {

	private boolean venomous;

	public Snake(boolean venomous) {
		this.venomous = venomous;

	}

	public boolean getVenomous() {
		return venomous;
	}

	public void setVenomous(boolean venomous) {
		this.venomous = venomous;
	}

}
 
class Plane {
	
		private List<Snake> snakes;

		public void addSnakes(List<Snake> snakes) {
			this.snakes = snakes;
		}

		public int getNumberOfVenomousSnakes() {
			int numOfSnakes = 0;

			for (Snake snake : snakes) {
				if (snake.getVenomous()) {
					numOfSnakes++;
				}
			}
			return numOfSnakes;
		}
	}

class SnakeFactory{

	public static List<Snake> createListOfSnakesWithThatAreRandomlyVenomous() {
		boolean venomous = new Random().nextBoolean();
		List<Snake> snakes = new ArrayList<Snake>();
		for (int i = 0; i < 10000; i++) {
			snakes.add(new Snake(venomous));
			venomous = new Random().nextBoolean();
		}
		return snakes;
	}
}