package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EventsCalendar extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_calendar);

        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

        TextView ToolBar_Title = getSupportActionBar().getCustomView().findViewById(R.id.ActionBar_Title);
        ImageView ToolBar_CalendarItem = getSupportActionBar().getCustomView().findViewById(R.id.Left_Toolbar_Item);
        ImageView ToolBar_SearchItem = getSupportActionBar().getCustomView().findViewById(R.id.Right_Toolbar_Item);
        TextView ToolBar_RightText_Item  = getSupportActionBar().getCustomView().findViewById(R.id.RightText_Item);
        TextView ToolBar_LeftText_Item  = getSupportActionBar().getCustomView().findViewById(R.id.LeftText_Item);
        ToolBar_Title.setText("Calendary");
        ToolBar_RightText_Item.setVisibility(View.GONE); ToolBar_LeftText_Item.setVisibility(View.GONE);
        ToolBar_CalendarItem.setVisibility(View.GONE); ToolBar_SearchItem.setVisibility(View.GONE);

        findViewById(R.id.Events_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(EventsCalendar.this, Events.class);
                startActivity(intent); finish();
            }
        });

        Button AddEvent_Button = findViewById(R.id.AddEvent_Button);
        AddEvent_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(EventsCalendar.this, NewEvent.class);
                startActivity(intent); finish();
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(flags);
    }
}
