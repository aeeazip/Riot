package riot.mobile.lol;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

// 실시간 채팅 페이지
public class ChattingActivity extends AppCompatActivity {
    ListView chatListView;
    ChattingAdapter chattingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        chatListView = (ListView) findViewById(R.id.chatListView);
        chattingAdapter = new ChattingAdapter();
        chatListView.setAdapter(chattingAdapter);

        // 23.03.09 : 테스트용 더미 데이터
        chattingAdapter.add("이건 뭐지",1);
        chattingAdapter.add("쿨쿨",1);
        chattingAdapter.add("쿨쿨쿨쿨",0);
        chattingAdapter.add("재미있게",1);
    }
}