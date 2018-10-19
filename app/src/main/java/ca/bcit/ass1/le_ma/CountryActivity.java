package ca.bcit.ass1.le_ma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        // get the food from the intent
        int countryIndex = (Integer) getIntent().getExtras().get("index");
        int continentIndex = (Integer) getIntent().getExtras().get("continentIndex");
        String continent = Country.LIST_CONTINENTS[continentIndex];
        Country country = Country.continents.get(continent).get(countryIndex);

        //DownloadImageTask dit = new DownloadImageTask(_context, imgOnePhoto);
        //dit.execute(toon.getPicture());

        TextView name = findViewById(R.id.Name);
        name.setText(name.getText() + " " + country.getName());

        TextView capital = findViewById(R.id.Capital);
        capital.setText(capital.getText() + " " + country.getCapital());

        TextView region = findViewById(R.id.Region);
        region.setText(region.getText() + " " + country.getRegion());

        TextView population = findViewById(R.id.Population);
        population.setText(population.getText() + " " + country.getPopulation());

        TextView area = findViewById(R.id.Area);
        area.setText(area.getText() + " " + country.getArea());

        TextView borders = findViewById(R.id.Borders);
        borders.setText(borders.getText() + " " + country.getBorders());

        WebView flag = findViewById(R.id.thumbImage);
        flag.loadUrl(country.getFlag());
        flag.setInitialScale(80);
    }
}
