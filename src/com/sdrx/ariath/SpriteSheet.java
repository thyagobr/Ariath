/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdrx.ariath;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Archon
 */
public class SpriteSheet {

    public static final int SPRITESHEET_SIZE = 256;
    public static final int TILE_SIZE = 16;
    public static int[] pixels;

    public SpriteSheet(String URI) {
        pixels = new int[SPRITESHEET_SIZE * SPRITESHEET_SIZE];
        loadSpriteSheet(URI);
    }

    private void loadSpriteSheet(String URI) {
        try {
            BufferedImage img = ImageIO.read(SpriteSheet.class.getResource(URI));
            img.getRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
        } catch (IOException ex) {
            System.out.println("#> Spritesheet not loaded.");
        }
    }
}
