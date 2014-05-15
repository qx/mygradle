package com.cfz.android.utils.net;

import org.junit.Test;

import static com.cfz.android.visual.activity.NewProductFragment.performGetNewProduct;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Administrator on 2014/5/15.
 */
public class NewProductFragmentTester {
    @Test
    public void testperformGetNewProduct() {
//            assertThat(ToStringBuilder.reflectionToString(getData2MapFromNet(), ToStringStyle.DEFAULT_STYLE), equalTo(null));
            try {
                assertThat(performGetNewProduct().toString(), equalTo(null));
            } catch (Exception e) {
                e.printStackTrace();
            }
//        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));

        }
}
