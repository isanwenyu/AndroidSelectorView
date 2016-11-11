package com.isanwenyu.selectorview.library.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.isanwenyu.selectorview.library.R;
import com.isanwenyu.selectorview.library.model.SelectorData;
import com.isanwenyu.selectorview.library.model.Type;
import com.isanwenyu.selectorview.library.widget.FocusedCheckedTextView;
import com.isanwenyu.selectorview.library.widget.MeasureGridView;

import java.util.List;

/**
 * <pre>
 * 焦点始终获取的CheckedTextView
 * todo 自定义group及child item resource
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class SelectorAdapter extends BaseExpandableListAdapter {
    public static final int CONST_CHILDREN_COUNT = 1;//子类数量
    private List<SelectorData> mGroupData;
    private Context mContext;
    private LayoutInflater mInflater;
    private InvertChangedListener mInvertChangedListener;

    public SelectorAdapter(Context context, List<SelectorData> groupData) {
        super();
        this.mGroupData = groupData;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return mGroupData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return CONST_CHILDREN_COUNT;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public SelectorData getGroup(int groupPosition) {
        return mGroupData.get(groupPosition);
    }

    @Override
    public Type getChild(int groupPosition, int childPosition) {
        return mGroupData.get(groupPosition).getTypeList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.elv_group_item, null);
        TextView titleView = (TextView) convertView
                .findViewById(R.id.tv_title_elv);
        ToggleButton toggle = (ToggleButton) convertView
                .findViewById(R.id.tb_invert_elv);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (mInvertChangedListener != null)
                    mInvertChangedListener
                            .invertChange(groupPosition, isChecked);
            }
        });
        String title = getGroup(groupPosition).getTitle();
        titleView.setText(title);
        if (getGroup(groupPosition).isShowRevert()) {
            toggle.setVisibility(View.VISIBLE);
        }else {
            toggle.setVisibility(View.GONE);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        MeasureGridView gridView = new MeasureGridView(mContext);
        gridView.setNumColumns(4);
        gridView.setHorizontalSpacing(5);
        gridView.setVerticalSpacing(5);
        gridView.setGravity(Gravity.CENTER);
        gridView.setPadding(30, 30, 30, 30);
        if (getGroup(groupPosition).isMultiChoice()) {
            gridView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        } else {
            gridView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        }
        gridView.setBackgroundColor(mContext.getResources().getColor(
                android.R.color.white));
        gridView.setSelector(android.R.color.transparent);
        GridAdapter adapter = new GridAdapter(mGroupData.get(groupPosition)
                .getTypeList());
        gridView.setAdapter(adapter);// Adapter
        List<Type> list = mGroupData.get(groupPosition).getTypeList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isChecked())
                gridView.setItemChecked(i, true);
        }
        return gridView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return false;
    }

    public void setOnInvertChangedListener(InvertChangedListener l) {
        this.mInvertChangedListener = l;

    }


    public interface InvertChangedListener {

        void invertChange(int groupPosition, boolean isChecked);
    }

    class GridAdapter extends BaseAdapter {
        private List<Type> mList;

        public GridAdapter(List<Type> typeList) {
            this.mList = typeList;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            FocusedCheckedTextView cb = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.elv_child_item, null);
                cb = (FocusedCheckedTextView) convertView;
            }
            if (cb != null) {
                cb.setOnCheckedChangeListener(new FocusedCheckedTextView.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(FocusedCheckedTextView myCheckedTextView, boolean isChecked) {
                        mList.get(position).setChecked(isChecked);

                    }

                });
                cb.setText(mList.get(position).getName());
            }
            return convertView;
        }
    }

    public List<SelectorData> getmGroupData() {
        return mGroupData;
    }

    public void setmGroupData(List<SelectorData> mGroupData) {
        this.mGroupData = mGroupData;
    }
}
