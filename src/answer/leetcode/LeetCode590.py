"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if root == None:
            return []
        stack1 = []
        result = []
        stack1.append(root)
        while len(stack1) != 0:
            temp = stack1.pop()
            result.append(temp.val)
            if temp.children:
                for i in temp.children:
                    stack1.append(i)
        return result[::-1]
