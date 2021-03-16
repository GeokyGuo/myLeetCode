package secondRound.Week1.第03课_数组_链表_跳表.array;

public class L11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea4(height));
    }

    public static int maxArea1(int[] height) {
        int maxA = 0;
        for (int k = 0; k < height.length - 1; k++) {
            for (int l = k + 1; l < height.length; l++) {
                int area = (l - k) * Math.min(height[k], height[l]);
                maxA = Math.max(area, maxA);
            }
        }
        return maxA;
    }

    public static int maxArea2(int[] height) {
        int maxA = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
//            算面积 右减左*最小高度
//            比较出 最大面积并赋值
//            移动较小的边界，如果左边小 则移动 否则移动右边界
            int area = (j - i) * Math.min(height[i], height[j]);
            maxA = Math.max(maxA, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxA;
    }

    //复习
    public static int maxArea3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;

        int i = 0;
        int j = height.length - 1;
        while (i<j) {
            int temp = (j - i) * Math.min(height[i], height[j]);
            max = Math.max(temp, max);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public static int maxArea4(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        int area = 0;
        while(i < j){
            if(height[i] < height[j]){
                area = height[i] * (j - i);
                while(i < j && height[i] < height[i + 1]) i++;
            }else{
                area = height[j] * (j - i);
                while(i < j && height[j] < height[j - 1]) j--;
            }
            max = area > max ? area : max;
        }
        return max;
    }

}
