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
public class HeartRateListener implements EntityListener<HeartRate> {

    @Override
    public void preInsert(HeartRate entity, PreInsertContext<HeartRate> context) {
    }

    @Override
    public void preUpdate(HeartRate entity, PreUpdateContext<HeartRate> context) {
    }

    @Override
    public void preDelete(HeartRate entity, PreDeleteContext<HeartRate> context) {
    }

    @Override
    public void postInsert(HeartRate entity, PostInsertContext<HeartRate> context) {
    }

    @Override
    public void postUpdate(HeartRate entity, PostUpdateContext<HeartRate> context) {
    }

    @Override
    public void postDelete(HeartRate entity, PostDeleteContext<HeartRate> context) {
    }
}