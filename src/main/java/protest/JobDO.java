package protest;

import java.util.Date;

public class JobDO extends Job {
    private long userId;

    private long brandId;

    private int position;

    private String positionName;//为用户手写的职位名称

    private int lowSalary;

    private int highSalary;

    private int location;

    private int experience;

    private int degree;

    private String postRequirement;

    private String postResponsibility;

    private String postDescription;

    private int jobType;

    private int jobStatus;

    private int auditStatus;

    private long lureId;

    private int sort;

    private Date refreshTime;

    private int deleted;

    private int browseTimes;//分享带来的展示数量

    private String unpassReason;

    private Date expireRefreshTime;

    private long customPositionId;

    private String expireDesc;//目前火爆职位用

    private boolean canAudit = true;

    //5.33 增加火爆职位，hot，hotPayStatus 主要用作，火爆职位的有效期状态
    private boolean hot;

    private int hotPayStatus;

    private int expireDays;//有效期天数
}
