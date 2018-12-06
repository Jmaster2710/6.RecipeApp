package com.example.joel_.recipeapp2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Recipe> recipes;

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<Recipe> recipes)
    {
        super(fm);
        this.recipes = recipes;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a FoodFragment (defined as a static inner class below).
        return FoodFragment.newInstance(recipes.get(position));
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return recipes.size();
    }
}