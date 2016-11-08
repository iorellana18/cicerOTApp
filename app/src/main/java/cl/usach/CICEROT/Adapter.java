package cl.usach.CICEROT;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;


public class Adapter extends AppCompatActivity {

    TextView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        search =(TextView)findViewById(R.id.Searchmain);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Adapter.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.blue_person));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_collections_black_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_whatshot_black_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_chat_black_48dp));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TabPagerAdapter adapter = new TabPagerAdapter

                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //tab.setIcon(R.drawable.fire);---->Cambia por otro icono
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.drawable.blue_person);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.blue_collector);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.blue_hots);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.blue_mail);
                        break;
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tab.setIcon(R.mipmap.ic_person_black_48dp);
                        break;
                    case 1:
                        tab.setIcon(R.mipmap.ic_collections_black_48dp);
                        break;
                    case 2:
                        tab.setIcon(R.mipmap.ic_whatshot_black_48dp);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_chat_black_48dp);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.menu.menu_main) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}