<template>
  <div>
    <div style="display: flex; margin: 20px auto;">
      <div style="position: relative; left: 0">
        商品名：<el-input v-model="condition.name" placeholder="请输入"
              style="margin-right: 3em"></el-input>
        价格：<el-input v-model="condition.minPrice" placeholder="请输入"></el-input> — 
        <el-input v-model="condition.maxPrice" placeholder="请输入"></el-input> 元
        <el-button class="button-search" type="primary" 
            icon="el-icon-search" @click="handleSearch">搜索</el-button>
      </div>
      
      <div style="margin-left: 7em">
        <el-button class="button-add" type="primary" 
        icon="el-icon-plus" v-show="checkPerms()"
              @click="handleInsert">新增商品</el-button>
      </div>
    </div>
    

  <el-table :data="pdts" 
  stripe 
  style="width: 70em;font-size: 16px;" 
  @row-click="handleEdit"
  border
  >
    <el-table-column v-if="false" prop="id" label="ID">
    </el-table-column>
    <el-table-column prop="name" label="商品名称" width="220">
    </el-table-column>
    <el-table-column prop="unitPrice" label="单价" width="220">
    </el-table-column>
    <el-table-column prop="type" label="类别" width="220">
    </el-table-column>
    <el-table-column prop="amount" label="数量" width="220">
    </el-table-column>
    <el-table-column label="操作">
      <el-container v-show="!checkPerms()">
        <el-button type="primary" @click="handleOrder" style="margin-left:4.5em">购买</el-button>
        <!-- <el-button type="primary" @click="handleCheckDetail">查看详情</el-button> -->
      </el-container>
      <el-container v-show="checkPerms()">
        <el-button type="primary" @click="handleUpdate" style="margin-left:2em;">修改</el-button>
        <el-button type="primary" @click="handleDelete" style="margin-left:2em">删除 </el-button>
      </el-container>
    </el-table-column>
  </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :current-page="current"
      :total="total"
      :page-size="size"
      @current-change="handleCurrentChange"
      >
    </el-pagination>

    <FormAdd/>
    <FormUpdate :pdt="pdt"/>
    <FormOrder :pdt="pdt"/>
  </div>
</template>

<script>
import FormUpdate from "@/components/Forms/FormUpdate.vue"
import FormAdd from '@/components/Forms/FormAdd.vue'
import FormOrder from "@/components/Forms/FormOrder.vue"

export default {
  components:{
    FormUpdate,
    FormAdd,
    FormOrder
  },
  data(){
    return{
      pdts:{
        type: Array,
        default: () => []
      },
      total: '',
      condition:{
        type: this.$store.state.types[3].type,
        minPrice: '',
        maxPrice: '',
        name: ''
      },
      current: 1,
      size: 6,

      updateDialogVisible: false,
      pdt:{
        id: '',
        name: '',
        type: '',
        unitPrice: '',
        amount: ''
      }
    }
  },
  mounted(){
    this.getPdtList();
  },
  methods:{
    getPdtList(){
      this.$axios
      .get('/pdts/page',{
        params:{
          type: this.condition.type,
          minPrice: this.condition.minPrice,
          maxPrice: this.condition.maxPrice,
          name: this.condition.name,
          current: this.current,
          size: this.size
        }
      })
      .then(res => res.data)
      .then(data =>{
        console.log(data);
        this.pdts = data.data.records;
        this.current = data.data.current;
        this.size = data.data.size;
        this.total = data.data.total;
      })
    },
    deletePdt(){
      let param = new URLSearchParams()
      param.append('pdtId', pdtId)
      this.$axios({
        method: 'POST',
        url: '/pdts/delete',
        data: param
      })
      .then(res =>{
        console.log(res.data);
        // TODO 功能待测试
      })
    },
    handleSearch(){
      this.getPdtList();
    },
    handleEdit(row){
      // 传递参数至store中的pdt
      this.$store.state.pdt = row;
    },
    handleInsert(){
      // 弹出新增商品表单
      this.$store.commit('InVisible');
    },
    handleOrder(){
      // TODO 弹出购买信息表单以填写购买参数
      this.$store.commit('OdVisible');
    },
    handleUpdate(){
      // TODO 弹出更新表单 传递当前数据
      this.$store.commit('UpVisible');
    },
    handleDelete(){
      // TODO 弹出删除确认窗口
      this.$confirm('此操作将永久删除该商品, 是否继续?', '提示！', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
        .then(() => {
          let param = new URLSearchParams;
          param.append('pdtId', this.$store.state.pdt.id);
          this.$axios({
            method: 'DELETE',
            url: '/pdts/delete',
            data: param
          })
          .then(res =>{
            console.log(res.data);
            if(res.data.success){
                this.$message({
                type: 'success',
                message: '删除成功!'
              });
              // 重新刷新页面
              this.getPdtList();
            }else{
                this.$message({
                  type: 'fail',
                  message: '删除失败!'
                })
            }
          })    
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
    },
    handleCurrentChange(val){
      this.current = val;
      this.getPdtList();
    },
    checkPerms(){
      if(localStorage.getItem('pr_role') == "管理员"){
        return true;
      }else{
        return false;
      }
    }
  },
  
}
</script>

<style scoped>
.el-input{
  width: 150px;
}
.el-pagination{
  position: relative;
  margin-top: 20px;
  width: 100%;
  
}
.button-search{
  margin-left: 50px;
}
</style>