package com.kg.android.MainActivities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kg.android.R;


public class LoginActivity extends Activity implements View.OnClickListener {
    TextInputLayout usernameWrapper, passwordWrapper;
    EditText userName, password;
    Button login;
    String TAG = LoginActivity.class.getSimpleName();
    Snackbar snackbar;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        Init();
    }

    private void Init() {
        mainLayout = (LinearLayout) findViewById(R.id.LL_Main_layout);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
        userName = (EditText) findViewById(R.id.edt_user_name);
        password = (EditText) findViewById(R.id.edt_Password);
        login = (Button) findViewById(R.id.bt_login);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_login) {
            int mUserNameLength = userName.getText().toString().trim().length();
            int mPassword = password.getText().toString().trim().length();
            Log.d(TAG, "mUserNameLength:" + mUserNameLength);
            Log.d(TAG, "mPassword:" + mPassword);
            if (mUserNameLength > 0) {

                if (mPassword > 0) {

                    if (userName.getText().toString().trim().equals("Kongsberg")) {

                        if (password.getText().toString().trim().equals("Kongsberg@123")) {
                            Log.e(TAG, "Success");
                            Intent i = new Intent(LoginActivity.this, NavigationDrawerActivity.class);
                            startActivity(i);
                        } else {
                            snackbar = Snackbar
                                    .make(mainLayout, "Wrong UserName or Password", Snackbar.LENGTH_LONG);
                            View sbView = snackbar.getView();
                            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                            textView.setTextColor(Color.YELLOW);
                            snackbar.show();
                        }
                    } else {

                        snackbar = Snackbar
                                .make(mainLayout, "Wrong UserName or Password", Snackbar.LENGTH_LONG);
                        View sbView = snackbar.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.YELLOW);
                        snackbar.show();
                    }
                } else {
                    password.setError("Password cannot be blank");

                }
            } else {
                userName.setError("UserName cannot be blank");
            }
        }
    }
}
