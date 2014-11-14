package com.example.kpp.guice.persist;


import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.seasar.doma.jdbc.tx.LocalTransaction;

import com.example.kpp.doma.DomaConfig;

/**
 * Guiceでトランザクション管理を行うインターセプタ
 * @author T.Kawamoto
 * @version 1.0
 */
public class DomaLocalTxInterceptor implements MethodInterceptor {
   private LocalTransaction tx = DomaConfig.getLocalTransaction();

   /**
    * {@inheritDoc}
    */
   @Override
   public Object invoke(MethodInvocation invocation) throws Throwable {
       DomaTransactionAttribute transactional = readTransactionMetadata(invocation);

       Object result = null;
       if (transactional != null) {
           try {
               if (!tx.isActive()) {
                   tx.begin();
               }
               result = invocation.proceed();
               tx.commit();
           } finally {
               tx.rollback();
           }
       }
       return result;
   }

   /*
    * DomaTransactionAttributeアノテーションを取り出す。
    */
   private DomaTransactionAttribute readTransactionMetadata(
           MethodInvocation methodInvocation) {
       Method method = methodInvocation.getMethod();
       Class<?> targetClass = methodInvocation.getThis().getClass();

       DomaTransactionAttribute transactional = method
               .getAnnotation(DomaTransactionAttribute.class);
       if (transactional == null) {
           transactional = targetClass
                   .getAnnotation(DomaTransactionAttribute.class);
       }

       return transactional;
   }

   @DomaTransactionAttribute
   private static class Internal {
   }
}

