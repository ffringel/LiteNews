package me.quif.litenews.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

import me.quif.litenews.R;

public class MashableFragment extends ListFragment implements AbsListView.OnScrollListener {
    private TweetTimelineListAdapter mListAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private UserTimeline userTimeline;

    private String screenName = "mashable";
    private int mLastFirstVisibleItem;

    public MashableFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mashable, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swiperefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.divider, R.color.ColorPrimary,
                R.color.ColorPrimaryDark, R.color.divider);

        mListView = (ListView) rootView.findViewById(android.R.id.list);
        mListView.setOnScrollListener(this);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userTimeline = new UserTimeline.Builder()
                .screenName(screenName).maxItemsPerRequest(10).build();
        mListAdapter = new TweetTimelineListAdapter(getActivity(), userTimeline);

        setListAdapter(mListAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initiateRefresh();
            }
        });

    }

    private void initiateRefresh() {
        new FetchTweetTask().execute();
    }

    private void onRefreshComplete(TweetTimelineListAdapter result) {
        setListAdapter(result);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView listView, int firstVisibleItem, int i1, int i2) {
        int topRowVerticalPosition = (mListView == null || mListView.getChildCount() == 0) ?
                0 : mListView.getChildAt(0).getTop();
        mSwipeRefreshLayout.setEnabled((firstVisibleItem == 0) && (topRowVerticalPosition >= 0));
        if (listView.getId() == mListView.getId()) {
            final int currentFirstVisibleItem = mListView.getFirstVisiblePosition();

            if (currentFirstVisibleItem > mLastFirstVisibleItem) {
                ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
            } else if (currentFirstVisibleItem < mLastFirstVisibleItem) {
                ((AppCompatActivity)getActivity()).getSupportActionBar().show();
            }
            mLastFirstVisibleItem = currentFirstVisibleItem;
        }
    }

    private class FetchTweetTask extends AsyncTask<Void, Void, TweetTimelineListAdapter> {

        @Override
        protected TweetTimelineListAdapter doInBackground(Void... voids) {
            userTimeline = new UserTimeline.Builder()
                    .screenName(screenName).maxItemsPerRequest(10).build();
            mListAdapter = new TweetTimelineListAdapter(getActivity(), userTimeline);
            return mListAdapter;
        }

        @Override
        protected void onPostExecute(TweetTimelineListAdapter result) {
            super.onPostExecute(result);
            onRefreshComplete(result);
        }
    }
}
