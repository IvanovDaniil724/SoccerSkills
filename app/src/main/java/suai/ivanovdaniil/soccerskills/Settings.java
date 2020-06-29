package suai.ivanovdaniil.soccerskills;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

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

        ToolBar_LeftItem.setVisibility(View.GONE); ToolBar_RightItem.setVisibility(View.GONE);
        ToolBar_LeftText_Item.setVisibility(View.GONE); ToolBar_RightText_Item.setVisibility(View.GONE);
        ToolBar_Title.setText("Settings");

        findViewById(R.id.GroupCall_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Settings.this, Teams.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.Events_Menu_Image).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Settings.this, Events.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.AboutTitle).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Settings.this, AboutUs.class);
                startActivity(intent); finish();
            }
        });

        findViewById(R.id.PersonalDataTitle).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Intent intent = new Intent(Settings.this, AboutUs.class);
                //startActivity(intent); finish();
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
