/**
 *
 */
package ir.jnf.maven.libs.Kernel.util;

import java.io.Serializable;

/**
 * @author eae966
 *
 */
public class JNFCharUtil implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 3096673421546719924L;

	/**
	 *
	 */
	public JNFCharUtil() {
		// TODO Auto-generated constructor stub
	}

	public static char[] addCharToCharArray(char[] chArray,char ch,int pos) {
		String s = new String(chArray);
		s = JNFStringUtil.addCharToString(s, ch, pos);
		return s.toCharArray();
	}

	public static char[] addCharToFirstPosOfCharArray(char[] chArray,char ch) {
		String s = new String(chArray);
		s = JNFStringUtil.addCharToFirstPosOfString(s, ch);
		return s.toCharArray();
	}

	public static char[] addCharToLastPosOfCharArray(char[] chArray,char ch) {
		String s = new String(chArray);
		s = JNFStringUtil.addCharToLastPosOfString(s, ch);
		return s.toCharArray();
	}

}
