package com.isanwenyu.selectorview.library.model;

/**
 * <pre>
 * 类别实体
 * Created by isanwenyu on 2016/11/9.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class Type {
	private String id;
	private String value;
	private String name;
	private boolean isChecked;

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Type(String id, String value, String name, boolean isChecked) {
		super();
		this.id = id;
		this.value = value;
		this.name = name;
		this.isChecked = isChecked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChecked(boolean b) {
		this.isChecked = b;
	}

	public boolean isChecked() {
		return isChecked;
	}

	@Override
	public String toString() {
		return "id:" + id + "value:" + value + "name:" + name + "checked:"
				+ isChecked;
	}
}
