package com.example.springboot.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 树：自关联
 */
public class Tree {
    private String treeId;
    private String parentTreeId;
    private String title;
    private String url;
    private String treeDesc;
    private List<Tree> childTrees=new ArrayList<Tree>();

    //    private Tree parentTree;

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getParentTreeId() {
        return parentTreeId;
    }

    public void setParentTreeId(String parentTreeId) {
        this.parentTreeId = parentTreeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTreeDesc() {
        return treeDesc;
    }

    public void setTreeDesc(String treeDesc) {
        this.treeDesc = treeDesc;
    }

    public List<Tree> getChildTrees() {
        return childTrees;
    }

    public void setChildTrees(List<Tree> childTrees) {
        this.childTrees = childTrees;
    }

//    public Tree getParentTree() {
//        return parentTree;
//    }
//
//    public void setParentTree(Tree parentTree) {
//        this.parentTree = parentTree;
//    }
}