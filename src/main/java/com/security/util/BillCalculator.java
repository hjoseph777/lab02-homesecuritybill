// ==========================================
// Class: BillCalculator
// Purpose: Handles all pricing calculations
// ==========================================


package com.security.util;



public class BillCalculator {
    private static final double BASE_PRICE = 13.99;  // YFinity base price
    private static final double FIRST_CAMERA_PRICE = 5.00;
    private static final double ADDITIONAL_CAMERA_PRICE = 3.00;
    private static final int MONTHS_IN_YEAR = 12;

    public double calculateMonthlyPrice(int cameraCount) {
        double camerasCost = FIRST_CAMERA_PRICE;
        if (cameraCount > 1) {
            camerasCost += (cameraCount - 1) * ADDITIONAL_CAMERA_PRICE;
        }
        return BASE_PRICE + camerasCost;
    }

    public double calculateTotalContractValue(double monthlyPrice, int contractYears) {
        return monthlyPrice * MONTHS_IN_YEAR * contractYears;
    }

    // Getter methods for constants if needed
    public static double getBasePrice() {
        return BASE_PRICE;
    }

    public static double getFirstCameraPrice() {
        return FIRST_CAMERA_PRICE;
    }

    public static double getAdditionalCameraPrice() {
        return ADDITIONAL_CAMERA_PRICE;
    }
}
