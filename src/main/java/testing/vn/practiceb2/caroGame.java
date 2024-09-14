package testing.vn.practiceb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class caroGame {
    //player: X, computer: O
    public static void main(String[] args) {
        String[] row1 = new String[]{"   ", "|", "   ", "|", "   "}; // 0 2 4
        String[] row2 = new String[]{" - ", "+", " - ", "+", " - "}; // 0 2 4
        String[] row3 = new String[]{"   ", "|", "   ", "|", "   "}; // 0 2 4
        String[] row4 = new String[]{" - ", "+", " - ", "+", " - "}; // 0 2 4
        String[] row5 = new String[]{"   ", "|", "   ", "|", "   "}; // 0 2 4

        List<Integer> playerChosen = new ArrayList<>();
        List<Integer> computerChosen = new ArrayList<>();

        List<String[]> table = List.of(row1, row2, row3, row4, row5);
        Scanner scanner = new Scanner(System.in); //Create a Scanner object
        System.out.println("Please select from 1-9");
        for (int i = 0; i < 4; i++) {
            int userSelect = scanner.nextInt();
            while (playerChosen.contains(userSelect) || playerChosen.contains(userSelect)) {
                System.out.println("Please select other index");
                userSelect = scanner.nextInt();
            }
            playerChosen.add(userSelect);
            selectPoint(table, userSelect, " X ");
            printTable(table);

            int computerSelect = getRandomNumber(1, 9);
            while (playerChosen.contains(computerSelect) || computerChosen.contains(computerSelect)) {
                computerSelect = getRandomNumber(1, 9);
            }
            computerChosen.add(computerSelect);
            selectPoint(table, computerSelect, " O ");
            printTable(table);

        }
        List<int[]> win=new ArrayList<>();
        win.add(new int[]{1, 2, 3});
        win.add(new int[]{4, 5, 6});
        win.add(new int[]{7, 8, 9});
        win.add(new int[]{1, 4, 7});
        win.add(new int[]{2, 5, 8});
        win.add(new int[]{3, 6, 9});
        win.add(new int[]{1, 5, 9});
        win.add(new int[]{3, 5, 7});
        outer:
        for(int[] row:win){
            for (int i:row){
                if(playerChosen.contains(i)){
                    System.out.println("You win!!");
                    break outer;
                }
                else if(computerChosen.contains(i)){
                    System.out.println("You lose ><!");
                    break outer;
                }
                else {
                    System.out.println("Tie!!");
                    break outer;
                }
            }
        }
    }

    public static void selectPoint(List<String[]> table, int select, String player) {
        switch (select) {
            case 1: {
                table.get(0)[0] = player;
                break;
            }
            case 2: {
                table.get(0)[2] = player;
                break;
            }
            case 3: {
                table.get(0)[4] = player;
                break;
            }
            case 4: {
                table.get(2)[0] = player;
                break;
            }
            case 5: {
                table.get(2)[2] = player;
                break;
            }
            case 6: {
                table.get(4)[2] = player;
                break;
            }
            case 7: {
                table.get(4)[0] = player;
                break;
            }
            case 8: {
                table.get(4)[2] = player;
                break;
            }
            case 9: {
                table.get(4)[4] = " X ";
                break;
            }
            default:
                break;
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static List<int[]> listWin(List<int[]> win) {
        win.add(new int[]{1, 2, 3});
        win.add(new int[]{4, 5, 6});
        win.add(new int[]{7, 8, 9});
        win.add(new int[]{1, 4, 7});
        win.add(new int[]{2, 5, 8});
        win.add(new int[]{3, 6, 9});
        win.add(new int[]{1, 5, 9});
        win.add(new int[]{3, 5, 7});
        return win;
    }

    public static void printTable(List<String[]> table) {
        for (String[] row : table) {
            for (String column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
        System.out.println();
    }

}
