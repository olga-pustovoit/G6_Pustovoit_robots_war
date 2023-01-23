package robots_war;

import java.util.Random;
import java.util.Scanner;

public class Robot {


    private String name;
    private int heath = 100;
    private String damageKeys = "";
    private String usedKeys = "";
    public boolean isAlive = true;

    public String getName () {
        return this.name;
    }
    public int getHealth () {
        return this.heath;
    }


    public void setName(int order) {
        System.out.println("Enter robot_" + order + " name: ");
        Scanner scanner = new Scanner(System.in);
        try {
            this.name = scanner.next();
        } catch (Exception e) {
            String.valueOf(false);
        }
    }

    private String alphabet = "QWEASDZXC";
    private String alphabetConst = "QWEASDZXC";

    char getRandomKey() {
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }

    public void getDamageKeys() {
        for (int i = 0; i < 5; i++) {
            this.damageKeys += String.valueOf(getRandomKey());
        }
//    System.out.println(this.damageKeys);
    }
    public static void printMenuStart(String name) {
        System.out.println("");
        System.out.println("For exit press P");
        System.out.println("A shot at the robot: " + name);
        System.out.println("Your step: press key (QWEASDZXC)");
    }

    public void showHealth() {
        System.out.println("---------");
        System.out.println(this.name + " " + this.heath);
        System.out.println("---------");
    }

    public void handlePress (String exitKey){
        printMenuStart(this.name);
        String key;
        boolean isWrongKey = true;
        do {
            Scanner scanner = new Scanner(System.in);
                key = scanner.next().toUpperCase();
                if(exitKey.equalsIgnoreCase(key)) {
                    this.isAlive = false;
                    System.out.println("Goodbye!");
                    return;
                }
                if(alphabetConst.contains(key)){
                    this.tryDamage(key);
                    isWrongKey = false;
                } else {
                    System.out.println(key + "- Wrong enters. Use only One key from QWEASDZXC");
                }
        } while (isWrongKey);
    }

    private void tryDamage(String key) {
        if (this.damageKeys.contains(key) && !this.usedKeys.contains(key)) {
            this.heath -= 20;
            this.isAlive = this.heath > 0;
            this.usedKeys += key;
            System.out.println("Good shot! BaBah. The health " + this.name + " of decreased for -20");
        } else if (this.usedKeys.contains(key)) {
            System.out.println("Kay is not active");
        } else {
            System.out.println("Key dos no damage");
        }
    }

}
