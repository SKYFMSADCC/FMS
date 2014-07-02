package com.adcc.skyfml.controller;

import java.io.File;

public interface IFlyPlanParseController {
	public boolean parseDataSource(File fDataSource);
	public void saveToDB();
}
