package com.isanwenyu.selectorview.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

import com.isanwenyu.selectorview.library.adapter.SelectorAdapter;
import com.isanwenyu.selectorview.library.model.SelectorData;
import com.isanwenyu.selectorview.library.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 选择器控件
 * extends ExpandableListView
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class SelectorView extends ExpandableListView {
    SelectorAdapter mAdapter;//数据适配器
    private List<SelectorData> mGroupData;

    public SelectorView(Context context) {
        this(context, null);
    }

    public SelectorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SelectorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 初始化
     */
    private void init() {
        setOnInvertChangedListener(new SelectorAdapter.InvertChangedListener() {

            @Override
            public void invertChange(int groupPosition, boolean isChecked) {

                List<Type> list = mGroupData.get(groupPosition).getTypeList();
                if (isChecked) { // 反选
                    for (Type type : list) {
                        type.setChecked(!type.isChecked());
                    }
                } else {// 全选
                    for (Type type : list) {
                        type.setChecked(true);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
        });
        setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // 屏蔽分组点击事件
                return true;
            }
        });

    }

    /**
     * 设置自定义适配器
     *
     * @param adapter
     * @return this
     */
    public SelectorView setAdapter(SelectorAdapter adapter) {
        super.setAdapter(adapter);
        this.mAdapter = adapter;
        this.mGroupData = adapter.getmGroupData();
        init();
        return this;
    }

    public List<SelectorData> getGroupData() {
        return mGroupData;
    }

    public SelectorView setGroupData(List<SelectorData> mGroupData) {
        this.mGroupData = mGroupData;
        return this;
    }

    public SelectorView setOnInvertChangedListener(SelectorAdapter.InvertChangedListener invertChangedListener) {
        if (mAdapter == null) {
            throw new NullPointerException("must initialize the adatper first");
        }
        mAdapter.setOnInvertChangedListener(invertChangedListener);
        return this;
    }

    public SelectorView notifyDataSetChanged() {
        if (mAdapter == null) {
            throw new NullPointerException("must initialize the adatper first");
        }
        mAdapter.notifyDataSetChanged();
        //刷新数据 自动展开分组
        for (int i = 0; i < getExpandableListAdapter().getGroupCount(); i++) {
            expandGroup(i);
        }
        return this;
    }

    /**
     * @return 选择的组数据
     */
    public List<SelectorData> getSelectedDataGroup() {
        List<SelectorData> selectedListGroup = new ArrayList<>();
        if (mGroupData != null) {

            for (int i = 0; i < mGroupData.size(); i++) {
                if (mGroupData.get(i) == null) {
                    break;
                }
                SelectorData filterData = mGroupData.get(i);
                if (filterData == null) {
                    continue;
                }
                //构造选择数据容器
                SelectorData selectedFilterData = new SelectorData();
                selectedFilterData.setTitle(filterData.getTitle());
                List<Type> seletedList = new ArrayList<>();
                selectedFilterData.setTypeList(seletedList);
                selectedListGroup.add(selectedFilterData);

                for (Type type : filterData.getTypeList()) {
                    if (type.isChecked()) {
                        seletedList.add(type);
                    }
                }

            }
        }

        return selectedListGroup;
    }

}
