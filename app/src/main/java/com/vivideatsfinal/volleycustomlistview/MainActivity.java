package com.vivideatsfinal.volleycustomlistview;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.vivideatsfinal.adapter.CustomListAdapter;
import com.vivideatsfinal.model.Events;
import com.vividseatsfinal.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Vivid Seats json url
    private static final String url = "https://webservices.vividseats.com/rest/mobile/v1/home/browse?includeSuggested=true";
    private ProgressDialog pDialog;
    private List<Events> eventList = new ArrayList<Events>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this,eventList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest clientReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Events worldEvents = new Events();

                                worldEvents.setName(obj.getString("name"));
                                worldEvents.setPerformerHeroImage(obj.getString("performerHeroImage"));
                                worldEvents.setCategoryHeroImage(obj.getString("categoryHeroImage"));
                                worldEvents.setDateDisplay(obj.getString("dateDisplay"));


                                // adding event to worldEvents array
                                eventList.add(worldEvents);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(clientReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
