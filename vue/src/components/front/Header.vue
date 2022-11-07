<template>
    <div class="header">
      <span style="float: left">
        <img src="@/assets/logo1.png" style="width: 146px;height: 61px">
      </span>
      <div class="operation">
        <ul>
          <li>
            <a><i class="el-icon-s-goods" style="margin-right: 5px"></i>我的购物单</a>
          </li>
          <li class="spacer" >|</li>
          <li>
            <a><i class="el-icon-star-on" style="margin-right: 5px"></i>我的收藏</a>
          </li>
          <li class="spacer" >|</li>
          <a><i class="el-icon-user-solid" style="margin-right: 5px"></i>我的空间</a>
        </ul>
      </div>
    </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return{
    }
  },
  methods:{
  },
}
</script>

<style scoped>
  .header {
    font:14px Microsoft YaHei;
    font-weight: bold;
    color: #ffffff;
    padding:0 100px 0 100px;
    border-bottom: 1px solid #ccc;
    background-color: #e60012;
    line-height: 52px;
  }
  .operation {
    height: 52px;
    text-align: right;
  }
  .operation ul{
    list-style-type:none;
  }
  .operation li {
    display: inline;
  }
  .spacer {
    padding: 0 10px 0 10px;
  }

</style>
