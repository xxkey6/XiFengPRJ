<template>
<div class="whole">
  
    <div :span="12" class="bg-purple">
      <div v-if="!checkPerms()">{{ username }},欢迎光临西风呼呼义卖铺</div>
      <div v-if="checkPerms()">管理员{{ username }}，欢迎登录</div>
    </div>


  <el-container class="header-box">
  <div class="wow slideInLeft" data-wow-offset="10">
    <el-timeline class="timeline">
      <el-timeline-item placement="top">
        <el-card>
          <h4>西风呼呼义卖铺（以下简称义卖铺）是蒙德的公益义卖组织，是从事无偿义卖工作的社会志愿团体，是提瓦特大陆义卖团的成员。</h4>
        </el-card>
      </el-timeline-item>
      <el-timeline-item placement="top">
        <el-card>
          <h4>义卖铺成立于2022年，建铺以后从事精准扶贫、救助难民和各种公益活动，为帮助农户销售商品进行精准扶贫和减轻生活困难人群（如孤儿，无生存能力的老人）的痛苦积极工作，并成为蒙德希望学校主席团成员。义卖铺作为提瓦特大陆义卖团的重要成员，遵守蒙德法律，履行法定职责，为提瓦特大陆的和谐统一贡献自己的力量，义卖铺深入贯彻提瓦特命运共同体思想，发挥其在人道领域的独特作用。</h4>
        </el-card>
      </el-timeline-item>
      <!-- <el-timeline-item placement="top">
        <el-card>
          <h4>义卖铺共有五名主要创始人，已签订与四个国家的往来贸易协定。在此特别鸣谢巴巴托斯，摩拉克斯，巴尔泽布和小吉祥草王对义卖铺的大力支持。</h4>
        </el-card>
      </el-timeline-item> -->
    </el-timeline>
  </div>

  <div class="wow slideInRight" data-wow-offset="10" data-wow-delay="0.5s">
    <el-container class="cards">
          <el-card class="card_back">
            <h4>义卖铺共有五名主要创始人，已签订与四个国家的往来贸易协定。</h4>
            <h4>在此特别鸣谢<br/>
                <span style="color: #58FAD0;">风神巴巴托斯 - </span>
                <span style="color: #DBA901;">岩王帝君摩拉克斯</span><br/>
                <span style="color: #A901DB">雷电将军巴尔泽布 - </span>
                <span style="color: #40FF00;">小吉祥草王布耶尔</span>
                <br/>对义卖铺的大力支持。</h4>
          </el-card>
          <el-card class="card_front">
            <h4>义卖铺共有五名主要创始人，已签订与四个国家的往来贸易协定。</h4>
            <h4>在此特别鸣谢<br/>
                <span style="color: #58FAD0;">风神巴巴托斯 - </span>
                <span style="color: #DBA901;">岩王帝君摩拉克斯</span><br/>
                <span style="color: #A901DB">雷电将军巴尔泽布 - </span>
                <span style="color: #40FF00;">小吉祥草王布耶尔</span>
                <br/>对义卖铺的大力支持。</h4>
          </el-card>
    </el-container>
  </div>

  <!-- <div style="display: block">
    <img src="@/assets/images/咕噜咕噜.jpg" style="height: 50px;width: 200px;"></img>
  </div> -->

  </el-container>

  <div style="height: 80px"></div>
  <el-header style="display: flex;margin: 0.8em 0;">
    <hr class="divider"/>
      <span class="wow bounceIn img-span" data-wow-offset="10">团队风采</span>
    <hr class="divider"/>
  </el-header>
  <el-container class="wow slideInDown" data-wow-offset="10" data-wow-delay="0.5s">
    <div class="swiper-box">
      <el-main>
          <template>
            <el-carousel :interval="2500" type="card" height="400px" indicator-position="outside">
              <el-carousel-item v-for="img in imgs" :key="img.index">
                <el-image :src="img.path"/>
              </el-carousel-item>
            </el-carousel>
          </template>
      </el-main>
    </div>
  </el-container>


</div>
</template>

<script>

export default {
  mounted(){
    new this.$wow.WOW().init()
  },
  data(){
    return {
      imgs:[
        {index: 1, path: require('@/assets/images/swiper_images/天空之琴.jpg')},
        {index: 2, path: require('@/assets/images/swiper_images/提哪里.jpg')},
        {index: 3, path: require('@/assets/images/swiper_images/三金.jpg')},
        {index: 4, path: require('@/assets/images/swiper_images/狼的神乐.jpg')},
        {index: 5, path: require('@/assets/images/swiper_images/十连二草.jpg')},
        {index: 6, path: require('@/assets/images/swiper_images/岩王帝君.jpg')},
        {index: 7, path: require('@/assets/images/swiper_images/屑狐狸.jpg')},
        {index: 8, path: require('@/assets/images/swiper_images/风神.jpg')}
      ],
    }
  },
  computed:{
    username(){
      return localStorage.getItem('pr_username') || '尊贵的匿名用户'
    }
  },
  methods:{
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
.header-box{
  opacity: 0.7;
}
.bg-purple {
  display: block;
  height: 6vw;
  line-height: 6vw;
  font-size: 3vw;
  position: relative;
  font-weight: 700;
  text-shadow:0px 8px 10px#B3C0D1;
  margin-bottom: 1.5em;
}
.timeline{
  margin-left: 60px;
  font-size: 1.2em;
}
.card_back{
  position: relative;
  margin-left: 20%;
  top: 0;
  height: 400px;
  width: 500px;
  opacity: 0.6;
  z-index: 1;
}
.card_front{
  position: relative;
  margin-left: -43%;
  top: 30px;
  height: 400px;
  width: 500px;
  z-index: 2;
}
.swiper-box{
  width: 100%;
  height: 100%;
}
.el-row {
  margin-bottom: 20px;
  height: 6vw;
}
.el-col {
  border-radius: 4px;
  height: 6vw;
  padding: auto;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
    border-radius: 2vw;
}

.el-carousel__item:nth-child(2n) {
    border-radius: 2em;
}
.el-carousel__item:nth-child(2n+1) {
    border-radius: 2em;
}
.row-bg {
padding: 10px 0;
}
/* ul.el-carousel__indicators.el-carousel__indicators--horizontal.el-carousel__indicators--outside {
    line-height: 40px;
} */
.el-header{
  color: #333;
  text-align: center;
  line-height: 60px;
  font-size: 2vw;
  font-weight: 500;
  text-shadow: 0px 5px 10px rgb(200,190,210);
  font-family: "楷体";
  border-radius: 2vw;
}
.el-aside {
  color: #333;
  text-align: center;
}
.el-main {
  color: #333;
  text-align: center;
  border-radius: 2vw;
}
.el-timeline{
  width: 500px;
}
.divider{
  width: 38%;
  height: 4.5px;
  border: rgba(255, 255, 255, 0.692);
  background-color: rgba(255, 255, 255, 0.692);
}
.img-span{
  font-size: 48px;
  color: rgb(255, 255, 255);
  font-family: '隶书';
  margin: 0 0.4em;
}
body > .el-container {
  margin-bottom: 20px;
}
.cards{
  font-size: 24px;
  line-height: 2.2em;
}
</style>