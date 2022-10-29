<template>
    <div>
        hello============>b
        <el-button type="primary" @click="tos">点击我生辰订单</el-button>
    </div>
</template>

<script>
    export default {
        name: "b",
        methods:{
            tos(){
              let time = parseInt(new Date().getTime() / 1000) + '';
              window.open('http://localhost:8080/alipay/pay?subject='+'手机'+'&traceNo='+time+'手机'+'100'+'&totalAmount=100');
            }
        }
    }
</script>

<style scoped>

</style>