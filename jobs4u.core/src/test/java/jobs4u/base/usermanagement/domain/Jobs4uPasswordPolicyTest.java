/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jobs4u.base.usermanagement.domain;

import jobs4u.base.usermanagement.domain.Jobs4uPasswordPolicy.PasswordStrength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Paulo Gandra de Sousa 18/04/2020
 */
class Jobs4uPasswordPolicyTest {

    private final Jobs4uPasswordPolicy subject = new Jobs4uPasswordPolicy();

    @Test
    void ensurePasswordHasAtLeastOneDigitOneCapitalAnd6CharactersLong() {
        assertTrue(subject.isSatisfiedBy("abCfefgh1"));
    }

    @Test
    void ensurePasswordsSmallerThan6CharactersAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("ab1c"));
    }

    @Test
    void ensurePasswordsWithoutDigitsAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("abcefghi"));
    }

    @Test
    void ensurePasswordsWithoutCapitalLetterAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("abcefghi1"));
    }

    @Test
    void testWeakPassword1() {
        assertEquals(PasswordStrength.WEAK, subject.strength("A23456"));
    }

    @Test
    void testWeakPassword2() {
        assertEquals(PasswordStrength.WEAK, subject.strength("A234567"));
    }

    @Test
    void testGoodPassword1() {
        assertEquals(PasswordStrength.GOOD, subject.strength("A2345678"));
    }

    @Test
    void testGoodPassword2() {
        assertEquals(PasswordStrength.GOOD, subject.strength("A23456789"));
    }

    @Test
    void testExcelentPassword1() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("123456789ABC"));
    }

    @Test
    void testExcelentPassword2() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("123456789ABCD"));
    }

    @Test
    void testExcelentPassword3() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234$5678"));
    }

    @Test
    void testExcelentPassword4() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234#5678"));
    }

    @Test
    void testExcelentPassword5() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234!5678"));
    }

    @Test
    void testExcelentPassword6() {
        assertEquals(PasswordStrength.EXCELENT, subject.strength("A234?5678"));
    }
}
