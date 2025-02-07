package com.lao.executionEngine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;

import com.lao.actionKeywords.ActionKeywords;
import com.lao.utilities.ExcelUtilities;
import com.lao.utilities.Locators;

public class executionEngine {

	ActionKeywords actionkeywords;
	Method[] methods;
	
	public static By locator;

	//Get Keywords from excel
	public executionEngine() {

		actionkeywords = new ActionKeywords();

		methods = actionkeywords.getClass().getMethods();
	}
	
	public void executeKeywords() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		for(int i=0;i<methods.length;i++) {
			
			if (methods[i].getName().equalsIgnoreCase(ExcelUtilities.KeyWordColumnvalue)) {
				methods[i].invoke(actionkeywords);
				break;
			}
		}
	}
	
	
	public void findWebElementsToBeUsed() {
		
		switch (ExcelUtilities.locatorname) {
		    case "id":
			locator =Locators.getId(ExcelUtilities.locatorvalue);
			break;
            case "name":
			locator =Locators.getName(ExcelUtilities.locatorvalue);
			break;
            case "xpath":
   			locator =Locators.getXpath(ExcelUtilities.locatorvalue);
   			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws Exception {

		ExcelUtilities utilities = new ExcelUtilities();

		utilities.readExcelfile(
				"C:\\Users\\x230\\eclipse-workspace\\keyword-driven-framework\\src\\test\\resources\\TestDataCore.xlsx");

		executionEngine executionEngine = new executionEngine();
		
		int locatorColumn=3;
		int KeyWordColumn = locatorColumn+1;
		int dataColumn = locatorColumn+2;
		
		//executionEngine.getKeywordsFromActions();
		for (int row = 1; row <= ExcelUtilities.totalRows; row++) {
			
			//keyword = utilities.getlocatorsKeywordsAndData(row, locatorColumn,KeyWordColumn,dataColumn);
			 utilities.getlocatorsKeywordsAndData(row, locatorColumn,KeyWordColumn,dataColumn);
			
			
			executionEngine.findWebElementsToBeUsed();
			executionEngine.executeKeywords();
			
		}

	}
}
