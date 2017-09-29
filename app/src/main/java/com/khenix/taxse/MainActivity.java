package com.khenix.taxse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.khenix.taxse.fragments.MainActionsFragment;
import com.khenix.taxse.util.DataInitializer;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.toolbar)
  Toolbar toolbar;

  @BindView(R.id.main_root)
  View mRootView;

  public static Intent createIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setupToolBar();

    //tester
    Log.d("Debug", "------- >>> ");

    // initialize data
    DataInitializer.initializeProvisionAndRequirements();
    DataInitializer.initializeFiling();


    MainActionsFragment mainActionsFragment = new MainActionsFragment();
    getFragmentManager().beginTransaction()
        .replace(R.id.layout_content, mainActionsFragment, "MainActionsFragment").commit();

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);

    return true;
  }

  void setupToolBar() {
    setSupportActionBar(toolbar);
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        return onOptionsItemSelected(item);
      }
    });
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getOrder() == 100) {
      signOut();

    }
    return true;
  }

  public void signOut() {
    AuthUI.getInstance()
        .signOut(this)
        .addOnCompleteListener(new OnCompleteListener<Void>() {
          @Override
          public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
              finish();
              startActivity(LoginActivity.createIntent(MainActivity.this));
            } else {
              showSnackbar(R.string.sign_out_failed);
            }
          }
        });
  }

  @MainThread
  private void showSnackbar(@StringRes int errorMessageRes) {
    Snackbar.make(mRootView, errorMessageRes, Snackbar.LENGTH_LONG).show();
  }
}
