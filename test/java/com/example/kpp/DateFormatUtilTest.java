package com.example.kpp;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.sql.Timestamp;

import mockit.Mocked;
import mockit.Verifications;

import org.junit.Test;

import com.example.kpp.util.DateFormatUtil;

public class DateFormatUtilTest {
    @SuppressWarnings("unused")
    @Mocked
    private DateFormatUtil mockDateFormatUtil;

    @SuppressWarnings("static-access")
    @Test
    public void testGetDateFormatConvert() {
//        new NonStrictExpectations(){{
//            mockDateFormatUtil.getDateFormatConvert(date, mockDateFormatUtil.DEFAULT_FORMAT);
//        }};
//        new Expectations() {{
//            DateFormatUtil.getDateFormatConvert(any, anyString); times = 1;
//        }};

        DateFormatUtil.getDateFormatConvert(new Timestamp(System.currentTimeMillis()), DateFormatUtil.DEFAULT_FORMAT);

        new Verifications(){{
            String format;
            DateFormatUtil.getDateFormatConvert(any, format=withCapture()); times = 1;
            System.out.println(format);
            assertThat(format ,is(DateFormatUtil.DEFAULT_FORMAT));
        }};
//        mockDateFormatUtil.getDateFormatConvert(date, mockDateFormatUtil.DEFAULT_FORMAT);
//        mockDateFormatUtil.getDateFormatConvert(date, mockDateFormatUtil.DEFAULT_FORMAT);

//        new Verifications(){{
//            mockDateFormatUtil.getDateFormatConvert(date, mockDateFormatUtil.DEFAULT_FORMAT); times=1;
//
//        }};
//        assertThat(result, not(isEmptyOrNullString()));
    }
}

