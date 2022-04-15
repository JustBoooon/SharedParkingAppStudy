package cn.edu.heuet.login.constant;

/**
 * 返回各URL地址
 */
public class NetConstant {
    public static final String baseService = "http://51hl498622.zicp.vip:50039";

    //都是短地址，基类地址已经在APP里面设好了
    private static final String getOtpCodeURL     = "/user/getOtp";
    private static final String loginURL          = "/user/login";
    private static final String registerURL       = "/user/register";
    private static final String createItemURL     = "/item/create";
    private static final String getItemListURL    = "/item/list";
    private static final String submitOrderURL    = "/order/createorder";

    private static final String getNewsListURL = "/news/list";
    private static final String getNewsByIdURL = "/news/detail/id?id=";
    private static final String getNewsByTitleURL = "/news/detail/title?title=";
    //添加SharedListURL
    private static final String getSharedListURL = "/shared/list";
    private static final String getSharedByIdURL = "/shared/detail/id?id=";
    private static final String getSharedByCommunityURL = "/shared/detail/community?community=";

    public static String getGetOtpCodeURL() {
        return getOtpCodeURL;
    }

    public static String getLoginURL() {
        return loginURL;
    }

    public static String getRegisterURL() {
        return registerURL;
    }

    public static String getCreateItemURL() {
        return createItemURL;
    }

    public static String getGetItemListURL() {
        return getItemListURL;
    }

    public static String getSubmitOrderURL() {
        return submitOrderURL;
    }

    public static String getNewsListURL() {
        return getNewsListURL;
    }

    public static String getNewsByIdURL() {
        return getNewsByIdURL;
    }

    public static String getNewsByTitleURL() {
        return getNewsByTitleURL;
    }
    //SharedListURL返回方法
    public static String getSharedListURL() {
        return getSharedListURL;
    }

    public static String getSharedByIdURL() {
        return getSharedByIdURL;
    }

    public static String getSharedByCommunityURL() {
        return getSharedByCommunityURL;
    }
}
