package ca.bcit.ass1.le_ma;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoRequestActivity extends AppCompatActivity {
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
        TextView serial = findViewById(R.id.serial);
        setShareActionIntent(serial.getText().toString());

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_request);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        TextView manufacturer = findViewById(R.id.manufacturer);
        manufacturer.setText(manufacturer.getText() + " " + Build.MANUFACTURER);

        TextView model = findViewById(R.id.model);
        model.setText(model.getText() + " " + Build.MODEL);

        TextView version = findViewById(R.id.version);
        version.setText(version.getText() + " " + Build.VERSION.SDK_INT );

        TextView version_release = findViewById(R.id.version_release);
        version_release.setText(version_release.getText() + " " + Build.VERSION.RELEASE );

        TextView serial = findViewById(R.id.serial);
        serial.setText(serial.getText() + " " + Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID) );
    }
}
