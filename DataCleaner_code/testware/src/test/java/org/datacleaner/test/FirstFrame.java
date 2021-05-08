package org.datacleaner.test;

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: wuyj.
 * @Description: TODO()
 * @Date:Created in 2020/3/26 20:38.
 * @Modified By:
 */
public class FirstFrame  extends JFrame {

	public static void main(String[] args) {
		FirstFrame t = new FirstFrame();
		t.show();

	}

	public FirstFrame(){
		this.setBounds(300,300,300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
		DefaultMutableTreeNode roo1 = new DefaultMutableTreeNode("节点1");
		DefaultMutableTreeNode roo2 = new DefaultMutableTreeNode("节点2");
		DefaultMutableTreeNode roo3 = new DefaultMutableTreeNode("节点3");
		DefaultMutableTreeNode roo4 = new DefaultMutableTreeNode("节点4");
		JTree tree = new JTree(root);
		root.add(roo1);
		root.add(roo2);
		root.add(roo3);
		root.add(roo4);

		this.getContentPane().add(tree,BorderLayout.CENTER);
	}
}

