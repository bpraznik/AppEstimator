package com.fynov.equaleyes.appestimator.ui.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fynov.equaleyes.appestimator.data.models.Feature;
import com.fynov.equaleyes.appestimator.databinding.ItemFeatureBinding;

public class FeatureViewHolder extends RecyclerView.ViewHolder  {
    private ItemFeatureBinding mBinding;
    public FeatureViewHolder(ItemFeatureBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(@NonNull final Feature feature) {
        mBinding.setFeature(feature);
        mBinding.executePendingBindings();
        mBinding.ivAddFeature.setSelected(feature.isSelected());

        mBinding.ivAddFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feature.setSelected(!feature.isSelected());
                mBinding.ivAddFeature.setSelected(feature.isSelected());
            }
        });
    }
}

