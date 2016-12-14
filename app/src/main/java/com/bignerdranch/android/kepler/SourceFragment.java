package com.bignerdranch.android.kepler;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by johnwheeler on 12/6/16.
 */

public class SourceFragment extends DialogFragment
{
    private TextView mSources;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View r = inflater.inflate(R.layout.about_this_app, container, false);
        mSources = (TextView) r.findViewById(R.id.source_list);
        mSources.setText("http://adsabs.harvard.edu/abs/2000M&PS...35.1309M\n https://science.nasa.gov/headlines/y2001/ast28mar_1.htm" +
                "\n https://www.nasa.gov/mission_pages/MRO/news/mro20110804.html\n http://mnras.oxfordjournals.org/content/59/10/574\n" +
                "http://jha.sagepub.com/content/46/2/218\n Planet images courtesy of www.wikipedia.org.\n\n" +"Spaceship courtesy of http://es.123rf.com.\n" +
                "Buttons courtesy of www.pixabay.com\n Alien courtesy of www.wallpaperrs.com\n\n Background music courtesy of www.bensound.com\n" +
                "Sound effects courtesy of www.freesound.org");
        getDialog().setTitle("About");

        return r;
    }
}
