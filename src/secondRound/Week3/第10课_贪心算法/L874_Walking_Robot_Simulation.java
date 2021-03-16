package secondRound.Week3.第10课_贪心算法;

import java.util.HashSet;
import java.util.Set;

public class L874_Walking_Robot_Simulation {
    int moveX[] = {0, 1, 0, -1};
    int moveY[] = {1, 0, -1, 0};

    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int dir = 0;
        int curX = 0; int curY = 0;
        Set<Long> obstaclesSet = new HashSet<>();
        for(int i = 0; i < obstacles.length; i++){
            long x = obstacles[i][0] + 30000;
            long y = obstacles[i][1] + 30000;
            long xy = ((x << 16) + y);
            obstaclesSet.add(xy);
        }

        for(int command : commands){
            if(command == -1){
                dir = (dir + 1) % 4;
            }else if(command == -2){
                dir = (dir + 3) % 4;
            }else{
                for(int j = 0; j < command; j++){
                    int newX = curX + moveX[dir];
                    int newY = curY + moveY[dir];
                    long newxy = (((long)newX + 30000) << 16) + ((long)newY + 30000);
                    if(obstaclesSet.contains(newxy)){
                        break;
                    }else{
                        curX = newX;
                        curY = newY;
                        max = Math.max(max, newX * newX + newY * newY);
                    }
                }
            }
        }
        return max;
    }
}

//byte short int long ， char flout double 1 2 4 8， 2 4 8
//2^7 = 128
//2^8 = 256
//2^15 = 32768
//2^16 = 65536

//少的字节强转 多的字节不会缺失精度