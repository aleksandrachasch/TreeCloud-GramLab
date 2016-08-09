package tree;

import java.io.IOException;


/**
 * Main class of the TreeCloud plugin
 * (currently works only on trees from TestData)
 * @author Aleksandra Chashchina
 *
 */

public class Main {
	
	public static void main(String [] args) throws IOException, InterruptedException{
		
		Tree t = new Tree();
		t.setCorpusPath(TestData.getTestPath());
		t.findFiles(t.corpuspath);
		t.setStatsOutput(t.concordhtml);
		t.removestopwords = true;
		t.setLanguage(TestData.getTestLanguage());
		t.setAlphabetPath(TestData.getTestAlphabetPath());
		//t.setMinNbOccur(1);
		t.setNumberOfTaxa(30);
		t.setUnitexToolLoggerPath(TestData.getTestUnitexToolPath());
		t.setStatsCommand();
		t.colormode = "target";
		
		t.setDistanceMatrix();
		System.out.println(t.numberoftaxa);
		t.performNJ();
		t.performEqualAngle();
		
		t.drawTree();
	}

}
