package BL.accountBL;

import java.io.File;

import utility.FileHelper;

public class AccountTest {
	public static void main(String args[]) {

		String Path = "";
		byte t[] = FileHelper.getBytes("d:test.png");
		String na = t.hashCode() + ".png";
		System.out.println("t.hash=" + na);

		File directory = new File("");// 设定为当前文件夹
		try {
			Path = directory.getCanonicalPath() + "/temp";
		} catch (Exception e) {
		}

		FileHelper.createFile(t, Path, na);

	}
}
