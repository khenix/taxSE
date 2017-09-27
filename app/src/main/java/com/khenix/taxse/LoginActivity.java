package com.khenix.taxse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

import static com.firebase.ui.auth.AuthUI.getDefaultTheme;


public class LoginActivity extends AppCompatActivity {
  private static final int RC_SIGN_IN = 100;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    FirebaseAuth auth = FirebaseAuth.getInstance();
    if (auth.getCurrentUser() != null) {
      makeLog("logged in ");
      finish();
      startActivity(new Intent(this, MainActivity.class));

    } else {
      makeLog("logged out ");
      signIn();

    }

  }

  void makeLog(String message) {
    Log.d("LoginActivity", "********----->>> " + message);
  }

  public void signIn() {
    startActivityForResult(
        AuthUI.getInstance().createSignInIntentBuilder()
            .setTheme(getDefaultTheme())
            .setLogo(R.mipmap.ic_launcher)
            .setAvailableProviders(getSelectedProviders())
            .setIsSmartLockEnabled(true, true)
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


}

