package tree;

import java.io.IOException;
import java.util.ArrayList;

import treecloud.ConcordanceText;
import treecloud.EqualAngle;
import treecloud.NeighborJoining;

/**
 * Class used to compute tree from Concordance file
 * (currently impossible to use as the distance matrix is too big
 * and NJ algorithm works very slowly)
 * @author Aleksandra Chashchina
 *
 */

public class Tree {
	
	public String filepath;
	public int numberoftaxa;
	public ArrayList<String> words = new ArrayList<String>();
	public ArrayList<ArrayList<Double>> distancematrix = new ArrayList<ArrayList<Double>>();
	public String newick;
	public ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
	
	public Tree(String path){
		this.filepath = path;
	}
	
	
	public void computeTree() throws IOException{
		
		ConcordanceText txt = new ConcordanceText();
		txt.FindFiles(filepath);
		System.out.println(txt.GetConcorPath());
		txt.readConcor();
		distancematrix = txt.getNormalizedMatrix();
		words = txt.getWords();
		numberoftaxa = words.size();
		
		NeighborJoining nj = new NeighborJoining();
		for(String s: words){
			TreeNode n = new TreeNode();
			n.setName(s);
			n.setAsLeaf();
			n.setID(words.indexOf(s));
			nj.allnodes.add(n);
		}
		
		newick = nj.computeNJTree(distancematrix, words);
		
		EqualAngle ea = new EqualAngle();
		ea.doEqualAngle(nj.allnodes, numberoftaxa);
		nodes = nj.allnodes;
	}
	
//	public static void main(String [] args) throws IOException{
//		Tree t = new Tree("C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/English/test");
//		
//		t.computeTree();
//		
//		System.out.println(t.words);
//		System.out.println(t.numberoftaxa);
//	}
	
	

}
