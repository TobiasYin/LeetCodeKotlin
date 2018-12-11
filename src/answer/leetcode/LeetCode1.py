class Solution1:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        nums_set = set(nums)
        for i in nums_set:
            if target-i in nums_set:
                index_1=nums.index(i)
                nums[index_1]=None
                index_2=nums.index(target-i)
                return [index_1,index_2]