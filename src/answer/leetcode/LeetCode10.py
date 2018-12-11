class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        import re
        answer = re.match(p, s)
        if answer:
            if answer.group() == s:
                return True
            else:
                return False
        else:
            return False
# 这道题偷懒了，之后会用koltin完全重做
