package com.isanwenyu.selectorview.library.model;

import java.util.List;


/**
 * <pre>
 * 分组选择实体
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class SelectorData {
	private String title;
	private boolean showRevert;//是否显示反选按钮
	private boolean multiChoice;//是否多选
	private List<Type> typeList;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isShowRevert() {
		return showRevert;
	}

	public void setShowRevert(boolean showRevert) {
		this.showRevert = showRevert;
	}

	public List<Type> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public boolean isMultiChoice() {
		return multiChoice;
	}

	public void setMultiChoice(boolean multiChoice) {
		this.multiChoice = multiChoice;
	}
}
