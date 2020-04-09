package com.svg.demo;


public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode root = tree.createBinaryTree();
        System.out.println("先序遍历为：");
        tree.PreOrderIterative(root);
        System.out.println("\n中序遍历为：");
        tree.InOrderIterative(root);
        System.out.println("\n后序遍历为：");
        tree.PostOrderIterative(root);
        System.out.println("\n层序遍历为：");
        tree.LevelOrder(root);
    }
}