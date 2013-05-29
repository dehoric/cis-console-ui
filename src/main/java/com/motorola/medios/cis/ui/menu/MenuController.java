package com.motorola.medios.cis.ui.menu;

import com.motorola.medios.cis.ui.menu.model.MenuNode;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/*
 * Copyright 2013 Motorola Mobility, All rights reserved.
 */
@ManagedBean
@SessionScoped
public class MenuController implements Serializable {

    private static String NODE_TYPE = "menuitem";

    private TreeNode root;

    private TreeNode selectedNode;

    public MenuController() {
        root = new DefaultTreeNode("Root", null);

        TreeNode ingestion = new DefaultTreeNode(new MenuNode("Ingest", null), root);

        createIngestionMenu(ingestion);
    }

    private void createIngestionMenu(TreeNode ingestion) {
        new DefaultTreeNode(NODE_TYPE, new MenuNode("ADI11", "ingest/ADI11"), ingestion);
        new DefaultTreeNode(NODE_TYPE, new MenuNode("ADI11 Merchandiser", "ingest/ADI11merch"), ingestion);
        new DefaultTreeNode(NODE_TYPE, new MenuNode("ADI3", "ingest/ADI3"), ingestion);
        new DefaultTreeNode(NODE_TYPE, new MenuNode("EPG", "ingest/epg"), ingestion);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public String onNodeSelect(NodeSelectEvent event) {
        if (root == event.getTreeNode().getParent()) {
            return null;
        }

        for (TreeNode treeNode : root.getChildren()) {
            if (treeNode.equals(selectedNode.getParent())) {
                treeNode.setExpanded(true);
            } else {
                treeNode.setExpanded(false);
            }
        }

        return ((MenuNode) event.getTreeNode().getData()).getView();
    }
}
