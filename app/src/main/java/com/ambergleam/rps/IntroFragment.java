package com.ambergleam.rps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Intro fragment
 */
public class IntroFragment extends Fragment {

    private Button mPlayButton;

    public IntroFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_intro, container, false);

        mPlayButton = (Button) rootView.findViewById(R.id.fragment_intro_play);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RPSActivity) getActivity()).navigate();
            }
        });

        return rootView;
    }

}