package com.project.myimagesliderzoom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ortiz.touchview.TouchImageView;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SlideAdapter extends SliderViewAdapter<SlideAdapter.Holder> {

    private int[] images;

    public SlideAdapter(int[] images){
        this.images = images;
    }

    @Override
    public SlideAdapter.Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.silder_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SlideAdapter.Holder viewHolder, int position) {
        viewHolder.ivSlide.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class Holder extends ViewHolder {

        private TouchImageView ivSlide;
        public Holder(View itemView) {
            super(itemView);
            ivSlide = (TouchImageView) itemView.findViewById(R.id.ivSlide);
        }
    }
}
