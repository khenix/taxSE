package com.khenix.taxse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.firebase.ui.auth.AuthUI.getDefaultTheme;


public class LoginActivity extends AppCompatActivity {
  private static final int RC_SIGN_IN = 100;

  @BindView(R.id.root)
  View mRootView;

  public static Intent createIntent(Context context) {
    return new Intent(context, LoginActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    FirebaseAuth auth = FirebaseAuth.getInstance();
    if (auth.getCurrentUser() != null) {
      finish();
      goToMain();
    } else {
      signIn();
    }

  }


  public void signIn() {
    startActivityForResult(
        AuthUI.getInstance().createSignInIntentBuilder()
            .setTheme(getDefaultTheme())
            .setLogo(R.mipmap.ic_launcher)
            .setAvailableProviders(getSelectedProviders())
            .setIsSmartLockEnabled(false, false)
            .setAllowNewEmailAccounts(true)
            .build(),
        RC_SIGN_IN);
  }

  @MainThread
  private List<AuthUI.IdpConfig> getSelectedProviders() {
    List<AuthUI.IdpConfig> selectedProviders = new ArrayList<>();

    selectedProviders.add(
        new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());

    selectedProviders.add(
        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build());

    return selectedProviders;


  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == RC_SIGN_IN) {
      handleSignInResponse(resultCode, data);
    }
    showSnackbar(R.string.unknown_response);
  }

  @MainThread
  private void handleSignInResponse(int resultCode, Intent data) {
    IdpResponse response = IdpResponse.fromResultIntent(data);

    // Successfully signed in
    if (resultCode == RESULT_OK) {
      makeLog("will start the main activity " + new Gson().toJson(response));
      goToMain();
      finish();
    } else {
      // Sign in failed
      if (response == null) {
        // User pressed back button
        finish();
      } else {
        if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
          showSnackbar(R.string.no_internet_connection);
        }

        if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
          showSnackbar(R.string.unknown_error);
        }
      }

    }

  }

  private void goToMain() {
    startActivity(MainActivity.createIntent(LoginActivity.this));

  }

  @MainThread
  private void showSnackbar(@StringRes int errorMessageRes) {
    Snackbar.make(mRootView, errorMessageRes, Snackbar.LENGTH_LONG).show();
  }


  private void makeLog(String message) {
    Log.d("LoginActivity", "********----->>> " + message);
  }
}

