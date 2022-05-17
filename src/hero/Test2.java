package hero;

public class Test2 {


    public int[] solution(int X, int Y) {

        int x = X;
        int y = Y;
        int big = 0;
        int mini = 0;
        while(x >= 1 && y >= 4){
            big++;
            x = x - 1;
            y = y - 4;
            if (x == 0 && y == 0) return new int[]{mini, big};
        }

        while(big > 0){
            big--;
            x = x + 1;
            y = y + 4;
            while(x >= 1 && y >= 2){
                mini++;
                x = x-1;
                y = y -2;
                if (x == 0 && y == 0) return new int[]{mini, big};

            }

        }

        while(x >= 1 && y >= 2){
            mini++;
            x = x-1;
            y = y -2;
            if (x == 0 && y == 0) return new int[]{mini, big};

        }

        return new int[]{-1, -1};

    }
}

