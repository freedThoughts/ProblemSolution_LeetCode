package hero;

public class Burgers {

    public static void main(String[] arg) {
        int[] ans = solution(15, 40);
        System.out.println(ans[0] + " " + ans[1]);
    }

    static int[] solution(int X, int Y) {
        int x = X;
        int y = Y;
        int min = 0;
        int big = 0;
        while(x >= 1 && y >= 4) {
            big++;
            x = x - 1;
            y = y - 4;
        }

        if (x == 0 && y == 0) return new int[]{min, big};

        while (x >= 1 && y >= 2) {
            min ++;
            x = x -1;
            y = y -2;
        }
        if (x == 0 && y == 0) return new int[]{min, big};

        while (big > 0) {
            big--;
            x = x +1;
            y = y +4;
            while (x >= 1 && y >= 2) {
                min ++;
                x = x -1;
                y = y -2;
            }
            if (x == 0 && y == 0) return new int[]{min, big};
        }

        return new int[]{-1, -1};
    }
}
