<template>
  <div class="login-wrap">
    <div class="ms-login">
      <div class="ms-title">欢迎登录</div>
      <el-form ref="login" label-width="0px" class="ms-content">
        <el-form-item>
          <el-input v-model="user.username" placeholder="输入用户名">
            <el-button slot="prepend" icon="el-icon-user"></el-button>
          </el-input>
        </el-form-item>
        <el-form-item style="margin-top: 25px">
          <el-input type="password" placeholder="登录密码" v-model="user.password">
            <el-button slot="prepend" icon="el-icon-lock"></el-button>
          </el-input>
        </el-form-item>
        <el-radio-group v-model="user.role">
          <el-radio-button class="role-btn" label="普通用户"></el-radio-button>
          <el-radio-button class="role-btn" label="管理员"></el-radio-button>
        </el-radio-group>
        <div class="login-btn">
          <el-button type="primary" @click="onLogin()">登录</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>

export default {
    name: 'Login',
    data(){
      return{
        user:{
          username: '',
          password: '',
          role: ''
        }
      }
      
    },
    methods:{
      onLogin(){
        // this.$axios
        // .post('/users/login', this.user)   该传参方法会导致字符集出错（源码自动修改）
        let param = new URLSearchParams()
        param.append('username', this.user.username)
        param.append('password', this.user.password)
        param.append('role', this.user.role)
        this.$axios({
            method: 'POST',
            url: '/users/login',
            data: param
        })
        .then(res =>{
          console.log(res.data);
          if(!res.data.success){
            // 登录失败 弹出报错信息
            alert(res.data.msg);
          }else{
            // 登录成功 存储用户信息 并且跳转到首页
            // this.$store.state.user = this.user;
            localStorage.setItem('pr_username', res.data.data.username);
            localStorage.setItem('pr_role', res.data.data.role);
            this.$router.push({
              path: '/'
            })
          }
        })
        
      }
    }
    
}
</script>

<style>
.login-wrap {
  position: absolute;
  width: 100%;
  height: 100%;
  background: url('../assets/images/login-background.jpg');
  background-repeat: no-repeat;
  background-position: center;
}
.ms-title {
  width: 100%;
  text-align: center;
  font-size: 22px;
  margin: 25px 0px 15px;
}
.ms-login {
  position: relative;
  width: 450px;
  height: 335px;
  max-width: 90%;
  margin: 275px auto;
  border-radius: 5px;
  background: white;
  overflow: hidden;
  opacity: 0.85;
}
.ms-content {
  padding: 10px 20px;
}
.login-btn {
  margin-top: 5%;
}
.login-btn button {
  width: 100%;
  height: 36px;
  text-align: center;
  margin-bottom: 10px;
}
</style>