package com.sdrx.ariath;

import java.util.Random;

/**
 *
 * @author Archon
 */
class Screen {

    public final int width;
    public final int height;
    public static final int TILE_SIZE = 16;
    public final int[] pixels;
    // public final int[] tileset;
    Random random = new Random();
    private Sprite grass;
    private Character mage;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];

        grass = new Sprite(32, 0);
        mage = new Character(0, 0, new Sprite(16, 0));

        // for tiles technique
//        this.tileset = new int[TILE_SIZE * TILE_SIZE];
//        for (int i = 0; i < tileset.length; i++) {
//            this.tileset[i] = random.nextInt();
//        }
    }

    void clear() {
        for (int i = 0; i < width * height; i++) {
            pixels[i] = 0;
        }
    }

    // normal technique: pixel per pixel
    void render(int xOff, int yOff) {
        clear();
        int yPos, xPos = 0;
        for (int y = 0; y < height; y++) {
            yPos = y + yOff;
            for (int x = 0; x < width; x++) {
                xPos = x + xOff;
                if ((xPos < 0) || (xPos >= width) || (yPos < 0) || (yPos >= height)) {
                    continue;
                }
                pixels[xPos + yPos * width] = grass.pixelMap[(x & (SpriteSheet.TILE_SIZE - 1)) + (y & (SpriteSheet.TILE_SIZE - 1)) * SpriteSheet.TILE_SIZE];
            }
        }
    }

    void drawCharacter(int xOff, int yOff) {
        int yPos, xPos = 0;
        for (int y = 0; y < SpriteSheet.TILE_SIZE; y++) {
            yPos = y + yOff;
            for (int x = 0; x < SpriteSheet.TILE_SIZE; x++) {
                xPos = x + xOff;
                if ((xPos < 0) || (xPos >= width) || (yPos < 0) || (yPos >= height)) {
                    continue;
                }
                int color = mage.getSprite().pixelMap[(x & (SpriteSheet.TILE_SIZE - 1)) + (y & (SpriteSheet.TILE_SIZE - 1)) * SpriteSheet.TILE_SIZE];
                if (color != 0xffff00ff) {
                    pixels[xPos + yPos * width] = color;
                }
            mage.setPosX(xPos);
            mage.getPosY(yPos);
            }
        }
        System.out.println("Character at: " + mage.getPosX() + ", " + mage.getPosY());
    }

    void drawAbstract() {
        for (int y1 = 0; y1 < height; y1++) {
            double y = y1 - height / 2.0;
            double z = 100 / y;
            //System.out.println("Z: " + z);
            for (int x1 = 0; x1 < width; x1++) {
                double x = x1 - (width / 2.0);
                double xx = x * y;
                // int val = (x1 >= width / 2 ? x1 - ( 2* (x1 - (width / 2))) : x1);
                //pixels[x1 + y1 * width] = ((int) xx & 5)* 128;
                pixels[x1 + y1 * width] = (int) xx & 5 * 128;
            }
        }

    }
//    void renderTiles(int yOff, int xOff) {
//        // tiling technique: 1 pixel on tile array ocupies more TILE_SIZE pixels on the actualy screen
//        for (int y1 = 0; y1 < height; y1++) {
//            int yoff = y1 * TILE_SIZE;
//            for (int x1 = 0; x1 < width; x1++) {
//                int index = x1 + y1 * TILE_SIZE;
//                int xoff = x1 * TILE_SIZE;
//                for (int y2 = 0; y2 < TILE_SIZE; y2++) {
//                    for (int x2 = 0; x2 < TILE_SIZE; x2++) {
//                        int xx = x2 + xoff;
//                        int yy = y2 + yoff;
//                        if ((xx < 0) || (xx >= width) || (yy < 0) || (yy >= height)) {
//                            break;
//                        }
//                        pixels[xx + yy * width] = tileset[index];
//                    }
//                }
//            }
//        }
//    }
}
