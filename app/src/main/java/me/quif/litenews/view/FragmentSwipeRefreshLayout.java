package me.quif.litenews.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentSwipeRefreshLayout extends ListFragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create the list fragment's content view by calling  the super method
        final View listFragmentView = super.onCreateView(inflater, container, savedInstanceState);

        // Now create a SwipeRefreshLayout to wrap the fragment's content view
        mSwipeRefreshLayout = new ListFragmentSwipeRefreshLayout(container.getContext());

        //Add the list fragment's content view to the SwipeRefreshLayout
        mSwipeRefreshLayout.addView(listFragmentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //Make sure that the SwipeRefreshLayout will fill the fragment
        mSwipeRefreshLayout.setLayoutParams(
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        return mSwipeRefreshLayout;
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        mSwipeRefreshLayout.setOnRefreshListener(listener);
    }

    public boolean isRefreshing() {
        return mSwipeRefreshLayout.isRefreshing();
    }

    public void setRefreshing(boolean refreshing) {
        mSwipeRefreshLayout.setRefreshing(refreshing);
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    public class ListFragmentSwipeRefreshLayout extends SwipeRefreshLayout {
        public ListFragmentSwipeRefreshLayout(Context context) {
            super(context);
        }

        @Override
        public boolean canChildScrollUp() {
            final ListView listView = getListView();
            if (listView.getVisibility() == View.VISIBLE) {
                return canListViewScrollUp(listView);
            } else {
                return false;
            }
        }

        private boolean canListViewScrollUp(ListView listView) {
            if (Build.VERSION.SDK_INT >= 14) {
                return ViewCompat.canScrollVertically(listView, -1);
            } else {
                return listView.getChildCount() > 0 && (listView.getFirstVisiblePosition() > 0
                        || listView.getChildAt(0).getTop() < listView.getPaddingTop());
            }
        }
    }

}
