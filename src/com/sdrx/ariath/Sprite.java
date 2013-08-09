/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdrx.ariath;

/**
 *
 * @author Archon
 */
public class Sprite {

    public final int x, y;
    public int[] pixelMap;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        pixelMap = new int[SpriteSheet.TILE_SIZE * SpriteSheet.TILE_SIZE];
        createSprite();
    }

    private void createSprite() {
        for (int v = 0; v < SpriteSheet.TILE_SIZE; v++) {
            for (int u = 0; u < SpriteSheet.TILE_SIZE; u++) {
                pixelMap[u + v * SpriteSheet.TILE_SIZE] = SpriteSheet.pixels[(u + this.x) + (v + this.y) * SpriteSheet.SPRITESHEET_SIZE];
            }
        }
    }
}
