package ca.bcit.ass1.le_ma;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class CountryAdapter extends ArrayAdapter<Country> {
    Context _context;
    public CountryAdapter(Context context, ArrayList<Country> contries) {
        super(context, 0, contries);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        Country country = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.Name);
        TextView tvRegion = (TextView) convertView.findViewById(R.id.Region);
        // Populate the data into the template view using the data object
        tvName.setText(country.getName());
        tvRegion.setText(country.getRegion());

        ImageView imgOnePhoto = (ImageView) convertView.findViewById(R.id.thumbImage);
        //DownloadImageTask dit = new DownloadImageTask(_context, imgOnePhoto);
        //dit.execute(toon.getPicture());
        if (country.getFlag() != null) {
            new ImageDownloaderTask(imgOnePhoto).execute(country.getFlag());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}

