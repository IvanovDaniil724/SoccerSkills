package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Teams extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);

        getSupportActionBar().hide();

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(flags);

        final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {

            @Override
            public void onSystemUiVisibilityChange(int visibility)
            {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                {
                    decorView.setSystemUiVisibility(flags);
                }
            }
        });

        findViewById(R.id.Events_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Teams.this, Events.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Settings_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Teams.this, Settings.class);
                startActivity(intent); finish();
            }
        });

        String[] TeamsText_Array = { "CSKA", "Spartak", "Dinamo Kiev", "Fakel", "Rubin" };
        GridLayout[] Teams =
                {
                        findViewById(R.id.Team_1),
                        findViewById(R.id.Team_2),
                        findViewById(R.id.Team_3),
                        findViewById(R.id.Team_4),
                        findViewById(R.id.Team_5)
                };

        Fill_TeamElement(TeamsText_Array[0], R.drawable.team_2, Teams, 0);
        Fill_TeamElement(TeamsText_Array[1], R.drawable.team_4, Teams, 1);
        Fill_TeamElement(TeamsText_Array[2], R.drawable.team_3, Teams, 2);
        Fill_TeamElement(TeamsText_Array[3], R.drawable.team_5, Teams, 3);
        Fill_TeamElement(TeamsText_Array[4], R.drawable.team_6, Teams, 4);
    }

    public void Fill_TeamElement(String TeamTitle_Text, int Team_Image_ID,
                                    GridLayout[] teams, int team_id)
    {
        TextView TeamTitle; ImageView Team_Image;

        TeamTitle = teams[team_id].findViewById(R.id.Team_Text);
        Team_Image = teams[team_id].findViewById(R.id.Team_Image);

        TeamTitle.setText(TeamTitle_Text); Team_Image.setImageResource(Team_Image_ID);

        teams[team_id].setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Teams.this, ShowTeam.class);
                startActivity(intent); finish();
            }
        });
    }
}
