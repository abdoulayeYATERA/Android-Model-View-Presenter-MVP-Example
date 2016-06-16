package com.yadevapp.mvp.presenter;

import android.util.Log;
import com.yadevapp.mvp.view.MainActivity;
import com.yadevapp.mvp.model.User;

/**
 * Created by abdoulaye on 6/10/16.
 * the presenter associate with the view {@link MainActivity}
 * all events in the view (like user interactions through ui) are delivered to the presenter
 * wich treat and update the view if necessary
 *
 * important !!!
 * the presenter hold a reference of the associated view {@link MainActivity}
 * and to the model(s) (a presenter can have many models) {@link User}
 * a presenter hold only ONE view but can hold many models
 */

public class MainActivityPresenter {
    private final String TAG = getClass().getSimpleName();
    private User mUser;
    private MainActivity mView;

    /**
     * @param view
     * set the view to this presenter
     */
    public void setView(MainActivity view) {
        Log.d(TAG, "setView");
        mView = view;
    }

    /**
     * @param user
     * set the model to this presenter
     */
    public void setModel(User user) {
        Log.d(TAG, "setModel");
        mUser = user;
    }

    /**
     * @param user
     * update the firstName in the view
     */
    public void updateViewFirstName(User user) {
        Log.d(TAG, "updateFirstName");
        mView.updateFirstName(user.getmFirstName());
    }

    /**
     * @param user
     * update the lastName in the view
     */
    public void updateViewLastName(User user) {
        Log.d(TAG, "updateViewLastName");
        mView.updateLastName(user.getmLastName());
    }

    /**
     * @param newLastName
     * update the user last name and update the view if necessary
     */
    public void onUpdateLastNameButtonClick (String newLastName) {
        Log.d(TAG, "onUpdateLastNameButtonClick");
        Log.d(TAG, "new last name = " + newLastName);

        if (newLastName.equals(mUser.getmLastName()) == false) {
            //the new last name is different of the actual one
            mUser.setmLastName(newLastName);
            updateViewLastName(mUser);
        } else {
            Log.d(TAG, "the new last name and the actual are equal, no need to update the view");
        }
    }

    /**
     * @param newFirstName
     * update the user first name and update the view if necessary
     */
    public void onUpdateFirstNameButtonClick (String newFirstName) {
        Log.d(TAG, "onUpdateLastNameButtonClick");
        Log.d(TAG, "new first name = " + newFirstName);

        if (newFirstName.equals(mUser.getmLastName()) == false) {
            //the new first name is different of the actual one
            mUser.setmFirstName(newFirstName);
            updateViewFirstName(mUser);
        } else {
            Log.d(TAG, "the new first name and the actual are equal, no need to update the view");
        }
    }
}
