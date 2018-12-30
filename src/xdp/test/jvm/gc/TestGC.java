package xdp.test.jvm.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class TestGC {
	
	private static final int _1MB = 1024*1024;

	public static void main(String[] args) {
//		testAllocation();
//		testGC();
//		testPretenureSizeThreshold();
		testTenuringThreshold();
	}
	
	public static void testGC(){
		List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
		for (GarbageCollectorMXBean b : beans) {
			System.out.println(b.getName());
		}
	}
	
	/**
	 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 */
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new byte[2*_1MB];
		allocation2 = new byte[2*_1MB];
		allocation3 = new byte[2*_1MB];
		allocation4 = new byte[4*_1MB];
	}
	
	/**
	 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:PretenureSizeThreshold=3145728  // 3m
	 */
	public static void testPretenureSizeThreshold(){
		byte[] allocation;
		allocation = new byte[3*_1MB];// 直接分配到老年代
	}
	
	
	/**
	 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
	 */
	public static void testTenuringThreshold(){
		byte[] allocation1,allocation2,allocation3;
		allocation1 = new byte[_1MB/4];
		allocation2 = new byte[4*_1MB];
		allocation3 = new byte[4*_1MB];
		allocation3 = null;
		allocation3 = new byte[4*_1MB];
	}


}
