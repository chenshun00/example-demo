package io.github.chenshun00.springcloud.provider.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

class TestServiceTest {
    @Spy
    Example example;
    @InjectMocks
    TestService testService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testService() {
        doNothing().when(example).example();
        doReturn("then").when(example).testExecute();
        //when(example.testExecute()).thenReturn("then");
        testService.service();
    }

    @Test
    void test2() {
        doNothing().when(example).example();
        testService.service();
    }

    @Test
    void test3() {

        //doReturn("ooo do").when(example).testExecute();
        //when(example.testExecute()).thenReturn("ooo no");

        testService.service();
        verify(example, times(1)).example();
        verify(example, times(1)).testExecute();
    }

    @Test
    void test4() {
        doReturn("G").when(example).valueCantBeNull(anyInt());
        when(example.valueCantBeNull(anyInt())).thenReturn("G");
        testService.valueCantBeNull();
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme