<template>
  <div class="whole">
    <div style="display: flex;">
        <div class="user-image">
            <el-image :src="imgSrc" alt="123456"/>
            <el-button type="text" style="font-size: 16px; ">更换头像</el-button>
        </div>
        

        <el-descriptions class="margin-top"
        direction="vertical" 
        :column="2" 
        border
        >
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-user"></i>用户名
                </template>
                    {{ user.username }}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone"></i>手机号
                </template>
                    {{ user.phoneNumber }}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline"></i>居住地
                </template>
                    {{ user.address }}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets"></i>账户余额
                </template>
                    {{ user.balance }}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-bell"></i>生日
                </template>
                    {{ user.birthday }}
            </el-descriptions-item>
            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-office-building"></i>收货地址
                </template>
                    {{ user.detailAddress }}
            </el-descriptions-item>
        </el-descriptions>
    </div>

    <template>
        <div>
            <el-button type="primary" @click="show = !show">领取优惠券</el-button>

            <div style="display: flex; margin-top: 20px; height: 100px;">
                <transition v-for="coupon in couponList" :key="coupon.index" name="el-fade-in">
                    <div v-show="show" class="transition-box">{{ coupon.text }}</div>
                </transition>
            </div>
        </div>
    </template>
</div>
</template>

<script>
export default {
    data(){
        return{
            user:{
                username: '',
                role: '',
                balance: '',
                address: '四川省雅安市',
                detailAddress: '新康路46号四川🐉业大学',
                phoneNumber:'10086',
                birthday: '2003-1-11'
            },
            couponList:[
                {index: 1, text: '8元优惠券'},
                {index: 2, text: '12元优惠券(仅限\'荣光之风\'商店)'},
                {index: 3, text: '4元优惠券(满20)'},
                {index: 4, text: '神秘优惠券(点击查看)'}
            ],
            show: false,
            imgSrc: require("@/assets/images/img.jpg")
        }
    },
    mounted(){
        this.user.username = localStorage.getItem('pr_username');
        this.user.role = localStorage.getItem('pr_role');
        this.$axios
        .get('/users/one', {
            params: {username: localStorage.getItem('pr_username')}
        })
        .then(res =>{
            console.log(res.data);
            this.user.balance = res.data.data.balance;
        })
    }
}
</script>

<style>
.whole{
    margin-top: 5%;
    height: 34em;
}
.transition-box {
    margin-bottom: 10px;
    width: 200px;
    height: 100px;
    border-radius: 4px;
    background-color: #07a4dd;
    text-align: center;
    color: #fff;
    padding: 40px 20px;
    box-sizing: border-box;
    margin-right: 20px;
}
.margin-top{
    font-size: 1.2em;
    width: 60%;
}
.user-image{
    margin-right: 10%;
    margin-left: 5%;
    text-align: center;
}
.user-image .el-image {
  display: block;
  width: 300px;
  height: 300px;
  border-radius: 50%;
}
</style>