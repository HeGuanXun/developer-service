package com.hgx.developer.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * dictionary实体类
 * @author
 */
@ApiModel(value="dictionary实体类")
@Setter
@Getter
public class Dictionary {

	private Integer id;

	@ApiModelProperty("父节点id")
	private Integer parentId;

	@ApiModelProperty("层级")
	private Integer level;

	@ApiModelProperty("编码")
	private String code;

	@ApiModelProperty("描述信息")
	private String description;

	@ApiModelProperty("排序")
	private Integer sort;

	@ApiModelProperty("键")
	private String key;

	@ApiModelProperty("值")
	private String value;

	@ApiModelProperty("创建人")
	private Long createBy;

	@ApiModelProperty("创建时间")
	private java.util.Date createTime;

	@ApiModelProperty("更新人")
	private Long updateBy;

	@ApiModelProperty("更新时间")
	private java.util.Date updateTime;

	@Override
	public String toString() {
		return "Dictionary [id=" + id + " , parentId=" + parentId + " , level=" + level + " , code=" + code + " , description=" + description + " , sort=" + sort + " , key=" + key + " , value=" + value + " , createBy=" + createBy + " , createTime=" + createTime + " , updateBy=" + updateBy + " , updateTime=" + updateTime + "  ]";
	}
}
