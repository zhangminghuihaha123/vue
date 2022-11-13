<template>
    <div style="padding: 100px">
        <el-card>
            <div style="display: flex">
                <div style="width: 300px">
                    <el-image :src="goods.avater" :preview-src-list="[goods.avater]" style="width: 100%"></el-image>
                </div>
                <div style="flex: 1; padding-left: 100px">
                    <div class="item1"><h3>{{goods.title}}</h3></div>
                    <div class="item1" style="color: orangered">价格 ￥ {{goods.id}}</div>
                    <div class="item1" style="margin-top: 10px">
                        <el-input-number v-model="form.num" :min="1" :max="100" label="描述文字"></el-input-number><b style="margin-left: 20px">个</b>
                        <div v-html="goods.test" style="margin-top: 30px"></div>
                    </div>
                    <div class="item1" style="margin-top: 50px">
                        <el-button size="medium" style="background-color: red;color: white" @click="tobuy(goods.title,goods.id*form.num)"><i class="el-icon-wallet"></i>直接购买</el-button>
                        <el-button size="medium" style="background-color: red;color: white" @click="tocar(goods.title,goods.id,goods.id*form.num)"><i class="el-icon-shopping-cart-2"></i>加入购物车</el-button>
                    </div>
                </div>
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
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "MyStore",
        data(){
            return{
               id: this.$route.query.id,
               goods: {},
               form: {
                   num: 1
               },
               user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
               shopcar: {},
               dialogVisible: false,
               trade: ''
            }
        },
        created() {
          this.getGoodsSomeOne();
        },
        mounted() {

        },
        methods: {
            getGoodsSomeOne(){
                this.request.get('/edit/getOne',{params: {
                       id: this.id
                    }}).then(res => {
                        this.goods=res.data;
                })
            },
            tobuy(title,id){
                let time = parseInt(new Date().getTime() / 1000) + '';
                window.open('http://localhost:8080/alipay/pay?subject='+title+'&traceNo='+time+title.charCodeAt()+id+'&totalAmount='+id);
                this.trade=time+title.charCodeAt()+id;
                this.dialogVisible=true;
            },
            tocar(goods,price,total){
                this.shopcar.goods=goods;
                this.shopcar.price=price;
                this.shopcar.total=total;
                this.shopcar.num=this.form.num;
                this.shopcar.user=this.user.username;
                this.request.post('/shop/insert',this.shopcar).then(res=>{
                    if(res.code !== '200'){
                        this.$message.error("位置错误!")
                    }else {
                        this.$message.success("入库成功!");
                        this.$router.push('/front/order?username=' + this.user.username);
                    }
                })
            },
            toSpet(){
                this.request.post('/order/session',this.trade).then(res =>{
                    if(res.code !== '200'){
                        this.$message.error("交易失败!");
                    }else {
                        this.$message.success("交易成功!");
                        this.dialogVisible=false;
                    }
                    this.trade=null;
                })
            }
        }
    }
</script>

<style scoped>
 .item1{
     padding: 10px;
     color: #666;
 }
</style>