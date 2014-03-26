package palindrome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AllPalindromeTests
{
    Palindrome palindrome = new Palindrome();

    @Test
    public void simplePalindromeTest()
    {
        //true
        palindrome.testForPalindrome("wow");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("Race car");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //false
        palindrome.testForPalindrome("This is a phrase");
        assertFalse(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("Radar");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //false
        palindrome.testForPalindrome("What is this?");
        assertFalse(palindrome.isPalindrome());
        palindrome.resetFields();
    }

    @Test
    public void semiComplexPalindromeTest()
    {
        //true
        palindrome.testForPalindrome("Rise to vote, sir!");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //false
        palindrome.testForPalindrome("Moving project selection.");
        assertFalse(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("Lager, sir, is regal.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //false
        palindrome.testForPalindrome("There is a fix for the bug.");
        assertFalse(palindrome.isPalindrome());
        palindrome.resetFields();
    }

    @Test
    public void complexPalindromeTest()
    {
        //true
        palindrome.testForPalindrome("Madam, I'm Adam!");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //false
        palindrome.testForPalindrome("Log file increases to 1,000 KB");
        assertFalse(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("A man, a plan, a canal, Panama.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("Nurse, I spy gypsies... run!");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();
    }

    @Test
    public void extremelyComplexPalindromeTest()
    {
        //true
        palindrome.testForPalindrome("No, I save on final perusal--a sure plan, if no evasion.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("Are we not drawn onward, we few? Drawn onward to new era?");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true
        palindrome.testForPalindrome("Are we not pure? \"No sir!\" Panama’s moody Noriega brags. “It is garbage!” Irony dooms a man; a prisoner up to new era.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true (in latin)
        palindrome.testForPalindrome("In girum imus nocte et consumimur igni.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true (in portuguese)
        palindrome.testForPalindrome("Luza Rocelina, a namorada do Manuel, leu na Moda da Romana: 'Anil e cor azul'.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();

        //true (in swedish)
        palindrome.testForPalindrome("Dromedaren Alp Aron, allena vid sidan av vanadisdivan Ella Nora, planerade mord.");
        assertTrue(palindrome.isPalindrome());
        palindrome.resetFields();
    }
}