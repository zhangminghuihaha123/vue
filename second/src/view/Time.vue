<template>
    <div>
        <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'">
            <el-table-column prop="id" label="ID" width="140" fixed></el-table-column>
            <el-table-column prop="username" label="用户名" width="320"></el-table-column>
            <el-table-column prop="role" label="身份"></el-table-column>
            <el-table-column prop="time" label="最后一次签到时间"></el-table-column>
            <el-table-column label="今天是否签到" align="center">
                <template slot-scope="scope">
                    <el-button v-if="scope.row.isToday == '1'" type="success">
                        今日已签到
                        <i class="el-icon-success"></i>
                    </el-button>
                    <el-button v-else type="danger">
                        今日未签到
                        <i class="el-icon-warning"></i>
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <div style="padding: 10px 0">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[2, 5, 10, 20]"
                    :page-size="100"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>

    </div>
</template>

<script>
    export default {
        name: "File",
        created() {
             this.getTimeForController();
        },
        data() {
            return {
                tableData: [],
                total: 0,
                pageNum: 1,
                pageSize: 2
            }
        },
        methods: {
            getTimeForController(){
                this.request.get('/user/getTimes',{params: {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize
                    }
                }).then(res =>{
                    this.tableData=res.data.data;
                    this.total=res.data.total;
                })
            },
            handleSizeChange(pageSize) {
                this.pageSize = pageSize;
                this.getTimeForController();
            },
            handleCurrentChange(pageNUm) {
                this.pageNum = pageNUm;
                this.getTimeForController();
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