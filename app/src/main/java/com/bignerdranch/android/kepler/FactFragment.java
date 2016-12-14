package com.bignerdranch.android.kepler;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

/**
 * Created by johnwheeler on 12/5/16.
 */

public class FactFragment extends DialogFragment
{
    private TextView mFacts;
    private Activity activity;
    private String factsfacts;
    //private String planetName;
    public static final String STRNG = "The_String";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (savedInstanceState !=null)
        {
            factsfacts = savedInstanceState.getString(STRNG, "The largest of the terrestrial planets.\n Atmospheres and Oceans were formed" +
                    " by volcanic activity.\n Outer layers are divided into tectonic plates.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View r = inflater.inflate(R.layout.facts, container, false);
        mFacts = (TextView) r.findViewById(R.id.factids);
        mFacts.setTextColor(Color.GREEN);
        mFacts.setText(factsfacts);
        getDialog().setTitle("Interesting Facts");

        return r;
    }

    public void setFactsfacts(String factsfacts)
    {
        this.factsfacts = factsfacts;
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(STRNG, factsfacts);
    }

    /*public void setPlanetName(String planetName)
    {
        this.planetName = planetName;
    }*/
}