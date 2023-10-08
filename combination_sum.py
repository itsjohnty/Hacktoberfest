class Solution(object):
    def combinationSum(self, candidates, target):
        res=[]

        def backtrack(start, combination, current_sum):
            if current_sum==target:
                res.append(combination[:])
                return 
            if current_sum>target:
                return

            for i in range(start, len(candidates)):
                combination.append(candidates[i])
                backtrack(i, combination, current_sum+candidates[i])
                combination.pop()
            
        backtrack(0,[],0)
        return res
