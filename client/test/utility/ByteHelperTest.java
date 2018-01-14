package utility;

import org.junit.jupiter.api.Test;

class ByteHelperTest {

	@Test
	void testImageToByte() {
		String filePath = "c:\\Users\\lzb\\Desktop\\testIn.txt";
		byte[] result = ByteHelper.imageToByte(filePath);
		
		for (byte e:result) {
			System.out.println(e);
		}
		assert(true);
	}

	@Test
	void testByteToImage() {
		byte[] array = new byte[256];
		array[0]='a';
		array[1]='b';
		String filePath = "c:\\Users\\lzb\\Desktop\\testOut.txt";
		
		ByteHelper.byteToImage(array, filePath);
		
	}

}
