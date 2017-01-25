package escapes.ismail_pc.the3mola;

import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.pushbots.push.Pushbots;


import escapes.ismail_pc.the3mola.lib.db;


public class data_home_tabs extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_home_tabs);
        Pushbots.sharedInstance().registerForRemoteNotifications();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



    }

void updaet_page(int p){

    mViewPager.setCurrentItem(p);
    mSectionsPagerAdapter.notifyDataSetChanged();

}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_home_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        public void update_mybanks() {


            ((data_home_tabs) getActivity()).updaet_page(0);

            if (myl!=null){
                com.github.rahatarmanahmed.cpv.CircularProgressView progress_view_mybanks = (com.github.rahatarmanahmed.cpv.CircularProgressView) mybanksView.findViewById(R.id.progress_view_mybanks);
                progress_view_mybanks.setVisibility(View.VISIBLE);
                myl.setAdapter(null);
            db d = new db("get_banks");
            d.thisContext = mybanksView.getContext();
            d.thisListview = myl;
            d.myparent =this;
                myl.setDivider(null);
            d.sand_data.put("pushbots_is", Pushbots.sharedInstance().getGCMRegistrationId());
            d.ListID = "code";
            d.ListImage = "image";
                d.ProgressView=progress_view_mybanks;


            d.get_data();
            }



        }


        /**
         * The fragment argument representing the section number for this
         * fragment.
         */





        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }


        boolean mybanksFill = false;
        boolean allFill = false;
        boolean min_max_Fill = false;
        View allView = null;
        View min_max_View = null;
        View mybanksView = null;

        FloatingActionButton floatingActionButton_USD;
        FloatingActionButton floatingActionButton_AED;
        FloatingActionButton floatingActionButton_EUR;
        FloatingActionButton floatingActionButton_SAR;
        FloatingActionButton floatingActionButton_KWD;
        FloatingActionButton floatingActionButton_title;
        TextView all_c_title;
        void update_btns_status(int v) {

            floatingActionButton_USD.setVisibility(v);
            floatingActionButton_AED.setVisibility(v);
            floatingActionButton_EUR.setVisibility(v);
            floatingActionButton_SAR.setVisibility(v);
            floatingActionButton_KWD.setVisibility(v);


        }
        void update_all_data(String type) {
            int img = 0;
            int title = 0;
            switch (type) {
                case "usd":
                    title = R.string.usd;
                    img = R.drawable.ic_usd;
                    break;
                case "sar":
                    title = R.string.sar;
                    img = R.drawable.ic_sar;
                    break;
                case "aed":
                    title = R.string.aed;
                    img = R.drawable.ic_aed;
                    break;
                case "eur":
                    title = R.string.eur;
                    img = R.drawable.ic_eur;
                    break;
                case "kwd":
                    title = R.string.kwd;
                    img = R.drawable.ic_kwd;
                    break;


            }
            com.github.rahatarmanahmed.cpv.CircularProgressView progress_view_all = (com.github.rahatarmanahmed.cpv.CircularProgressView) allView.findViewById(R.id.progress_view_all);
            progress_view_all.setVisibility(View.VISIBLE);
            all_c_title.setText(getString(title));
            floatingActionButton_title.setImageResource(img);
            update_btns_status(View.GONE);
            ListView l = (ListView) allView.findViewById(R.id.list_all_home);
            db d = new db("data_currency", "com_currency.type='"+type+"'");
            d.thisContext = allView.getContext();
            d.thisListview = l;
            d.myparent =this;
            d.ListImage = "image";
            d.ProgressView = progress_view_all;
            d.ListID = "code";
            d.get_data();
            allFill = true;




        }


        ViewGroup mycontainer;
        LayoutInflater myinflater;
        ListView myl;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            this.mycontainer=container;
            this.myinflater=inflater;


            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {


              //  if (!mybanksFill) {
                    mybanksView = inflater.inflate(R.layout.fragment_home_page, container, false);
                     myl = (ListView) mybanksView.findViewById(R.id.home_my_banks_list);
                    db d = new db("get_banks");
                    d.thisContext = mybanksView.getContext();
                    d.thisListview = myl;
                    d.myparent =this;
                    myl.setDivider(null);
                    d.sand_data.put("pushbots_is", Pushbots.sharedInstance().getGCMRegistrationId());
                    d.ListID = "code";
                    d.ListImage = "image";
                    d.get_data();
                    mybanksFill = true;
             //   }
                return mybanksView;


            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                if (!allFill) {

                    allView = inflater.inflate(R.layout.fragment_all_page, container, false);

                    FloatingActionButton fab = (FloatingActionButton) allView.findViewById(R.id.fab);
                    floatingActionButton_USD = (FloatingActionButton) allView.findViewById(R.id.floatingActionButton_USD);
                    floatingActionButton_AED = (FloatingActionButton) allView.findViewById(R.id.floatingActionButton_AED);
                    floatingActionButton_EUR = (FloatingActionButton) allView.findViewById(R.id.floatingActionButton_EUR);
                    floatingActionButton_SAR = (FloatingActionButton) allView.findViewById(R.id.floatingActionButton_SAR);
                    floatingActionButton_KWD = (FloatingActionButton) allView.findViewById(R.id.floatingActionButton_KWD);
                    floatingActionButton_title = (FloatingActionButton) allView.findViewById(R.id.floatingActionButton_title);
                    all_c_title = (TextView) allView.findViewById(R.id.all_c_title);
                    update_btns_status(View.GONE);
                    update_all_data("usd");
                    floatingActionButton_USD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            update_all_data("usd");

                        }
                    });


                    floatingActionButton_AED.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            update_all_data("aed");
                        }
                    });


                    floatingActionButton_EUR.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            update_all_data("eur");
                        }
                    });


                    floatingActionButton_SAR.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            update_all_data("sar");
                        }
                    });


                    floatingActionButton_KWD.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            update_all_data("kwd");

                        }
                    });

                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (floatingActionButton_USD.getVisibility() == View.VISIBLE) {
                                update_btns_status(View.GONE);
                            } else {
                                update_btns_status(View.VISIBLE);
                            }

                        }
                    });

                }
                return allView;

            } else {
                if (!min_max_Fill) {




                    min_max_View = inflater.inflate(R.layout.fragment_min_max_page, container, false);
                    ListView lmin = (ListView) min_max_View.findViewById(R.id._min_max_list);
                    com.github.rahatarmanahmed.cpv.CircularProgressView progress_view_min_max = (com.github.rahatarmanahmed.cpv.CircularProgressView) min_max_View.findViewById(R.id.progress_view_min_max);
                    progress_view_min_max.setVisibility(View.VISIBLE);

                    lmin.setDivider(null);

                    db d = new db("min_max", "com_currency.type='usd'");
                    d.thisContext = min_max_View.getContext();
                    d.thisListview = lmin;
                    d.myparent =this;
                    d.ListImage = "image";
                    d.ListID = "code";

                    d.ProgressView = progress_view_min_max;

                    d.get_data();
                    min_max_Fill = true;
                }

                return min_max_View;

            }


        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "All";
                case 2:
                    return "Min Max";
            }
            return null;
        }
    }
}
