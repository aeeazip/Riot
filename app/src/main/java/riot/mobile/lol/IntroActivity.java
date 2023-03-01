package riot.mobile.lol;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        try{
            Thread.sleep(5);
        } catch(Exception e){
            e.printStackTrace();
        }

        Intent intent = new Intent(this, AddAccountActivity.class);
        startActivity(intent);

    }
}