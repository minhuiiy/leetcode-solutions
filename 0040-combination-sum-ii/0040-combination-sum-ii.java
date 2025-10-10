class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > start && cand[i] == cand[i - 1]) continue;

            if(cand[i] > remain) break;

            path.add(cand[i]);
            dfs(cand, i + 1, remain - cand[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}