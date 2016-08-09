package tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import treecloud.ConcordanceText;
import treecloud.EqualAngle;
import treecloud.NeighborJoining;
import treecloud.PreprocessConcordance;

/**
 * Class used to compute tree from Concordance file
 * (currently impossible to use as the distance matrix is too big
 * and NJ algorithm works very slowly)
 * @author Aleksandra Chashchina
 *
 */

public class Tree {
	
	public String corpuspath;
	int numberoftaxa;
	public String language;
	public ArrayList<String> words = new ArrayList<String>();
	public ArrayList<ArrayList<Double>> distancematrix = new ArrayList<ArrayList<Double>>();
	public String newick;
	public ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
	private ArrayList<TreeNode> leaves = new ArrayList<TreeNode>();
	public String concordind;
	public String concordhtml;
	public String alphabet;
	public String statsoutput;
	public String [] statscommand;
	public String unitextool;
	public boolean removestopwords;
	public String locatetarget = "nation";
	int minNmbOfOccur;
	String colormode;
	String edgecolor;
	
	public void setCorpusPath(String p){
		this.corpuspath = p;
	}
	
	public void setAlphabetPath(String a){
		this.alphabet = a;
	}
	
	public void setLanguage(String lang){
		this.language = lang;
	}
	
	public void setMinNbOccur(int n){
		this.minNmbOfOccur = n;
	}
	
	public void setNumberOfTaxa(int n){
		this.numberoftaxa = n;
	}
	
	public void setLocateTarget(String l){
		this.locatetarget = l;
	}
	
	public void setUnitexToolLoggerPath(String u){
		this.unitextool = u;
	}
	
	public ArrayList<TreeNode> getNodeList(){
		return this.nodes;
	}
	
	public String getNewickTree(){
		return this.newick;
	}
	
	public ArrayList<String> getTreeWords(){
		return this.words;
	}
	
	public int getNumberOfTaxa(int n){
		return this.numberoftaxa;
	}
	
	
	
	public void findFiles(String dir){   
		File f = new File(dir);
		for (File item : f.listFiles()){
			if (item.isFile()){
				if (item.getName().equals("concord.html")){
					 concordhtml = item.getAbsolutePath();
				}else if(item.getName().equals("concord.ind")){
					concordind = item.getAbsolutePath();
			    }
			}else{
				findFiles(item.getAbsolutePath());
				}
			}
		}
	

	public void setStatsOutput(String concordhtmlpath){
		
		Pattern p = Pattern.compile("(.*?)(concord\\.html)");
		Matcher m = p.matcher(concordhtmlpath);
		if(m.find()){
			String res = m.group(1) + "statistics.txt";
			statsoutput = res;
		}else{
			System.out.println("Error in concord.html filepath");
		}
	}
	
	public void setStatsCommand(){
		
		String [] cmd = new String[10];
		cmd[1] = "\"Stats\"";
		cmd[4] = "\"-l10\"";
		cmd[5] = "\"-r10\"";
		cmd[7] = "\"-c1\"";
		cmd[8] = "\"-m1\"";
		cmd[9] = "\"-qutf8-no-bom\"";
		cmd[0] = "\"" + unitextool + "\"";
		cmd[2] = "\"" + concordind +  "\"";
		cmd[3] = "\"-a" + alphabet + "\"";
		cmd[6] = "\"-o" + statsoutput + "\"";
		
		statscommand = cmd;
	}
	
	/*
	 * TODO: correct all this
	 */
	
	private ArrayList<String> getTreeLabels() throws IOException, InterruptedException{
		
		PreprocessConcordance p = new PreprocessConcordance();
		
		ArrayList<String> alltokens = p.readStats(statsoutput, statscommand);
		//alltokens.add("nation");
		if(removestopwords){
			p.removeStopWords(alltokens, language);
			//System.out.println(alltokens);
			//System.out.println(alltokens.contains("nation"));
		}
		
		if(minNmbOfOccur != 0){
			//ArrayList<String> curr = new ArrayList<String>();
			alltokens = p.getWordsFreqs(statsoutput, minNmbOfOccur);
	
			//if(removestopwords){				
				//curr = p.removeStopWords(alltokens, language);
			//}else{
				//curr = alltokens;
			//}
		}
			
		if(numberoftaxa != 0){
			ArrayList<String> res = p.getWordsNumber(alltokens, numberoftaxa-1);
			//res.add(locatetarget);
			return res;
		}else{
			ArrayList<String> res = new ArrayList<String>(p.getWordsNumber(alltokens, 29));
			//res.add("nation");
			return res;
		}
//			else{
//				/*
//				 * 30 by default
//				 */
//				numberoftaxa = 30;
//				return p.getWordsNumber(curr, 30);
//			}
//		}else{
//			ArrayList<String> tokens = p.readStats(statsoutput, statscommand);
//			ArrayList<String> curr2 = new ArrayList<String>();
//			
//			if(removestopwords){
//				curr2 = p.removeStopWords(tokens, language);
//			}
//			
//			if(numberoftaxa != 0){
//				return p.getWordsNumber(curr2, numberoftaxa);
//			}else{
//				/*
//				 * 30 by default
//				 */
//				return p.getWordsNumber(curr2, 30);
//			}
//			
//		}
		
	}
	
	
	public void setDistanceMatrix() throws IOException, InterruptedException{
		
        ConcordanceText txt = new ConcordanceText();
        if(removestopwords){
        	leaves = txt.computeMatrixNoStats(concordhtml, PreprocessConcordance.getStopWordsFile(language), numberoftaxa, colormode);
        }else{
        	leaves = txt.computeMatrixNoStats(concordhtml, null, numberoftaxa, colormode);
        }
		distancematrix = txt.getMatrix();
		edgecolor = txt.getEdgeColor();
		words = txt.getLabelList();
	}
	
	public void performNJ(){
		NeighborJoining nj = new NeighborJoining(leaves);
		//nj.allnodes = leaves;
		//System.out.println("dm: " + distancematrix.size());
		//System.out.println("words: " + words.size());
		
		newick = nj.computeNJTree(distancematrix, words);
		nodes = nj.allnodes;
	}
	
	public void performEqualAngle(){
		EqualAngle ea = new EqualAngle();
		ea.doEqualAngle(nodes, numberoftaxa);
	}
	
	public void drawTree(){
		TreeSVG.drawTreeCloud(nodes, edgecolor);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void computeTree() throws IOException{
//		/*
//		 * Get current language
//		 */
//		
//		//GramlabProject p = GramlabConfigManager.getCurrentProject();
//		//String corpus = p.getCorpusDirectory().getAbsolutePath();
//		//String alphabet = p.getAlphabet().getAbsolutePath();
//		//String lang = p.getLanguage();
//		String testpath = "C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/English/test";
//		
//		Tree t = new Tree();
//		t.setCorpusPath(testpath);
//		t.setLanguage("English");
//		
//		t.findFiles(testpath);
//		t.setStatsOutput(t.concordhtml);
//		
//		
//		
//		
//		PreprocessConcordance pc = new PreprocessConcordance(statscommand);
//		
//		ConcordanceText txt = new ConcordanceText();
//		txt.FindFiles(corpusfilepath);
//		
//		txt.g
//		txt.readConcor();
//		distancematrix = txt.getNormalizedMatrix();
//		words = txt.getWords();
//		numberoftaxa = words.size();
//		
//		NeighborJoining nj = new NeighborJoining();
//		for(String s: words){
//			TreeNode n = new TreeNode();
//			n.setName(s);
//			n.setAsLeaf();
//			n.setID(words.indexOf(s));
//			nj.allnodes.add(n);
//		}
//		
//		newick = nj.computeNJTree(distancematrix, words);
//		
//		EqualAngle ea = new EqualAngle();
//		ea.doEqualAngle(nj.allnodes, numberoftaxa);
//		nodes = nj.allnodes;
	//}
	
//	public static void main(String [] args) throws IOException{
//		Tree t = new Tree("C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/English/test");
//		
//		t.computeTree();
//		
//		System.out.println(t.words);
//		System.out.println(t.numberoftaxa);
//	}
	
	

//}
