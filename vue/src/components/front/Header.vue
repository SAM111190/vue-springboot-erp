<template>
    <div class="header">
      <div class="operation">
        <span style="float: left"><i class="el-icon-s-shop" style="margin-right: 5px"/>欢迎您</span>
        <ul>
          <li>
            <a style="margin-right:10px ">您好，请登录</a>
            <a style="color: #f92b2b">免费注册</a>
          </li>
          <li class="spacer" >|</li>
          <li>我的购物车</li>
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
    font:12px Microsoft YaHei;
    font-weight: bold;
    color: #5d5d5d;
    padding:0 100px 0 100px;
    background-color:#e3e4e5;
    border-bottom: 1px solid #ccc;
    line-height: 30px;
  }
  .operation {
    height: 30px;
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
