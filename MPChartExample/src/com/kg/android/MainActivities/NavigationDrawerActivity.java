package com.kg.android.MainActivities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import com.kg.android.Classes.GaugeView;
import com.kg.android.R;
import com.kg.android.custom.MyMarkerView;
import com.kg.android.listviewitems.BarChartItem;
import com.kg.android.listviewitems.ChartItem;
import com.kg.android.listviewitems.LineChartItem;
import com.kg.android.listviewitems.PieChartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NavigationDrawerActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
static String TAG=NavigationDrawerActivity.class.getSimpleName();
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    static BarChart mChart=null;
    static SeekBar mSeekBarX, mSeekBarY = null;
    static TextView tvX, tvY;

    final CountDownTimer mTimer = null;
   static GaugeView mGaugeView1,mGaugeView2,mGaugeView3;
    static Random RAND = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
          if(position==0)
        {
            Log.e(TAG,"::"+position);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
          else if(position==1)
        {
          Log.e(TAG,"::"+position);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
        else  if(position==2)
        {
            Log.e(TAG,"::"+position);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
        else  if(position==3)
        {
            Log.e(TAG,"::"+position);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
        else  if(position==4)
        {
            Log.e(TAG,"::"+position);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }
        else  if(position==5)
        {
            Log.e(TAG,"::"+position);
            fragmentManager.beginTransaction()
                    .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                    .commit();
        }


    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);

                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
         static int activityNumber=0;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(final int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            activityNumber=sectionNumber;
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;
            Log.e(TAG,"Number::"+activityNumber);
            if(activityNumber==1)
            {
                rootView  = inflater.inflate(R.layout.activity_listview_chart, container, false);
                ListView lv = (ListView) rootView.findViewById(R.id.listView1);

                ArrayList<ChartItem> list = new ArrayList<ChartItem>();
                // 30 items
                for (int i = 0; i < 3; i++) {

                    if(i % 3 == 0) {
                        list.add(new LineChartItem(generateDataLine(i + 1), getActivity()));
                    } else if(i % 3 == 1) {
                        list.add(new BarChartItem(generateDataBar(i + 1), getActivity()));
                    } else if(i % 3 == 2) {
                        list.add(new PieChartItem(generateDataPie(i + 1), getActivity()));
                    }
                }
                ChartDataAdapter cda = new ChartDataAdapter(getActivity(), list);
                lv.setAdapter(cda);


            }
            else if(activityNumber==2)
            {


                rootView = inflater.inflate(R.layout.activity_barchart, container, false);

                tvX = (TextView) rootView.findViewById(R.id.tvXMax);
                tvY = (TextView) rootView.findViewById(R.id.tvYMax);

                mSeekBarX = (SeekBar) rootView.findViewById(R.id.seekBar1);
                mSeekBarX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        tvX.setText("" + (mSeekBarX.getProgress() + 1));
                        tvY.setText("" + (mSeekBarY.getProgress()));

                        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

                        for (int i = 0; i < mSeekBarX.getProgress() + 1; i++) {
                            float mult = (mSeekBarY.getProgress() + 1);
                            float val = (float) (Math.random() * mult) + mult / 3;
                            yVals1.add(new BarEntry(i, val));
                        }

                        BarDataSet set1;

                        if (mChart.getData() != null &&
                                mChart.getData().getDataSetCount() > 0) {
                            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
                            set1.setValues(yVals1);
                            mChart.getData().notifyDataChanged();
                            mChart.notifyDataSetChanged();
                        } else {
                            set1 = new BarDataSet(yVals1, "Data Set");
                            set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
                            set1.setDrawValues(false);

                            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                            dataSets.add(set1);

                            BarData data = new BarData(dataSets);
                            mChart.setData(data);
                            mChart.setFitBars(true);
                        }

                        mChart.invalidate();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Log.e(TAG, "onStartTrackingTouch::" + seekBar);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Log.e(TAG, "onStopTrackingTouch::" + seekBar);
                    }
                });

                mSeekBarY = (SeekBar) rootView.findViewById(R.id.seekBar2);
                mSeekBarY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        tvX.setText("" + (mSeekBarX.getProgress() + 1));
                        tvY.setText("" + (mSeekBarY.getProgress()));

                        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

                        for (int i = 0; i < mSeekBarX.getProgress() + 1; i++) {
                            float mult = (mSeekBarY.getProgress() + 1);
                            float val = (float) (Math.random() * mult) + mult / 3;
                            yVals1.add(new BarEntry(i, val));
                        }

                        BarDataSet set1;

                        if (mChart.getData() != null &&
                                mChart.getData().getDataSetCount() > 0) {
                            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
                            set1.setValues(yVals1);
                            mChart.getData().notifyDataChanged();
                            mChart.notifyDataSetChanged();
                        } else {
                            set1 = new BarDataSet(yVals1, "Data Set");
                            set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
                            set1.setDrawValues(false);

                            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
                            dataSets.add(set1);

                            BarData data = new BarData(dataSets);
                            mChart.setData(data);
                            mChart.setFitBars(true);
                        }

                        mChart.invalidate();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Log.e(TAG, "onStartTrackingTouch::" + seekBar);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Log.e(TAG, "onStopTrackingTouch::" + seekBar);
                    }
                });

                mChart = (BarChart) rootView.findViewById(R.id.chart1);

                mChart.getDescription().setEnabled(false);

                // if more than 60 entries are displayed in the chart, no values will be
                // drawn
                mChart.setMaxVisibleValueCount(60);

                // scaling can now only be done on x- and y-axis separately
                mChart.setPinchZoom(false);

                mChart.setDrawBarShadow(false);
                mChart.setDrawGridBackground(false);

                XAxis xAxis = mChart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                xAxis.setDrawGridLines(false);

                mChart.getAxisLeft().setDrawGridLines(false);

                // setting data
                mSeekBarX.setProgress(10);
                mSeekBarY.setProgress(100);

                // add a nice and smooth animation
                mChart.animateY(700);

                mChart.getLegend().setEnabled(false);

            }
            else if(activityNumber==3)
            {
                rootView = inflater.inflate(R.layout.list_item_piechart, container, false);
                PieChart pieChart = (PieChart) rootView.findViewById(R.id.chart);


                float mult = 100;
                 String[] mParties = new String[] {
                        "Company A", "Company B", "Company C", "Company D", "Company E", "Company F", "Company G", "Company H",
                        "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
                        "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
                        "Party Y", "Party Z"
                };
                ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
                for (int i = 0; i < 4 ; i++) {
                    entries.add(new PieEntry((float) ((Math.random() * mult) + mult / 5), mParties[i % mParties.length]));
                }
                PieDataSet dataSet = new PieDataSet(entries,"Quarter Results");

                ArrayList<Integer> colors = new ArrayList<Integer>();

                for (int c : ColorTemplate.VORDIPLOM_COLORS_SAMPLE)
                    colors.add(c);

                for (int c : ColorTemplate.JOYFUL_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.COLORFUL_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.LIBERTY_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.PASTEL_COLORS)
                    colors.add(c);

                colors.add(ColorTemplate.getHoloBlue());

                dataSet.setColors(colors);

                PieData data = new PieData( dataSet);

                data.setValueFormatter(new PercentFormatter());
                data.setValueTextSize(11f);
                data.setValueTextColor(Color.WHITE);
              //  data.setValueTypeface(mTfLight);
               pieChart.getDescription().setEnabled(false);
                pieChart.setData(data);

                pieChart.animateY(700);
            }
            else if(activityNumber==4)
            {
                rootView = inflater.inflate(R.layout.line_chart_layout, container, false);
                LineChart mChart = (LineChart) rootView.findViewById(R.id.chart1);
                mChart.getDescription().setEnabled(false);
                MyMarkerView mv = new MyMarkerView(getActivity(), R.layout.custom_marker_view);
                mv.setChartView(mChart); // For bounds control
                mChart.setMarker(mv); // Set the marker to the chart

                // x-axis limit line
                LimitLine llXAxis = new LimitLine(10f, "Index 10");
                llXAxis.setLineWidth(4f);
                llXAxis.enableDashedLine(10f, 10f, 0f);
                llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                llXAxis.setTextSize(10f);

                XAxis xAxis = mChart.getXAxis();
                xAxis.enableGridDashedLine(10f, 10f, 0f);
                Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");

                /*LimitLine ll1 = new LimitLine(150f, "Upper Limit");
                ll1.setLineWidth(4f);
                ll1.enableDashedLine(10f, 10f, 0f);
                ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                ll1.setTextSize(10f);
                ll1.setTypeface(tf);

                LimitLine ll2 = new LimitLine(-30f, "Lower Limit");
                ll2.setLineWidth(4f);
                ll2.enableDashedLine(10f, 10f, 0f);
                ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
                ll2.setTextSize(10f);
                ll2.setTypeface(tf);*/

                YAxis leftAxis = mChart.getAxisLeft();
                leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
                //  leftAxis.addLimitLine(ll1);
                // leftAxis.addLimitLine(ll2);
                leftAxis.setAxisMaximum(200f);
                leftAxis.setAxisMinimum(-50f);
                //leftAxis.setYOffset(20f);
                leftAxis.enableGridDashedLine(10f, 10f, 0f);
                leftAxis.setDrawZeroLine(false);

                // limit lines are drawn behind data (and not on top)
                leftAxis.setDrawLimitLinesBehindData(true);

                mChart.getAxisRight().setEnabled(false);

                //mChart.getViewPortHandler().setMaximumScaleY(2f);
                //mChart.getViewPortHandler().setMaximumScaleX(2f);

                // add data
                setData(5, 100,mChart);

//        mChart.setVisibleXRange(20);
//        mChart.setVisibleYRange(20f, AxisDependency.LEFT);
//        mChart.centerViewTo(20, 50, AxisDependency.LEFT);

                mChart.animateX(700);

            }
            else if(activityNumber==5)
            {
                ProgressDialog pd;

                 rootView = inflater.inflate(R.layout.web_view_layout, container, false);

                WebView webChart= (WebView) rootView.findViewById(R.id.web_view);
                webChart.getSettings().setJavaScriptEnabled(true);
                webChart.getSettings().setDomStorageEnabled(true);
                pd = new ProgressDialog(getActivity());
                pd.setMessage(getString(R.string.PLEASE_WAIT));
                pd.show();
               // String url="https://in.yahoo.com/";
                String url="http://www.femkekooij.nl/swf/financial_dashboard.gif";
                startWebView(url,webChart,pd);


            }
            else if(activityNumber==6)
            {


                rootView = inflater.inflate(R.layout.dummy, container, false);
                   mGaugeView1 = (GaugeView) rootView.findViewById(R.id.gauge_view1);
                   mGaugeView2 = (GaugeView) rootView.findViewById(R.id.gauge_view2);
                  mGaugeView3 = (GaugeView) rootView.findViewById(R.id.gauge_view3);
                final TextView revenue= (TextView) rootView.findViewById(R.id.tv_revenue);
                final TextView revenue2= (TextView) rootView.findViewById(R.id.tv_revenue2);
                final TextView revenue3= (TextView) rootView.findViewById(R.id.tv_revenue3);
                SeekBar seekBarView1= (SeekBar) rootView.findViewById(R.id.seekBar1);
              final  SeekBar seekBarView2= (SeekBar) rootView.findViewById(R.id.seekBar2);
              final  SeekBar seekBarView3= (SeekBar) rootView.findViewById(R.id.seekBar3);

                mGaugeView1.setTargetValue(13);
                mGaugeView2.setTargetValue(33);
                mGaugeView3.setTargetValue(55);
                seekBarView1.setProgress(13);
                seekBarView2.setProgress(33);
                seekBarView3.setProgress(55);
                revenue.setText("13");
                revenue2.setText("33");
                revenue3.setText("55");
                seekBarView1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int test=13;
                        progress=progress-test;
                        revenue.setText(""+progress);
                        revenue2.setText(""+(33+progress));
                        revenue3.setText(""+(55+progress));
                            mGaugeView1.setTargetValue(progress);
                            mGaugeView2.setTargetValue((33 + progress));
                            mGaugeView3.setTargetValue((55 + progress));

                            seekBarView2.setProgress((33 + progress));
                            seekBarView3.setProgress((55 + progress));

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
             //   mGaugeView1 = (GaugeView) rootView.findViewById(R.id.gauge_view1);
             //   mGaugeView2 = (GaugeView) rootView.findViewById(R.id.gauge_view2);
              //  mGaugeView3 = (GaugeView) rootView.findViewById(R.id.gauge_view3);
             //   mTimer.start();
            }
            


            return rootView;

        }
        private final CountDownTimer mTimer = new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(final long millisUntilFinished) {
                mGaugeView1.setTargetValue(RAND.nextInt(101));
               // mGaugeView2.setTargetValue(RAND.nextInt(101));
              //  mGaugeView3.setTargetValue(RAND.nextInt(101));
            }

            @Override
            public void onFinish() {}
        };

        private void startWebView(String urlLink, WebView landingWebview, final ProgressDialog pd) {
            //Create new landingWebview Client to show progress dialog
            //When opening a url or click on link

            landingWebview.setWebViewClient(new WebViewClient() {

                //If you will not use this method url links are opeen in new brower not in landingWebview
                public boolean shouldOverrideUrlLoading(WebView view, String urlLink) {
                    try {
                        view.loadUrl(urlLink);
                        if (!pd.isShowing()) {
                            pd.show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }

                //Show loader on url load
                public void onLoadResource(WebView view, String urlLink) {
               /* if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(con);
                    progressDialog.setMessage("Loading...");
                  //    progressDialog.show();
                }*/
                }

                public void onPageFinished(WebView view, String urlLink) {
                    try {
                        System.out.println("on finish");
                        if (pd.isShowing()) {
                            pd.dismiss();
                        }
                   /* if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }*/
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }

            });

            // Javascript inabled on landingWebview
            landingWebview.getSettings().setJavaScriptEnabled(true);

            // Other landingWebview options
        /*
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);
        */

        /*
         String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         landingWebview.loadData(summary, "text/html", null);
         */

            //Load url in webviewview
            //landingWebview.clearHistory();
            landingWebview.reload();
            landingWebview.loadUrl(urlLink);
        }

        private void setData(int count, int range, LineChart mChart) {

            ArrayList<Entry> values = new ArrayList<Entry>();

            for (int i = 0; i < count; i++) {

                float val = (float) (Math.random() * range) + 3;
                if(i==0) {
                    values.add(new Entry(2015, val));
                }
                else if(i==1) {
                    values.add(new Entry(2016,val));
                }
                else if(i==2) {
                    values.add(new Entry(2017,val));
                }
                else if(i==3) {
                    values.add(new Entry(2018,val));
                }
                else if(i==4) {
                    values.add(new Entry(2019,val));
                }

            }

            LineDataSet set1;

            if (mChart.getData() != null &&
                    mChart.getData().getDataSetCount() > 0) {
                set1 = (LineDataSet)mChart.getData().getDataSetByIndex(0);
                set1.setValues(values);
                mChart.getData().notifyDataChanged();
                mChart.notifyDataSetChanged();
            } else {
                // create a dataset and give it a type
                set1 = new LineDataSet(values, "DataSet 1");

                // set the line to be drawn like this "- - - - - -"
                set1.enableDashedLine(10f, 5f, 0f);
                set1.enableDashedHighlightLine(10f, 5f, 0f);
                set1.setColor(Color.BLACK);
                set1.setCircleColor(Color.BLACK);
                set1.setLineWidth(1f);
                set1.setCircleRadius(3f);
                set1.setDrawCircleHole(false);
                set1.setValueTextSize(9f);
                set1.setDrawFilled(true);
                set1.setFormLineWidth(1f);
                set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
                set1.setFormSize(15.f);

                if (Utils.getSDKInt() >= 18) {
                    // fill drawable only supported on api level 18 and above
                    Drawable drawable = ContextCompat.getDrawable(getActivity(), R.drawable.fade_red);
                    set1.setFillDrawable(drawable);
                }
                else {
                    set1.setFillColor(Color.BLACK);
                }

                ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
                dataSets.add(set1); // add the datasets

                // create a data object with the datasets
                LineData data = new LineData(dataSets);

                // set data
                mChart.setData(data);
            }
        }

        private class ChartDataAdapter extends ArrayAdapter<ChartItem> {

            public ChartDataAdapter(Context context, List<ChartItem> objects) {
                super(context, 0, objects);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                return getItem(position).getView(position, convertView, getContext());
            }

            @Override
            public int getItemViewType(int position) {
                // return the views type

                return getItem(position).getItemType();
            }

            @Override
            public int getViewTypeCount() {
                return 3; // we have 3 different item-types
            }
        }
        private LineData generateDataLine(int cnt) {

            ArrayList<Entry> e1 = new ArrayList<Entry>();

            for (int i = 0; i < 12; i++) {
                e1.add(new Entry(i, (int) (Math.random() * 65) + 40));
            }

            LineDataSet d1 = new LineDataSet(e1, "Year 2015 "+ ", (1)");
            d1.setLineWidth(2.5f);
            d1.setCircleRadius(4.5f);
            d1.setHighLightColor(Color.rgb(244, 117, 117));
            d1.setDrawValues(false);

            ArrayList<Entry> e2 = new ArrayList<Entry>();

            for (int i = 0; i < 12; i++) {
                e2.add(new Entry(i, e1.get(i).getY() - 30));
            }

            LineDataSet d2 = new LineDataSet(e2, "Year 2016 "+", (2)");
            d2.setLineWidth(2.5f);
            d2.setCircleRadius(4.5f);
            d2.setHighLightColor(Color.rgb(244, 117, 117));
            d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
            d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
            d2.setDrawValues(false);

            ArrayList<ILineDataSet> sets = new ArrayList<ILineDataSet>();
            sets.add(d1);
            sets.add(d2);

            LineData cd = new LineData(sets);
            return cd;
        }
        private BarData generateDataBar(int cnt) {

            ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

              final String[] mL = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String test="";
            for (int i = 0; i < 12; i++) {
                if(i==0)
                {
                    test+=mL[i];
                }
                else
                {
                    test+=", "+mL[i];
                }

                entries.add(new BarEntry(i, (int) (Math.random() * 70) + 30));
            }

            BarDataSet d = new BarDataSet(entries, "Months : "+test);
            d.setColors(ColorTemplate.VORDIPLOM_COLORS);
            d.setHighLightAlpha(255);

            BarData cd = new BarData(d);
            cd.setBarWidth(0.9f);
            return cd;
        }

        /**
         * generates a random ChartData object with just one DataSet
         *
         * @return
         */
        private PieData generateDataPie(int cnt) {

            ArrayList<PieEntry> entries = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                entries.add(new PieEntry((float) ((Math.random() * 70) + 30), "Quarter " + (i+1)));
            }

            PieDataSet d = new PieDataSet(entries, "");

            // space between slices
            d.setSliceSpace(2f);
            d.setColors(ColorTemplate.VORDIPLOM_COLORS_SAMPLE);

            PieData cd = new PieData(d);
            return cd;
        }
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((NavigationDrawerActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }



}
