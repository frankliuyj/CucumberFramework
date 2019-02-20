package com.frank.cucumberframework.framework.utils.supporter;

import com.frank.cucumberframework.framework.utils.datasource.CaseInputDataManager;
import com.frank.cucumberframework.framework.utils.datasource.IDataSource;

public class GetTestcaseInputPara {

	String filepath = "";
	IDataSource prop = null;

	public GetTestcaseInputPara(String filePath) {
		this.filepath = filePath;
		if (prop == null) {
			/*
			String args[] = new String[] {"third","test"};
			prop = CaseInputDataManager.getDataSourceManager("mongo", args);
			*/
			String args[] = new String[] {filePath};
			prop = CaseInputDataManager.getDataSourceManager("properties", args);
		}
	}

	public String getProperty(String str) {
		return prop.getProperty(str);
	}

}
