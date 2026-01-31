package com.example.virtualcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomBottomActivity extends BaseActivity {

    private ImageView bottomLayer; // clothes layer


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_bottom);


        // ===============================
        // BOTTOM LAYER (ON PET)
        // ===============================

        bottomLayer = findViewById(R.id.bottomLayer);


        // ===============================
        // RECYCLER VIEW
        // ===============================

        RecyclerView recyclerView =
                findViewById(R.id.itemsRecyclerViewBottom);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );


        // ===============================
        // SHOP IMAGES (PREVIEW)
        // ===============================

        int[] shopImages = {

                R.drawable.ic_cancel,
                R.drawable.bottom_girl_flaredpants,
                R.drawable.bottom_boy_denimpants,
                R.drawable.bottom_girl_skirt,
                R.drawable.bottom_boy_short,
                R.drawable.bottom_boy_blackpants
        };


        // ===============================
        // EQUIP IMAGES (ON PET)
        // ===============================

        int[] equipImages = {

                0, // cancel
                R.drawable.bottom_girl_flaredpants_1,
                R.drawable.bottom_boy_denimpants_1,
                R.drawable.bottom_girl_skirt_1,
                R.drawable.bottom_boy_short_1,
                R.drawable.bottom_boy_blackpants_1
        };


        // ===============================
        // PRICES
        // ===============================

        String[] prices = {

                "",
                "200",
                "220",
                "200",
                "180",
                "250"
        };


        // ===============================
        // ADAPTER (FIXED)
        // ===============================

        ShopItemAdapter adapter =
                new ShopItemAdapter(

                        shopImages,
                        equipImages,
                        prices,

                        equipResId -> equipBottom(equipResId)

                );

        recyclerView.setAdapter(adapter);


        // ===============================
        // CATEGORY BUTTONS
        // ===============================

        setupCategories();

        // ===============================
        // SETTINGS
        // ===============================

        setupSettings();

        // ===============================
        // BOTTOM NAV
        // ===============================

        setupBottomNav();
    }


    // ===============================
    // EQUIP BOTTOM
    // ===============================

    private void equipBottom(int resId) {

        if (bottomLayer == null) return;

        if (resId == 0) {

            bottomLayer.setVisibility(View.GONE);

        } else {

            bottomLayer.setImageResource(resId);
            bottomLayer.setVisibility(View.VISIBLE);
        }
    }


    // ===============================
    // CATEGORY BUTTONS
    // ===============================

    private void setupCategories() {

        LinearLayout cat1 = findViewById(R.id.categoryButton1);
        LinearLayout cat2 = findViewById(R.id.categoryButton2);
        LinearLayout cat3 = findViewById(R.id.categoryButton3);
        LinearLayout cat4 = findViewById(R.id.categoryButton4);


        // TOP
        if (cat1 != null) {
            cat1.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            CustomTopActivity.class
                    ))
            );
        }

        // BOTTOM (CURRENT)
        if (cat2 != null) {
            cat2.setOnClickListener(v -> {
                // Stay here
            });
        }

        // HAT
        if (cat3 != null) {
            cat3.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            CustomHatActivity.class
                    ))
            );
        }

        // GLASSES
        if (cat4 != null) {
            cat4.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            CustomGlassesActivity.class
                    ))
            );
        }
    }


    // ===============================
    // SETTINGS
    // ===============================

    private void setupSettings() {

        ImageView settings =
                findViewById(R.id.settingsIcon);

        if (settings != null) {
            settings.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            SettingsActivity.class
                    ))
            );
        }
    }


    // ===============================
    // BOTTOM NAV
    // ===============================

    private void setupBottomNav() {

        ImageView navHome =
                findViewById(R.id.navHome);

        ImageView navQuests =
                findViewById(R.id.navQuests);

        ImageView navCustomize =
                findViewById(R.id.navCustomize);


        if (navHome != null) {
            navHome.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            MoodActivity.class
                    ))
            );
        }

        if (navQuests != null) {
            navQuests.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            QuestsActivity.class
                    ))
            );
        }

        if (navCustomize != null) {
            navCustomize.setOnClickListener(v ->
                    startActivity(new Intent(
                            this,
                            CustomTopActivity.class
                    ))
            );
        }
    }
}
