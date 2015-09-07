package cortazar.cortazaroficial;

import com.heinrichreimersoftware.materialdrawer.DrawerActivity;
import com.heinrichreimersoftware.materialdrawer.DrawerView;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


public class MainActivity3 extends DrawerActivity {

    private DrawerView drawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer = (DrawerView) findViewById(R.id.drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.color_primary_dark));
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.closeDrawer(drawer);

        //drawer.addItem(new DrawerHeaderItem().setTitle(getString(R.string.lorem_ipsum_short)));
        drawer.addProfile(new DrawerProfile()
            .setId(1)
            .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.avatar))
            .setBackground(getResources().getDrawable(R.drawable.background))
            .setName(getString(R.string.profile_title))
            .setDescription(getString(R.string.profile_description))
        );

        drawer.addItem(new DrawerItem()
            .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.AVATAR)
            .setTextPrimary(getString(R.string.item_historia))
            .setTextSecondary(getString(R.string.item_historia_description), DrawerItem.THREE_LINE)
        );

        drawer.addItem(new DrawerItem()
            .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.AVATAR)
            .setTextPrimary(getString(R.string.item_tradiciones))
            .setTextSecondary(getString(R.string.item_tradiciones_description), DrawerItem.THREE_LINE)
        );

        drawer.addItem(new DrawerItem()
            .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.AVATAR)
            .setTextPrimary(getString(R.string.item_turismo))
            .setTextSecondary(getString(R.string.item_turismo_description), DrawerItem.THREE_LINE)
        );

        drawer.selectItem(0);
        drawer.setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectItem(position);
                Toast.makeText(MainActivity3.this, "Clicked item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        drawer.addFixedItem(new DrawerItem()
            .setImage(getResources().getDrawable(R.drawable.ic_flag))
            .setTextPrimary(getString(R.string.about))
        );

        drawer.setOnFixedItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                drawer.selectFixedItem(position);
                Toast.makeText(MainActivity3.this, "Clicked fixed item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
