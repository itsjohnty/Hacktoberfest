class Solution(object):
    # code for subset
    def subsets(self, nums):
        res=[]
        n=len(nums)

        def backtrack(start,subset):
            res.append(subset[:])

            for i in range(start,n):
                subset.append(nums[i])
                backtrack(i+1,subset)
                subset.pop()
        
        backtrack(0,[])
        
        return res
