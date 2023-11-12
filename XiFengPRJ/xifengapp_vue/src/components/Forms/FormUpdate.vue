<template>
  <el-dialog title="修改商品" 
  :visible="$store.state.updateFormVisible" 
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
    name: 'FormUpdate',
    methods:{
      handleInvisible(){
        this.$store.commit('UpInvisible');
        this.$store.commit('ClearPdt');
      },
      handleSummit(){
        let param = new URLSearchParams;
        param.append('id', this.$store.state.pdt.id);
        param.append('name', this.$store.state.pdt.name);
        param.append('type', this.$store.state.pdt.type);
        param.append('unitPrice', this.$store.state.pdt.unitPrice);
        param.append('amount', this.$store.state.pdt.amount);
        this.$axios({
          method: 'PUT',
          url: '/pdts/update',
          data: param
        })
        .then(res =>{
          if(res.data.success){
            this.$message({
              type: 'success',
              message: '修改成功!'
            })
          }else{
            this.$message({
              type: 'error',
              message: '修改失败!'
            })
          }
        })
        this.handleInvisible();
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