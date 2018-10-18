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
        Country country = null;
        if (TopLevelActivity.select == 0) {
            country = MainActivity.africa.get(TopLevelActivity.cc);
        }
        if (TopLevelActivity.select == 1) {
            country = MainActivity.america.get(TopLevelActivity.cc);
        }
        if (TopLevelActivity.select == 2) {

            country = MainActivity.asia.get(TopLevelActivity.cc);
        }
        if (TopLevelActivity.select == 3) {

            country = MainActivity.europe.get(TopLevelActivity.cc);
        }
        if (TopLevelActivity.select == 4) {
            country = MainActivity.oceania.get(TopLevelActivity.cc);
        }


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
