package com.hgx.developer.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * system实体类
 * @author
 */
@ApiModel(value="system实体类")
@Setter
@Getter
public class System {

	private Integer id;

	@ApiModelProperty("系统名字")
	private String systemName;

	@ApiModelProperty("创建时间")
	private java.util.Date createTime;

	@Override
	public String toString() {
		return "System [id=" + id + " , systemName=" + systemName + " , createTime=" + createTime + "  ]";
	}
}
