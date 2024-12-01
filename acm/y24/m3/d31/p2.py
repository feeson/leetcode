# Definition for a binary tree node.
from collections import deque


class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def isCompleteTree(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        walk = deque()
        walk.append(root)
        nxt = deque()
        if root.left:
            nxt.append(root.left)
        if root.right:
            nxt.append(root.right)
        while len(nxt) == 2 * len(walk):
            walk = nxt
            nxt = deque()
            for _, node in enumerate(walk):
                if node.left is not None:
                    nxt.append(node.left)
                if node.right is not None:
                    nxt.append(node.right)
        if not bool(nxt):
            return True
        for _, pa in enumerate(walk):
            def hasChild(node):
                if node.left is not None or node.right is not None:
                    return True
                return False
            if not bool(nxt):
                continue
            l = nxt.popleft()
            if pa.left is None or pa.left.val != l.val:
                return False
            if hasChild(l):
                return False
            if nxt:
                r = nxt.popleft()
                if pa.right is None or pa.right.val != r.val:
                    return False
                if hasChild(r):
                    return False
        else:
            return True


if __name__ == "__main__":
    solution = Solution()
    def list_to_tree(lst):
        if not lst:
            return None
        root = TreeNode(lst[0])
        queue = deque([root])
        i = 1
        while queue and i < len(lst):
            node = queue.popleft()
            if lst[i] is not None:
                node.left = TreeNode(lst[i])
                queue.append(node.left)
            i += 1
            if i < len(lst) and lst[i] is not None:
                node.right = TreeNode(lst[i])
                queue.append(node.right)
            i += 1
        return root
    node = list_to_tree([1,2,3,4,5,6,7,8,9,10,11,12,13,None,None,15])
    solution.isCompleteTree(node)
