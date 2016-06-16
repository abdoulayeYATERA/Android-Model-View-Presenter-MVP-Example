package com.yadevapp.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yadevapp.mvp.R;
import com.yadevapp.mvp.model.User;
import com.yadevapp.mvp.presenter.MainActivityPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * this is the view,
 * it hold the associated presenter reference {@link MainActivityPresenter}
 * it doesn't hold the model reference (it is not aware of the model)
 *
 * very important !!!!
 * there is not logical code in the view, events are delivered to the presenter
 * (a view has only ONE presenter)
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = getClass().getSimpleName();
    private MainActivityPresenter mMainActivityPresenter;

    @Bind(R.id.activity_main_firstname_textview) TextView mFirstNameTextView;
    @Bind(R.id.activity_main_lastname_textview) TextView mLastNameTextView;
    @Bind(R.id.activity_main_firstname_edittext) EditText mFirstNameEditText;
    @Bind(R.id.activity_main_lastname_edittext) EditText mLastNameEditText;
    @Bind(R.id.activity_main_update_firstname_button) Button mFirstNameUpdateButton;
    @Bind(R.id.activity_main_update_lastname_button) Button mLastNameUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //butter knife, instanciation
        ButterKnife.bind(this);
        //set buttons listeners
        mFirstNameUpdateButton.setOnClickListener(this);
        mLastNameUpdateButton.setOnClickListener(this);
        //instanciate the presenter
        mMainActivityPresenter = new MainActivityPresenter();
        mMainActivityPresenter.setModel(new User());
        mMainActivityPresenter.setView(this);
    }

    /**
     * update the firstName
     * @param firstName
     */
    public void updateFirstName(String firstName) {
        Log.d(TAG, "updateFirstName : " + firstName);
        mFirstNameTextView.setText(firstName);
    }

    /**
     * update the lastName
     * @param lastName
     */
    public void updateLastName(String lastName) {
        Log.d(TAG, "updateLastName : " + lastName);
        mLastNameTextView.setText(lastName);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick");
        int viewId = v.getId();

        switch (viewId) {
            case R.id.activity_main_update_firstname_button:
                //the user clicked on update firstname button
                //send the event to the presenter
                String newFirstName = mFirstNameEditText.getText().toString();
                mMainActivityPresenter.onUpdateFirstNameButtonClick(newFirstName);
                break;
            case R.id.activity_main_update_lastname_button:
                //the user clicked on update lastname button
                String newLastName = mLastNameEditText.getText().toString();
                mMainActivityPresenter.onUpdateLastNameButtonClick(newLastName);
                break;
        }
    }
}
