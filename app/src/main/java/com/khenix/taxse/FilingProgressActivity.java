package com.khenix.taxse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.khenix.taxse.fragments.PayerTypeAFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by kestrella on 9/29/17.
 */

public class FilingProgressActivity extends AppCompatActivity {
  @BindView(R.id.viewpagerApplicant)
  ViewPager viewPager;

  @BindView(R.id.indicator)
  CircleIndicator indicator;

  PayerTypeAFragment payerTypeAFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.filing_progress_layout);
    ButterKnife.bind(this);
    setupViewPager();
    indicator.setViewPager(viewPager);
  }

  private void setupViewPager() {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    payerTypeAFragment = new PayerTypeAFragment();
    adapter.addFragment(payerTypeAFragment, "Step 1");
    viewPager.setAdapter(adapter);
  }

  private class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    ViewPagerAdapter(FragmentManager manager) {
      super(manager);
    }

    @Override
    public Fragment getItem(int position) {
      return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
      return mFragmentList.size();
    }

    void addFragment(Fragment fragment, String title) {
      mFragmentList.add(fragment);
      mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return mFragmentTitleList.get(position);
    }
  }
}
