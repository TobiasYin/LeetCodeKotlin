class Solution3:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        data = []
        max_len = 0
        sub_len = 0
        for i in s:
            if i in data:
                if sub_len > max_len:
                    max_len = sub_len
                index = data.index(i)
                sub_len -= index
                data = data[index + 1:]
                data.append(i)
            else:
                data.append(i)
                sub_len += 1
        if sub_len > max_len:
            max_len = sub_len
        return max_len
