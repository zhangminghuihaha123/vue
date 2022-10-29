<template>
    <div style="background-color: #F7F9FA;padding: 100px;margin-top: -50px;">
        <div style="background-color: white;padding: 50px;width: 1700px;border-radius: 2%">
            <div style="margin-top: -30px;">
                <div style="width: 600px;margin-left: 500px">
                    <img src="../../assets/logo.png" alt="" width="50px;" style="position: absolute;top: 120px;left: 560px">
                        <el-input placeholder="请输入内容" v-model="inputs" class="input-with-select" size="medium">
                            <template slot="prepend">Vue商店搜索</template>
                            <el-button slot="append" icon="el-icon-search"></el-button>
                        </el-input>
                </div>
                <div style="display: flex;margin-top: 30px">
                    <div style="width: 500px;height: 400px;border-radius:20px;background-color: #F7F9FA">
                        <ul style="margin-top: 50px;list-style: none">
                            <li class="ul-li"><i class="el-icon-cold-drink" style="margin-right: 20px"></i><a href="">酒</a> &nbsp;<span>/</span>&nbsp; <a href="">水</a> &nbsp;<span>/</span>&nbsp; <a href="">饮料</a></li>
                            <li class="ul-li"><i class="el-icon-soccer" style="margin-right: 20px"></i><a href="">10~30棒球</a> &nbsp;<span>/</span>&nbsp; <a href="">30~100棒球</a> &nbsp;<span>/</span>&nbsp; <a href="">100以上棒球</a></li>
                            <li class="ul-li"><i class="el-icon-baseball" style="margin-right: 20px"></i><a href="">10~30足球</a> &nbsp;<span>/</span>&nbsp; <a href="">30~100足球</a> &nbsp;<span>/</span>&nbsp; <a href="">100以上棒球</a></li>
                            <li class="ul-li"><i class="el-icon-truck" style="margin-right: 20px"></i><a href="">小轿车</a> &nbsp;<span>/</span>&nbsp; <a href="">大货车</a> &nbsp;<span>/</span>&nbsp; <a href="">卡车</a></li>
                            <li class="ul-li"><i class="el-icon-knife-fork" style="margin-right: 20px"></i><a href="">餐饮</a> &nbsp;<span>/</span>&nbsp; <a href="">小零食</a> &nbsp;<span>/</span>&nbsp; <a href="">烧烤</a></li>
                            <li class="ul-li"><i class="el-icon-water-cup" style="margin-right: 20px"></i><a href="">杯子</a> &nbsp;<span>/</span>&nbsp; <a href="">家用彩电</a> &nbsp;<span>/</span>&nbsp; <a href="">日常用品</a></li>
                        </ul>
                    </div>
                    <el-carousel :interval="4000" height="400px" style="width: 750px;flex: 1">
                        <el-carousel-item v-for="item in imgs" :key="item">
                            <img :src="item"  style="width: 750px;height: 400px">
                        </el-carousel-item>
                    </el-carousel>
                    <div style="width: 500px;height: 400px;border-radius:20px;background-color: #F7F9FA;text-align: center;line-height: 400px">
                        <router-link to="">更多内容下次更新</router-link>
                    </div>
                </div>
            </div>
            <div style="width: 1400px;margin-left: 100px;margin-top: 100px">
                <router-view />
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Carousel",
        created() {
            this.getImg();
        },
        data() {
            return{
                imgs:[],
                inputs: ''
            }
        },
        methods: {
            getImg(){
                this.request.get('/front/getimg').then(res => {
                        this.imgs=res.data;
                })
            }
        }
    }
</script>

<style>
    .el-carousel__item h3 {
        color: #475669;
        font-size: 14px;
        opacity: 0.75;
        line-height: 200px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }

    .ul-li{
        margin-top: 35px;
        margin-left: 50px;
    }

    ul li a{
        text-decoration: none;
    }

</style>