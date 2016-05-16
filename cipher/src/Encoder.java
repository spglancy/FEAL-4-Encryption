import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Encoder {
	public static String input1;
	public static String input2;
	public static String secretkey="afsuirlc";
	public static byte[] key = secretkey.getBytes(StandardCharsets.UTF_8);
	public static byte[] key1;
	public static byte[] key2 = new byte[4];
	public static byte keysched1;
	public static byte keysched2;
	public static byte keysched3;
	public static byte keysched4;
	public static byte keysched5;
	public static byte keysched6;
	public static byte keysched7;
	public static byte keysched8;
	public static byte sub1;
	public static byte sub2;
	public static byte sub3;
	public static byte sub4;
	public static byte sub5;
	public static byte sub6;
	public static byte[] subkey1=new byte[2];
	public static byte[] subkey2=new byte[2];
	public static byte[] subkey3=new byte[2];
	public static byte[] subkey4=new byte[2];
	public static byte[] subkey5=new byte[2];
	public static byte[] subkey6=new byte[2];
	public static byte[] subkey7=new byte[2];
	public static byte[] subkey8=new byte[2];
	public static byte[] subkey9=new byte[2];
	public static byte[] subkey10=new byte[2];
	public static byte[] subkey11=new byte[2];
	public static byte[] subkey12=new byte[2];
	public static byte[] subkey13=new byte[2];
	public static byte[] subkey14=new byte[2];
	public static byte[] subkey15=new byte[2];
	public static byte[] subkey16=new byte[2];
	public static byte[] temp;
	public static byte[] temp2;
	public static byte[] temp5=new byte[8];
	public static byte temps;
	public static byte[] result=new byte[4];
	public static byte[] result2=new byte[8];
	public static byte[] temp3;
	public static byte[] temp4;
	public static byte[] xorkey1=new byte[8];
	public static byte[] xorkey2=new byte[8];

	public Encoder(String arg) {
		input1 = arg.substring(0, arg.length() / 2);
		input2 = arg.substring(arg.length() / 2, arg.length());
	}

	public static void split(byte[] a, byte[] b, byte[] c) {
		for (int i = 0; i < a.length/2; i++) {
			b[i] = a[i];
		}
		c[0]=a[2];
		c[1]=a[3];
	}

	public static void keysched(byte[] arg1, byte[] arg2) {
		temp = fkblock(arg1, arg2);
		split(temp, subkey1, subkey2);
		temp = XOR(temp, key1);
		temp2 = fkblock(key2, temp);
		split(temp2, subkey3, subkey4);
		temp = XOR(temp2, key2);
		temp = fkblock(temp, temp2);
		split(temp, subkey5, subkey6);
		temp = XOR(temp2, temp);
		temp2 = fkblock(temp2, temp);
		split(temp2, subkey7, subkey8);
		temp=XOR(temp,temp2);
		temp=fkblock(temp,temp2);
		split(temp,subkey9,subkey10);
		temp=XOR(temp,temp2);
		temp2=fkblock(temp2,temp);
		split(temp2,subkey11,subkey12);
		temp=XOR(temp,temp2);
		temp=fkblock(temp,temp2);
		split(temp,subkey13,subkey14);
		temp=XOR(temp,temp2);
		temp2=fkblock(temp2,temp);
		split(temp2,subkey15,subkey16);
	}

	public static byte[] fkblock(byte[] a, byte[] b) {
		keysched1 = a[0];
		keysched2 = a[1];
		keysched3 = a[2];
		keysched4 = a[3];
		keysched5 = b[0];
		keysched6 = b[1];
		keysched7 = b[2];
		keysched8 = b[3];
		keysched2 = (byte) (keysched1 ^ keysched2);
		keysched3 = (byte) (keysched3 ^ keysched4);
		keysched5 = (byte) (keysched5 ^ keysched3);
		keysched2 = sblock(keysched2, keysched5, (byte) 1);
		keysched7 = (byte) (keysched2 ^ keysched7);
		keysched1 = sblock(keysched1, keysched7, (byte) 0);
		keysched6 = (byte) (keysched2 ^ keysched6);
		keysched3 = sblock(keysched3, keysched6, (byte) 0);
		keysched8 = (byte) (keysched3 ^ keysched8);
		keysched4 = sblock(keysched4, keysched8, (byte) 1);
		final byte[] subkeys={ keysched1, keysched2, keysched3, keysched4 };
		return subkeys;
	}

	public static byte[] XOR(byte[] a, byte[] b) {
		for (int i = 0; i < b.length; i++) {
			result[i] = (byte) (a[i] ^ b[i]);
		}
		return result;
	}
	public static byte[] XOR2(byte[] a, byte[] b) {
		for (int i = 0; i < b.length; i++) {
			result2[i] = (byte) (a[i] ^ b[i]);
		}
		return result2;
	}

	public void shiftleft(byte[] arg) {
		for (int i = arg.length; i > -1; i--) {
			if (i < arg.length) {
				arg[i] = arg[i + 1];
			}
			arg[i] = arg[0];
		}
	}

	public static byte[] fblock(byte[] a, byte[] b) {
		sub1 = a[0];
		sub2 = a[1];
		sub3 = a[2];
		sub4 = a[3];
		sub5 = b[0];
		sub6 = b[1];
		sub2 = (byte) (sub2 ^ sub5);
		sub2 = (byte) (sub2 ^ sub1);
		sub3 = (byte) (sub3 ^ sub6);
		sub3 = (byte) (sub3 ^ sub4);
		sub2 = sblock(sub2, sub3, (byte) 1);
		sub3 = sblock(sub3, sub2, (byte) 0);
		sub1 = sblock(sub1, sub2, (byte) 0);
		sub4 = sblock(sub4, sub3, (byte) 1);
		final byte[] subs={sub1,sub2,sub3,sub4};
		return subs;

	}

	// needs finished
	public static byte sblock(byte a, byte b, byte x) {
		temps = (byte) (a + b + (x % 256));
		return temps;
	}
	
	public static byte[] Encrypt(byte[] data1, byte[] data2){
		xorkey1[0]=subkey9[0];
		xorkey1[1]=subkey9[1];
		xorkey1[2]=subkey10[0];
		xorkey1[3]=subkey10[1];
		xorkey1[4]=subkey11[0];
		xorkey1[5]=subkey11[1];
		xorkey1[6]=subkey12[0];
		xorkey1[7]=subkey12[1];
		xorkey2[0]=subkey13[0];
		xorkey2[1]=subkey13[1];
		xorkey2[2]=subkey14[0];
		xorkey2[3]=subkey14[1];
		xorkey2[4]=subkey15[0];
		xorkey2[5]=subkey15[1];
		xorkey2[6]=subkey16[0];
		xorkey2[7]=subkey16[1];
		XOR2(key,xorkey1);
		key1 = Arrays.copyOfRange(key, 0, 4);
		key2 = Arrays.copyOfRange(key, 4, 8);
		temp3=XOR(data1,data2);
		temp4=fblock(temp3,subkey1);
		temp4=XOR(temp4,data1);
		temp4=fblock(temp4,subkey2);
		temp3=XOR(temp3,temp4);
		temp3=fblock(temp3,subkey3);
		temp4=XOR(temp3,temp4);
		temp4=fblock(temp4,subkey4);
		temp3=XOR(temp3,temp4);
		temp3=fblock(temp3,subkey5);
		temp4=XOR(temp3,temp4);
		temp4=fblock(temp4,subkey6);
		temp3=XOR(temp3,temp4);
		temp3=fblock(temp3,subkey7);
		temp4=XOR(temp3,temp4);
		temp4=fblock(temp4,subkey8);
		temp3=XOR(temp3,temp4);
		temp5[0]=temp3[0];
		temp5[1]=temp3[1];
		temp5[2]=temp3[2];
		temp5[3]=temp3[3];
		temp5[4]=temp4[0];
		temp5[5]=temp4[1];
		temp5[6]=temp4[2];
		temp5[7]=temp4[3];
		temp5=XOR2(temp5,xorkey2);
		return  temp5;
	}

	public static void main(String[] args) {
		Encoder a = new Encoder("hellodot");
		byte[] data1 = input1.getBytes(StandardCharsets.UTF_8);
		byte[] data2 = input2.getBytes(StandardCharsets.UTF_8);
		key1 = Arrays.copyOfRange(key, 0, 4);
		key2 = Arrays.copyOfRange(key, 4, 8);
		keysched(key1, key2);
		System.out.print(Arrays.toString(Encrypt(data1,data2)));
	}
}