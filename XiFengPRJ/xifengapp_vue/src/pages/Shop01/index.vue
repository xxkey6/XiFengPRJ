<template>
  <div>
    <el-container>
      <!-- 侧边栏 二级菜单 -->
      <el-aside class="side-box">
        <Aside :asideList='asideList'></Aside>
      </el-aside>
      <!-- 二级菜单所对应的页面 -->
      <el-container class="main-box">
        <el-main>
          <router-view></router-view>
        </el-main> 
      </el-container>
    </el-container>
  </div>
</template>
<script>
import Aside from '@/components/Aside.vue'

export default {
  components:{
    Aside
  },
  data(){
    return{
      asideList: this.$store.state.typeList[0]
    }
  },
}
</script>

<style scoped>
.side-box{
  background: #fff;
  width: 100%;
  height: 100%;
  margin-right: -6%;
}
.main-box{
  background: #fff;
  width: 100%;
  height: 100%;
}
</style>

