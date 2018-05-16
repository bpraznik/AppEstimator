package com.fynov.equaleyes.appestimator.ui.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.models.Category;
import com.fynov.equaleyes.appestimator.databinding.ActivityEstimatorBinding;
import com.fynov.equaleyes.appestimator.ui.adapters.CategoryAdapter;
import com.fynov.equaleyes.appestimator.viewmodels.EstimatorViewModel;

import java.util.ArrayList;

public class ActivityEstimator extends AppCompatActivity {
    private ActivityEstimatorBinding binding;
    private EstimatorViewModel mEstimatorViewModel;
    private RecyclerView.LayoutManager mLayoutManagaer;
    CategoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayoutManagaer = new LinearLayoutManager(this);
        mEstimatorViewModel = ViewModelProviders.of(this).get(EstimatorViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_estimator);
        mAdapter = new CategoryAdapter(new ArrayList<Category>());
        subscribe();
    }

    private void subscribe(){
        final Observer<ArrayList<Category>> categoryObserver = new Observer<ArrayList<Category>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Category> categories) {
                mAdapter.setItems(categories);
                binding.rvCategories.setLayoutManager(mLayoutManagaer);
                binding.rvCategories.setAdapter(mAdapter);
            }
        };
        mEstimatorViewModel.getCategoryList().observe(this, categoryObserver);
    }
}