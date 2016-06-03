package juliensere.calendrierdechets.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import juliensere.calendrierdechets.R;
import juliensere.calendrierdechets.models.Ville;

public class MainActivity extends AppCompatActivity {

    public final static String VILLE_PARAM = "juliensere.VILLE_PARAM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Called when the user clicks the Send button
     */
    public void selectZone(View view) {
        Intent intent = new Intent(this, ZoneSelectionActivity.class);
        Ville ville = Ville.LUNION;
        intent.putExtra(VILLE_PARAM, ville);
        startActivity(intent);
    }

    public void configurerNotification(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void changerZone(View view) {
        Intent intent = new Intent(this, ZoneSelectionActivity.class);
        Ville ville = Ville.LUNION;

        intent.putExtra(VILLE_PARAM, ville);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actionSettings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
