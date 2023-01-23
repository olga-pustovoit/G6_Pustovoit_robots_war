package robots_war;

import java.util.Scanner;

public class MainClass {

    public static void showWinner(Robot first, Robot second) {
        Robot winner = first.getHealth() > 0 ? first : second;
        Robot loser = first.getHealth() == 0 ? first : second;

        System.out.println("---------");
        System.out.println(winner.getName() + "- Win !!!!!!");
        System.out.println(loser.getName() + " was killed");
        System.out.println("---------");

        System.out.println(winner.getName() + ", " + winner.getHealth());
    }
    public static void main(String[] args) {
        final String EXIT_KEY = "P";


        System.out.println("Hello");
        Robot robot_1 = new Robot();
        Robot robot_2 = new Robot();
        robot_1.setName(1);
        robot_2.setName(2);

        robot_1.getDamageKeys();
        robot_2.getDamageKeys();


        do {
            robot_1.handlePress(EXIT_KEY);
            if (!robot_1.isAlive) {
                break;
            }
            robot_2.handlePress(EXIT_KEY);
            if (!robot_2.isAlive) {
                break;
            }
            robot_1.showHealth();
            robot_2.showHealth();
        } while (robot_1.isAlive && robot_2.isAlive);

        showWinner(robot_1, robot_2);
    }
}
