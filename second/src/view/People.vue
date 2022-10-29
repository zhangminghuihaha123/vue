<template>
        <el-card style="width: 900px;">
            <el-form label-width="100px" size="medium">
                <p v-if="test">名称:{{test}}</p><br><br>
                <el-upload
                        class="avatar-uploader"
                        action="http://localhost:8080/file/upload"
                        :show-file-list="true"
                        :limit="1"
                        :on-success="handleAvatarSuccess"
                >
                    <img v-if="form.avater != null" :src="form.avater" class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>

                <el-form-item label="id">
                    <el-input v-model="form.id" disabled autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="用户名">
                    <el-input v-model="form.username" disabled autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="form.password" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="创建日期">
                    <el-input type="textarea" disabled v-model="form.createTime" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="save">确 定</el-button>
                </el-form-item>
            </el-form>
        </el-card>
</template>

<script>
    export default {
        name: "People",
        created() {
            this.getUserThinga();
        },
        data(){
            return{
                form: {},
                user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
                test: '',
                imgURL: ''
            }
        },
        methods: {
            getUserThinga(){
                this.form=this.request.get('/user/selectone/'+this.user.username).then(res =>{
                    this.form=res;
                })
            },
            handleAvatarSuccess(res,file) {
                this.form.avater = URL.createObjectURL(file.raw);
                this.test=JSON.stringify(file.name);
                this.imgURL=this.form.avater;
            },
            save() {
                this.form.avater=this.test;
                this.request.post('/file/getimg',this.form).then(res => {
                    this.form.avater=this.imgURL;
                    this.$message.success(res.data);
                })
            }
        }
    }
</script>

<style>
    .avatar-uploader {
        text-align: center;
        padding-bottom: 10px;
    }
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 138px;
        height: 138px;
        line-height: 138px;
        text-align: center;
    }
    .avatar {
        width: 138px;
        height: 138px;
        display: block;
    }
</style>