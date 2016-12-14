package com.bignerdranch.android.kepler;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.UUID;

/**
 * Created by johnwheeler on 12/1/16.
 */

public class Planet
{
    //private UUID PlanetID;
    private String mName;
    private String mFacts;
    private Drawable pic;

    //private String ImagePath;

    /*public String getImagePath()
    {
        return ImagePath;
    }

    public void setImagePath(String imagePath)
    {
        ImagePath = imagePath;
    }*/

    /*public UUID getPlanetID()
    {
        return PlanetID;
    }*/

    public Planet (String name, Drawable pic, String facts)
    {
        this.mName = name;
        this.pic = pic;
        this.mFacts = facts;
    }

    public String getmName()
    {
        return mName;
    }

    /*public void setmName(String mName)
    {
        this.mName = mName;
    }*/

    public String getmFacts()
    {
        return mFacts;
    }

    /*public void setmFacts(String mFacts)
    {
        this.mFacts = mFacts;
    }*/

    public Drawable getPic() {return pic;}

    /*public void setPic(Drawable pic)
    {
        this.pic = pic;
    }

    public String getPhotoFile()
    {
        return "IMG_" + getPlanetID().toString()+".jpg";
    }*/
}