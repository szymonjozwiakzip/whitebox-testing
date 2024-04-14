package com.uam.whitebox;
import org.junit.Test;


import static junit.framework.TestCase.assertEquals;

public class PersonalDataTest {

    public PersonalData pd = new PersonalData();

    @Test
    public void shouldReturnTrueIfFirstNameIsValid()  {
        assertEquals(pd.validateName("jacek"), true);
    }

    @Test
    public void shouldReturnFalseIfFirstNameIsInvalid()  {
        assertEquals(pd.validateName("jacek@"), false);
    }

    @Test
    public void shouldReturnTrueIfSurnameIsValid()  {
        assertEquals(pd.validateSurname("Kosiniak-Kamysz"), true);
    }

    @Test
    public void shouldReturnFalseIfSurnameIsInvalid()  {
        assertEquals(pd.validateSurname("Lewandowski; drop table users"), false);
    }

    @Test
    public void shouldReturnTrueIfPhoneNumberIsValid() {
        assertEquals(pd.validatePhoneNumber("618422783"), true);
    }

    @Test
    public void shouldReturnFalseIfPhoneNumberIsInvalid() {
        assertEquals(pd.validatePhoneNumber("+48618422783"), false);
    }

    @Test
    public void shouldReturnTrueIfPeselIsValid() {
        assertEquals(pd.validatePesel("83062113611"), true);
        assertEquals(pd.validatePesel("13220203470"), true);
    }

    @Test
    public void shouldReturnFalseIfPeselIsInvalid() {
        assertEquals(pd.validatePesel("99999999999"), false);
        assertEquals(pd.validatePesel("14"), false);
        assertEquals(pd.validatePesel("03223109570"), false);
        assertEquals(pd.validatePesel("03233209570"), false);
        assertEquals(pd.validatePesel("03230009570"), false);
        assertEquals(pd.validatePesel("03141109570"), false);
        assertEquals(pd.validatePesel("80023012345"), false);
        assertEquals(pd.validatePesel("80023012345"), false);
            
    }

    @Test
    public void shouldReturnFalseIfDayValid() {
        assertEquals(pd.checkDay("28", "2"), true); 
        assertEquals(pd.checkDay("29", "2"), true);
        assertEquals(pd.checkDay("30", "4"), true);
        assertEquals(pd.checkDay("30", "6"), true);
        assertEquals(pd.checkDay("30", "9"), true);
        assertEquals(pd.checkDay("30", "11"), true);

    }

    @Test
    public void shouldReturnFalseIfDayInvalid() {
        assertEquals(pd.checkDay("0", "1"), false);
        assertEquals(pd.checkDay("32", "1"), false); 
        assertEquals(pd.checkDay("30", "2"), false);  
        assertEquals(pd.checkDay("31", "4"), false); 
        assertEquals(pd.checkDay("32", "12"), false); 
        assertEquals(pd.checkDay("31", "4"), false);
        assertEquals(pd.checkDay("31", "6"), false);
        assertEquals(pd.checkDay("31", "9"), false);
        assertEquals(pd.checkDay("31", "11"), false);
    }
}
