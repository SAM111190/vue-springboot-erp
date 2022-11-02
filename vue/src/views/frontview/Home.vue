<template>
  <div>
    <div class="header">
      <img src="https://img10.360buyimg.com/img/jfs/t1/166380/2/31077/11459/6349238bE44ab127b/b941fb6f627e6059.jpg" style="width: 190px;height: 120px">
    </div>
    <div class="main">
        <el-carousel height="500px" style="margin: 0 auto">
          <el-carousel-item v-for="item in 4" :key="item">
            <h3 class="small">{{ item }}</h3>
          </el-carousel-item>
        </el-carousel>
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
}
</script>

<style scoped>
  .header {
    height: 140px;
    border-bottom:1px solid #ccc;
    padding: 10px 150px 10px 150px;
  }
  .main {
    padding: 15px calc((100vw - 1150px)/2);
    background: url("https://img20.360buyimg.com/babel/jfs/t1/207821/19/27711/462425/635fa26fEc786b736/d737fbc33fdfcd67.png.webp") no-repeat center 0;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
