package de.adornis.snookercalculator;

/**
 * Created by fightcookie on 9/12/2014.
 */
class Table {
	//use hashmap for balls, at least for colored, good for remainingPoints method
	private int redBalls;
	private boolean yellowBall;
	private boolean greenBall;
	private boolean brownBall;
	private boolean blueBall;
	private boolean pinkBall;
	private boolean blackBall;

	private int scorePlayer1;
	private int scorePlayer2;

	private int remainingPoints;

	void resetTable() {
		redBalls = 15;
		yellowBall = true;
		greenBall = true;
		brownBall = true;
		blueBall = true;
		pinkBall = true;
		blackBall = true;
		remainingPoints = 147;
	}

	int getScorePlayer1() {
		return scorePlayer1;
	}

	int getScorePlayer2() {
		return scorePlayer2;
	}

	public int getRemainingPoints() {
		return remainingPoints;
	}

	int remainingPoints() {
		int remainingPoints = 0;
		remainingPoints += redBalls * 8;
		if(yellowBall) {
			remainingPoints += 2;
		}

		if(greenBall) {
			remainingPoints += 3;
		}

		if(brownBall) {
			remainingPoints += 4;
		}

		if(blueBall) {
			remainingPoints += 5;
		}

		if(pinkBall) {
			remainingPoints += 6;
		}

		if(blackBall) {
			remainingPoints += 7;
		}
		return remainingPoints;
	}
}
