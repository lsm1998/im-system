package com.lsm1998.im.imjob.user.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_user")
public class UserEntity extends BaseModel
{
    // user openid
    private String openid;

    // appId
    private String appId;

    // 用户名称
    private String nickName;

    //位置
    private String location;

    //生日
    private String birthDay;

    // 密码
    private transient String password;

    // 头像
    private String avatar;

    // 性别
    private Integer userSex;

    // 个性签名
    private String describe;

    // 加好友验证类型（Friend_AllowType） 1需要验证
    private Integer friendAllowType;

    // 管理员禁止用户添加加好友：0 未禁用 1 已禁用
    private Integer disableAddFriend;

    // 禁用标识(0 未禁用 1 已禁用)
    private Integer forbiddenFlag;

    // 禁言标识
    private Integer silentFlag;

    // 用户类型 1普通用户 2客服 3机器人
    private Integer userType;

    // 扩展信息
    private String extra;
}
