package com.sdrx.ariath;

// @author archon

class Character {

private Integer x;
private Integer y;
private Sprite sprite;

public Character(Integer x, Integer y, Sprite sprite)
{
  this.x = x;
  this.y = y;
  this.sprite = sprite;
}

// Getters & Setters
public Sprite getSprite()
{
  return this.sprite;
}

public Integer getPosX()
{
  return this.x;
}

public void setPosX(Integer x)
{
  this.x = x;
}

public Integer getPosY()
{
  return this.y;
}

public void setPosY(Integer y)
{
  this.y = y;
}

}
