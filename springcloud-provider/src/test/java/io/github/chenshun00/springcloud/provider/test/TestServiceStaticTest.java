package io.github.chenshun00.springcloud.provider.test;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

@DisplayName("静态方法测试")
class TestServiceStaticTest {
    @Spy
    Example example;
    @InjectMocks
    TestService testService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    static MockedStatic<Goo> loginUtilsMockedStatic;

    @BeforeAll
    public static void beforeClass() throws Exception {
        loginUtilsMockedStatic = mockStatic(Goo.class);
    }

    @Test
    void test6() {
        loginUtilsMockedStatic.when(() -> Goo.assertParams(anyInt())).thenReturn("ok1");
        testService.invokeValueCantBeNull();
    }

    @Test
    @DisplayName("静态方法调用--无参数")
    void test5() {
        testService.invokeHandle();
    }

    @Test
    void test4() {
        loginUtilsMockedStatic.when(Goo::handle).thenAnswer((Answer<Void>) invocation -> null);
        loginUtilsMockedStatic.when(Goo::returnValue).thenReturn("ok1");
        loginUtilsMockedStatic.when(() -> Goo.returnValueWithParams(anyString())).thenReturn("ok2");
        testService.handle();
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
        testService.service();
        verify(example, times(1)).example();
        verify(example, times(1)).testExecute();
    }

    @AfterAll
    public static void afterClass() throws Exception {
        loginUtilsMockedStatic.close();
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme