import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<List<Integer>> perms;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        perms = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        backtrack(0, nums.length, perm);
        return map2Var(nums, perms);
    }

    private List<List<Integer>> map2Var(int[] nums, List<List<Integer>> perms) {
        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> perm : perms) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < perm.size(); i++) {
                if (perm.get(i)==1) {
                    cur.add(nums[i]);
                }
            }
            Collections.sort(cur);
            if(!ans.contains(cur)){
                ans.add(cur);
            }
        }
        return ans;
    }

    private void backtrack(int idx, int length, List<Integer> perm) {
        if (idx == length) {
            perms.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < 2; i++) {
            perm.add(i);
            backtrack(idx + 1, length, perm);
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,2};
        System.out.println(s.subsetsWithDup(arr));
    }
}