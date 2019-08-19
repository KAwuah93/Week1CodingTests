public class infectedRoom {
    public static void main(String[] args) {
        Room[][] vertTrue = returnVertRooms();
        Room[][] horiTrue = returnHoriRooms();
        // Visualization
        printRooms(vertTrue);
        System.out.println(isOutbreak(vertTrue));

        printRooms(horiTrue);
        System.out.println(isOutbreak(horiTrue));
    }

    public static class Room {
        public final boolean isInfected;
        public boolean visited = false;

        Room(boolean infected) {
            isInfected = infected;
        }
    }

    public static boolean isOutbreak(Room[][] floor) {
        // Your logic here
        // TODO add incrementation but leave when you get a chain of 5
        for (int i = 0; i < floor.length; i++) {
            for (int k = 0; k < floor[i].length; k++) {
                if (floor[i][k].isInfected == true || floor[i][k].visited == false) {
                    // floor[i][k]
                    int results = scout(floor[i][k], i, k, 1, floor);
                    if (results >= 5) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // set up a recurring function to scout the rooms
    public static int scout(Room x, int currX, int currY, int mapped, Room[][] floor) {
        // set room to visited
        x.visited = true;
        // Checking up and down to make sure that you are in the room (assuming
        // everything is in)
        // a box formation
        if (currX - 1 >= 0) {
            if (floor[currX - 1][currY].isInfected == true && floor[currX - 1][currY].visited == false) {
                // add it up
                mapped += scout(floor[currX - 1][currY], currX - 1, currY, mapped, floor);
            }
        }
        if (currX + 1 < floor.length) {
            if (floor[currX + 1][currY].isInfected == true && floor[currX + 1][currY].visited == false) {
                // add it up
                mapped += scout(floor[currX + 1][currY], currX + 1, currY, mapped, floor);
            }
        }
        // Checking left and right to make sure that you are in the floor (assuming
        // everything is in) a box formation
        // check if the room is infested and unscouted
        // TODO figure out math logical sequence.
        System.out.println(currY);
        if (currY - 1 >= 0) {
            if (floor[currX][currY - 1].isInfected == true && floor[currX][currY - 1].visited == false) {
                // add it up

                mapped += scout(floor[currX][currY - 1], currX, currY - 1, mapped, floor);
            }
        }
        if (currY + 1 < floor[currX].length) {
            if (floor[currX][currY + 1].isInfected == true && floor[currX][currY + 1].visited == false) {
                // add it up
                mapped += scout(floor[currX][currY + 1], currX, currY + 1, mapped, floor);
            }
        }
        return mapped;
    }

    public static void printRooms(Room[][] rooms) {
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[y].length; x++) {
                String s = rooms[y][x].isInfected ? "X" : " ";
                if (rooms[y][x].visited)
                    s = "O";
                System.out.print("[" + s + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Room[][] returnVertRooms() {
        Room[][] test2 = new Room[][] {
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) } };

        return test2;
    }

    public static Room[][] returnHoriRooms() {
        Room[][] horizontalTrue = new Room[][] {
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) },
                { new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
                        new Room(false), new Room(false), new Room(false) } };

        return horizontalTrue;
    }

}