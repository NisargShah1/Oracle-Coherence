package com.oraclecoherence.demo.client;

import java.util.Collection;

import com.oraclecoherence.demo.service.ICoherenceCacheService;
import com.oraclecoherence.demo.vo.Employee;

public class CoherenceCacheRunner implements Runnable{

	ICoherenceCacheService cacheService;
    private Employee employee;
     
    public Employee getEmployee() {
        return employee;
    }
 
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
 
    public ICoherenceCacheService getCacheService() {
        return cacheService;
    }
 
    public void setCacheService(ICoherenceCacheService cacheService) {
        this.cacheService = cacheService;
    }
 
    public void run() {     
         
        //New User are created... 
        //Entries which will be inserted via first member of the cluster so before the project is built 
        // in order to deploy first member of the cluster, this code block should be opened...
        getEmployee().setFirstName("Nisarg");
        getEmployee().setLastName("Shah");
         
        //Entries are added to cache...
        getCacheService().addToCache("employee1", getEmployee());
         
//      //New User are created... 
//      //Entries which will be inserted via second member of the cluster so before the project is built 
//      // in order to deploy second member of the cluster, this code block should be opened...
//      getEmployee().setFirstName("abc");
//      getEmployee().setLastName("xyz");
//      
//      //Entries are added to cache...
//      getCacheService().addToCache("employee2", getEmployee());
 
        //Cache Entries are printed...
        printCacheEntries();        
    }
     
    private void printCacheEntries() {
        Collection<Employee> empCollection = null;
        try {
            while(true) {
            	empCollection = (Collection<Employee>)getCacheService().getCache().values();
                for(Employee emp : empCollection) {
                    System.out.println("Cache Content : "+emp);
                }
                Thread.sleep(10000);            
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
