import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class byteThing {
    public static void main(String[] args) throws UnsupportedEncodingException {

	// The string we want to convert.
	String letters = "abc";
	System.out.println(letters);


	byte[] valuesDefault = letters.getBytes();
	// ... Use Arrays.toString to display our byte array.
	System.out.println(Arrays.toString(valuesDefault));

	// Specify US-ASCII char set directly.
	byte[] valuesAscii = letters.getBytes("US-ASCII");
	System.out.println(Arrays.toString(valuesAscii));
    }
}
