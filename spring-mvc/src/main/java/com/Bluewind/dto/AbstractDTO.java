package com.Bluewind.dto;

import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {
	private List<T> listResult = new ArrayList<>();

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
}
