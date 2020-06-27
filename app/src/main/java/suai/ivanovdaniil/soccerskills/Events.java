package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Events extends AppCompatActivity
{
    public int Events_Count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);

        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

        TextView ToolBar_Title = getSupportActionBar().getCustomView().findViewById(R.id.ActionBar_Title);
        ImageView ToolBar_CalendarItem = getSupportActionBar().getCustomView().findViewById(R.id.Calendar_Item);
        ImageView ToolBar_SearchItem = getSupportActionBar().getCustomView().findViewById(R.id.Search_Item);
        ToolBar_Title.setText("Events");

        ToolBar_CalendarItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Calendar!", Toast.LENGTH_LONG).show();
            }
        });

        ToolBar_SearchItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Search!", Toast.LENGTH_LONG).show();
            }
        });

        LinearLayout[] Events =
                {
                        findViewById(R.id.Event_1),
                        findViewById(R.id.Event_2),
                        findViewById(R.id.Event_3),
                        findViewById(R.id.Event_4)
                };

        Fill_Event("18", "Fri",
                "Spartak M - Zenit", "12:00", Events, 0);
        Fill_Event("19", "Sat",
                "Tomsk = Rostov", "12:00", Events, 1);
        Fill_Event("19", "Sat",
                "Ural - Rubin", "12:00", Events, 2);
        Fill_Event("20", "Mon",
                "Arsenal - CSKA", "12:00", Events, 3);


    }

    public void Fill_Event(String EventDay_Text, String EventDayOfWeek_Text,
                           String EventTeams_Text, String EventTime_Text,
                           LinearLayout[] events, int event_id)
    {
        TextView EventDay, EventDayOfWeek, EventTeams, EventTime;

        EventDay = events[event_id].findViewById(R.id.EventDay_Text);
        EventDayOfWeek = events[event_id].findViewById(R.id.EventDayOfWeek_Text);
        EventTeams = events[event_id].findViewById(R.id.Teams_Text);
        EventTime = events[event_id].findViewById(R.id.Time_Text);

        EventDay.setText(EventDay_Text); EventDayOfWeek.setText(EventDayOfWeek_Text);
        EventTeams.setText(EventTeams_Text); EventTime.setText(EventTime_Text);
    }
}
