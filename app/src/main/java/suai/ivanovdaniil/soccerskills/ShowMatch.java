package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class ShowMatch extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_match);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

        TextView ToolBar_Title = getSupportActionBar().getCustomView().findViewById(R.id.ActionBar_Title);
        ImageView ToolBar_LeftItem = getSupportActionBar().getCustomView().findViewById(R.id.Left_Toolbar_Item);
        ImageView ToolBar_RightItem = getSupportActionBar().getCustomView().findViewById(R.id.Right_Toolbar_Item);
        TextView ToolBar_RightText_Item  = getSupportActionBar().getCustomView().findViewById(R.id.RightText_Item);
        TextView ToolBar_LeftText_Item  = getSupportActionBar().getCustomView().findViewById(R.id.LeftText_Item);

        ToolBar_LeftText_Item.setVisibility(View.GONE); ToolBar_RightItem.setVisibility(View.GONE);
        ToolBar_LeftItem.setImageResource(R.drawable.back_button_24dp);
        ToolBar_Title.setText("Show match");ToolBar_RightText_Item.setText("Edit");

        EditText EventName_EditText = findViewById(R.id.ShowMatch_EventName_EditText);
        EditText EventStart_EditText = findViewById(R.id.ShowMatch_EventStart_EditText);
        EditText EventFinish_EditText = findViewById(R.id.ShowMatch_EventFinish_EditText);
        EditText Stadium_EditText = findViewById(R.id.ShowMatch_Stadium_EditText);
        EditText Team_1_EditText = findViewById(R.id.ShowMatch_Team_1_EditText);
        EditText Team_2_EditText = findViewById(R.id.ShowMatch_Team_2_EditText);

        EventName_EditText.setEnabled(false); Stadium_EditText.setEnabled(false);
        EventStart_EditText.setEnabled(false); EventFinish_EditText.setEnabled(false);
        Team_1_EditText.setEnabled(false); Team_2_EditText.setEnabled(false);

        ToolBar_LeftItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ShowMatch.this, ShowTeam.class);
                startActivity(intent); finish();
            }
        });

        ToolBar_RightText_Item.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ShowMatch.this, EditMatch.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.GroupCall_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ShowMatch.this, Teams.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Events_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ShowMatch.this, Events.class);
                startActivity(intent); finish();
            }
        });

        Timer HideUI_Timer = new Timer();
        final Handler HideUI_Handler = new Handler();
        HideUI_Timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                HideUI_Handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        getWindow().getDecorView().setSystemUiVisibility(flags);
                    }
                });
            }
        }, 0, 1000);
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
