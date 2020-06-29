package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Profile extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Profile");

        findViewById(R.id.GroupCall_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Profile.this, Teams.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Events_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Profile.this, Events.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Settings_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Profile.this, Settings.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Profile_Save_Button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Profile.this, Settings.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Profile_Back_Button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Profile.this, Settings.class);
                startActivity(intent); finish();
            }
        });

        String[] Cities_Array = { "Moscow", "St. Petersburg" },
                 Teams_Array = { "CSKA", "Spartak", "Dinamo Kiev", "Fakel", "Rubin" };

        ArrayAdapter<String> Cities_SpinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Cities_Array);
        ArrayAdapter<String> Teams_SpinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Teams_Array);

        Cities_SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Teams_SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner Cities_Spinner = findViewById(R.id.Profile_City_Spinner);
        Spinner Teams_Spinner = findViewById(R.id.Profile_Team_Spinner);

        Cities_Spinner.setAdapter(Cities_SpinnerAdapter);
        Teams_Spinner.setAdapter(Teams_SpinnerAdapter);

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
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            Intent intent = new Intent(Profile.this, Settings.class);
            startActivity(intent); finish(); return true;
        }
        else { return super.onOptionsItemSelected(item); }
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
