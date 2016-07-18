package tree;

import java.util.ArrayList;

import treecloud.EqualAngle;

/**
 * Main class of the TreeCloud plugin
 * (currently works only on trees from TestData)
 * @author Aleksandra Chashchina
 *
 */

public class Main {
	
	public static void main(String [] args){
		
		TestData test = new TestData();
		ArrayList<TreeNode> tree = test.getFourthTest();
		
		EqualAngle ea = new EqualAngle();
		
		ea.doEqualAngle(tree, test.getNtaxaFourth());
		
		TreeSVG.drawTreeCloud(tree);
		
		
	}

}
