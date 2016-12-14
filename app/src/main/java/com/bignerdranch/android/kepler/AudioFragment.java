package com.bignerdranch.android.kepler;

/**
 * Created by johnwheeler on 12/8/16.
 */
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AudioFragment extends DialogFragment
{
    private TextView t1;
    private Button t2, t3;
    private int i;
    private MediaPlayer mp;
    public static final String KEY_INDEX = "index";
    //ArrayList<Integer> music;

    public void setMp(MediaPlayer mp)
    {
        this.mp = mp;
    }
    /*public void setNote(int note)
    {
        this.note = note;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (savedInstanceState !=null)
        {
            i = savedInstanceState.getInt(KEY_INDEX, R.raw.controlroom);
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View f = inflater.inflate(R.layout.pick_audio, container, false);
/*        music = new ArrayList<>();
        music.add(R.raw.controlroom);
        music.add(R.raw.bensoundscifi);
        music.add(R.raw.bensoundrelaxing);*/
        i = R.raw.controlroom;
        mp = MediaPlayer.create(getActivity(),i);
        //mp.start();
        //mp.setLooping(true);

        t1 = (TextView) f.findViewById(R.id.audio_selector);
        t1.setTextColor(Color.WHITE);


            t2 = (Button) f.findViewById(R.id.ambience);
            t2.setTextColor(Color.WHITE);
        try {
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t2.setTextColor(Color.BLUE);
                    //mp.pause();
                    mp.stop();
                    //mp.release();
                    //mp.reset();
                    //mp.seekTo(R.raw.controlroom);
                    i = R.raw.controlroom;
                    mp = MediaPlayer.create(getActivity(),i);
                    mp.start();
                    //note = R.raw.controlroom;
                    //mp = MediaPlayer.create(getActivity(), note);
                    //mp.selectTrack(R.raw.controlroom);
                    //mp.prepareAsync();
                    getDialog().dismiss();
                }
            });

            t3 = (Button) f.findViewById(R.id.relaxing);
            t3.setTextColor(Color.WHITE);
            t3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t3.setTextColor(Color.BLUE);
                    //mp.reset();
                    //mp.pause();
                    mp.stop();
                    //mp.release();
                    i = R.raw.bensoundrelaxing;
                    mp = MediaPlayer.create(getActivity(),i);
                    //mp.seekTo(R.raw.bensoundrelaxing);
                    mp.start();
                    getDialog().dismiss();
                }
            });
        }

        catch (Exception e)
        {
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Danger! Danger! We've Encountered an Error!", Toast.LENGTH_SHORT);
            t.show();
        }
            /*t4 = (Button) f.findViewById(R.id.scifi);
            t4.setTextColor(Color.WHITE);
            t4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t4.setTextColor(Color.BLUE);
                    //mp.reset();
                    //mp.pause();
                    mp.stop();
                    //mp.release();
                    mp = MediaPlayer.create(getActivity(),R.raw.bensoundscifi);
                    //mp.seekTo(R.raw.bensoundscifi);
                    mp.start();
                    getDialog().dismiss();
                }
            });*/



        getDialog().setTitle("Pick a Track");

        return f;
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, i);
    }


}