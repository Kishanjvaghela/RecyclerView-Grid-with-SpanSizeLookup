package com.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private HeaderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager manager = new GridLayoutManager(this, 6);
        recyclerView.setLayoutManager(manager);
        adapter = new HeaderAdapter(30);
        recyclerView.setAdapter(adapter);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return getSpanSizeFromPosition(position);
            }
        });
    }

    /**
     * Here we have following template
     *
     *
     * .____________.
     * |      |     |
     * |______|_____|
     * |            |
     * |____________|
     * |    |   |   |
     * |____|___|___|
     * |            |
     * |____________|
     *
     * @param position
     * @return
     */
    private int getSpanSizeFromPosition(int position) {
        int viewType = adapter.getItemViewType(position);
        int spanValue;
        switch (viewType) {
            case 0:
                spanValue = 3;
                break;
            case 1:
                spanValue = 3;
                break;
            case 2:
                spanValue = 6;
                break;
            case 3:
                spanValue = 2;
                break;
            case 4:
                spanValue = 2;
                break;
            case 5:
                spanValue = 2;
                break;
            case 6:
                spanValue = 6;
                break;
            default:
                spanValue = 6;
                break;
        }
        return spanValue;
    }
}
