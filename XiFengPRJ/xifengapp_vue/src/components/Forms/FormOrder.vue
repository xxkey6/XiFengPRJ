<template>
  <el-dialog title="提交商品订单" 
  :visible="$store.state.orderFormVisible" 
  :before-close="handleInvisible"
  append-to-body
  width="30%">
      <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="$store.state.pdt.name"></el-input>
      </el-form-item>
      <el-form-item label="商品类型">
        <el-select v-model="$store.state.pdt.type" placeholder="请选择商品类型">
          <el-option v-for="{index, type} in $store.state.types" :value="type" :key="index"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="商品单价">
        <el-input v-model="$store.state.pdt.unitPrice"></el-input>
      </el-form-item>
      <el-form-item label="商品数量">
        <el-input v-model="$store.state.pdt.amount"></el-input>
      </el-form-item>
      <el-button type="primary" @click="handleInvisible">取消</el-button>
      <el-button type="primary" @click="handleSummit">确定</el-button>
    </el-form>
  </el-dialog>
</template>

<script>

export default {
    name: 'FormOrder',
    data(){
      return{
        username: localStorage.getItem('pr_username')
      }
    },
    methods:{
      handleInvisible(){
          this.$store.commit('OdInvisible');
          this.$store.commit('ClearPdt');
      },
      handleSummit(){
        let param = new URLSearchParams()
        param.append('pdtId', this.$store.state.pdt.id)
        param.append('amount', this.$store.state.pdt.amount)
        param.append('username', this.username)
        this.$axios({
          method: 'POST',
          url: '/shop/summit',
          data: param
        })
        .then(res =>{
          console.log(res.data);
          // TODO 功能待测试
          if(res.data.success){
            this.$message({
              type: 'success',
              message: '购买成功!'
            })
          }else{
            if(res.data.msg == '余额不足!'){
              this.$message({
                type: 'error',
                message: '余额不足!'
              })
            }else{
              this.$message({
                type: 'error',
                message: '购买失败!'
              })
            } 
            
          }
        })
        this.handleInvisible();// 关闭窗口
      },
    }
}
</script>

<style scoped>
.el-form-item{
  width: 250%;
}
.footer-button{
  float: left;
}
.el-input{
  width: 250px;
}
</style>