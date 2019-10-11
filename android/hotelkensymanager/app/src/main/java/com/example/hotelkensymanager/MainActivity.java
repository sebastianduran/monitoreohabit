package com.example.hotelkensymanager;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public FloatingActionButton importFab,exportFab,expenseFab;
    public Intent intent;
    String mon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        importFab = (FloatingActionButton) findViewById(R.id.importFab);
        exportFab = (FloatingActionButton) findViewById(R.id.exportFab);
        expenseFab = (FloatingActionButton) findViewById(R.id.expenseFab);

        importFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HomeActivity.this,"Import Button clicked",Toast.LENGTH_SHORT).show();

                intent = new Intent(MainActivity.this,ImportEditorActivity.class);
                startActivity(intent);
            }
        });

        exportFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HomeActivity.this,"Export Button Clicked",Toast.LENGTH_SHORT).show();

                intent = new Intent(MainActivity.this, ExportEditorActivity.class);
                startActivity(intent);

            }
        });

        expenseFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HomeActivity.this,"Expense Button Clicked",Toast.LENGTH_SHORT).show();

                intent = new Intent(MainActivity.this, ExpenseEditorActivity.class);
                startActivity(intent);

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                animateFab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                animateFab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // trying to achieve movement

    /*    viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){

                    case MotionEvent.ACTION_DOWN:

                        toolbar.showOverflowMenu();
                        break;
                    case MotionEvent.ACTION_UP:
                        toolbar.hideOverflowMenu();
                        break;
                }

                return false;
            }
        });*/

    }

    private void animateFab(int position) {
        switch (position) {
            case 0:
                expenseFab.hide();
                exportFab.hide();
                importFab.show();
                break;
            case 1:
                expenseFab.hide();
                importFab.hide();
                exportFab.show();
                break;
            case 2:
                exportFab.hide();
                importFab.hide();
                expenseFab.show();
                break;
            case 3:
                exportFab.hide();
                importFab.hide();
                expenseFab.hide();
                break;
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        MainActivity.ViewPagerAdapter adapter = new MainActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ImportFragment(), "Ocupadas");
        adapter.addFragment(new ExportFragment(), "Reservas");
        adapter.addFragment(new ExpenseFragment(), "CheckOut");
        adapter.addFragment(new ReportFragment(), "Aseo");
        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
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

        public void addFragment(ImportFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public void addFragment(ExportFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public void addFragment(ExpenseFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public void addFragment(ReportFragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // getSupportFragmentManager().beginTransaction().detach().attach(exportFragment).commit();
        //Toast.makeText(this,"Retsrt",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_items, menu);

        MenuItem item = menu.getItem(1);

        // Todays date

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate= dateFormat.format(c.getTime());
        int day = c.get(Calendar.DAY_OF_WEEK);

        switch (day){
            case Calendar.SUNDAY:
                mon =", Dom";
                item.setTitle(formatedDate+mon);
                break;
            case Calendar.MONDAY:
                mon =", Lun";
                item.setTitle(formatedDate + mon);
                break;
            case Calendar.TUESDAY:
                mon =", Mar";
                item.setTitle(formatedDate + mon);
                break;
            case Calendar.WEDNESDAY:
                mon =", Mie";
                item.setTitle(formatedDate+mon);
                break;
            case Calendar.THURSDAY:
                mon =", Jue";
                item.setTitle(formatedDate + mon);
                break;
            case Calendar.FRIDAY:
                mon =", Vie";
                item.setTitle(formatedDate + mon);
                break;
            case Calendar.SATURDAY:
                mon =", Sab";
                item.setTitle(formatedDate + mon);
                break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.exit:
                //  finishAffinity();
                finish();
                return true;
            /*case R.id.getReport:
                Toast.makeText(HomeActivity.this,"Report Generated.",Toast.LENGTH_SHORT).show();
                return true; */
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("¿Desea salir?")
                .setMessage("¿Realmente desea salir de la aplicacion?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }
}

