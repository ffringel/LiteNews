package me.quif.litenews.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import me.quif.litenews.R;
import me.quif.litenews.SportPagerAdapter;
import me.quif.litenews.view.widget.SlidingTabLayout;

public class SportActivity extends AppCompatActivity {
    SportPagerAdapter viewPagerAdapter;
    SlidingTabLayout tabs;
    int numOfTabs = 3;
    CharSequence Titles[] = {
            "Sky Sports", "ESPN", "BBC Sport"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPagerAdapter = new SportPagerAdapter(getSupportFragmentManager(), Titles, numOfTabs);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(viewPagerAdapter);

        tabs = (SlidingTabLayout)findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.ColorPrimary);
            }
        });
        tabs.setViewPager(pager);

        initActionMenu();
    }

    private void initActionMenu() {
        FloatingActionMenu menu = (FloatingActionMenu) findViewById(R.id.menu);

        final FloatingActionButton button1 = new FloatingActionButton(this);
        button1.setButtonSize(FloatingActionButton.SIZE_MINI);
        button1.setLabelText("World News");
        button1.setImageResource(R.drawable.ic_action_news);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton button2 = new FloatingActionButton(this);
        button2.setButtonSize(FloatingActionButton.SIZE_MINI);
        button2.setLabelText("Technology");
        button2.setImageResource(R.drawable.ic_action_tech);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportActivity.this, TechActivity.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton button3 = new FloatingActionButton(this);
        button3.setButtonSize(FloatingActionButton.SIZE_MINI);
        button3.setLabelText("Politics");
        button3.setImageResource(R.drawable.ic_action_politics);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportActivity.this, PoliticsActivity.class);
                startActivity(intent);
            }
        });

        final FloatingActionButton button4 = new FloatingActionButton(this);
        button4.setButtonSize(FloatingActionButton.SIZE_MINI);
        button4.setLabelText("Entertainment");
        button4.setImageResource(R.drawable.ic_action_entertainment);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportActivity.this, EntertainmentActivity.class);
                startActivity(intent);
            }
        });

        menu.addMenuButton(button1);
        menu.addMenuButton(button2);
        menu.addMenuButton(button3);
        menu.addMenuButton(button4);

    }
}
