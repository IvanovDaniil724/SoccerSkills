package suai.ivanovdaniil.soccerskills;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class NewEvent extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_event);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.toolbar_layout);

        TextView ToolBar_Title = getSupportActionBar().getCustomView().findViewById(R.id.ActionBar_Title);
        ImageView ToolBar_CloseItem = getSupportActionBar().getCustomView().findViewById(R.id.Left_Toolbar_Item);
        ImageView ToolBar_SearchItem = getSupportActionBar().getCustomView().findViewById(R.id.Right_Toolbar_Item);
        TextView ToolBar_RightText_Item  = getSupportActionBar().getCustomView().findViewById(R.id.RightText_Item);
        TextView ToolBar_LeftText_Item  = getSupportActionBar().getCustomView().findViewById(R.id.LeftText_Item);
        ToolBar_SearchItem.setVisibility(View.GONE); ToolBar_LeftText_Item.setVisibility(View.GONE);
        ToolBar_CloseItem.setImageResource(R.drawable.close_icon);
        ToolBar_Title.setText("New Event"); ToolBar_RightText_Item.setText("SAVE");
        ToolBar_Title.setTypeface(null, Typeface.BOLD);

        AlertDialog.Builder builder = new AlertDialog.Builder(NewEvent.this);
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Intent intent = new Intent(NewEvent.this, Events.class);
                startActivity(intent); finish();
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int id)
            {

            }
        });
        builder.setMessage("Save event?");
        final AlertDialog SaveEvent_Dialog = builder.create();

        ToolBar_CloseItem.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SaveEvent_Dialog.show();
            }
        });

        ToolBar_RightText_Item.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SaveEvent_Dialog.show();
            }
        });

        findViewById(R.id.GroupCall_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(NewEvent.this, Teams.class);
                startActivity(intent); finish();
            }
        });

        String[] EventStart_Array = { "2019-09-01 09:00:00" },
                 EventFinish_Array = { "2019-09-01 09:00:00" },
                 Teams_Array = { "CSKA", "Spartak", "Dinamo Kiev", "Fakel", "Rubin" };

        ArrayAdapter<String> EventStart_SpinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, EventStart_Array);
        ArrayAdapter<String> EventFinish_SpinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, EventFinish_Array);
        ArrayAdapter<String> Teams_SpinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Teams_Array);

        EventStart_SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        EventFinish_SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Teams_SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner EventStart_Spinner = findViewById(R.id.EventStart_Spinner);
        Spinner EventFinish_Spinner = findViewById(R.id.EventFinish_Spinner);
        Spinner Team_1_Spinner = findViewById(R.id.Team_1_Spinner);
        Spinner Team_2_Spinner = findViewById(R.id.Team_2_Spinner);

        EventStart_Spinner.setAdapter(EventStart_SpinnerAdapter);
        EventFinish_Spinner.setAdapter(EventFinish_SpinnerAdapter);
        Team_1_Spinner.setAdapter(Teams_SpinnerAdapter);
        Team_2_Spinner.setAdapter(Teams_SpinnerAdapter);

        Timer  HideUI_Timer = new Timer();
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
