package ca.bcit.ass1.le_ma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class TopLevelActivity extends AppCompatActivity {
    public static int select = 0;
    public static int cc = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        ListView list_foods = findViewById(R.id.list_continents);
        list_foods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                select = i;
                Intent intent = new Intent(TopLevelActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
