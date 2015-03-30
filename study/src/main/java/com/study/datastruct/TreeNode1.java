package com.study.datastruct;

import java.util.List;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com 2015年3月29日
 * 
 */
public class TreeNode1 {

    /* 存数据的 */
    private Object value;
    /* 左孩子结点 */
    private TreeNode leftChild;
    /* 右孩子结点 */
    private TreeNode rightChild;
    private int parent;
    protected TreeNode parentNode;
    protected List<TreeNode> childList;

    public Object getValue() {
	return value;
    }

    public void setValue(Object value) {
	this.value = value;
    }

    public TreeNode getLeftChild() {
	return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
	this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
	return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
	this.rightChild = rightChild;
    }

    public int getParent() {
	return parent;
    }

    public void setParent(int parent) {
	this.parent = parent;
    }

    public TreeNode getParentNode() {
	return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
	this.parentNode = parentNode;
    }

    public List<TreeNode> getChildList() {
	return childList;
    }

    public void setChildList(List<TreeNode> childList) {
	this.childList = childList;
    }

}
