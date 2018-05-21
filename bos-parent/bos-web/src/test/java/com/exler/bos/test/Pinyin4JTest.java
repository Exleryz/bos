package com.exler.bos.test;

import com.exler.bos.utils.PinYin4jUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @Auther: Exler
 * @Date: 2018/5/21 15:34
 * @Description:
 */
public class Pinyin4JTest {

    @Test
    public void test1() {
        String province = "河北省";
        String city = "石家庄市";
        String district = "桥西区";
        // 简码
        province = province.substring(0, province.length() - 1);
        city = city.substring(0, city.length() - 1);
        district = district.substring(0, district.length() - 1);
        String info = province + city + district;
        System.out.println(info);
        String[] headByString = PinYin4jUtils.getHeadByString(info);
        String join = StringUtils.join(headByString);
        System.out.println(join);
        // 城市编码
        String cityCode = PinYin4jUtils.hanziToPinyin(city, "");
        System.out.println(cityCode);
    }
}
