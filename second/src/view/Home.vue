<template>
    <div>
        主页!
        <el-card style="margin-top: 30px">
          <div style="width: 300px; height: 300px; border-radius: 50%;background-color: #1E90FF;font-size: 42px;color: white;
          line-height: 300px;text-align: center; cursor: pointer;box-shadow: 0 0 30px rgba(0,0,0, .2)">
              <p @click="daka">打卡</p>
          </div>
            <div v-if="this.province != null">{{province}} {{city}}</div>
        </el-card>
    </div>
</template>

<script type="text/javascript" src="https://api.map.baidu.com/api?v=1.0&type=webgl&ak=ns2haiFU7m2gny12BAFH8pjnWLmvxyUG"></script>

<script>
    export default {
        name: "Home",
        data(){
          return{
            province: sessionStorage.getItem("province"),
            city: sessionStorage.getItem("city"),
            user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
          }
        },
        created() {

        },
        methods: {
            daka(){
                this.request.post('/time/times',this.user.username).then(res => {
                    if(res.code !== '200'){
                        this.$message.error(res.msg);
                    }else {
                        this.$message.success(res.data);
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>