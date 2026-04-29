package com.example.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {

    @Test
    void testSuccessfulPaymentLogging() {
        PaymentProcessor processor = new PaymentProcessor();
        boolean result = processor.processPayment("alice_bidder", 150.50);
        assertTrue(result);
    }

    @Test
    void testFailedPaymentLogging() {
        PaymentProcessor processor = new PaymentProcessor();
        // Cố tình truyền số âm để kích hoạt Exception và log ERROR
        boolean result = processor.processPayment("bob_hacker", -50.00);
        assertFalse(result);
    }
}