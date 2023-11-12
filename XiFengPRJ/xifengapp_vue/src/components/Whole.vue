<template>
<div class="wrapper">
    <el-container>
      <el-header class="header">
      
      <!-- 水平一级菜单 -->
      <div>
        <el-menu 
          mode="horizontal"
          text-color="#000000"
          active-text-color="#3989fa"
          :default-active="toIndex"
          @select="handleSelect">
          <el-menu-item v-for="(item, index) in $store.state.headerList" :index="item.path" :key="index">
            <span>{{ item.title }}</span>
          </el-menu-item>
        </el-menu>
      </div>
      
      <div class="header-right">
        <div class="header-user-icon">
          <!-- 用户头像 -->
          <div class="user-avator">
            <img src="@/assets/images/img.jpg"/>
          </div>
          <!-- 用户名下拉菜单 -->
          <el-dropdown class="user-name" trigger="click" @command="handleCommand">
            <span class="el-dropdown-link"> 
              {{ username }} 
              <i class="el-icon-caret-bottom"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="checkDetails">查看个人信息</el-dropdown-item>
              <el-dropdown-item v-show="!checkPerms()" command="checkOrders">查看我的订单</el-dropdown-item>
              <el-dropdown-item command="logout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </el-header>

        <el-main class="main-box">
            <router-view></router-view>
        </el-main>

    </el-container>
    
</div>
</template>

<script>
export default {
    created(){
      if(localStorage.getItem('pr_username') == null){
        this.$router.replace('/login')
      }
    },
    computed:{
      username(){
        return localStorage.getItem("pr_username") || ''
      },
      toIndex(){
        return this.$route.path.split('/')[1];
      }
    },
    methods:{
        handleSelect(path){
            this.$router.push({
                path: path
            })
        },
        // 处理用户名下拉菜单的请求
        handleCommand(command){
            if(command == 'logout'){
              localStorage.removeItem('pr_username')
              localStorage.removeItem('pr_role')
              this.$router.push({
                path: '/login'
              })
              .then(() =>{
                this.$message({
                  type: 'success',
                  message: '登出成功!'
                })
              })
              .catch(() =>{
                this.$message({
                  type: 'error',
                  message: '登出失败!'
                })
              })
            }
            else if(command == 'checkDetails'){
              this.$router.push({
                path: '/user_details'
              })
            }
            else if(command == 'checkOrders'){
              this.$router.push({
                path: '/user_orders'
              })
            }
        },

        checkPerms(){
        if(localStorage.getItem('pr_role') == "管理员"){
          return true;
        }else{
          return false;
        }
    }

    }
}
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 100%;
  background: url("@/assets/images/abd.jpg");
  background-repeat: no-repeat;
  background-position: center;
}
.header {
  position: sticky;
  background: rgb(255, 255, 255);
  opacity: 0.8;
  /* box-sizing: border-box; */
  top: 0;
  left: 0;
  z-index: 99;
  width: 100%;
  height: 100%;
}
.header .logo {
  float: left;
  margin-left: 60px;
  margin-top: 17.5px;
  height: 29px;
  width: 160px;
  vertical-align: middle;
}
/* --------------- 用户头像区域的样式 ---------------- */
.header-right {
  float: right;
  padding-right: 50px;
}
.header-user-icon {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 70px;
}
.user-avator {
  margin-left: 20px; 
}
.user-avator img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.user-name {
  margin-left: 10px;
}
.el-dropdown-link {
  cursor: pointer;
}
.el-dropdown-menu__item {
  text-align: center;
}
/* --------------- 水平一级菜单栏的样式--------------------- */
.el-menu.el-menu--horizontal {
  border-bottom: none !important;
  float: left;
  margin-left: 50px;
  background: transparent;
}
.el-menu--horizontal > .el-menu-item.is-active {
  /* border-bottom: 2px solid #3989fa;
  color: #3989fa; */
  font-weight: bold;
}
.el-menu--horizontal > .el-menu-item {
  font-size: 16px;
  margin: 0 15px;
}

.main-box{
  opacity: 0.8;
}
</style>