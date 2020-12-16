package com.hgx.developer.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * role实体类
 * @author
 */
@ApiModel(value="role实体类")
@Setter
@Getter
public class Role {

	private Integer id;

	@ApiModelProperty("角色名")
	private String roleName;

	@ApiModelProperty("创建时间")
	private java.util.Date createTime;

	@Override
	public String toString() {
		return "Role [id=" + id + " , roleName=" + roleName + " , createTime=" + createTime + "  ]";
	}
}
