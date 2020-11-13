public class Judge {
    public int findJudge(int n, int[][] trust) {
        int total_trust[] = new int[n];
        int j = 0; //maybe j
        for (int i = 0; i < total_trust.length; i++) {
            if (trust[i][0] > 0 && trust[i][j] != trust[i][j + 1]) { //row and col not equal
                total_trust[trust[i][0] - 1] += 1;
            } else {
                System.out.println("The values are same for " + trust[i][j] + trust[i][j + 1]);
            }
        }

        int n_judge = -1;
        int list[] = new int[n];
        for (int x = 0; x < n; x++) { //find judge
            int y = 0;
            if (total_trust[x] == 0) { //when no trust on any judge
                for (int z = 0; z < trust.length; z++) { //check all others that do trust this
                    boolean b = false;
                    for (int a = 0; a < z; a++) { //check if trusted or not
                        b = true;
                        break;
                    }
                    if (trust[z][1] == x + 1 && b == false) { //if everyone trusts judge
                        list[y] = trust[z][0]; //add judge to trust list
                        y += 1;//number trusted
                    } else {
                        if (b) {
                        } else { //if judge not trusted by person then break
                            break;
                        }
                    }
                }
            }
            if (y == n - 1) {
                n_judge = x + 1; //if everyone else trusted judge
                break;
            }

        }
        return n_judge;

    }

    public static void main(String[] args) {
        Judge N = new Judge();
        int array_1[][] = {{1, 3}, {2, 3}};
        int array_2[][] = {{1, 3}, {2, 3}, {3, 1}};
        int array_3[][] = {{1, 3}, {2, 3}};
        int array_4[][] = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println("Array 1 judge: " + N.findJudge(3, array_1));
        System.out.println("Array 2 judge: " + N.findJudge(3, array_2));
        System.out.println("Array 3 judge: " + N.findJudge(3, array_3));
        System.out.println("Array 4 judge: " + N.findJudge(4, array_4));

    }
}





