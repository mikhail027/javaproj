public class Strip {
    public boolean[] stripArray = {false, false, false, false, false, false, false, false};
    public int selectedIdx = Math.round(stripArray.length / 2); // Start the needle sorta close to the center

    public int stripToDecimal() {
        int converted = 0;
        for (int i=0;i<stripArray.length;i++) {
            double thisValue = Math.pow(2, i);
            if (stripArray[i] == true) {
                converted += thisValue;
            }
        }
        return converted;
    }

    public void flipBit() {
        stripArray[selectedIdx] = !stripArray[selectedIdx];
    }

    // Goes line by line, drawing an arrow
    private String displayArrow() {
        String finalString = "";

        for (int i=0;i<stripArray.length;i++) {
            if (i == selectedIdx) {
                finalString += "|  ";
            } else {
                finalString += "    ";
            }
        }
        finalString += "\n";

        for (int i=0;i<stripArray.length;i++) {
            if (i == selectedIdx) {
                finalString += "|  ";
            } else {
                finalString += "    ";
            }
        }
        finalString += "\n";

        for (int i=0;i<stripArray.length;i++) {
            if (i == selectedIdx) {
                finalString += "V  ";
            } else {
                finalString += "    ";
            }
        }
        finalString += "\n";

        return finalString;
    }

    public String display() {
        String finalString = "";

        finalString += displayArrow();

        for (int i=0;i<stripArray.length;i++) {
            int numberized = 0;
            if (stripArray[i] == true) {
                numberized = 1;
            }
            finalString = finalString + Integer.toString(numberized) + " | "; 
        }
        finalString += "\nCurrent strip is equal to --> ";
        finalString += Integer.toString(stripToDecimal());

        return finalString;
    }
}
