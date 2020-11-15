package com.wernette.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jory A. Wernette
 */
public class SalesTransactionTest {
    
    private SalesTransaction instance;
    private static final int GOOD_TRANSACTION_ID = 500;
    private static final int GOOD_SALES_PERSON_ID = 10;
    private static final LocalDateTime GOOD_DATE = LocalDateTime.now();
    private static final int GOOD_ITEM_ID = 100;
    private static final BigDecimal GOOD_UNIT_PRICE = new BigDecimal("1.00");
    private static final int GOOD_QTY_SOLD = 1;
    //private SalesTransaction instance;

    public SalesTransactionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new SalesTransaction(GOOD_TRANSACTION_ID,
                GOOD_SALES_PERSON_ID, GOOD_DATE, GOOD_ITEM_ID,
                GOOD_UNIT_PRICE, GOOD_QTY_SOLD);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTransactionId method, of class SalesTransaction.
     */
    @Test
    public void testGetTransactionId() {
        setUp();
        int expResult = 500;
        int result = instance.getTransactionId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSalesPersonId method, of class SalesTransaction.
     */
    @Test
    public void testGetSalesPersonId() {
        setUp();
        int expResult = 10;
        int result = instance.getSalesPersonId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTransactionDateTime method, of class SalesTransaction.
     */
    @Test
    public void testGetTransactionDateTime() {
        setUp();
        LocalDateTime expResult = GOOD_DATE;
        LocalDateTime result = instance.getTransactionDateTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemId method, of class SalesTransaction.
     */
    @Test
    public void testGetItemId() {
        setUp();
        int expResult = 100;
        int result = instance.getItemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnitPrice method, of class SalesTransaction.
     */
    @Test
    public void testGetUnitPrice() {
        setUp();
        BigDecimal expResult = new BigDecimal("1.00");
        BigDecimal result = instance.getUnitPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantitySold method, of class SalesTransaction.
     */
    @Test
    public void testGetQuantitySold() {
        setUp();
        int expResult = 1;
        int result = instance.getQuantitySold();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class SalesTransaction.
     */
    @Test
    public void testToString() {
        setUp();
        String expResult = "SalesTransaction{" + "transactionId=" + GOOD_TRANSACTION_ID
                + ", salesPersonId=" + GOOD_SALES_PERSON_ID + ", transactionDateTime="
                + GOOD_DATE + ", itemId=" + GOOD_ITEM_ID + ", unitPrice="
                + GOOD_UNIT_PRICE + ", quantitySold=" + GOOD_QTY_SOLD + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetTransactionIdArbitraryGood() {
        setUp();
        instance.setTransactionId(50);
        assertEquals(50, instance.getTransactionId());

        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetTransactionIdZeroGood() {
        setUp();
        instance.setTransactionId(0);
        assertEquals(1, instance.getTransactionId());

        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetTransactionIdNegativeBad() {
        setUp();
        // use a try-catch statement
        try {
            instance.setTransactionId(-1);
            fail("TransactionID cannot be a Negative number");
        } catch (Exception ex) {
            assertTrue(instance.getTransactionId() >= 0);
        }
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetSalesPersonIdBadZero() {
        setUp();
        // use a try-catch statement
        try {
            instance.setSalesPersonId(0);
            fail("Sales Person cannot be 0.");
        } catch (Exception ex) {
            assertTrue(instance.getSalesPersonId() > 0);
        }
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetSalesPersonIdOneGood() {
        setUp();
        instance.setSalesPersonId(GOOD_SALES_PERSON_ID);
        assertEquals(GOOD_SALES_PERSON_ID, instance.getSalesPersonId());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetSalesPersonIdArbitraryGood() {
        setUp();
        instance.setSalesPersonId(12);
        assertEquals(12, instance.getSalesPersonId());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetSalesDateTimeTodayGood() {
        setUp();
        instance.setTransactionDateTime(GOOD_DATE);
        assertEquals(GOOD_DATE, instance.getTransactionDateTime());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetSalesDateTimeTomorrowBad() {
        setUp();
        try {
            instance.setTransactionDateTime(GOOD_DATE.plusDays(1));
            fail("Sales Date cannot be set in the Future.");
        } catch (Exception ex) {
            assertTrue(instance.getTransactionDateTime().isBefore(GOOD_DATE.plusDays(1)));
        }
        // use a try-catch statement
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetSalesDateTimeMinus31DaysBad() {
        setUp();
        try {
            instance.setTransactionDateTime(GOOD_DATE.minusDays(31));
            fail("Sales Date cannot be set further than 30 days in the past.");
        } catch (Exception ex) {
            assertTrue(instance.getTransactionDateTime().isAfter(GOOD_DATE.minusDays(31)));
        }
        // use a try-catch statement
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetSalesDateTimeMinus30DaysGood() {
        setUp();
        instance.setTransactionDateTime(GOOD_DATE.minusHours(719)); // 30 days - 1 hour
        assertEquals(GOOD_DATE.minusHours(719), instance.getTransactionDateTime());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetItemIdZeroBad() {
        setUp();
        // use a try-catch statement
        try {
            instance.setItemId(0);
        } catch (Exception ex) {
            assertTrue(instance.getSalesPersonId() > 0);
        }
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetItemIdOneGood() {
        setUp();
        instance.setItemId(GOOD_ITEM_ID);
        assertEquals(GOOD_ITEM_ID, instance.getItemId());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetItemIdArbitraryGood() {
        setUp();
        instance.setItemId(927);
        assertEquals(927, instance.getItemId());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetUnitPriceNegativeBad() {
        setUp();
        // use a try-catch statement
        try {
            instance.setUnitPrice(new BigDecimal("-1.00"));
            fail("Unit price cannot be negative.");
        } catch (Exception ex) {
            assertTrue(instance.getUnitPrice().compareTo(BigDecimal.ZERO) > 0);
        }
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetUnitPriceZeroGood() {
        setUp();
        instance.setUnitPrice(new BigDecimal("0.00"));
        assertEquals(new BigDecimal("0.00"), instance.getUnitPrice());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetUnitPriceArbitraryGood() {
        setUp();
        instance.setUnitPrice(new BigDecimal("9.27"));
        assertEquals(new BigDecimal("9.27"), instance.getUnitPrice());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetUnitPriceOneDecimalGood() {
        setUp();
        instance.setUnitPrice(new BigDecimal("1.0"));
        assertEquals(new BigDecimal("1.0"), instance.getUnitPrice().setScale(1));
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetUnitPriceThreeDecimalsGood() {
        setUp();
        instance.setUnitPrice(new BigDecimal("1.000"));
        assertEquals(new BigDecimal("1.000"), instance.getUnitPrice().setScale(3));
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetQuantitySoldZeroBad() {
        setUp();
        // use a try-catch statement
        try {
            instance.setQuantitySold(0);
            fail("Cannot sell 0 of something.");
        } catch (Exception ex){
            assertTrue(instance.getQuantitySold() > 0);
        }
        // inside try, call the appropriate method to set the necessary BAD value 
        // inside try, call the fail method, with an appropriate message, if the program allows the setter to process
        // inside catch, use assertTrue with any truthy expression
    }
    
    @Test
    public void testSetQuantitySoldOneGood() {
        setUp();
        instance.setQuantitySold(GOOD_QTY_SOLD);
        assertEquals(GOOD_QTY_SOLD, instance.getQuantitySold());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testSetQuantitySoldArbitraryGood() {
        setUp();
        instance.setQuantitySold(927);
        assertEquals(927, instance.getQuantitySold());
        // call the appropriate method to set the necessary GOOD value
        // use assertEquals to compare an expected value with an actual value. The actual value must come from the getter method.
    }
    
    @Test
    public void testCompareToFirstDateEarlier() {
        setUp();
        LocalDateTime anotherDate = instance.getTransactionDateTime().minusDays(1);
        assertTrue(instance.getTransactionDateTime().compareTo(anotherDate) > 0);
        // instantiate a second mock object using aribitray acceptable values, modify the date as necessary
        // use assertTrue with an expression that uses the .compareTo() method
    }
    
    @Test
    public void testCompareToBothDatesEqual() {
        setUp();
        LocalDateTime anotherDate = instance.getTransactionDateTime();
        assertTrue(instance.getTransactionDateTime().compareTo(anotherDate) == 0);
        // instantiate a second mock object using aribitray acceptable values, modify the date as necessary
        // use assertTrue with an expression that uses the .compareTo() method
    }
    
    @Test
    public void testCompareToOtherDateEarlier() {
        setUp();
        LocalDateTime anotherDate = instance.getTransactionDateTime().plusDays(1);
        assertTrue(instance.getTransactionDateTime().compareTo(anotherDate) < 0);
        // instantiate a second mock object using aribitray acceptable values, modify the date as necessary
        // use assertTrue with an expression that uses the .compareTo() method
    }
    
}
