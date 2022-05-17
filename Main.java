// Binary Strip, by Mikhail.
// This project gives the user a strip of 1's and 0's and
// they can edit it in any way they want, and then see what
// decimal number they created. This was written to prove
// my proficiency at the basics of Java.

import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Press enter to create a new strip:");
        scanner.nextLine();
        Strip newStrip = new Strip();

        boolean done = false;
        while (done == false) {
            System.out.println(newStrip.display());
            System.out.print("Pick an option (left, right, flip, close)");
            String input = scanner.next();

            if (input.equals("left")) {
                int requestedIdx = newStrip.selectedIdx - 1;
                if (requestedIdx < 0 || requestedIdx >= newStrip.stripArray.length) {
                    System.out.println("That's out of bounds!");
                    continue;
                }
                newStrip.selectedIdx = requestedIdx;
            } else if (input.equals("right")) {
                int requestedIdx = newStrip.selectedIdx + 1;
                if (requestedIdx < 0 || requestedIdx >= newStrip.stripArray.length) {
                    System.out.println("That's out of bounds!");
                    continue;
                }
                newStrip.selectedIdx = requestedIdx;
            } else if (input.equals("flip")) {
                newStrip.flipBit();
            } else if (input.equals("close")) {
                done = true;
            } else {
                System.out.println("That's not a valid input!");
            }
        }

        System.out.format("Alright! Your final strip had the value of %d.\n", newStrip.stripToDecimal());
    }
}