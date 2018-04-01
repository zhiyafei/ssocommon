package demo.sso.reg;


import java.util.regex.Pattern;

public class RegUtils {


    // 用户名

    public static RegResult userName(String userName) {

        if (userName.length() >32 || userName.length() < 8) {
            return new RegResult(false,"用户名长度在8和32之间");
        }
        boolean result = Pattern.matches("^[a-zA-Z0-9_-]{8,32}$",userName);
        return new RegResult(result,result?"验证成功":"用户名验证失败，不能有，-等中文字符");

    }

    // url
    public static RegResult url(String url) {

        if (url == null || url.equals("")) {
            return new RegResult(false,"路径不能为空");
        }
        boolean result = Pattern.matches("^((ht|f)tps?):\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-\\.,@?^=%&:\\/~\\+#]*[\\w\\-\\@?^=%&\\/~\\+#])?$",url);
        return new RegResult(result,result?"验证成功":"路径验证失败");

    }
    // 性别
    public static RegResult sex(Integer sex) {

        if (sex == null || sex.equals("")) {
            return new RegResult(false,"性别为空");
        }
        if (sex.equals(0) || sex.equals(1)) {
            return new RegResult(true,"性别验证成功");
        }
        return new RegResult(false,"性别验证失败，未知错误");

    }
    // 用户类型判断
    public static RegResult userTypeId(String userTypeId) {
        if (userTypeId.equals("")) {
            return new RegResult(false,"用户类型验证失败");
        }
        boolean result = Pattern.matches("^\\d{4}$",userTypeId);
        return new RegResult(result,result?"验证成功":"用户类型验证失败");
    }
    //密码
    public static RegResult pwd(String pwd) {

        if (pwd == null || pwd.equals("")) {
            return new RegResult(false,"密码不能为空");
        }
        boolean result = Pattern.matches("[a-zA-Z0-9]{9,26}",pwd);
        return new RegResult(result,result?"验证成功":"密码格式不正确");

    }

    // phone
    public static RegResult phone(String phone) {

        if (phone == null || phone.equals("")) {
            return new RegResult(false,"手机号码不能为空");
        }
        boolean result = Pattern.matches("[0-9]{11}",phone);
        return new RegResult(result,result?"验证成功":"手机号码格式不正确");

    }
    // userId
    public static RegResult userId(String userId) {

        if (userId == null || userId.equals("")) {
            return new RegResult(false,"用户id为空");
        }
        boolean result = Pattern.matches("[0-9]{19}",userId);
        return new RegResult(result,result?"验证成功":"用户id格式不正确");

    }
    // 年份
    public static RegResult createYear(String createYear) {

        if (createYear == null || createYear.equals("")) {
            return new RegResult(false,"创建年份不正确");
        }
        boolean result = Pattern.matches("^(19|20)\\d{2}$",createYear);
        return new RegResult(result,result?"验证成功":"创建年份格式不正确");

    }
    // 月份
    public static RegResult createMonth(String createMonth) {

        if (createMonth == null || createMonth.equals("")) {
            return new RegResult(false,"创建月份不正确");
        }
        boolean result = Pattern.matches("^([1-9]|1[0-2])$",createMonth);
        return new RegResult(result,result?"验证成功":"创建月份格式不正确");

    }
    // 天
    public static RegResult createDay(String createDay) {

        if (createDay == null || createDay.equals("")) {
            return new RegResult(false,"创建当天日期不正确");
        }
        boolean result = Pattern.matches("^((0?[1-9])|((1|2)[0-9])|30|31)$",createDay);
        return new RegResult(result,result?"验证成功":"创建当天日期格式不正确");

    }
}
