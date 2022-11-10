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
 * @author WJ
 * @since 2022-11-10
 */
@Getter
@Setter
  @ApiModel(value = "Order对象", description = "")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      @ApiModelProperty("购买用户id")
      private Integer userId;

      @ApiModelProperty("购买游戏id")
      private Integer gameId;

      @ApiModelProperty("购买数量")
      private Integer number;


}
