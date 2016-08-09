package tree;

import java.util.ArrayList;

import treecloud.NeighborJoining;

/**
 * This class contains data for testing EqualAngle algorithm
 * Includes 4 different distance matrices
 * @author Aleksandra Chashchina
 *
 */

public class TestData {
	
	public static String getTestPath(){
		//return "C:/Users/SONY/Desktop/GSoC/unitex_proposal/bush_snt";
		return "C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/English/test2/src/Corpus";
	}
	
	public static String getTestUnitexToolPath(){
		return "C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/App/UnitexToolLogger.exe";
	}
	public static String getTestIndPath(){
		return "C:/Users/SONY/Desktop/GSoC/unitex_proposal/bush_snt/concord.ind";
		//return "C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/English/test/src/Corpus/ivanhoe_snt/concord.ind";
	}
	
	public static String getTestAlphabetPath(){
		return "C:/Users/SONY/Desktop/Unitex-GramLab-3.1rc-source-distribution/Unitex-GramLab-3.1rc/English/test/src/Alphabet.txt";
	}
	
	public static String getTestLanguage(){
		return "English";
	}
	
	public static int getTestNbOccur(){
		return 0;
	}
	
	public static boolean getTestRemoveStopWords(){
		return false;
	}
	
	public static int getTestNbWords(){
		return 0;
	}
	/**
	 * Get number of leaves in the first tree test
	 * @return int
	 */
	
	public int getNtaxaFirst(){
		return 5;
	}
	
	/**
	 * Get number of leaves in the second tree test
	 * @return int
	 */
	
	public int getNtaxaSecond(){
		return 6;
	}
	
	/**
	 * Get number of leaves in the third tree test
	 * @return int
	 */
	
	public int getNtaxaThird(){
		return 4;
	}
	
	/**
	 * Get number of leaves in the fourth tree test
	 * @return int
	 */
	
	public int getNtaxaFourth(){
		return 30;
	}
	
	/**
	 * Get list of nodes of the first tree test after performing NJ-algorithm
	 * @return list of nodes
	 */
	
	public ArrayList<TreeNode> getFirstTest(){
		
		ArrayList<ArrayList<Double>> mm = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> a = new ArrayList<Double>();
		a.add(0.0);
		a.add(5.0);
		a.add(9.0);
		a.add(9.0);
		a.add(8.0);
		mm.add(a);
		
		ArrayList<Double> b = new ArrayList<Double>();
		b.add(5.0);
		b.add(0.0);
		b.add(10.0);
		b.add(10.0);
		b.add(9.0);
		mm.add(b);
		
		ArrayList<Double> c = new ArrayList<Double>();
		c.add(9.0);
		c.add(10.0);
		c.add(0.0);
		c.add(8.0);
		c.add(7.0);
		mm.add(c);
		
		ArrayList<Double> d = new ArrayList<Double>();
		d.add(9.0);
		d.add(10.0);
		d.add(8.0);
		d.add(0.0);
		d.add(3.0);
		mm.add(d);
		
		ArrayList<Double> e = new ArrayList<Double>();
		e.add(8.0);
		e.add(9.0);
		e.add(7.0);
		e.add(3.0);
		e.add(0.0);
		mm.add(e);
		
	ArrayList<String> names = new ArrayList<String>();
	names.add("a");
	names.add("b");
	names.add("c");
	names.add("d");
	names.add("e");
	
	//NeighborJoining nj = new NeighborJoining();
	
//	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
	for(String s: names){
		TreeNode n = new TreeNode();
		n.setName(s);
		n.setAsLeaf();
		n.setID(names.indexOf(s));
		//nj.allnodes.add(n);
	}
	//nj.computeNJTree(mm, names);
	//return nj.allnodes;
//	return res;
	return null;
	}
	
	/**
	 * Get list of nodes of the second tree test after performing NJ-algorithm
	 * @return list of nodes
	 */
	
	public ArrayList<TreeNode> getSecondTest(){
		
ArrayList<ArrayList<Double>> dm2 = new ArrayList<ArrayList<Double>>();
		
		ArrayList<Double> aa2 = new ArrayList<Double>();
		aa2.add(0.0);
		aa2.add(184.0);
		aa2.add(222.0);
		aa2.add(177.0);
		aa2.add(216.0);
		aa2.add(231.0);
		dm2.add(aa2);
		
		ArrayList<Double> b2 = new ArrayList<Double>();
		b2.add(184.0);
		b2.add(0.0);
		b2.add(45.0);
		b2.add(123.0);
		b2.add(128.0);
		b2.add(200.0);
		dm2.add(b2);
		
		ArrayList<Double> c2 = new ArrayList<Double>();
		c2.add(222.0);
		c2.add(45.0);
		c2.add(0.0);
		c2.add(129.0);
		c2.add(121.0);
		c2.add(203.0);
		dm2.add(c2);
		
		ArrayList<Double> d2 = new ArrayList<Double>();
		d2.add(177.0);
		d2.add(123.0);
		d2.add(129.0);
		d2.add(0.0);
		d2.add(46.0);
		d2.add(83.0);
		dm2.add(d2);
		
		ArrayList<Double> e2 = new ArrayList<Double>();
		e2.add(216.0);
		e2.add(128.0);
		e2.add(121.0);
		e2.add(46.0);
		e2.add(0.0);
		e2.add(83.0);
		dm2.add(e2);
		
		ArrayList<Double> f2 = new ArrayList<Double>();
		f2.add(231.0);
		f2.add(200.0);
		f2.add(203.0);
		f2.add(83.0);
		f2.add(83.0);
		f2.add(0.0);
		dm2.add(f2);
		
		ArrayList<String> taxanames2 = new ArrayList<String>();
		taxanames2.add("a");
		taxanames2.add("b");
		taxanames2.add("c");
		taxanames2.add("d");
		taxanames2.add("e");
		taxanames2.add("f");
		
		//NeighborJoining nj = new NeighborJoining();
		
		for(String s: taxanames2){
			TreeNode n = new TreeNode();
			n.setName(s);
			n.setAsLeaf();
			n.setID(taxanames2.indexOf(s));
			//nj.allnodes.add(n);
		}
		//nj.computeNJTree(dm2, taxanames2);
		//return nj.allnodes;
		return null;
		}
	
	/**
	 * Get list of nodes of the third tree test after performing NJ-algorithm
	 * @return list of nodes
	 */
	
	public ArrayList<TreeNode> getThirdTest(){
		
		ArrayList<ArrayList<Double>> dm3 = new ArrayList<ArrayList<Double>>();
		
		ArrayList<Double> aa3 = new ArrayList<Double>();
		aa3.add(0.0);
		aa3.add(6.0);
		aa3.add(7.0);
		aa3.add(14.0);
		dm3.add(aa3);
		
		ArrayList<Double> b3 = new ArrayList<Double>();
		b3.add(6.0);
		b3.add(0.0);
		b3.add(3.0);
		b3.add(10.0);
		dm3.add(b3);
		
		ArrayList<Double> c3 = new ArrayList<Double>();
		c3.add(7.0);
		c3.add(3.0);
		c3.add(0.0);
		c3.add(9.0);
		dm3.add(c3);
		
		ArrayList<Double> d3 = new ArrayList<Double>();
		d3.add(14.0);
		d3.add(10.0);
		d3.add(9.0);
		d3.add(0.0);
		dm3.add(d3);
		
		ArrayList<String> taxanames3 = new ArrayList<String>();
		taxanames3.add("a");
		taxanames3.add("b");
		taxanames3.add("c");
		taxanames3.add("d");
		
		//NeighborJoining nj = new NeighborJoining();
		
		for(String s: taxanames3){
			TreeNode n = new TreeNode();
			n.setName(s);
			n.setAsLeaf();
			n.setID(taxanames3.indexOf(s));
			//nj.allnodes.add(n);
		}
		
		//nj.computeNJTree(dm3, taxanames3);
		//return nj.allnodes;
		return null;
		}
	
	/**
	 * Get list of nodes of the fourth tree test after performing NJ-algorithm
	 * @return list of nodes
	 */
	
	public ArrayList<TreeNode> getFourthTest(){
		
		ArrayList<ArrayList<Double>> m = new ArrayList<ArrayList<Double>>();
		ArrayList<Double>a0=new ArrayList<Double>();
		a0.add(0.0);
		a0.add(0.6047026);
		a0.add(0.61180866);
		a0.add(0.6202567);
		a0.add(0.65002716);
		a0.add(0.6449196);
		a0.add(0.62335384);
		a0.add(0.639802);
		a0.add(0.66953695);
		a0.add(0.6878638);
		a0.add(0.64485717);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.8726263);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.8999413);
		a0.add(0.6541064);
		a0.add(0.98188627);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		a0.add(0.6541064);
		m.add(a0);
		ArrayList<Double>a1=new ArrayList<Double>();
		a1.add(0.6047026);
		a1.add(0.0);
		a1.add(0.7252028);
		a1.add(0.8596782);
		a1.add(0.8210499);
		a1.add(0.82763433);
		a1.add(0.8556299);
		a1.add(0.30567276);
		a1.add(0.57643944);
		a1.add(0.8556299);
		a1.add(0.6542601);
		a1.add(0.3558715);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.68702227);
		a1.add(0.8158031);
		a1.add(0.57663864);
		a1.add(0.8158031);
		a1.add(0.5030496);
		a1.add(0.57663864);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.8158031);
		a1.add(0.72381675);
		a1.add(0.8158031);
		m.add(a1);
		ArrayList<Double>a2=new ArrayList<Double>();
		a2.add(0.61180866);
		a2.add(0.7252028);
		a2.add(0.0);
		a2.add(0.8750663);
		a2.add(0.50500774);
		a2.add(0.8411412);
		a2.add(0.8707763);
		a2.add(0.8481379);
		a2.add(0.47783065);
		a2.add(0.58220327);
		a2.add(0.7144659);
		a2.add(0.5611002);
		a2.add(0.828633);
		a2.add(0.792962);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.5432647);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.828633);
		a2.add(0.77512646);
		a2.add(0.48975807);
		a2.add(0.68594885);
		m.add(a2);
		ArrayList<Double>a3=new ArrayList<Double>();
		a3.add(0.6202567);
		a3.add(0.8596782);
		a3.add(0.8750663);
		a3.add(0.0);
		a3.add(0.76868457);
		a3.add(0.6268877);
		a3.add(0.56463456);
		a3.add(0.8170779);
		a3.add(0.81092);
		a3.add(0.49655387);
		a3.add(0.74164444);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.605618);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.43076786);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.7998959);
		a3.add(0.45019567);
		a3.add(0.46962345);
		a3.add(0.43076786);
		a3.add(0.508479);
		a3.add(0.7998959);
		a3.add(0.605618);
		m.add(a3);
		ArrayList<Double>a4=new ArrayList<Double>();
		a4.add(0.65002716);
		a4.add(0.8210499);
		a4.add(0.50500774);
		a4.add(0.76868457);
		a4.add(0.0);
		a4.add(0.7790568);
		a4.add(0.8015514);
		a4.add(0.7843903);
		a4.add(0.7790568);
		a4.add(0.32517254);
		a4.add(0.8015514);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.43161425);
		a4.add(0.769489);
		a4.add(0.769489);
		a4.add(0.3592125);
		a4.add(0.769489);
		a4.add(0.23854294);
		m.add(a4);
		ArrayList<Double>a5=new ArrayList<Double>();
		a5.add(0.6449196);
		a5.add(0.82763433);
		a5.add(0.8411412);
		a5.add(0.6268877);
		a5.add(0.7790568);
		a5.add(0.0);
		a5.add(0.4505632);
		a5.add(0.7899834);
		a5.add(0.78451264);
		a5.add(0.8075977);
		a5.add(0.8075977);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.7747025);
		a5.add(0.2271835);
		a5.add(0.27281007);
		a5.add(0.7747025);
		a5.add(0.5465696);
		a5.add(0.7747025);
		m.add(a5);
		ArrayList<Double>a6=new ArrayList<Double>();
		a6.add(0.62335384);
		a6.add(0.8556299);
		a6.add(0.8707763);
		a6.add(0.56463456);
		a6.add(0.8015514);
		a6.add(0.4505632);
		a6.add(0.0);
		a6.add(0.81366694);
		a6.add(0.8075977);
		a6.add(0.8332545);
		a6.add(0.8332545);
		a6.add(0.7967302);
		a6.add(0.7967302);
		a6.add(0.7967302);
		a6.add(0.777031);
		a6.add(0.24515197);
		a6.add(0.7967302);
		a6.add(0.50124186);
		a6.add(0.7967302);
		a6.add(0.7967302);
		a6.add(0.7967302);
		a6.add(0.777031);
		a6.add(0.7967302);
		a6.add(0.6785349);
		a6.add(0.69823414);
		a6.add(0.26485118);
		a6.add(0.22545275);
		a6.add(0.7573318);
		a6.add(0.7967302);
		a6.add(0.7967302);
		m.add(a6);
		ArrayList<Double>a7=new ArrayList<Double>();
		a7.add(0.639802);
		a7.add(0.30567276);
		a7.add(0.8481379);
		a7.add(0.8170779);
		a7.add(0.7843903);
		a7.add(0.7899834);
		a7.add(0.81366694);
		a7.add(0.0);
		a7.add(0.7899834);
		a7.add(0.81366694);
		a7.add(0.74972844);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.45298338);
		a7.add(0.77992743);
		a7.add(0.75813115);
		a7.add(0.77992743);
		a7.add(0.23502068);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		a7.add(0.77992743);
		m.add(a7);
		ArrayList<Double>a8=new ArrayList<Double>();
		a8.add(0.66953695);
		a8.add(0.57643944);
		a8.add(0.47783065);
		a8.add(0.81092);
		a8.add(0.7790568);
		a8.add(0.78451264);
		a8.add(0.8075977);
		a8.add(0.7899834);
		a8.add(0.0);
		a8.add(0.8075977);
		a8.add(0.7225895);
		a8.add(0.29562336);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.09030376);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		a8.add(0.7747025);
		m.add(a8);
		ArrayList<Double>a9=new ArrayList<Double>();
		a9.add(0.6878638);
		a9.add(0.8556299);
		a9.add(0.58220327);
		a9.add(0.49655387);
		a9.add(0.32517254);
		a9.add(0.8075977);
		a9.add(0.8332545);
		a9.add(0.81366694);
		a9.add(0.8075977);
		a9.add(0.0);
		a9.add(0.8054794);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.69823414);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.32394886);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.6785349);
		a9.add(0.7967302);
		a9.add(0.7967302);
		a9.add(0.6194372);
		a9.add(0.7967302);
		a9.add(0.52094114);
		m.add(a9);
		ArrayList<Double>a10=new ArrayList<Double>();
		a10.add(0.64485717);
		a10.add(0.6542601);
		a10.add(0.7144659);
		a10.add(0.74164444);
		a10.add(0.8015514);
		a10.add(0.8075977);
		a10.add(0.8332545);
		a10.add(0.74972844);
		a10.add(0.7225895);
		a10.add(0.8054794);
		a10.add(0.0);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.422445);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.26485118);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.50124186);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		a10.add(0.7967302);
		m.add(a10);
		ArrayList<Double>a11=new ArrayList<Double>();
		a11.add(0.6541064);
		a11.add(0.3558715);
		a11.add(0.5611002);
		a11.add(0.7998959);
		a11.add(0.769489);
		a11.add(0.7747025);
		a11.add(0.7967302);
		a11.add(0.77992743);
		a11.add(0.29562336);
		a11.add(0.7967302);
		a11.add(0.7967302);
		a11.add(0.0);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.30613047);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		a11.add(0.7653262);
		m.add(a11);
		ArrayList<Double>a12=new ArrayList<Double>();
		a12.add(0.6541064);
		a12.add(0.8158031);
		a12.add(0.828633);
		a12.add(0.7998959);
		a12.add(0.769489);
		a12.add(0.7747025);
		a12.add(0.7967302);
		a12.add(0.77992743);
		a12.add(0.7747025);
		a12.add(0.7967302);
		a12.add(0.7967302);
		a12.add(0.7653262);
		a12.add(0.0);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.48470658);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.12755436);
		a12.add(0.7653262);
		a12.add(0.2551087);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		a12.add(0.7653262);
		m.add(a12);
		ArrayList<Double>a13=new ArrayList<Double>();
		a13.add(0.8726263);
		a13.add(0.8158031);
		a13.add(0.792962);
		a13.add(0.7998959);
		a13.add(0.769489);
		a13.add(0.7747025);
		a13.add(0.7967302);
		a13.add(0.77992743);
		a13.add(0.7747025);
		a13.add(0.7967302);
		a13.add(0.422445);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.0);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.102043495);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		a13.add(0.7653262);
		m.add(a13);
		ArrayList<Double>a14=new ArrayList<Double>();
		a14.add(0.6541064);
		a14.add(0.68702227);
		a14.add(0.828633);
		a14.add(0.7998959);
		a14.add(0.769489);
		a14.add(0.7747025);
		a14.add(0.777031);
		a14.add(0.45298338);
		a14.add(0.7747025);
		a14.add(0.7967302);
		a14.add(0.7967302);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.0);
		a14.add(0.68879354);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.2551087);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		a14.add(0.7653262);
		m.add(a14);
		ArrayList<Double>a15=new ArrayList<Double>();
		a15.add(0.6541064);
		a15.add(0.8158031);
		a15.add(0.828633);
		a15.add(0.7998959);
		a15.add(0.769489);
		a15.add(0.7747025);
		a15.add(0.24515197);
		a15.add(0.77992743);
		a15.add(0.7747025);
		a15.add(0.7967302);
		a15.add(0.7967302);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.68879354);
		a15.add(0.0);
		a15.add(0.7653262);
		a15.add(0.43368483);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.6632827);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		a15.add(0.7653262);
		m.add(a15);
		ArrayList<Double>a16=new ArrayList<Double>();
		a16.add(0.6541064);
		a16.add(0.57663864);
		a16.add(0.828633);
		a16.add(0.605618);
		a16.add(0.769489);
		a16.add(0.7747025);
		a16.add(0.7967302);
		a16.add(0.75813115);
		a16.add(0.7747025);
		a16.add(0.69823414);
		a16.add(0.26485118);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.0);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		a16.add(0.7653262);
		m.add(a16);
		ArrayList<Double>a17=new ArrayList<Double>();
		a17.add(0.6541064);
		a17.add(0.8158031);
		a17.add(0.828633);
		a17.add(0.7998959);
		a17.add(0.769489);
		a17.add(0.7747025);
		a17.add(0.50124186);
		a17.add(0.77992743);
		a17.add(0.7747025);
		a17.add(0.7967302);
		a17.add(0.7967302);
		a17.add(0.7653262);
		a17.add(0.48470658);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.43368483);
		a17.add(0.7653262);
		a17.add(0.0);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.35715222);
		a17.add(0.7653262);
		a17.add(0.22959785);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.7653262);
		a17.add(0.7653262);
		m.add(a17);
		ArrayList<Double>a18=new ArrayList<Double>();
		a18.add(0.6541064);
		a18.add(0.5030496);
		a18.add(0.828633);
		a18.add(0.7998959);
		a18.add(0.769489);
		a18.add(0.7747025);
		a18.add(0.7967302);
		a18.add(0.23502068);
		a18.add(0.7747025);
		a18.add(0.7967302);
		a18.add(0.7967302);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.2551087);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.0);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		a18.add(0.7653262);
		m.add(a18);
		ArrayList<Double>a19=new ArrayList<Double>();
		a19.add(0.6541064);
		a19.add(0.57663864);
		a19.add(0.5432647);
		a19.add(0.7998959);
		a19.add(0.769489);
		a19.add(0.7747025);
		a19.add(0.7967302);
		a19.add(0.77992743);
		a19.add(0.09030376);
		a19.add(0.7967302);
		a19.add(0.7967302);
		a19.add(0.30613047);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.0);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		a19.add(0.7653262);
		m.add(a19);
		ArrayList<Double>a20=new ArrayList<Double>();
		a20.add(0.8999413);
		a20.add(0.8158031);
		a20.add(0.828633);
		a20.add(0.43076786);
		a20.add(0.769489);
		a20.add(0.7747025);
		a20.add(0.7967302);
		a20.add(0.77992743);
		a20.add(0.7747025);
		a20.add(0.32394886);
		a20.add(0.7967302);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.0);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		a20.add(0.7653262);
		m.add(a20);
		ArrayList<Double>a21=new ArrayList<Double>();
		a21.add(0.6541064);
		a21.add(0.8158031);
		a21.add(0.828633);
		a21.add(0.7998959);
		a21.add(0.769489);
		a21.add(0.7747025);
		a21.add(0.777031);
		a21.add(0.77992743);
		a21.add(0.7747025);
		a21.add(0.7967302);
		a21.add(0.7967302);
		a21.add(0.7653262);
		a21.add(0.12755436);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.35715222);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.0);
		a21.add(0.7653262);
		a21.add(0.12755436);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		a21.add(0.7653262);
		m.add(a21);
		ArrayList<Double>a22=new ArrayList<Double>();
		a22.add(0.98188627);
		a22.add(0.8158031);
		a22.add(0.828633);
		a22.add(0.7998959);
		a22.add(0.769489);
		a22.add(0.7747025);
		a22.add(0.7967302);
		a22.add(0.77992743);
		a22.add(0.7747025);
		a22.add(0.7967302);
		a22.add(0.50124186);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.102043495);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.0);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		a22.add(0.7653262);
		m.add(a22);
		ArrayList<Double>a23=new ArrayList<Double>();
		a23.add(0.6541064);
		a23.add(0.8158031);
		a23.add(0.828633);
		a23.add(0.7998959);
		a23.add(0.769489);
		a23.add(0.7747025);
		a23.add(0.6785349);
		a23.add(0.77992743);
		a23.add(0.7747025);
		a23.add(0.7967302);
		a23.add(0.7967302);
		a23.add(0.7653262);
		a23.add(0.2551087);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.6632827);
		a23.add(0.7653262);
		a23.add(0.22959785);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.12755436);
		a23.add(0.7653262);
		a23.add(0.0);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.7653262);
		a23.add(0.7653262);
		m.add(a23);
		ArrayList<Double>a24=new ArrayList<Double>();
		a24.add(0.6541064);
		a24.add(0.8158031);
		a24.add(0.828633);
		a24.add(0.45019567);
		a24.add(0.43161425);
		a24.add(0.7747025);
		a24.add(0.69823414);
		a24.add(0.77992743);
		a24.add(0.7747025);
		a24.add(0.6785349);
		a24.add(0.7967302);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.7653262);
		a24.add(0.0);
		a24.add(0.71430445);
		a24.add(0.6632827);
		a24.add(0.07653262);
		a24.add(0.7653262);
		a24.add(0.20408699);
		m.add(a24);
		ArrayList<Double>a25=new ArrayList<Double>();
		a25.add(0.6541064);
		a25.add(0.8158031);
		a25.add(0.828633);
		a25.add(0.46962345);
		a25.add(0.769489);
		a25.add(0.2271835);
		a25.add(0.26485118);
		a25.add(0.77992743);
		a25.add(0.7747025);
		a25.add(0.7967302);
		a25.add(0.7967302);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.71430445);
		a25.add(0.0);
		a25.add(0.051021747);
		a25.add(0.7653262);
		a25.add(0.7653262);
		a25.add(0.7653262);
		m.add(a25);
		ArrayList<Double>a26=new ArrayList<Double>();
		a26.add(0.6541064);
		a26.add(0.8158031);
		a26.add(0.828633);
		a26.add(0.43076786);
		a26.add(0.769489);
		a26.add(0.27281007);
		a26.add(0.22545275);
		a26.add(0.77992743);
		a26.add(0.7747025);
		a26.add(0.7967302);
		a26.add(0.7967302);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.7653262);
		a26.add(0.6632827);
		a26.add(0.051021747);
		a26.add(0.0);
		a26.add(0.7398153);
		a26.add(0.7653262);
		a26.add(0.7653262);
		m.add(a26);
		ArrayList<Double>a27=new ArrayList<Double>();
		a27.add(0.6541064);
		a27.add(0.8158031);
		a27.add(0.77512646);
		a27.add(0.508479);
		a27.add(0.3592125);
		a27.add(0.7747025);
		a27.add(0.7573318);
		a27.add(0.77992743);
		a27.add(0.7747025);
		a27.add(0.6194372);
		a27.add(0.7967302);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.7653262);
		a27.add(0.07653262);
		a27.add(0.7653262);
		a27.add(0.7398153);
		a27.add(0.0);
		a27.add(0.7653262);
		a27.add(0.12755436);
		m.add(a27);
		ArrayList<Double>a28=new ArrayList<Double>();
		a28.add(0.6541064);
		a28.add(0.72381675);
		a28.add(0.48975807);
		a28.add(0.7998959);
		a28.add(0.769489);
		a28.add(0.5465696);
		a28.add(0.7967302);
		a28.add(0.77992743);
		a28.add(0.7747025);
		a28.add(0.7967302);
		a28.add(0.7967302);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.7653262);
		a28.add(0.0);
		a28.add(0.7653262);
		m.add(a28);
		ArrayList<Double>a29=new ArrayList<Double>();
		a29.add(0.6541064);
		a29.add(0.8158031);
		a29.add(0.68594885);
		a29.add(0.605618);
		a29.add(0.23854294);
		a29.add(0.7747025);
		a29.add(0.7967302);
		a29.add(0.77992743);
		a29.add(0.7747025);
		a29.add(0.52094114);
		a29.add(0.7967302);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.20408699);
		a29.add(0.7653262);
		a29.add(0.7653262);
		a29.add(0.12755436);
		a29.add(0.7653262);
		a29.add(0.0);
		m.add(a29);
		
		ArrayList<String> taxas = new ArrayList<String>();
		taxas.add("nation");
		taxas.add("people");
		taxas.add("freedom");
		taxas.add("war");
		taxas.add("single");
		taxas.add("impact");
		taxas.add("god");
		taxas.add("state");
		taxas.add("choice");
		taxas.add("response");
		taxas.add("institutions");
		taxas.add("emerging");
		taxas.add("mission");
		taxas.add("ending");
		taxas.add("discipline");
		taxas.add("chosen");
		taxas.add("finally");
		taxas.add("women");
		taxas.add("means");
		taxas.add("ruler");
		taxas.add("patriot");
		taxas.add("fancying");
		taxas.add("world");
		taxas.add("lost");
		taxas.add("calling");
		taxas.add("bless");
		taxas.add("continue");
		taxas.add("security");
		taxas.add("liberating");
		taxas.add("requirement");
		
		//NeighborJoining nj = new NeighborJoining();
		
		for(String s: taxas){
			TreeNode n = new TreeNode();
			n.setName(s);
			n.setAsLeaf();
			n.setID(taxas.indexOf(s));
			//nj.allnodes.add(n);
		}
		//nj.computeNJTree(m, taxas);
		//return nj.allnodes;
		return null;
	}
	
}


