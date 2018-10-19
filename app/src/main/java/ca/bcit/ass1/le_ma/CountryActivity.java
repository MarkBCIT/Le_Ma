package ca.bcit.ass1.le_ma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        ImageView imgOnePhoto = (ImageView) findViewById(R.id.thumbImage);
        //DownloadImageTask dit = new DownloadImageTask(_context, imgOnePhoto);
        //dit.execute(toon.getPicture());
        if (country.getFlag() != null) {
            new ImageDownloaderTask(imgOnePhoto).execute(country.getFlag());
        }

        TextView name = findViewById(R.id.Name);
        name.setText(country.getName());

        TextView region = findViewById(R.id.Region);
        region.setText(country.getRegion());

        TextView pop = findViewById(R.id.Population);
        pop.setText(country.getPopulation());

        TextView area = findViewById(R.id.Area);
        area.setText(country.getArea());

        TextView borders = findViewById(R.id.Borders);
        borders.setText(country.getBorders());
    }
}
