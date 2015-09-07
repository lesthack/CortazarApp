package cortazar.cortazaroficial;

/**
 * Created by lesthack on 18/06/15.
 */

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.heinrichreimersoftware.materialdrawer.DrawerActivity;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;
import com.heinrichreimersoftware.materialdrawer.theme.DrawerTheme;

public class MainActivity extends DrawerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        /*setDrawerTheme(
                new DrawerTheme(this)
                        .setBackgroundColorRes(R.color.color_primary_light)
                        .setTextColorPrimaryRes(R.color.primary_text_default_material_dark)
                        .setTextColorSecondaryRes(R.color.secondary_text_default_material_dark)
        );*/

        addProfile(new DrawerProfile()
            .setId(1)
            .setRoundedAvatar((BitmapDrawable) getResources().getDrawable(R.drawable.avatar))
            .setBackground(getResources().getDrawable(R.drawable.background))
            .setName(getString(R.string.profile_title))
            .setDescription(getString(R.string.profile_description))
        );

        addItems(
          new DrawerItem()
            .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.AVATAR)
            .setTextPrimary(getString(R.string.item_principal))
            .setTextSecondary(getString(R.string.item_principal_description), DrawerItem.THREE_LINE)
          ,
          new DrawerItem()
            .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.AVATAR)
            .setTextPrimary(getString(R.string.item_donde_dormir))
            .setTextSecondary(getString(R.string.item_donde_dormir_description), DrawerItem.THREE_LINE)
          ,
          new DrawerItem()
            .setRoundedImage((BitmapDrawable) getResources().getDrawable(R.drawable.cat_2), DrawerItem.AVATAR)
            .setTextPrimary(getString(R.string.item_donde_comer))
            .setTextSecondary(getString(R.string.item_donde_comer_description), DrawerItem.THREE_LINE)
        );
        selectItem(0);
        setOnItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                selectItem(position);
                Toast.makeText(MainActivity.this, "Clicked item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        addFixedItems(
          new DrawerItem()
            .setImage(getResources().getDrawable(R.drawable.ic_flag))
            .setTextPrimary(getString(R.string.about))
        );
        setOnFixedItemClickListener(new DrawerItem.OnItemClickListener() {
            @Override
            public void onClick(DrawerItem item, long id, int position) {
                selectFixedItem(position);
                Toast.makeText(MainActivity.this, "Clicked fixed item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout layout_historia = (LinearLayout) findViewById(R.id.layout_historia);
        layout_historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Historia", Toast.LENGTH_SHORT);
            }
        });
    }
}
