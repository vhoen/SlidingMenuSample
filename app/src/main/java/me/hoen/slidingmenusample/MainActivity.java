package me.hoen.slidingmenusample;

import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;

import java.util.ArrayList;

import me.hoen.slidingmenu.BaseActivity;
import me.hoen.slidingmenu.MenuItem;

public class MainActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSlideMenu().setCloseAfterItemSelection(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        goHome();
    }

    @Override
    protected void goHome() {
        Fragment f = new HomeFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.content_frame, f, "home").commit();
        getFragmentManager().executePendingTransactions();
    }

    @Override
    protected ArrayList<MenuItem> getSlidingMenuItems() {
        final ArrayList<MenuItem> list = new ArrayList<>();

        list.add(new MenuItem(getString(R.string.first_menu_item)));

        return list;
    }

    @Override
    protected void onSideMenuClick(MenuItem item) {
        if (item.getLabel().equals(getString(R.string.first_menu_item))) {
            Fragment f = new Item1Fragment();

            getFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, f,
                            "tag")
                    .commit();
            getFragmentManager().executePendingTransactions();
        }
    }
}
