<template>
  <div>
    <el-row :gutter="0">
      <el-col :span="4">
        <div class="card">
              <div class="img">
                <img width="216" height="121" src="https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_1.2395833730697632/c_scale,w_300/ncom/en_US/games/switch/p/persona-5-royal-switch/hero">
              </div>
                <div class="title">Persona 5 Royal—Available now</div>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="card">
          <div class="img">
            <img width="216" height="121" src="https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_1.2395833730697632/c_scale,w_300/ncom/en_US/games/switch/s/splatoon-3-switch/hero">
          </div>
          <div class="title">Splatoon 3—Available now</div>
        </div>
      </el-col>
      <el-col :span="4">
        <div class="card">
          <div class="img">
            <img width="216" height="121" src="https://assets.nintendo.com/image/upload/ar_16:9,b_auto:border,c_lpad/b_white/f_auto/q_auto/dpr_1.2395833730697632/c_scale,w_300/ncom/en_US/games/switch/b/bayonetta-3-switch/hero">
          </div>
          <div class="title">Bayonetta 3—Available now</div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "nintendo"
}
</script>

<style scoped>
  .card {
    height: 220px;
    width: 216px;
    box-shadow: -1px 0px 10px 3px rgba(0, 0, 0, 0.08);
    margin-bottom:15px;
  }
  .title {
    padding: 10px 25px;
    font-weight: 500;
    font-size: 1rem;
  }
</style>
