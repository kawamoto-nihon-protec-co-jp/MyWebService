package ngdemo.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class HealthInfoListener implements EntityListener<HealthInfo> {

    @Override
    public void preInsert(HealthInfo entity, PreInsertContext<HealthInfo> context) {
    }

    @Override
    public void preUpdate(HealthInfo entity, PreUpdateContext<HealthInfo> context) {
    }

    @Override
    public void preDelete(HealthInfo entity, PreDeleteContext<HealthInfo> context) {
    }

    @Override
    public void postInsert(HealthInfo entity, PostInsertContext<HealthInfo> context) {
    }

    @Override
    public void postUpdate(HealthInfo entity, PostUpdateContext<HealthInfo> context) {
    }

    @Override
    public void postDelete(HealthInfo entity, PostDeleteContext<HealthInfo> context) {
    }
}