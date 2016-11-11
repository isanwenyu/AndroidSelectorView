package com.isanwenyu.selectorview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * <pre>
 * 简单抽象类
 * Created by isanwenyu on 2016/11/8.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity {

	protected abstract void initView();

	protected abstract void setListener();

	protected abstract void fillData();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		setListener();
		fillData();

	}
}
