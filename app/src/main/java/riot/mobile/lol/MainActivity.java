package riot.mobile.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 23.03.02 IntroActivity Test #aeeazip
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }
}