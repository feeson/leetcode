package y23.m11.d26;

/**
 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

 实现词典类 WordDictionary ：


 WordDictionary() 初始化词典对象
 void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。




 示例：

 输入：
 ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 输出：
 [null,null,null,null,false,true,true,true]

 解释：
 WordDictionary wordDictionary = new WordDictionary();
 wordDictionary.addWord("bad");
 wordDictionary.addWord("dad");
 wordDictionary.addWord("mad");
 wordDictionary.search("pad"); // 返回 False
 wordDictionary.search("bad"); // 返回 True
 wordDictionary.search(".ad"); // 返回 True
 wordDictionary.search("b.."); // 返回 True




 提示：


 1 <= word.length <= 25
 addWord 中的 word 由小写英文字母组成
 search 中的 word 由 '.' 或小写英文字母组成
 最多调用 104 次 addWord 和 search


 */
/*
https://leetcode.cn/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150
*/
class WordDictionary {
    class Node{
        Node(char c){
            this.c = c;
            this.isWord = false;
        }
        char c;
        boolean isWord;
        Node[] nxt = new Node[26];
    }
    Node root = new Node('/');
    public WordDictionary() {

    }

    public void addWord(String word) {
        char[] ca = word.toCharArray();
        Node node = root;
        for (char c:ca){
            int index = c-'a';
            if (node.nxt[index] == null)
                node.nxt[index] = new Node(c);
            node = node.nxt[index];
        }
        node.isWord = true;
    }
    boolean dfs(Node node,String word){
        char[] ca = word.toCharArray();
        int len = ca.length;
        for (int i=0;i<len;++i){
            if (ca[i] =='.'){
                for (Node nxtN:node.nxt){
                    if (nxtN != null &&dfs(nxtN,word.substring(i+1)))
                        return true;
                }
                return false;
            }
            int index = ca[i]-'a';
            if (node.nxt[index] == null)
                return false;
            node = node.nxt[index];
        }
        return node.isWord;
    }
    public boolean search(String word) {
        return dfs(root,word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
