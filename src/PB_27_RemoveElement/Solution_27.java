package PB_27_RemoveElement;

public class Solution_27 {
    public static void main(String[] args) {
        Solution_27 sol = new Solution_27();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(sol.removeElement(nums, val));

    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (!checkAndSwag(nums, i)) {
                    length = i;
                    break;
                }
            }
        }
        return length;
    }

    //在index之后寻找最近的，不是val值的，与index位交换
    public boolean checkAndSwag(int[] nums, int index) {
        boolean flag = false;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                flag = true;
                break;
            }
        }
        return flag;
    }

}
