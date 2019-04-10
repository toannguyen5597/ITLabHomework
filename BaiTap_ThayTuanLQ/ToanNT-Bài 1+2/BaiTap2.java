/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitap2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 *
 * @author khong
 */
public class BaiTap2{

    public static void main(String[] args) {
        BufferedImage img = null;
        File file = null;
        try {
            file = new File("d:\\Demo3.jpg");
            img = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println(e);
        }
        int wid = img.getWidth();
        int hig = img.getHeight();
        
        for(int row = 0; row < hig; row++)
            for(int col = 0; col < wid; col++){
                int p = img.getRGB(col, row);
                //System.out.println(p+"  ");
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = (p >> 0) & 0xff;
                
                if((g+b) < r-20){
                    p = new Color(0,0,255).getRGB();
                    img.setRGB(col, row, p);
                }
                
            }
        try {
            file = new File("D:\\Output.jpg");
            ImageIO.write(img, "jpg", file);
        } catch (Exception e) {
        }
    }
    
    
    
}
