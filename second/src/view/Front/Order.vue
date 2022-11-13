<template>
    <div>
       <div style="margin: 50px" v-for="item in order" :key="item.goods">
          <el-card>
              <div style="display: flex">
                  <div style="padding-left: 50px;display: inline-block">
                      <img :src="item.avater" width="200px" height="200px">
                  </div>
                  <div style="margin-left: 100px">
                      <b style="font-size: 32px" class="item2">{{item.goods}}</b>
                  </div>
                  <div style="margin-left: 500px;display: inline-block;">
                      <b style="color: orangered" class="item2">单价: ￥ {{item.price}} 元</b>
                      <p style="color: #973ffb" class="item2">总花费 ￥ {{item.total}} 元</p>
                      <p style="color: red" class="item2">购买数量:  {{item.num}} 个</p>
                      <p class="item2">订单日期:  {{item.time}}</p>
                  </div>
                  <div class="item1" style="margin-top: 200px;margin-left: 250px">
                      <el-button size="medium" style="background-color: red;color: white" @click="tobuy(item.goods,item.total)"><i class="el-icon-wallet"></i>直接购买</el-button>
                      <el-button size="medium" style="background-color: red;color: white" @click="giveup(item.goods)"><i class="el-icon-shopping-cart-2"></i>放弃</el-button>
                  </div>
              </div>
          </el-card>
       </div>
        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="30%">
            <span>是否完成交易?</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="toSpet">取 消</el-button>
                <el-button type="primary" @click="toSpet">确 定</el-button>
           </span>
        </el-dialog>

    </div>
</template>

<script>
    export default {
        name: "Order",
        data(){
            return{
                username: this.$route.query.username != null ? this.$route.query.username : JSON.parse(localStorage.getItem("user")).username,
                order: [],
                abandon: {},
                dialogVisible: false,
                trade: '',
                goods: ''
            }
        },
        created() {
            this.getUserOrder();
        },
        methods: {
            getUserOrder(){
                this.request.get('/order/get',{params: {
                        username : this.username
                    }}).then(res => {
                        this.order=res.data;
                })
            },
            tobuy(title,id){
                let time = parseInt(new Date().getTime() / 1000) + '';
                this.trade=time+title.charCodeAt()+id;
                this.goods=title;
                window.open('http://localhost:8080/alipay/pay?subject='+title+'&traceNo='+time+title.charCodeAt()+id+'&totalAmount='+id);
                this.dialogVisible=true;
            },
            giveup(goods){
                this.abandon.goods=goods;
                this.abandon.user=this.username;
                this.request.post('/order/delete',this.abandon).then(res =>{
                    if(res.code !== '200'){
                        this.$message.error("发生未知错误!");
                    }else {
                        this.$message.success("删除订单成功!");
                        this.getUserOrder();
                    }
                    this.abandon=null;
                })
            },
            toSpet(){
                this.request.post('/order/session',this.trade).then(res =>{
                    if(res.code !== '200'){
                        this.$message.error("交易失败!");
                    }else {
                        this.$message.success("交易成功!");
                        this.dialogVisible=false;
                        this.giveup(this.goods);
                        this.goods=null;
                    }
                })
            }
        }
    }
</script>

<style scoped>
.item2{
    font-size: 18px;
    margin-top: 30px;
}
</style>