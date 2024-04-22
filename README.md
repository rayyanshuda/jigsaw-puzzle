In standard jigsaw puzzles, each piece has four sides, and each side is either a tab (indenting outwards), blank (indenting inwards) or a straight edge. 
To make puzzles fit in only one way, each tab can only interlock with one other blank. 
One way to represent this in a program is to use a class where each side is represented by an integer. 
Tabs can be represented by positive numbers, edges by negative numbers, and sides by zero. 
If a tab and knot fit, they should have the same value (but different sign). 

Each piece has the following attributes: name, which is a string that uniquely identifies each piece and side1, side2, side3, side4, 
all of which are integers representing the four sides of the jigsaw puzzle as integers. 
(Assume the orientation of each piece has side 1 on the left, side 2 on the top, side 3 on the right, side 4 on the bottom.

This program assumes an array of type jigsawpiece with a number of pieces in random order. 
Writen is a program that solves this puzzle. To solve it, the program will print the name attribute of the pieces in order from top left to bottom right.
