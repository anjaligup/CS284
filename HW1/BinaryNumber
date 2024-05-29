package HW1;

//Name: Anjali Gupta
//Pledge: I pledge my honor tht I have abided by the Stevens Honor System
public class BinaryNumber {
    private int data[];
    private int length;

    /**
     * creates binary number given a length (constructor)
     */
    public BinaryNumber(int length){
        if (length <= 0) {
            throw new IllegalArgumentException("Length can not be 0 or less than zero");
            //throw error saying you cannot input a negative number or 0
        }
        data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = 0;
            //create a string with 0's
        }
        this.length = length;
    }

        /**
         * creates binary number given a string (constructor)
         */
        public BinaryNumber(String str) {
            //create a for loop that iterates through the string and converts by character
            length = str.length();
            data = new int[length];
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) != '1' && str.charAt(i) != '0') {
                    throw new IllegalArgumentException("Enter valid string");
                } else { //how to convert character value to int?
                    data[i] = Character.getNumericValue(str.charAt(i));
                }
            }
        }

        /**
         *determines length of binary number
         */
        public int getLength () {
            return length;
        }

        /**
         * obtains the digit of a binary number given an index
         */
        public int getDigit (int index){
            if (index < 0) {
                throw new ArrayIndexOutOfBoundsException("This index is out of bounds, input new index");
            }
            return data[index];

        }

        /**
         * returns integer array representing the binary number
         */
        public int[] getInnerArray () {
            return data;
        }

        /**
         * computes bitwise "and" of two numbers
         */
        public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2){
            if (bn1.length != bn2.length){
                throw new IllegalArgumentException("Binary Numbers must be of same length");
            }
            int[] newNumber = new int[bn1.length];
            for(int i = 0; i < bn1.length; i ++){
                newNumber[i] = bn1.getDigit(i) | bn2.getDigit(i);
            }
            return newNumber;
        }

        /**
         * computes bitwise "or" of two numbers
         */
        public static int [] bwand(BinaryNumber bn1, BinaryNumber bn2){
            if (bn1.length != bn2.length){
                throw new IllegalArgumentException("Binary Numbers must be of same length");
            }
            int[] newNumber = new int[bn1.length];
            for(int i = 0; i < bn1.length; i++){
                newNumber[i] = bn1.getDigit(i) & bn2.getDigit(i);
            }
            return newNumber;
        }

        /**
         * shifts binary digits any number of places left or right
         */
        public void bitShift ( int direction, int amount){
            if (direction == 1) { //right shift
                int newLength = length - amount;
                int[] temp = new int[newLength];
                for (int i=0; i < newLength; i++){
                    temp[i] = data[i];
                }
                this.data = temp;
            }
            else if  (direction == -1) { //left shift
                int newLength = length + amount;

                int[] temp = new int[newLength]; //create a space in array for shifted number
                for (int i = 0; i < length; i++){ //copy array into temp
                    temp[i] = data[i];
                }
                for (int i = 0; i < amount; i++){ //add amount 0's to tail end
                    temp[length + i] = 0;
                }
                this.data = temp;
            } else {
                throw new IllegalArgumentException("Direction must be -1 or 1");

            }
        }

        /**
         * puts 0's in front of binary numbers not of same length
         */
        public void prepend(int amount){
            if (amount < 0) {
                throw new IllegalArgumentException("Amount must be greater than 0");
            }
            int [] prependNumber = new int[amount + length];
            for (int i = 0; i < amount; i++){
                prependNumber[i] = 0;
            }
            for (int i = 0; i < length; i++){
                prependNumber[i + amount] = data[i];
            }
            this.data = prependNumber;
        }


        /**
         * adding keywords this and aBinaryNumber together
         */
        public void add(BinaryNumber aBinaryNumber) {
            //int [] result = new int[length];
            if (aBinaryNumber.getLength() < this.getLength()) {
                int prependAmount = this.getLength() - aBinaryNumber.getLength();
                aBinaryNumber.prepend(prependAmount);
            } else if (this.getLength() < aBinaryNumber.getLength()){
                int prependAmount = aBinaryNumber.getLength() - this.getLength();
                this.prepend(prependAmount);
            }
            int carry = 0;
            //int i = length - 1;
            //add the numbers
            for (int i = length - 1; i >= 0; i--){
                int sum = aBinaryNumber.data[i] + this.data[i] + carry;
                if (sum <= 1){
                    data[i] = sum;
                    carry = 0;
                } else if (sum == 2){
                    data[i] = 0;
                    carry++;
                } else{
                    data[i] = 1;
                    carry++;
                }
            }
            if (carry ==1){
                this.prepend(1);
                this.data[0] = 1;
            }
        }

        /**
         * returns the HW1.BinaryNumber as a string
         */
        public String toString(){
            String str = "";
            for (int i = 0; i < length; i++){
                str += data[i];
            }
            return str;
        }


        /**
         * transforms binary number to decimal form
         */
        public int toDecimal () {
            int tempCounter = 0; //holds place value
            int decimalValue = 0; //holds decimal value
            for(int i = length - 1; i >= 0; i--){
                if (data[i] == 1){
                    decimalValue += (int) Math.pow(2, tempCounter);
                    //System.out.println("decimalValue value: " + decimalValue);
                    tempCounter ++;
                    //System.out.println("tempCounter value: " + tempCounter);
                } else {
                    tempCounter ++;
                    //System.out.println("tempCounter value in else statement: " + tempCounter);
                }
            }
            return decimalValue;
        }
    }
