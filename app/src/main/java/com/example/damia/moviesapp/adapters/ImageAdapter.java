package com.example.damia.moviesapp.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.damia.moviesapp.R;

import java.util.List;

/**
 * Created by damia on 09.04.2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private List<Integer> mResources;

    public ImageAdapter(Context context, List<Integer> resources) {
        mContext = context;
        mResources = resources;
    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public Object getItem(int i) {
        return mResources.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new SquereImageViews(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mResources.get(position));
        return imageView;
    }

    private class SquereImageViews extends android.support.v7.widget.AppCompatImageView{

        SquereImageViews(Context context){
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            int width = getMeasuredWidth();
            setMeasuredDimension(width, width);
        }
    }
}
