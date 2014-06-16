package com.adcc.skyfml.core;

public class Request {
	/**
	 * 航班号
	 */
	private String _flightNumber;
	/**
	 * 请求点信息（多个点用逗号分隔）
	 */
	private String _points;
	/**
	 * 高度层（多个高度层用逗号分隔）
	 */
	private String _levels;
	/**
	 * 原始报文内容
	 */
	private String _rawMsg;

	public String getFlightNumber() {
		return this._flightNumber;
	}

	public void setFlightNumber(String aFlightNumber) {
		this._flightNumber = aFlightNumber;
	}

	public String getPoints() {
		return this._points;
	}

	public void setPoints(String aPoints) {
		this._points = aPoints;
	}

	public String getRawMsg() {
		return this._rawMsg;
	}

	public void setRawMsg(String aRawMsg) {
		this._rawMsg = aRawMsg;
	}

	public String getLevels() {
		return this._levels;
	}

	public void setLevels(String aLevels) {
		this._levels = aLevels;
	}
}