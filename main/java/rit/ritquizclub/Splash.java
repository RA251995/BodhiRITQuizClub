package rit.ritquizclub;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Splash extends Activity {

    List<String> titleArray = null;
    List<String> detailsArray = null;
    List<String> dayArray = null;
    List<String> monthArray = null;

    ProgressBar pb;
    TextView tvLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        titleArray = new ArrayList<String>();
        detailsArray = new ArrayList<String>();
        dayArray = new ArrayList<String>();
        monthArray = new ArrayList<String>();


        pb = (ProgressBar) findViewById(R.id.pb);
        tvLoad = (TextView) findViewById(R.id.tvLoad);

        new JSONParse().execute("http://ritquizclub.netne.net/quiz/index.php");

    }

    private class JSONParse extends AsyncTask<String, String, Boolean> {
        boolean result = false;

        @Override
        protected void onPreExecute() {


            super.onPreExecute();

            pb.setVisibility(View.VISIBLE);

        }

        @Override
        protected Boolean doInBackground(String... args) {
            JSONParser jParser = new JSONParser();
            String url = args[0];
            // Getting JSON from URL
            JSONArray json = jParser.getJSONFromUrl(url);
            try {
                // Getting JSON Array

                for (int i = 0; i < json.length(); i++) {
                    JSONObject c = json.getJSONObject(i);

                    // Storing  JSON item in a Variable
                    String title = c.getString("title");
                    String details = c.getString("details");
                    String date = c.getString("eventdate");
                    String splitdate[] = date.split("-");
                    titleArray.add(title);
                    detailsArray.add(details);
                    dayArray.add(splitdate[2]);
                    monthArray.add(getMonthStr(splitdate[1]));

                }
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean res) {

            tvLoad.setText("");
            pb.setVisibility(View.GONE);

            if (res == true) {
                ((MyApplication) Splash.this.getApplication()).setArrays(titleArray, detailsArray, dayArray, monthArray);
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            } else {
                tvLoad.setText("NETWORK ERROR");
            }
        }

        private String getMonthStr(String s) {
            int monthInt = Integer.parseInt(s);
            String result = "";
            switch (monthInt) {
                case 1:
                    result = "January";
                    break;
                case 2:
                    result = "February";
                    break;
                case 3:
                    result = "March";
                    break;
                case 4:
                    result = "April";
                    break;
                case 5:
                    result = "May";
                    break;
                case 6:
                    result = "June";
                    break;
                case 7:
                    result = "July";
                    break;
                case 8:
                    result = "August";
                    break;
                case 9:
                    result = "September";
                    break;
                case 10:
                    result = "October";
                    break;
                case 11:
                    result = "November";
                    break;
                case 12:
                    result = "December";
                    break;
            }
            return result;
        }
    }
}



