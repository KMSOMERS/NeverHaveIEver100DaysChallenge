package uk.co.kmsomers.neverhaveiever;

import junit.framework.Assert;

import org.junit.Test;

import uk.co.kmsomers.neverhaveiever.utils.CommonUtils;

/**
 * Created by kizer on 11/03/2018.
 */

public class CommonUtilsTest {

    @Test
    public void concatenateTest(){
        String[] arr1 = {"1", "2", "3"};
        String[] arr2 = {"4", "5", "6"};
        String[] arrConcat = CommonUtils.concatenate(arr1, arr2);
        Assert.assertEquals("1", arrConcat[0]);
        Assert.assertEquals("2", arrConcat[1]);
        Assert.assertEquals("3", arrConcat[2]);
        Assert.assertEquals("4", arrConcat[3]);
        Assert.assertEquals("5", arrConcat[4]);
        Assert.assertEquals("6", arrConcat[5]);
    }

    @Test
    public void randomiseQuestions(){
        String[] arr1 = {"1","2","3","4","5","6"};
        String[] random = {"1","2","3","4","5","6"};
        CommonUtils.randomiseQuestions(random);
        boolean isRandom = true;
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i].equals(random[i])){
                isRandom = false;
            } else {
                isRandom = true;
                break;
            }
        }
        Assert.assertTrue(isRandom);
    }

    @Test
    public void swapItems(){
        String[] arr1 = {"1", "2"};
        CommonUtils.swapItems(arr1, 0, 1);
        Assert.assertEquals("2", arr1[0]);
        Assert.assertEquals("1", arr1[1]);
    }

}
