package com.oraclecoherence.demo.listener;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

public class EmployeeMapListener implements MapListener{

	  public void entryDeleted(MapEvent me) {
	         System.out.println("Deleted Key = " + me.getKey() + ", Value = " + me.getOldValue());
	    }
	 
	    public void entryInserted(MapEvent me) {
	    	System.out.println("Inserted Key = " + me.getKey() + ", Value = " + me.getNewValue());
	    }
	 
	    public void entryUpdated(MapEvent me) {
	      System.out.println("Updated Key = " + me.getKey() + ", New_Value = " + me.getNewValue() + ", Old Value = " + me.getOldValue());
	    } 
}
