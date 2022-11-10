<template>
  <div style="text-align: right; font-size: 12px;border-bottom: 1px solid #ccc;display:flex ">
      <div style="flex: 1;font-size: 18px;text-align: left">
        <span :class="collapseBtnClass" style="cursor: pointer;font-size: 20px" @click="collapse"></span>
      </div>
      <span style="font-size: 15px"><b>欢迎您 ADMIN</b></span>
  </div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass:String,
    collapse:Function,
  },
}
</script>

<style scoped>

</style>
