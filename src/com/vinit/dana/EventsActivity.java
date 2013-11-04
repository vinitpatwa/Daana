package com.vinit.dana;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class EventsActivity extends FragmentActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events);
		
		setupNavigationTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.events, menu);
		return true;
	}

	private void setupNavigationTabs() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		
		Tab tabHome = actionBar.newTab().setText("Near Me")
				.setTag("HomeFeedFragment").setTabListener(this);
		Tab tabRecentEvents = actionBar.newTab().setText("Recent")
				.setTag("RecentEventsFragment").setTabListener(this);
		Tab tabMyEvents = actionBar.newTab().setText("My Events")
				.setTag("MyEventsFragment").setTabListener(this);
		
		actionBar.addTab(tabHome);
		actionBar.addTab(tabRecentEvents);
		actionBar.addTab(tabMyEvents);
		actionBar.selectTab(tabHome);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = manager.beginTransaction();
		
		if(tab.getTag() == "HomeFeedFragment"){
			//set the fragment in framelayout to home timeline
			fts.replace(R.id.frame_container, new HomeTimelineFragment());
		} else if(tab.getTag() == "RecentEventsFragment"){
			//set the fragment in framelayout to mentions timeline
			fts.replace(R.id.frame_container, new MentionsFragment());
		} else if(tab.getTag() == "MyEventsFragment"){
			//set the fragment in framelayout to mentions timeline
			fts.replace(R.id.frame_container, new MentionsFragment());
		}
		
		fts.commit();
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
