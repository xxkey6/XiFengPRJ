<template>
    <!-- 侧导航栏 -->
    <div class="sidebar">
        <el-menu
        class="sidebar-el-menu"
        :default-active="toIndex"
        background-color="#fff"
        text-color="#000000"
        router>
        <el-menu-item v-for="(item, index) in asideList" :key="index" :index="item.path">
            <!-- 需要图标的在 item 对象中加上属性 icon -->
            <!-- <i :class="item.icon"></i> -->
            <span slot="title">{{ item.title }}</span>
        </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
export default {
    name: 'Aside',
    computed:{
      toIndex(){
        return this.$route.path.split('/')[2]
      }
    },
    props:{
      asideList:{
        type: Array,
        default: () => []
      }
    },
  
}
</script>

<style scoped>
.sidebar {
  display: block;
  position: absolute;
  background-color: #fff;
  left: 0;
  top: 9%;
  bottom: 0;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  /* 侧边栏的滑动条删除 */
  width: 0;
}
.sidebar-el-menu {
  width: 220px;
}
/* 左侧二级菜单项的样式 */
.el-menu-item{
  font-size: 18px !important;
  padding-left: 35px !important;
}

/* 左侧二级菜单选中时的样式 */
.el-menu-item.is-active {
  color: white !important;
  background: #4ca0e4 !important;
}
.el-menu-item, .el-submenu__title {
  height: 60px !important;
  line-height: 50px !important;
}
</style>