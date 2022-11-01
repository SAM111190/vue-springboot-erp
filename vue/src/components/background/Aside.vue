<!-- 侧边栏 -->
<template>
  <el-menu
      style="width:200px;min-height:calc(100vh - 50px);margin-right: 10px;"
      active-text-color="#1260cc"
      background-color="#fff"
      class="el-menu-vertical-demo"
      default-active="user"
      :default-openeds="opens"
      text-color="#000"
      :collapse-transition="false"
      :collapse="isCollapse"
      router>
<!--    <div>-->
<!--      <div>-->
<!--        <el-menu-item>-->
<!--          <span slot="title">输入查询</span>-->
<!--        </el-menu-item>-->
<!--      </div>-->
<!--      <div v-else>-->
<!--        <el-sub-menu :index="item.id ">-->
<!--          <template #title>-->
<!--            <i :class="item.icon"></i>-->
<!--            <span slot="title">{{ item.name }}</span>-->
<!--          </template>-->
<!--          <div  v-for="subItem in item.children" :key="subItem.id">-->
<!--            <el-menu-item :index="subItem.path">-->
<!--              <i :class="subItem.icon"></i>-->
<!--              <span slot="title">{{ subItem.name }}</span>-->
<!--            </el-menu-item>-->
<!--          </div>-->
<!--        </el-sub-menu>-->
<!--      </div>-->
<!--    </div>-->
      <div>
                <el-menu
                    style="width:200px;min-height:calc(100vh - 50px);margin-right: 10px"
                    active-text-color="#1260cc"
                    background-color="#fff"
                    class="el-menu-vertical-demo"
                    default-active="user"
                    :default-openeds="[1]"
                    text-color="#000">
                    <el-sub-menu index="1">
                      <template #title>erp系统管理</template>
                      <el-menu-item index="user" @click="$router.push('/search')">输入产品</el-menu-item>
                      <el-menu-item index="role"  @click="$router.push('/home')">物料生产表</el-menu-item>
                      <el-menu-item index="menu"  @click="$router.push('/about')">mrp结果表</el-menu-item>
                      <el-menu-item index="menu"  @click="$router.push('/zichan2')">资产负债表</el-menu-item>
                    </el-sub-menu>
                  </el-menu>
        </div>
  </el-menu>
</template>

<script>

export default {
  name:"Aside",
  props: {
    isCollapse: Boolean,
    logoTextShow: Boolean,
  },
  data() {
    return {
    }
  },

}
</script>

<style scoped>
</style>
