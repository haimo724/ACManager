package org.acmaster.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 验证为空工具类
 * @author 王海涵
 */
public class ValidateUtil {

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && ((String) obj).length() == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).size() == 0) {
            return true;
        }
        return false;
    }

}
