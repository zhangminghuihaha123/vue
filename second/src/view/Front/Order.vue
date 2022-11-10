<template>
    <div>
       <div style="margin-top: 30px;margin: 50px" v-for="item in order" :key="item.goods">
          <el-card style="padding-left: 200px">
                <p>{{item.price}}</p>
                <p>{{item.total}}</p>
                <p>{{item.num}}</p>
                <p>{{item.time}}</p>
                <p>{{item.goods}}</p>
                <img :src="item.avater" width="200px" height="200px">
          </el-card>
       </div>
    </div>
</template>

<script>
    export default {
        name: "Order",
        data(){
            return{
                username: this.$route.query.username != null ? this.$route.query.username : JSON.parse(localStorage.getItem("user")).username,
                order: []
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
            }
        }
    }
</script>

<style scoped>

</style>