package com.kg.android.Interface;

/**
 * Created by prasannn on 29-12-2016.
 */

import android.graphics.RectF;
import android.transition.Transition;

public interface  TransitionGenerator {

public com.kg.android.Classes.Transition generateNextTransition(RectF drawableBounds, RectF viewport);

}
