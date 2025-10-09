class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] cand, int start, int remain, List<Integer> path, List<List<Integer>> res) {
        if(remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < cand.length; i++) {
            int x = cand[i];
            if(x > remain) break;
            path.add(x);
            dfs(cand, i, remain - x, path, res);
            path.remove(path.size() - 1);
        }
    }
}