<template>
<div class="whole">
    <el-table 
    class="order-table"
    :data="orders" 
    stripe 
    border
    >
        <el-table-column type="index" :index="getIndex" label="序号" width="120">
        </el-table-column>
        <el-table-column prop="pdtName" label="商品名称">
        </el-table-column>
        <el-table-column prop="amount" label="数量">
        </el-table-column>
        <el-table-column prop="totalMoney" label="总价">
        </el-table-column>
        <el-table-column prop="time" label="购买时间">
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
</div>
  
</template>

<script>
export default {
    data(){
        return{
            orders:{
                type: Array,
                default: () => []
            },
            current: 1,
            size: 6,
            total: ''
        }
    },
    computed:{
        getIndex(index){
            return (this.current-1)*this.size + index + 1;
        }
    },
    mounted(){
        console.log("渲染完成");
        this.getOrderList();
    },
    methods:{
        getOrderList(){
            this.$axios
            .get('/user/orders',{
                params:{
                    current: 1,
                    size: 5,
                    username: localStorage.getItem('pr_username')
                }
            })
            .then(res => res.data)
            .then(data => {
                console.log(data);
                this.orders = data.data.records;
                this.current = data.data.current;
                this.size = data.data.size;
                this.total = data.data.total;
            })
        },
        handleCurrentChange(val){
            this.current = val;
            this.getPdtList();
        },
    }
}
</script>

<style scoped>
.whole{
    height: 36.2em;
}
.order-table{
    font-size: 18px;
    width: 100%;
    margin: 2em 0;
}
</style>