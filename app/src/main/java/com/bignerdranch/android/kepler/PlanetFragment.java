package com.bignerdranch.android.kepler;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.graphics.Typeface;
import android.media.MediaPlayer;

import java.util.List;

/**
 * Created by johnwheeler on 12/2/16.
 */

public class PlanetFragment extends Fragment
{
    private Button mNextButton;
    private Button mPrevButton;
    private Button mFactsButton;
    private ImageView planetView;
    private TextView planetNameView;

    public static final String KEY_INDEX = "index";


    private int i;
    //private int amb;
    MediaPlayer mp2;


    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        if (savedInstanceState !=null)
        {
            i = savedInstanceState.getInt(KEY_INDEX, 0);
        }


    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        Drawable e = getResources().getDrawable(R.drawable.earth);
        Drawable m = getResources().getDrawable(R.drawable.mars);
        Drawable j = getResources().getDrawable(R.drawable.jupiter);
        Drawable s = getResources().getDrawable(R.drawable.saturn);
        Drawable u = getResources().getDrawable(R.drawable.uranus);
        Drawable n = getResources().getDrawable(R.drawable.neptune);
        Drawable mr = getResources().getDrawable(R.drawable.mercury);
        Drawable vs = getResources().getDrawable(R.drawable.venus);



        final Planet [] planets = new Planet[]
                {
                        new Planet("Earth", e, "The largest of the terrestrial planets.\n Atmospheres and Oceans were formed" +
                                " by volcanic activity.\n Outer layers are divided into tectonic plates."),
                        new Planet("Mars", m, "Named for the Roman god of war.\n The iron oxide on the surface gives it its red appearance.\n" +
                                "Currently host to eight functional spacecraft."),
                        new Planet("Jupiter", j, "Its red spot is actually a storm larger than Earth.\n Atmosphere mostly consists of Hydrogen and Helium.\n" +
                                "Galileo discovered its four largest moons in 1610 with a telescope."),
                        new Planet("Saturn", s, "Most recognizable by its rings.\n Core's composition is similar to Earth's, but denser.\n" +
                                "A Saturn year lasts roughly 29 Earth years."),
                        new Planet("Uranus", u, "Similar atmosphere to Jupiter and Saturn but with more ice.\n Has a significantly lower internal " +
                                "heat than the other giant planets.\n Magnetic field does not originate from its geometric center."),
                        new Planet("Neptune", n, "Along with Uranus is known as one of the 'ice giants.'\n Densest of the giant planets.\n" +
                                "Discovered by French mathematician Urbain Le Verrier in 1846."),
                        new Planet("Mercury", mr, "Surface temperatures range from -280 degrees Fahrenheit to 800 degrees Fahrenheit.\n" +
                                "Has a rocky surface similar to that of Earth.\n "),
                        new Planet("Venus", vs, "Has the longest rotation period in the Solar System.\n Atmosphere consists of mostly" +
                                " Carbon Dioxide.\n Has twice the number of volcanoes on Earth.")
                };


        View v = inflater.inflate(R.layout.activity_planet, container, false);

        //Typeface t = Typeface.createFromAsset(getActivity().getAssets(),"fonts/earthorbiter.ttf");

        mNextButton = (Button) v.findViewById(R.id.next_button);
        mPrevButton = (Button) v.findViewById(R.id.prev_button);
        mFactsButton = (Button) v.findViewById(R.id.fact_button);
        planetNameView = (TextView) v.findViewById(R.id.planet_name);
        //planetNameView.setTypeface(t);
        planetNameView.setTextColor(Color.GREEN);
        planetNameView.setText(planets[i].getmName());
        planetView = (ImageView) v.findViewById(R.id.planet_image);
        planetView.setImageDrawable(planets[i].getPic());

        MediaPlayer mp1 = MediaPlayer.create(getActivity(), R.raw.servoburst);
        mp1.start();
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer)
            {
                mediaPlayer.release();
            }
        });
        //amb = R.raw.controlroom;
        mp2 = MediaPlayer.create(getActivity(), R.raw.controlroom);
        mp2.setLooping(true);
        mp2.start();
        mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer)
            {
                mediaPlayer.release();

            }
        });

        //CharSequence Nm = planets[i].getmName();

        //Toast.makeText(getActivity().getApplicationContext(), planets[i].getmName(), Toast.LENGTH_LONG).show();

        try {

            mNextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i = (i + 1) % planets.length;
                    planetNameView.setText(planets[i].getmName());
                    planetView.setImageDrawable(planets[i].getPic());
                    MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.openbutton);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                    {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer)
                        {
                            mediaPlayer.release();

                        }
                    });
                }
            });

            mPrevButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (i == 0) {
                        i = (planets.length - 1);
                    } else {
                        i = (i - 1) % planets.length;
                    }

                    planetNameView.setText(planets[i].getmName());
                    planetView.setImageDrawable(planets[i].getPic());
                    MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.openbutton);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                    {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer)
                        {
                            mediaPlayer.release();

                        }
                    });
                }
            });

            mFactsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MediaPlayer mp = MediaPlayer.create(getActivity(), R.raw.scifiinterface);
                    FragmentManager fm = getFragmentManager();
                    FactFragment ff = new FactFragment();
                    ff.setFactsfacts("\n" + planets[i].getmFacts());
                    ff.setTargetFragment(PlanetFragment.this, 1);
                    ff.show(fm, "Facts About " + planets[i].getmName());
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                    {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer)
                        {
                            mediaPlayer.release();

                        }
                    });
                }
            });
        }

        catch (Exception ex)
        {
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "DANGER! DANGER! We've Encountered an Error!", Toast.LENGTH_SHORT);
            t.show();
        }

        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        //savedInstanceState.putCharSequence(KEY_INDEX, planetNameView.getText());
        savedInstanceState.putInt(KEY_INDEX, i);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.about_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_item_about_app:
            FragmentManager fm = getFragmentManager();
            SourceFragment sf = new SourceFragment();
            sf.setTargetFragment(PlanetFragment.this, 1);
            sf.show(fm, "About the App");
            return true;

            case R.id.menu_item_audio:
                FragmentManager fm2 = getFragmentManager();
                AudioFragment af = new AudioFragment();
                //af.setNote(amb);
                af.setMp(mp2);
                af.setTargetFragment(PlanetFragment.this, 1);
                af.show(fm2, "Pick A Track");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}