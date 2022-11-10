<template>
  <el-menu
      :default-openeds="['2']"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :collapse-transition="false"
      :collapse="isCollapsed"
      router
  >
    <div class="logo">
      <img src="@/assets/logo1.png" alt="" style="width: 80px;position: relative;top: 14px;">
      <b style="color: white;margin-left: 10px" v-show="logoTextShow">后台系统</b>
    </div>
    <el-menu-item index="/">
      <i class="el-icon-house"></i>
      <span slot="title">系统主页</span>
    </el-menu-item>
    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span slot="title">系统管理</span>
      </template>
      <el-menu-item-group>
        <template slot="title">系统功能</template>
        <el-menu-item index="/goods"><i class="el-icon-s-order"></i> 商品管理</el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  props: {
    isCollapsed: Boolean,
    logoTextShow: Boolean,
  }
}
</script>

<style scoped>
.logo {
  height: 60px;
  line-height: 60px;
  text-align: center;
}
</style>
