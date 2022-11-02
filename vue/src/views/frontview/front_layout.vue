<template>
  <div>
    <el-container>
<!--    导航栏-->
    <el-header height="30" style="padding: 0">
      <Header></Header>
    </el-header>
<!--主体-->
    <el-main style="padding: 0">
      <router-view></router-view>
    </el-main>
    </el-container>
  </div>
</template>

<script>
import Header from "@/components/front/Header";
export default {
  name: "front_layout",
  components: {
    Header,
  }

}
</script>

<style scoped>

</style>
