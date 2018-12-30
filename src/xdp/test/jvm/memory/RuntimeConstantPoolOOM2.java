package xdp.test.jvm.memory;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM2 {

	public static void main(String[] args) {
		String str1 = new StringBuilder("¼ÆËã»ú").append("Èí¼ş").toString();
		String intern = str1.intern();
		System.out.println("intern:"+intern);
		System.out.println(intern == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		String intern2 = str2.intern();
		System.out.println("intern2:"+intern2);
		System.out.println(intern2 == str2);
		
		String str3 = new String("java");
		System.out.println(str3.intern() == str3);
	}

}
