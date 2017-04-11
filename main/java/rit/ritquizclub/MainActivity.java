package rit.ritquizclub;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private EventsListAdapter mAdapter;

    List<String> titleArray = null;
    List<String> detailsArray = null;
    List<String> dayArray = null;
    List<String> monthArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        setContentView(R.layout.activity_main);
        titleArray = ((MyApplication) this.getApplication()).getTitleArray();
        detailsArray = ((MyApplication) this.getApplication()).getDetailsArray();
        dayArray = ((MyApplication) this.getApplication()).getDayArray();
        monthArray = ((MyApplication) this.getApplication()).getMonthArray();

        mRecyclerView = (RecyclerView) findViewById(R.id.rvlist);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        mAdapter = new EventsListAdapter(MainActivity.this, titleArray, detailsArray, dayArray, monthArray);
        mRecyclerView.setAdapter(mAdapter);
    }

}
