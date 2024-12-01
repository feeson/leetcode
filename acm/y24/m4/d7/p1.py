class Node:
    def __init__(self, name):
        self.name = name
        self.childs = []
        self.dead = False


class ThroneInheritance(object):

    def __init__(self, kingName):
        """
        :type kingName: str
        """
        self.king = kingName
        kingNode = Node(kingName)
        self.head = kingNode
        self.dic = {kingName: kingNode}

    def birth(self, parentName, childName):
        """
        :type parentName: str
        :type childName: str
        :rtype: None
        """
        cdNode = Node(childName)
        self.dic[childName] = cdNode
        paNode = self.dic[parentName]
        paNode.childs.append(cdNode)

    def death(self, name):
        """
        :type name: str
        :rtype: None
        """
        self.dic[name].dead = True

    def getInheritanceOrder(self):
        """
        :rtype: List[str]
        """
        res = []
        def dfs(node):
            if not node.dead:
                res.append(node.name)
            for child in node.childs:
                dfs(child)

        dfs(self.head)
        return res

# Your ThroneInheritance object will be instantiated and called as such:
# obj = ThroneInheritance(kingName)
# obj.birth(parentName,childName)
# obj.death(name)
# param_3 = obj.getInheritanceOrder()
