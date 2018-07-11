package com.videos.gujjuvideo.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.videos.gujjuvideo.R;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog dialog;
    private static BaseActivity instance;

    public boolean isInternetOn() {
        try {
            NetworkInfo activeNetwork = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE))
                    .getActiveNetworkInfo();
            if (activeNetwork == null || !activeNetwork.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void showNetworkAlert() {
        new AlertDialog.Builder(this)
                .setMessage(R.string.check_internet)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        dialogInterface.dismiss();
                    }
                }).show();
    }

    public static BaseActivity getInstance() {
        return instance;
    }

    public void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view == null) {
            imm.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
        } else {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void showProgressDialog(int messageID) {
        try {
            if (dialog == null) {
                dialog = new ProgressDialog(this);
            }
            if (!dialog.isShowing()) {
                dialog.setMessage(getString(messageID));
                dialog.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }

    public String getDeviceId() {
        return Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }
}