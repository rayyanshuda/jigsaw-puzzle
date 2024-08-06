package com.mycompany.jigsawpiece; //if the program does not work, the package name is different
 
public class JigsawPiece {
    // initializing attributes
    String name = ""; //name of puzzle piece
    int side1 = 0; //left
    int side2 = 0; //top
    int side3 = 0; //right
    int side4 = 0; //bottom
 
    JigsawPiece (String n, int s1, int s2, int s3, int s4) { //constructor to initialize each piece
        name = n;
        side1 = s1;
        side2 = s2;
        side3 = s3;
        side4 = s4;
    }
    boolean isLeftEdge() {
        if (side1 == 0) { //checks that only the left side is a straight edge
            return true;
        }
        else
            return false;
    }
    boolean isTopEdge() {
        if (side2 == 0) { //checks that only the top side is a straight edge
            return true;
        }
        else
            return false;
    }
    boolean isRightEdge() {
        if (side3 == 0) { //checks that only the right side is a straight edge
            return true;
        }
        else
            return false;
    }
    boolean isBottomEdge() {
        if (side4 == 0) { //checks that only the bottom side is a straight edge
            return true;
        }
        else
            return false;
    }
    boolean isTopLeftCorner() {
        if ((side1 == 0) && (side2==0) && !(side3==0) && !(side4==0)) { //checks if side1 and side2 are flat
            return true;
        }
        else
            return false;
    }
    boolean isTopRightCorner() {
        if ((side2 == 0) && (side3==0) && !(side1==0) && !(side4==0)) { //checks if side2 and side 3 are flat
            return true;
        }
        else
            return false;
    }
    boolean isBottomLeftCorner() {
        if ((side1 == 0) && (side4==0) && !(side2==0) && !(side3==0)) { //checks if side 1 and side 4 are flat
            return true;
        }
        else
            return false;
    }
    boolean isBottomRightCorner() {
        if ((side3 == 0) && (side4==0) && !(side1==0) && !(side2==0)) { //checks if side 3 and side 4 are flat
            return true;
        }
        else
            return false;
    }
    boolean fits(JigsawPiece j) {
        if ((this.side1) == (-1 * j.side3)) {
            return true;
        }
        else
            return false;
    }
    void print() {
        System.out.print(name + " "); // printing attribute name of element
    }
 
    public static void main(String[] args) {
        //myArray is the number of puzzle pieces (change this number to increase or decrease the length of the puzzle)
        JigsawPiece[] myArray = new JigsawPiece[20]; // trying to order this array 
        int x = myArray.length;
        int rowLength;
        JigsawPiece[] ordered = new JigsawPiece[x]; // to keep the correct order of the puzzle
        int p = 0; // index of ordered list.

        myArray[0] = new JigsawPiece("a", -45, 0, 0, -84);
        myArray[1] = new JigsawPiece("c", -46, 0, 45, 19);
        myArray[2] = new JigsawPiece("d", 0, -2, 6, 13);
        myArray[3] = new JigsawPiece("e", 0, 0, 96, 2);
        myArray[4] = new JigsawPiece("f", -96, 0, 46, 15);
        myArray[5] = new JigsawPiece("g", 0, -13, 30, 23);
        myArray[6] = new JigsawPiece("h", -47, 34, 0, 0);
        myArray[7] = new JigsawPiece("i", -9, 87, 47, 15);
        myArray[8] = new JigsawPiece("j", -6, -2, 9, 8);
        myArray[9] = new JigsawPiece("l", 17, -20, 48, 0);
        myArray[10] = new JigsawPiece("k", -30, 7, -17, 0);
        myArray[11] = new JigsawPiece("m", -48, 5, 0, 0);
        myArray[12] = new JigsawPiece("n", -89, 99, 0,77);
        myArray[13] = new JigsawPiece("o", 0, -23, 79, 73);
        myArray[14] = new JigsawPiece("p", -79, 34, 21, 27);
        myArray[15] = new JigsawPiece("q", -21, 15, 89, 36);
        myArray[16] = new JigsawPiece("r", -41, 6, 0, 0);
        myArray[17] = new JigsawPiece("s", 0, -73, 22, 60);
        myArray[18] = new JigsawPiece("t", -88, 35, 41, 0);
        myArray[19] = new JigsawPiece("u", -22, 15, 88, 0);
        
        boolean found = false;
        
        //find top left piece
        for (int i = 0; i<myArray.length; i++) {
            if (myArray[i].isTopLeftCorner()) {
                myArray[i].print(); //prints the first piece name
                ordered[p] = myArray[i]; //first element in ordered array -----> ordered[0]
                // note: this ordered array is used to compare the last piece in the completed puzzle with new pieces to find the piece to the right
                found = true; // if there is a piece that fits, it is found.
                break;
            }
        }
        
        if (found == false) { // if no piece is found, end the program.
            System.out.println("Puzzle piece missing.");
            System.exit(0);
        }
        
        found = false; // reset variable for next element
        
        while (!ordered[p].isTopRightCorner()) {
            // find next piece to the right until it reaches the top right corner.
            for (int i = 0; i<myArray.length; i++) {
                if ((myArray[i].fits(ordered[p]))) {
                    myArray[i].print();
                    p++;
                    ordered[p] = myArray[i]; // add the element found to the ordered array
                    found = true;
                    break;
                }
            }
            
            if (found == false) { //check again if an element was found
                System.out.println("Puzzle piece missing.");
                System.exit(0);
            }
            
            found = false;
        }
        
        // first line is completed. 
        
        System.out.println();

        rowLength = p+1; //how long each row is (all rows must be the same length)
        
        int n = myArray.length / rowLength; // 'n' is the number of rows in total
        
        n--; // subtract one row because the first row is complete
        
        // first element in second line must fit below the first element in the ordered array (ordered[0])
        for (int i = 0; i<myArray.length; i++) {
                if ((myArray[i].side2 == (-1*(ordered[0].side4)))) {
                    myArray[i].print();
                    p++;
                    ordered[p] = myArray[i]; // add the element found to the ordered array
                    found = true;
                    break;
                }
        }
        
        if (found == false) { // check if an element was found
            System.out.println("Puzzle piece missing.");
            System.exit(0);
        }
        
        found = false;
 
        //while the piece isn't a right edge, keep going.
        while (!ordered[p].isRightEdge()) {
            // find next piece to the right until it reaches the right edge piece.
            for (int i = 0; i<myArray.length; i++) {
                if ((myArray[i].fits(ordered[p]))) {
                    myArray[i].print();
                    p++;
                    ordered[p] = myArray[i]; // add the element found to the ordered array
                    found = true;
                    break;
                }
            }
            
            if (found == false) { //check if a sufficient piece was found
                System.out.println("Puzzle piece missing.");
                System.exit(0);
            }
            
            found = false;
            
        }
        // second line is finished.
        System.out.println();
        
        n--; // subtract because an additional line is complete.
        
        // there can be minimum 2 rows in a puzzle
        // if there is more than 2 rows, complete the row and subtract n-- until 'n' reaches zero indicating the final row is complete
        
        while (n>0) {
            
            for (int i = 0; i<myArray.length; i++) {
                if ((myArray[i].side2 == (-1*(ordered[p-rowLength+1].side4)))) {
                    myArray[i].print();
                    p++;
                    ordered[p] = myArray[i]; // add the element found to the ordered array
                    found = true;
                    break;
                }
            }
            
            if (found == false) { // check if the piece was found
                System.out.println("Puzzle piece missing.");
                System.exit(0);
            }
            
            found = false;
 
            while (!ordered[p].isRightEdge()) {
                // find next piece to the right until it reaches the right edge piece.
                for (int i = 0; i<myArray.length; i++) {
                    if ((myArray[i].fits(ordered[p]))) {
                        myArray[i].print();
                        p++;
                        ordered[p] = myArray[i]; // add the element found to the ordered array
                        found = true;
                        break;
                    }
                }
                
                if (found == false) { // check if the piece was found
                    System.out.println("Puzzle piece missing.");
                    System.exit(0);
                }
                
                found = false;
            }

            System.out.println(); // so when it prints a new line in the puzzle, it prints below the previous line
            n--;
        }
    }
}