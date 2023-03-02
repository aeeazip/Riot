package riot.mobile.lol;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

// 메인 페이지 (알림 비활성화)
public class MainAccountActivity extends AppCompatActivity {
    private ImageView lowwerScroll;
    private Dialog removeAccountDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_account);

        lowwerScroll = findViewById(R.id.lowwerScroll);

        removeAccountDialog = new Dialog(this);                          // Dialog 초기화
        removeAccountDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);      // 타이틀 제거
        removeAccountDialog.setContentView(R.layout.remove_account_dialog);
    }

    // 아래로 스크롤 : 계정 삭제 Dialog 창 띄우기
    public void onClick(View v){
        switch(v.getId()){
            case R.id.lowwerScroll:
                removeAccountDialog.show();      // Dialog 띄우기

                // 아니요 버튼
                removeAccountDialog.findViewById(R.id.noButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        removeAccountDialog.dismiss();       // 다이얼로그 닫기
                    }
                });

                // 예 버튼
                removeAccountDialog.findViewById(R.id.yesButton).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 계정 삭제 API 연결
                        finish();
                    }
                });

        }
    }
}