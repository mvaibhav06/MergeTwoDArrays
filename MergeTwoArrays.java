import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MergeTwoArrays {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer,Integer> temp1 = new HashMap<>();
        HashMap<Integer,Integer> temp2 = new HashMap<>();
        HashSet<Integer> size = new HashSet<>();

        for(int i=0; i<nums1.length; i++){
            temp1.put(nums1[i][0], nums1[i][1]);
            size.add(nums1[i][0]);
        }

        for(int i=0; i<nums2.length; i++){
            temp2.put(nums2[i][0], nums2[i][1]);
            size.add(nums2[i][0]);
        }
        int[][] out = new int[size.size()][2];

        int i = 0;

        for(int key : temp1.keySet()){
            out[i][0] = key;
            if(temp2.containsKey(key)){
                out[i][1] = temp1.get(key) + temp2.get(key);
            }else{
                out[i][1] = temp1.get(key);
            }
            i++;
        }
        for(int key : temp2.keySet()){
            if(!temp1.containsKey(key)){
                out[i][0] = key;
                out[i][1] = temp2.get(key);
                i++;
            }
        }
        Arrays.sort(out, (int[] a, int[] b) -> a[0]-b[0]);
        return out;
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] out = mergeArrays(nums1,nums2);
        for (int i=0; i<out.length; i++){
            System.out.println(Arrays.toString(out[i]));
        }
    }
}
