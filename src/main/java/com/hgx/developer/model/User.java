package com.hgx.developer.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * user实体类
 * @author
 */
@ApiModel(value="user实体类")
@Setter
@Getter
public class User {

	private Integer id;

	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("真实名字")
	private String realName;

	@ApiModelProperty("角色id")
	private Integer roleId;

	@ApiModelProperty("创建时间")
	private java.util.Date createTime;

	@Override
	public String toString() {
		return "User [id=" + id + " , username=" + username + " , password=" + password + " , realName=" + realName + " , roleId=" + roleId + " , createTime=" + createTime + "  ]";
	}
}
