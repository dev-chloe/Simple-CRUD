package com.toyproject.simplecrudapp.supports;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Parameter;
import java.util.Objects;

import static org.mockito.Mockito.mock;

public class SpringMockitoSupport implements TestInstancePostProcessor, ParameterResolver {

  @Override
  public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
    MockitoAnnotations.openMocks( testInstance );
  }

  @Override
  public boolean supportsParameter( ParameterContext parameterContext, ExtensionContext extensionContext ) {
    return parameterContext.getParameter().isAnnotationPresent( Mock.class );
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext ) {
    return getMock(parameterContext.getParameter(), extensionContext);
  }

  private Object getMock( Parameter parameter, ExtensionContext extensionContext) {
    Class<?> mockType = parameter.getType();
    ExtensionContext.Store mocks = extensionContext.getStore( ExtensionContext.Namespace.create( SpringMockitoSupport.class, mockType));
    String mockName = getMockName(parameter);

    return Objects.isNull(mockName)
                  ? mocks.getOrComputeIfAbsent(mockType.getCanonicalName(), key -> mock(mockType))
                  : mocks.getOrComputeIfAbsent(mockName, key -> mock(mockType, mockName));
  }

  private String getMockName(Parameter parameter) {
    String explicitMockName = parameter.getAnnotation(Mock.class).name().trim();
    if (!explicitMockName.isEmpty())
      return explicitMockName;
    if (parameter.isNamePresent())
      return parameter.getName();
    return null;
  }
}