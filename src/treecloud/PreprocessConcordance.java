package treecloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreprocessConcordance {
	
	/*
	 * TODO: remove hard code
	 */
	
	
	String [] cmd = {"\"C:/Users/SONY/AppData/Local/Unitex-GramLab/App/UnitexToolLogger.exe\"" , 
				"\"Stats\"" , "\"C:/Users/SONY/Documents/Unitex-GramLab/Unitex/English/Corpus/ivanhoe_snt/concord.ind\"" ,
				"\"-aC:/Users/SONY/Documents/Unitex-GramLab/Unitex/English/Alphabet.txt\"",
				"\"-l10\"", "\"-r10\"" , "\"-oC:/Users/SONY/Desktop/statistics.txt\"" , 
				"\"-c1\"", "\"-m1\"", "\"-qutf8-no-bom\""};
	
    public String getLocateTarget(String concorfilepath) throws IOException{
        ArrayList<String> concorlist = new ArrayList<String>();
    	
		FileReader concorfr = new FileReader(concorfilepath);
		BufferedReader concorfrreader = new BufferedReader(concorfr);
		while (true){
			String line = concorfrreader.readLine();
			if (line == null) {
				break;
			}else if (line.startsWith("<tr>")){
			    concorlist.add(line);}
			}
		concorfrreader.close();
		
		String tmp = concorlist.get(0);
		Pattern pat = Pattern.compile("<a.+?>([a-zA-Z]+?)</a>");
		Matcher m = pat.matcher(tmp);
		if(m.find()){
			return m.group(1);
		}else{
			return null;
		}
    }
    
    
	public ArrayList<String> readStats(String statsfile, String [] commands) throws IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec(commands);
		p.waitFor();
		
		FileReader fr = new FileReader(statsfile);
		BufferedReader sr = new BufferedReader(fr);
		
		ArrayList<String> stats = new ArrayList<String>();
		
		ArrayList<String> words = new ArrayList<String>();
		while(true){
			String line = sr.readLine();
			if(line==null){
				break;
			}else{
				stats.add(line);
			}
		}
		sr.close();

		for(String s : stats){
			String [] two = s.split("\\s+");
			
			if(!two[0].matches("[^a-zA-Z ]|[^0-9]")){
				words.add(two[0].toLowerCase());
			}
			
			}
		return words;
	}
		
		
	public static String getStopWordsFile(String workinglanguage){
		
		if(workinglanguage.equals("English") | workinglanguage.equals("French")){
			return "C:/stopwords/StoplistEnglishFrench.txt";
			
		}else if(workinglanguage.equals("German")){
			return "C:/stopwords/StoplistGerman.txt";
		
		}else if(workinglanguage.equals("Portuguese")){
			return "C:/stopwords/StoplistPortuguese.txt";
		
		}else if(workinglanguage.equals("Italian")){
			return "C:/stopwords/StoplistItalian.txt";
			
		}else if(workinglanguage.equals("Spanish")){
			return "C:/stopwords/StoplistSpanish.txt";
		}else{
			System.out.println("Stoplist not available");
			return null;
		}
		
	}
	
	public void removeStopWords(ArrayList<String> words, String language) throws IOException{
		
		//ArrayList<String> cleanedwords = new ArrayList<String>();
		ArrayList<String> stopwords = new ArrayList<String>();
		
		FileReader fr = new FileReader(getStopWordsFile(language));
		BufferedReader bfr = new BufferedReader(fr);
		
		while(true){
			String line = bfr.readLine();
			if(line==null){
				break;
			}else{
				stopwords.add(line);
			}
		}
		bfr.close();
		
		for(String word: stopwords){
			if(words.contains(word)){
				words.remove(word);
			}
		}
		
		//return cleanedwords;
	}
	
	public ArrayList<String> getWordsFreqs(String statsfile, int minfreq) throws IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec(cmd);
		p.waitFor();
		
		FileReader fr = new FileReader(statsfile);
		BufferedReader sr = new BufferedReader(fr);
		
		ArrayList<String> stats = new ArrayList<String>();
		
		Map<String,Integer> wordsfreqs = new HashMap<String,Integer>();
		//wordsfreqs.put("nation", 19);
		
		while(true){
			String line = sr.readLine();
			if(line==null){
				break;
			}else{
				stats.add(line);
			}
		}
		sr.close();

		for(String s : stats){
			String [] two = s.split("\\s+");
			
			if(!two[0].matches("[^a-zA-Z ]|[^0-9]")){
				wordsfreqs.put(two[0].toLowerCase(), Integer.parseInt(two[1]));
			}
			
		}
        ArrayList<String> finalwords = new ArrayList<String>();
		
		for(String word : wordsfreqs.keySet()){
			
			if(wordsfreqs.get(word)>=minfreq){
				finalwords.add(word);
			}
		}
		
		return finalwords;
	}
	
	public ArrayList<String> getWordsNumber(ArrayList<String> cleanedwords, int number){
		
		ArrayList<String> finalwords = new ArrayList<String>();
		
		for(int i=0; i<number; i++){
			finalwords.add(cleanedwords.get(i));
		}
		
		return finalwords;
	}
	
	public ArrayList<String> getWordsMinFreq(Map<String,Integer> wordsfreq, int minfreq){
		
		ArrayList<String> finalwords = new ArrayList<String>();
		
		for(String word : wordsfreq.keySet()){
			
			if(wordsfreq.get(word)>=minfreq){
				finalwords.add(word);
			}
		}
		
		return finalwords;
	}		
}

