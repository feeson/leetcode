package y23.m9.d4;

public class Codec1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("h:" + root.hashCode());
        sb.append("v:" + root.val);
        sb.append("{l:" + root.hashCode());
        sb.append(serialize(root.left));
        sb.append("}{r:" + root.hashCode());
        sb.append(serialize(root.right));
        sb.append("}" + root.hashCode() + "}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        int index = data.indexOf("h:") + 2;
        int index2 = data.indexOf("v:", index);
        String hashCode = data.substring(index, index2);
        index = data.indexOf("{l:", index2) + 3 + hashCode.length();
        int val = Integer.parseInt(
                data.substring(index2 + 2, index - 3 - hashCode.length()));
        index2 = data.indexOf("}{r:" + hashCode, index);
        String left = data.substring(index, index2);
        index = data.indexOf("}" + hashCode + "}", index2);
        String right = data.substring(index2 + 4 + hashCode.length(), index);
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = deserialize(left);
        treeNode.right = deserialize(right);
        return treeNode;
    }
}
