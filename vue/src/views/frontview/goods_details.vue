<template>
  <div>
    <section id="background" :style="color">
      <div class="show_goods">
        <el-page-header style="padding-left: 50px;padding-top: 30px;font-weight: bold;margin-bottom: 20px;color: #484848;" @back="goBack" :content="goods.name">
        </el-page-header>
        <img class="img" width="656px" height="369px" :src="goods.imgDetail">
        <div class="info">
          <p style="color: #e60012;display: inline;margin-right: 5px">|</p>
          <p class="fac">{{goods.fac}}</p>
          <p class="sold">已售:{{goods.sold}}份</p>
          <p class="name">{{goods.name}}</p>
          <p class="price">￥{{goods.price}} / {{goods.unit}}</p>
          <p class="delivery"><i class="el-icon-truck" style="margin-right: 5px"></i>下单后48小时之内发货，到达上海预计3天</p>
          <el-button class="buy" type="danger" icon="el-icon-shopping-cart-2">购买</el-button>
        </div>

        <!--          清除浮动效果-->
        <div class="clear_float"/>

        <div class="left">
          <div class="long_info">
            {{goods.info}}
          </div>
          <div style="text-align: right">
            <el-popover
                placement="right-end"
                width="400"
                trigger="hover"
            :content="goods.info">
              <el-button slot="reference" type="text">查看简介</el-button>
          </el-popover>
          </div>
        <div class="details">
          <el-row>
            <el-col :span="12" style="margin-bottom: 5px">支持平台：{{goods.platform}}</el-col>
            <el-col :span="12" style="margin-bottom: 5px">游玩人数：{{goods.playernum}}人</el-col>
            <el-col :span="12" style="margin-bottom: 5px">游戏类型：{{goods.gametype}}</el-col>
            <el-col :span="12" style="margin-bottom: 5px">支持语言：{{goods.language}}等</el-col>
            <el-col :span="12" style="margin-bottom: 5px">发售时间：{{goods.date}}</el-col>
            <el-col :span="12" style="margin-bottom: 5px">发行商：{{goods.producer}}</el-col>
          </el-row>
        </div>
      </div>

        <!--          清除浮动效果-->
        <div class="clear_float"/>


      </div>
    </section>
    <section class="crm">
      <div class="type_1">
        <p class="crm_title">类似商品</p>
        <el-row :gutter="0">
          <el-col :span="6" v-for="item in adjgoods.slice(0,4)" :key="item.id">
            <router-link :to="{path:'/goods_details',query:{index: item.id}}" @click.native="flushCom">
            <div class="card">
              <div class="crm_img">
                <img width="260" height="146" :src="item.imgUrl">
              </div>
              <div class="title">{{item.name}}</div>
            </div>
            </router-link>
          </el-col>
        </el-row>
      </div>
      <div class="type_2">
        <p class="crm_title">推荐一起购买</p>
        <el-row :gutter="0">
          <el-col :span="6" v-for="item in correlationgoods.slice(0,4)" :key="item.id">
            <router-link :to="{path:'/goods_details',query:{index: item.id}}" @click.native="flushCom">
              <div class="card">
                <div class="crm_img">
                  <img width="260" height="146" :src="item.imgUrl">
                </div>
                <div class="title">{{item.name}}</div>
              </div>
            </router-link>
          </el-col>
        </el-row>
      </div>
      <div class="type_3">
        <p class="crm_title">猜你喜欢</p>
        <el-row :gutter="0">
          <el-col :span="6" v-for="item in correlationInterest.slice(0,4)" :key="item.id">
            <router-link :to="{path:'/goods_details',query:{index: item.id}}" @click.native="flushCom">
              <div class="card">
                <div class="crm_img">
                  <img width="260" height="146" :src="item.imgUrl">
                </div>
                <div class="title">{{item.name}}</div>
              </div>
            </router-link>
          </el-col>
        </el-row>
      </div>
    </section>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "goods_details",
  data() {
    return {
      color:'background-color:',//背景颜色
      goods:[],//展示商品
      adjgoods:[],//类似商品
      correlationgoods:[],//推荐一起购买
      correlationInterest:[],//猜你喜欢商品
    }
  },
  created() {
      this.load(),
      this.search()
  },
  methods:{
    goBack(){
      this.$router.go(-1)
    },
    load(){
      this.qid=this.$route.query.index
      request.get("/goods/"+this.qid,{
      }).then(res=>{
        this.goods = res.data
        this.color += this.goods.backgroundcolor
      })
    },
    search()
    {
      this.id=this.$route.query.index
      request.get("/goods/adjacent/"+this.id,{
      }).then(res=>{
        this.adjgoods = res
      })
      request.get("/goods/correlation/"+this.id,{
      }).then(res=>{
        this.correlationgoods = res
      })
      request.get("/goods/correlationInterest/"+this.id,{
      }).then(res=>{
        this.correlationInterest = res
      })
    },
    flushCom:function(){
      document.body.scrollTop = 0;
      document.documentElement.scrollTop = 0;
      this.$router.go(0);
    }
  }
}
</script>

<style scoped>
  .clear_float {
    clear: both;
  }
  #background {
    height: 640px;
  }
  .show_goods {
    border-radius: 4px;
    position: relative;
    top: 25px;
    box-shadow: -1px 0px 10px 3px rgba(0, 0, 0, 0.08);
    background-color: #fff;
    height: 650px;
    width: 1240px;
    margin:0 auto;
  }
  .img {
    float: left;
    position: relative;
    left: 50px;
  }
  .info {
    float: right;
    width: 438px;
    position: relative;
    right: 50px;
  }
  .fac {
    display: inline;
    font-weight: 300;
    font-size: 0.9rem;
  }
  .sold {
    text-align: right;
    color: #484848;
    font-weight: 300;
    font-size: 1rem;
  }
  .name {
    margin-top: 40px;
    font-size: 1.75rem;
    font-weight: bold;
    color: #484848;
  }
  .price {
    margin-top: 40px;
    font-size: 1.75rem;
    font-weight: bold;
    color: #484848;
  }
  .delivery {
    margin-top: 40px;
    font-size: 0.8rem;
    font-weight: 300;
    color: #484848;
  }
  .buy {
    width: 100%;
    margin-top: 50px;
    height: 64px;
    color: white;
    font-weight: 700;
    font-size: 1.125rem;
  }
  .left {
    float: left;
    width: 656px;
    margin: 10px 20px 20px 50px;
  }
  .long_info {
    color: #484848;
    font-weight: 500;
    font-size: 1rem;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 2;
    -webkit-box-orient:vertical;
  }
  .details {
    border: 1px solid #cccccc;
    background-color: #e1e1e1;
    height: 90px;
    font-weight: 700;
    font-size: 0.8rem;
    color: #484848;
    padding: 10px 20px 10px 20px;
  }
  .crm {
    margin:60px  auto 20px auto;
    width: 1200px;
  }
  .el-button--danger,
  .el-button--danger:focus,
  .el-button--danger.is-active,
  .el-button--danger:active{
    background: #e60012;
  }
  .el-button--danger:hover {
    background: #ac000d;
    color: #fff;
  }
  .crm_title {
    font-weight: 700;
    font-size: 1rem;
    color: #484848;
    margin-bottom: 10px;
  }
  .card {
    height: 200px;
    width: 260px;
    box-shadow: -1px 0px 10px 3px rgba(0, 0, 0, 0.08);
    margin-bottom:15px;
  }
  .card:hover {
    box-shadow: 0 16px 32px 0 rgba(48, 55, 66, 0.3);/* 鼠标悬浮时盒子出现的阴影 */
    transform: translate(0, -5px);/* 鼠标悬浮时盒子上移10px */
    cursor: pointer;
  }
  .title:hover{
    color:#e60012;
  }
  .title {
    color: #484848;
    padding: 10px 30px;
    font-weight: 520;
    font-size: 1rem;
  }
</style>
