package com.ambergleam.rps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Player One fragment
 */
public class PlayerOneFragment extends Fragment {

    private Button mRockButton;
    private Button mPaperButton;
    private Button mScissorsButton;

    public PlayerOneFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_player_one, container, false);

        mRockButton = (Button) rootView.findViewById(R.id.fragment_player_one_button_rock);
        mRockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThrow(Throw.ROCK);
            }
        });

        mPaperButton = (Button) rootView.findViewById(R.id.fragment_player_one_button_paper);
        mPaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThrow(Throw.PAPER);
            }
        });

        mScissorsButton = (Button) rootView.findViewById(R.id.fragment_player_one_button_scissors);
        mScissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThrow(Throw.SCISSORS);
            }
        });

        return rootView;
    }

    private void makeThrow(Throw playerOneThrow){
        ((RPSActivity) getActivity()).setPlayerOneThrow(playerOneThrow);
        ((RPSActivity) getActivity()).navigate();
    }

}
