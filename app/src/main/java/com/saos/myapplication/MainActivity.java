package com.saos.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DiffUtil;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yuyakaido.android.cardstackview.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CardStackListener {

    DrawerLayout drawerLayout;
    CardStackView cardStackView;
    CardStackLayoutManager cardStackLayoutManager;
    CardStackAdapter cardStackAdapter;
    ArrayList<Spot> spotList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        cardStackView = findViewById(R.id.card_stack_view);
        cardStackLayoutManager = new CardStackLayoutManager(this,this);

        spotList = SpotList.getList();
        cardStackAdapter = new CardStackAdapter(getApplicationContext(), spotList);

        //setupNavigation();

        setupCardStackView();
        setupButton();
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public void onCardDragging(Direction direction, float ratio){
        Log.d("CardStackView",direction + "");
    }


    @Override
    public void onCardSwiped(Direction direction) {
        if(cardStackLayoutManager.getTopPosition() == cardStackAdapter.getItemCount() - 5) {
            paginate();
        }

    }


    @Override
    public void onCardRewound() {
        Log.d("CardStackView", "onCardRewound: ${manager.topPosition}");
    }

    @Override
    public void onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled: ${manager.topPosition}");
    }

    @Override
    public void onCardAppeared(View view, int position) {
        TextView textView = view.findViewById(R.id.item_name);
    }

    @Override
    public void onCardDisappeared(View view, int position) {
        TextView textView = view.findViewById(R.id.item_name);
    }


    private void setupCardStackView() {
        initialize();
    }

    private void setupButton() {
        View skip = findViewById(R.id.skip_button);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                cardStackLayoutManager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
            }
        });

        View rewind = findViewById(R.id.rewind_button);
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Bottom)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new DecelerateInterpolator())
                        .build();
                cardStackLayoutManager.setSwipeAnimationSetting(setting);
                cardStackView.rewind();
            }
        });

        View like = findViewById(R.id.like_button);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                cardStackLayoutManager.setSwipeAnimationSetting(setting);
                cardStackView.swipe();
            }
        });
    }

    private void initialize(){
        cardStackLayoutManager.setStackFrom(StackFrom.None);
        cardStackLayoutManager.setVisibleCount(3);
        cardStackLayoutManager.setTranslationInterval(8.0f);
        cardStackLayoutManager.setScaleInterval(0.95f);
        cardStackLayoutManager.setSwipeThreshold(0.3f);
        cardStackLayoutManager.setMaxDegree(20.0f);
        cardStackLayoutManager.setDirections(Direction.HORIZONTAL);
        cardStackLayoutManager.setCanScrollHorizontal(true);
        cardStackLayoutManager.setCanScrollVertical(true);
        cardStackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
        cardStackLayoutManager.setOverlayInterpolator(new LinearInterpolator());
        cardStackView.setLayoutManager(cardStackLayoutManager);
        cardStackView.setAdapter(cardStackAdapter);

    }

    private void paginate(){
        ArrayList<Spot> old = cardStackAdapter.getItem();
        ArrayList<Spot> neww = SpotList.getList();
        SpotDiffCallback spotDiffCallback = new SpotDiffCallback(old,neww);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(spotDiffCallback);
        cardStackAdapter.setItem(neww);
        result.dispatchUpdatesTo(cardStackAdapter);
    }



    //https://www.programcreek.com/java-api-examples/index.php?project_name=yuyakaido%2FCardStackView#



}
