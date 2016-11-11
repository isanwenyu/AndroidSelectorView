package com.isanwenyu.selectorview.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewDebug.ExportedProperty;
import android.widget.CheckedTextView;

/**
 * <pre>
 * 焦点始终获取的CheckedTextView
 * override {@link #isFocused()}
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class FocusedCheckedTextView extends CheckedTextView {

	private OnCheckedChangeListener mOnCheckedChangeListener;

	public FocusedCheckedTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FocusedCheckedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FocusedCheckedTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setChecked(boolean checked) {
		// TODO Auto-generated method stub
		super.setChecked(checked);
		if (mOnCheckedChangeListener != null) {
			mOnCheckedChangeListener.onCheckedChanged(this, this.isChecked());
		}
	}

	/**
	 * Register a callback to be invoked when the checked state of this button
	 * changes.
	 * 
	 * @param listener
	 *            the callback to call on checked state change
	 */
	public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
		mOnCheckedChangeListener = listener;
	}

	/**
	 * Interface definition for a callback to be invoked when the checked state
	 * of a compound button changed.
	 */
	public static interface OnCheckedChangeListener {
		/**
		 * Called when the checked state of a compound button has changed.
		 * 
		 * @param myFocusedCheckedTextView
		 *            The CheckedTextView whose state has changed.
		 * @param isChecked
		 *            The new checked state of buttonView.
		 */
		void onCheckedChanged(FocusedCheckedTextView myFocusedCheckedTextView,
							  boolean isChecked);
	}

	@Override
	@ExportedProperty(category = "focus")
	public boolean isFocused() {
		// TODO Auto-generated method stub
		return true;
	}
}
