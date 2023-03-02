package riot.mobile.lol;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// 계정 등록 화면
public class AddAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account);

        try{
            Thread.sleep(3);
        } catch(Exception e){
            e.printStackTrace();
        }

        Intent intent = new Intent(this, MainAccountActivity.class);
        startActivity(intent);
    }
}