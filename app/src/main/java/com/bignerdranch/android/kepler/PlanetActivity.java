package com.bignerdranch.android.kepler;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlanetActivity extends SingleFragmentActivity
{
    @Override
    public Fragment createFragment()
    {
        return new PlanetFragment();
    }
}