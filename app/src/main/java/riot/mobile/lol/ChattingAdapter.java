package riot.mobile.lol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChattingAdapter extends BaseAdapter {
    static class ListContents{
        String message;
        int type;

        public ListContents(String message,int type) {
            this.message = message;
            this.type = type;
        }
    }

    private ArrayList m_List;
    public ChattingAdapter() {
        m_List = new ArrayList();
    }

    // 외부에서 아이템 추가 요청 시 사용
    public void add(String message, int type) {
        m_List.add(new ListContents(message, type));
    }

    // 외부에서 아이템 삭제 요청 시 사용
    public void remove(int position) {
        m_List.remove(position);
    }

    @Override
    public int getCount() {
        return m_List.size();
    }

    @Override
    public Object getItem(int position) {
        return m_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        CustomHolder holder = null;
        LinearLayout layout = null;
        ImageView championImage = null;
        TextView userNickName = null;
        TextView text = null;



        // 리스트가 길어지면서 현재 화면에 보이지 않는 아이템은 converView가 null인 상태로 들어 옴
        if (convertView == null) {
            // view가 null일 경우 커스텀 레이아웃을 얻어 옴
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chat_list_item, parent, false);

            layout = (LinearLayout) convertView.findViewById(R.id.layout);
            championImage = (ImageView) convertView.findViewById(R.id.championImage);
            userNickName = (TextView) convertView.findViewById(R.id.userNickName);
            text = (TextView) convertView.findViewById(R.id.chatMessage);


            // 홀더 생성 및 Tag로 등록
            holder = new CustomHolder();
            holder.layout = layout;
            holder.championImage = championImage;
            holder.userNickName = userNickName;
            holder.text = text;
            convertView.setTag(holder);
        }
        else {
            holder = (CustomHolder) convertView.getTag();
            layout = holder.layout;
            championImage = holder.championImage;
            userNickName = holder.userNickName;
            text = holder.text;
        }

        // Text 등록
        ListContents lc = (ListContents)m_List.get(position);
        text.setText(lc.message);

        // 리스트 아이템을 터치 했을 때 이벤트 발생
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 터치 시 해당 아이템 이름 출력
                Toast.makeText(context, "리스트 클릭 : "+m_List.get(pos), Toast.LENGTH_SHORT).show();
            }
        });

        // 리스트 아이템을 길게 터치 했을때 이벤트 발생
        convertView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                // 터치 시 해당 아이템 이름 출력
                Toast.makeText(context, "리스트 롱 클릭 : "+m_List.get(pos), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return convertView;
    }

    private class CustomHolder {
        LinearLayout layout;
        ImageView championImage;
        TextView userNickName;
        TextView text;
    }
}
