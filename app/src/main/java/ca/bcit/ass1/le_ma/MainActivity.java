package ca.bcit.ass1.le_ma;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private ListView lv;
    // URL to get contacts JSON
    private static String SERVICE_URL = "https://restcountries.eu/rest/v2/all/";
    public static ArrayList<Country> africa;
    public static ArrayList<Country> america;
    public static ArrayList<Country> asia;
    public static ArrayList<Country> europe;
    public static ArrayList<Country> oceania;
    public static String[] continents = {"Africa", "America", "Asia", "Europe", "Oceania"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        africa = new ArrayList<Country>();
        america = new ArrayList<Country>();
        asia = new ArrayList<Country>();
        europe = new ArrayList<Country>();
        oceania = new ArrayList<Country>();
        lv = (ListView) findViewById(R.id.countryList);
        new GetContacts().execute();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TopLevelActivity.cc = i;
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }



        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    //JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray toonJsonArray = new JSONArray(jsonStr);

                    // looping through All Contacts
                    for (int i = 0; i < toonJsonArray.length(); i++) {

                        JSONObject c = toonJsonArray.getJSONObject(i);

                        String name = c.getString("name");
                        String capital = c.getString("capital");
                        String region = c.getString("region");
                        String population = c.getString("population");
                        String area = c.getString("area");
                        String borders = c.getString("borders");
                        String flag = c.getString("flag");

                        // tmp hash map for single contact
                        Country country = new Country();

                        // adding each child node to HashMap key => value
                        country.setName(name);
                        country.setCapital(capital);
                        country.setRegion(region);
                        country.setPopulation(population);
                        country.setArea(area);
                        country.setBorders(borders);
                        country.setFlag(flag);

                        // adding contact to contact list
                        if (region.equals("Africa")) {
                            africa.add(country);
                        }
                        if (region.equals("Americas")) {
                            america.add(country);
                        }
                        if (region.equals("Asia")) {
                            asia.add(country);
                        }
                        if (region.equals("Europe")) {
                            europe.add(country);
                        }
                        if (region.equals("Oceania")) {
                            oceania.add(country);
                        }


                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            //Toon[] toonArray = toonList.toArray(new Toon[toonList.size()]);
            CountryAdapter adapter = null;
            if(TopLevelActivity.select==0) {
                adapter = new CountryAdapter(MainActivity.this, africa);
            }
            if(TopLevelActivity.select==1) {
                adapter = new CountryAdapter(MainActivity.this, america);
            }
            if(TopLevelActivity.select==2) {
                adapter = new CountryAdapter(MainActivity.this, asia);
            }
            if(TopLevelActivity.select==3) {
                adapter = new CountryAdapter(MainActivity.this, europe);
            }
            if(TopLevelActivity.select==4) {
                adapter = new CountryAdapter(MainActivity.this, oceania);
            }
            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }

}
