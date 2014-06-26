package com.ambergleam.rps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Player Two fragment
 */
public class PlayerTwoFragment extends Fragment {


    private Button mRockButton;
    private Button mPaperButton;
    private Button mScissorsButton;

    public PlayerTwoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_player_two, container, false);


        mRockButton = (Button) rootView.findViewById(R.id.fragment_player_two_button_rock);
        mRockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThrow(Throw.ROCK);
            }
        });

        mPaperButton = (Button) rootView.findViewById(R.id.fragment_player_two_button_paper);
        mPaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThrow(Throw.PAPER);

            }
        });

        mScissorsButton = (Button) rootView.findViewById(R.id.fragment_player_two_button_scissors);
        mScissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeThrow(Throw.SCISSORS);
            }
        });

        return rootView;
    }

    private void makeThrow(Throw playerTwoThrow) {
        ((RPSActivity) getActivity()).setPlayerTwoThrow(playerTwoThrow);
        ((RPSActivity) getActivity()).navigate();
    }

}
