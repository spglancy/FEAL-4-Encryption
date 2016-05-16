import java.nio.charset.StandardCharsets;

public class toByte{
	public static String input="hello";
	public String result;
	static byte[] data = input.getBytes(StandardCharsets.UTF_8);
	@Override
	public String toString(){
		for(int i=0;i<data.length;i++){
			result+=data[i]+",";
		}
		return result+"]";
	}
	public static void main(String[] args){
		System.out.print(data);
	}
}