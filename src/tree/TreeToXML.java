package tree;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Export NJ-tree as XML;
 * with two possible tags: <tree> and <node>
 * @author Aleksandra Chashchina
 *
 */

public class TreeToXML {
	
	String newick;
	
	public TreeToXML(String n){
		this.newick = n;
	}
	
	
	/**
	 * Convert NJ-tree in newick format into XML
	 * @param filename absolute path to the XML file
	 * @throws IOException
	 */
	public void convertToXML(String filename) throws IOException{
		FileWriter fw = new FileWriter(filename);
		fw.write("<tree>\r\n");
		String n = newick.replaceAll(",", "\r\n");
		String s = n.replaceAll("\\:0\\.[0-9]+", " ");
		String z = s.replaceAll("\\(", "<node>\r\n");
		String f = z.replaceAll("\\)", "</node>\r\n");
		fw.write(f);
		fw.write("</tree>");
		fw.close();
		}
	
}

