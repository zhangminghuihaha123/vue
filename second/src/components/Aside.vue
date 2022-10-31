<template>
    <el-menu :default-openeds="['2']" style="min-height: 100%; overflow-x: hidden"
             background-color="rgb(48,65,86)"
             text-color="#fff"
             active-text-color="#ffd04b"
             :collapse-transition="false"
              router
    >
        <!--激活跳转router,使index可用-->
        <div style="height: 60px; line-height: 60px;text-align: center">
            <img src="../assets/logo.png" style="width: 20px;position: relative;top:5px;margin-right: 15px">
            <span style="color: white;">后台管理系统</span>
        </div>
        <el-menu-item index="/">
            <i class="el-icon-house"></i>
            <span slot="title">主页</span>
        </el-menu-item>
        <el-menu-item index="/people">
            <i class="el-icon-platform-eleme"></i>
            <span slot="title">个人信息</span>
        </el-menu-item>
        <el-submenu index="2">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span slot="title" >系统管理</span>
            </template>
            <el-menu-item index="/user">
                <i class="el-icon-s-custom"></i>
                <span slot="title">用户管理</span>
            </el-menu-item>
            <el-menu-item index="/file">
                <i class="el-icon-document"></i>
                <span slot="title">文件管理</span>
            </el-menu-item>
            <el-menu-item index="/role">
                <i class="el-icon-s-custom"></i>
                <span slot="title">角色管理</span>
            </el-menu-item>
            <el-menu-item index="/time">
                <i class="el-icon-time"></i>
                <span slot="title">打卡管理</span>
            </el-menu-item>
        </el-submenu>
        <el-submenu index="3">
            <template slot="title">
                <i class="el-icon-s-promotion"></i>
                <span slot="title" >前台管理</span>
            </template>
            <el-menu-item index="/editor">
                <i class="el-icon-s-shop"></i>
                <span slot="title">物品录入管理</span>
            </el-menu-item>
        </el-submenu>
        <el-menu-item index="/im">
            <i class="el-icon-phone"></i>
            <span slot="title">聊天室</span>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "Aside"
    }
</script>

<style scoped>

</style>