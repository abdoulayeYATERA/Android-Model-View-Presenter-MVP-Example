package com.yadevapp.mvp.model;

import android.util.Log;

/**
 * Created by abdoulaye on 6/10/16.
 * this is the user model
 * important !!
 * a model does not hold any presenter or view reference
 */
public class User {
    private String TAG = getClass().getSimpleName();
    private String mFistName;
    private String mLastName;

    public String getmFirstName() {
        Log.d(TAG, "getmFirstName");
        return mFistName;
    }

    public void setmFirstName(String mFirstName) {
        Log.d(TAG, "setmFirstName : " + mFirstName);
        this.mFistName = mFirstName;
    }

    public String getmLastName() {
        Log.d(TAG, "getmFirstName");
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        Log.d(TAG, "setmLastName : " + mLastName);
        this.mLastName = mLastName;
    }
}
