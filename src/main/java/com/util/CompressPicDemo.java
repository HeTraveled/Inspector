package com.util;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
 
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class CompressPicDemo {
	
	public static CompressPicDemo compressPicDemo;
	
	
   
    public static CompressPicDemo getCompressPicDemo() {
    	if(compressPicDemo==null)compressPicDemo=new CompressPicDemo();
		return compressPicDemo;
	}



	public void setCompressPicDemo(CompressPicDemo compressPicDemo) {
		CompressPicDemo.compressPicDemo = compressPicDemo;
	}



	// 图片处理
    public static File compressPic(File file,double outputWidth,double outputHeight) {
        try {
            //获得源文件
            if (!file.exists()) {
            	System.out.println(1);
                return null;
            }
            Image img = ImageIO.read(file);
            // 判断图片格式是否正确
            if (img.getWidth(null) == -1) {
                return null;
            } else {
                int newWidth;
                int newHeight;
                // 为等比缩放计算输出的图片宽度及高度
				double rate1 = img.getWidth(null) / outputWidth + 0.1;
				double rate2 = img.getHeight(null) / outputHeight + 0.1;
				// 根据缩放比率大的进行缩放控制
				double rate = rate1 > rate2 ? rate1 : rate2;
				newWidth = (int) (img.getWidth(null) / rate);
				newHeight = (int) (img.getHeight(null) / rate);
                BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                 /*
                 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的
                 * 优先级比速度高 生成的图片质量比较好 但速度慢
                 */
                tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
                FileOutputStream out = new FileOutputStream(file);
                // JPEGImageEncoder可适用于其他图片类型的转换
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                encoder.encode(tag);
                out.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return file;
    }
}