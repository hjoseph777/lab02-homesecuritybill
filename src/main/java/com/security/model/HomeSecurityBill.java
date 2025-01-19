 // ==========================================
// Class: HomeSecurityBill
// Purpose: Stores customer and contract information
// ==========================================
package com.security.model;
import com.security.util.BillCalculator;
import com.security.validation.HomeSecurityInputvalidation;
import java.util.Scanner;

public class HomeSecurityBill {
    private String customerName;
    private String address;
    private int cameraCount;
    private int contractYears;
    private double monthlyPrice;
    private double totalContractValue;
    private static final HomeSecurityInputvalidation validator = new HomeSecurityInputvalidation();

    public HomeSecurityBill(String customerName, String address, int cameraCount, int contractYears) {
        
        this.customerName = validator.getValidString(new Scanner(customerName), "");
        this.address = validator.getValidString(new Scanner(address), "");
        
        
        validator.validateRange(cameraCount, 1, Integer.MAX_VALUE, "Camera count");
        validator.validateRange(contractYears, 2, Integer.MAX_VALUE, "Contract years");
        
        this.cameraCount = cameraCount;
        this.contractYears = contractYears;
        calculatePrices();
    }

    private void calculatePrices() {
        BillCalculator calculator = new BillCalculator();
        this.monthlyPrice = calculator.calculateMonthlyPrice(cameraCount);
        this.totalContractValue = calculator.calculateTotalContractValue(monthlyPrice, contractYears);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public int getCameraCount() {
        return cameraCount;
    }

    public int getContractYears() {
        return contractYears;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public double getTotalContractValue() {
        return totalContractValue;
    }

    public void setCustomerName(String customerName) {
        this.customerName = validator.getValidString(new Scanner(customerName), "");
    }

    public void setAddress(String address) {
        this.address = validator.getValidString(new Scanner(address), "");
    }

    public void setCameraCount(int cameraCount) {
        validator.validateRange(cameraCount, 1, Integer.MAX_VALUE, "Camera count");
        this.cameraCount = cameraCount;
        calculatePrices(); // Recalculate prices when camera count changes
    }

    public void setContractYears(int contractYears) {
        validator.validateRange(contractYears, 2, Integer.MAX_VALUE, "Contract years");
        this.contractYears = contractYears;
        calculatePrices(); // Recalculate prices when contract years change
    }

    public String getBillSummary() {
        return """
            Customer: %s
            Address: %s
            Number of Cameras: %d
            Contract Length: %d years
            Monthly Cost: $%.2f
            Total Contract Value: $%.2f
            """.formatted(
                customerName, address, cameraCount, contractYears,
                monthlyPrice, totalContractValue);
    }
}
