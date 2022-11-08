package com.example.erp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author JHJ
 * @since 2022-11-07
 */
@Getter
@Setter
  @ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String name;

    private String imgUrl;

    private String fac;

    private String unit;

    private Integer price;

    private String info;

    private Integer type;

    private Integer sold;

    private String backgroundcolor;

    private String platform;

    private Integer playernum;

    private String gametype;

    private String language;

    private String date;

    private String producer;

    private String imgDetail;

}
