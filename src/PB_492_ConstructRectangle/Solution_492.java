package PB_492_ConstructRectangle;

public class Solution_492 {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        int traverse_width = (int) Math.sqrt(area);
        while (traverse_width >= 1) {
            if (area % traverse_width == 0) {
                result[0] = area / traverse_width;
                result[1] = traverse_width;
                break;
            }
            traverse_width--;
        }
        return result;
    }
}
