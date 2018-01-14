package utility;

import java.io.File;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageZipUtil {

	
	public static void main(String[] args) {
		zipWidthHeightImageFile(new File("D:\\test.png"), new File("D:\\new.png"), 80, 80, 0.8f);

		 System.out.println("ok");
	}

/**
* �������õĿ�ߵȱ���ѹ��ͼƬ�ļ�<br>
* �ȱ���ԭ�ļ�����ѹ�����ϴ�
* 
* @param oldFile
* Ҫ����ѹ�����ļ�
* @param newFile
* ���ļ�
* @param width
* ��� //���ÿ��ʱ���߶ȴ���0���ȱ������ţ�
* @param height
* �߶� //���ø߶�ʱ����ȴ���0���ȱ������ţ�
* @param quality
* ����
* @return ����ѹ������ļ���ȫ·��
*/
	public static String zipImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return null;
		}
		try {
			/** �Է������ϵ���ʱ�ļ����д��� */
		Image srcFile = ImageIO.read(oldFile);
		int w = srcFile.getWidth(null);
		int h = srcFile.getHeight(null);
		double bili;
		if (width > 0) {
		bili = width / (double) w;
		height = (int) (h * bili);
		} else {
		if (height > 0) {
		bili = height / (double) h;
		width = (int) (w * bili);
		}
		}
		
		String srcImgPath = newFile.getAbsoluteFile().toString();
		// System.out.println(srcImgPath);
		String subfix = "jpg";
		subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
		
		BufferedImage buffImg = null;
		if (subfix.equals("png")) {
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		} else {
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		
		Graphics2D graphics = buffImg.createGraphics();
		graphics.setBackground(new Color(255, 255, 255));
		graphics.setColor(new Color(255, 255, 255));
		graphics.fillRect(0, 0, width, height);
		graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		
		ImageIO.write(buffImg, subfix, new File(srcImgPath));
		
		} catch (Exception e) {
		e.printStackTrace();
		}
		return newFile.getAbsolutePath();
	}
		
		/**
		* �����õĿ�ȸ߶�ѹ��ͼƬ�ļ�<br>
		* �ȱ���ԭ�ļ�����ѹ�����ϴ�
		* 
		* @param oldFile
		* Ҫ����ѹ�����ļ�ȫ·��
		* @param newFile
		* ���ļ�
		* @param width
		* ���
		* @param height
		* �߶�
		* @param quality
		* ����
		* @return ����ѹ������ļ���ȫ·��
		*/
	public static boolean zipWidthHeightImageFile(File oldFile, File newFile, int width, int height, float quality) {
		if (oldFile == null) {
			return false;
		}
		Image srcFile = null;
		BufferedImage buffImg = null;
			try {
		/** �Է������ϵ���ʱ�ļ����д��� */
		srcFile = ImageIO.read(oldFile);
		
		String srcImgPath = newFile.getAbsoluteFile().toString();
		// System.out.println(srcImgPath);
		String subfix = "jpg";
		subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
		
		if (subfix.equals("png")) {
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		} else {
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		}
		
		Graphics2D graphics = buffImg.createGraphics();
		graphics.setBackground(new Color(255, 255, 255));
		graphics.setColor(new Color(255, 255, 255));
		graphics.fillRect(0, 0, width, height);
		graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		
		ImageIO.write(buffImg, subfix, new File(srcImgPath));
		return true;
		
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		} finally {
		if (srcFile != null) {
		srcFile.flush();
		}
		if (buffImg != null) {
		buffImg.flush();
		}
		
		}
		
		}
		
}