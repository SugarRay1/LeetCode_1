package PB_283_MoveZeros;

public class Solution_283 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
        Solution_283 sol = new Solution_283();
        sol.moveZeroes(nums);
    }

    /**
     * 方法3
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {

        //计算0的个数
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero = countZero + 1;
            }
        }

        //找到之后放到前面
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[current] = nums[i];
                current = current + 1;
            }
        }

        //后面全部置零
        for (int i = current; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    /**
     * 方法2：改进版
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int nearestNoneZero = findNearestNoneZero(nums, i);
                //说明已经换好了
                if (nearestNoneZero == nums.length) {
                    break;
                } else {
                    swap2(nums, i, nearestNoneZero);
                }
            }
        }
    }

    //寻找最近的非零数
    public int findNearestNoneZero(int[] nums, int index) {
        int nearestNoneZero = nums.length;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != 0) {
                nearestNoneZero = i;
                break;
            }
        }
        return nearestNoneZero;
    }

    //交换位置
    public void swap2(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 方法1：
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        first:
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0) {
                moveToLast(nums, i);
                if (checkDone(nums, i)) {
                    break first;
                }
            }
        }
    }

    //查看是否排序完成
    public boolean checkDone(int[] nums, int index) {
        boolean flag = true;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    //把一个元素一道最后一个
    public void moveToLast(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; i++) {
            swap(nums, i, i + 1);
        }
    }

    //交换位置
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
