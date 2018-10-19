package ca.bcit.ass1.le_ma;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountryList extends ListActivity {

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, CountryActivity.class);
        int continentIndex = (Integer) getIntent().getExtras().get("index");
        i.putExtra("index", (int) id);
        i.putExtra("continentIndex", continentIndex);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int continentIndex = (Integer) getIntent().getExtras().get("index");
        String continent = Country.LIST_CONTINENTS[continentIndex];
        Country[] countries = Country.continents.get(continent).toArray(new Country[Country.continents.get(continent).size()]);

        ArrayAdapter<Country> arrayAdapter = new ArrayAdapter<Country>(
                this, android.R.layout.simple_list_item_1, countries
        );

        ListView list_countries = getListView();
        list_countries.setAdapter(arrayAdapter);
    }
}
