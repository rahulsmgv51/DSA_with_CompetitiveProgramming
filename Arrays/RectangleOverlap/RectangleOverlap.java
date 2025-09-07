package Arrays.RectangleOverlap;
public class RectangleOverlap{
    public static void main(String[] args){
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec2[2] <= rec1[0] || rec2[0] >= rec1[2]) return false;

        if(rec2[3] <= rec1[1] || rec2[1] >= rec1[3]) return false;

        return true;
    }

}