<template>
  <div>
    <el-row :gutter="0">
      <el-col :span="4" v-for="item in goods" :key="item.id" v-if="item.type === 3">
        <router-link :to="{path:'/goods_details',query:{index: item.id}}">
          <div style="overflow: hidden;">
            <div class="card" >
              <div class="img">
                <img width="216" height="121" :src="item.imgUrl">
              </div>
              <div class="title">{{item.name}}</div>
            </div>
          </div>
        </router-link>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "nintendo",
  data() {
    return {
      goods:[],
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() //显示后台数据
    {
      request.get("/goods",{
      }).then(res=>{
        this.goods = res.data
      })
    },
  }
}
</script>

<style scoped>
.card {
  height: 180px;
  width: 216px;
  box-shadow: -1px 0px 10px 3px rgba(0, 0, 0, 0.08);
  margin-bottom:15px;
  position: relative;
  overflow: hidden;
}
.card:before {
  padding: 50px 0 5px 0;
  background-color: #1e831e;
  color: #fff;
  font-weight: 600;
  font-size: 0.55rem;
  text-align: center;
  letter-spacing: 0.1em;
  content: "XBox";
  display: block;
  position: absolute;
  width: 79px;
  transform: translate(-50%, -50%) rotate(-45deg);
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
  padding: 10px 25px;
  font-weight: 520;
  font-size: 1rem;
}
</style>
