<template>
  <div>
    <el-container style="height: 100vh">

      <el-aside :width="sideWidth + 'px'">
        <Aside :isCollapsed="isCollapsed" :logoTextShow="logoTextShow"/>
      </el-aside>

      <el-container>

        <el-header>
        <Header :collapseBtnClass="collapseBtnClass" :collapse="collapse"/>
        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "@/components/back/Aside";
import Header from "@/components/back/Header";
export default {
  name: 'HomeView',
  components: {
    Aside,
    Header,
  },
  data() {
    return {
      collapseBtnClass:'el-icon-s-fold',
      isCollapsed:false,
      sideWidth:200,
      logoTextShow:true,
    }
  },
  methods: {
    collapse() {//点击收缩按钮触发
      this.isCollapsed = !this.isCollapsed
      if(this.isCollapsed){
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      }
      else {
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },
  }
}
</script>

<style scoped>
.el-aside {
  box-shadow: 2px 0 6px rgba(0,21,41,35%);
}
.el-header {
  color: #333;
  line-height: 60px;
}

.el-aside {
  background-color: rgb(238, 241, 246);
  height:100%;
  color: #333;
}
.el-menu {
  min-height: 100%;
  overflow: hidden;
}
</style>
