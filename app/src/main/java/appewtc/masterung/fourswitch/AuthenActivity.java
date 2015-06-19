package appewtc.masterung.fourswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AuthenActivity extends AppCompatActivity {

    private EditText userEditText, passEditText;
    private String userString, passString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authen);
    }   // onCreate

    public void clickLogin(View view) {

        String strUserTrue = "master";
        String strPass = "12345";

        userEditText = (EditText) findViewById(R.id.editText);
        passEditText = (EditText) findViewById(R.id.editText2);

        userString = userEditText.getText().toString().trim();
        passString = passEditText.getText().toString().trim();

        if (userString.equals(strUserTrue) && passString.equals(strPass) ) {

            Intent objIntent = new Intent(AuthenActivity.this, MainActivity.class);
            startActivity(objIntent);
            finish();

        } else {

            Toast.makeText(AuthenActivity.this, "Login False", Toast.LENGTH_SHORT).show();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_authen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
