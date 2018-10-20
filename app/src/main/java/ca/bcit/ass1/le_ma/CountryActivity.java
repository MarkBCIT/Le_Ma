package ca.bcit.ass1.le_ma;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

public class CountryActivity extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    private void setShareActionIntent(String text) {
        Intent inr = new Intent(Intent.ACTION_SEND);
        inr.setType("text/plain");
        inr.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(inr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu. This adds items to the app bar.
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        TextView name = findViewById(R.id.Name);
        setShareActionIntent(name.getText().toString());

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        // get the food from the intent
        int countryIndex = (Integer) getIntent().getExtras().get("index");
        int continentIndex = (Integer) getIntent().getExtras().get("continentIndex");
        String continent = Country.LIST_CONTINENTS[continentIndex];
        Country country = Country.continents.get(continent).get(countryIndex);

        TextView name = findViewById(R.id.Name);
        String countryName = country.getName();
        String nameText = name.getText() + " " + countryName;
        name.setText(nameText);

        TextView capital = findViewById(R.id.Capital);
        String capitalText = capital.getText() + " " + country.getCapital();
        capital.setText(capitalText);

        TextView region = findViewById(R.id.Region);
        String regionText = region.getText() + " " + country.getRegion();
        region.setText(regionText);

        TextView population = findViewById(R.id.Population);
        String populationText = population.getText() + " " + country.getPopulation();
        population.setText(populationText);

        TextView area = findViewById(R.id.Area);
        String areaText = country.getArea().equals("null") ? area.getText() + " " + "No info"
                : area.getText() + " " + country.getArea() + " km2";
        area.setText(areaText);

        TextView borders = findViewById(R.id.Borders);
        String bordersText = borders.getText() + " " + country.getBordersString();
        borders.setText(bordersText);

        WebView flag = findViewById(R.id.thumbImage);
        flag.loadUrl(country.getFlag());
        flag.getSettings().setUseWideViewPort(true);
        flag.getSettings().setLoadWithOverviewMode(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(countryName);
    }
}
