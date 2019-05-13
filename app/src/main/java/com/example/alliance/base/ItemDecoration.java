package com.example.alliance.base;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public ItemDecoration(int space){
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);

        if (space == 1){

            if(position == 0 || position == 2){
                outRect.bottom = space * 5;
            }
            else if (position == 1 || position == 3){
                outRect.bottom = space * 72;
            }

        }

        else if (space == 2){

            outRect.bottom = space;
        }




    }
}
