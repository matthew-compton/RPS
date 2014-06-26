package com.ambergleam.rps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class RPSActivity extends FragmentActivity {

    public static final String EXTRA_PLAYER_ONE_THROW = "com.ambergleam.player_one_throw";
    public static final String EXTRA_PLAYER_TWO_THROW = "com.ambergleam.player_two_throw";

    private Throw mPlayerOneThrow;
    private Throw mPlayerTwoThrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
        if (savedInstanceState == null) {
            navigateStart();
        } else {
            mPlayerOneThrow = (Throw) savedInstanceState.getSerializable(EXTRA_PLAYER_ONE_THROW);
            mPlayerTwoThrow = (Throw) savedInstanceState.getSerializable(EXTRA_PLAYER_TWO_THROW);
            navigate();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putSerializable(EXTRA_PLAYER_ONE_THROW, mPlayerOneThrow);
        savedInstanceState.putSerializable(EXTRA_PLAYER_TWO_THROW, mPlayerTwoThrow);
        super.onSaveInstanceState(savedInstanceState);
    }

    protected void navigateStart() {
        mPlayerOneThrow = null;
        mPlayerTwoThrow = null;

        Fragment fragment = new IntroFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    protected void navigate() {
        Fragment fragment;
        if (mPlayerOneThrow == null && mPlayerTwoThrow == null) {
            fragment = new PlayerOneFragment();
        } else if (mPlayerOneThrow != null && mPlayerTwoThrow == null) {
            fragment = new PlayerTwoFragment();
        } else if (mPlayerOneThrow != null && mPlayerTwoThrow != null) {
            fragment = new ResultFragment();
        } else {
            fragment = new IntroFragment();
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    public Throw getPlayerTwoThrow() {
        return mPlayerTwoThrow;
    }

    public void setPlayerTwoThrow(Throw playerTwoThrow) {
        mPlayerTwoThrow = playerTwoThrow;
    }

    public Throw getPlayerOneThrow() {
        return mPlayerOneThrow;
    }

    public void setPlayerOneThrow(Throw playerOneThrow) {
        mPlayerOneThrow = playerOneThrow;
    }

}
