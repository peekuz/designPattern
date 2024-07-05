package com.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.Interview.model.Customer;
import com.example.Interview.model.Item;
public class DMCC {
    public static void main(String[] args) {
        Customer currentCustomer = new Customer("shafeeq",Boolean.TRUE,Boolean.TRUE,LocalDate.now());
        double percentageDiscountValue = getPercentageDiscount(currentCustomer);
        List<Item> lineItems = getLineItems();
        double totalDiscountAmount = getTotalPercentageDiscountAmount(percentageDiscountValue, lineItems);
        double total = lineItems.stream().mapToDouble(item -> item.getQuantity() * item.getAmount())
        .sum();
        double discountedTotal = getAmountDiscountValue(total - totalDiscountAmount);
        System.out.println("DiscountedSubtotal: "+ discountedTotal);
    }

    private static List<Item> getLineItems() {
        return Arrays.asList(
                new Item("grocery", "rice",10,50),
                new Item("fruit", "apple",2,30.0)
        );   
    
    }

    private static double getTotalPercentageDiscountAmount(double percentageDiscountValue,         List<Item> lineItems) {
        double totalDiscountAmount = 0;
        for (Item item : lineItems) {
            double percentageDiscountAmount = getPercentageDiscountAmount(item,percentageDiscountValue);
            totalDiscountAmount+= percentageDiscountAmount;
        }
        return totalDiscountAmount;
    }

    private static double getPercentageDiscountAmount(Item item, double percentageDiscountValue) {
        double itemTotal = item.getAmount() * item.getQuantity();
        if (!item.getType().equals("grocery")) {
            return (itemTotal * percentageDiscountValue) / 100;
        }
        return 0;
    }

    private static double getAmountDiscountValue(double amount) {
        Double count =  (amount / 100);

        double discountValue =((count.intValue()) * 5);
        return amount - discountValue;
    }

    private static double getPercentageDiscount(Customer currentCustomer) {
        if (currentCustomer.isEmployee()) {
            return 30;
        } else if (currentCustomer.isAffiliatedToStore()) {
            return 10;
        } else {
            return isLoyalCustomer(currentCustomer.getCreatedDate());
        }
    }

    private static double isLoyalCustomer(LocalDate createdDate) {
        LocalDate loyaltyThresholdDate = LocalDate.now().minusYears(2);
        if (createdDate.isAfter(loyaltyThresholdDate)) {
            return 5;
        }
        return 0;
    }

   
}
