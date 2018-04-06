package protest;

public class Job {
    //有效开关状态 jobStatus
    public static final int JOB_NORMAL = 0;

    public static final int JOB_OFFLINE = 1;

    public static final int JOB_WILL_OVERDUE = 2;//职位即将过期的状态，此状态是中间状态，不会存数据库

    public static final int JOB_WAIT_OPEN = 3;//待开放


    public static final int[] JOB_STATUS_VALID_ARR = new int[]{0};
    public static final int[] JOB_STATUS_ALL = new int[]{0, 1, 3};

    //删除状态
    public static final int JOB_DELETED = 1;

    //初次提交未审核
    public static final int JOB_AUDIT_CREATE = 0;
    //更新提交未审核
    public static final int JOB_AUDIT_UPDATE = 1;
    //审核未通过
    public static final int JOB_AUDIT_UNPASS = 2;
    //审核通过
    public static final int JOB_AUDIT_PASS = 3;
    //审核通过并推荐
    public static final int JOB_AUDIT_PASS_AND_RECOMMEND = 4;

    //废弃职位
    public static final int JOB_AUDIT_DISCARD = 5;

    public static final int[] AUDIT_STATUS_VALID_ARR = new int[]{0, 1, 3, 4};
    public static final int[] AUDIT_STATUS_ALL = new int[]{0, 1, 2, 3, 4};

    //职位有效期
    public static final int JOB_EXPIRE_DAYS = 60;

    public static final int JOB_51_DAYS = 50;

    public static final int JOB_55_DAYS = 54;

    public static final int JOB_60_DAYS = 59;

    //后来增加大桶小桶，不同有效期
    public static final int JOB_EXPIRE_SMALL_BUCKET_DAYS = 180;

    public static final int JOB_SMALL_BUCKET_171_DAYS = 170;
    public static final int JOB_SMALL_BUCKET_175_DAYS = 174;
    public static final int JOB_SMALL_BUCKET_180_DAYS = 179;

    //5.33火爆职位
    public static final int JOB_EXPIRE_HOT_POSITION_DAYS = 30;
    public static final int JOB_HOT_POSITION_21_DAYS = 20;
    public static final int JOB_HOT_POSITION_25_DAYS = 24;
    public static final int JOB_HOT_POSITION_30_DAYS = 29;

    //职位个数限制
    public static final int JOB_COUNT_LIMIT_UNCERTIFICATION = 3;//未认证 最多2个

    public static final int JOB_COUNT_LIMIT_UNCOMPLETE_COMPANY = 5;//认证未完善公司 主页最大4个

    public static final int JOB_LIMIT_UNCERTIFICATION = 1;//未认证职位限制标识
    public static final int JOB_LIMIT_CERTIFICATION_ING = 2;//提交认证但是还没有审核
    public static final int JOB_LIMIT_UNCOMPLETE_COMPANY = 3;//认证未完善公司标识

    //4.6boss每天发布的新职位个数不能超过
    public static final int JOB_DAILY_PUBLISH_LIMIT = 10;

    //定义职位驳回的原因类型
    public static final int UNPASS_ADMIN = 0;
    public static final int UNPASS_FREEZE = 1;
    public static final int UNPASS_BRAND_REJECT = 2;
    public static final int UNPASS_KICKOFF_COM = 3;

    //定义职位不可编辑Code
    public static final int CANNOT_EDIT_4_TOP_CARD = 1;//由于置顶卡而导致不能编辑职位
    public static final int CANNOT_EDIT_4_BOMB = 2;//由于使用牛人炸弹而导致不能编辑职位

    //定义职位不可编辑原因
    public static final String CANNOT_EDIT_REASON_4_TOP_CARD = "此职位正在使用置顶卡，无法编辑/关闭";
    public static final String CANNOT_EDIT_REASON_4_BOMB = "此职位正在使用牛人炸弹，无法编辑/关闭";
}
