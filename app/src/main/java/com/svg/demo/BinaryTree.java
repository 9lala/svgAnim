package com.svg.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private BinaryTreeNode root;//二叉树根结点

    public BinaryTree() {
        this.root = null;
    }

    /*       建立二叉树：
                 1
               /   \
              2      3
             / \    /
            4   5   6
     */
    public BinaryTreeNode createBinaryTree() {
        root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setLeft(new BinaryTreeNode(6));
        return root;
    }

    //先序遍历:非递归方法
    public void PreOrderIterative(BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {  //遇到一个结点，就把它压栈并访问它，然后去遍历它的左子树；
                s.push(temp);
                System.out.print(temp.getData() + " ");
                temp = temp.getLeft();
            }
            if (!s.isEmpty()) {
                temp = s.pop();//当左子树遍历结束后，从栈顶弹出这个结点；
                temp = temp.getRight();//然后按其右指针再去先序遍历该结点的右子树
            }
        }
    }

    //中序遍历:非递归方法
    public void InOrderIterative(BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {  //遇到一个结点，就把它压栈，并去遍历它的左子树；
                s.push(temp);
                temp = temp.getLeft();
            }
            if (!s.isEmpty()) {
                temp = s.pop();//当左子树遍历结束后，从栈顶弹出这个结点并访问它；
                System.out.print(temp.getData() + " ");
                temp = temp.getRight();// 然后按其右指针再去中序遍历该结点的右子树
            }
        }
    }

    //后序遍历:非递归方法
    public void PostOrderIterative(BinaryTreeNode root) {
        BinaryTreeNode temp = root;
        BinaryTreeNode pre = null;//标记访问序列中前一个二叉树节点（当前节点的之前访问的节点）
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                s.push(temp);
                temp = temp.getLeft();
            }
            if (!s.isEmpty()) {
                temp = s.peek();
                //如果一个节点右孩子是空，或者右孩子刚被访问过，那么就访问该节点。否则就往右孩子走。
                if (temp.getRight() == null || temp.getRight() == pre) {
                    System.out.print(temp.getData() + " ");
                    s.pop();
                    pre = temp;
                    temp = null;
                } else {
                    temp = temp.getRight();
                }
            }
        }
    }

    //层序遍历
    public void LevelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;

        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        if (root == null)
            return;
        q.add(root);
        while (!q.isEmpty()) {
            temp = q.poll();//移除并返问队列头部的元素
            System.out.print(temp.getData() + " ");
            if (temp.getLeft() != null) {
                q.add(temp.getLeft());//左孩子入队
            }
            if (temp.getRight() != null) {
                q.add(temp.getRight());//右孩子入队
            }
        }
    }
}
