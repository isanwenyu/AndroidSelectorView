package com.isanwenyu.selectorview.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * <pre>
 * 自动测量的网格控件
 * ovriride {@link #onMeasure(int, int)} expand it's height at most
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class MeasureGridView extends GridView {
	public MeasureGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MeasureGridView(Context context) {
		super(context);
	}

	public MeasureGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}