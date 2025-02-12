import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());

        Map<String, TreeNode> treeMap = new HashMap<>();

        for(int i=0;i<26;i++){
            char character = (char) (i+65);
            String str = String.valueOf(character);
            treeMap.put(str, new TreeNode(str, null, null));
        }

        for(int i=0;i<n;i++){
            String[] strs = br.readLine().split(" ");
            if(!strs[1].equals(".")){
                treeMap.get(strs[0]).left = treeMap.get(strs[1]);
            }
            if(!strs[2].equals(".")){
                treeMap.get(strs[0]).right = treeMap.get(strs[2]);
            }
        }

        TreeNode root = treeMap.get("A");

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);


    }

    private static void preorder(TreeNode node){
        System.out.print(node.node);
        if(node.left!=null){
            preorder(node.left);
        }
        if(node.right!=null){
            preorder(node.right);
        }
    }

    private static void inorder(TreeNode node){
        if(node.left != null){
            inorder(node.left);
        }
        System.out.print(node.node);
        if(node.right != null){
            inorder(node.right);
        }
    }

    private static void postorder(TreeNode node){
        if(node.left!=null){
            postorder(node.left);
        }
        if(node.right!=null){
            postorder(node.right);
        }
        System.out.print(node.node);
    }
}

class TreeNode {
    String node;
    TreeNode left;
    TreeNode right;

    public TreeNode(String node, TreeNode left, TreeNode right) {
        this.node = node;
        this.left = left;
        this.right = right;
    }
}