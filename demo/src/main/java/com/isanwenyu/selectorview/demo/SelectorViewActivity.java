package com.isanwenyu.selectorview.demo;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.isanwenyu.selectorview.demo.utils.JsonUtils;
import com.isanwenyu.selectorview.library.adapter.SelectorAdapter;
import com.isanwenyu.selectorview.library.model.SelectorData;
import com.isanwenyu.selectorview.library.SelectorView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <pre>
 * SelectorView Demo Activity
 * Created by isanwenyu on 2016/11/8.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class SelectorViewActivity extends BaseActivity {

    private static final String TAG = "SelectorViewActivity";
    private SelectorView mSelectorView;
    private List<SelectorData> mSelectorData;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.selector_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_selector_ok:
                Toast.makeText(this, JsonUtils.serialize(mSelectorView.getSelectedDataGroup()), Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_selector_reset:
                mSelectorData.clear();
                fillData();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initView() {

        setContentView(R.layout.selector_activity);
        mSelectorView = (SelectorView) findViewById(R.id.elv_filter);
        mSelectorData = new ArrayList<SelectorData>();
        mSelectorView.setAdapter(new SelectorAdapter(this, mSelectorData));
    }

    @Override
    protected void setListener() {


    }

    @Override
    protected void fillData() {
        mSelectorData.clear();
        mSelectorData.addAll((Collection<? extends SelectorData>) JsonUtils.deserialize(getString(R.string.selector_json_data), new TypeToken<ArrayList<SelectorData>>(){}.getType()));

        mSelectorView.notifyDataSetChanged();

    }
}
