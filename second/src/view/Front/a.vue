<template>
    <div style="margin-top: -100px">
        <el-row :gutter="10">
            <el-col :span="6" v-for="item in stores" :key="item.id" style="width: 300px;margin-top: 50px;margin-left: 30px">
                <div style="border: 1px solid #ccc;padding: 10px;border-radius: 10px;">
                    <img :src="item.avater" alt="" style="padding-bottom: 10px;width: 260px;height: 280px;cursor: pointer" @click="toStores(item.id)">
                    <div style="color: #666; padding: 5px;cursor: pointer" align="center" @click="toStores(item.id)">
                        <b style="font-size: 24px;">
                            {{item.title}}
                        </b>
                    </div>
                    <div style="color: #666; padding: 5px;font-size: 12px">{{item.time}}</div>
                    <div style="color: orangered; padding: 5px">￥ {{item.id}}元</div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "a",
        data(){
          return {
             stores: []
          }
        },
        created() {
            this.getStores();
        },
        methods: {
            getStores(){
                this.request.get('/edit/getAll').then(res => {
                    this.stores=res.data;
                })
            },
            toStores(itemid){
                this.$router.push('/front/myStore?id=' + itemid);
            }
        }
    }
</script>

<style>

</style>