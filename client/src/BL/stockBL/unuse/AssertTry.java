package BL.stockBL.unuse;

/**
 * test for add assert ,useless i think
 * @author lzb
 *
 */
public class AssertTry {

	public static boolean test(int x) {
		assert(x!=0);
		System.out.println("in here");
		return true;
	}
	public static void main(String[] args) {
		boolean flag =AssertTry.test(0);
		System.out.println("hello"+flag);
	}
}
