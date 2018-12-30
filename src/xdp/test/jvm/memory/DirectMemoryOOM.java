package xdp.test.jvm.memory;

import java.lang.reflect.Field;

import sun.misc.Unsafe;
/**
 * VM args: -Xmx20m -XX:MaxDirectMemorySize=10m
 * @author dell
 *
 */
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024*1024;

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field field = Unsafe.class.getDeclaredFields()[0];
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe) field.get(null);
		int i=0;
		while(true){
			// ∑÷≈‰ƒ⁄¥Ê
			unsafe.allocateMemory(_1MB);
			System.out.println(++i);
		}

	}

}
