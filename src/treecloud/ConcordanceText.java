package treecloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * This class is used to generate distance matrix from
 * Concordance HTML file
 * @author Aleksandra
 *
 */
public class ConcordanceText {
	final ArrayList<String> concordance = new ArrayList<String>();
	String concor;
	final String concorname = "concord.html";
	/**
	 * Search "concord.html" file in current GramLab project directory
	 * @param dir  path to current project directory
	 */
	public void FindFiles(String dir){   
		File f = new File(dir);
		for (File item : f.listFiles()){
			if (item.isFile()){
				if (item.getName().equals(concorname)){
					concor = item.getAbsolutePath();}
			}else{
					FindFiles(item.getAbsolutePath());
				}
			}
		}
	/**
	 * @return  absolute path to "concord.html"
	 */
    public String GetConcorPath(){
    	return this.concor;
    }
    /**
     * reads "concord.html" file, adds each line to an ArrayList,
     * removes HTML tags and punctuation from each line,
     * puts sepchar 'aaaaaaaaa' at the end of each line
     * 
     * @throws IOException
     */
    public void readConcor() throws IOException{ 
    	ArrayList<String> concorlist = new ArrayList<String>();
		FileReader concorfr = new FileReader(concor);
		concordance.clear();
		BufferedReader concorfrreader = new BufferedReader(concorfr);
		while (true){
			String line = concorfrreader.readLine();
			if (line == null) {
				break;}
			else if (line.startsWith("<tr>"))
			    concorlist.add(line);
			}
		concorfrreader.close();

	for (String line : concorlist) {
		String s = line.replaceAll("</td></tr>", "aaaaaaaaa ");
		String p = s.replaceAll("<a.+?>|</a>|&nbsp;|\\{S\\}|<tr><td nowrap>", " ");
		String z = p.replaceAll("[^a-zA-Z ]", "");
		z.trim();
		concordance.add(z);
	    }
	}
    
    /**
     * splits each line of concordance by whitespace
     * 
     * @param stringlist ArrayList of concordance lines
     * @return ArrayList of concordance words
     */
    private ArrayList<String> text(ArrayList<String> stringlist){
		   ArrayList<String> words = new ArrayList<String>();
		   
		   for(String line : stringlist){
			   for(String word : line.split("\\s+")){
				   if(!word.equals("")){      //while splitting empty words can occur
				  words.add(word.toLowerCase()); //issue: how will lower case work for other languages(and should we lower everything)
			   }}   
		   }
		   return words;
	   }
    /**
     * generates a map {word=number of occurrences in the concordance}
     * @param textwords
     * @return
     */
    
	   private Map<String, Integer> freqsDict(ArrayList<String> textwords){
		   Map<String, Integer> freqs = new HashMap<String, Integer>();
		   for(String word : textwords){
			   Integer value = freqs.get(word);
			   if (!freqs.containsKey(word)){
				   freqs.put(word, 1);
			   }else{
				   freqs.put(word, value + 1);}
			   }
		   return freqs;
	   }
    /**
     * generates a map {n1={word1=1,word2=1},n2={word3=1,word4=1}}
     * where n1, n2 are numbers of occurrences of the words in concordance
     * word1, word2 are words that occurred number1 times in concordance.
     * 
     * @param frequency map {word=number_of_occurrences}
     * @return a map
     */
    private Map<Integer, Map<String,Integer>> sortByFrequency(Map<String,Integer> frequencies){
		 
		   Map<Integer, Map<String,Integer>> sortedfreqs = new HashMap<Integer, Map<String,Integer>>();
		   ArrayList<String> words = new ArrayList<String>(frequencies.keySet());
		   Collections.sort(words);
		   for (String word : words){
			   Integer val = frequencies.get(word);
			   if (sortedfreqs.containsKey(val)){
				   sortedfreqs.get(val).put(word, 1);
			   }else{
				   Map<String, Integer> pair = new HashMap<String, Integer>();
				   pair.put(word , 1);
				   sortedfreqs.put(val, pair);
			   }}
		   return sortedfreqs;   
	   }
    /**
     * generates an array of three elements:
     * 1: a map with words from concordance as keys and unique IDs for each word as values
     * 2: an ArrayList of words from concordance; ID of the word is its
     *    index in this ArrayList
     * 3: an ArrayList of frequencies of the words from concordance; 
     *    ID of the word is index of its frequency in this ArrayList
     *    
     * @param freqsdict
     * @return
     */
    private Object [] wordList(Map<Integer, Map<String,Integer>>freqsdict, Map<String,Integer> frequencies){
		   Object[] theresult = new Object[3];
		   Map <String,Integer> wordsID = new HashMap<String,Integer>();
		   ArrayList<Integer> freqs = new ArrayList<Integer>(freqsdict.keySet());
		   Collections.sort(freqs , Collections.reverseOrder());
		  
		  int n = 0;
		  for (Integer i : freqs){
			   Map <String,Integer> pairs = freqsdict.get(i);
			   for (String s : pairs.keySet()){
				   wordsID.put(s, n);
				   n += 1;
			   }
		  }
		  int [] keptwordsfrequencies = new int[wordsID.size()];
		  String [] keptwords = new String[wordsID.size()]; 
		  for (String word : wordsID.keySet()){
			  keptwords[wordsID.get(word)] = word;
			  keptwordsfrequencies[wordsID.get(word)] = frequencies.get(word);
		  }
		  
		  theresult[0] = wordsID;
		  theresult[1] = keptwords;
		  theresult[2] = keptwordsfrequencies;
		return theresult;
		   
	   }
    /**
     * Computes cooccurrence of the words; word x and word y cooccurred if
     * they appeared in one line of the concordance.
     * @param keptWordsid
     * @param words
     * @return
     */
    public ArrayList<ArrayList<ArrayList<Integer>>> computeCooccurrenceDisjoint(Map <String, Integer>keptWordsid, ArrayList<String> words ){
 	   ArrayList<ArrayList<ArrayList<Integer>>> coocc = new ArrayList<ArrayList<ArrayList<Integer>>>(keptWordsid.size());     //use arrays instead of arraylist??
 	   ArrayList<Integer> freqwin = new ArrayList<Integer>(keptWordsid.size());
 	   int winnb = 0;
 	   int i = 0;
 	   
 	   while(i < keptWordsid.size()){
 		   ArrayList<ArrayList<Integer>> coocrow = new ArrayList<ArrayList<Integer>>(keptWordsid.size());
 		   freqwin.add(0);
 		   int j = 0;
 		   while(j < keptWordsid.size()){
 			   ArrayList<Integer> coocCase = new ArrayList<Integer>(4);
 			   coocCase.add(0);
 			   coocCase.add(0);
 			   coocCase.add(0);
 			   coocCase.add(0);
 			   coocrow.add(coocCase);
 			   j +=1;
 		   }
 		   coocc.add(coocrow);
 		   i += 1;
 	   }
 	   
 	   Map<String,Integer> window = new HashMap<String,Integer>();
 	   int ii = 0;
 	   while(ii < words.size()){
 		   if(!words.get(ii).equals("aaaaaaaaa")){
 			   if(!words.get(ii).equals("")){            //not necessary for proof-of-concept since we don't put off stopwords
 			   window.put(words.get(ii), 1);
 			   }
 			   }else{
 				   winnb += 1;
 				   ArrayList<String> windowWords = new ArrayList<String>(window.keySet());
 				   int jj = 0;
 				   while(jj < windowWords.size()){
 					   int k = jj + 1;
 					   int posj = keptWordsid.get(windowWords.get(jj));
 					   if(window.get(windowWords.get(jj))>0){
 						   freqwin.set(posj, freqwin.get(posj) + 1);
 					   }
 					   while(k < windowWords.size()){
 						   int posk = keptWordsid.get(windowWords.get(k));
 						   coocc.get(posj).get(posk).set(0, coocc.get(posj).get(posk).get(0) +1);
 						   coocc.get(posk).get(posj).set(0, coocc.get(posj).get(posk).get(0));
 						   k += 1;}
 					   jj += 1;}
 				   window.clear();
 					   }
 		   ii += 1;
 				   }
 	   if(!words.get(ii-1).equals("aaaaaaaaa")){
 		   winnb += 1;
 		   ArrayList<String> windowWords = new ArrayList<String>(window.keySet());
 		   int j = 0;
 		   while(j < windowWords.size()){
 			   int k = j + 1;
 			   int posj = keptWordsid.get(windowWords.get(j));
 			   if(window.get(windowWords.get(j))>0){
 				   freqwin.set(posj, freqwin.get(posj)+1);
 			   }
 			   while(k < windowWords.size()){
 				   int posk = keptWordsid.get(windowWords.get(k));
 				   coocc.get(posj).get(posk).set(0, coocc.get(posj).get(posk).get(0) + 1);
 				   coocc.get(posk).get(posj).set(0, coocc.get(posj).get(posk).get(0));
 				   k += 1;
 			   }
 			   j += 1;
 		   }
 	   }
 	   int j = 0;
 	   while(j < freqwin.size()){
 		   int k = 0;
 		   while(k < freqwin.size()){
 			   coocc.get(j).get(k).set(1, freqwin.get(j)-coocc.get(j).get(k).get(0));
 			   coocc.get(k).get(j).set(2, coocc.get(j).get(k).get(1));
 			   coocc.get(k).get(j).set(1, freqwin.get(k)-coocc.get(k).get(j).get(0));
 			   coocc.get(j).get(k).set(2, coocc.get(k).get(j).get(1));
 			   coocc.get(j).get(k).set(3, winnb-coocc.get(j).get(k).get(0)-coocc.get(j).get(k).get(1)-coocc.get(j).get(k).get(2));
 			   coocc.get(k).get(j).set(3, coocc.get(j).get(k).get(3));
 			   k += 1;
 		   }
 		   j += 1;
 	   }   
 	return coocc;
    }
    /**
     * computes distance matrix from cooccurrences using chisquared method
     * @param coocc
     * @return
     */
    public ArrayList<ArrayList<Double>> distanceFromCooccurrence(ArrayList<ArrayList<ArrayList<Integer>>> coocc){
		
		   ArrayList<ArrayList<Double>> distance = new ArrayList<ArrayList<Double>>();   //is it okay to use float instead of double?
		   
		   int j = 0;
		   while(j < coocc.get(0).size()){
			   int k = 0;
			   ArrayList<Double> distancerow = new ArrayList<Double>();
			   while(k < coocc.get(0).size()){
				   if(k == j){
					   distancerow.add((double) 0);
				   }else{
					   int O11 = coocc.get(j).get(k).get(0);
					   int O12 = coocc.get(j).get(k).get(1);
					   int O21 = coocc.get(j).get(k).get(2);
					   int O22 = coocc.get(j).get(k).get(3);
					   int R1 = O11+O12;
					   int R2 = O21+O22;
					   int C1 = O11+O21;
					   int C2 = O12+O22;
					   int N = R1+R2;
					   if(R1*R2*C1*C2 > 0){
						   distancerow.add(1000-(1.0*N*(O11*O22-O12*O21)*(O11*O22-O12*O21)/(R1*R2*C1*C2)));
					   }else{
						   distancerow.add((double) 0);
					   }
				   }
				   k += 1;
			   }
			   distance.add(distancerow);
			   j += 1;
		   }
		
		   return distance;
		   
	   }
    /**
     * normalizes distance matrix using linear method
     * 
     * @param mat
     * @return
     */
    public ArrayList<ArrayList<Double>> normalizeMatrix(ArrayList<ArrayList<Double>> mat){
		   double themax = 1;
		   double themin = mat.get(0).get(0);
		   for(int i=0; i < mat.get(0).size(); i++){
			   for(int j=0; j < mat.get(0).size(); j++){
				   themax = Math.max(themax, mat.get(i).get(j));
				   themin = Math.max(themin, mat.get(i).get(j));
			   }
		   }
		   for(int i=0; i < mat.get(0).size(); i++){
			   for(int j=0; j < mat.get(0).size(); j++){
				   mat.get(i).set(j, mat.get(i).get(j)/themax);
			   }
		   }
		   return mat; 
	   }
    
    public void saveMatrixToCSV(ArrayList<ArrayList<Double>> distmatrix, String [] words) throws IOException{
    	FileWriter w = new FileWriter("C:/distancematrix.csv");
    	int j = 0;
    	w.write(";");
    	for(String word : words){
    		w.write(word + "; ");
    	}
    	w.write("\r\n");
    	while(j<distmatrix.size()){
    		ArrayList<Double> row = distmatrix.get(j);
    		w.write(words[j] + "; ");
    		j += 1;
    		int i = 0;
    		while(i<row.size()){
    			w.write(row.get(i) + "; ");
    			i += 1;
    		}
    		w.write("\r\n");
    	}
    	w.close();
    }
    /*
     * Following methods are made to retrieve all stages 
     * of concordance-to-matrix processing
     * without passing necessary arguments
     */
    public ArrayList<String> getText() {
		   return this.text(concordance);}
		
	   public Map<String, Integer> getFrequencies(){
		   return this.freqsDict(this.text(concordance));}
	   
	   public Map<Integer, Map<String, Integer>> getSortedByFreqs(){
		   return this.sortByFrequency(this.freqsDict(this.text(concordance)));}
	   
	   public Map<String, Integer> getWordID(){
		   Object [] ob = this.wordList(this.sortByFrequency(this.freqsDict(this.text(concordance))), this.freqsDict(this.text(concordance)));
		   Map<String, Integer> ids = (Map<String, Integer>) ob[0];
		   return ids;}
	   
	   public Object[] getWordList(){
		   return this.wordList(this.sortByFrequency(this.freqsDict(this.text(concordance))), this.freqsDict(this.text(concordance)));}
	   
	   public ArrayList<String> getWords(){
		   Object [] ob = this.wordList(this.sortByFrequency(this.freqsDict(this.text(concordance))), this.freqsDict(this.text(concordance)));
		   String [] w = (String []) ob[1];
		   ArrayList<String> taxa = new ArrayList<String>(Arrays.asList(w));
		   return taxa;
	   }
	   
	   public ArrayList<ArrayList<ArrayList<Integer>>> getCooccurence(){
		   Object [] ob = this.wordList(this.sortByFrequency(this.freqsDict(this.text(concordance))), this.freqsDict(this.text(concordance)));
		   Map<String, Integer> ids = (Map<String, Integer>) ob[0];
		   return this.computeCooccurrenceDisjoint(ids, this.text(concordance));}
	   
	   public ArrayList<ArrayList<Double>> getDistance(){
		   Object [] ob = this.wordList(this.sortByFrequency(this.freqsDict(this.text(concordance))), this.freqsDict(this.text(concordance)));
		   Map<String, Integer> ids = (Map<String, Integer>) ob[0];
		   return this.distanceFromCooccurrence(this.computeCooccurrenceDisjoint(ids, this.text(concordance)));}
	   
	   public ArrayList<ArrayList<Double>> getNormalizedMatrix(){
		   Object [] ob = this.wordList(this.sortByFrequency(this.freqsDict(this.text(concordance))), this.freqsDict(this.text(concordance)));
		   Map<String, Integer> ids = (Map<String, Integer>) ob[0];
		   return this.normalizeMatrix(this.distanceFromCooccurrence(this.computeCooccurrenceDisjoint(ids, this.text(concordance))));}
	   
}


