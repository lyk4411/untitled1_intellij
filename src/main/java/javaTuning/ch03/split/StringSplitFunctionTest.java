package javaTuning.ch03.split;

import java.util.StringTokenizer;

import org.junit.Test;

public class StringSplitFunctionTest {

	@Test
	public void testSplit() {
		String str="a;b,c:d";
		String re[]="a;b,c:d".split("[;|,|:]");
		for(String s:re){
			System.out.println(s);
		}
	}

	
}
