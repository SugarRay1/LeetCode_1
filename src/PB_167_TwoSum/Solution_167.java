package PB_167_TwoSum;

public class Solution_167 {
    public static void main(String[] args) {
        Solution_167 sol = new Solution_167();
        int[] numbers = {12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199, 212, 221, 227, 230, 277, 282, 306, 314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375, 384, 387, 394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583, 585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847, 858, 863, 863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997};
        int target = 542;
        System.out.println(sol.twoSum_2(numbers, target));

    }

    //方法1:双指针
    public int[] twoSum(int[] numbers, int target) {
        int front_index = 0;
        int back_index = numbers.length - 1;
        int[] re_target = {-1, -1};
        while (front_index < back_index) {
            if ((numbers[front_index] + numbers[back_index]) == target) {
                re_target[0] = front_index + 1;
                re_target[1] = back_index + 1;
                break;
            } else if ((numbers[front_index] + numbers[back_index]) < target) {
                front_index++;
            } else {
                back_index--;
            }
        }
        return re_target;
    }


    //方法2：二分查找
    public int[] twoSum_2(int[] numbers, int target) {
        int[] re_target = {0, 0};
        for (int i = 0; i < numbers.length - 1; i++) {
            int second_index = recursive_binary_search(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (second_index > i) {
                re_target[0] = i + 1;
                re_target[1] = second_index + 1;
                break;
            }
        }
        return re_target;
    }

    //递归二分查找,没有就返回-1
    public int recursive_binary_search(int[] numbers, int target, int start, int end) {
        if ((start == end) || (end - start == 1)) {
            if (numbers[start] == target) {
                return start;
            } else if (numbers[end] == target) {
                return end;
            } else {
                return -1;
            }
        } else {
            int mid = (start + end) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                return recursive_binary_search(numbers, target, mid, end);
            } else {
                return recursive_binary_search(numbers, target, start, mid);
            }
        }
    }
}
