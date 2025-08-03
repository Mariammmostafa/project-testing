package Utelities;

import org.testng.Assert;

public class AssersionHelper
{
      public void asserEqual(String Actual , String Expected) {
            Assert.assertEquals(Actual, Expected, "not matched!");


      }
                  // تأكد إن القيمة صحيحة (true)
                  public void assertTrue(boolean condition) {
                        Assert.assertTrue(condition, "❌ Condition was expected to be true, but it was false.");
                  }

                  // تأكد إن القيمة خاطئة (false)
                  public void assertFalse(boolean condition) {
                        Assert.assertFalse(condition, "❌ Condition was expected to be false, but it was true.");
                  }
            }
