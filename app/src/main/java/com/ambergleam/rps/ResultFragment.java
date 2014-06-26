package com.ambergleam.rps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Result fragment
 */
public class ResultFragment extends Fragment {

    private TextView mResultTextView;
    private Button mPlayAgainButton;

    public ResultFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        mResultTextView = (TextView) rootView.findViewById(R.id.fragment_result_text);
        mResultTextView.setText(getResultText());

        mPlayAgainButton = (Button) rootView.findViewById(R.id.fragment_result_play_again);
        mPlayAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RPSActivity) getActivity()).navigateStart();
            }
        });

        return rootView;
    }

    private String getResultText() {
        Throw one = ((RPSActivity) getActivity()).getPlayerOneThrow();
        Throw two = ((RPSActivity) getActivity()).getPlayerTwoThrow();
        if (one.defeats(two)) {
            return getString(R.string.fragment_result_player_one_wins);
        }
        if (two.defeats(one)) {
            return getString(R.string.fragment_result_player_two_wins);
        }
        return getString(R.string.fragment_result_draw);
    }

}
